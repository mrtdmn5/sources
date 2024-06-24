package com.google.firebase.analytics.connector;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzco;
import com.google.android.gms.internal.measurement.zzds;
import com.google.android.gms.internal.measurement.zzdt;
import com.google.android.gms.internal.measurement.zzef;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.analytics.connector.internal.zzc;
import com.google.firebase.analytics.connector.internal.zze;
import com.google.firebase.analytics.connector.internal.zzg;
import com.google.firebase.crashlytics.CrashlyticsAnalyticsListener;
import io.reactivex.exceptions.Exceptions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-api@@21.2.0 */
/* loaded from: classes3.dex */
public final class AnalyticsConnectorImpl implements AnalyticsConnector {
    public static volatile AnalyticsConnectorImpl zzc;
    public final AppMeasurementSdk zza;
    public final ConcurrentHashMap zzb;

    /* compiled from: com.google.android.gms:play-services-measurement-api@@21.2.0 */
    /* renamed from: com.google.firebase.analytics.connector.AnalyticsConnectorImpl$1 */
    /* loaded from: classes3.dex */
    public final class AnonymousClass1 {
    }

    public AnalyticsConnectorImpl(AppMeasurementSdk appMeasurementSdk) {
        Preconditions.checkNotNull(appMeasurementSdk);
        this.zza = appMeasurementSdk;
        this.zzb = new ConcurrentHashMap();
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public final void clearConditionalUserProperty(String str) {
        zzef zzefVar = this.zza.zza;
        zzefVar.getClass();
        zzefVar.zzV(new zzco(zzefVar, str, null, null));
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public final ArrayList getConditionalUserProperties(String str) {
        ArrayList arrayList = new ArrayList();
        for (Bundle bundle : this.zza.zza.zzq(str, "")) {
            HashSet hashSet = zzc.zza;
            Preconditions.checkNotNull(bundle);
            AnalyticsConnector.ConditionalUserProperty conditionalUserProperty = new AnalyticsConnector.ConditionalUserProperty();
            String str2 = (String) Exceptions.zza(bundle, "origin", String.class, null);
            Preconditions.checkNotNull(str2);
            conditionalUserProperty.origin = str2;
            String str3 = (String) Exceptions.zza(bundle, "name", String.class, null);
            Preconditions.checkNotNull(str3);
            conditionalUserProperty.name = str3;
            conditionalUserProperty.value = Exceptions.zza(bundle, "value", Object.class, null);
            conditionalUserProperty.triggerEventName = (String) Exceptions.zza(bundle, "trigger_event_name", String.class, null);
            conditionalUserProperty.triggerTimeout = ((Long) Exceptions.zza(bundle, "trigger_timeout", Long.class, 0L)).longValue();
            conditionalUserProperty.timedOutEventName = (String) Exceptions.zza(bundle, "timed_out_event_name", String.class, null);
            conditionalUserProperty.timedOutEventParams = (Bundle) Exceptions.zza(bundle, "timed_out_event_params", Bundle.class, null);
            conditionalUserProperty.triggeredEventName = (String) Exceptions.zza(bundle, "triggered_event_name", String.class, null);
            conditionalUserProperty.triggeredEventParams = (Bundle) Exceptions.zza(bundle, "triggered_event_params", Bundle.class, null);
            conditionalUserProperty.timeToLive = ((Long) Exceptions.zza(bundle, "time_to_live", Long.class, 0L)).longValue();
            conditionalUserProperty.expiredEventName = (String) Exceptions.zza(bundle, "expired_event_name", String.class, null);
            conditionalUserProperty.expiredEventParams = (Bundle) Exceptions.zza(bundle, "expired_event_params", Bundle.class, null);
            conditionalUserProperty.active = ((Boolean) Exceptions.zza(bundle, "active", Boolean.class, Boolean.FALSE)).booleanValue();
            conditionalUserProperty.creationTimestamp = ((Long) Exceptions.zza(bundle, "creation_timestamp", Long.class, 0L)).longValue();
            conditionalUserProperty.triggeredTimestamp = ((Long) Exceptions.zza(bundle, "triggered_timestamp", Long.class, 0L)).longValue();
            arrayList.add(conditionalUserProperty);
        }
        return arrayList;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public final int getMaxUserProperties(String str) {
        return this.zza.zza.zza(str);
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public final Map<String, Object> getUserProperties(boolean z) {
        return this.zza.zza.zzr(null, null, z);
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public final void logEvent(String str, String str2, Bundle bundle) {
        if (!zzc.zzl(str) || !zzc.zzj(bundle, str2) || !zzc.zzh(str, str2, bundle)) {
            return;
        }
        if ("clx".equals(str) && "_ae".equals(str2)) {
            bundle.putLong("_r", 1L);
        }
        zzef zzefVar = this.zza.zza;
        zzefVar.getClass();
        zzefVar.zzV(new zzds(zzefVar, str, str2, bundle, true));
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public final AnonymousClass1 registerAnalyticsConnectorListener(String str, CrashlyticsAnalyticsListener crashlyticsAnalyticsListener) {
        boolean z;
        Object obj;
        if (!zzc.zzl(str)) {
            return null;
        }
        boolean isEmpty = str.isEmpty();
        ConcurrentHashMap concurrentHashMap = this.zzb;
        if (!isEmpty && concurrentHashMap.containsKey(str) && concurrentHashMap.get(str) != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        boolean equals = "fiam".equals(str);
        AppMeasurementSdk appMeasurementSdk = this.zza;
        if (equals) {
            obj = new zze(appMeasurementSdk, crashlyticsAnalyticsListener);
        } else if ("clx".equals(str)) {
            obj = new zzg(appMeasurementSdk, crashlyticsAnalyticsListener);
        } else {
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        concurrentHashMap.put(str, obj);
        return new AnonymousClass1();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0052, code lost:            if (r2 == null) goto L153;     */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00af A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b0  */
    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void setConditionalUserProperty(com.google.firebase.analytics.connector.AnalyticsConnector.ConditionalUserProperty r7) {
        /*
            Method dump skipped, instructions count: 320
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.analytics.connector.AnalyticsConnectorImpl.setConditionalUserProperty(com.google.firebase.analytics.connector.AnalyticsConnector$ConditionalUserProperty):void");
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public final void setUserProperty(String str) {
        if (!zzc.zzl("fcm") || !zzc.zzm("fcm", "_ln")) {
            return;
        }
        zzef zzefVar = this.zza.zza;
        zzefVar.getClass();
        zzefVar.zzV(new zzdt(zzefVar, "fcm", "_ln", str, true));
    }
}
