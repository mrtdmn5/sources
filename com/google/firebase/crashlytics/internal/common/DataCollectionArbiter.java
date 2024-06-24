package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseApp;

/* loaded from: classes3.dex */
public final class DataCollectionArbiter {
    public Boolean crashlyticsDataCollectionEnabled;
    public TaskCompletionSource<Void> dataCollectionEnabledTask;
    public final TaskCompletionSource<Void> dataCollectionExplicitlyApproved;
    public final FirebaseApp firebaseApp;
    public boolean setInManifest;
    public final SharedPreferences sharedPreferences;
    public final Object taskLock;
    public boolean taskResolved;

    public DataCollectionArbiter(FirebaseApp firebaseApp) {
        Boolean bool;
        Object obj = new Object();
        this.taskLock = obj;
        this.dataCollectionEnabledTask = new TaskCompletionSource<>();
        this.taskResolved = false;
        this.setInManifest = false;
        this.dataCollectionExplicitlyApproved = new TaskCompletionSource<>();
        firebaseApp.checkNotDeleted();
        Context context = firebaseApp.applicationContext;
        this.firebaseApp = firebaseApp;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.firebase.crashlytics", 0);
        this.sharedPreferences = sharedPreferences;
        if (sharedPreferences.contains("firebase_crashlytics_collection_enabled")) {
            this.setInManifest = false;
            bool = Boolean.valueOf(sharedPreferences.getBoolean("firebase_crashlytics_collection_enabled", true));
        } else {
            bool = null;
        }
        this.crashlyticsDataCollectionEnabled = bool == null ? getDataCollectionValueFromManifest(context) : bool;
        synchronized (obj) {
            if (isAutomaticDataCollectionEnabled()) {
                this.dataCollectionEnabledTask.trySetResult(null);
                this.taskResolved = true;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Boolean getDataCollectionValueFromManifest(android.content.Context r5) {
        /*
            r4 = this;
            java.lang.String r0 = "firebase_crashlytics_collection_enabled"
            r1 = 0
            android.content.pm.PackageManager r2 = r5.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L2a
            if (r2 == 0) goto L32
            java.lang.String r5 = r5.getPackageName()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L2a
            r3 = 128(0x80, float:1.8E-43)
            android.content.pm.ApplicationInfo r5 = r2.getApplicationInfo(r5, r3)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L2a
            if (r5 == 0) goto L32
            android.os.Bundle r2 = r5.metaData     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L2a
            if (r2 == 0) goto L32
            boolean r2 = r2.containsKey(r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L2a
            if (r2 == 0) goto L32
            android.os.Bundle r5 = r5.metaData     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L2a
            boolean r5 = r5.getBoolean(r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L2a
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L2a
            goto L33
        L2a:
            r5 = move-exception
            java.lang.String r0 = "FirebaseCrashlytics"
            java.lang.String r2 = "Could not read data collection permission from manifest"
            android.util.Log.e(r0, r2, r5)
        L32:
            r5 = r1
        L33:
            if (r5 != 0) goto L39
            r5 = 0
            r4.setInManifest = r5
            return r1
        L39:
            r0 = 1
            r4.setInManifest = r0
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            boolean r5 = r0.equals(r5)
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.common.DataCollectionArbiter.getDataCollectionValueFromManifest(android.content.Context):java.lang.Boolean");
    }

    public final synchronized boolean isAutomaticDataCollectionEnabled() {
        boolean isDataCollectionDefaultEnabled;
        String str;
        String str2;
        Boolean bool = this.crashlyticsDataCollectionEnabled;
        if (bool != null) {
            isDataCollectionDefaultEnabled = bool.booleanValue();
        } else {
            isDataCollectionDefaultEnabled = this.firebaseApp.isDataCollectionDefaultEnabled();
        }
        if (isDataCollectionDefaultEnabled) {
            str = "ENABLED";
        } else {
            str = "DISABLED";
        }
        if (this.crashlyticsDataCollectionEnabled == null) {
            str2 = "global Firebase setting";
        } else if (this.setInManifest) {
            str2 = "firebase_crashlytics_collection_enabled manifest flag";
        } else {
            str2 = "API";
        }
        String format = String.format("Crashlytics automatic data collection %s by %s.", str, str2);
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", format, null);
        }
        return isDataCollectionDefaultEnabled;
    }
}
