package com.google.firebase.abt.component;

import android.content.Context;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inject.Provider;
import java.util.HashMap;

/* loaded from: classes3.dex */
public final class AbtComponent {
    public final HashMap abtOriginInstances = new HashMap();
    public final Provider<AnalyticsConnector> analyticsConnector;

    public AbtComponent(Context context, Provider<AnalyticsConnector> provider) {
        this.analyticsConnector = provider;
    }
}
