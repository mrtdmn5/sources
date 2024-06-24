package com.google.android.gms.measurement;

import android.os.Bundle;
import android.os.SystemClock;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzab;
import com.google.android.gms.measurement.internal.zzeh;
import com.google.android.gms.measurement.internal.zzfo;
import com.google.android.gms.measurement.internal.zzfr;
import com.google.android.gms.measurement.internal.zzhh;
import com.google.android.gms.measurement.internal.zzhj;
import com.google.android.gms.measurement.internal.zzhx;
import com.google.android.gms.measurement.internal.zzie;
import com.google.android.gms.measurement.internal.zzim;
import com.google.android.gms.measurement.internal.zzkw;
import com.google.android.gms.measurement.internal.zzlb;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import no.nordicsemi.android.dfu.DfuServiceInitiator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zza extends zzd {
    public final zzfr zza;
    public final zzhx zzb;

    public zza(zzfr zzfrVar) {
        Preconditions.checkNotNull(zzfrVar);
        this.zza = zzfrVar;
        zzhx zzhxVar = zzfrVar.zzt;
        zzfr.zzQ(zzhxVar);
        this.zzb = zzhxVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzhy
    public final int zza(String str) {
        zzhx zzhxVar = this.zzb;
        zzhxVar.getClass();
        Preconditions.checkNotEmpty(str);
        zzhxVar.zzt.getClass();
        return 25;
    }

    @Override // com.google.android.gms.measurement.internal.zzhy
    public final long zzb() {
        zzlb zzlbVar = this.zza.zzp;
        zzfr.zzP(zzlbVar);
        return zzlbVar.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzhy
    public final String zzh() {
        return this.zzb.zzo$1();
    }

    @Override // com.google.android.gms.measurement.internal.zzhy
    public final String zzi() {
        zzim zzimVar = this.zzb.zzt.zzs;
        zzfr.zzQ(zzimVar);
        zzie zzieVar = zzimVar.zzb;
        if (zzieVar != null) {
            return zzieVar.zzb;
        }
        return null;
    }

    @Override // com.google.android.gms.measurement.internal.zzhy
    public final String zzj() {
        zzim zzimVar = this.zzb.zzt.zzs;
        zzfr.zzQ(zzimVar);
        zzie zzieVar = zzimVar.zzb;
        if (zzieVar != null) {
            return zzieVar.zza;
        }
        return null;
    }

    @Override // com.google.android.gms.measurement.internal.zzhy
    public final String zzk() {
        return this.zzb.zzo$1();
    }

    @Override // com.google.android.gms.measurement.internal.zzhy
    public final List zzm(String str, String str2) {
        zzhx zzhxVar = this.zzb;
        zzfr zzfrVar = zzhxVar.zzt;
        zzfo zzfoVar = zzfrVar.zzn;
        zzfr.zzR(zzfoVar);
        boolean zzs = zzfoVar.zzs();
        zzeh zzehVar = zzfrVar.zzm;
        if (zzs) {
            zzfr.zzR(zzehVar);
            zzehVar.zzd.zza("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList(0);
        }
        if (zzab.zza()) {
            zzfr.zzR(zzehVar);
            zzehVar.zzd.zza("Cannot get conditional user properties from main thread");
            return new ArrayList(0);
        }
        AtomicReference atomicReference = new AtomicReference();
        zzfo zzfoVar2 = zzfrVar.zzn;
        zzfr.zzR(zzfoVar2);
        zzfoVar2.zzd(atomicReference, DfuServiceInitiator.DEFAULT_SCAN_TIMEOUT, "get conditional user properties", new zzhh(zzhxVar, atomicReference, str, str2));
        List list = (List) atomicReference.get();
        if (list == null) {
            zzfr.zzR(zzehVar);
            zzehVar.zzd.zzb(null, "Timed out waiting for get conditional user properties");
            return new ArrayList();
        }
        return zzlb.zzH(list);
    }

    @Override // com.google.android.gms.measurement.internal.zzhy
    public final Map zzo(String str, String str2, boolean z) {
        zzhx zzhxVar = this.zzb;
        zzfr zzfrVar = zzhxVar.zzt;
        zzfo zzfoVar = zzfrVar.zzn;
        zzfr.zzR(zzfoVar);
        boolean zzs = zzfoVar.zzs();
        zzeh zzehVar = zzfrVar.zzm;
        if (zzs) {
            zzfr.zzR(zzehVar);
            zzehVar.zzd.zza("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        }
        if (zzab.zza()) {
            zzfr.zzR(zzehVar);
            zzehVar.zzd.zza("Cannot get user properties from main thread");
            return Collections.emptyMap();
        }
        AtomicReference atomicReference = new AtomicReference();
        zzfo zzfoVar2 = zzfrVar.zzn;
        zzfr.zzR(zzfoVar2);
        zzfoVar2.zzd(atomicReference, DfuServiceInitiator.DEFAULT_SCAN_TIMEOUT, "get user properties", new zzhj(zzhxVar, atomicReference, str, str2, z));
        List<zzkw> list = (List) atomicReference.get();
        if (list == null) {
            zzfr.zzR(zzehVar);
            zzehVar.zzd.zzb(Boolean.valueOf(z), "Timed out waiting for handle get user properties, includeInternal");
            return Collections.emptyMap();
        }
        ArrayMap arrayMap = new ArrayMap(list.size());
        for (zzkw zzkwVar : list) {
            Object zza = zzkwVar.zza();
            if (zza != null) {
                arrayMap.put(zzkwVar.zzb, zza);
            }
        }
        return arrayMap;
    }

    @Override // com.google.android.gms.measurement.internal.zzhy
    public final void zzp(String str) {
        zzfr zzfrVar = this.zza;
        com.google.android.gms.measurement.internal.zzd zzd = zzfrVar.zzd();
        zzfrVar.zzr.getClass();
        zzd.zzd(SystemClock.elapsedRealtime(), str);
    }

    @Override // com.google.android.gms.measurement.internal.zzhy
    public final void zzq(String str, String str2, Bundle bundle) {
        zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        zzhxVar.zzA(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzhy
    public final void zzr(String str) {
        zzfr zzfrVar = this.zza;
        com.google.android.gms.measurement.internal.zzd zzd = zzfrVar.zzd();
        zzfrVar.zzr.getClass();
        zzd.zze(SystemClock.elapsedRealtime(), str);
    }

    @Override // com.google.android.gms.measurement.internal.zzhy
    public final void zzs(String str, String str2, Bundle bundle) {
        zzhx zzhxVar = this.zzb;
        zzhxVar.zzt.zzr.getClass();
        zzhxVar.zzE(str, str2, bundle, true, true, System.currentTimeMillis());
    }

    @Override // com.google.android.gms.measurement.internal.zzhy
    public final void zzv(Bundle bundle) {
        zzhx zzhxVar = this.zzb;
        zzhxVar.zzt.zzr.getClass();
        zzhxVar.zzQ(bundle, System.currentTimeMillis());
    }
}
