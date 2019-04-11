package com.robot.anyDemo.download;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.robot.anyDemo.R;
import com.robot.anyDemo.base.BaseActivity;

public class DownloadActivity extends BaseActivity<DownloadPresenter> {

    private ViewGroup firstView;
    private ViewGroup secondView;
    private ViewGroup thirdView;
    private ViewGroup fourthView;
    private ViewGroup fifthView;
    private ProgressBar bar;

    private String downloadUrl = "http://fjdx.sc.chinaz.net/Files/DownLoad/pic9/201904/hpic827.rar";

    @Override
    protected DownloadPresenter createPresenter() {
        return new DownloadPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_download;
    }

    @Override
    public void initView() {
        firstView = findViewById(R.id.download_1);
        secondView = findViewById(R.id.download_2);
        thirdView = findViewById(R.id.download_3);
        fourthView = findViewById(R.id.download_4);
        fifthView = findViewById(R.id.download_5);

        bar = firstView.findViewById(R.id.download_progressbar);
        firstView.findViewById(R.id.download_now).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadEntity entity = presenter.startDownloadTask(downloadUrl, new DownloadListener() {
                    @Override
                    public void onProgress(int progress) {
                        bar.setProgress(progress);
                    }

                    @Override
                    public void onSuccess() {
                        bar.setProgress(100);
                        Toast.makeText(DownloadActivity.this, "下载完成", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailed() {

                    }

                    @Override
                    public void onPaused() {
                        Button button = firstView.findViewById(R.id.download_now);
                        button.setText("继续");
                    }

                    @Override
                    public void onCanceled() {

                    }
                });
                firstView.setTag(entity);
            }
        });
        firstView.findViewById(R.id.download_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Object obj = firstView.getTag();
                if (null != obj && obj instanceof DownloadEntity) {
                    DownloadEntity entity = (DownloadEntity) obj;
                    entity.pauseDownload();
                }
            }
        });

    }

    @Override
    public void initData() {
        setTitle("断点续传");
    }
}
