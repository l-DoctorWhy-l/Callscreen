package com.example.callscreen;

public class StringCutter {

    public static String cutter(String str, int max_len) {
        if (str.length() >= max_len)
            str = str.substring(0, max_len) + "...";
        return str;
    }
}
