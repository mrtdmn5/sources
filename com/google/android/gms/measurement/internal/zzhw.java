package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import com.animaconnected.secondo.provider.configuration.database.ConfigurationItem;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
@TargetApi(14)
/* loaded from: classes3.dex */
public final class zzhw implements Application.ActivityLifecycleCallbacks {
    public final /* synthetic */ zzhx zza;

    public /* synthetic */ zzhw(zzhx zzhxVar) {
        this.zza = zzhxVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zzim zzimVar;
        Uri data;
        boolean z;
        String str;
        zzhx zzhxVar = this.zza;
        try {
            try {
                zzeh zzehVar = zzhxVar.zzt.zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzl.zza("onActivityCreated");
                Intent intent = activity.getIntent();
                zzfr zzfrVar = zzhxVar.zzt;
                if (intent != null && (data = intent.getData()) != null && data.isHierarchical()) {
                    zzfr.zzP(zzfrVar.zzp);
                    String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
                    boolean z2 = true;
                    if (!"android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) && !"https://www.google.com".equals(stringExtra) && !"android-app://com.google.appcrawler".equals(stringExtra)) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (true != z) {
                        str = "auto";
                    } else {
                        str = "gs";
                    }
                    String str2 = str;
                    String queryParameter = data.getQueryParameter("referrer");
                    if (bundle != null) {
                        z2 = false;
                    }
                    zzfo zzfoVar = zzfrVar.zzn;
                    zzfr.zzR(zzfoVar);
                    zzfoVar.zzp(new zzhu(this, z2, data, str2, queryParameter));
                }
                zzimVar = zzfrVar.zzs;
            } catch (RuntimeException e) {
                zzeh zzehVar2 = zzhxVar.zzt.zzm;
                zzfr.zzR(zzehVar2);
                zzehVar2.zzd.zzb(e, "Throwable caught in onActivityCreated");
                zzimVar = zzhxVar.zzt.zzs;
            }
            zzfr.zzQ(zzimVar);
            zzimVar.zzr(activity, bundle);
        } catch (Throwable th) {
            zzim zzimVar2 = zzhxVar.zzt.zzs;
            zzfr.zzQ(zzimVar2);
            zzimVar2.zzr(activity, bundle);
            throw th;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        zzim zzimVar = this.zza.zzt.zzs;
        zzfr.zzQ(zzimVar);
        synchronized (zzimVar.zzj) {
            if (activity == zzimVar.zze) {
                zzimVar.zze = null;
            }
        }
        if (zzimVar.zzt.zzk.zzu()) {
            zzimVar.zzd.remove(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        zzim zzimVar = this.zza.zzt.zzs;
        zzfr.zzQ(zzimVar);
        synchronized (zzimVar.zzj) {
            zzimVar.zzi = false;
            zzimVar.zzf = true;
        }
        zzimVar.zzt.zzr.getClass();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (!zzimVar.zzt.zzk.zzu()) {
            zzimVar.zzb = null;
            zzfo zzfoVar = zzimVar.zzt.zzn;
            zzfr.zzR(zzfoVar);
            zzfoVar.zzp(new zzij(zzimVar, elapsedRealtime));
        } else {
            zzie zzy = zzimVar.zzy(activity);
            zzimVar.zzc = zzimVar.zzb;
            zzimVar.zzb = null;
            zzfo zzfoVar2 = zzimVar.zzt.zzn;
            zzfr.zzR(zzfoVar2);
            zzfoVar2.zzp(new zzik(zzimVar, zzy, elapsedRealtime));
        }
        zzkc zzkcVar = this.zza.zzt.zzo;
        zzfr.zzQ(zzkcVar);
        zzkcVar.zzt.zzr.getClass();
        long elapsedRealtime2 = SystemClock.elapsedRealtime();
        zzfo zzfoVar3 = zzkcVar.zzt.zzn;
        zzfr.zzR(zzfoVar3);
        zzfoVar3.zzp(new zzjv(zzkcVar, elapsedRealtime2));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        zzkc zzkcVar = this.zza.zzt.zzo;
        zzfr.zzQ(zzkcVar);
        zzkcVar.zzt.zzr.getClass();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        zzfo zzfoVar = zzkcVar.zzt.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzp(new zzju(zzkcVar, elapsedRealtime));
        zzim zzimVar = this.zza.zzt.zzs;
        zzfr.zzQ(zzimVar);
        synchronized (zzimVar.zzj) {
            zzimVar.zzi = true;
            if (activity != zzimVar.zze) {
                synchronized (zzimVar.zzj) {
                    zzimVar.zze = activity;
                    zzimVar.zzf = false;
                }
                if (zzimVar.zzt.zzk.zzu()) {
                    zzimVar.zzg = null;
                    zzfo zzfoVar2 = zzimVar.zzt.zzn;
                    zzfr.zzR(zzfoVar2);
                    zzfoVar2.zzp(new zzil(zzimVar));
                }
            }
        }
        if (!zzimVar.zzt.zzk.zzu()) {
            zzimVar.zzb = zzimVar.zzg;
            zzfo zzfoVar3 = zzimVar.zzt.zzn;
            zzfr.zzR(zzfoVar3);
            zzfoVar3.zzp(new zzii(zzimVar));
            return;
        }
        zzimVar.zzz(activity, zzimVar.zzy(activity), false);
        zzd zzd = zzimVar.zzt.zzd();
        zzd.zzt.zzr.getClass();
        long elapsedRealtime2 = SystemClock.elapsedRealtime();
        zzfo zzfoVar4 = zzd.zzt.zzn;
        zzfr.zzR(zzfoVar4);
        zzfoVar4.zzp(new zzc(zzd, elapsedRealtime2));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzie zzieVar;
        zzim zzimVar = this.zza.zzt.zzs;
        zzfr.zzQ(zzimVar);
        if (zzimVar.zzt.zzk.zzu() && bundle != null && (zzieVar = (zzie) zzimVar.zzd.get(activity)) != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putLong(ConfigurationItem.COLUMN_NAME_ID, zzieVar.zzc);
            bundle2.putString("name", zzieVar.zza);
            bundle2.putString("referrer_name", zzieVar.zzb);
            bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}
