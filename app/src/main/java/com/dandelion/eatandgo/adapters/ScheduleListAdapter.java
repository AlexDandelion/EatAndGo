package com.dandelion.eatandgo.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dandelion.eatandgo.R;
import com.dandelion.eatandgo.model.ScheduleItem;

import java.util.List;

public class ScheduleListAdapter extends
        RecyclerView.Adapter<ScheduleListAdapter.ScheduleViewHolder> {

    private List<ScheduleItem> data;

    public ScheduleListAdapter(List<ScheduleItem> data) {
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
        holder.foodWeight.setText(data.get(position).getFoodWeight());
        holder.feedingTime.setText(data.get(position).getFeedingTime());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ScheduleViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private CardView cardView;
        private TextView foodWeight;
        private TextView feedingTime;

        public ScheduleViewHolder(View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.scheduleCardView);
            cardView.setOnClickListener(this);
            foodWeight = (TextView) itemView.findViewById(R.id.foodWeight);
            feedingTime = (TextView) itemView.findViewById(R.id.feedingTime);
        }

        @Override
        public void onClick(View view) {
//            всплывающее меню с полями
        }
    }
}
