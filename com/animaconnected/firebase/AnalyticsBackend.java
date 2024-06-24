package com.animaconnected.firebase;

import java.util.Map;

/* compiled from: AnalyticsBackend.kt */
/* loaded from: classes.dex */
public interface AnalyticsBackend {
    void logEvent(String str, Map<String, String> map);

    void setAnalyticsCollectionEnabled(boolean z);

    void setUserProperty(String str, String str2);
}
