package com.example.desafio_password_strength_mvp.model;

import androidx.annotation.VisibleForTesting;

public class Verifier {

    public static final int WEAK = 0;
    public static final int MEDIUM = 1;
    public static final int STRONG = 2;
    public static final int VERY_STRONG = 3;

    public static int howSecurePassword(String text){
        if(!isMinimum(text))
            return WEAK;
        else if(!haveUpperCase(text))
            return MEDIUM;
        else if(!haveNumber(text))
            return STRONG;
        else
            return VERY_STRONG;
    }

    @VisibleForTesting
    protected static boolean isMinimum(String text){
        return text.length() >= 5;
    }

    @VisibleForTesting
    protected static boolean haveUpperCase(String text){
        return text.matches(".*[A-Z]+.*$");
    }

    @VisibleForTesting
    protected static boolean haveNumber(String text){
        return text.matches(".*[0-9]+.*$");
    }
}
