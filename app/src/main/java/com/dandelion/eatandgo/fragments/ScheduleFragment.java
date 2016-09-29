package com.dandelion.eatandgo.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dandelion.eatandgo.R;
import com.dandelion.eatandgo.adapters.ScheduleListAdapter;
import com.dandelion.eatandgo.model.Schedule;

import java.util.ArrayList;
import java.util.List;

public class ScheduleFragment extends Fragment implements View.OnClickListener {

    private RecyclerView recyclerView;
    private List<Schedule> data;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);

        data = new ArrayList<>();

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(this);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new ScheduleListAdapter(createMockScheduleListData()));

        return view;
    }

    private List<Schedule> createMockScheduleListData() {
        data.add(new Schedule("130", "9:00"));
        data.add(new Schedule("200", "15:00"));
        return data;
    }

    private void changeRecyclerView(List<Schedule> data) {
        recyclerView.setAdapter(new ScheduleListAdapter(data));
    }

    @Override
    public void onClick(View view) {
        data.add(new Schedule("300", "21:00"));
        changeRecyclerView(data);
    }
}
