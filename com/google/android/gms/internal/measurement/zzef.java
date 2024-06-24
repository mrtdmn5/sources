package com.google.android.gms.internal.measurement;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.compose.ui.geometry.MutableRectKt;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import no.nordicsemi.android.dfu.DfuServiceInitiator;
import okhttp3.Dns$Companion$DnsSystem;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzef {
    public static volatile zzef zzc;
    public final ExecutorService zzb;
    public final AppMeasurementSdk zze;
    public final ArrayList zzf;
    public int zzg;
    public boolean zzh;
    public volatile zzcc zzj;
    public final String zzd = "FA";
    public final Dns$Companion$DnsSystem zza = Dns$Companion$DnsSystem.zza;

    public zzef(Context context, Bundle bundle) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new zzdi());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.zzb = Executors.unconfigurableExecutorService(threadPoolExecutor);
        this.zze = new AppMeasurementSdk(this);
        this.zzf = new ArrayList();
        try {
            if (MutableRectKt.zzc(context, com.google.android.gms.measurement.internal.zzfj.zza(context)) != null) {
                boolean z = false;
                try {
                    Class.forName("com.google.firebase.analytics.FirebaseAnalytics", false, zzef.class.getClassLoader());
                    z = true;
                } catch (ClassNotFoundException unused) {
                }
                if (!z) {
                    this.zzh = true;
                    Log.w(this.zzd, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Remove this value or add Google Analytics for Firebase to resume data collection.");
                    return;
                }
            }
        } catch (IllegalStateException unused2) {
        }
        zzV(new zzcx(this, context, bundle));
        Application application = (Application) context.getApplicationContext();
        if (application == null) {
            Log.w(this.zzd, "Unable to register lifecycle notifications. Application null.");
        } else {
            application.registerActivityLifecycleCallbacks(new zzee(this));
        }
    }

    public static zzef zzg(Context context, Bundle bundle) {
        Preconditions.checkNotNull(context);
        if (zzc == null) {
            synchronized (zzef.class) {
                if (zzc == null) {
                    zzc = new zzef(context, bundle);
                }
            }
        }
        return zzc;
    }

    public final void zzT(Exception exc, boolean z, boolean z2) {
        this.zzh |= z;
        String str = this.zzd;
        if (z) {
            Log.w(str, "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        if (z2) {
            zzV(new zzdg(this, exc));
        }
        Log.w(str, "Error with data collection. Data lost.", exc);
    }

    public final void zzV(zzdu zzduVar) {
        this.zzb.execute(zzduVar);
    }

    public final int zza(String str) {
        zzbz zzbzVar = new zzbz();
        zzV(new zzdj(this, str, zzbzVar));
        Integer num = (Integer) zzbz.zzf(zzbzVar.zzb(10000L), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    public final List zzq(String str, String str2) {
        zzbz zzbzVar = new zzbz();
        zzV(new zzcp(this, str, str2, zzbzVar));
        List list = (List) zzbz.zzf(zzbzVar.zzb(DfuServiceInitiator.DEFAULT_SCAN_TIMEOUT), List.class);
        if (list == null) {
            return Collections.emptyList();
        }
        return list;
    }

    public final Map zzr(String str, String str2, boolean z) {
        zzbz zzbzVar = new zzbz();
        zzV(new zzdf(this, str, str2, z, zzbzVar));
        Bundle zzb = zzbzVar.zzb(DfuServiceInitiator.DEFAULT_SCAN_TIMEOUT);
        if (zzb != null && zzb.size() != 0) {
            HashMap hashMap = new HashMap(zzb.size());
            for (String str3 : zzb.keySet()) {
                Object obj = zzb.get(str3);
                if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                    hashMap.put(str3, obj);
                }
            }
            return hashMap;
        }
        return Collections.emptyMap();
    }
}
