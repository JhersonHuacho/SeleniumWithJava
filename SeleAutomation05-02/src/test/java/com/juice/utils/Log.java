package com.juice.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
    private static final Logger log = LogManager.getLogger(Log.class);

    public static void info(String message) {
        Log.info(message);
    }

    public static void warn(String message) {
        Log.warn(message);
    }

    public static void fatal(String message) {
        Log.fatal(message);
    }

    public static void error(String message) {
        Log.error(message);
    }
}
