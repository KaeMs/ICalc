package com.gmg.icalc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.gmg.icalc.CustomViews.CustomFontTextView;

import butterknife.BindView;

/**
 * Created by KM on 10/20/2017. IC
 */

public class BaseMenuFragment extends BaseFragment {
    @BindView(R.id.base_menu_fragment_background)
    public ImageView background;
    @BindView(R.id.base_menu_fragment_title)
    public CustomFontTextView title;
    @BindView(R.id.base_menu_fragment_message)
    public CustomFontTextView message;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.base_menu_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}
