package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import com.animaconnected.firebase.AnalyticsConstants;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.UidVerifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.Dns$Companion$DnsSystem;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzgj extends zzdw {
    public final zzkt zza;
    public Boolean zzb;
    public String zzc;

    public zzgj(zzkt zzktVar) {
        Preconditions.checkNotNull(zzktVar);
        this.zza = zzktVar;
        this.zzc = null;
    }

    public final void zzA(zzaw zzawVar, zzq zzqVar) {
        zzkt zzktVar = this.zza;
        zzktVar.zzA$1();
        zzktVar.zzE(zzawVar, zzqVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final String zzd(zzq zzqVar) {
        zzy(zzqVar);
        zzkt zzktVar = this.zza;
        try {
            return (String) zzktVar.zzaz().zzh(new zzkm(zzktVar, zzqVar)).get(30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            zzeh zzay = zzktVar.zzay();
            zzay.zzd.zzc(zzeh.zzn(zzqVar.zza), e, "Failed to get app instance id. appId");
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final List zzf(String str, String str2, zzq zzqVar) {
        zzy(zzqVar);
        String str3 = zzqVar.zza;
        Preconditions.checkNotNull(str3);
        zzkt zzktVar = this.zza;
        try {
            return (List) zzktVar.zzaz().zzh(new zzfx(this, str3, str, str2)).get();
        } catch (InterruptedException | ExecutionException e) {
            zzktVar.zzay().zzd.zzb(e, "Failed to get conditional user properties");
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final List zzg(String str, String str2, String str3) {
        zzz(str, true);
        zzkt zzktVar = this.zza;
        try {
            return (List) zzktVar.zzaz().zzh(new zzfy(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e) {
            zzktVar.zzay().zzd.zzb(e, "Failed to get conditional user properties as");
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final List zzh(String str, String str2, boolean z, zzq zzqVar) {
        zzy(zzqVar);
        String str3 = zzqVar.zza;
        Preconditions.checkNotNull(str3);
        zzkt zzktVar = this.zza;
        try {
            List<zzky> list = (List) zzktVar.zzaz().zzh(new zzfv(this, str3, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzky zzkyVar : list) {
                if (z || !zzlb.zzah(zzkyVar.zzc)) {
                    arrayList.add(new zzkw(zzkyVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            zzeh zzay = zzktVar.zzay();
            zzay.zzd.zzc(zzeh.zzn(str3), e, "Failed to query user properties. appId");
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final List zzi(String str, String str2, String str3, boolean z) {
        zzz(str, true);
        zzkt zzktVar = this.zza;
        try {
            List<zzky> list = (List) zzktVar.zzaz().zzh(new zzfw(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzky zzkyVar : list) {
                if (z || !zzlb.zzah(zzkyVar.zzc)) {
                    arrayList.add(new zzkw(zzkyVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            zzeh zzay = zzktVar.zzay();
            zzay.zzd.zzc(zzeh.zzn(str), e, "Failed to get user properties as. appId");
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final void zzj(zzq zzqVar) {
        zzy(zzqVar);
        zzx(new zzgh(this, zzqVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final void zzk(zzaw zzawVar, zzq zzqVar) {
        Preconditions.checkNotNull(zzawVar);
        zzy(zzqVar);
        zzx(new zzgc(this, zzawVar, zzqVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final void zzm(zzq zzqVar) {
        Preconditions.checkNotEmpty(zzqVar.zza);
        zzz(zzqVar.zza, false);
        zzx(new zzfz(this, zzqVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final void zzn(zzac zzacVar, zzq zzqVar) {
        Preconditions.checkNotNull(zzacVar);
        Preconditions.checkNotNull(zzacVar.zzc);
        zzy(zzqVar);
        zzac zzacVar2 = new zzac(zzacVar);
        zzacVar2.zza = zzqVar.zza;
        zzx(new zzft(this, zzacVar2, zzqVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final void zzp(zzq zzqVar) {
        Preconditions.checkNotEmpty(zzqVar.zza);
        Preconditions.checkNotNull(zzqVar.zzv);
        zzgb zzgbVar = new zzgb(this, zzqVar);
        zzkt zzktVar = this.zza;
        if (zzktVar.zzaz().zzs()) {
            zzgbVar.run();
        } else {
            zzktVar.zzaz().zzq(zzgbVar);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final void zzq(long j, String str, String str2, String str3) {
        zzx(new zzgi(this, str2, str3, str, j));
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final void zzr(final Bundle bundle, zzq zzqVar) {
        zzy(zzqVar);
        final String str = zzqVar.zza;
        Preconditions.checkNotNull(str);
        zzx(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzfs
            @Override // java.lang.Runnable
            public final void run() {
                zzau zzauVar;
                zzam zzamVar = zzgj.this.zza.zze;
                zzkt.zzal(zzamVar);
                zzamVar.zzg();
                zzamVar.zzW();
                String str2 = str;
                Preconditions.checkNotEmpty(str2);
                Preconditions.checkNotEmpty("dep");
                TextUtils.isEmpty("");
                Bundle bundle2 = bundle;
                zzfr zzfrVar = zzamVar.zzt;
                if (bundle2 != null && !bundle2.isEmpty()) {
                    Bundle bundle3 = new Bundle(bundle2);
                    Iterator<String> it = bundle3.keySet().iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (next == null) {
                            zzeh zzehVar = zzfrVar.zzm;
                            zzfr.zzR(zzehVar);
                            zzehVar.zzd.zza("Param name can't be null");
                            it.remove();
                        } else {
                            zzlb zzlbVar = zzfrVar.zzp;
                            zzfr.zzP(zzlbVar);
                            Object zzA = zzlbVar.zzA(bundle3.get(next), next);
                            if (zzA == null) {
                                zzeh zzehVar2 = zzfrVar.zzm;
                                zzfr.zzR(zzehVar2);
                                zzehVar2.zzg.zzb(zzfrVar.zzq.zze(next), "Param value can't be null");
                                it.remove();
                            } else {
                                zzlb zzlbVar2 = zzfrVar.zzp;
                                zzfr.zzP(zzlbVar2);
                                zzlbVar2.zzO(bundle3, next, zzA);
                            }
                        }
                    }
                    zzauVar = new zzau(bundle3);
                } else {
                    zzauVar = new zzau(new Bundle());
                }
                zzkv zzkvVar = zzamVar.zzf.zzi;
                zzkt.zzal(zzkvVar);
                com.google.android.gms.internal.measurement.zzfs zze = com.google.android.gms.internal.measurement.zzft.zze();
                zze.zzaG();
                com.google.android.gms.internal.measurement.zzft.zzr(0L, (com.google.android.gms.internal.measurement.zzft) zze.zza);
                Bundle bundle4 = zzauVar.zza;
                for (String str3 : bundle4.keySet()) {
                    com.google.android.gms.internal.measurement.zzfw zze$1 = com.google.android.gms.internal.measurement.zzfx.zze$1();
                    zze$1.zzj(str3);
                    Object obj = bundle4.get(str3);
                    Preconditions.checkNotNull(obj);
                    zzkvVar.zzt(zze$1, obj);
                    zze.zze(zze$1);
                }
                byte[] zzbu = ((com.google.android.gms.internal.measurement.zzft) zze.zzaC()).zzbu();
                zzeh zzehVar3 = zzfrVar.zzm;
                zzfr.zzR(zzehVar3);
                zzehVar3.zzl.zzc(zzfrVar.zzq.zzd(str2), Integer.valueOf(zzbu.length), "Saving default event parameters, appId, data size");
                ContentValues contentValues = new ContentValues();
                contentValues.put(AnalyticsConstants.USER_PROPERTY_APP_ID, str2);
                contentValues.put("parameters", zzbu);
                try {
                    if (zzamVar.zzh().insertWithOnConflict("default_event_params", null, contentValues, 5) == -1) {
                        zzfr.zzR(zzehVar3);
                        zzehVar3.zzd.zzb(zzeh.zzn(str2), "Failed to insert default event parameters (got -1). appId");
                    }
                } catch (SQLiteException e) {
                    zzfr.zzR(zzehVar3);
                    zzehVar3.zzd.zzc(zzeh.zzn(str2), e, "Error storing default event parameters. appId");
                }
            }
        });
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final void zzs(zzq zzqVar) {
        zzy(zzqVar);
        zzx(new zzga(this, zzqVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final void zzt(zzkw zzkwVar, zzq zzqVar) {
        Preconditions.checkNotNull(zzkwVar);
        zzy(zzqVar);
        zzx(new zzgf(this, zzkwVar, zzqVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final byte[] zzu(zzaw zzawVar, String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzawVar);
        zzz(str, true);
        zzkt zzktVar = this.zza;
        zzeh zzay = zzktVar.zzay();
        zzfr zzfrVar = zzktVar.zzn;
        zzec zzecVar = zzfrVar.zzq;
        String str2 = zzawVar.zza;
        zzay.zzk.zzb(zzecVar.zzd(str2), "Log and bundle. event");
        ((Dns$Companion$DnsSystem) zzktVar.zzav()).getClass();
        long nanoTime = System.nanoTime() / 1000000;
        zzfo zzaz = zzktVar.zzaz();
        zzge zzgeVar = new zzge(this, zzawVar, str);
        zzaz.zzu();
        zzfm zzfmVar = new zzfm(zzaz, zzgeVar, true);
        if (Thread.currentThread() == zzaz.zzb) {
            zzfmVar.run();
        } else {
            zzaz.zzt(zzfmVar);
        }
        try {
            byte[] bArr = (byte[]) zzfmVar.get();
            if (bArr == null) {
                zzktVar.zzay().zzd.zzb(zzeh.zzn(str), "Log and bundle returned null. appId");
                bArr = new byte[0];
            }
            ((Dns$Companion$DnsSystem) zzktVar.zzav()).getClass();
            zzktVar.zzay().zzk.zzd("Log and bundle processed. event, size, time_ms", zzfrVar.zzq.zzd(str2), Integer.valueOf(bArr.length), Long.valueOf((System.nanoTime() / 1000000) - nanoTime));
            return bArr;
        } catch (InterruptedException | ExecutionException e) {
            zzeh zzay2 = zzktVar.zzay();
            zzay2.zzd.zzd("Failed to log and bundle. appId, event, error", zzeh.zzn(str), zzfrVar.zzq.zzd(str2), e);
            return null;
        }
    }

    public final void zzx(Runnable runnable) {
        zzkt zzktVar = this.zza;
        if (zzktVar.zzaz().zzs()) {
            runnable.run();
        } else {
            zzktVar.zzaz().zzp(runnable);
        }
    }

    public final void zzy(zzq zzqVar) {
        Preconditions.checkNotNull(zzqVar);
        String str = zzqVar.zza;
        Preconditions.checkNotEmpty(str);
        zzz(str, false);
        this.zza.zzv().zzX(zzqVar.zzb, zzqVar.zzq);
    }

    public final void zzz(String str, boolean z) {
        boolean z2;
        boolean isEmpty = TextUtils.isEmpty(str);
        zzkt zzktVar = this.zza;
        if (!isEmpty) {
            if (z) {
                try {
                    if (this.zzb == null) {
                        if (!"com.google.android.gms".equals(this.zzc) && !UidVerifier.isGooglePlayServicesUid(zzktVar.zzn.zze, Binder.getCallingUid()) && !GoogleSignatureVerifier.getInstance(zzktVar.zzn.zze).isUidGoogleSigned(Binder.getCallingUid())) {
                            z2 = false;
                            this.zzb = Boolean.valueOf(z2);
                        }
                        z2 = true;
                        this.zzb = Boolean.valueOf(z2);
                    }
                    if (this.zzb.booleanValue()) {
                        return;
                    }
                } catch (SecurityException e) {
                    zzeh zzay = zzktVar.zzay();
                    zzay.zzd.zzb(zzeh.zzn(str), "Measurement Service called with invalid calling package. appId");
                    throw e;
                }
            }
            if (this.zzc == null) {
                Context context = zzktVar.zzn.zze;
                int callingUid = Binder.getCallingUid();
                AtomicBoolean atomicBoolean = GooglePlayServicesUtilLight.sCanceledAvailabilityNotification;
                if (UidVerifier.uidHasPackageName(callingUid, context, str)) {
                    this.zzc = str;
                }
            }
            if (str.equals(this.zzc)) {
                return;
            } else {
                throw new SecurityException(String.format("Unknown calling package name '%s'.", str));
            }
        }
        zzktVar.zzay().zzd.zza("Measurement Service called without app package");
        throw new SecurityException("Measurement Service called without app package");
    }
}
