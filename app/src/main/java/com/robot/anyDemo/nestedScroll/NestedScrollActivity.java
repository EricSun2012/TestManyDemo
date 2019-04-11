package com.robot.anyDemo.nestedScroll;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.robot.anyDemo.R;
import com.robot.anyDemo.base.BaseActivity;
import com.robot.anyDemo.base.BasePresenter;

public class NestedScrollActivity extends BaseActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_nestedscroll;
    }

    @Override
    public void initView() {
        super.initView();
        setTitle("NestedScroll");
        mRecyclerView = findViewById(R.id.list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new RecyclerView.Adapter() {
            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                View item = LayoutInflater.from(NestedScrollActivity.this)
                        .inflate(R.layout.item_main, null, false);
                return new Holder(item);
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                Holder holder = (Holder) viewHolder;
                holder.textView.setText("position=" + (i + 1));
            }

            @Override
            public int getItemCount() {
                return 20;
            }

            class Holder extends RecyclerView.ViewHolder {
                TextView textView;

                public Holder(View itemView) {
                    super(itemView);
                    textView = (TextView) itemView.findViewById(R.id.txt_title);
                }
            }
        });
    }

    @Override
    public void initData() {
        super.initData();
    }
}
