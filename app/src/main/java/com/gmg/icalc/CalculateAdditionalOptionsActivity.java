package com.gmg.icalc;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.gmg.icalc.CustomViews.CustomFontButton;
import com.gmg.icalc.CustomViews.CustomFontCheckBox;
import com.gmg.icalc.utils.CalculateUtils;
import com.google.gson.Gson;

import butterknife.BindView;

/**
 * Created by KM on 8/21/2017. IC
 */

public class CalculateAdditionalOptionsActivity extends BaseActivity {

    @BindView(R.id.additional_options_tsfwd)
    CustomFontCheckBox tsfwdCB;
    @BindView(R.id.additional_options_eqvet)
    CustomFontCheckBox eqvetCB;
    @BindView(R.id.additional_options_srcc)
    CustomFontCheckBox srccCB;
    @BindView(R.id.additional_options_ts)
    CustomFontCheckBox tsCB;

    @BindView(R.id.additional_options_confirm)
    CustomFontButton confirmBtn;
    Gson gson;

    private CalculateAddOptionsModel calculateAddOptionsModel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additional_options);

        gson = new Gson();
        String addOptModelStr = getIntent().getStringExtra(CalculateUtils.ADDITIONAL_INFO_INTENT);
        calculateAddOptionsModel = gson.fromJson(addOptModelStr, CalculateAddOptionsModel.class);

        tsfwdCB.setSelected(calculateAddOptionsModel.isTSFWD());
        eqvetCB.setSelected(calculateAddOptionsModel.isEQVET());
        srccCB.setSelected(calculateAddOptionsModel.isSRCC());
        tsCB.setSelected(calculateAddOptionsModel.isTS());

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                String returnAddOptModelStr = gson.toJson(calculateAddOptionsModel);
                intent.putExtra(CalculateUtils.ADDITIONAL_INFO_INTENT, returnAddOptModelStr);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
