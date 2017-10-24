package com.gmg.icalc.car;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.gmg.icalc.BaseActivity;
import com.gmg.icalc.BaseMenuActivity;
import com.gmg.icalc.MainActivity;
import com.gmg.icalc.MediaUtils;
import com.gmg.icalc.PagerFragmentModel;
import com.gmg.icalc.R;
import com.gmg.icalc.SharedPreferenceUtilities;
import com.gmg.icalc.utils.ViewUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KM on 10/20/2017. IC
 */

public class CarMainActivity extends BaseMenuActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<PagerFragmentModel> pagerFragmentModels = new ArrayList<>();

        PagerFragmentModel otomate = new PagerFragmentModel();
        otomate.setFragment(CarOtomateFragment.newInstance(getIntent().getExtras()));
        otomate.setTitle(getString(R.string.otomate));
        otomate.setIcon(R.mipmap.ic_launcher);
        pagerFragmentModels.add(otomate);

        PagerFragmentModel comprehensive = new PagerFragmentModel();
        comprehensive.setFragment(CarComprehensiveFragment.newInstance(getIntent().getExtras()));
        comprehensive.setTitle(getString(R.string.comprehensive));
        comprehensive.setIcon(R.mipmap.ic_launcher_round);
        pagerFragmentModels.add(comprehensive);

        PagerFragmentModel tlo = new PagerFragmentModel();
        tlo.setFragment(CarTLOFragment.newInstance(getIntent().getExtras()));
        tlo.setTitle(getString(R.string.total_lost_only));
        tlo.setIcon(R.mipmap.ic_launcher);
        pagerFragmentModels.add(tlo);

        pagerAdapter.addFragments(pagerFragmentModels);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CarMainActivity.this, CalculateActivity.class);
                startActivity(intent);
            }
        });

        title.setText(getString(R.string.vehicle));
    }
}
