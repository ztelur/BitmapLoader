package com.carpediem.homer.imagemaster;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;

import java.lang.ref.WeakReference;

/**
 * Created by homer on 16-8-29.
 */
public class Request {
    private String mUrl;
    private View mContainer;
    private WeakReference<Context> mContextRef;


    public Request(@NonNull  String url, @NonNull  View view, @NonNull Context context) {
        mUrl = url;
        mContainer = view;
        mContextRef = new WeakReference<Context>(context);
    }



}
