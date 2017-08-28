package com.gmg.icalc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

@SuppressLint("ApplySharedPref")
public class SharedPreferenceUtilities {

    public static final String SESSION_SP = "SESSION_SP";
    public static final String INIT_DATA_STEP = "INIT_DATA_STEP";
    public static final String USER_ID = "USER_ID";
    public static final String USER_EMAIL = "USER_EMAIL";
    public static final String USER_FIRST_NAME = "USER_FIRST_NAME";
    public static final String USER_LAST_NAME = "USER_LAST_NAME";
    public static final String USER_AGENCY = "USER_AGENCY";
    public static final String USER_DATE_JOIN = "USER_DATE_JOIN";
    public static final String USER_DATE_EXPIRED = "USER_DATE_EXPIRED";
    public static final String USER_PHOTO = "USER_PHOTO";
    public static final String USER_PHONE = "USER_PHONE";
    public static final String USER_LICENSE = "USER_LICENSE";
    public static final String USER_DEVICE_IMEI = "USER_DEVICE_IMEI";
    public static final String USER_STATUS = "USER_STATUS";
    public static final String USER_CREATED_AT = "USER_CREATED_AT";
    public static final String USER_UPDATED_AT = "USER_UPDATED_AT";
    public static final String USER_API_TOKEN = "USER_API_TOKEN";

    public static final String GUIDE_SP = "GUIDE_SP";
    public static final String GUIDE_MAIN_SCREEN = "GUIDE_MAIN_SCREEN";
    public static final String GUIDE_DRAWER = "GUIDE_DRAWER";


    private SharedPreferenceUtilities() {
        super();
    }

    private static void save(Context context, String prefsName, String prefsKey, String text) {
        SharedPreferences settings;
        SharedPreferences.Editor editor;

        //settings = PreferenceManager.getDefaultSharedPreferences(context);
        settings = context.getSharedPreferences(prefsName, Context.MODE_PRIVATE); //1
        editor = settings.edit(); //2

        editor.putString(prefsKey, text); //3

        editor.commit(); //4
    }

    private static String getValue(Context context, String prefsName, String prefsKey) {
        SharedPreferences settings;
        String text;

        //settings = PreferenceManager.getDefaultSharedPreferences(context);
        settings = context.getSharedPreferences(prefsName, Context.MODE_PRIVATE);
        text = settings.getString(prefsKey, null);
        return text;
    }

    public static void clearSharedPreference(Context context, String prefsName) {
        SharedPreferences settings;
        SharedPreferences.Editor editor;

        //settings = PreferenceManager.getDefaultSharedPreferences(context);
        settings = context.getSharedPreferences(prefsName, Context.MODE_PRIVATE);
        editor = settings.edit();

        editor.clear();
        editor.commit();
    }

    private static void removeValue(Context context, String prefsName, String prefsKey) {
        SharedPreferences settings;
        SharedPreferences.Editor editor;

        settings = context.getSharedPreferences(prefsName, Context.MODE_PRIVATE);
        editor = settings.edit();

        editor.remove(prefsKey);
        editor.commit();
    }

    public static String getFromSessionSP(Context context, String whatToGet) {
        return getValue(context, SESSION_SP,
                whatToGet);
    }

    public static String getFromGuideSP(Context context, String whatToGet) {
        return getValue(context, GUIDE_SP,
                whatToGet);
    }

    public static String getUserId(Context context){
        return getFromSessionSP(context, USER_ID);
    }

    public static void setUserInformation(Context context, String prefId, String whatToSave) {
        // If exist then remove the value
        if (getValue(context, SESSION_SP, prefId) != null) {
            removeValue(context, SESSION_SP, prefId);
            save(context, SESSION_SP, prefId, whatToSave);
        } else {
            save(context, SESSION_SP, prefId, whatToSave);
        }
    }
    public static void setUserInformation(Context context, String sharedPref, String prefId, String whatToSave) {
        // If exist then remove the value
        if (getValue(context, sharedPref, prefId) != null) {
            removeValue(context, sharedPref, prefId);
            save(context, sharedPref, prefId, whatToSave);
        } else {
            save(context, sharedPref, prefId, whatToSave);
        }
    }

    public static void removeUserInformation(Context context, String whatToRemove) {
        // If exist then remove the value
        if (getValue(context, SESSION_SP, whatToRemove) != null) {
            removeValue(context, SESSION_SP, whatToRemove);
        }
    }
    public static void removeUserInformation(Context context, String sharedPref, String whatToRemove) {
        // If exist then remove the value
        if (getValue(context, sharedPref, whatToRemove) != null) {
            removeValue(context, sharedPref, whatToRemove);
        }
    }
}
