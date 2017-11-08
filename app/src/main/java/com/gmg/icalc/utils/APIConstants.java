package com.gmg.icalc.utils;

/**
 * Created by GMG-Developer on 8/28/2017.
 */

public class APIConstants {
    public static final String API_URL = "http://www.asuransipremimurah.com/public";
    public static final String WEB_URL = "http://www.asuransipremimurah.com";

    public static final String LOGIN = "/api/login";
    public static final String SEND_OTOMATE = "/api/SendDocument";
    public static final String SEND_SOLITAIRE = "/api/SendSolitareDocument";
    public static final String SEND_COMPREHENSIVE = "/api/SendComprehensiveDocument";
    public static final String SEND_TLO = "/api/SendDocument";
    public static final int connectTimeout = 15;
    public static final int writeTimeout = 15;
    public static final int readTimeout = 30;
    public static final String CONNECTION_ERROR = "Connection error";
}
