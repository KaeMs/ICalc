package com.gmg.icalc.car;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.gmg.icalc.BaseMenuFragment;
import com.gmg.icalc.R;

/**
 * Created by KM on 10/20/2017. IC
 */

public class CarTLOFragment extends BaseMenuFragment {

    public static CarTLOFragment newInstance(Bundle bundle) {
        CarTLOFragment fragment = new CarTLOFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        background.setImageResource(R.color.lightGreen100Opa40);
        title.setText(getString(R.string.total_lost_only));
        message.setText(getString(R.string.placeholder_ipsum));
    }
}
