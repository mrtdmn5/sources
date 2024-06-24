package com.google.firebase.crashlytics.internal.analytics;

import android.os.Bundle;
import com.google.firebase.analytics.connector.AnalyticsConnector;

/* loaded from: classes3.dex */
public final class CrashlyticsOriginAnalyticsEventLogger implements AnalyticsEventLogger {
    public final AnalyticsConnector analyticsConnector;

    public CrashlyticsOriginAnalyticsEventLogger(AnalyticsConnector analyticsConnector) {
        this.analyticsConnector = analyticsConnector;
    }

    @Override // com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger
    public final void logEvent(Bundle bundle) {
        this.analyticsConnector.logEvent("clx", "_ae", bundle);
    }
}
