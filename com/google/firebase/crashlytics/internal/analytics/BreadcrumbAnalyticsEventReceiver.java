package com.google.firebase.crashlytics.internal.analytics;

import android.os.Bundle;
import android.util.Log;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class BreadcrumbAnalyticsEventReceiver implements AnalyticsEventReceiver, BreadcrumbSource {
    public BreadcrumbHandler breadcrumbHandler;

    public static String serializeEvent(Bundle bundle, String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        for (String str2 : bundle.keySet()) {
            jSONObject2.put(str2, bundle.get(str2));
        }
        jSONObject.put("name", str);
        jSONObject.put("parameters", jSONObject2);
        return jSONObject.toString();
    }

    @Override // com.google.firebase.crashlytics.internal.analytics.AnalyticsEventReceiver
    public final void onEvent(Bundle bundle, String str) {
        BreadcrumbHandler breadcrumbHandler = this.breadcrumbHandler;
        if (breadcrumbHandler != null) {
            try {
                breadcrumbHandler.handleBreadcrumb("$A$:" + serializeEvent(bundle, str));
            } catch (JSONException unused) {
                Log.w("FirebaseCrashlytics", "Unable to serialize Firebase Analytics event to breadcrumb.", null);
            }
        }
    }

    @Override // com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource
    public final void registerBreadcrumbHandler(BreadcrumbHandler breadcrumbHandler) {
        boolean z;
        this.breadcrumbHandler = breadcrumbHandler;
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            Log.d("FirebaseCrashlytics", "Registered Firebase Analytics event receiver for breadcrumbs", null);
        }
    }
}
