package com.dandelion.eatandgo.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dandelion.eatandgo.listeners.CallbackListener;
import com.dandelion.eatandgo.R;
import com.dandelion.eatandgo.models.ScheduleItem;

import java.util.List;

public class ScheduleListAdapter extends
        RecyclerView.Adapter<ScheduleListAdapter.ScheduleViewHolder> {

    private CallbackListener listener;
    private List<ScheduleItem> data;

    public ScheduleListAdapter(CallbackListener listener, List<ScheduleItem> data) {
        this.listener = listener;
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

    public class ScheduleViewHolder extends RecyclerView.ViewHolder
            implements View.OnLongClickListener {

        private CardView cardView;
        private TextView foodWeight;
        private TextView feedingTime;

        public ScheduleViewHolder(View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.scheduleCardView);
            cardView.setOnLongClickListener(this);
            foodWeight = (TextView) itemView.findViewById(R.id.foodWeight);
            feedingTime = (TextView) itemView.findViewById(R.id.feedingTime);
        }

        @Override
        public boolean onLongClick(View view) {
            listener.callback(getAdapterPosition());
            return true;
        }
    }
}
