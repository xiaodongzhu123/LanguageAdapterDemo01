package com.example.screenadapterdemo03;

import android.app.Application;

/**
 * Created by lenovo on 2016/9/29.
 */
public class MyApp extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
