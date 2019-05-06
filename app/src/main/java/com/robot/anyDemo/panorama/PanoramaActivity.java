package com.robot.anyDemo.panorama;

import android.graphics.BitmapFactory;
import android.util.Log;

import com.google.vr.sdk.widgets.pano.VrPanoramaEventListener;
import com.google.vr.sdk.widgets.pano.VrPanoramaView;
import com.robot.anyDemo.R;
import com.robot.anyDemo.base.BaseActivity;

public class PanoramaActivity extends BaseActivity<PanoramaPresenter> {

    private String TAG = "PanoramaActivity";
    private VrPanoramaView allView;

    @Override
    protected PanoramaPresenter createPresenter() {
        return new PanoramaPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_panorama;
    }

    @Override
    public void initData() {
        setTitle("全景图");
    }

    @Override
    public void initView() {
        allView = findViewById(R.id.all_panorama);
        VrPanoramaView.Options paNormalOptions = new VrPanoramaView.Options();
//  mVrPanoramaView.setFullscreenButtonEnabled (false); //隐藏全屏模式按钮
        allView.setInfoButtonEnabled(false); //设置隐藏最左边信息的按钮
        allView.setStereoModeButtonEnabled(false); //设置隐藏立体模型的按钮
        allView.setEventListener(new ActivityEventListener()); //设置监听
        paNormalOptions.inputType = VrPanoramaView.Options.TYPE_MONO;
        //加载本地的图片源
        allView.loadImageFromBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.andes2), paNormalOptions);
    }

    private class ActivityEventListener extends VrPanoramaEventListener {
        /**
         * Called by pano widget on the UI thread when it's done loading the image.
         */
        @Override
        public void onLoadSuccess() {
            Log.e(TAG, "图片加载成功了 ");
        }

        /**
         * Called by pano widget on the UI thread on any asynchronous error.
         */
        @Override
        public void onLoadError(String errorMessage) {

            Log.e(TAG, "图片加载: " + errorMessage);
        }

        @Override
        public void onDisplayModeChanged(int newDisplayMode) {
            //改变显示模式时候（全屏模式和纸板模式）
            super.onDisplayModeChanged(newDisplayMode);
            Log.i(TAG, "onDisplayModeChanged------------>" + newDisplayMode);
        }

        @Override
        public void onClick() {
            super.onClick();
            //点击VrPanoramaView
            Log.i(TAG, "onClick------------>");
        }
    }


}
