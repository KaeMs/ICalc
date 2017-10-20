package com.gmg.icalc;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.gmg.icalc.CustomViews.CustomFontTextView;
import com.gmg.icalc.car.CalculateActivity;
import com.gmg.icalc.car.CarMainActivity;
import com.gmg.icalc.utils.APIConstants;
import com.gmg.icalc.utils.ViewAnimationUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements AppBarLayout.OnOffsetChangedListener, MenuGridAdapter.MenuOnclick {

    private static final float PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR = 0.9f;
    private static final float PERCENTAGE_TO_HIDE_TITLE_DETAILS = 0.3f;
    private static final int ALPHA_ANIMATIONS_DURATION = 200;

    private boolean mIsTheTitleVisible = false;
    private boolean mIsTheTitleContainerVisible = true;

    // Title
    @BindView(R.id.main_toolbar_title)
    CustomFontTextView toolbarTitle;
    @BindView(R.id.main_avatar)
    ImageView avatar;
    @BindView(R.id.main_appbar)
    AppBarLayout appBarLayout;
    @BindView(R.id.main_name_wrapper)
    LinearLayout nameWrapper;
    @BindView(R.id.main_name)
    CustomFontTextView name;
    @BindView(R.id.main_name_frame_wrapper)
    FrameLayout nameFrameWrapper;
    /*// Otomate
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
    CustomFontTextView totalLostContent;*/
    @BindView(R.id.main_gridview)
    GridView gridView;

//    @BindView(R.id.main_fab)
//    FloatingActionButton calculateFAB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name.setText(SharedPreferenceUtilities.getFromSessionSP(this, SharedPreferenceUtilities.USER_FIRST_NAME));
        toolbarTitle.setText(SharedPreferenceUtilities.getFromSessionSP(this, SharedPreferenceUtilities.USER_FIRST_NAME));

        /*otomateView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleOtomate();
            }
        });

        otomateContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleOtomate();
            }
        });

        comprehensiveView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleComprehensive();
            }
        });

        comprehensiveContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleComprehensive();
            }
        });

        totalLostView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleTotalLost();
            }
        });

        totalLostContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleTotalLost();
            }
        });*/

        List<MenuModel> menuModels = new ArrayList<>();
        MenuModel menuModel = new MenuModel();
        menuModel.setActivity(CarMainActivity.class.getName());
        menuModel.setImgRes(R.mipmap.ic_launcher_round);
        menuModel.setName(getString(R.string.vehicle));
        menuModels.add(menuModel);

        MenuGridAdapter menuGridAdapter = new MenuGridAdapter(this, R.layout.base_menu_item, menuModels, this);
        gridView.setAdapter(menuGridAdapter);

        /*calculateFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CalculateActivity.class);
                startActivity(intent);
            }
        });*/

        appBarLayout.addOnOffsetChangedListener(this);

        String avatarPath = SharedPreferenceUtilities.getFromSessionSP(this, SharedPreferenceUtilities.USER_PHOTO);

        Glide.with(this)
                .load(APIConstants.WEB_URL + avatarPath)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .fitCenter()
                .skipMemoryCache(true)
                .placeholder(MediaUtils.image_placeholder_black)
                .error(MediaUtils.image_error_black)
                .into(avatar);

        startAlphaAnimation(toolbarTitle, 0, View.INVISIBLE);
    }

    /*private void toggleOtomate(){
        if (otomateContent.getVisibility() == View.VISIBLE){
            ViewAnimationUtils.collapse(otomateContent);
        } else {
            ViewAnimationUtils.expand(otomateContent);
        }
    }

    private void toggleComprehensive(){
        if (comprehensiveContent.getVisibility() == View.VISIBLE){
            ViewAnimationUtils.collapse(comprehensiveContent);
        } else {
            ViewAnimationUtils.expand(comprehensiveContent);
        }
    }

    private void toggleTotalLost(){
        if (totalLostContent.getVisibility() == View.VISIBLE){
            ViewAnimationUtils.collapse(totalLostContent);
        } else {
            ViewAnimationUtils.expand(totalLostContent);
        }
    }*/

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int offset) {
        int maxScroll = appBarLayout.getTotalScrollRange();
        float percentage = (float) Math.abs(offset) / (float) maxScroll;

        handleAlphaOnTitle(percentage);
        handleToolbarTitleVisibility(percentage);
    }

    private void handleToolbarTitleVisibility(float percentage) {
        if (percentage >= PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR) {

            if (!mIsTheTitleVisible) {
                startAlphaAnimation(toolbarTitle, ALPHA_ANIMATIONS_DURATION, View.VISIBLE);
                mIsTheTitleVisible = true;
            }

        } else {

            if (mIsTheTitleVisible) {
                startAlphaAnimation(toolbarTitle, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE);
                mIsTheTitleVisible = false;
            }
        }
    }

    private void handleAlphaOnTitle(float percentage) {
        if (percentage >= PERCENTAGE_TO_HIDE_TITLE_DETAILS) {
            if (mIsTheTitleContainerVisible) {
                startAlphaAnimation(nameWrapper, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE);
                mIsTheTitleContainerVisible = false;
            }

        } else {

            if (!mIsTheTitleContainerVisible) {
                startAlphaAnimation(nameWrapper, ALPHA_ANIMATIONS_DURATION, View.VISIBLE);
                mIsTheTitleContainerVisible = true;
            }
        }
    }

    public static void startAlphaAnimation(View v, long duration, int visibility) {
        AlphaAnimation alphaAnimation = (visibility == View.VISIBLE)
                ? new AlphaAnimation(0f, 1f)
                : new AlphaAnimation(1f, 0f);

        alphaAnimation.setDuration(duration);
        alphaAnimation.setFillAfter(true);
        v.startAnimation(alphaAnimation);
    }

    @Override
    public void onMenuClick(int position, View clickedView, MenuModel menuModel) {

        try {
            Class c = Class.forName(menuModel.getActivity());
            Intent intent = new Intent(this, c);
            startActivity(intent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
