package com.j256.ormlite.logger;

import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;

/* loaded from: classes3.dex */
public final class LoggerFactory {
    public static LogBackendType logBackendFactory;

    public static Logger getLogger(Class<?> cls) {
        LogBackendType valueOf;
        String name = cls.getName();
        if (logBackendFactory == null) {
            String property = System.getProperty("com.j256.simplelogger.backend");
            if (property != null) {
                try {
                    valueOf = LogBackendType.valueOf(property);
                } catch (IllegalArgumentException unused) {
                    new LocalLogBackend(LoggerFactory.class.getName()).printMessage(Level.WARNING, zzav$$ExternalSyntheticOutline0.m("Could not find valid log-type from system property 'com.j256.simplelogger.backend', value '", property, "'"), null);
                }
                logBackendFactory = valueOf;
            }
            LogBackendType[] values = LogBackendType.values();
            int length = values.length;
            int r2 = 0;
            while (true) {
                if (r2 < length) {
                    LogBackendType logBackendType = values[r2];
                    if (logBackendType.isAvailable()) {
                        valueOf = logBackendType;
                        break;
                    }
                    r2++;
                } else {
                    valueOf = LogBackendType.LOCAL;
                    break;
                }
            }
            logBackendFactory = valueOf;
        }
        return new Logger(logBackendFactory.createLogBackend(name));
    }
}
