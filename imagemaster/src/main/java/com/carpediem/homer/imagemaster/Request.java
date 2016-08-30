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
    private RequestHandler mHandler;

    public Request(@NonNull  String url, @NonNull  View view, @NonNull Context context) {
        mUrl = url;
        mContainer = view;
        mContextRef = new WeakReference<Context>(context);
    }

    public RequestHandler getHandler() {
        return mHandler;
    }

    public void setHandler(RequestHandler mHandler) {
        this.mHandler = mHandler;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    public View getContainer() {
        return mContainer;
    }

    public void setContainer(View mContainer) {
        this.mContainer = mContainer;
    }

    public WeakReference<Context> getmContextRef() {
        return mContextRef;
    }

    public void setmContextRef(WeakReference<Context> mContextRef) {
        this.mContextRef = mContextRef;
    }
}
