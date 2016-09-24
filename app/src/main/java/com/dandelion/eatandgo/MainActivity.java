package com.dandelion.eatandgo;

import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.dandelion.eatandgo.adapters.TabsFragmentAdapter;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialToolbar();
        initNavigationView();
        initTabs();
    }

    private void initialToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
    }

    private void initNavigationView() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout,
                toolbar, R.string.view_navigation_open, R.string.view_navigation_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem item) {
                        drawerLayout.closeDrawers();
                        switch (item.getItemId()) {
                            case R.id.actionScheduleItem:
                                viewPager.setCurrentItem(Constants.TAB_ONE);
                                break;
                            case R.id.actionSettingsItem:
                                viewPager.setCurrentItem(Constants.TAB_TWO);
                                break;
                            case R.id.actionStatisticsItem:
                                viewPager.setCurrentItem(Constants.TAB_THREE);
                                break;
                            case R.id.actionChartItem:
                                viewPager.setCurrentItem(Constants.TAB_FOUR);
                                break;
                            case R.id.actionInfoItem:
                                viewPager.setCurrentItem(Constants.TAB_FIVE);
                                break;
                        }
                        return true;
                    }
                });
    }

    private void initTabs() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        TabsFragmentAdapter adapter = new TabsFragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }
}
