package com.clam314.videoplayerdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setOnClickListener(this,findViewById(R.id.bt_1),findViewById(R.id.bt_2));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_1:
                startActivity(new Intent(this,VideoViewActivity.class));
                break;
            case R.id.bt_2:
                startActivity(new Intent(this,MediaPlayerSurfaceViewActivity.class));
                break;
        }
    }

    private void setOnClickListener(View.OnClickListener listener,View... views){
        for(View v : views){
            v.setOnClickListener(listener);
        }
    }
}
