package com.robot.anyDemo.IPC_Binder;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;

import androidx.annotation.Nullable;

import com.robot.anyDemo.ICallback;
import com.robot.anyDemo.IRemoteService;

import java.sql.SQLOutput;
import java.util.concurrent.CopyOnWriteArrayList;


/**
 * 项目名称：TestManyDemo
 * 类描述：
 * 创建人：Eric
 * 创建时间：2020-02-28 11:13
 * 修改人：Eric
 * 修改时间：2020-02-28 11:13
 * 修改备注：
 */
public class OtherService extends Service {

    private RemoteCallbackList<ICallback> iCallbacks;

    @Override
    public void onCreate() {
        super.onCreate();

        int pid = android.os.Process.myPid();
        System.out.println("service pid=" + pid);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        iCallbacks = new RemoteCallbackList<>();
        return mBinder;
    }


    private final IRemoteService.Stub mBinder = new IRemoteService.Stub() {

        @Override
        public void request(RequestVO vo) throws RemoteException {
            sendResponse(vo.getName());
        }

        @Override
        public void registerCallback(ICallback cb) throws RemoteException {
            if (null != cb) {
                iCallbacks.register(cb);
            }
        }

        @Override
        public void unregisterCallback(ICallback cb) throws RemoteException {
            if (null != cb) {
                iCallbacks.unregister(cb);
            }
        }
    };

    private void sendResponse(String name) {
        ResponseVO vo = new ResponseVO();
        vo.setName(name);
        int len = iCallbacks.beginBroadcast();
        for (int i = 0; i < len; i++) {
            try {
                iCallbacks.getBroadcastItem(i).onResult(vo);
            } catch (RemoteException e) {

            }
        }
    }
}
