package com.gmg.icalc.car;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.gmg.icalc.BaseMenuFragment;
import com.gmg.icalc.R;

/**
 * Created by KM on 10/20/2017. IC
 */

public class CarOtomateFragment extends BaseMenuFragment {

    public static CarOtomateFragment newInstance(Bundle bundle) {
        CarOtomateFragment fragment = new CarOtomateFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        background.setImageResource(R.color.greyOpa40);
        title.setText(getString(R.string.otomate));
        message.setText(getString(R.string.placeholder_ipsum));
    }
}
