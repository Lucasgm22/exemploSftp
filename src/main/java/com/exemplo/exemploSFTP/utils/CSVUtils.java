package com.exemplo.exemploSFTP.utils;

public class CSVUtils {

    public static String stringArrayToCsvLine(String[] array) {
        return String.join(";",array).concat("\n");
    }
}
