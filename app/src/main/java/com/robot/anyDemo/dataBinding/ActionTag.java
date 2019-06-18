package com.robot.anyDemo.dataBinding;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.robot.anyDemo.BR;


/**
 * 项目名称：TestManyDemo
 * 类描述：
 * 创建人：Eric
 * 创建时间：2019-06-13 17:33
 * 修改人：Eric
 * 修改时间：2019-06-13 17:33
 * 修改备注：
 */
public class ActionTag extends BaseObservable {

    private String time;
    private int value;

    private String title;

    @Bindable
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Bindable
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    /*
     这里修改title内容后，将通知视图更新
     */
    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }
}
