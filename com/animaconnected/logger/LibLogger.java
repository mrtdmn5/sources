package com.animaconnected.logger;

/* compiled from: Log.kt */
/* loaded from: classes.dex */
public interface LibLogger {
    static /* synthetic */ int logDebug$default(LibLogger libLogger, String str, String str2, Throwable th, int r4, Object obj) {
        if (obj == null) {
            if ((r4 & 4) != 0) {
                th = null;
            }
            return libLogger.logDebug(str, str2, th);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logDebug");
    }

    static /* synthetic */ int logError$default(LibLogger libLogger, String str, String str2, Throwable th, int r4, Object obj) {
        if (obj == null) {
            if ((r4 & 4) != 0) {
                th = null;
            }
            return libLogger.logError(str, str2, th);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logError");
    }

    static /* synthetic */ int logInfo$default(LibLogger libLogger, String str, String str2, Throwable th, int r4, Object obj) {
        if (obj == null) {
            if ((r4 & 4) != 0) {
                th = null;
            }
            return libLogger.logInfo(str, str2, th);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logInfo");
    }

    static /* synthetic */ int logVerbose$default(LibLogger libLogger, String str, String str2, Throwable th, int r4, Object obj) {
        if (obj == null) {
            if ((r4 & 4) != 0) {
                th = null;
            }
            return libLogger.logVerbose(str, str2, th);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logVerbose");
    }

    static /* synthetic */ int logWarn$default(LibLogger libLogger, String str, String str2, Throwable th, int r4, Object obj) {
        if (obj == null) {
            if ((r4 & 4) != 0) {
                th = null;
            }
            return libLogger.logWarn(str, str2, th);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logWarn");
    }

    boolean isLogging();

    int logDebug(String str, String str2, Throwable th);

    int logError(String str, String str2, Throwable th);

    int logInfo(String str, String str2, Throwable th);

    void logRemotely(String str);

    int logVerbose(String str, String str2, Throwable th);

    int logWarn(String str, String str2, Throwable th);

    void recordExceptionRemotely(Throwable th);
}
