package com.carpediem.homer.imageloader;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.carpediem.homer.imagemaster.ImageMaster;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView view = (ImageView)findViewById(R.id.image);
        ImageMaster.load(this,"http://7xrxif.com1.z0.glb.clouddn.com/20160609-TCP/IP-TCPHead.png",view);
    }
}
