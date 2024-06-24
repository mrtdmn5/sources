package com.google.firebase.crashlytics;

import android.os.Bundle;
import android.util.Log;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventReceiver;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class CrashlyticsAnalyticsListener implements AnalyticsConnector.AnalyticsConnectorListener {
    public AnalyticsEventReceiver breadcrumbEventReceiver;
    public AnalyticsEventReceiver crashlyticsOriginEventReceiver;

    public final void onMessageTriggered(int r3, Bundle bundle) {
        AnalyticsEventReceiver analyticsEventReceiver;
        String format = String.format(Locale.US, "Analytics listener received message. ID: %d, Extras: %s", Integer.valueOf(r3), bundle);
        if (Log.isLoggable("FirebaseCrashlytics", 2)) {
            Log.v("FirebaseCrashlytics", format, null);
        }
        String string = bundle.getString("name");
        if (string != null) {
            Bundle bundle2 = bundle.getBundle("params");
            if (bundle2 == null) {
                bundle2 = new Bundle();
            }
            if ("clx".equals(bundle2.getString("_o"))) {
                analyticsEventReceiver = this.crashlyticsOriginEventReceiver;
            } else {
                analyticsEventReceiver = this.breadcrumbEventReceiver;
            }
            if (analyticsEventReceiver != null) {
                analyticsEventReceiver.onEvent(bundle2, string);
            }
        }
    }
}
