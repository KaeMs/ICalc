package com.gmg.icalc;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import com.gmg.icalc.CustomViews.CustomFontButton;
import com.gmg.icalc.CustomViews.CustomFontEditText;
import com.gmg.icalc.utils.CalculateUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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

    String additionalInfo = "";
    private final int ADDITIONAL_INFO_REQ_CODE = 1001;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        categorySpinnerAdapter = new CalculateSpinnerAdapter(this, R.layout.spinner_calculate_view, getCategory());
        categorySpinner.setAdapter(categorySpinnerAdapter);
        insuranceTypeSpinnerAdapter = new CalculateSpinnerAdapter(this, R.layout.spinner_calculate_view, getRegion());
        insuranceTypeSpinner.setAdapter(insuranceTypeSpinnerAdapter);
        vehicleYearSpinnerAdapter = new CalculateSpinnerAdapter(this, R.layout.spinner_calculate_view, getVehicleYear());
        vehicleYearSpinner.setAdapter(vehicleYearSpinnerAdapter);
        regionSpinnerAdapter = new CalculateSpinnerAdapter(this, R.layout.spinner_calculate_view, getRegion());
        regionSpinner.setAdapter(regionSpinnerAdapter);

        addititionalOptsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CalculateActivity.this, CalculateAdditionalInfoActivity.class);
                startActivityForResult(intent, ADDITIONAL_INFO_REQ_CODE);
            }
        });

        calculatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent = new Intent(CalculateActivity.this, CalculateResultActivity.class);
                intent.putExtra(CalculateUtils.CALCULATION_RESULT_INTENT,
                                CalculateUtils.calculate(vehiclePriceET.getText().toString(),
                                CalculateUtils.OTOMATE, additionalInfo));
                startActivity(intent);*/
                Toast.makeText(CalculateActivity.this, CalculateUtils.calculate(vehiclePriceET.getText().toString(),
                        CalculateUtils.OTOMATE, additionalInfo), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADDITIONAL_INFO_REQ_CODE) {
            if (resultCode == RESULT_OK) {
                additionalInfo = data.getStringExtra(CalculateUtils.ADDITIONAL_INFO_INTENT);
            }
        }
    }

    private List<CalculateModel> getCategory() {
        List<CalculateModel> returnCategory = new ArrayList<>();

        returnCategory.add(new CalculateModel("0", getString(R.string.non_truck)));
        returnCategory.add(new CalculateModel("1", getString(R.string.truck_pickup_box)));
        returnCategory.add(new CalculateModel("2", getString(R.string.bus)));

        return returnCategory;
    }

    private List<CalculateModel> getRegion() {
        List<CalculateModel> returnRegion = new ArrayList<>();

        returnRegion.add(new CalculateModel("0", getString(R.string.otomate)));
        returnRegion.add(new CalculateModel("1", getString(R.string.comprehensive)));
        returnRegion.add(new CalculateModel("2", getString(R.string.total_lost_only)));

        return returnRegion;
    }

    private List<CalculateModel> getVehicleYear() {
        List<CalculateModel> returnVehicleYear = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();

        for (int i = 0; i < 8; i++) {
            calendar.add(Calendar.YEAR, i);
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
