package com.csf.sample;

import android.app.Application;

public class AppController extends Application {

    private RestApi restApi;
    private static AppController instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }


    public static AppController create() {
        return instance;
    }

    public RestApi getRestApi() {
        if (restApi == null) {
            restApi = RestApiFactory.create();
        }
        return restApi;
    }

}
