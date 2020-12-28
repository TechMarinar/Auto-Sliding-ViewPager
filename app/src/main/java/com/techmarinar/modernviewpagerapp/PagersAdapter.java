package com.techmarinar.modernviewpagerapp;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.techmarinar.modernviewpagerapp.fragmentclasses.ExploreFragment;
import com.techmarinar.modernviewpagerapp.fragmentclasses.FlightFragment;
import com.techmarinar.modernviewpagerapp.fragmentclasses.TripsFragment;
import com.techmarinar.modernviewpagerapp.tabdata.TabClass;
import com.techmarinar.modernviewpagerapp.tabdata.TabClassList;

import java.util.ArrayList;

public class PagersAdapter extends FragmentStateAdapter {
    private Context mContext;
    private ArrayList<TabClass> mList= TabClassList.getTabList();

    //constructor
    public PagersAdapter(FragmentManager fragmentManager, Lifecycle lifecycle , Context context) {
        super(fragmentManager, lifecycle);
        mContext=context;
    }

    @Override
    public Fragment createFragment(int position) {

        switch (position){
            case 0:
                return ExploreFragment.newInstance(position + 1);
            case 1:
                return  FlightFragment.newInstance(position + 1);
            default:
                return TripsFragment.newInstance(position + 1);


        }

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
