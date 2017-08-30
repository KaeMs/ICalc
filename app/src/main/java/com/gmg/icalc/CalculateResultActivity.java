package com.gmg.icalc;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.gmg.icalc.CustomViews.CustomFontTextView;

import butterknife.BindView;

/**
 * Created by KM on 8/21/2017. IC
 */

public class CalculateResultActivity extends BaseActivity {

    @BindView(R.id.calculate_result_actual_price)
    CustomFontTextView actualPrice;
    @BindView(R.id.calculate_result_additional)
    CustomFontTextView additional;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_result);

    }
}
