package com.carpediem.homer.imageloader;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.File;
import java.io.IOException;

public class IOActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_io);
        File cacheDir = getDiskCacheDir(this,"test");

        Log.e("test",cacheDir.getAbsolutePath());
        if (!cacheDir.exists()) {
            Log.e("test","the cache dir is not exsit");
            try {
                cacheDir.createNewFile();
                Log.e("test","create a new cache dir");
            } catch (IOException e ) {
                e.printStackTrace();
            }
        }
    }

    private File getDiskCacheDir(Context context, String uniqueName) {
        String cachePath;
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
            || !Environment.isExternalStorageRemovable()) {
            cachePath = context.getExternalCacheDir().getPath();
        } else {
            cachePath = context.getCacheDir().getPath();
        }
        return new File(cachePath + File.separator + uniqueName);
    }
}
