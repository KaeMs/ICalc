package com.gmg.icalc;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;

import com.gmg.icalc.CustomViews.CustomFontTextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin Murvie on 8/21/2017. IC
 */
public class CalculateSpinnerAdapter extends ArrayAdapter<CalculateModel> implements SpinnerAdapter {

    private List<CalculateModel> mDataset = new ArrayList<>();
    private Context context;
    private String itemToShow;

    public CalculateSpinnerAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
        this.context = context;
    }

    public CalculateSpinnerAdapter(@NonNull Context context, @LayoutRes int resource, List<CalculateModel> calculateModels) {
        super(context, resource, calculateModels);
        this.context = context;
    }

    public void addList(List<CalculateModel> dataset) {
        this.mDataset.addAll(dataset);
        notifyDataSetChanged();
    }

    public void changeList(List<CalculateModel> dataset) {
        this.mDataset.clear();
        this.mDataset.addAll(dataset);
        notifyDataSetChanged();
    }

    @Override
    public void clear() {
        if (this.mDataset.size() > 0) {
            this.mDataset.clear();
            notifyDataSetChanged();
        }
    }

    @Override
    public int getCount() {
        return mDataset.size();
    }

    @Override
    public CalculateModel getItem(int position) {
        return mDataset.get(position);
    }

    @Override
    public View getDropDownView(int position, View convertView,
                                @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.spinner_calculate_dropdownview, parent, false);
        }

        View divider = convertView.findViewById(R.id.calculate_dropdownview_divider);
        if (position + 1 < mDataset.size()) {
            divider.setVisibility(View.VISIBLE);
        } else {
            divider.setVisibility(View.GONE);
        }
        CustomFontTextView dropdownTxt = convertView.findViewById(R.id.calculate_dropdownview_text);
        dropdownTxt.setText(mDataset.get(position).getName());

        return convertView;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.spinner_calculate_view, parent, false);
        }

        CustomFontTextView selectedTxt = convertView.findViewById(R.id.calculate_view_selectedTxt);
        selectedTxt.setText(mDataset.get(position).getName());

        return convertView;
    }
}
