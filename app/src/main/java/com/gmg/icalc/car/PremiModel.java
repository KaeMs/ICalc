package com.gmg.icalc.car;

/**
 * Created by KM on 10/16/2017. IC
 */

public class PremiModel {
    private double premi;
    private double rate;
    private double TSFWD;
    private double EQVET;
    private double SRCCTS;
    private double TS;
    private double personalAccidentDriver;
    private double personalAccidentPassenger;
    private double thirdParty;

    public PremiModel() {
        this.premi = 0.0;
        this.rate = 0.0;
        this.TSFWD = 0.0;
        this.EQVET = 0.0;
        this.SRCCTS = 0.0;
        this.TS = 0.0;
        this.personalAccidentDriver = 0.0;
        this.personalAccidentPassenger = 0.0;
        this.thirdParty = 0.0;
    }

    public double getPremi() {
        return premi;
    }

    public void setPremi(double premi) {
        this.premi = premi;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getTSFWD() {
        return TSFWD;
    }

    public void setTSFWD(double TSFWD) {
        this.TSFWD = TSFWD;
    }

    public double getEQVET() {
        return EQVET;
    }

    public void setEQVET(double EQVET) {
        this.EQVET = EQVET;
    }

    public double getSRCCTS() {
        return SRCCTS;
    }

    public void setSRCCTS(double SRCCTS) {
        this.SRCCTS = SRCCTS;
    }

    public double getTS() {
        return TS;
    }

    public void setTS(double TS) {
        this.TS = TS;
    }

    public double getPersonalAccidentDriver() {
        return personalAccidentDriver;
    }

    public void setPersonalAccidentDriver(double personalAccidentDriver) {
        this.personalAccidentDriver = personalAccidentDriver;
    }

    public double getPersonalAccidentPassenger() {
        return personalAccidentPassenger;
    }

    public void setPersonalAccidentPassenger(double personalAccidentPassenger) {
        this.personalAccidentPassenger = personalAccidentPassenger;
    }

    public double getThirdParty() {
        return thirdParty;
    }

    public void setThirdParty(double thirdParty) {
        this.thirdParty = thirdParty;
    }
}
