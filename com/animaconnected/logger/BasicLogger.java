package com.animaconnected.logger;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: Log.kt */
/* loaded from: classes.dex */
public final class BasicLogger implements LibLogger {
    @Override // com.animaconnected.logger.LibLogger
    public boolean isLogging() {
        return false;
    }

    @Override // com.animaconnected.logger.LibLogger
    public int logDebug(String tag, String string, Throwable th) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(string, "string");
        System.out.print((Object) ("BasicLogger: D: tag: " + tag + " string: " + string + ' ' + th));
        return 0;
    }

    @Override // com.animaconnected.logger.LibLogger
    public int logError(String tag, String string, Throwable th) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(string, "string");
        System.out.print((Object) ("BasicLogger: E: tag: " + tag + " string: " + string + ' ' + th));
        return 0;
    }

    @Override // com.animaconnected.logger.LibLogger
    public int logInfo(String tag, String string, Throwable th) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(string, "string");
        System.out.print((Object) ("BasicLogger: I: tag: " + tag + " string: " + string + ' ' + th));
        return 0;
    }

    @Override // com.animaconnected.logger.LibLogger
    public void logRemotely(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        System.out.print((Object) "BasicLogger: Not Logging remotely: ".concat(text));
    }

    @Override // com.animaconnected.logger.LibLogger
    public int logVerbose(String tag, String string, Throwable th) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(string, "string");
        System.out.print((Object) ("BasicLogger: V: tag: " + tag + " string: " + string + ' ' + th));
        return 0;
    }

    @Override // com.animaconnected.logger.LibLogger
    public int logWarn(String tag, String string, Throwable th) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(string, "string");
        System.out.print((Object) ("BasicLogger: W: tag: " + tag + " string: " + string + ' ' + th));
        return 0;
    }

    @Override // com.animaconnected.logger.LibLogger
    public void recordExceptionRemotely(Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        System.out.print((Object) ("BasicLogger: Not Logging remotely: " + throwable));
    }
}
