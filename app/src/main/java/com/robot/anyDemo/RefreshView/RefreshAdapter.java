package com.robot.anyDemo.RefreshView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.robot.anyDemo.R;

public class RefreshAdapter extends RecyclerView.Adapter<RefreshAdapter.RefreshViewHolder> {

    private Context mContext;

    public RefreshAdapter(Context context) {
        mContext = context;
    }

    private int rowCount = 0;

    @NonNull
    @Override
    public RefreshAdapter.RefreshViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_refresh, viewGroup, false);
        RefreshViewHolder holder = new RefreshViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RefreshAdapter.RefreshViewHolder viewHolder, int i) {
        viewHolder.titleView.setText("面包数量" + (i + 1));
        viewHolder.timeView.setText("2019-3-3");
        viewHolder.srcImageView.setImageDrawable(mContext.getResources().getDrawable(R.drawable.details_store_ic));
    }

    public void setRowCount(int count) {
        rowCount = count;
    }

    @Override
    public int getItemCount() {
        return rowCount;
    }


    public class RefreshViewHolder extends RecyclerView.ViewHolder {

        TextView titleView;
        TextView timeView;
        ImageView srcImageView;

        public RefreshViewHolder(@NonNull View itemView) {
            super(itemView);
            titleView = itemView.findViewById(R.id.refreshTitle);
            timeView = itemView.findViewById(R.id.time);
            srcImageView = itemView.findViewById(R.id.iv_anim);
        }
    }

}
