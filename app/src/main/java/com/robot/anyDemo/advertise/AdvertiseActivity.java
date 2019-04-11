package com.robot.anyDemo.advertise;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.robot.anyDemo.R;

import java.util.ArrayList;


/**
 * 展示轮播图
 */
public class AdvertiseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advertise);
        setTitle("轮播图");

        BannerView bannerView = findViewById(R.id.advertiseBanner);
        bannerView.setPagerAnimation(0);
        ArrayList<Drawable> drawables = new ArrayList<>();
        ArrayList<String> tips = new ArrayList<>();
        drawables.add(getResources().getDrawable(R.drawable.icon_share_qrcode));
        drawables.add(getResources().getDrawable(R.drawable.icon_share_information));
        drawables.add(getResources().getDrawable(R.drawable.icon_share_qrcode));
        drawables.add(getResources().getDrawable(R.drawable.icon_share_information));
        drawables.add(getResources().getDrawable(R.drawable.icon_share_qrcode));
        drawables.add(getResources().getDrawable(R.drawable.icon_share_information));

        tips.add("111111111111");
        tips.add("222222222222");
        tips.add("333333333333");
        tips.add("444444444444");
        tips.add("555555555555");
        tips.add("666666666666");
        tips.add("999999999999");

        bannerView.setDrawables(drawables, tips);


    }
}
