package com.clam314.videoplayerdemo;

import android.content.Context;
import android.os.Environment;

import java.io.File;

/**
 * Created by clam314 on 2017/3/27
 */

public class Config {
    public static final String videoName = "video.mp4";

    public static String getBasePath(Context context) {
        String strPath = null;
        if (!android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED)) {
            strPath = context.getFilesDir() + "/" + "Movies";
        } else{
            strPath = Environment.getExternalStorageDirectory() + "/" + "Movies";
        }
        File dir = new File(strPath);
        dir.mkdirs();
        return strPath;
    }
}
