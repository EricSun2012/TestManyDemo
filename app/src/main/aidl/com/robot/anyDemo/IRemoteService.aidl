// IRemoteService.aidl
package com.robot.anyDemo;

//这个需要和java类包名路径一致，别问我是怎么知道的（反复报错后做的妥协）
import com.robot.anyDemo.IPC_Binder.RequestVO;
import com.robot.anyDemo.ICallback;

// Declare any non-default types here with import statements

interface IRemoteService {
    void request(in RequestVO vo);
    void registerCallback(in ICallback cb);
    void unregisterCallback(in ICallback cb);
}
