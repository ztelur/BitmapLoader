package com.carpediem.homer.imagemaster;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;

import java.io.IOException;
import java.io.InputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Response;

/**
 * Created by homer on 16-8-30.
 */
public class HttpClient {
    private OkHttpClient client;
    public HttpClient() {
        client = new OkHttpClient();
    }

    @Nullable
    protected Bitmap sendRequest(Request request) {
        Bitmap bm = null;
        try {
            okhttp3.Request originRequest = new okhttp3.Request.Builder().url(request.getUrl()).build();
            Response response = client.newCall(originRequest).execute();
            InputStream is = response.body().byteStream();
            bm = BitmapFactory.decodeStream(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bm;
    }

//    private void sendRequestAsyn(Request request) {
//        try {
//            okhttp3.Request originRequest = new okhttp3.Request.Builder().url(request.getUrl()).build();
//            client.newCall(originRequest).enqueue(new Callback() {
//                @Override
//                public void onFailure(Call call, IOException e) {
//
//                }
//
//                @Override
//                public void onResponse(Call call, Response response) throws IOException {
//
//                }
//            });
//            InputStream is = response.body().byteStream();
//            bm = BitmapFactory.decodeStream(is);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}
