package com.robot.anyDemo.push;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import androidx.core.app.NotificationCompat;

import com.igexin.sdk.GTIntentService;
import com.igexin.sdk.message.GTCmdMessage;
import com.igexin.sdk.message.GTNotificationMessage;
import com.igexin.sdk.message.GTTransmitMessage;

import org.greenrobot.eventbus.EventBus;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DemoIntentService extends GTIntentService {
    @Override
    public void onReceiveServicePid(Context context, int i) {
        System.out.println("pid=" + i);
    }

    @Override
    public void onReceiveClientId(Context context, String s) {
        System.out.println("clientId=" + s + "\ncurrentThreadId=" + Thread.currentThread().getId());
    }

    @Override
    public void onReceiveMessageData(Context context, GTTransmitMessage gtTransmitMessage) {
        String tempMsg = new String(gtTransmitMessage.getPayload());
        Logger.getGlobal().log(Level.INFO, gtTransmitMessage.getMessageId() + "=" + tempMsg);


        EventBus.getDefault().post(tempMsg);
    }

    @Override
    public void onReceiveOnlineState(Context context, boolean b) {

    }

    @Override
    public void onReceiveCommandResult(Context context, GTCmdMessage gtCmdMessage) {

    }

    @Override
    public void onNotificationMessageArrived(Context context, GTNotificationMessage gtNotificationMessage) {
        Logger.getGlobal().log(Level.INFO, gtNotificationMessage.getContent());
    }

    @Override
    public void onNotificationMessageClicked(Context context, GTNotificationMessage gtNotificationMessage) {
        Logger.getGlobal().log(Level.INFO, gtNotificationMessage.getContent() + "clicked");
    }
}
