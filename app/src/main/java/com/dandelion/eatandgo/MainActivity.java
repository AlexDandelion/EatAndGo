package com.dandelion.eatandgo;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.dandelion.eatandgo.fragments.ScheduleFragment;
import com.dandelion.eatandgo.fragments.SettingsFragment;
import com.dandelion.eatandgo.fragments.StatisticsFragment;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.holder.DimenHolder;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerBuilder drawerBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialToolbar();
        initDrawerBuilder();
        switchFragments(new ScheduleFragment());
    }

    private void initialToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
    }

    private void initDrawerBuilder() {
        drawerBuilder = new DrawerBuilder(this);
        drawerBuilder.withToolbar(toolbar);
        drawerBuilder.withHeader(R.layout.navigation_header);
        drawerBuilder.withHeaderHeight(DimenHolder.fromResource(R.dimen.navigation_header_height));
        drawerBuilder.addDrawerItems(getDrawerItems());
        drawerBuilder.withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
            @Override
            public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                switch ((int) drawerItem.getIdentifier()) {
                    case Constants.DRAWER_ITEM_IDENTIFIER_SCHEDULE:
                        switchFragments(new ScheduleFragment());
                        break;
                    case Constants.DRAWER_ITEM_IDENTIFIER_STATISTICS:
                        switchFragments(new StatisticsFragment());
                        break;
                    case Constants.DRAWER_ITEM_IDENTIFIER_SETTINGS:
                        switchFragments(new SettingsFragment());
                        break;
                    case Constants.DRAWER_ITEM_IDENTIFIER_EXIT:
                        exit();
                        break;
                }
                return true;
            }
        });

        Drawer d = drawerBuilder.build();
        d.getActionBarDrawerToggle();
        drawerBuilder.withActionBarDrawerToggleAnimated(true);
    }

    private IDrawerItem[] getDrawerItems() {
        return new IDrawerItem[]{
                new SecondaryDrawerItem()
                        .withIdentifier(Constants.DRAWER_ITEM_IDENTIFIER_SCHEDULE)
                        .withName(R.string.schedule)
                        .withIcon(R.mipmap.ic_bone),
                new SecondaryDrawerItem()
                        .withIdentifier(Constants.DRAWER_ITEM_IDENTIFIER_STATISTICS)
                        .withName(R.string.statistics)
                        .withIcon(R.mipmap.ic_paw),
                new SecondaryDrawerItem()
                        .withIdentifier(Constants.DRAWER_ITEM_IDENTIFIER_SETTINGS)
                        .withName(R.string.settings)
                        .withIcon(R.mipmap.ic_settings),
                new SecondaryDrawerItem()
                        .withIdentifier(Constants.DRAWER_ITEM_IDENTIFIER_PROFILE)
                        .withName(R.string.navigation_profile)
                        .withIcon(R.mipmap.ic_cat)
                        .withSubItems(
                        new SecondaryDrawerItem()
                                .withIdentifier(Constants.DRAWER_ITEM_IDENTIFIER_NAME)
                                .withName(R.string.navigation_name),
                        new SecondaryDrawerItem()
                                .withIdentifier(Constants.DRAWER_ITEM_IDENTIFIER_PHOTO)
                                .withName(R.string.navigation_photo)),
                new SecondaryDrawerItem()
                        .withIdentifier(Constants.DRAWER_ITEM_IDENTIFIER_EXIT)
                        .withName(R.string.exit)
                        .withIcon(R.mipmap.ic_close_octagon)
        };
    }

    private void switchFragments(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.baseLayoutContainer, fragment).commit();
    }

    private void exit() {
        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
    }
}
