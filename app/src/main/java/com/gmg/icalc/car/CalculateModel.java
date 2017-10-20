package com.gmg.icalc.car;

/**
 * Created by KM on 8/21/2017. IC
 */

public class CalculateModel {
    private final String id;
    private final String name;

    public CalculateModel(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
