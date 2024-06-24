package com.animaconnected.secondo.utils.debugging;

import android.util.Log;
import com.animaconnected.logger.LibLogger;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.crashlytics.internal.common.CrashlyticsController;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoggerAndroid.kt */
/* loaded from: classes3.dex */
public final class LoggerAndroid implements LibLogger {
    public static final int $stable = 0;
    private final boolean isLogging;

    @Override // com.animaconnected.logger.LibLogger
    public boolean isLogging() {
        return this.isLogging;
    }

    @Override // com.animaconnected.logger.LibLogger
    public int logDebug(String tag, String string, Throwable th) {
        String tag2;
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(string, "string");
        tag2 = LoggerAndroidKt.getTag(tag);
        return Log.d(tag2, string, th);
    }

    @Override // com.animaconnected.logger.LibLogger
    public int logError(String tag, String string, Throwable th) {
        String tag2;
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(string, "string");
        tag2 = LoggerAndroidKt.getTag(tag);
        return Log.e(tag2, string, th);
    }

    @Override // com.animaconnected.logger.LibLogger
    public int logInfo(String tag, String string, Throwable th) {
        String tag2;
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(string, "string");
        tag2 = LoggerAndroidKt.getTag(tag);
        return Log.i(tag2, string, th);
    }

    @Override // com.animaconnected.logger.LibLogger
    public void logRemotely(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        try {
            CrashlyticsCore crashlyticsCore = FirebaseCrashlytics.getInstance().core;
            crashlyticsCore.getClass();
            long currentTimeMillis = System.currentTimeMillis() - crashlyticsCore.startTime;
            CrashlyticsController crashlyticsController = crashlyticsCore.controller;
            crashlyticsController.getClass();
            crashlyticsController.backgroundWorker.submit(new CrashlyticsController.AnonymousClass5(currentTimeMillis, text));
        } catch (IllegalStateException unused) {
        }
    }

    @Override // com.animaconnected.logger.LibLogger
    public int logVerbose(String tag, String string, Throwable th) {
        String tag2;
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(string, "string");
        tag2 = LoggerAndroidKt.getTag(tag);
        return Log.v(tag2, string, th);
    }

    @Override // com.animaconnected.logger.LibLogger
    public int logWarn(String tag, String string, Throwable th) {
        String tag2;
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(string, "string");
        tag2 = LoggerAndroidKt.getTag(tag);
        return Log.w(tag2, string, th);
    }

    @Override // com.animaconnected.logger.LibLogger
    public void recordExceptionRemotely(Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        try {
            FirebaseCrashlytics.getInstance().recordException(throwable);
        } catch (IllegalStateException unused) {
        }
    }
}
