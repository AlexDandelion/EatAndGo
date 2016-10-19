package com.dandelion.eatandgo.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dandelion.eatandgo.R;
import com.dandelion.eatandgo.models.StatisticsItem;

import java.util.List;

public class StatisticsListAdapter extends
        RecyclerView.Adapter<StatisticsListAdapter.StatisticsViewHolder> {

    private List<StatisticsItem> data;

    public StatisticsListAdapter(List<StatisticsItem> data) {
        this.data = data;
    }

    @Override
    public StatisticsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.statistics_item, parent, false);

        return new StatisticsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StatisticsViewHolder holder, int position) {
        holder.foodWeight.setText(data.get(position).getFoodWeight());
        holder.waterWeight.setText(data.get(position).getWaterWeight());
        holder.date.setText(data.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class StatisticsViewHolder extends RecyclerView.ViewHolder {

        private TextView foodWeight;
        private TextView waterWeight;
        private TextView date;

        public StatisticsViewHolder(View itemView) {
            super(itemView);

            foodWeight = (TextView) itemView.findViewById(R.id.statisticsFoodWeight);
            waterWeight = (TextView) itemView.findViewById(R.id.statisticsWaterWeight);
            date = (TextView) itemView.findViewById(R.id.statisticsDate);
        }
    }
}
