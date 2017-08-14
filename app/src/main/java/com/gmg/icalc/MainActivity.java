package com.gmg.icalc;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.gmg.icalc.utils.ViewAnimationUtils;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
    // Otomate
    @BindView(R.id.main_otomate)
    LinearLayout otomateView;
    @BindView(R.id.main_otomate_content)
    CustomFontTextView otomateContent;
    // Comprehensive
    @BindView(R.id.main_comprehensive)
    LinearLayout comprehensiveView;
    @BindView(R.id.main_comprehensive_content)
    CustomFontTextView comprehensiveContent;
    // Total Lost
    @BindView(R.id.main_total_lost)
    LinearLayout totalLostView;
    @BindView(R.id.main_total_lost_content)
    CustomFontTextView totalLostContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        otomateView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (otomateContent.getVisibility() == View.VISIBLE){
                    ViewAnimationUtils.collapse(otomateContent);
                } else {
                    ViewAnimationUtils.expand(otomateContent);
                }
            }
        });

        comprehensiveView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (comprehensiveContent.getVisibility() == View.VISIBLE){
                    ViewAnimationUtils.collapse(comprehensiveContent);
                } else {
                    ViewAnimationUtils.expand(comprehensiveContent);
                }
            }
        });

        totalLostView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (totalLostContent.getVisibility() == View.VISIBLE){
                    ViewAnimationUtils.collapse(totalLostContent);
                } else {
                    ViewAnimationUtils.expand(totalLostContent);
                }
            }
        });
    }
}
