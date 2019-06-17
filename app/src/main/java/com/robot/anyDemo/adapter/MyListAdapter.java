package com.robot.anyDemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.robot.anyDemo.RefreshView.RefreshActivity;
import com.robot.anyDemo.RxJava.RxActivity;
import com.robot.anyDemo.Scroller.ScrollerActivity;
import com.robot.anyDemo.ThridDimensional.ThirdDimensionActivity;
import com.robot.anyDemo.animate.AnimateActivity;
import com.robot.anyDemo.dataBinding.DataBindingActivity;
import com.robot.anyDemo.dataStructure.DataStructureActivity;
import com.robot.anyDemo.download.DownloadActivity;
import com.robot.anyDemo.dragger2.Dagger2Activity;
import com.robot.anyDemo.dynamicIcon.DynamicIconActivity;
import com.robot.anyDemo.gouwuche.BuyCarActivity;
import com.robot.anyDemo.R;
import com.robot.anyDemo.advertise.AdvertiseActivity;
import com.robot.anyDemo.mvp.MvpActivity;
import com.robot.anyDemo.nestedScroll.NestedScrollActivity;
import com.robot.anyDemo.panorama.PanoramaActivity;
import com.robot.anyDemo.retrofit.RetrofitActivity;
import com.robot.anyDemo.room.RoomActivity;
import com.robot.anyDemo.touchconflict.TouchConflictActivity;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.MyViewHolder> {

    private Context mContext;
    private String[] contents;

    public MyListAdapter(Context context) {
        mContext = context;
        contents = new String[]{"动画总结", "room初步使用", "RxJava",
                "购物车动画", "广告轮播图", "greendao配置使用[未]", "断点续传",
                "缓存配置[未]", "数据结构", "MVP结构", "retrofit&okhttp使用",
                "NestedScroll", "全景图", "3D动画", "Viewpager与Scrollerview冲突",
                "Dragger2", "Scroller应用", "刷新+骨架屏", "动态改变icon",
                "DataBinding", "等等"};
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
                        startActivityFromAdapter(AnimateActivity.class);
                    }
                    break;
                    case 1: {
                        startActivityFromAdapter(RoomActivity.class);
                    }
                    break;
                    case 2: {
                        startActivityFromAdapter(RxActivity.class);
                    }
                    break;
                    case 3: {
                        startActivityFromAdapter(BuyCarActivity.class);
                    }
                    break;
                    case 4: {
                        startActivityFromAdapter(AdvertiseActivity.class);
                    }
                    break;
                    case 6: {
                        startActivityFromAdapter(DownloadActivity.class);
                    }
                    break;
                    case 8: {
                        startActivityFromAdapter(DataStructureActivity.class);
                    }
                    break;
                    case 9: {
                        startActivityFromAdapter(MvpActivity.class);
                    }
                    break;
                    case 10: {
                        startActivityFromAdapter(RetrofitActivity.class);
                    }
                    break;
                    case 11: {
                        startActivityFromAdapter(NestedScrollActivity.class);
                    }
                    break;
                    case 12: {
                        startActivityFromAdapter(PanoramaActivity.class);
                    }
                    break;
                    case 13: {
                        startActivityFromAdapter(ThirdDimensionActivity.class);
                    }
                    break;
                    case 14: {
                        startActivityFromAdapter(TouchConflictActivity.class);
                    }
                    break;
                    case 15: {
                        startActivityFromAdapter(Dagger2Activity.class);
                    }
                    break;
                    case 16: {
                        startActivityFromAdapter(ScrollerActivity.class);
                    }
                    break;
                    case 17: {
                        startActivityFromAdapter(RefreshActivity.class);
                    }
                    break;
                    case 18: {
                        startActivityFromAdapter(DynamicIconActivity.class);
                    }
                    break;
                    case 19: {
                        startActivityFromAdapter(DataBindingActivity.class);
                    }
                    break;
                }
            }
        });

    }

    public void startActivityFromAdapter(Class objClass) {
        Intent mIntent = new Intent(mContext, objClass);
        mContext.startActivity(mIntent);
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
