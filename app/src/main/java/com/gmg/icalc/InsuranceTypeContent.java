package com.gmg.icalc;

/**
 * Created by KM on 11/6/2017. IC
 */

public enum  InsuranceTypeContent {
    OTOMATE("otomate", "Otomate"),
    OTOMATE_SMART("smart", "Otomate Smart"),
    OTOMATE_SOLITAIRE("solitaire", "Otomate Solitaire"),
    COMPREHENSIVE("comprehensive", "Comprehensive"),
    TOTAL_LOST("tlo", "Total Lost");

    private final String id;
    private final String name;
    InsuranceTypeContent(String id, String name){
        this.id = id;
        this.name = name;
    }
    public String getId() { return id; }
    public String getName() { return name; }
}
