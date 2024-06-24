package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.compose.runtime.collection.IntMap;
import com.animaconnected.firebase.AnalyticsConstants;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzof;
import com.google.android.gms.internal.measurement.zzog;
import com.google.android.gms.internal.measurement.zzpd;
import io.reactivex.exceptions.Exceptions;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import okhttp3.Dns$Companion$DnsSystem;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzhx extends zzf {
    public zzhw zza;
    public final zzs zzb;
    public boolean zzc;
    public zzo zzd;
    public final CopyOnWriteArraySet zze;
    public boolean zzf;
    public final AtomicReference zzg;
    public final Object zzh;
    public zzai zzi;
    public int zzj;
    public final AtomicLong zzk;
    public long zzl;
    public int zzm;
    public final zzhl zzn;

    public zzhx(zzfr zzfrVar) {
        super(zzfrVar);
        this.zze = new CopyOnWriteArraySet();
        this.zzh = new Object();
        this.zzc = true;
        this.zzn = new zzhl(this);
        this.zzg = new AtomicReference();
        this.zzi = new zzai(null, null);
        this.zzj = 100;
        this.zzl = -1L;
        this.zzm = 100;
        this.zzk = new AtomicLong(0L);
        this.zzb = new zzs(zzfrVar);
    }

    public static /* bridge */ /* synthetic */ void zzv(zzhx zzhxVar, zzai zzaiVar, zzai zzaiVar2) {
        zzah[] zzahVarArr = {zzah.ANALYTICS_STORAGE, zzah.AD_STORAGE};
        boolean z = false;
        int r2 = 0;
        while (true) {
            if (r2 >= 2) {
                break;
            }
            zzah zzahVar = zzahVarArr[r2];
            if (!zzaiVar2.zzi(zzahVar) && zzaiVar.zzi(zzahVar)) {
                z = true;
                break;
            }
            r2++;
        }
        boolean zzl = zzaiVar.zzl(zzaiVar2, zzah.ANALYTICS_STORAGE, zzah.AD_STORAGE);
        if (!z && !zzl) {
            return;
        }
        zzhxVar.zzt.zzh().zzo();
    }

    public static void zzw(zzhx zzhxVar, zzai zzaiVar, int r6, long j, boolean z, boolean z2) {
        boolean z3;
        zzhxVar.zzg();
        zzhxVar.zza();
        long j2 = zzhxVar.zzl;
        zzfr zzfrVar = zzhxVar.zzt;
        if (j <= j2) {
            int r0 = zzhxVar.zzm;
            zzai zzaiVar2 = zzai.zza;
            if (r0 <= r6) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                zzeh zzehVar = zzfrVar.zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzj.zzb(zzaiVar, "Dropped out-of-date consent setting, proposed settings");
                return;
            }
        }
        zzew zzewVar = zzfrVar.zzl;
        zzfr.zzP(zzewVar);
        zzewVar.zzg();
        if (zzewVar.zzl(r6)) {
            SharedPreferences.Editor edit = zzewVar.zza().edit();
            edit.putString("consent_settings", zzaiVar.zzh());
            edit.putInt("consent_source", r6);
            edit.apply();
            zzhxVar.zzl = j;
            zzhxVar.zzm = r6;
            zzjm zzt = zzfrVar.zzt();
            zzt.zzg();
            zzt.zza();
            if (z) {
                zzfr zzfrVar2 = zzt.zzt;
                zzfrVar2.getClass();
                zzfrVar2.zzi().zzj();
            }
            if (zzt.zzM()) {
                zzt.zzR(new zzja(zzt, zzt.zzO(false)));
            }
            if (z2) {
                zzfrVar.zzt().zzu(new AtomicReference());
                return;
            }
            return;
        }
        zzeh zzehVar2 = zzfrVar.zzm;
        zzfr.zzR(zzehVar2);
        zzehVar2.zzj.zzb(Integer.valueOf(r6), "Lower precedence consent source ignored, proposed source");
    }

    public final void zzA(String str, String str2, Bundle bundle) {
        zzfr zzfrVar = this.zzt;
        zzfrVar.zzr.getClass();
        long currentTimeMillis = System.currentTimeMillis();
        Preconditions.checkNotEmpty(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str);
        bundle2.putLong("creation_timestamp", currentTimeMillis);
        if (str2 != null) {
            bundle2.putString("expired_event_name", str2);
            bundle2.putBundle("expired_event_params", bundle);
        }
        zzfo zzfoVar = zzfrVar.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzp(new zzhg(this, bundle2));
    }

    public final void zzB$1() {
        zzfr zzfrVar = this.zzt;
        if ((zzfrVar.zze.getApplicationContext() instanceof Application) && this.zza != null) {
            ((Application) zzfrVar.zze.getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zza);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x00f1, code lost:            if (r5 > 100) goto L188;     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0123, code lost:            if (r6 > 100) goto L197;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzE(java.lang.String r21, java.lang.String r22, android.os.Bundle r23, boolean r24, boolean r25, long r26) {
        /*
            Method dump skipped, instructions count: 487
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhx.zzE(java.lang.String, java.lang.String, android.os.Bundle, boolean, boolean, long):void");
    }

    public final void zzG(String str, String str2, Bundle bundle) {
        zzg();
        this.zzt.zzr.getClass();
        zzH(System.currentTimeMillis(), bundle, str, str2);
    }

    public final void zzH(long j, Bundle bundle, String str, String str2) {
        boolean z;
        zzg();
        if (this.zzd != null && !zzlb.zzah(str2)) {
            z = false;
        } else {
            z = true;
        }
        zzI(str, str2, j, bundle, true, z, true, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x03c1  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0417  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0113  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzI(java.lang.String r27, java.lang.String r28, long r29, android.os.Bundle r31, boolean r32, boolean r33, boolean r34, java.lang.String r35) {
        /*
            Method dump skipped, instructions count: 1269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhx.zzI(java.lang.String, java.lang.String, long, android.os.Bundle, boolean, boolean, boolean, java.lang.String):void");
    }

    public final void zzL(long j, boolean z) {
        zzg();
        zza();
        zzfr zzfrVar = this.zzt;
        zzeh zzehVar = zzfrVar.zzm;
        zzfr.zzR(zzehVar);
        zzehVar.zzk.zza("Resetting analytics data (FE)");
        zzkc zzkcVar = zzfrVar.zzo;
        zzfr.zzQ(zzkcVar);
        zzkcVar.zzg();
        zzka zzkaVar = zzkcVar.zzb;
        zzkaVar.zzd.zzb();
        zzkaVar.zza = 0L;
        zzkaVar.zzb = 0L;
        zzpd.zzc();
        zzdt zzdtVar = zzdu.zzam;
        zzag zzagVar = zzfrVar.zzk;
        if (zzagVar.zzs(null, zzdtVar)) {
            zzfrVar.zzh().zzo();
        }
        boolean zzJ = zzfrVar.zzJ();
        zzew zzewVar = zzfrVar.zzl;
        zzfr.zzP(zzewVar);
        zzewVar.zzc.zzb(j);
        zzfr zzfrVar2 = zzewVar.zzt;
        zzew zzewVar2 = zzfrVar2.zzl;
        zzfr.zzP(zzewVar2);
        if (!TextUtils.isEmpty(zzewVar2.zzp.zza())) {
            zzewVar.zzp.zzb(null);
        }
        zzof zzofVar = zzof.zza;
        ((zzog) zzofVar.zzb.zza()).zza();
        zzdt zzdtVar2 = zzdu.zzad;
        zzag zzagVar2 = zzfrVar2.zzk;
        if (zzagVar2.zzs(null, zzdtVar2)) {
            zzewVar.zzj.zzb(0L);
        }
        zzewVar.zzk.zzb(0L);
        if (!zzagVar2.zzv()) {
            zzewVar.zzi(!zzJ);
        }
        zzewVar.zzq.zzb(null);
        zzewVar.zzr.zzb(0L);
        zzewVar.zzs.zzb(null);
        if (z) {
            zzjm zzt = zzfrVar.zzt();
            zzt.zzg();
            zzt.zza();
            zzq zzO = zzt.zzO(false);
            zzfr zzfrVar3 = zzt.zzt;
            zzfrVar3.getClass();
            zzfrVar3.zzi().zzj();
            zzt.zzR(new zziq(zzt, zzO));
        }
        ((zzog) zzofVar.zzb.zza()).zza();
        if (zzagVar.zzs(null, zzdtVar2)) {
            zzfr.zzQ(zzkcVar);
            zzkcVar.zza.zza();
        }
        this.zzc = !zzJ;
    }

    public final void zzQ(Bundle bundle, long j) {
        Preconditions.checkNotNull(bundle);
        Bundle bundle2 = new Bundle(bundle);
        boolean isEmpty = TextUtils.isEmpty(bundle2.getString(AnalyticsConstants.USER_PROPERTY_APP_ID));
        zzfr zzfrVar = this.zzt;
        if (!isEmpty) {
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzg.zza("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove(AnalyticsConstants.USER_PROPERTY_APP_ID);
        Exceptions.zza(bundle2, AnalyticsConstants.USER_PROPERTY_APP_ID, String.class, null);
        Exceptions.zza(bundle2, "origin", String.class, null);
        Exceptions.zza(bundle2, "name", String.class, null);
        Exceptions.zza(bundle2, "value", Object.class, null);
        Exceptions.zza(bundle2, "trigger_event_name", String.class, null);
        Exceptions.zza(bundle2, "trigger_timeout", Long.class, 0L);
        Exceptions.zza(bundle2, "timed_out_event_name", String.class, null);
        Exceptions.zza(bundle2, "timed_out_event_params", Bundle.class, null);
        Exceptions.zza(bundle2, "triggered_event_name", String.class, null);
        Exceptions.zza(bundle2, "triggered_event_params", Bundle.class, null);
        Exceptions.zza(bundle2, "time_to_live", Long.class, 0L);
        Exceptions.zza(bundle2, "expired_event_name", String.class, null);
        Exceptions.zza(bundle2, "expired_event_params", Bundle.class, null);
        Preconditions.checkNotEmpty(bundle2.getString("name"));
        Preconditions.checkNotEmpty(bundle2.getString("origin"));
        Preconditions.checkNotNull(bundle2.get("value"));
        bundle2.putLong("creation_timestamp", j);
        String string = bundle2.getString("name");
        Object obj = bundle2.get("value");
        zzlb zzlbVar = zzfrVar.zzp;
        zzfr.zzP(zzlbVar);
        int zzl = zzlbVar.zzl(string);
        zzec zzecVar = zzfrVar.zzq;
        zzeh zzehVar2 = zzfrVar.zzm;
        if (zzl == 0) {
            zzlb zzlbVar2 = zzfrVar.zzp;
            zzfr.zzP(zzlbVar2);
            if (zzlbVar2.zzd(obj, string) == 0) {
                zzfr.zzP(zzlbVar2);
                Object zzB = zzlbVar2.zzB(obj, string);
                if (zzB == null) {
                    zzfr.zzR(zzehVar2);
                    zzehVar2.zzd.zzc(zzecVar.zzf(string), obj, "Unable to normalize conditional user property value");
                    return;
                }
                Exceptions.zzb(bundle2, zzB);
                long j2 = bundle2.getLong("trigger_timeout");
                if (!TextUtils.isEmpty(bundle2.getString("trigger_event_name")) && (j2 > 15552000000L || j2 < 1)) {
                    zzfr.zzR(zzehVar2);
                    zzehVar2.zzd.zzc(zzecVar.zzf(string), Long.valueOf(j2), "Invalid conditional user property timeout");
                    return;
                }
                long j3 = bundle2.getLong("time_to_live");
                if (j3 <= 15552000000L && j3 >= 1) {
                    zzfo zzfoVar = zzfrVar.zzn;
                    zzfr.zzR(zzfoVar);
                    zzfoVar.zzp(new zzhf(this, bundle2));
                    return;
                } else {
                    zzfr.zzR(zzehVar2);
                    zzehVar2.zzd.zzc(zzecVar.zzf(string), Long.valueOf(j3), "Invalid conditional user property time to live");
                    return;
                }
            }
            zzfr.zzR(zzehVar2);
            zzehVar2.zzd.zzc(zzecVar.zzf(string), obj, "Invalid conditional user property value");
            return;
        }
        zzfr.zzR(zzehVar2);
        zzehVar2.zzd.zzb(zzecVar.zzf(string), "Invalid conditional user property name");
    }

    public final void zzR(Bundle bundle, int r8, long j) {
        Object obj;
        String string;
        zza();
        zzai zzaiVar = zzai.zza;
        zzah[] values = zzah.values();
        int length = values.length;
        int r2 = 0;
        while (true) {
            obj = null;
            if (r2 >= length) {
                break;
            }
            zzah zzahVar = values[r2];
            if (bundle.containsKey(zzahVar.zzd) && (string = bundle.getString(zzahVar.zzd)) != null) {
                if (string.equals("granted")) {
                    obj = Boolean.TRUE;
                } else if (string.equals("denied")) {
                    obj = Boolean.FALSE;
                }
                if (obj == null) {
                    obj = string;
                    break;
                }
            }
            r2++;
        }
        if (obj != null) {
            zzfr zzfrVar = this.zzt;
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzi.zzb(obj, "Ignoring invalid consent setting");
            zzeh zzehVar2 = zzfrVar.zzm;
            zzfr.zzR(zzehVar2);
            zzehVar2.zzi.zza("Valid consent values are 'granted', 'denied'");
        }
        zzS(zzai.zza(bundle), r8, j);
    }

    public final void zzS(zzai zzaiVar, int r18, long j) {
        zzai zzaiVar2;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        zzai zzaiVar3 = zzaiVar;
        zza();
        if (r18 != -10 && ((Boolean) zzaiVar3.zzb.get(zzah.AD_STORAGE)) == null && ((Boolean) zzaiVar3.zzb.get(zzah.ANALYTICS_STORAGE)) == null) {
            zzeh zzehVar = this.zzt.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzi.zza("Discarding empty consent settings");
            return;
        }
        synchronized (this.zzh) {
            try {
                zzaiVar2 = this.zzi;
                int r2 = this.zzj;
                zzai zzaiVar4 = zzai.zza;
                z = false;
                if (r18 <= r2) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    z3 = zzaiVar3.zzl(zzaiVar2, (zzah[]) zzaiVar3.zzb.keySet().toArray(new zzah[0]));
                    zzah zzahVar = zzah.ANALYTICS_STORAGE;
                    if (zzaiVar3.zzi(zzahVar) && !this.zzi.zzi(zzahVar)) {
                        z = true;
                    }
                    zzaiVar3 = zzaiVar3.zzd(this.zzi);
                    this.zzi = zzaiVar3;
                    this.zzj = r18;
                    z4 = z;
                    z = true;
                } else {
                    z3 = false;
                    z4 = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (!z) {
            zzeh zzehVar2 = this.zzt.zzm;
            zzfr.zzR(zzehVar2);
            zzehVar2.zzj.zzb(zzaiVar3, "Ignoring lower-priority consent settings, proposed settings");
            return;
        }
        long andIncrement = this.zzk.getAndIncrement();
        if (z3) {
            this.zzg.set(null);
            zzfo zzfoVar = this.zzt.zzn;
            zzfr.zzR(zzfoVar);
            zzfoVar.zzq(new zzhr(this, zzaiVar3, j, r18, andIncrement, z4, zzaiVar2));
            return;
        }
        zzhs zzhsVar = new zzhs(this, zzaiVar3, r18, andIncrement, z4, zzaiVar2);
        if (r18 != 30 && r18 != -10) {
            zzfo zzfoVar2 = this.zzt.zzn;
            zzfr.zzR(zzfoVar2);
            zzfoVar2.zzp(zzhsVar);
        } else {
            zzfo zzfoVar3 = this.zzt.zzn;
            zzfr.zzR(zzfoVar3);
            zzfoVar3.zzq(zzhsVar);
        }
    }

    public final void zzV(zzai zzaiVar) {
        boolean z;
        Boolean bool;
        zzg();
        if ((zzaiVar.zzi(zzah.ANALYTICS_STORAGE) && zzaiVar.zzi(zzah.AD_STORAGE)) || this.zzt.zzt().zzM()) {
            z = true;
        } else {
            z = false;
        }
        zzfr zzfrVar = this.zzt;
        zzfo zzfoVar = zzfrVar.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        if (z != zzfrVar.zzF) {
            zzfr zzfrVar2 = this.zzt;
            zzfo zzfoVar2 = zzfrVar2.zzn;
            zzfr.zzR(zzfoVar2);
            zzfoVar2.zzg();
            zzfrVar2.zzF = z;
            zzew zzewVar = this.zzt.zzl;
            zzfr.zzP(zzewVar);
            zzewVar.zzg();
            if (zzewVar.zza().contains("measurement_enabled_from_api")) {
                bool = Boolean.valueOf(zzewVar.zza().getBoolean("measurement_enabled_from_api", true));
            } else {
                bool = null;
            }
            if (!z || bool == null || bool.booleanValue()) {
                zzaa(Boolean.valueOf(z), false);
            }
        }
    }

    public final void zzX(String str, String str2, Object obj, boolean z, long j) {
        String str3;
        int r6;
        if (str == null) {
            str3 = "app";
        } else {
            str3 = str;
        }
        zzfr zzfrVar = this.zzt;
        int r4 = 0;
        if (z) {
            zzlb zzlbVar = zzfrVar.zzp;
            zzfr.zzP(zzlbVar);
            r6 = zzlbVar.zzl(str2);
        } else {
            zzlb zzlbVar2 = zzfrVar.zzp;
            zzfr.zzP(zzlbVar2);
            if (zzlbVar2.zzac("user property", str2)) {
                if (!zzlbVar2.zzZ("user property", zzgq.zza, null, str2)) {
                    r6 = 15;
                } else {
                    zzlbVar2.zzt.getClass();
                    if (zzlbVar2.zzY("user property", 24, str2)) {
                        r6 = 0;
                    }
                }
            }
            r6 = 6;
        }
        zzhl zzhlVar = this.zzn;
        if (r6 != 0) {
            zzlb zzlbVar3 = zzfrVar.zzp;
            zzfr.zzP(zzlbVar3);
            zzlbVar3.getClass();
            String zzD = zzlb.zzD(str2, 24, true);
            if (str2 != null) {
                r4 = str2.length();
            }
            zzlb zzlbVar4 = zzfrVar.zzp;
            zzfr.zzP(zzlbVar4);
            zzlbVar4.getClass();
            zzlb.zzN(zzhlVar, null, r6, "_ev", zzD, r4);
            return;
        }
        if (obj != null) {
            zzlb zzlbVar5 = zzfrVar.zzp;
            zzfr.zzP(zzlbVar5);
            int zzd = zzlbVar5.zzd(obj, str2);
            zzlb zzlbVar6 = zzfrVar.zzp;
            if (zzd != 0) {
                zzfr.zzP(zzlbVar6);
                zzlbVar6.getClass();
                String zzD2 = zzlb.zzD(str2, 24, true);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    r4 = obj.toString().length();
                }
                zzfr.zzP(zzlbVar6);
                zzlbVar6.getClass();
                zzlb.zzN(zzhlVar, null, zzd, "_ev", zzD2, r4);
                return;
            }
            zzfr.zzP(zzlbVar6);
            Object zzB = zzlbVar6.zzB(obj, str2);
            if (zzB != null) {
                zzfo zzfoVar = zzfrVar.zzn;
                zzfr.zzR(zzfoVar);
                zzfoVar.zzp(new zzhc(this, str3, str2, zzB, j));
                return;
            }
            return;
        }
        zzfo zzfoVar2 = zzfrVar.zzn;
        zzfr.zzR(zzfoVar2);
        zzfoVar2.zzp(new zzhc(this, str3, str2, null, j));
    }

    public final void zzY(long j, Object obj, String str, String str2) {
        boolean zzq;
        long j2;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zza();
        boolean equals = "allow_personalized_ads".equals(str2);
        zzfr zzfrVar = this.zzt;
        if (equals) {
            if (obj instanceof String) {
                String str3 = (String) obj;
                if (!TextUtils.isEmpty(str3)) {
                    String str4 = "false";
                    if (true != "false".equals(str3.toLowerCase(Locale.ENGLISH))) {
                        j2 = 0;
                    } else {
                        j2 = 1;
                    }
                    Long valueOf = Long.valueOf(j2);
                    zzew zzewVar = zzfrVar.zzl;
                    zzfr.zzP(zzewVar);
                    if (valueOf.longValue() == 1) {
                        str4 = "true";
                    }
                    zzewVar.zzh.zzb(str4);
                    obj = valueOf;
                    str2 = "_npa";
                }
            }
            if (obj == null) {
                zzew zzewVar2 = zzfrVar.zzl;
                zzfr.zzP(zzewVar2);
                zzewVar2.zzh.zzb("unset");
                obj = obj;
                str2 = "_npa";
            }
        }
        Object obj2 = obj;
        String str5 = str2;
        if (!zzfrVar.zzJ()) {
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzl.zza("User property not set since app measurement is disabled");
            return;
        }
        if (!zzfrVar.zzM()) {
            return;
        }
        zzkw zzkwVar = new zzkw(j, obj2, str5, str);
        zzjm zzt = zzfrVar.zzt();
        zzt.zzg();
        zzt.zza();
        zzfr zzfrVar2 = zzt.zzt;
        zzfrVar2.getClass();
        zzea zzi = zzfrVar2.zzi();
        zzi.getClass();
        Parcel obtain = Parcel.obtain();
        zzkx.zza(zzkwVar, obtain);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length > 131072) {
            zzeh zzehVar2 = zzi.zzt.zzm;
            zzfr.zzR(zzehVar2);
            zzehVar2.zze.zza("User property too long for local database. Sending directly to service");
            zzq = false;
        } else {
            zzq = zzi.zzq(1, marshall);
        }
        zzt.zzR(new zzio(zzt, zzt.zzO(true), zzq, zzkwVar));
    }

    public final void zzaa(Boolean bool, boolean z) {
        zzg();
        zza();
        zzfr zzfrVar = this.zzt;
        zzeh zzehVar = zzfrVar.zzm;
        zzfr.zzR(zzehVar);
        zzehVar.zzk.zzb(bool, "Setting app measurement enabled (FE)");
        zzew zzewVar = zzfrVar.zzl;
        zzfr.zzP(zzewVar);
        zzewVar.zzh(bool);
        if (z) {
            zzew zzewVar2 = zzfrVar.zzl;
            zzfr.zzP(zzewVar2);
            zzewVar2.zzg();
            SharedPreferences.Editor edit = zzewVar2.zza().edit();
            if (bool != null) {
                edit.putBoolean("measurement_enabled_from_api", bool.booleanValue());
            } else {
                edit.remove("measurement_enabled_from_api");
            }
            edit.apply();
        }
        zzfo zzfoVar = zzfrVar.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        if (!zzfrVar.zzF && (bool == null || bool.booleanValue())) {
            return;
        }
        zzab();
    }

    public final void zzab() {
        long j;
        zzg();
        zzfr zzfrVar = this.zzt;
        zzew zzewVar = zzfrVar.zzl;
        zzfr.zzP(zzewVar);
        String zza = zzewVar.zzh.zza();
        if (zza != null) {
            boolean equals = "unset".equals(zza);
            Dns$Companion$DnsSystem dns$Companion$DnsSystem = zzfrVar.zzr;
            if (equals) {
                dns$Companion$DnsSystem.getClass();
                zzY(System.currentTimeMillis(), null, "app", "_npa");
            } else {
                if (true != "true".equals(zza)) {
                    j = 0;
                } else {
                    j = 1;
                }
                Long valueOf = Long.valueOf(j);
                dns$Companion$DnsSystem.getClass();
                zzY(System.currentTimeMillis(), valueOf, "app", "_npa");
            }
        }
        boolean zzJ = zzfrVar.zzJ();
        zzeh zzehVar = zzfrVar.zzm;
        if (zzJ && this.zzc) {
            zzfr.zzR(zzehVar);
            zzehVar.zzk.zza("Recording app launch after enabling measurement for the first time (FE)");
            zzz();
            ((zzog) zzof.zza.zzb.zza()).zza();
            if (zzfrVar.zzk.zzs(null, zzdu.zzad)) {
                zzkc zzkcVar = zzfrVar.zzo;
                zzfr.zzQ(zzkcVar);
                zzkcVar.zza.zza();
            }
            zzfo zzfoVar = zzfrVar.zzn;
            zzfr.zzR(zzfoVar);
            zzfoVar.zzp(new zzgz(this));
            return;
        }
        zzfr.zzR(zzehVar);
        zzehVar.zzk.zza("Updating Scion state (FE)");
        zzjm zzt = zzfrVar.zzt();
        zzt.zzg();
        zzt.zza();
        zzt.zzR(new zziz(zzt, zzt.zzO(true)));
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final boolean zzf() {
        return false;
    }

    public final String zzo$1() {
        return (String) this.zzg.get();
    }

    public final void zzz() {
        zzg();
        zza();
        zzfr zzfrVar = this.zzt;
        if (zzfrVar.zzM()) {
            zzdt zzdtVar = zzdu.zzX;
            zzag zzagVar = zzfrVar.zzk;
            if (zzagVar.zzs(null, zzdtVar)) {
                zzagVar.zzt.getClass();
                Boolean zzk = zzagVar.zzk("google_analytics_deferred_deep_link_enabled");
                if (zzk != null && zzk.booleanValue()) {
                    zzeh zzehVar = zzfrVar.zzm;
                    zzfr.zzR(zzehVar);
                    zzehVar.zzk.zza("Deferred Deep Link feature enabled.");
                    zzfo zzfoVar = zzfrVar.zzn;
                    zzfr.zzR(zzfoVar);
                    zzfoVar.zzp(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzgy
                        @Override // java.lang.Runnable
                        public final void run() {
                            Pair pair;
                            boolean z;
                            NetworkInfo activeNetworkInfo;
                            zzhx zzhxVar = zzhx.this;
                            zzhxVar.zzg();
                            zzfr zzfrVar2 = zzhxVar.zzt;
                            zzew zzewVar = zzfrVar2.zzl;
                            zzfr.zzP(zzewVar);
                            boolean zzb = zzewVar.zzn.zzb();
                            zzeh zzehVar2 = zzfrVar2.zzm;
                            if (!zzb) {
                                zzew zzewVar2 = zzfrVar2.zzl;
                                zzfr.zzP(zzewVar2);
                                long zza = zzewVar2.zzo.zza();
                                zzfr.zzP(zzewVar2);
                                zzewVar2.zzo.zzb(1 + zza);
                                if (zza >= 5) {
                                    zzfr.zzR(zzehVar2);
                                    zzehVar2.zzg.zza("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
                                    zzfr.zzP(zzewVar2);
                                    zzewVar2.zzn.zza(true);
                                    return;
                                }
                                zzfo zzfoVar2 = zzfrVar2.zzn;
                                zzfr.zzR(zzfoVar2);
                                zzfoVar2.zzg();
                                zzib zzibVar = zzfrVar2.zzv;
                                zzfr.zzR(zzibVar);
                                zzfr.zzR(zzibVar);
                                String zzl = zzfrVar2.zzh().zzl();
                                zzfr.zzP(zzewVar2);
                                zzewVar2.zzg();
                                zzfr zzfrVar3 = zzewVar2.zzt;
                                zzfrVar3.zzr.getClass();
                                long elapsedRealtime = SystemClock.elapsedRealtime();
                                String str = zzewVar2.zzv;
                                if (str != null && elapsedRealtime < zzewVar2.zzx) {
                                    pair = new Pair(str, Boolean.valueOf(zzewVar2.zzw));
                                } else {
                                    zzewVar2.zzx = zzfrVar3.zzk.zzi(zzl, zzdu.zza) + elapsedRealtime;
                                    try {
                                        AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(zzfrVar3.zze);
                                        zzewVar2.zzv = "";
                                        String str2 = advertisingIdInfo.zza;
                                        if (str2 != null) {
                                            zzewVar2.zzv = str2;
                                        }
                                        zzewVar2.zzw = advertisingIdInfo.zzb;
                                    } catch (Exception e) {
                                        zzeh zzehVar3 = zzfrVar3.zzm;
                                        zzfr.zzR(zzehVar3);
                                        zzehVar3.zzk.zzb(e, "Unable to get advertising id");
                                        zzewVar2.zzv = "";
                                    }
                                    pair = new Pair(zzewVar2.zzv, Boolean.valueOf(zzewVar2.zzw));
                                }
                                Boolean zzk2 = zzfrVar2.zzk.zzk("google_analytics_adid_collection_enabled");
                                if (zzk2 != null && !zzk2.booleanValue()) {
                                    z = false;
                                } else {
                                    z = true;
                                }
                                if (z && !((Boolean) pair.second).booleanValue() && !TextUtils.isEmpty((CharSequence) pair.first)) {
                                    zzfr.zzR(zzibVar);
                                    zzibVar.zzu();
                                    zzfr zzfrVar4 = zzibVar.zzt;
                                    ConnectivityManager connectivityManager = (ConnectivityManager) zzfrVar4.zze.getSystemService("connectivity");
                                    URL url = null;
                                    if (connectivityManager != null) {
                                        try {
                                            activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                                        } catch (SecurityException unused) {
                                        }
                                        if (activeNetworkInfo == null && activeNetworkInfo.isConnected()) {
                                            zzlb zzlbVar = zzfrVar2.zzp;
                                            zzfr.zzP(zzlbVar);
                                            zzfrVar2.zzh().zzt.zzk.zzh();
                                            String str3 = (String) pair.first;
                                            long zza2 = zzewVar2.zzo.zza() - 1;
                                            zzfr zzfrVar5 = zzlbVar.zzt;
                                            try {
                                                Preconditions.checkNotEmpty(str3);
                                                Preconditions.checkNotEmpty(zzl);
                                                String format = String.format("https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s&retry=%s", String.format("v%s.%s", 74029L, Integer.valueOf(zzlbVar.zzm())), str3, zzl, Long.valueOf(zza2));
                                                if (zzl.equals(zzfrVar5.zzk.zzB("debug.deferred.deeplink"))) {
                                                    format = format.concat("&ddl_test=1");
                                                }
                                                url = new URL(format);
                                            } catch (IllegalArgumentException | MalformedURLException e2) {
                                                zzeh zzehVar4 = zzfrVar5.zzm;
                                                zzfr.zzR(zzehVar4);
                                                zzehVar4.zzd.zzb(e2.getMessage(), "Failed to create BOW URL for Deferred Deep Link. exception");
                                            }
                                            if (url != null) {
                                                zzfr.zzR(zzibVar);
                                                IntMap intMap = new IntMap(zzfrVar2);
                                                zzibVar.zzg();
                                                zzibVar.zzu();
                                                zzfo zzfoVar3 = zzfrVar4.zzn;
                                                zzfr.zzR(zzfoVar3);
                                                zzfoVar3.zzo(new zzia(zzibVar, zzl, url, intMap));
                                                return;
                                            }
                                            return;
                                        }
                                        zzfr.zzR(zzehVar2);
                                        zzehVar2.zzg.zza("Network is not available for Deferred Deep Link request. Skipping");
                                        return;
                                    }
                                    activeNetworkInfo = null;
                                    if (activeNetworkInfo == null) {
                                    }
                                    zzfr.zzR(zzehVar2);
                                    zzehVar2.zzg.zza("Network is not available for Deferred Deep Link request. Skipping");
                                    return;
                                }
                                zzfr.zzR(zzehVar2);
                                zzehVar2.zzk.zza("ADID unavailable to retrieve Deferred Deep Link. Skipping");
                                return;
                            }
                            zzfr.zzR(zzehVar2);
                            zzehVar2.zzk.zza("Deferred Deep Link already retrieved. Not fetching again.");
                        }
                    });
                }
            }
            zzjm zzt = zzfrVar.zzt();
            zzt.zzg();
            zzt.zza();
            zzq zzO = zzt.zzO(true);
            zzt.zzt.zzi().zzq(3, new byte[0]);
            zzt.zzR(new zzit(zzt, zzO));
            this.zzc = false;
            zzew zzewVar = zzfrVar.zzl;
            zzfr.zzP(zzewVar);
            zzewVar.zzg();
            String string = zzewVar.zza().getString("previous_os_version", null);
            zzewVar.zzt.zzg().zzu();
            String str = Build.VERSION.RELEASE;
            if (!TextUtils.isEmpty(str) && !str.equals(string)) {
                SharedPreferences.Editor edit = zzewVar.zza().edit();
                edit.putString("previous_os_version", str);
                edit.apply();
            }
            if (!TextUtils.isEmpty(string)) {
                zzfrVar.zzg().zzu();
                if (!string.equals(str)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("_po", string);
                    zzG("auto", "_ou", bundle);
                }
            }
        }
    }
}
