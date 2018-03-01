package com.nytechnology.nyimlib;

import android.app.Application;

import io.rong.imkit.NYAppManger;

/**
 * Created by 18513 on 2017/12/19.
 */

public class MyApplication extends Application{


    @Override
    public void onCreate() {
        super.onCreate();
//        NYAppManger.onCreate(getApplicationContext(),"p5tvi9dsphyw4");
        NYAppManger.initNYApp(getApplicationContext());
    }
}
