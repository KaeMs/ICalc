package com.gmg.icalc;

import android.support.annotation.DrawableRes;
import android.support.v4.app.Fragment;

/**
 * Created by KM on 10/20/2017. IC
 */

public class PagerFragmentModel {
    private Fragment fragment;
    private String title;
    @DrawableRes private int icon;

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
