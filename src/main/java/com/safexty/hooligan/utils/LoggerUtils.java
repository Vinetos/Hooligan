package com.safexty.hooligan.utils;

import java.text.DateFormat;
import java.util.Date;

import static java.text.DateFormat.*;

public class LoggerUtils {

    private static final DateFormat shortDateFormat = getDateTimeInstance(SHORT, SHORT);

    public static void info(String message) {
        System.out.print(shortDateFormat.format(new Date()));
        System.out.println(" " + message);
    }

    public static void warn(String message) {
        System.out.print("[?] ");
        System.out.print(shortDateFormat.format(new Date()));
        System.out.println(" " + message);
    }

    public static void error(String message) {
        System.err.print("[!] ");
        System.err.print(shortDateFormat.format(new Date()));
        System.err.println(" " + message);
    }

}
