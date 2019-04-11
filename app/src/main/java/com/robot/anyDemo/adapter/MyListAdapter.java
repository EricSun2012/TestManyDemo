package com.robot.anyDemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.robot.anyDemo.RxJava.RxActivity;
import com.robot.anyDemo.animate.AnimateActivity;
import com.robot.anyDemo.dataStructure.DataStructureActivity;
import com.robot.anyDemo.download.DownloadActivity;
import com.robot.anyDemo.gouwuche.BuyCarActivity;
import com.robot.anyDemo.R;
import com.robot.anyDemo.advertise.AdvertiseActivity;
import com.robot.anyDemo.mvp.MvpActivity;
import com.robot.anyDemo.nestedScroll.NestedScrollActivity;
import com.robot.anyDemo.retrofit.RetrofitActivity;
import com.robot.anyDemo.room.RoomActivity;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.MyViewHolder> {

    private Context mContext;
    private String[] contents;

    public MyListAdapter(Context context) {
        mContext = context;
        contents = new String[]{"动画总结", "room初步使用", "RxJava", "购物车动画", "广告轮播图", "greendao配置使用[未]", "断点续传", "缓存配置[未]", "数据结构", "MVP结构", "retrofit&okhttp使用", "NestedScroll", "等等"};
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_main, null);
        MyViewHolder holder = new MyViewHolder(view);
        holder.title = view.findViewById(R.id.txt_title);
        holder.contentView = view.findViewById(R.id.mainView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        myViewHolder.title.setText(contents[i]);
        myViewHolder.contentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (i) {
                    case 0: {
                        Intent mIntent = new Intent(mContext, AnimateActivity.class);
                        mContext.startActivity(mIntent);
                    }
                    break;
                    case 1: {
                        Intent mIntent = new Intent(mContext, RoomActivity.class);
                        mContext.startActivity(mIntent);
                    }
                    break;
                    case 2: {
                        Intent mIntent = new Intent(mContext, RxActivity.class);
                        mContext.startActivity(mIntent);
                    }
                    break;
                    case 3: {
                        Intent mIntent = new Intent(mContext, BuyCarActivity.class);
                        mContext.startActivity(mIntent);
                    }
                    break;
                    case 4: {
                        Intent mIntent = new Intent(mContext, AdvertiseActivity.class);
                        mContext.startActivity(mIntent);
                    }
                    break;
                    case 6: {
                        Intent mIntent = new Intent(mContext, DownloadActivity.class);
                        mContext.startActivity(mIntent);
                    }
                    break;
                    case 8: {
                        Intent mIntent = new Intent(mContext, DataStructureActivity.class);
                        mContext.startActivity(mIntent);
                    }
                    break;
                    case 9: {
                        Intent mIntent = new Intent(mContext, MvpActivity.class);
                        mContext.startActivity(mIntent);
                    }
                    break;
                    case 10: {
                        Intent mIntent = new Intent(mContext, RetrofitActivity.class);
                        mContext.startActivity(mIntent);
                    }
                    break;
                    case 11: {
                        Intent mIntent = new Intent(mContext, NestedScrollActivity.class);
                        mContext.startActivity(mIntent);
                    }
                    break;
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return contents.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private View contentView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
