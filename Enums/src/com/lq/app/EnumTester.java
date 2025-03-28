package com.lq.app;

import com.lq.enums.TirePressures;

public class EnumTester {

    public static void main(String[] args) {

        for (TirePressures t : TirePressures.values()) {
            System.out.println(t + "  " + t.getPressure());
        }
    }
}
