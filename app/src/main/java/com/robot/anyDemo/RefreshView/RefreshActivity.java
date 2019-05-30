package com.robot.anyDemo.RefreshView;

import android.os.Handler;
import android.support.v7.widget.RecyclerView;

import com.robot.anyDemo.R;
import com.robot.anyDemo.base.BaseActivity;
import com.robot.anyDemo.base.BasePresenter;
import com.trycatch.mysnackbar.Prompt;
import com.trycatch.mysnackbar.TSnackbar;
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

//                        final ViewGroup viewGroup = (ViewGroup) findViewById(android.R.id.content).getRootView();//注意getRootView()最为重要，直接关系到TSnackBar的位置
//                snackBar.setPromptThemBackground(Prompt.SUCCESS).setText("登录成功").setDuration(TSnackbar.LENGTH_LONG).show();
//                snackBar.setPromptThemBackground(Prompt.ERROR).setText("登录失败").setDuration(TSnackbar.LENGTH_LONG).show();
                        TSnackbar.make(refreshLayout, "网络已连接", TSnackbar.LENGTH_LONG, TSnackbar.APPEAR_FROM_TOP_TO_DOWN).setPromptThemBackground(Prompt.SUCCESS).show();
//                TSnackbar.make(viewGroup, "网络未连接", TSnackbar.LENGTH_LONG, TSnackbar.APPEAR_FROM_TOP_TO_DOWN).setPromptThemBackground(Prompt.WARNING).show();
//                        TSnackbar snackBar = TSnackbar.make(refreshLayout, "正在加载中...", TSnackbar.LENGTH_INDEFINITE, TSnackbar.APPEAR_FROM_TOP_TO_DOWN);
//                        snackBar.setAction("取消", new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//
//                            }
//                        });
//                        snackBar.setPromptThemBackground(Prompt.SUCCESS);
//                        snackBar.addIconProgressLoading(0, true, false);
//                        snackBar.show();

                    }
                }, 3000);
            }

            @Override
            public void onLoadMore() {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.setRefresh(false);
                        TSnackbar.make(refreshLayout, "网络未连接", TSnackbar.LENGTH_LONG, TSnackbar.APPEAR_FROM_BOTTOM_TO_TOP).setPromptThemBackground(Prompt.WARNING).show();

                    }
                }, 3000);
            }
        });
    }
}
