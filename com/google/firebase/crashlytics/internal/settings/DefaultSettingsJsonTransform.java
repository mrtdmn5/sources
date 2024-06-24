package com.google.firebase.crashlytics.internal.settings;

import com.google.android.gms.common.internal.zao;
import com.google.firebase.crashlytics.internal.settings.Settings;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class DefaultSettingsJsonTransform implements SettingsJsonTransform {
    public static Settings defaultSettings(zao zaoVar) {
        Settings.SessionData sessionData = new Settings.SessionData(8);
        Settings.FeatureFlagData featureFlagData = new Settings.FeatureFlagData(true, false, false);
        zaoVar.getClass();
        return new Settings(System.currentTimeMillis() + 3600000, sessionData, featureFlagData, 10.0d, 1.2d, 60);
    }

    @Override // com.google.firebase.crashlytics.internal.settings.SettingsJsonTransform
    public final Settings buildFromJson(zao zaoVar, JSONObject jSONObject) {
        return defaultSettings(zaoVar);
    }
}
