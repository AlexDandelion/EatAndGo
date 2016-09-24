package com.dandelion.eatandgo.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.dandelion.eatandgo.App;
import com.dandelion.eatandgo.R;
import com.dandelion.eatandgo.fragments.ChartFragment;
import com.dandelion.eatandgo.fragments.InfoFragment;
import com.dandelion.eatandgo.fragments.ScheduleFragment;
import com.dandelion.eatandgo.fragments.SettingsFragment;
import com.dandelion.eatandgo.fragments.StatisticsFragment;

import java.util.HashMap;
import java.util.Map;

public class TabsFragmentAdapter extends FragmentPagerAdapter {

    private Map<Integer, Fragment> tabs;
    private Map<Integer, String> titles;

    public TabsFragmentAdapter(FragmentManager fm) {
        super(fm);
        initTabsMap();
        initTitlesMap();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return tabs.get(position);
    }

    @Override
    public int getCount() {
        return tabs.size();
    }

    private void initTabsMap() {
        tabs = new HashMap<>();
        tabs.put(0, new ScheduleFragment());
        tabs.put(1, new SettingsFragment());
        tabs.put(2, new StatisticsFragment());
        tabs.put(3, new ChartFragment());
        tabs.put(4, new InfoFragment());
    }

    private void initTitlesMap() {
        titles = new HashMap<>();
        titles.put(0, App.getContext().getString(R.string.schedule));
        titles.put(1, App.getContext().getString(R.string.settings));
        titles.put(2, App.getContext().getString(R.string.statistics));
        titles.put(3, App.getContext().getString(R.string.chart));
        titles.put(4, App.getContext().getString(R.string.info));
    }
}
