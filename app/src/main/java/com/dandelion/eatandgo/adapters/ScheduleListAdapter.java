package com.dandelion.eatandgo.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dandelion.eatandgo.R;
import com.dandelion.eatandgo.dto.ScheduleDTO;

import java.util.List;

public class ScheduleListAdapter extends
        RecyclerView.Adapter<ScheduleListAdapter.ScheduleViewHolder> {

    private List<ScheduleDTO> data;

    public ScheduleListAdapter(List<ScheduleDTO> data) {
        this.data = data;
    }

    @Override
    public ScheduleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.schedule_item, parent, false);
        return new ScheduleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ScheduleViewHolder holder, int position) {
//        holder.title.setText(data.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ScheduleViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;
        private TextView title;

        public ScheduleViewHolder(View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.cardView);
            title = (TextView) itemView.findViewById(R.id.title);
        }
    }
}
