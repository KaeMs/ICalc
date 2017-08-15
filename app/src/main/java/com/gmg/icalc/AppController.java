package com.gmg.icalc;

import android.app.Application;
import android.content.Context;

/**
 * Created by KM on 8/15/2017. IC
 */

public class AppController extends Application {
//    public static Realm realm;
    private static boolean activityVisible;
    public static int screenWidth;

    @Override
    public void onCreate() {
        super.onCreate();
//        realm = buildDatabase();
    }

    public static boolean isActivityVisible() {
        return activityVisible;
    }

    public static void activityResumed() {
        activityVisible = true;
    }

    public static void activityPaused() {
        activityVisible = false;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
//        MultiDex.install(this);
    }

    /*public Realm buildDatabase(){
        Realm.init(getApplicationContext());
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name("FM.realm")
                .deleteRealmIfMigrationNeeded().build();
        Realm.setDefaultConfiguration(realmConfiguration);
        return Realm.getInstance(realmConfiguration);
    }*/
}
