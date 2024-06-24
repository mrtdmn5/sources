package com.google.firebase.analytics.connector;

import android.os.Bundle;
import com.google.firebase.analytics.connector.AnalyticsConnectorImpl;
import com.google.firebase.crashlytics.CrashlyticsAnalyticsListener;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-measurement-connector@@19.0.0 */
/* loaded from: classes3.dex */
public interface AnalyticsConnector {

    /* compiled from: com.google.firebase:firebase-measurement-connector@@19.0.0 */
    /* loaded from: classes3.dex */
    public interface AnalyticsConnectorListener {
    }

    /* compiled from: com.google.firebase:firebase-measurement-connector@@19.0.0 */
    /* loaded from: classes3.dex */
    public static class ConditionalUserProperty {
        public boolean active;
        public long creationTimestamp;
        public String expiredEventName;
        public Bundle expiredEventParams;
        public String name;
        public String origin;
        public long timeToLive;
        public String timedOutEventName;
        public Bundle timedOutEventParams;
        public String triggerEventName;
        public long triggerTimeout;
        public String triggeredEventName;
        public Bundle triggeredEventParams;
        public long triggeredTimestamp;
        public Object value;
    }

    void clearConditionalUserProperty(String str);

    ArrayList getConditionalUserProperties(String str);

    int getMaxUserProperties(String str);

    Map<String, Object> getUserProperties(boolean z);

    void logEvent(String str, String str2, Bundle bundle);

    AnalyticsConnectorImpl.AnonymousClass1 registerAnalyticsConnectorListener(String str, CrashlyticsAnalyticsListener crashlyticsAnalyticsListener);

    void setConditionalUserProperty(ConditionalUserProperty conditionalUserProperty);

    void setUserProperty(String str);
}
