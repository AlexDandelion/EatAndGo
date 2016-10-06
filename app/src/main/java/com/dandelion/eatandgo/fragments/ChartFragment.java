package com.dandelion.eatandgo.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dandelion.eatandgo.R;

public class ChartFragment extends BaseFragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chart, container, false);

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.chartFloActBut);
        fab.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switchFragments(new StatisticsFragment());
    }
}
