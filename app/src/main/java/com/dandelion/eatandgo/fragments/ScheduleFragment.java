package com.dandelion.eatandgo.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dandelion.eatandgo.Constants;
import com.dandelion.eatandgo.listeners.CallbackListener;
import com.dandelion.eatandgo.R;
import com.dandelion.eatandgo.adapters.ScheduleListAdapter;
import com.dandelion.eatandgo.listeners.NewListener;
import com.dandelion.eatandgo.models.ScheduleItem;

import java.util.ArrayList;
import java.util.List;

public class ScheduleFragment extends BaseFragment
        implements View.OnClickListener, CallbackListener {

    private List<ScheduleItem> data;
    private ScheduleListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);

        data = new ArrayList<>();
        adapter = new ScheduleListAdapter(this, createMockScheduleListData());

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.scheduleFloActBut);
        fab.setOnClickListener(this);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.scheduleRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        return view;
    }

    private List<ScheduleItem> createMockScheduleListData() {
        data.add(new ScheduleItem("130", "9:00"));
        data.add(new ScheduleItem("200", "15:00"));
        return data;
    }

    private void changeRecyclerView(List<ScheduleItem> data) {
        adapter.notifyDataSetChanged();
//        recyclerView.setAdapter(new ScheduleListAdapter(this, data));
    }

    @Override
    public void onClick(View view) {
        data.add(new ScheduleItem("add the grams", "add the time"));
        changeRecyclerView(data);
    }

    @Override
    public void callback(final int position) {
//        new ScheduleDialogFragment().show(getActivity().getSupportFragmentManager(),
//                Constants.DIALOG_SCHEDULE);

        ScheduleDialogFragment.getInstance(new NewListener() {
            @Override
            public void itemCallback(String s1, String s2) {
                data.set(position, new ScheduleItem(s1, s2));
                adapter.notifyDataSetChanged();
//                recyclerView.setAdapter(new ScheduleListAdapter(ScheduleFragment.this, data));
            }
        }).show(getActivity().getSupportFragmentManager(),
                Constants.DIALOG_SCHEDULE);
    }
}
