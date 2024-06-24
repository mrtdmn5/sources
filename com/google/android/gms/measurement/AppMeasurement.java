package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.animaconnected.firebase.AnalyticsConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcl;
import com.google.android.gms.measurement.internal.zzfr;
import com.google.android.gms.measurement.internal.zzhy;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.reactivex.exceptions.Exceptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
@Deprecated
/* loaded from: classes3.dex */
public class AppMeasurement {
    public static volatile AppMeasurement zza;
    public final zzd zzb;

    /* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
    /* loaded from: classes3.dex */
    public static class ConditionalUserProperty {

        @Keep
        public boolean mActive;

        @Keep
        public String mAppId;

        @Keep
        public long mCreationTimestamp;

        @Keep
        public String mExpiredEventName;

        @Keep
        public Bundle mExpiredEventParams;

        @Keep
        public String mName;

        @Keep
        public String mOrigin;

        @Keep
        public long mTimeToLive;

        @Keep
        public String mTimedOutEventName;

        @Keep
        public Bundle mTimedOutEventParams;

        @Keep
        public String mTriggerEventName;

        @Keep
        public long mTriggerTimeout;

        @Keep
        public String mTriggeredEventName;

        @Keep
        public Bundle mTriggeredEventParams;

        @Keep
        public long mTriggeredTimestamp;

        @Keep
        public Object mValue;

        public ConditionalUserProperty() {
        }

        public ConditionalUserProperty(Bundle bundle) {
            Preconditions.checkNotNull(bundle);
            this.mAppId = (String) Exceptions.zza(bundle, AnalyticsConstants.USER_PROPERTY_APP_ID, String.class, null);
            this.mOrigin = (String) Exceptions.zza(bundle, "origin", String.class, null);
            this.mName = (String) Exceptions.zza(bundle, "name", String.class, null);
            this.mValue = Exceptions.zza(bundle, "value", Object.class, null);
            this.mTriggerEventName = (String) Exceptions.zza(bundle, "trigger_event_name", String.class, null);
            this.mTriggerTimeout = ((Long) Exceptions.zza(bundle, "trigger_timeout", Long.class, 0L)).longValue();
            this.mTimedOutEventName = (String) Exceptions.zza(bundle, "timed_out_event_name", String.class, null);
            this.mTimedOutEventParams = (Bundle) Exceptions.zza(bundle, "timed_out_event_params", Bundle.class, null);
            this.mTriggeredEventName = (String) Exceptions.zza(bundle, "triggered_event_name", String.class, null);
            this.mTriggeredEventParams = (Bundle) Exceptions.zza(bundle, "triggered_event_params", Bundle.class, null);
            this.mTimeToLive = ((Long) Exceptions.zza(bundle, "time_to_live", Long.class, 0L)).longValue();
            this.mExpiredEventName = (String) Exceptions.zza(bundle, "expired_event_name", String.class, null);
            this.mExpiredEventParams = (Bundle) Exceptions.zza(bundle, "expired_event_params", Bundle.class, null);
            this.mActive = ((Boolean) Exceptions.zza(bundle, "active", Boolean.class, Boolean.FALSE)).booleanValue();
            this.mCreationTimestamp = ((Long) Exceptions.zza(bundle, "creation_timestamp", Long.class, 0L)).longValue();
            this.mTriggeredTimestamp = ((Long) Exceptions.zza(bundle, "triggered_timestamp", Long.class, 0L)).longValue();
        }
    }

    public AppMeasurement(zzfr zzfrVar) {
        this.zzb = new zza(zzfrVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Keep
    @Deprecated
    public static AppMeasurement getInstance(Context context) {
        if (zza == null) {
            synchronized (AppMeasurement.class) {
                if (zza == null) {
                    zzhy zzhyVar = (zzhy) FirebaseAnalytics.class.getDeclaredMethod("getScionFrontendApiImplementation", Context.class, Bundle.class).invoke(null, context, null);
                    if (zzhyVar != null) {
                        zza = new AppMeasurement(zzhyVar);
                    } else {
                        zza = new AppMeasurement(zzfr.zzp(context, new zzcl(0L, 0L, true, null, null, null, null, null), null));
                    }
                }
            }
        }
        return zza;
    }

    @Keep
    public void beginAdUnitExposure(String str) {
        this.zzb.zzp(str);
    }

    @Keep
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        this.zzb.zzq(str, str2, bundle);
    }

    @Keep
    public void endAdUnitExposure(String str) {
        this.zzb.zzr(str);
    }

    @Keep
    public long generateEventId() {
        return this.zzb.zzb();
    }

    @Keep
    public String getAppInstanceId() {
        return this.zzb.zzh();
    }

    @Keep
    public List<ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        int size;
        List zzm = this.zzb.zzm(str, str2);
        if (zzm == null) {
            size = 0;
        } else {
            size = zzm.size();
        }
        ArrayList arrayList = new ArrayList(size);
        Iterator it = zzm.iterator();
        while (it.hasNext()) {
            arrayList.add(new ConditionalUserProperty((Bundle) it.next()));
        }
        return arrayList;
    }

    @Keep
    public String getCurrentScreenClass() {
        return this.zzb.zzi();
    }

    @Keep
    public String getCurrentScreenName() {
        return this.zzb.zzj();
    }

    @Keep
    public String getGmpAppId() {
        return this.zzb.zzk();
    }

    @Keep
    public int getMaxUserProperties(String str) {
        return this.zzb.zza(str);
    }

    @Keep
    public Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        return this.zzb.zzo(str, str2, z);
    }

    @Keep
    public void logEventInternal(String str, String str2, Bundle bundle) {
        this.zzb.zzs(str, str2, bundle);
    }

    @Keep
    public void setConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
        Preconditions.checkNotNull(conditionalUserProperty);
        Bundle bundle = new Bundle();
        String str = conditionalUserProperty.mAppId;
        if (str != null) {
            bundle.putString(AnalyticsConstants.USER_PROPERTY_APP_ID, str);
        }
        String str2 = conditionalUserProperty.mOrigin;
        if (str2 != null) {
            bundle.putString("origin", str2);
        }
        String str3 = conditionalUserProperty.mName;
        if (str3 != null) {
            bundle.putString("name", str3);
        }
        Object obj = conditionalUserProperty.mValue;
        if (obj != null) {
            Exceptions.zzb(bundle, obj);
        }
        String str4 = conditionalUserProperty.mTriggerEventName;
        if (str4 != null) {
            bundle.putString("trigger_event_name", str4);
        }
        bundle.putLong("trigger_timeout", conditionalUserProperty.mTriggerTimeout);
        String str5 = conditionalUserProperty.mTimedOutEventName;
        if (str5 != null) {
            bundle.putString("timed_out_event_name", str5);
        }
        Bundle bundle2 = conditionalUserProperty.mTimedOutEventParams;
        if (bundle2 != null) {
            bundle.putBundle("timed_out_event_params", bundle2);
        }
        String str6 = conditionalUserProperty.mTriggeredEventName;
        if (str6 != null) {
            bundle.putString("triggered_event_name", str6);
        }
        Bundle bundle3 = conditionalUserProperty.mTriggeredEventParams;
        if (bundle3 != null) {
            bundle.putBundle("triggered_event_params", bundle3);
        }
        bundle.putLong("time_to_live", conditionalUserProperty.mTimeToLive);
        String str7 = conditionalUserProperty.mExpiredEventName;
        if (str7 != null) {
            bundle.putString("expired_event_name", str7);
        }
        Bundle bundle4 = conditionalUserProperty.mExpiredEventParams;
        if (bundle4 != null) {
            bundle.putBundle("expired_event_params", bundle4);
        }
        bundle.putLong("creation_timestamp", conditionalUserProperty.mCreationTimestamp);
        bundle.putBoolean("active", conditionalUserProperty.mActive);
        bundle.putLong("triggered_timestamp", conditionalUserProperty.mTriggeredTimestamp);
        this.zzb.zzv(bundle);
    }

    public AppMeasurement(zzhy zzhyVar) {
        this.zzb = new zzb(zzhyVar);
    }
}
