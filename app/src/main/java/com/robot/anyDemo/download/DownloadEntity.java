package com.robot.anyDemo.download;

import android.os.Environment;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DownloadEntity implements Runnable {

    private OkHttpClient mClient;
    private String mUrl;
    private DownloadListener listener;

    private boolean isCanceled = false;

    private boolean isPaused = false;

    private int lastProgress;


    public static class Build {
        private String mUrl;
        private OkHttpClient mClient;
        private DownloadListener mListener;

        public Build setUrl(String url) {
            mUrl = url;
            return this;
        }

        public Build setClient(OkHttpClient client) {
            mClient = client;
            return this;
        }

        public Build setListner(DownloadListener listner) {
            mListener = listner;
            return this;
        }

        public DownloadEntity build() {
            DownloadEntity entity = new DownloadEntity(this);
            return entity;
        }
    }


    private DownloadEntity(Build build) {
        mClient = build.mClient;
        mUrl = build.mUrl;
        listener = build.mListener;
    }


    public void pauseDownload() {
        isPaused = true;
    }

    public void cancelDownload() {
        isCanceled = true;
    }

    private long getContentLength(String downloadUrl) {
        Request request = new Request.Builder().url(downloadUrl).build();
        try {
            Response response = mClient.newCall(request).execute();
            if (response != null && response.isSuccessful()) {
                long contentLength = response.body().contentLength();
                response.body().close();
                return contentLength;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }


    @NonNull
    public static String md5(String string) {
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(string.getBytes());
            StringBuilder result = new StringBuilder();
            for (byte b : bytes) {
                String temp = Integer.toHexString(b & 0xff);
                if (temp.length() == 1) {
                    temp = "0" + temp;
                }
                result.append(temp);
            }
            return result.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }


    @Override
    public void run() {
        InputStream is = null;
        RandomAccessFile savedFile = null;
        File file = null;
        long downloadLength = 0;   //记录已经下载的文件长度
        //文件下载地址
        //下载文件的名称
        String fileName = md5(mUrl);
        //下载文件存放的目录
        String directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
        //创建一个文件
        file = new File(directory + File.separator + fileName);
        if (file.exists()) {
            //如果文件存在的话，得到文件的大小
            downloadLength = file.length();
        }
        //得到下载内容的大小
        long contentLength = getContentLength(mUrl);
        if (contentLength == 0) {
            if (null != listener) {
                listener.onFailed();
                return;
            }
        } else if (contentLength == downloadLength) {
            //已下载字节和文件总字节相等，说明已经下载完成了
            if (null != listener) {
                listener.onSuccess();
                return;
            }
        }
        /**
         * HTTP请求是有一个Header的，里面有个Range属性是定义下载区域的，它接收的值是一个区间范围，
         * 比如：Range:bytes=0-10000。这样我们就可以按照一定的规则，将一个大文件拆分为若干很小的部分，
         * 然后分批次的下载，每个小块下载完成之后，再合并到文件中；这样即使下载中断了，重新下载时，
         * 也可以通过文件的字节长度来判断下载的起始点，然后重启断点续传的过程，直到最后完成下载过程。
         */
        Request request = new Request.Builder()
                .addHeader("RANGE", "bytes=" + downloadLength + "-")  //断点续传要用到的，指示下载的区间
                .url(mUrl)
                .build();
        try {
            Response response = mClient.newCall(request).execute();
            if (response != null) {
                is = response.body().byteStream();
                savedFile = new RandomAccessFile(file, "rw");
                savedFile.seek(downloadLength);//跳过已经下载的字节
                byte[] b = new byte[1024];
                int total = 0;
                int len;
                while ((len = is.read(b)) != -1) {
                    if (isCanceled) {
                        if (null != listener) {
                            listener.onCanceled();
                            return;
                        }
                    } else if (isPaused) {
                        if (null != listener) {
                            listener.onPaused();
                            return;
                        }
                    } else {
                        total += len;
                        savedFile.write(b, 0, len);
                        //计算已经下载的百分比
                        int progress = (int) ((total + downloadLength) * 100 / contentLength);
                        //注意：在doInBackground()中是不可以进行UI操作的，如果需要更新UI,比如说反馈当前任务的执行进度，
                        //可以调用publishProgress()方法完成。
//                        publishProgress(progress);
                        if (null != listener) {
                            listener.onProgress(progress);
                        }
                    }

                }
                response.body().close();
                if (null != listener) {
                    listener.onSuccess();
                    return;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
                if (savedFile != null) {
                    savedFile.close();
                }
                if (isCanceled && file != null) {
                    file.delete();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (null != listener) {
            listener.onFailed();
            return;
        }
    }
}
