package com.gmg.icalc;

import com.gmg.icalc.utils.APIConstants;

/**
 * Created by KM on 11/6/2017. IC
 */

public enum InsuranceTypeContent {
    OTOMATE("otomate", "Otomate", APIConstants.SEND_OTOMATE),
    OTOMATE_SMART("smart", "Otomate Smart", APIConstants.SEND_OTOMATE),
    OTOMATE_SOLITAIRE("solitaire", "Otomate Solitaire", APIConstants.SEND_SOLITAIRE),
    COMPREHENSIVE("comprehensive", "Comprehensive", APIConstants.SEND_COMPREHENSIVE),
    TOTAL_LOST("tlo", "Total Lost", APIConstants.SEND_TLO);

    private final String id;
    private final String name;
    private final String url;

    InsuranceTypeContent(String id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public static String getAppropiateUrl(String type) {
        switch (type) {
            case "otomate":
                return OTOMATE.getUrl();
            case "smart":
                return OTOMATE_SMART.getUrl();
            case "solitaire":
                return OTOMATE_SOLITAIRE.getUrl();
            case "comprehensive":
                return COMPREHENSIVE.getUrl();
            case "tlo":
                return TOTAL_LOST.getUrl();
            default:
                return "";
        }
    }
}
