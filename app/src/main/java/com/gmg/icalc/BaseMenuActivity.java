package com.gmg.icalc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by KM on 10/20/2017. IC
 */

public class BaseMenuActivity extends BaseActivity {
    @BindView(R.id.base_menu_tablayout)
    public TabLayout tabLayout;
    @BindView(R.id.base_menu_pager)
    public ViewPager pager;
    @BindView(R.id.base_menu_fab)
    public FloatingActionButton fab;
    public BaseMenuPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_menu_activity);

        pagerAdapter = new BaseMenuPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(pager);
    }

    public class BaseMenuPagerAdapter extends FragmentStatePagerAdapter {

        private List<Fragment> fragments = new ArrayList<>();
        private final List<String> titleList = new ArrayList<>();

        public BaseMenuPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titleList.get(position);
        }


        @Override
        public int getCount() {
            return fragments.size();
        }

        public void addFragment(PagerFragmentModel pagerFragmentModel) {
            fragments.add(pagerFragmentModel.getFragment());
            titleList.add(pagerFragmentModel.getTitle());
            TabLayout.Tab tab = tabLayout.getTabAt(getCount());
            if (tab != null){
                tabLayout.getTabAt(fragments.size() - 1).setIcon(ContextCompat.getDrawable(BaseMenuActivity.this, pagerFragmentModel.getIcon()));
            }
            notifyDataSetChanged();
        }

        public void addFragments(List<PagerFragmentModel> fragmentModels) {
            for (PagerFragmentModel item :
                    fragmentModels) {
                fragments.add(item.getFragment());
                titleList.add(item.getTitle());
                TabLayout.Tab tab = tabLayout.getTabAt(getCount());
                if (tab != null){
                    tabLayout.getTabAt(fragments.size() - 1).setIcon(ContextCompat.getDrawable(BaseMenuActivity.this, item.getIcon()));
                }
                notifyDataSetChanged();
            }
        }
    }
}
