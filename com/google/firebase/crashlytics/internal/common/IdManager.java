package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.firebase.installations.FirebaseInstallationsApi;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public final class IdManager implements InstallIdProvider {
    public final Context appContext;
    public final String appIdentifier;
    public String crashlyticsInstallId;
    public final DataCollectionArbiter dataCollectionArbiter;
    public final FirebaseInstallationsApi firebaseInstallationsApi;
    public final InstallerPackageNameProvider installerPackageNameProvider;
    public static final Pattern ID_PATTERN = Pattern.compile("[^\\p{Alnum}]");
    public static final String FORWARD_SLASH_REGEX = Pattern.quote("/");

    public IdManager(Context context, String str, FirebaseInstallationsApi firebaseInstallationsApi, DataCollectionArbiter dataCollectionArbiter) {
        if (str != null) {
            this.appContext = context;
            this.appIdentifier = str;
            this.firebaseInstallationsApi = firebaseInstallationsApi;
            this.dataCollectionArbiter = dataCollectionArbiter;
            this.installerPackageNameProvider = new InstallerPackageNameProvider();
            return;
        }
        throw new IllegalArgumentException("appIdentifier must not be null");
    }

    public static String createSyntheticFid() {
        return "SYN_" + UUID.randomUUID().toString();
    }

    public final synchronized String createAndCacheCrashlyticsInstallId(SharedPreferences sharedPreferences, String str) {
        String lowerCase;
        String str2 = UUID.randomUUID().toString();
        if (str2 == null) {
            lowerCase = null;
        } else {
            lowerCase = ID_PATTERN.matcher(str2).replaceAll("").toLowerCase(Locale.US);
        }
        String str3 = "Created new Crashlytics installation ID: " + lowerCase + " for FID: " + str;
        if (Log.isLoggable("FirebaseCrashlytics", 2)) {
            Log.v("FirebaseCrashlytics", str3, null);
        }
        sharedPreferences.edit().putString("crashlytics.installation.id", lowerCase).putString("firebase.installation.id", str).apply();
        return lowerCase;
    }

    public final synchronized String getCrashlyticsInstallId() {
        String str;
        String str2 = this.crashlyticsInstallId;
        if (str2 != null) {
            return str2;
        }
        if (Log.isLoggable("FirebaseCrashlytics", 2)) {
            Log.v("FirebaseCrashlytics", "Determining Crashlytics installation ID...", null);
        }
        boolean z = false;
        SharedPreferences sharedPreferences = this.appContext.getSharedPreferences("com.google.firebase.crashlytics", 0);
        String string = sharedPreferences.getString("firebase.installation.id", null);
        String str3 = "Cached Firebase Installation ID: " + string;
        if (Log.isLoggable("FirebaseCrashlytics", 2)) {
            Log.v("FirebaseCrashlytics", str3, null);
        }
        if (this.dataCollectionArbiter.isAutomaticDataCollectionEnabled()) {
            try {
                str = (String) Utils.awaitEvenIfOnMainThread(this.firebaseInstallationsApi.getId());
            } catch (Exception e) {
                Log.w("FirebaseCrashlytics", "Failed to retrieve Firebase Installations ID.", e);
                str = null;
            }
            String str4 = "Fetched Firebase Installation ID: " + str;
            if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                Log.v("FirebaseCrashlytics", str4, null);
            }
            if (str == null) {
                if (string == null) {
                    str = createSyntheticFid();
                } else {
                    str = string;
                }
            }
            if (str.equals(string)) {
                this.crashlyticsInstallId = sharedPreferences.getString("crashlytics.installation.id", null);
            } else {
                this.crashlyticsInstallId = createAndCacheCrashlyticsInstallId(sharedPreferences, str);
            }
        } else {
            if (string != null && string.startsWith("SYN_")) {
                z = true;
            }
            if (z) {
                this.crashlyticsInstallId = sharedPreferences.getString("crashlytics.installation.id", null);
            } else {
                this.crashlyticsInstallId = createAndCacheCrashlyticsInstallId(sharedPreferences, createSyntheticFid());
            }
        }
        if (this.crashlyticsInstallId == null) {
            Log.w("FirebaseCrashlytics", "Unable to determine Crashlytics Install Id, creating a new one.", null);
            this.crashlyticsInstallId = createAndCacheCrashlyticsInstallId(sharedPreferences, createSyntheticFid());
        }
        String str5 = "Crashlytics installation ID: " + this.crashlyticsInstallId;
        if (Log.isLoggable("FirebaseCrashlytics", 2)) {
            Log.v("FirebaseCrashlytics", str5, null);
        }
        return this.crashlyticsInstallId;
    }

    public final String getInstallerPackageName() {
        String str;
        InstallerPackageNameProvider installerPackageNameProvider = this.installerPackageNameProvider;
        Context context = this.appContext;
        synchronized (installerPackageNameProvider) {
            if (installerPackageNameProvider.installerPackageName == null) {
                String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
                if (installerPackageName == null) {
                    installerPackageName = "";
                }
                installerPackageNameProvider.installerPackageName = installerPackageName;
            }
            if ("".equals(installerPackageNameProvider.installerPackageName)) {
                str = null;
            } else {
                str = installerPackageNameProvider.installerPackageName;
            }
        }
        return str;
    }
}
