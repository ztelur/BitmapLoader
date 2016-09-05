package com.carpediem.homer.imageloader;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.carpediem.homer.imagemaster.ImageMaster;

import java.io.File;

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
        Button button = (Button)findViewById(R.id.button);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    useMatric();
//                    clipBitmap();
//                    circleCornerBitmap();
                    useInBitmap();
                }
            });
        }

//        startActivity(new Intent(this,BlogActivity.class));
    }
    private void circleCornerBitmap() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inMutable = true;
        Bitmap bm = BitmapFactory.decodeResource(getResources(),R.drawable.back,options);

        int width = bm.getWidth();
        int height = bm.getHeight();
        Bitmap background = Bitmap.createBitmap(width,height, Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(background);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        Log.e("test",bm.isMutable() + " ");
        int roundLength = (width + height) / 2 / 10;
        RectF rect = new RectF(0,0,width/2,height/2);
        canvas.drawRoundRect(rect,roundLength,roundLength,paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bm,0,0,paint);

//        canvas.drawBitmap(bm,0,0,paint);
        mImageView.setImageBitmap(background);
    }

    // use canvas.clipPath
    private void circleCornerBitmap2() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inMutable = true;
        Bitmap bm = BitmapFactory.decodeResource(getResources(),R.drawable.back,options);
        int width = bm.getWidth();
        int height = bm.getHeight();

        Canvas canvas = new Canvas(bm);
        Path path = new Path();
//        path.addRoundRect();
//        path.addRoundRect(0,0,width,height,width/10,height/10, Path.Direction.CCW);

//        canvas
    }


    private void saveBitmap() {

    }

    private void calSize() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
//        options.inDensity = 160; //无dpi的文件夹下默认为160
//        options.inTargetDensity = 160; //屏幕
        Bitmap bm = BitmapFactory.decodeResource(getResources(),R.drawable.back,options);
        Bitmap bm2 = BitmapFactory.decodeResource(getResources(),R.drawable.back);
//        Log.e("test","---------------------------------");
//        Log.e("test","the option value is " + options.inDensity + " " + options.inTargetDensity+" "+options.inPreferredConfig.toString());
//        Log.e("test","bm size is " + bm.getByteCount()+" "+bm.getWidth()+" "+bm.getHeight());
//        Log.e("test","bm2 size is " + bm2.getByteCount() + " " + bm2.getWidth() + " " + bm2.getHeight());
        mImageView.setImageBitmap(bm);
        mImageView2.setImageBitmap(bm2);
    }
    private void useInSample() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        Bitmap bm = BitmapFactory.decodeResource(getResources(),R.drawable.back,options);
        Log.e("test"," w  and h is" + options.outWidth + " " + options.outHeight);
        Log.e("test"," the view w and h are " + mImageView4.getWidth() + " " + mImageView4.getMeasuredHeight());

        int rawWidth = options.outWidth;
        int rawHeight = options.outHeight;
        int targetWidth = mImageView4.getMeasuredWidth();
        int targetHeight = mImageView4.getMeasuredHeight();
        int inSampleSize = 0;

        if (rawHeight > targetHeight || rawWidth > targetWidth) {
            float ratioWidth = (float) rawWidth / targetHeight;
            float ratioHeight = (float) rawHeight / targetHeight;
            inSampleSize = (int)Math.min(ratioHeight,ratioWidth);
        }
        inSampleSize = Math.max(1,inSampleSize);
        Log.e("test","the inSampleSize is" + inSampleSize);
        options.inJustDecodeBounds = false;
        options.inSampleSize = inSampleSize;

        bm = BitmapFactory.decodeResource(getResources(),R.drawable.back,options);
        Log.e("test","the bitmap is" + bm.getByteCount() + " w is " + bm.getWidth() + " h is " + bm.getHeight());
        //TODO:查看ImageView是否在内部收缩了图片
        mImageView4.setImageBitmap(bm);
    }


    private void useMatric() {
        Runtime runtime = Runtime.getRuntime();
        Log.e("test","max total free" + runtime.maxMemory() + " " + runtime.totalMemory() + " " + runtime.freeMemory());
        Bitmap bm = BitmapFactory.decodeResource(getResources(),R.drawable.back);
        Log.e("test","the origin bitmap size is " + bm.getByteCount());
        Matrix matrix = new Matrix();
//        matrix.postScale(0.5f,0.5f);
        matrix.postRotate(40);
        Bitmap bm2 = Bitmap.createBitmap(bm,0,0,bm.getWidth(),bm.getHeight(),matrix,true);
        Log.e("test","the scaled bitmap size is " + bm2.getByteCount());
//        mImageView4.setImageBitmap(bm2);
        Log.e("test","max total free" + runtime.maxMemory() + " " + runtime.totalMemory() + " " + runtime.freeMemory());

        bm.recycle();
        bm2.recycle();
    }

    private void clipBitmap() {
        Bitmap bm = BitmapFactory.decodeResource(getResources(),R.drawable.back);
        Bitmap bm2 = Bitmap.createBitmap(bm,0,0,bm.getWidth()/2,bm.getHeight()/2);
        mImageView.setImageBitmap(bm2);
    }
    private void checkFile() {

    }

    public File getDiskCacheDir(Context context, String uniqueName) {
        return null;
    }

    private void useInBitmap() {
        Bitmap bm = BitmapFactory.decodeResource(getResources(),R.drawable.back);

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inBitmap = bm;

        Bitmap bm2 = BitmapFactory.decodeResource(getResources(),R.drawable.back,options);
        if (bm2 == bm) {
            Log.e("test","equals");
        } else {
            Log.e("test","not equals");
        }
        mImageView.setImageBitmap(bm2);

    }

    private void usePalette() {

    }
}
