package com.sourabh.android.androidbasictourguide;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private List<BaseRecyclerViewModel> dataList;

    public CustomAdapter(LayoutInflater inflater, List<BaseRecyclerViewModel> dataList) {
        this.inflater = inflater;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.base_recycler_view_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, int position) {
        holder.bindData(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imageView)
        ImageView imageView;
        @BindView(R.id.title)
        TextView titleTextView;
        @BindView(R.id.details)
        TextView detailTextView;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindData(BaseRecyclerViewModel data) {
            if (data.getImageResource() != -1)
                imageView.setImageResource(data.getImageResource());
            else
                imageView.setVisibility(View.GONE);
            titleTextView.setText(data.getTitle());
            detailTextView.setText(data.getDetails());
        }
    }
}
