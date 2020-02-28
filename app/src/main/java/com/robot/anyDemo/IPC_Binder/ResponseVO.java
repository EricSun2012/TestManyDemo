package com.robot.anyDemo.IPC_Binder;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 项目名称：TestManyDemo
 * 类描述：
 * 创建人：Eric
 * 创建时间：2020-02-28 17:02
 * 修改人：Eric
 * 修改时间：2020-02-28 17:02
 * 修改备注：
 */
public class ResponseVO implements Parcelable {

    private String name;
    private String type;

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

    public ResponseVO() {

    }

    protected ResponseVO(Parcel in) {
        name = in.readString();
        type = in.readString();
    }

    public static final Creator<ResponseVO> CREATOR = new Creator<ResponseVO>() {
        @Override
        public ResponseVO createFromParcel(Parcel in) {
            return new ResponseVO(in);
        }

        @Override
        public ResponseVO[] newArray(int size) {
            return new ResponseVO[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(type);
    }
}
