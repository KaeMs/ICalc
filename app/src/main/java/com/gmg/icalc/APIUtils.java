package com.gmg.icalc;

import android.content.Context;

import com.google.gson.Gson;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by KM on 10/16/2017. IC
 */

public class APIUtils {
    public static final int SUCCESS = 200;

    public static String getJsonStrFromClass(Object c){
        return new Gson().toJson(c);
    }

    public static RequestBody getJsonRequestBody(String clasStr){
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        return RequestBody.create(JSON, clasStr);
    }

    private static class JsonMsgClass {
        String Message;
    }
    public static String getResponse(Context context, int responseCode, String jsonStr){
        if (responseCode == SUCCESS){
            return jsonStr;
        } else {
            try {
                JsonMsgClass jsonMsgClass = new Gson().fromJson(jsonStr, JsonMsgClass.class);
                return jsonMsgClass.Message;
            } catch (Exception ex){
                return context.getString(R.string.error_connection);
            }
        }
    }
}
