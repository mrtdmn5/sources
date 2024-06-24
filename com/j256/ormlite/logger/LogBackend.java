package com.j256.ormlite.logger;

/* loaded from: classes3.dex */
public interface LogBackend {
    boolean isLevelEnabled(Level level);

    void log(Level level, String str);

    void log(Level level, String str, Exception exc);
}
