package com.dandelion.eatandgo.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dandelion.eatandgo.MainActivity;
import com.dandelion.eatandgo.R;
import com.dandelion.eatandgo.adapters.StatisticsListAdapter;
import com.dandelion.eatandgo.model.StatisticsItem;

import java.util.ArrayList;
import java.util.List;

public class StatisticsFragment extends Fragment implements View.OnClickListener {

    private RecyclerView recyclerView;
    private List<StatisticsItem> data;
    private TextView headerType;
    private TextView headerWeight;
    private TextView headerTime;
    private TextView chart;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_statistics, container, false);

        data = new ArrayList<>();

        recyclerView = (RecyclerView) view.findViewById(R.id.statisticsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new StatisticsListAdapter(createMockStatisticsListData()));

        headerType = (TextView) view.findViewById(R.id.statisticsType);
        headerType.setOnClickListener(this);
        headerWeight = (TextView) view.findViewById(R.id.statisticsWeight);
        headerWeight.setOnClickListener(this);
        headerTime = (TextView) view.findViewById(R.id.statisticsTime);
        headerTime.setOnClickListener(this);
        chart = (TextView) view.findViewById(R.id.statisticsChart);
        chart.setOnClickListener(this);

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
            case R.id.statisticsChart:
                ((MainActivity) getActivity()).switchFragments(new ChartFragment());
                break;
        }
    }
}
