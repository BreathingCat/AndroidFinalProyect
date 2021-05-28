package com.eboshug.hugobosquep2;

import android.app.Application;

public class CustomApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        this.deleteDatabase("gamedatabase");
        new GameDataHelper(this).mockData();

    }
}
