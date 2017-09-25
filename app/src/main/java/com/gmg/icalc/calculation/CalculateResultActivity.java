package com.gmg.icalc.calculation;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.gmg.icalc.BaseActivity;
import com.gmg.icalc.CustomViews.CustomFontTextView;
import com.gmg.icalc.R;
import com.google.gson.Gson;

import butterknife.BindView;

/**
 * Created by KM on 8/21/2017. IC
 */

public class CalculateResultActivity extends BaseActivity {

    @BindView(R.id.calculate_result_vehicle_type)
    CustomFontTextView vehicleType;
    @BindView(R.id.calculate_result_total_premi)
    CustomFontTextView premi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_result);

        String calcResExtra = getIntent().getStringExtra(CalculateResultModel.CALC_RESULT_EXTRA);
        CalculateResultModel calculateResultModel = new Gson().fromJson(calcResExtra, CalculateResultModel.class);

        vehicleType.setText(calculateResultModel.getVehicleType());
        premi.setText(getString(R.string.premi_colon, calculateResultModel.getPremi()));
    }
}
