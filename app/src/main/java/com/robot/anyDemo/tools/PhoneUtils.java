package com.robot.anyDemo.tools;

import android.content.Context;
import android.telephony.TelephonyManager;

public class PhoneUtils {
    /**
     * 获取手机IMSI号
     */
    public static String getIMSI(Context context) {
        TelephonyManager mTelephonyMgr = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String imsi = mTelephonyMgr.getSubscriberId();

        return imsi;
    }


    public static String getPhoneNumber(Context context) {


        TelephonyManager mTelephonyMgr = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String phone = mTelephonyMgr.getLine1Number();//获取本机号码
        return phone;
    }
}
