package com.example.ergedd_android2.app;

import android.app.Application;
import android.content.Intent;

public class MyApp extends Application {

    private static MyApp app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;


    }

    public static MyApp getInstance() {
        return app;
    }
}
