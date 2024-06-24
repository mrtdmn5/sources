package com.google.firebase.crashlytics.internal.settings;

import com.google.android.gms.common.internal.zao;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface SettingsJsonTransform {
    Settings buildFromJson(zao zaoVar, JSONObject jSONObject) throws JSONException;
}
