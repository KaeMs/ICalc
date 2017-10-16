package com.gmg.icalc.utils;

import com.gmg.icalc.calculation.CalculateAddOptComprehensiveModel;
import com.gmg.icalc.calculation.PremiModel;

import java.util.Locale;

/**
 * Created by KM on 8/21/2017. IC
 */

public class CalculateUtils {

    public static final int OTOMATE = 1;
    public static final int OTOMATE_SMART = 2;
    public static final int OTOMATE_SOLITAIRE = 3;
    public static final String TSWFD = "101";
    public static final String EQVET = "102";
    public static final String SRCC = "103";
    public static final String TS = "104";
    public static final String ADDITIONAL_INFO_INTENT = "additionalInfo";
    public static final String CALCULATION_RESULT_INTENT = "calculationResult";

    private static double getOtomate (String vehiclePrice){
        int category = getCategory(vehiclePrice);
        if (category == 1) return 3.92;
        else if (category == 2) return 3.02;
        else if (category == 3) return 2.48;
        else if (category == 4) return 1.47;
        else return 1.25;
    }

    private static double getOtomateSmart (String vehiclePrice){
        int category = getCategory(vehiclePrice);
        if (category == 1) return 3.59;
        else if (category == 2) return 2.73;
        else if (category == 3) return 2.26;
        else if (category == 4) return 1.29;
        else return 1.11;
    }

    private static double getOtomateSolitaire (String vehiclePrice){
        int category = getCategory(vehiclePrice);
        if (category == 1) return 4.16;
        else if (category == 2) return 3.25;
        else if (category == 3) return 2.69;
        else if (category == 4) return 1.66;
        else return 1.44;
    }

    private static int getCategory(String vehiclePriceStr){
        int vehiclePrice = Integer.valueOf(vehiclePriceStr.replace(".", "").replace(",", ""));
        if (vehiclePrice >= 0 && vehiclePrice < 126000000){
            return 1;
        } else if (vehiclePrice >= 126000000 && vehiclePrice < 200000000){
            return 2;
        } else if (vehiclePrice >= 200000000 && vehiclePrice < 400000000){
            return 3;
        } else if (vehiclePrice >= 400000000 && vehiclePrice < 800000000){
            return 4;
        } else {
            return 5;
        }
    }

    public static PremiModel calculate(String vehiclePrice, int insuranceType, CalculateAddOptComprehensiveModel additionalOpts){
        PremiModel premiModel = new PremiModel();
        double percentage = 0;
        vehiclePrice = vehiclePrice.replace(".", "").replace(",", "");
        if (insuranceType == OTOMATE){
            percentage += getOtomate(vehiclePrice);
        } else if (insuranceType == OTOMATE_SMART){
            percentage += getOtomateSmart(vehiclePrice);
        } else {
            percentage += getOtomateSolitaire(vehiclePrice);
        }

        if (additionalOpts.isTSFWD()) percentage += 0.1;
        if (additionalOpts.isEQVET()) percentage += 0.1;
        if (additionalOpts.isSRCC()) percentage += 0.05;
        if (additionalOpts.isTS()) percentage += 0.05;

        percentage = percentage / 100;
        premiModel.setRate(percentage);
        premiModel.setPremi(Double.parseDouble(vehiclePrice) * percentage);
        return premiModel;
    }

    public static String numberToString(Double d){
        return String.format(Locale.getDefault(), "%1$,.2f", d);
    }

    public static String numberToString(int i){
        return String.valueOf(i);
    }

    public static Double stringToDouble(String s){
        s = s.replace("." , "").replace(",", "");
        return Double.parseDouble(s);
    }

    public static int stringToInt(String s){
        return Integer.parseInt(s);
    }
}
