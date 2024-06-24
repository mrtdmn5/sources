package com.google.firebase.crashlytics.internal.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import bleshadow.dagger.internal.SetBuilder;
import com.amazonaws.http.HttpHeader;
import com.google.android.gms.common.internal.zao;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.DataCollectionArbiter;
import com.google.firebase.crashlytics.internal.network.HttpGetRequest;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig$$ExternalSyntheticLambda0;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class SettingsController implements SettingsProvider {
    public final SetBuilder cachedSettingsIo;
    public final Context context;
    public final zao currentTimeProvider;
    public final DataCollectionArbiter dataCollectionArbiter;
    public final AtomicReference<Settings> settings;
    public final SettingsJsonParser settingsJsonParser;
    public final SettingsRequest settingsRequest;
    public final DefaultSettingsSpiCall settingsSpiCall;
    public final AtomicReference<TaskCompletionSource<Settings>> settingsTask;

    /* renamed from: com.google.firebase.crashlytics.internal.settings.SettingsController$1 */
    /* loaded from: classes3.dex */
    public final class AnonymousClass1 implements SuccessContinuation<Void, Void> {
        public AnonymousClass1() {
        }

        @Override // com.google.android.gms.tasks.SuccessContinuation
        public final Task<Void> then(Void r14) throws Exception {
            JSONObject jSONObject;
            Exception e;
            FileWriter fileWriter;
            SettingsController settingsController = SettingsController.this;
            DefaultSettingsSpiCall defaultSettingsSpiCall = settingsController.settingsSpiCall;
            SettingsRequest settingsRequest = settingsController.settingsRequest;
            String str = defaultSettingsSpiCall.url;
            FileWriter fileWriter2 = null;
            try {
                HashMap queryParamsFor = DefaultSettingsSpiCall.getQueryParamsFor(settingsRequest);
                defaultSettingsSpiCall.requestFactory.getClass();
                HttpGetRequest httpGetRequest = new HttpGetRequest(str, queryParamsFor);
                HashMap hashMap = httpGetRequest.headers;
                hashMap.put(HttpHeader.USER_AGENT, "Crashlytics Android SDK/18.3.5");
                hashMap.put("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
                DefaultSettingsSpiCall.applyHeadersTo(httpGetRequest, settingsRequest);
                String str2 = "Requesting settings from " + str;
                if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                    Log.d("FirebaseCrashlytics", str2, null);
                }
                String str3 = "Settings query params were: " + queryParamsFor;
                if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                    Log.v("FirebaseCrashlytics", str3, null);
                }
                jSONObject = defaultSettingsSpiCall.handleResponse(httpGetRequest.execute());
            } catch (IOException e2) {
                Log.e("FirebaseCrashlytics", "Settings request failed.", e2);
                jSONObject = null;
            }
            if (jSONObject != null) {
                Settings parseSettingsJson = settingsController.settingsJsonParser.parseSettingsJson(jSONObject);
                long j = parseSettingsJson.expiresAtMillis;
                SetBuilder setBuilder = settingsController.cachedSettingsIo;
                setBuilder.getClass();
                if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                    Log.v("FirebaseCrashlytics", "Writing settings to cache file...", null);
                }
                try {
                    jSONObject.put("expires_at", j);
                    fileWriter = new FileWriter((File) setBuilder.contributions);
                } catch (Exception e3) {
                    e = e3;
                    fileWriter = null;
                } catch (Throwable th) {
                    th = th;
                    CommonUtils.closeOrLog(fileWriter2, "Failed to close settings writer.");
                    throw th;
                }
                try {
                    try {
                        fileWriter.write(jSONObject.toString());
                        fileWriter.flush();
                    } catch (Throwable th2) {
                        th = th2;
                        fileWriter2 = fileWriter;
                        CommonUtils.closeOrLog(fileWriter2, "Failed to close settings writer.");
                        throw th;
                    }
                } catch (Exception e4) {
                    e = e4;
                    Log.e("FirebaseCrashlytics", "Failed to cache settings", e);
                    CommonUtils.closeOrLog(fileWriter, "Failed to close settings writer.");
                    SettingsController.logSettings(jSONObject, "Loaded settings: ");
                    String str4 = settingsRequest.instanceId;
                    SharedPreferences.Editor edit = settingsController.context.getSharedPreferences("com.google.firebase.crashlytics", 0).edit();
                    edit.putString("existing_instance_identifier", str4);
                    edit.apply();
                    settingsController.settings.set(parseSettingsJson);
                    settingsController.settingsTask.get().trySetResult(parseSettingsJson);
                    return Tasks.forResult(null);
                }
                CommonUtils.closeOrLog(fileWriter, "Failed to close settings writer.");
                SettingsController.logSettings(jSONObject, "Loaded settings: ");
                String str42 = settingsRequest.instanceId;
                SharedPreferences.Editor edit2 = settingsController.context.getSharedPreferences("com.google.firebase.crashlytics", 0).edit();
                edit2.putString("existing_instance_identifier", str42);
                edit2.apply();
                settingsController.settings.set(parseSettingsJson);
                settingsController.settingsTask.get().trySetResult(parseSettingsJson);
            }
            return Tasks.forResult(null);
        }
    }

    public SettingsController(Context context, SettingsRequest settingsRequest, zao zaoVar, SettingsJsonParser settingsJsonParser, SetBuilder setBuilder, DefaultSettingsSpiCall defaultSettingsSpiCall, DataCollectionArbiter dataCollectionArbiter) {
        AtomicReference<Settings> atomicReference = new AtomicReference<>();
        this.settings = atomicReference;
        this.settingsTask = new AtomicReference<>(new TaskCompletionSource());
        this.context = context;
        this.settingsRequest = settingsRequest;
        this.currentTimeProvider = zaoVar;
        this.settingsJsonParser = settingsJsonParser;
        this.cachedSettingsIo = setBuilder;
        this.settingsSpiCall = defaultSettingsSpiCall;
        this.dataCollectionArbiter = dataCollectionArbiter;
        atomicReference.set(DefaultSettingsJsonTransform.defaultSettings(zaoVar));
    }

    public static void logSettings(JSONObject jSONObject, String str) throws JSONException {
        StringBuilder m = FirebaseRemoteConfig$$ExternalSyntheticLambda0.m(str);
        m.append(jSONObject.toString());
        String sb = m.toString();
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", sb, null);
        }
    }

    public final Settings getCachedSettingsData(SettingsCacheBehavior settingsCacheBehavior) {
        boolean z;
        Settings settings = null;
        try {
            if (!SettingsCacheBehavior.SKIP_CACHE_LOOKUP.equals(settingsCacheBehavior)) {
                JSONObject readCachedSettings = this.cachedSettingsIo.readCachedSettings();
                if (readCachedSettings != null) {
                    Settings parseSettingsJson = this.settingsJsonParser.parseSettingsJson(readCachedSettings);
                    if (parseSettingsJson != null) {
                        logSettings(readCachedSettings, "Loaded cached settings: ");
                        this.currentTimeProvider.getClass();
                        long currentTimeMillis = System.currentTimeMillis();
                        if (!SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION.equals(settingsCacheBehavior)) {
                            if (parseSettingsJson.expiresAtMillis < currentTimeMillis) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                                    Log.v("FirebaseCrashlytics", "Cached settings have expired.", null);
                                }
                            }
                        }
                        try {
                            if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                                Log.v("FirebaseCrashlytics", "Returning cached settings.", null);
                            }
                            settings = parseSettingsJson;
                        } catch (Exception e) {
                            e = e;
                            settings = parseSettingsJson;
                            Log.e("FirebaseCrashlytics", "Failed to get cached settings", e);
                            return settings;
                        }
                    } else {
                        Log.e("FirebaseCrashlytics", "Failed to parse cached settings data.", null);
                    }
                } else if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                    Log.d("FirebaseCrashlytics", "No cached settings data found.", null);
                }
            }
        } catch (Exception e2) {
            e = e2;
        }
        return settings;
    }

    public final Settings getSettingsSync() {
        return this.settings.get();
    }
}
