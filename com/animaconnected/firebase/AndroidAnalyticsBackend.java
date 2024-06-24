package com.animaconnected.firebase;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzcs;
import com.google.android.gms.internal.measurement.zzds;
import com.google.android.gms.internal.measurement.zzdt;
import com.google.android.gms.internal.measurement.zzef;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidAnalyticsBackend.kt */
/* loaded from: classes.dex */
public final class AndroidAnalyticsBackend implements AnalyticsBackend {
    private static final boolean DEBUG = false;
    private FirebaseAnalytics firebaseAnalytics;
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "AndroidAnalyticsBackend";

    /* compiled from: AndroidAnalyticsBackend.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public AndroidAnalyticsBackend(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(context);
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        this.firebaseAnalytics = firebaseAnalytics;
    }

    @Override // com.animaconnected.firebase.AnalyticsBackend
    public void logEvent(String name, Map<String, String> params) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(params, "params");
        Bundle bundle = new Bundle();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            bundle.putString(entry.getKey(), entry.getValue());
        }
        zzef zzefVar = this.firebaseAnalytics.zzb;
        zzefVar.getClass();
        zzefVar.zzV(new zzds(zzefVar, null, name, bundle, false));
    }

    @Override // com.animaconnected.firebase.AnalyticsBackend
    public void setAnalyticsCollectionEnabled(boolean z) {
        FirebaseAnalytics firebaseAnalytics = this.firebaseAnalytics;
        Boolean valueOf = Boolean.valueOf(z);
        zzef zzefVar = firebaseAnalytics.zzb;
        zzefVar.getClass();
        zzefVar.zzV(new zzcs(zzefVar, valueOf));
    }

    @Override // com.animaconnected.firebase.AnalyticsBackend
    public synchronized void setUserProperty(String property, String str) {
        Intrinsics.checkNotNullParameter(property, "property");
        zzef zzefVar = this.firebaseAnalytics.zzb;
        zzefVar.getClass();
        zzefVar.zzV(new zzdt(zzefVar, null, property, str, false));
    }
}
