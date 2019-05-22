package com.robot.anyDemo.RefreshView;

import android.os.Handler;
import android.support.v7.widget.RecyclerView;

import com.robot.anyDemo.R;
import com.robot.anyDemo.base.BaseActivity;
import com.robot.anyDemo.base.BasePresenter;
import com.ufo.dwrefresh.view.DWRefreshLayout;

public class RefreshActivity extends BaseActivity {
    private DWRefreshLayout refreshLayout;
    private RecyclerView recyclerView;
    private Handler mHandler = new Handler();

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_refresh;
    }

    @Override
    public void initView() {
        refreshLayout = findViewById(R.id.refresh_view);
        recyclerView = findViewById(R.id.recycleView);
        refreshLayout.setOnRefreshListener(new DWRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.setRefresh(false);
                    }
                },3000);
            }

            @Override
            public void onLoadMore() {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.setRefresh(false);
                    }
                },3000);
            }
        });
    }
}
