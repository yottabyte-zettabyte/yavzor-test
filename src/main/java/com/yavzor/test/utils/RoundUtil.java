package com.yavzor.test.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class RoundUtil {

    public static double round(double value, int places) {
        if (value >= 0) {
            return (long) (value * Math.pow(10, places) + 0.5) / Math.pow(10, places);
        } else {
            return (-1) * ((long) (Math.abs(value) * Math.pow(10, places) + 0.5) / Math.pow(10, places));
        }
    }
}
