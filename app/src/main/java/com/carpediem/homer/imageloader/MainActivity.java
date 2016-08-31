package com.carpediem.homer.imageloader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.carpediem.homer.imagemaster.ImageMaster;

public class MainActivity extends AppCompatActivity {
    private ImageView mImageView;
    private ImageView mImageView2;
    private ImageView mImageView3;
    private ImageView mImageView4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = (ImageView)findViewById(R.id.image);
        mImageView2 = (ImageView)findViewById(R.id.image2);
        mImageView3 = (ImageView)findViewById(R.id.image3);
        mImageView4 = (ImageView)findViewById(R.id.image4);

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
//        options.inDensity = 160; //无dpi的文件夹下默认为160
//        options.inTargetDensity = 160; //屏幕
        Bitmap bm = BitmapFactory.decodeResource(getResources(),R.drawable.,options);
        Bitmap bm2 = BitmapFactory.decodeResource(getResources(),R.drawable.back);
        Log.e("test","---------------------------------");
        Log.e("test","the option value is " + options.inDensity + " " + options.inTargetDensity+" "+options.inPreferredConfig.toString());
        Log.e("test","bm size is " + bm.getByteCount()+" "+bm.getWidth()+" "+bm.getHeight());
        Log.e("test","bm2 size is " + bm2.getByteCount() + " " + bm2.getWidth() + " " + bm2.getHeight());
        mImageView.setImageBitmap(bm);
        mImageView2.setImageBitmap(bm2);

    }

    private void useInSampleSize() {

    }
}
