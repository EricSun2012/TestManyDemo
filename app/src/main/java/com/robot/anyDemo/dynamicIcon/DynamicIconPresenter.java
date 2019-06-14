package com.robot.anyDemo.dynamicIcon;

import android.app.Activity;
import android.content.ComponentName;
import android.content.pm.PackageManager;

import com.robot.anyDemo.base.BasePresenter;
import com.robot.anyDemo.base.BaseView;

public class DynamicIconPresenter extends BasePresenter {
    private PackageManager mPm;

    private ComponentName icon;
    private ComponentName defaultIcon;


    public DynamicIconPresenter(BaseView baseView) {
        super(baseView);
        mPm = ((Activity) baseView).getApplicationContext().getPackageManager();

        icon = new ComponentName(((Activity) baseView).getApplicationContext(), "com.robot.anyDemo.Test");
        defaultIcon = new ComponentName(((Activity) baseView).getApplicationContext(), "com.robot.anyDemo.Default");
    }

    public void changeDefaultIcon() {
        disableComponent(icon);
        enableComponent(defaultIcon);
    }

    public void changeIcon() {
        disableComponent(defaultIcon);
        enableComponent(icon);
    }


    private void enableComponent(ComponentName componentName) {
        mPm.setComponentEnabledSetting(componentName,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP);
    }

    private void disableComponent(ComponentName componentName) {
        mPm.setComponentEnabledSetting(componentName,
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP);
    }

}
