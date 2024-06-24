package com.google.firebase.crashlytics.internal.settings;

import android.text.TextUtils;
import android.util.Log;
import com.amazonaws.http.HttpHeader;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.firebase.crashlytics.internal.network.HttpGetRequest;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.network.HttpResponse;
import io.ktor.http.UrlKt;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class DefaultSettingsSpiCall {
    public final HttpRequestFactory requestFactory;
    public final String url;

    public DefaultSettingsSpiCall(String str, HttpRequestFactory httpRequestFactory) {
        if (str != null) {
            this.requestFactory = httpRequestFactory;
            this.url = str;
            return;
        }
        throw new IllegalArgumentException("url must not be null.");
    }

    public static void applyHeadersTo(HttpGetRequest httpGetRequest, SettingsRequest settingsRequest) {
        applyNonNullHeader(httpGetRequest, "X-CRASHLYTICS-GOOGLE-APP-ID", settingsRequest.googleAppId);
        applyNonNullHeader(httpGetRequest, "X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        applyNonNullHeader(httpGetRequest, "X-CRASHLYTICS-API-CLIENT-VERSION", "18.3.5");
        applyNonNullHeader(httpGetRequest, HttpHeader.ACCEPT, "application/json");
        applyNonNullHeader(httpGetRequest, "X-CRASHLYTICS-DEVICE-MODEL", settingsRequest.deviceModel);
        applyNonNullHeader(httpGetRequest, "X-CRASHLYTICS-OS-BUILD-VERSION", settingsRequest.osBuildVersion);
        applyNonNullHeader(httpGetRequest, "X-CRASHLYTICS-OS-DISPLAY-VERSION", settingsRequest.osDisplayVersion);
        applyNonNullHeader(httpGetRequest, "X-CRASHLYTICS-INSTALLATION-ID", ((IdManager) settingsRequest.installIdProvider).getCrashlyticsInstallId());
    }

    public static void applyNonNullHeader(HttpGetRequest httpGetRequest, String str, String str2) {
        if (str2 != null) {
            httpGetRequest.headers.put(str, str2);
        }
    }

    public static HashMap getQueryParamsFor(SettingsRequest settingsRequest) {
        HashMap hashMap = new HashMap();
        hashMap.put("build_version", settingsRequest.buildVersion);
        hashMap.put("display_version", settingsRequest.displayVersion);
        hashMap.put("source", Integer.toString(settingsRequest.source));
        String str = settingsRequest.instanceId;
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("instance", str);
        }
        return hashMap;
    }

    public final JSONObject handleResponse(HttpResponse httpResponse) {
        boolean z;
        StringBuilder sb = new StringBuilder("Settings response code was: ");
        int r1 = httpResponse.code;
        sb.append(r1);
        String sb2 = sb.toString();
        UrlKt urlKt = UrlKt.DEFAULT_LOGGER;
        urlKt.v(sb2);
        if (r1 != 200 && r1 != 201 && r1 != 202 && r1 != 203) {
            z = false;
        } else {
            z = true;
        }
        String str = this.url;
        if (z) {
            String str2 = httpResponse.body;
            try {
                return new JSONObject(str2);
            } catch (Exception e) {
                urlKt.w("Failed to parse settings JSON from " + str, e);
                urlKt.w("Settings response " + str2, null);
                return null;
            }
        }
        String str3 = "Settings request failed; (status: " + r1 + ") from " + str;
        if (!urlKt.canLog(6)) {
            return null;
        }
        Log.e("FirebaseCrashlytics", str3, null);
        return null;
    }
}
