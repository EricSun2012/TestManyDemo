package com.robot.anyDemo.room;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.robot.anyDemo.R;
import com.robot.anyDemo.base.BaseActivity;

import java.util.List;

public class RoomActivity extends BaseActivity<RoomPresenter> {

    private Button insertButton;
    private Button countButton;
    private Button showButton;
    private TextView contentText;


    @Override
    protected RoomPresenter createPresenter() {
        return new RoomPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_room;
    }

    @Override
    public void initView() {
        contentText = findViewById(R.id.room_content);

        insertButton = findViewById(R.id.room_insert);
        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AudioCache cache = new AudioCache();
                cache.setFileName("eee");
                presenter.saveAudioData(RoomActivity.this, cache);
                contentText.setText("insert success");
            }
        });
        countButton = findViewById(R.id.room_count);
        countButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = presenter.getAudioCount(RoomActivity.this);
                contentText.setText("count=" + count);
            }
        });

        showButton = findViewById(R.id.room_select);
        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<AudioCache> list = presenter.getAllOfAudio(RoomActivity.this);
                StringBuilder builder = new StringBuilder();
                for (AudioCache cache : list) {
                    builder.append("[");
                    builder.append(cache.getFileName());
                    builder.append("]\n");

                }
                contentText.setText(builder.toString());
            }
        });

    }

    @Override
    public void initData() {
        setTitle("Room使用");
    }
}
