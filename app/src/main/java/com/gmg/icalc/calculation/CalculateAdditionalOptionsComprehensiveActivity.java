package com.gmg.icalc.calculation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.gmg.icalc.BaseActivity;
import com.gmg.icalc.CustomViews.CustomFontButton;
import com.gmg.icalc.CustomViews.CustomFontRadioButton;
import com.gmg.icalc.R;
import com.gmg.icalc.utils.CalculateUtils;
import com.google.gson.Gson;

import butterknife.BindView;

/**
 * Created by KM on 8/21/2017. IC
 */

public class CalculateAdditionalOptionsComprehensiveActivity extends BaseActivity {

    @BindView(R.id.additional_options_tsfwd)
    CustomFontRadioButton tsfwdCB;
    @BindView(R.id.additional_options_eqvet)
    CustomFontRadioButton eqvetCB;
    @BindView(R.id.additional_options_srcc)
    CustomFontRadioButton srccCB;
    @BindView(R.id.additional_options_ts)
    CustomFontRadioButton tsCB;

    @BindView(R.id.additional_options_confirm)
    CustomFontButton confirmBtn;
    Gson gson;

    private CalculateAddOptComprehensiveModel calculateAddOptComprehensiveModel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additional_options_comprehensive);

        gson = new Gson();
        String addOptModelStr = getIntent().getStringExtra(CalculateUtils.ADDITIONAL_INFO_INTENT);
        calculateAddOptComprehensiveModel = gson.fromJson(addOptModelStr, CalculateAddOptComprehensiveModel.class);

        tsfwdCB.setSelected(calculateAddOptComprehensiveModel.isTSFWD());
        eqvetCB.setSelected(calculateAddOptComprehensiveModel.isEQVET());
        srccCB.setSelected(calculateAddOptComprehensiveModel.isSRCC());
        tsCB.setSelected(calculateAddOptComprehensiveModel.isTS());

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                String returnAddOptModelStr = gson.toJson(calculateAddOptComprehensiveModel);
                intent.putExtra(CalculateUtils.ADDITIONAL_INFO_INTENT, returnAddOptModelStr);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
