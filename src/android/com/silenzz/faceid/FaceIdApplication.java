package com.silenzz.faceid;

import android.app.Application;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class FaceIdApplication extends Application {
    
    private static final String TAG = FaceIdApplication.class.getSimpleName();

    private static boolean debug;

    public void onCreate() {
        super.onCreate();
        setDebug(true);
    }

    public static boolean isDebug() {
        return debug;
    }

    public static void setDebug(boolean debug) {
        FaceIdApplication.debug = debug;
    }

}
