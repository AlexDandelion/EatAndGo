package com.dandelion.eatandgo.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dandelion.eatandgo.R;
import com.dandelion.eatandgo.adapters.StatisticsListAdapter;
import com.dandelion.eatandgo.model.StatisticsItem;

import java.util.ArrayList;
import java.util.List;

public class StatisticsFragment extends BaseFragment implements View.OnClickListener {

    private List<StatisticsItem> data;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_statistics, container, false);

        data = new ArrayList<>();

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.statisticsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new StatisticsListAdapter(createMockStatisticsListData()));

        TextView headerType = (TextView) view.findViewById(R.id.statisticsType);
        headerType.setOnClickListener(this);
        TextView headerWeight = (TextView) view.findViewById(R.id.statisticsWeight);
        headerWeight.setOnClickListener(this);
        TextView headerTime = (TextView) view.findViewById(R.id.statisticsTime);
        headerTime.setOnClickListener(this);

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.statisticsFloActBut);
        fab.setOnClickListener(this);

        return view;
    }

    private List<StatisticsItem> createMockStatisticsListData() {
        data.add(new StatisticsItem("food", "120", "9 - 15"));
        data.add(new StatisticsItem("water", "70", "10 - 13"));
        data.add(new StatisticsItem("food", "150", "15 - 21"));
        return data;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.statisticsType:
                break;
            case R.id.statisticsWeight:
                break;
            case R.id.statisticsTime:
                break;
            case R.id.statisticsFloActBut:
                switchFragments(new ChartFragment());
                break;
        }
    }
}
