package com.techmarinar.modernviewpagerapp.fragmentclasses;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.techmarinar.modernviewpagerapp.R;

public class TripsFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";

    private int mPage;


    public TripsFragment() {
        // Required empty public constructor
    }

    public static TripsFragment newInstance( int page) {
        TripsFragment fragment = new TripsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, page);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPage = getArguments().getInt(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_trips, container, false);

        //find the textView
        TextView textView=(TextView) v.findViewById(R.id.mTripsTv);
        textView.setText("Trips");
        //return the view
        return v;

    }
}