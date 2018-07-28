package com.sourabh.android.androidbasictourguide;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.drawerLayout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.navigationView)
    NavigationView mNavigationView;
    private FragmentManager mFragmentManager;
    private HistoricFragment mHistoricFragment;
    private EventsFragment mEventsFragment;
    private FavouriteFragment mFavouriteFragment;
    private HotelFragment mHotelFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mFragmentManager = getSupportFragmentManager();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }
        mHistoricFragment = new HistoricFragment();
        mEventsFragment = new EventsFragment();
        mFavouriteFragment = new FavouriteFragment();
        mHotelFragment = new HotelFragment();
        mFragmentManager.beginTransaction().add(R.id.fragment_layout, mHotelFragment).commit();
        mNavigationView.setCheckedItem(R.id.hotel_menu_item);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.hotel_menu_item:
                        mFragmentManager.beginTransaction().replace(R.id.fragment_layout, mHotelFragment).commit();
                        break;
                    case R.id.fav_menu_item:
                        mFragmentManager.beginTransaction().replace(R.id.fragment_layout, mFavouriteFragment).commit();
                        break;
                    case R.id.event_menu_item:
                        mFragmentManager.beginTransaction().replace(R.id.fragment_layout, mEventsFragment).commit();
                        break;
                    case R.id.history_menu_item:
                        mFragmentManager.beginTransaction().replace(R.id.fragment_layout, mHistoricFragment).commit();
                        break;
                }
                item.setChecked(true);
                mDrawerLayout.closeDrawers();
                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            mDrawerLayout.openDrawer(Gravity.START);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
