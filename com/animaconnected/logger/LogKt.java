package com.animaconnected.logger;

import androidx.activity.result.ActivityResultRegistry$$ExternalSyntheticOutline0;
import kotlin.ExceptionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: Log.kt */
/* loaded from: classes.dex */
public final class LogKt {
    private static LibLogger currentLogger = new BasicLogger();

    public static final void debug(Object obj, String message, String tag, Throwable th, boolean z) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (currentLogger.isLogging()) {
            currentLogger.logDebug(tag, message, th);
        }
        if (z) {
            currentLogger.logRemotely("D:" + tag + ": " + message);
            if (th != null) {
                LibLogger libLogger = currentLogger;
                StringBuilder m = ActivityResultRegistry$$ExternalSyntheticOutline0.m("D:", tag, ": Error message: ");
                m.append(th.getMessage());
                m.append(". Stacktrace: ");
                m.append(ExceptionsKt.stackTraceToString(th));
                libLogger.logRemotely(m.toString());
            }
        }
    }

    public static /* synthetic */ void debug$default(Object obj, String str, String str2, Throwable th, boolean z, int r5, Object obj2) {
        if ((r5 & 2) != 0) {
            str2 = getTag(obj);
        }
        if ((r5 & 4) != 0) {
            th = null;
        }
        if ((r5 & 8) != 0) {
            z = false;
        }
        debug(obj, str, str2, th, z);
    }

    public static final int err(Object obj, String message, String tag, Throwable th, boolean z) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (z) {
            currentLogger.logRemotely(tag + ": " + message);
            if (th != null) {
                currentLogger.recordExceptionRemotely(th);
            }
        }
        return currentLogger.logError(tag, message, th);
    }

    public static /* synthetic */ int err$default(Object obj, String str, String str2, Throwable th, boolean z, int r5, Object obj2) {
        if ((r5 & 2) != 0) {
            str2 = getTag(obj);
        }
        if ((r5 & 4) != 0) {
            th = null;
        }
        if ((r5 & 8) != 0) {
            z = false;
        }
        return err(obj, str, str2, th, z);
    }

    public static final LibLogger getCurrentLogger() {
        return currentLogger;
    }

    private static final String getTag(Object obj) {
        String simpleName = Reflection.getOrCreateKotlinClass(obj.getClass()).getSimpleName();
        if (simpleName == null) {
            simpleName = "Unknown class";
        }
        if (simpleName.length() > 23) {
            String substring = simpleName.substring(0, 23);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            return substring;
        }
        return simpleName;
    }

    public static final void info(Object obj, String message, String tag, Throwable th, boolean z) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (currentLogger.isLogging()) {
            currentLogger.logInfo(tag, message, th);
        }
        if (z) {
            currentLogger.logRemotely("I:" + tag + ": " + message);
            if (th != null) {
                LibLogger libLogger = currentLogger;
                StringBuilder m = ActivityResultRegistry$$ExternalSyntheticOutline0.m("I:", tag, ": Error message: ");
                m.append(th.getMessage());
                m.append(". Stacktrace: ");
                m.append(ExceptionsKt.stackTraceToString(th));
                libLogger.logRemotely(m.toString());
            }
        }
    }

    public static /* synthetic */ void info$default(Object obj, String str, String str2, Throwable th, boolean z, int r5, Object obj2) {
        if ((r5 & 2) != 0) {
            str2 = getTag(obj);
        }
        if ((r5 & 4) != 0) {
            th = null;
        }
        if ((r5 & 8) != 0) {
            z = false;
        }
        info(obj, str, str2, th, z);
    }

    public static final void prepareLogger(LibLogger logger) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        LibLogger.logDebug$default(currentLogger, "init", "Initializing new logger", null, 4, null);
        currentLogger = logger;
        LibLogger.logDebug$default(logger, "init", "New logger initialized", null, 4, null);
    }

    public static final void verbose(Object obj, String message, String tag, Throwable th, boolean z) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (currentLogger.isLogging()) {
            currentLogger.logVerbose(tag, message, th);
            return;
        }
        if (z) {
            currentLogger.logRemotely("V:" + tag + ": " + message);
            if (th != null) {
                LibLogger libLogger = currentLogger;
                StringBuilder m = ActivityResultRegistry$$ExternalSyntheticOutline0.m("V:", tag, ": Error message: ");
                m.append(th.getMessage());
                m.append(". Stacktrace: ");
                m.append(ExceptionsKt.stackTraceToString(th));
                libLogger.logRemotely(m.toString());
            }
        }
    }

    public static /* synthetic */ void verbose$default(Object obj, String str, String str2, Throwable th, boolean z, int r5, Object obj2) {
        if ((r5 & 2) != 0) {
            str2 = getTag(obj);
        }
        if ((r5 & 4) != 0) {
            th = null;
        }
        if ((r5 & 8) != 0) {
            z = false;
        }
        verbose(obj, str, str2, th, z);
    }

    public static final void warn(Object obj, String message, String tag, Throwable th, boolean z) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (currentLogger.isLogging()) {
            currentLogger.logWarn(tag, message, th);
        }
        if (z) {
            currentLogger.logRemotely("W:" + tag + ": " + message);
            if (th != null) {
                LibLogger libLogger = currentLogger;
                StringBuilder m = ActivityResultRegistry$$ExternalSyntheticOutline0.m("W:", tag, ": Error message: ");
                m.append(th.getMessage());
                m.append(". Stacktrace: ");
                m.append(ExceptionsKt.stackTraceToString(th));
                libLogger.logRemotely(m.toString());
            }
        }
    }

    public static /* synthetic */ void warn$default(Object obj, String str, String str2, Throwable th, boolean z, int r5, Object obj2) {
        if ((r5 & 2) != 0) {
            str2 = getTag(obj);
        }
        if ((r5 & 4) != 0) {
            th = null;
        }
        if ((r5 & 8) != 0) {
            z = false;
        }
        warn(obj, str, str2, th, z);
    }

    public static /* synthetic */ void debug$default(Object obj, String str, Throwable th, boolean z, Function0 function0, int r5, Object obj2) {
        if ((r5 & 1) != 0) {
            str = getTag(obj);
        }
        if ((r5 & 2) != 0) {
            th = null;
        }
        if ((r5 & 4) != 0) {
            z = false;
        }
        debug(obj, str, th, z, (Function0<String>) function0);
    }

    public static /* synthetic */ void err$default(Object obj, String str, Throwable th, boolean z, Function0 function0, int r5, Object obj2) {
        if ((r5 & 1) != 0) {
            str = getTag(obj);
        }
        if ((r5 & 2) != 0) {
            th = null;
        }
        if ((r5 & 4) != 0) {
            z = false;
        }
        err(obj, str, th, z, (Function0<String>) function0);
    }

    public static /* synthetic */ void info$default(Object obj, String str, Throwable th, boolean z, Function0 function0, int r5, Object obj2) {
        if ((r5 & 1) != 0) {
            str = getTag(obj);
        }
        if ((r5 & 2) != 0) {
            th = null;
        }
        if ((r5 & 4) != 0) {
            z = false;
        }
        info(obj, str, th, z, (Function0<String>) function0);
    }

    public static /* synthetic */ void verbose$default(Object obj, String str, Throwable th, boolean z, Function0 function0, int r5, Object obj2) {
        if ((r5 & 1) != 0) {
            str = getTag(obj);
        }
        if ((r5 & 2) != 0) {
            th = null;
        }
        if ((r5 & 4) != 0) {
            z = false;
        }
        verbose(obj, str, th, z, (Function0<String>) function0);
    }

    public static /* synthetic */ void warn$default(Object obj, String str, Throwable th, boolean z, Function0 function0, int r5, Object obj2) {
        if ((r5 & 1) != 0) {
            str = getTag(obj);
        }
        if ((r5 & 2) != 0) {
            th = null;
        }
        if ((r5 & 4) != 0) {
            z = false;
        }
        warn(obj, str, th, z, (Function0<String>) function0);
    }

    public static final void err(Object obj, String tag, Throwable th, boolean z, Function0<String> message) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        if (currentLogger.isLogging() || z) {
            err(obj, message.invoke(), tag, th, z);
        }
    }

    public static final void debug(Object obj, String tag, Throwable th, boolean z, Function0<String> message) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        if (currentLogger.isLogging() || z) {
            debug(obj, message.invoke(), tag, th, z);
        }
    }

    public static final void info(Object obj, String tag, Throwable th, boolean z, Function0<String> block) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(block, "block");
        if (currentLogger.isLogging() || z) {
            info(obj, block.invoke(), tag, th, z);
        }
    }

    public static final void verbose(Object obj, String tag, Throwable th, boolean z, Function0<String> message) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        if (currentLogger.isLogging() || z) {
            verbose(obj, message.invoke(), tag, th, z);
        }
    }

    public static final void warn(Object obj, String tag, Throwable th, boolean z, Function0<String> block) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(block, "block");
        if (currentLogger.isLogging() || z) {
            warn(obj, block.invoke(), tag, th, z);
        }
    }
}
