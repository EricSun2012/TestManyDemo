package com.robot.anyDemo.IPC_Binder;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 项目名称：TestManyDemo
 * 类描述：
 * 创建人：Eric
 * 创建时间：2020-02-28 12:06
 * 修改人：Eric
 * 修改时间：2020-02-28 12:06
 * 修改备注：
 */
public class RequestVO implements Parcelable {

    private String name;
    private String type;

    public RequestVO(String name, String type) {
        this.name = name;
        this.type = type;
    }

    protected RequestVO(Parcel in) {
        name = in.readString();
        type = in.readString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(type);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<RequestVO> CREATOR = new Creator<RequestVO>() {
        @Override
        public RequestVO createFromParcel(Parcel in) {
            return new RequestVO(in);
        }

        @Override
        public RequestVO[] newArray(int size) {
            return new RequestVO[size];
        }
    };
}
