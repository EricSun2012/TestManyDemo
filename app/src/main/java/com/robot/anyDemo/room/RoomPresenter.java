package com.robot.anyDemo.room;

import android.content.Context;

import com.robot.anyDemo.base.BasePresenter;
import com.robot.anyDemo.base.BaseView;

import java.util.List;

public class RoomPresenter extends BasePresenter {
    public RoomPresenter(BaseView baseView) {
        super(baseView);
    }


    protected void saveAudioData(Context context, AudioCache cache) {
        AppDatabase.getInstance(context).getAudioCacheDao().insertAudioFile(cache);
    }

    protected int getAudioCount(Context context) {
        return AppDatabase.getInstance(context).getAudioCacheDao().sizeOfAudio();
    }

    protected List<AudioCache> getAllOfAudio(Context context) {
        return AppDatabase.getInstance(context).getAudioCacheDao().getAllData();
    }
}
