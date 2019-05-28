package com.moviestore.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toolbar;
import android.support.design.widget.TabLayout;

import com.moviestore.BaseActivity;
import com.moviestore.R;
import com.moviestore.adapter.ViewPagerAdapter;
import com.moviestore.fragment.AboutFragment;
import com.moviestore.fragment.FavouriteFragment;
import com.moviestore.fragment.MapFragment;
import com.moviestore.fragment.MovieFragment;
import com.moviestore.fragment.SettingFragment;

public class MainActivity extends BaseActivity {

    private Toolbar mToolbar;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mViewPager = findViewById(R.id.viewPager);
        mTabLayout = findViewById(R.id.tabs);

        mTabLayout.addTab(mTabLayout.newTab().setText("Movie"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Favourite"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Setting"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Map"));
        mTabLayout.addTab(mTabLayout.newTab().setText("About"));
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        setupViewPager(mViewPager);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager mViewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new MovieFragment(), "MOVIE");
        adapter.addFragment(new FavouriteFragment(), "FAVOURITE");
        adapter.addFragment(new SettingFragment(), "SETTING");
        adapter.addFragment(new MapFragment(), "MAP");
        adapter.addFragment(new AboutFragment(), "ABOUT");
        mViewPager.setAdapter(adapter);
    }
}
