package com.techmarinar.modernviewpagerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.os.Handler;

import com.google.android.material.tabs.TabLayout;
import com.techmarinar.modernviewpagerapp.tabdata.TabClass;
import com.techmarinar.modernviewpagerapp.tabdata.TabClassList;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    //var widget
    private TabLayout mTabs;
    private ViewPager2 mViewPager;
    private int NUM_PAGES=3;
    private static int currentPage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find widget
        mTabs=(TabLayout) findViewById(R.id.mTabsLayout);
        mViewPager=(ViewPager2) findViewById(R.id.mViewPager);

        //find fragment manager
        FragmentManager fm=getSupportFragmentManager();
        PagersAdapter adapter=new PagersAdapter(fm , getLifecycle() ,MainActivity.this);
        //set pager adapter
        mViewPager.setAdapter(adapter);

        //setting tabs
       setTabsWidget(mTabs);

        //connect tabs with ViewPager
        setTabsWithViewPager();

        //set sliding from page to page
        setUpSliding(mViewPager,mTabs);

        //setup Timer
        setUpAutoSlidingTimer();


    }

    //Auto sliding timer
    private void setUpAutoSlidingTimer() {

        //NUM_PAGES =mLists.size();
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mViewPager.setCurrentItem(currentPage++, true);
            }
        };

        //swiping timer
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);

    }

    private void setTabsWidget(TabLayout mTabs) {
        //get names of tabs from the list
        ArrayList<TabClass> list=TabClassList.getTabList();

        //tabs name
        mTabs.addTab(mTabs.newTab().setText(list.get(0).getTabName()));
        mTabs.addTab(mTabs.newTab().setText(list.get(1).getTabName()));
        mTabs.addTab(mTabs.newTab().setText(list.get(2).getTabName()));

        //set Tab icons

        mTabs.getTabAt(0).setIcon(R.drawable.ic_baseline_search_24);
        mTabs.getTabAt(1).setIcon(R.drawable.ic_baseline_flight_24);
        mTabs.getTabAt(2).setIcon(R.drawable.ic_baseline_electric_scooter_24);
    }

    private void setTabsWithViewPager() {

        mTabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //connect with tabs
                mViewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setUpSliding(ViewPager2 mViewPager, TabLayout mTabs) {

        mViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                mTabs.selectTab(mTabs.getTabAt(position));

            }
        });
    }
}