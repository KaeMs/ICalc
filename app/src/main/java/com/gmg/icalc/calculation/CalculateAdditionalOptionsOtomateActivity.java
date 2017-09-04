package com.gmg.icalc.calculation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.gmg.icalc.BaseActivity;
import com.gmg.icalc.CustomViews.CustomFontButton;
import com.gmg.icalc.CustomViews.CustomFontCheckBox;
import com.gmg.icalc.CustomViews.CustomFontRadioButton;
import com.gmg.icalc.R;
import com.gmg.icalc.utils.CalculateUtils;
import com.google.gson.Gson;

import butterknife.BindView;

/**
 * Created by KM on 8/21/2017. IC
 */

public class CalculateAdditionalOptionsOtomateActivity extends BaseActivity {

    @BindView(R.id.additional_options_flood)
    CustomFontCheckBox floodQuake;

    // Third Party
    @BindView(R.id.additional_options_tp_CB)
    CustomFontCheckBox tpCB;

    // Third Party
    @BindView(R.id.additional_options_pa_CB)
    CustomFontCheckBox paCB;

    @BindView(R.id.additional_options_confirm)
    CustomFontButton confirmBtn;
    Gson gson;

    private CalculateAddOptOtomateModel calculateAddOptOtomateModel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additional_options_comprehensive);

        gson = new Gson();
        String addOptModelStr = getIntent().getStringExtra(CalculateUtils.ADDITIONAL_INFO_INTENT);
        calculateAddOptOtomateModel = gson.fromJson(addOptModelStr, CalculateAddOptOtomateModel.class);

        if (calculateAddOptOtomateModel == null){
            calculateAddOptOtomateModel = new CalculateAddOptOtomateModel();
        }

        floodQuake.setChecked(calculateAddOptOtomateModel.isFloodQuake());
        // Third Party
        tpCB.setChecked(calculateAddOptOtomateModel.isTp());
        // Personal Accident
        paCB.setChecked(calculateAddOptOtomateModel.isPa());

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                String returnAddOptModelStr = gson.toJson(calculateAddOptOtomateModel);
                intent.putExtra(CalculateUtils.ADDITIONAL_INFO_INTENT, returnAddOptModelStr);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    private void modelSet(){
        calculateAddOptOtomateModel.setFloodQuake(floodQuake.isChecked());
        String tp = "";

    }
}
