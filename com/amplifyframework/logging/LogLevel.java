package com.amplifyframework.logging;

/* loaded from: classes.dex */
public enum LogLevel {
    VERBOSE,
    DEBUG,
    INFO,
    WARN,
    ERROR,
    NONE;

    public boolean above(LogLevel logLevel) {
        if (ordinal() > logLevel.ordinal()) {
            return true;
        }
        return false;
    }
}
