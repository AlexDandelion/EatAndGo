package com.dandelion.eatandgo.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dandelion.eatandgo.R;
import com.dandelion.eatandgo.adapters.ScheduleListAdapter;
import com.dandelion.eatandgo.dto.ScheduleDTO;

import java.util.ArrayList;
import java.util.List;

public class ScheduleFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new ScheduleListAdapter(createMockScheduleListData()));

        return view;
    }

    private List<ScheduleDTO> createMockScheduleListData() {
        List<ScheduleDTO> data = new ArrayList<>();
        data.add(new ScheduleDTO("TestItem 1"));
        data.add(new ScheduleDTO("TestItem 2"));

        return data;
    }
}
