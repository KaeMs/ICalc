package com.gmg.icalc.calculation;

/**
 * Created by KM on 8/30/2017. IC
 */

public class CalculateAddOptComprehensiveModel {
    private boolean TSFWD = false;
    private boolean EQVET = false;
    private boolean SRCC = false;
    private boolean TS = false;

    public boolean isTSFWD() {
        return TSFWD;
    }

    public void setTSFWD(boolean TSFWD) {
        this.TSFWD = TSFWD;
    }

    public boolean isEQVET() {
        return EQVET;
    }

    public void setEQVET(boolean EQVET) {
        this.EQVET = EQVET;
    }

    public boolean isSRCC() {
        return SRCC;
    }

    public void setSRCC(boolean SRCC) {
        this.SRCC = SRCC;
    }

    public boolean isTS() {
        return TS;
    }

    public void setTS(boolean TS) {
        this.TS = TS;
    }
}
