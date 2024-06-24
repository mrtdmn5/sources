package com.google.firebase.crashlytics.internal.settings;

import android.util.Log;
import com.google.android.gms.common.internal.zao;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class SettingsJsonParser {
    public final zao currentTimeProvider;

    public SettingsJsonParser(zao zaoVar) {
        this.currentTimeProvider = zaoVar;
    }

    public final Settings parseSettingsJson(JSONObject jSONObject) throws JSONException {
        SettingsJsonTransform settingsV3JsonTransform;
        int r0 = jSONObject.getInt("settings_version");
        if (r0 != 3) {
            Log.e("FirebaseCrashlytics", "Could not determine SettingsJsonTransform for settings version " + r0 + ". Using default settings values.", null);
            settingsV3JsonTransform = new DefaultSettingsJsonTransform();
        } else {
            settingsV3JsonTransform = new SettingsV3JsonTransform();
        }
        return settingsV3JsonTransform.buildFromJson(this.currentTimeProvider, jSONObject);
    }
}
