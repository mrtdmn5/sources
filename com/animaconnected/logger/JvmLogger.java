package com.animaconnected.logger;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoggerJvm.kt */
/* loaded from: classes.dex */
public final class JvmLogger implements LibLogger {
    private final boolean isLogging = true;

    @Override // com.animaconnected.logger.LibLogger
    public boolean isLogging() {
        return this.isLogging;
    }

    @Override // com.animaconnected.logger.LibLogger
    public int logDebug(String tag, String string, Throwable th) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(string, "string");
        System.out.println((Object) (tag + ": " + string));
        return 1;
    }

    @Override // com.animaconnected.logger.LibLogger
    public int logError(String tag, String string, Throwable th) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(string, "string");
        System.out.println((Object) (tag + ": " + string));
        return 1;
    }

    @Override // com.animaconnected.logger.LibLogger
    public int logInfo(String tag, String string, Throwable th) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(string, "string");
        System.out.println((Object) (tag + ": " + string));
        return 1;
    }

    @Override // com.animaconnected.logger.LibLogger
    public void logRemotely(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
    }

    @Override // com.animaconnected.logger.LibLogger
    public int logVerbose(String tag, String string, Throwable th) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(string, "string");
        System.out.println((Object) (tag + ": " + string));
        return 1;
    }

    @Override // com.animaconnected.logger.LibLogger
    public int logWarn(String tag, String string, Throwable th) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(string, "string");
        System.out.println((Object) (tag + ": " + string));
        return 1;
    }

    @Override // com.animaconnected.logger.LibLogger
    public void recordExceptionRemotely(Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
    }
}
