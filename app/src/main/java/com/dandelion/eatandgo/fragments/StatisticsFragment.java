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
import com.dandelion.eatandgo.models.StatisticsItem;
import com.dandelion.eatandgo.utils.StatisticsSort;

import java.util.ArrayList;
import java.util.List;

public class StatisticsFragment extends BaseFragment implements View.OnClickListener {

    private List<StatisticsItem> data;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_statistics, container, false);

        data = new ArrayList<>();

        recyclerView = (RecyclerView) view.findViewById(R.id.statisticsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new StatisticsListAdapter(createMockStatisticsListData()));

        TextView headerType = (TextView) view.findViewById(R.id.statisticsType);
        headerType.setOnClickListener(this);
        TextView headerWeight = (TextView) view.findViewById(R.id.statisticsWeight);
        headerWeight.setOnClickListener(this);
        TextView headerDate = (TextView) view.findViewById(R.id.statisticsDate);
        headerDate.setOnClickListener(this);

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.statisticsFloActBut);
        fab.setOnClickListener(this);

        return view;
    }

    private List<StatisticsItem> createMockStatisticsListData() {
        data.add(new StatisticsItem("food", "150", "9 - 15", "11.06.16"));
        data.add(new StatisticsItem("water", "10", "10 - 13", "11.07.16"));
        data.add(new StatisticsItem("food", "20", "15 - 21", "12.07.16"));
        data.add(new StatisticsItem("water", "90", "12 - 18", "12.05.16"));
        data.add(new StatisticsItem("water", "40", "10 - 23", "13.07.16"));
        data.add(new StatisticsItem("food", "70", "13 - 15", "13.07.16"));
        data.add(new StatisticsItem("water", "65", "11 - 15", "14.07.16"));

        return data;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.statisticsType:
                StatisticsSort.typeSort(data);
                recyclerView.setAdapter(new StatisticsListAdapter(data));
                break;
            case R.id.statisticsWeight:
                StatisticsSort.weightSort(data);
                recyclerView.setAdapter(new StatisticsListAdapter(data));
                break;
            case R.id.statisticsDate:
                StatisticsSort.dateSort(data);
                recyclerView.setAdapter(new StatisticsListAdapter(data));
                break;
            case R.id.statisticsFloActBut:
                switchFragments(new ChartFragment());
                break;
        }
    }
}
