package com.dandelion.eatandgo;

import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.dandelion.eatandgo.fragments.AuthorizationFragment;
import com.dandelion.eatandgo.fragments.PetProfileFragment;
import com.dandelion.eatandgo.fragments.ScheduleFragment;
import com.dandelion.eatandgo.fragments.SettingsFragment;
import com.dandelion.eatandgo.fragments.StatisticsFragment;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Drawer drawer;
    private DrawerLayout drawerLayout;
    private AccountHeaderBuilder accountHeaderBuilder;
    private AccountHeader accountHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialToolbar();
        initialAccountHeader();
        initDrawerBuilder();

        if (EatAndGoApp.getInstance().isAuthorized()) {
            switchFragments(new ScheduleFragment());
        } else {
            hideToolBar();
            switchFragments(new AuthorizationFragment());
        }
    }

    private void initialToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    public void hideToolBar() {
        getSupportActionBar().hide();
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
    }

    public void showToolBar() {
        getSupportActionBar().show();
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
    }

    private void initialAccountHeader() {
        accountHeaderBuilder = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.color.colorPrimary)
                .addProfiles(
                        new ProfileDrawerItem()
                                .withName("Fluffy")
                                .withEmail("eatandgo@gmail.com")
                                .withIcon(getResources().getDrawable(R.drawable.photo_circle))
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .withSelectionListEnabledForSingleProfile(false);
        accountHeader = accountHeaderBuilder.build();

    }

    private void initDrawerBuilder() {
        DrawerBuilder drawerBuilder = new DrawerBuilder(this);
        drawerBuilder.withToolbar(toolbar);
        drawerBuilder.withAccountHeader(accountHeader);
        drawerBuilder.addDrawerItems(getDrawerItems());

        drawer = drawerBuilder.build();
        drawer.getActionBarDrawerToggle();
        drawerBuilder.withActionBarDrawerToggleAnimated(true);

        drawerLayout = drawer.getDrawerLayout();

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
                    case Constants.DRAWER_ITEM_IDENTIFIER_PROFILE:
                        switchFragments(new PetProfileFragment());
                        break;
                    case Constants.DRAWER_ITEM_IDENTIFIER_EXIT:
                        logOut();
                        break;
                }
                drawer.closeDrawer();
                return true;
            }
        });
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
                        .withIcon(R.mipmap.ic_cat),
                new SecondaryDrawerItem()
                        .withIdentifier(Constants.DRAWER_ITEM_IDENTIFIER_EXIT)
                        .withName(R.string.exit)
                        .withIcon(R.mipmap.ic_close_octagon)
        };
    }

    public void switchFragments(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.baseLayoutContainer, fragment).commit();
    }

    private void logOut() {
        switchFragments(new AuthorizationFragment());
        hideToolBar();
        EatAndGoApp.getInstance().setIsAuthorized(false);
    }

//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        нужно проверить стек фрагментов + isFirstVisit
//        finish();
//    }
}
