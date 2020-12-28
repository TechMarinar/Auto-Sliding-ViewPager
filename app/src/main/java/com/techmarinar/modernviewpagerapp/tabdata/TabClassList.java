package com.techmarinar.modernviewpagerapp.tabdata;

import com.techmarinar.modernviewpagerapp.R;

import java.util.ArrayList;

public class TabClassList {
    private static ArrayList<TabClass> tabList=new ArrayList<TabClass>(){
        {
            add(new TabClass(R.drawable.ic_baseline_search_24,"Explore"));
            add(new TabClass(R.drawable.ic_baseline_flight_24,"Flights"));
            add(new TabClass(R.drawable.ic_baseline_electric_scooter_24,"Trips"));
        }
    };

    public static ArrayList<TabClass> getTabList() {
        return tabList;
    }
}
