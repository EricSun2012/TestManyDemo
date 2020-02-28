package com.robot.anyDemo;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.igexin.sdk.PushManager;
import com.robot.anyDemo.adapter.MyListAdapter;
import com.robot.anyDemo.push.DemoIntentService;
import com.robot.anyDemo.tools.UIUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private long lastTimestamp = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UIUtil.setContext(getApplicationContext());
        recyclerView = findViewById(R.id.recycleView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyListAdapter(this));

        long id = getMainLooper().getThread().getId();
        Logger.getGlobal().log(Level.INFO, "mainThreadId=" + id);
        EventBus.getDefault().register(this);

        // com.getui.demo.DemoPushService 为第三方自定义推送服务
        PushManager.getInstance().initialize(getApplicationContext(), null);
        PushManager.getInstance().registerPushIntentService(getApplicationContext(), DemoIntentService.class);
//        PushManager.getInstance().turnOnPush(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getMessage(String mesg) {

        NotificationChannel channel = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            //创建 通知通道  channelid和channelname是必须的（自己命名就好）
            channel = new NotificationChannel("msg", "alert", NotificationManager.IMPORTANCE_DEFAULT);
//            channel.enableLights(true);//是否在桌面icon右上角展示小红点
//            channel.setLightColor(Color.GREEN);//小红点颜色
//            channel.setShowBadge(false); //是否在久按桌面图标时显示此渠道的通知
        }
        Notification notification;
        //获取Notification实例   获取Notification实例有很多方法处理    在此我只展示通用的方法（虽然这种方式是属于api16以上，但是已经可以了，毕竟16以下的Android机很少了，如果非要全面兼容可以用）
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            //向上兼容 用Notification.Builder构造notification对象
            notification = new Notification.Builder(this, "msg")
                    .setContentTitle("通知栏标题")
                    .setContentText(mesg)
                    .setWhen(System.currentTimeMillis())
                    .setSmallIcon(R.drawable.push_small)
                    .setColor(Color.parseColor("#FEDA26"))
                    .setLargeIcon(BitmapFactory.decodeResource(this.getResources(), R.drawable.push))
                    .setTicker("巴士门")
                    .build();
        } else {
            //向下兼容 用NotificationCompat.Builder构造notification对象
            notification = new NotificationCompat.Builder(this)
                    .setContentTitle("通知栏标题")
                    .setContentText(mesg)
                    .setWhen(System.currentTimeMillis())
                    .setSmallIcon(R.drawable.push_small)
                    .setColor(Color.parseColor("#FEDA26"))
                    .setLargeIcon(BitmapFactory.decodeResource(this.getResources(), R.drawable.push))
                    .setTicker("巴士门")
                    .build();
        }


        //发送通知
        int notifiId = 1;
        //创建一个通知管理器
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManager.createNotificationChannel(channel);
        }
//        notificationManager.notify(notifiId, notification);


//        new AlertDialog.Builder(this)
//                .setCancelable(true)
//                .setTitle("通知")
//                .setMessage(mesg)
//                .setItems(new String[]{"开始", "结束"}, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        dialogInterface.dismiss();
//                    }
//                })
//                .show();
    }

    @Override
    public void onBackPressed() {

        if (System.currentTimeMillis() - lastTimestamp > 2000) {
            lastTimestamp = System.currentTimeMillis();
            Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
        } else {
            super.onBackPressed();
        }
    }
}
