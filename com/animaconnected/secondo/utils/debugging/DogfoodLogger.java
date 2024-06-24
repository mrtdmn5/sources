package com.animaconnected.secondo.utils.debugging;

import android.content.Context;
import android.util.Log;
import com.animaconnected.logger.LibLogger;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.crashlytics.internal.common.CrashlyticsController;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DogfoodLogger.kt */
/* loaded from: classes3.dex */
public final class DogfoodLogger implements LibLogger {
    public static final int $stable = 8;
    private final Context context;
    private final SimpleDateFormat dateFormat;
    private final FileWriter fileWriter;
    private final boolean isLogging;

    public DogfoodLogger(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.fileWriter = new FileWriter("appLog", null, 0, 0, 0L, null, 62, null);
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX", Locale.ENGLISH);
        this.isLogging = true;
    }

    private final void log(Context context, String str, String str2, String str3, Throwable th) {
        if (th != null) {
            str3 = str3 + '\n' + ExceptionsKt.stackTraceToString(th);
        }
        this.fileWriter.append(context, this.dateFormat.format(new Date()) + "\t[" + str2 + "]\t[" + str + "]\t" + str3 + '\n');
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // com.animaconnected.logger.LibLogger
    public boolean isLogging() {
        return this.isLogging;
    }

    @Override // com.animaconnected.logger.LibLogger
    public int logDebug(String tag, String string, Throwable th) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(string, "string");
        log(this.context, tag, "Debug", string, th);
        return Log.d(tag, string, th);
    }

    @Override // com.animaconnected.logger.LibLogger
    public int logError(String tag, String string, Throwable th) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(string, "string");
        log(this.context, tag, "Error", string, th);
        return Log.e(tag, string, th);
    }

    @Override // com.animaconnected.logger.LibLogger
    public int logInfo(String tag, String string, Throwable th) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(string, "string");
        log(this.context, tag, "Info", string, th);
        return Log.i(tag, string, th);
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
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(string, "string");
        return Log.v(tag, string, th);
    }

    @Override // com.animaconnected.logger.LibLogger
    public int logWarn(String tag, String string, Throwable th) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(string, "string");
        log(this.context, tag, "Warn", string, th);
        return Log.w(tag, string, th);
    }

    @Override // com.animaconnected.logger.LibLogger
    public void recordExceptionRemotely(Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        try {
            FirebaseCrashlytics.getInstance().recordException(throwable);
        } catch (IllegalStateException unused) {
        }
    }

    public final Object savePendingDataToFile(Continuation<? super Unit> continuation) {
        Object flush = this.fileWriter.flush(this.context, continuation);
        if (flush == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return flush;
        }
        return Unit.INSTANCE;
    }
}
