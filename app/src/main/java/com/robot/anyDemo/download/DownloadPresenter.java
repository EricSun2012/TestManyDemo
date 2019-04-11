package com.robot.anyDemo.download;

import com.robot.anyDemo.base.BasePresenter;
import com.robot.anyDemo.base.BaseView;

public class DownloadPresenter extends BasePresenter {
    public DownloadPresenter(BaseView baseView) {
        super(baseView);
    }


    public DownloadEntity startDownloadTask(String url, DownloadListener listener) {
        return DownloadManager.getInstance().download(url, listener);
    }

    public void pauseTask(DownloadEntity entity) {
        entity.pauseDownload();
    }

    public void cancelTask(DownloadEntity entity) {
        entity.cancelDownload();
    }
}
