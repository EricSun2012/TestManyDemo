package com.robot.anyDemo.IPC_Binder;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;

import com.robot.anyDemo.ICallback;
import com.robot.anyDemo.IRemoteService;
import com.robot.anyDemo.base.BaseActivity;
import com.robot.anyDemo.base.BasePresenter;

/**
 * 项目名称：TestManyDemo
 * 类描述：
 * 创建人：Eric
 * 创建时间：2020-02-28 11:11
 * 修改人：Eric
 * 修改时间：2020-02-28 11:11
 * 修改备注：
 */
public class BinderPresenter extends BasePresenter<BinderView> {
    private ServiceConnection serviceConnection;
    private IRemoteService mIRemoteService;
    private ICallback mCallback = new ICallback.Stub() {
        @Override
        public void onResult(ResponseVO vo) throws RemoteException {
            System.out.println("get name=" + vo.getName());
        }

        @Override
        public IBinder asBinder() {
            //这里需要把自己返回去，如果返回其他的对象，抱歉会一直报错到崩溃【别问我哪来这么深的领悟】
            return this;
        }
    };


    public BinderPresenter(BinderView baseView) {
        super(baseView);


        serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                mIRemoteService = IRemoteService.Stub.asInterface(iBinder);
                try {
                    mIRemoteService.registerCallback(mCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {
                try {
                    mIRemoteService.unregisterCallback(mCallback);
                    mIRemoteService = null;
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    public void init() {

        Intent intent = new Intent();
        intent.setPackage("com.robot.anyDemo");
        intent.setAction("com.robot.anyDemo.RemoteService");
        ((BaseActivity) baseView).bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    public void requestBody(String name) {
        if (null != mIRemoteService) {
            try {
                mIRemoteService.request(new RequestVO(name, ""));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
