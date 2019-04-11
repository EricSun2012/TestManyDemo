package com.robot.anyDemo.download;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public class DownloadManager {
    private static DownloadManager instance = null;
    //    private HashMap<String, DownloadEntity> downCalls;
    private OkHttpClient mClient;
    private ExecutorService pool = null;


    public static DownloadManager getInstance() {
        if (null == instance) {
            synchronized (DownloadManager.class) {
                if (null == instance) {
                    instance = new DownloadManager();
                }
            }
        }
        return instance;
    }

    private DownloadManager() {
//        downCalls = new HashMap<>();
        mClient = new OkHttpClient.Builder().build();
        pool = new ThreadPoolExecutor(5, Integer.MAX_VALUE, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
    }


    public DownloadEntity download(String url, DownloadListener listener) {
        DownloadEntity entity = new DownloadEntity.Build().setClient(mClient).setUrl(url).setListner(listener).build();
//        downCalls.put(url, entity);
        pool.submit(entity);
        return entity;
    }

}
