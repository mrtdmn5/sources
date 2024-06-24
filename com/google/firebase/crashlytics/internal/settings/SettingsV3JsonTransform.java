package com.google.firebase.crashlytics.internal.settings;

import com.google.android.gms.common.internal.zao;
import com.google.firebase.crashlytics.internal.settings.Settings;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class SettingsV3JsonTransform implements SettingsJsonTransform {
    @Override // com.google.firebase.crashlytics.internal.settings.SettingsJsonTransform
    public final Settings buildFromJson(zao zaoVar, JSONObject jSONObject) throws JSONException {
        Settings.SessionData sessionData;
        long currentTimeMillis;
        jSONObject.optInt("settings_version", 0);
        int optInt = jSONObject.optInt("cache_duration", 3600);
        double optDouble = jSONObject.optDouble("on_demand_upload_rate_per_minute", 10.0d);
        double optDouble2 = jSONObject.optDouble("on_demand_backoff_base", 1.2d);
        int optInt2 = jSONObject.optInt("on_demand_backoff_step_duration_seconds", 60);
        if (jSONObject.has("session")) {
            sessionData = new Settings.SessionData(jSONObject.getJSONObject("session").optInt("max_custom_exception_events", 8));
        } else {
            sessionData = new Settings.SessionData(new JSONObject().optInt("max_custom_exception_events", 8));
        }
        Settings.SessionData sessionData2 = sessionData;
        JSONObject jSONObject2 = jSONObject.getJSONObject("features");
        Settings.FeatureFlagData featureFlagData = new Settings.FeatureFlagData(jSONObject2.optBoolean("collect_reports", true), jSONObject2.optBoolean("collect_anrs", false), jSONObject2.optBoolean("collect_build_ids", false));
        long j = optInt;
        if (jSONObject.has("expires_at")) {
            currentTimeMillis = jSONObject.optLong("expires_at");
        } else {
            zaoVar.getClass();
            currentTimeMillis = (j * 1000) + System.currentTimeMillis();
        }
        return new Settings(currentTimeMillis, sessionData2, featureFlagData, optDouble, optDouble2, optInt2);
    }
}
