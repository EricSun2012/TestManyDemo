// ICallback.aidl
package com.robot.anyDemo;

// Declare any non-default types here with import statements
//这个需要和java类包名路径一致，别问我是怎么知道的（反复报错后做的妥协）
import com.robot.anyDemo.IPC_Binder.ResponseVO;
interface ICallback {
    void onResult(in ResponseVO vo);
}
