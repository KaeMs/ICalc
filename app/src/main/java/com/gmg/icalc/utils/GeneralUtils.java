package com.gmg.icalc.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.TelephonyManager;

/**
 * Created by GMG-Developer on 8/28/2017.
 */

public class GeneralUtils {

    @SuppressLint("HardwareIds")
    public static String getImei(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String imei = "";
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            return telephonyManager.getImei();
        } else {
            return telephonyManager.getDeviceId();
        }
    }
}
