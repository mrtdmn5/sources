package com.google.firebase.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import com.google.firebase.events.Publisher;

/* loaded from: classes3.dex */
public final class DataCollectionConfigStorage {
    public final boolean dataCollectionDefaultEnabled;
    public final Publisher publisher;

    public DataCollectionConfigStorage(Context context, String str, Publisher publisher) {
        boolean z;
        ApplicationInfo applicationInfo;
        Bundle bundle;
        Object obj = ContextCompat.sLock;
        Context createDeviceProtectedStorageContext = ContextCompat.Api24Impl.createDeviceProtectedStorageContext(context);
        SharedPreferences sharedPreferences = createDeviceProtectedStorageContext.getSharedPreferences("com.google.firebase.common.prefs:" + str, 0);
        this.publisher = publisher;
        boolean z2 = true;
        if (sharedPreferences.contains("firebase_data_collection_default_enabled")) {
            z = sharedPreferences.getBoolean("firebase_data_collection_default_enabled", true);
        } else {
            try {
                PackageManager packageManager = createDeviceProtectedStorageContext.getPackageManager();
                if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(createDeviceProtectedStorageContext.getPackageName(), 128)) != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey("firebase_data_collection_default_enabled")) {
                    z2 = applicationInfo.metaData.getBoolean("firebase_data_collection_default_enabled");
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
            z = z2;
        }
        this.dataCollectionDefaultEnabled = z;
    }
}
