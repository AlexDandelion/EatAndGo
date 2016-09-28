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

public class ScheduleFragment extends Fragment implements View.OnClickListener {

    private RecyclerView recyclerView;
    private List<ScheduleDTO> data;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);

        data = new ArrayList<>();

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new ScheduleListAdapter(createMockScheduleListData()));

        return view;
    }

    private List<ScheduleDTO> createMockScheduleListData() {
        data.add(new ScheduleDTO("130", "9:00"));
        data.add(new ScheduleDTO("200", "15:00"));
        return data;
    }

    private void changeRecyclerView(List<ScheduleDTO> data) {
        recyclerView.setAdapter(new ScheduleListAdapter(data));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab:
                data.add(new ScheduleDTO("300", "21:00"));
                changeRecyclerView(data);
                break;
            case R.id.cardView:
                data.remove(data.size() - 1);
                changeRecyclerView(data);
                break;
        }
    }
}
