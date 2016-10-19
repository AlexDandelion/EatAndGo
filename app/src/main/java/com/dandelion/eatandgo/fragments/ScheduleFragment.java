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
import com.dandelion.eatandgo.listeners.ScheduleDialogListener;
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
        data.add(new ScheduleItem("130", "9", "15"));
        data.add(new ScheduleItem("200", "14", "30"));
        return data;
    }

    @Override
    public void onClick(View view) {
        data.add(new ScheduleItem("grams", "hours", "minutes"));
        adapter.notifyDataSetChanged();
    }

    @Override
    public void callback(final int position) {
        ScheduleDialogFragment.getInstance(new ScheduleDialogListener() {
            @Override
            public void itemCallback(String weight, String hours, String minutes) {
                data.set(position, new ScheduleItem(weight, hours, minutes));
                adapter.notifyDataSetChanged();
            }
        }).show(getActivity().getSupportFragmentManager(),
                Constants.DIALOG_SCHEDULE);
    }
}
