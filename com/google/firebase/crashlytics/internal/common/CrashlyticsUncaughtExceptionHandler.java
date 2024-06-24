package com.google.firebase.crashlytics.internal.common;

import android.util.Log;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.common.CrashlyticsController;
import com.google.firebase.crashlytics.internal.settings.SettingsController;
import com.google.firebase.crashlytics.internal.settings.SettingsProvider;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public final class CrashlyticsUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    public final CrashListener crashListener;
    public final Thread.UncaughtExceptionHandler defaultHandler;
    public final AtomicBoolean isHandlingException = new AtomicBoolean(false);
    public final CrashlyticsNativeComponent nativeComponent;
    public final SettingsProvider settingsProvider;

    /* loaded from: classes3.dex */
    public interface CrashListener {
    }

    public CrashlyticsUncaughtExceptionHandler(CrashlyticsController.AnonymousClass1 anonymousClass1, SettingsController settingsController, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, CrashlyticsNativeComponent crashlyticsNativeComponent) {
        this.crashListener = anonymousClass1;
        this.settingsProvider = settingsController;
        this.defaultHandler = uncaughtExceptionHandler;
        this.nativeComponent = crashlyticsNativeComponent;
    }

    public final boolean shouldRecordUncaughtException(Thread thread, Throwable th) {
        if (thread == null) {
            Log.e("FirebaseCrashlytics", "Crashlytics will not record uncaught exception; null thread", null);
            return false;
        }
        if (th == null) {
            Log.e("FirebaseCrashlytics", "Crashlytics will not record uncaught exception; null throwable", null);
            return false;
        }
        boolean z = true;
        if (!this.nativeComponent.hasCrashDataForCurrentSession()) {
            return true;
        }
        if (!Log.isLoggable("FirebaseCrashlytics", 3)) {
            z = false;
        }
        if (z) {
            Log.d("FirebaseCrashlytics", "Crashlytics will not record uncaught exception; native crash exists for session.", null);
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003b, code lost:            if (r4 != false) goto L28;     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0050, code lost:            r0.uncaughtException(r11, r12);        r3.set(false);     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0056, code lost:            return;     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004d, code lost:            android.util.Log.d("FirebaseCrashlytics", "Completed exception processing. Invoking default exception handler.", null);     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004b, code lost:            if (r4 != false) goto L28;     */
    @Override // java.lang.Thread.UncaughtExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void uncaughtException(java.lang.Thread r11, java.lang.Throwable r12) {
        /*
            r10 = this;
            java.lang.Thread$UncaughtExceptionHandler r0 = r10.defaultHandler
            java.lang.String r1 = "Completed exception processing. Invoking default exception handler."
            java.lang.String r2 = "FirebaseCrashlytics"
            java.util.concurrent.atomic.AtomicBoolean r3 = r10.isHandlingException
            r4 = 1
            r3.set(r4)
            r5 = 3
            r6 = 0
            r7 = 0
            boolean r8 = r10.shouldRecordUncaughtException(r11, r12)     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L21
            if (r8 == 0) goto L23
            com.google.firebase.crashlytics.internal.common.CrashlyticsUncaughtExceptionHandler$CrashListener r8 = r10.crashListener     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L21
            com.google.firebase.crashlytics.internal.settings.SettingsProvider r9 = r10.settingsProvider     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L21
            com.google.firebase.crashlytics.internal.common.CrashlyticsController$1 r8 = (com.google.firebase.crashlytics.internal.common.CrashlyticsController.AnonymousClass1) r8     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L21
            r8.onUncaughtException(r9, r11, r12)     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L21
            goto L33
        L1f:
            r8 = move-exception
            goto L57
        L21:
            r8 = move-exception
            goto L3e
        L23:
            java.lang.String r8 = "Uncaught exception will not be recorded by Crashlytics."
            boolean r9 = android.util.Log.isLoggable(r2, r5)     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L21
            if (r9 == 0) goto L2d
            r9 = r4
            goto L2e
        L2d:
            r9 = r7
        L2e:
            if (r9 == 0) goto L33
            android.util.Log.d(r2, r8, r6)     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L21
        L33:
            boolean r5 = android.util.Log.isLoggable(r2, r5)
            if (r5 == 0) goto L3a
            goto L3b
        L3a:
            r4 = r7
        L3b:
            if (r4 == 0) goto L50
            goto L4d
        L3e:
            java.lang.String r9 = "An error occurred in the uncaught exception handler"
            android.util.Log.e(r2, r9, r8)     // Catch: java.lang.Throwable -> L1f
            boolean r5 = android.util.Log.isLoggable(r2, r5)
            if (r5 == 0) goto L4a
            goto L4b
        L4a:
            r4 = r7
        L4b:
            if (r4 == 0) goto L50
        L4d:
            android.util.Log.d(r2, r1, r6)
        L50:
            r0.uncaughtException(r11, r12)
            r3.set(r7)
            return
        L57:
            boolean r5 = android.util.Log.isLoggable(r2, r5)
            if (r5 == 0) goto L5e
            goto L5f
        L5e:
            r4 = r7
        L5f:
            if (r4 == 0) goto L64
            android.util.Log.d(r2, r1, r6)
        L64:
            r0.uncaughtException(r11, r12)
            r3.set(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.common.CrashlyticsUncaughtExceptionHandler.uncaughtException(java.lang.Thread, java.lang.Throwable):void");
    }
}
