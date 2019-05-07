package com.robot.anyDemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.robot.anyDemo.adapter.MyListAdapter;
import com.robot.anyDemo.tools.UIUtil;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private long lastTimestamp = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UIUtil.setContext(getApplicationContext());
        recyclerView = findViewById(R.id.recycleView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyListAdapter(this));
    }


    @Override
    public void onBackPressed() {

        if (System.currentTimeMillis() - lastTimestamp > 2000) {
            lastTimestamp = System.currentTimeMillis();
            Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
        } else {
            super.onBackPressed();
        }
    }
}
