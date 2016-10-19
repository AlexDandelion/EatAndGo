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
    private StatisticsListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_statistics, container, false);

        data = new ArrayList<>();
        adapter = new StatisticsListAdapter(createMockStatisticsListData());

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.statisticsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        TextView headerWeight = (TextView) view.findViewById(R.id.statisticsWeight);
        headerWeight.setOnClickListener(this);
        TextView headerDate = (TextView) view.findViewById(R.id.statisticsDate);
        headerDate.setOnClickListener(this);

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.statisticsFloActBut);
        fab.setOnClickListener(this);

        return view;
    }

    private List<StatisticsItem> createMockStatisticsListData() {
        data.add(new StatisticsItem("150", "70", "11.07.16"));
        data.add(new StatisticsItem("210", "100", "10.07.16"));
        data.add(new StatisticsItem("90", "40", "12.07.16"));
        data.add(new StatisticsItem("140", "110", "15.07.16"));
        data.add(new StatisticsItem("135", "40", "09.07.16"));
        data.add(new StatisticsItem("190", "80", "13.07.16"));
        data.add(new StatisticsItem("80", "65", "14.07.16"));

        return data;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.statisticsWeight:
                StatisticsSort.weightSort(data);
                adapter.notifyDataSetChanged();
                break;
            case R.id.statisticsDate:
                StatisticsSort.dateSort(data);
                adapter.notifyDataSetChanged();
                break;
            case R.id.statisticsFloActBut:
                switchFragments(new ChartFragment());
                break;
        }
    }
}
