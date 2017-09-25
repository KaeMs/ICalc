package com.gmg.icalc.calculation;

/**
 * Created by KM on 9/25/2017. KSM
 */

public class CalculateResultModel {
    private String vehicleType;
    private double vehiclePrice;
    private double premi;
    public static final String CALC_RESULT_EXTRA = "CALC_RESULT_EXTRA";


    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public double getVehiclePrice() {
        return vehiclePrice;
    }

    public void setVehiclePrice(double vehiclePrice) {
        this.vehiclePrice = vehiclePrice;
    }

    public double getPremi() {
        return premi;
    }

    public void setPremi(double premi) {
        this.premi = premi;
    }
}
