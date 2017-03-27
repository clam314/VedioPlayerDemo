package com.clam314.videoplayerdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;

public class VideoViewActivity extends AppCompatActivity {
    private static final String TAG = VideoViewActivity.class.getSimpleName();
    private VideoView vvPlayer;
    private MediaController mmController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);
        String filePath = Config.getBasePath(this)+ File.separator+Config.videoName;

        vvPlayer = (VideoView)findViewById(R.id.vv_video);
//        获取视频的缩略图，另设置background可能会挡住播放
//        Bitmap bitmap = ThumbnailUtils.createVideoThumbnail(filePath, MediaStore.Images.Thumbnails.MICRO_KIND);
//        vvPlayer.setBackground(new BitmapDrawable(bitmap));
        mmController = new MediaController(this);
        File file = new File(filePath);
        if(file.exists()){
            Log.d(TAG,"filePath: "+filePath);
            vvPlayer.setVideoPath(filePath);
            vvPlayer.setMediaController(mmController);
            mmController.setMediaPlayer(vvPlayer);
            mmController.setPrevNextListeners(
                    new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(VideoViewActivity.this, "下一个",Toast.LENGTH_SHORT).show();
                }
            },      new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(VideoViewActivity.this, "上一个",Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
