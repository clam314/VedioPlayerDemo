package com.clam314.videoplayerdemo;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MediaPlayerSurfaceViewActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = MediaPlayerSurfaceViewActivity.class.getSimpleName();
    private SurfaceView surfaceView;
    private SurfaceHolder surfaceHolder;
    private MediaPlayer mediaPlayer;
    private Button btStart,btPause,btStop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player_surface_view);

        setOnClickListener(this,findViewById(R.id.button1),findViewById(R.id.button2),findViewById(R.id.button3));

        surfaceView = (SurfaceView)findViewById(R.id.surface);
        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                mediaPlayer = new MediaPlayer();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mediaPlayer.setDisplay(surfaceHolder);//设置画面输出到surfaceView中
                try {
                    mediaPlayer.setDataSource(Config.getBasePath(MediaPlayerSurfaceViewActivity.this)+ File.separator+Config.videoName);
                    mediaPlayer.prepare();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }
        mediaPlayer.release();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                mediaPlayer.start();
                break;
            case R.id.button2:
                mediaPlayer.pause();
                break;
            case R.id.button3:
                mediaPlayer.stop();
                break;
        }
    }

    private void setOnClickListener(View.OnClickListener listener, View... views){
        for(View v : views){
            v.setOnClickListener(listener);
        }
    }
}
