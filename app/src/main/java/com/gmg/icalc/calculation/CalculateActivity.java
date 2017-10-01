package com.gmg.icalc.calculation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import com.gmg.icalc.BaseActivity;
import com.gmg.icalc.CustomViews.CustomFontButton;
import com.gmg.icalc.CustomViews.CustomFontEditText;
import com.gmg.icalc.R;
import com.gmg.icalc.utils.CalculateUtils;
import com.google.gson.Gson;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;

/**
 * Created by KM on 8/15/2017. IC
 */

public class CalculateActivity extends BaseActivity {

    @BindView(R.id.calculate_vehicle_price)
    CustomFontEditText vehiclePriceET;
    @BindView(R.id.calculate_vehicle_category_spinner)
    Spinner categorySpinner;
    CalculateSpinnerAdapter categorySpinnerAdapter;
    @BindView(R.id.calculate_insurance_type_spinner)
    Spinner insuranceTypeSpinner;
    CalculateSpinnerAdapter insuranceTypeSpinnerAdapter;
    @BindView(R.id.calculate_vehicle_year_spinner)
    Spinner vehicleYearSpinner;
    CalculateSpinnerAdapter vehicleYearSpinnerAdapter;
    @BindView(R.id.calculate_region_spinner)
    Spinner regionSpinner;
    CalculateSpinnerAdapter regionSpinnerAdapter;
    @BindView(R.id.calculate_add_opts_btn)
    CustomFontButton addititionalOptsBtn;
    @BindView(R.id.calculate_calculate_btn)
    CustomFontButton calculatebtn;

    private CalculateAddOptComprehensiveModel calculateAddOptComprehensiveModel;

    private final int ADDITIONAL_INFO_REQ_CODE = 1001;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        categorySpinnerAdapter = new CalculateSpinnerAdapter(this, R.layout.spinner_calculate_view, getCategory());
        categorySpinner.setAdapter(categorySpinnerAdapter);
        insuranceTypeSpinnerAdapter = new CalculateSpinnerAdapter(this, R.layout.spinner_calculate_view, getType());
        insuranceTypeSpinner.setAdapter(insuranceTypeSpinnerAdapter);
        vehicleYearSpinnerAdapter = new CalculateSpinnerAdapter(this, R.layout.spinner_calculate_view, getVehicleYear());
        vehicleYearSpinner.setAdapter(vehicleYearSpinnerAdapter);
        regionSpinnerAdapter = new CalculateSpinnerAdapter(this, R.layout.spinner_calculate_view, getArea());
        regionSpinner.setAdapter(regionSpinnerAdapter);

        calculateAddOptComprehensiveModel = new CalculateAddOptComprehensiveModel();

        addititionalOptsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (insuranceTypeSpinner.getSelectedItemPosition() == 1){
                    Intent intent = new Intent(CalculateActivity.this, CalculateAdditionalOptionsComprehensiveActivity.class);
                    Gson gson = new Gson();
                    intent.putExtra(CalculateUtils.ADDITIONAL_INFO_INTENT, gson.toJson(calculateAddOptComprehensiveModel));
                    startActivityForResult(intent, ADDITIONAL_INFO_REQ_CODE);
                } else if (insuranceTypeSpinner.getSelectedItemPosition() == 2){

                } else {
                    Toast.makeText(CalculateActivity.this, getString(R.string.otomate_no_add_opt), Toast.LENGTH_SHORT).show();
                }
            }
        });

        calculatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(vehiclePriceET.getText().toString())){
                    Toast.makeText(CalculateActivity.this, getString(R.string.vehicle_price_missing), Toast.LENGTH_SHORT).show();
                    return;
                }

                CalculateResultModel calculateResultModel = new CalculateResultModel();
                calculateResultModel.setVehiclePrice(CalculateUtils.stringToDouble(vehiclePriceET.getText().toString()));
                calculateResultModel.setVehicleType(categorySpinnerAdapter.getItem(categorySpinner.getSelectedItemPosition()).getName());
                calculateResultModel.setInsuranceType(insuranceTypeSpinnerAdapter.getItem(insuranceTypeSpinner.getSelectedItemPosition()).getName());
                double premi = CalculateUtils.calculate(vehiclePriceET.getText().toString(),
                        CalculateUtils.OTOMATE, calculateAddOptComprehensiveModel);
                calculateResultModel.setPremi(premi);

                Gson gson = new Gson();
                String calcResExtra = gson.toJson(calculateResultModel);

                Intent intent = new Intent(CalculateActivity.this, CalculateResultActivity.class);
                intent.putExtra(CalculateResultModel.CALC_RESULT_EXTRA, calcResExtra);
                startActivity(intent);
            }
        });

        vehiclePriceET.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                vehiclePriceET.removeTextChangedListener(this);
                if (s.length() > 0) {
                    String editedStr = String.format(Locale.GERMAN, "%,d", new BigInteger(vehiclePriceET.getText().toString().replaceAll("\\.", "").replaceAll(",", "")));
                    vehiclePriceET.setText(editedStr);
                }
                vehiclePriceET.setSelection(vehiclePriceET.getText().length());
                vehiclePriceET.addTextChangedListener(this);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADDITIONAL_INFO_REQ_CODE) {
            if (resultCode == RESULT_OK) {
                Gson gson = new Gson();
                calculateAddOptComprehensiveModel = gson.fromJson(data.getStringExtra(CalculateUtils.ADDITIONAL_INFO_INTENT), CalculateAddOptComprehensiveModel.class);
            }
        }
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.translate_bottom_to_start, R.anim.translate_start_to_down);
    }

    private List<CalculateModel> getCategory() {
        List<CalculateModel> returnCategory = new ArrayList<>();

        returnCategory.add(new CalculateModel("0", getString(R.string.non_truck)));
        returnCategory.add(new CalculateModel("1", getString(R.string.truck_pickup_box)));
        returnCategory.add(new CalculateModel("2", getString(R.string.bus)));

        return returnCategory;
    }

    private List<CalculateModel> getType() {
        List<CalculateModel> returnRegion = new ArrayList<>();

        returnRegion.add(new CalculateModel("0", getString(R.string.otomate)));
//        returnRegion.add(new CalculateModel("1", getString(R.string.comprehensive)));
//        returnRegion.add(new CalculateModel("2", getString(R.string.total_lost_only)));

        return returnRegion;
    }

    private List<CalculateModel> getVehicleYear() {
        List<CalculateModel> returnVehicleYear = new ArrayList<>();


        for (int i = 0; i < 8; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.YEAR, -i);
            returnVehicleYear.add(new CalculateModel(String.valueOf(i), String.valueOf(calendar.get(Calendar.YEAR))));
        }

        return returnVehicleYear;
    }

    private List<CalculateModel> getArea() {
        List<CalculateModel> returnInsType = new ArrayList<>();

        returnInsType.add(new CalculateModel("0", getString(R.string.area_1)));
        returnInsType.add(new CalculateModel("1", getString(R.string.area_2)));
        returnInsType.add(new CalculateModel("2", getString(R.string.area_3)));

        return returnInsType;
    }
}
