package com.animaconnected.watch.account.strava;

import com.animaconnected.watch.ServiceLocator;

/* compiled from: StravaHttpClient.kt */
/* loaded from: classes3.dex */
public final class StravaAnalytics {
    public static final StravaAnalytics INSTANCE = new StravaAnalytics();

    private StravaAnalytics() {
    }

    public final void trackUserSignIn() {
        ServiceLocator.INSTANCE.getAnalytics().getAppEvents().sendAction("strava_enabled");
    }

    public final void trackUserSignOut() {
        ServiceLocator.INSTANCE.getAnalytics().getAppEvents().sendAction("strava_disabled");
    }
}
