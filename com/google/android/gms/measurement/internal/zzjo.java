package com.google.android.gms.measurement.internal;

import android.os.SystemClock;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzjo extends zzkh {
    public final zzes zza;
    public final zzes zzb;
    public final zzes zzc;
    public final zzes zzd;
    public final zzes zze;
    public final HashMap zzg;

    public zzjo(zzkt zzktVar) {
        super(zzktVar);
        this.zzg = new HashMap();
        zzew zzewVar = this.zzt.zzl;
        zzfr.zzP(zzewVar);
        this.zza = new zzes(zzewVar, "last_delete_stale", 0L);
        zzew zzewVar2 = this.zzt.zzl;
        zzfr.zzP(zzewVar2);
        this.zzb = new zzes(zzewVar2, "backoff", 0L);
        zzew zzewVar3 = this.zzt.zzl;
        zzfr.zzP(zzewVar3);
        this.zzc = new zzes(zzewVar3, "last_upload", 0L);
        zzew zzewVar4 = this.zzt.zzl;
        zzfr.zzP(zzewVar4);
        this.zzd = new zzes(zzewVar4, "last_upload_attempt", 0L);
        zzew zzewVar5 = this.zzt.zzl;
        zzfr.zzP(zzewVar5);
        this.zze = new zzes(zzewVar5, "midnight_offset", 0L);
    }

    @Deprecated
    public final Pair zza(String str) {
        zzjn zzjnVar;
        zzg();
        zzfr zzfrVar = this.zzt;
        zzfrVar.zzr.getClass();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        HashMap hashMap = this.zzg;
        zzjn zzjnVar2 = (zzjn) hashMap.get(str);
        if (zzjnVar2 != null && elapsedRealtime < zzjnVar2.zzc) {
            return new Pair(zzjnVar2.zza, Boolean.valueOf(zzjnVar2.zzb));
        }
        long zzi = zzfrVar.zzk.zzi(str, zzdu.zza) + elapsedRealtime;
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(zzfrVar.zze);
            String str2 = advertisingIdInfo.zza;
            boolean z = advertisingIdInfo.zzb;
            if (str2 != null) {
                zzjnVar = new zzjn(str2, zzi, z);
            } else {
                zzjnVar = new zzjn("", zzi, z);
            }
        } catch (Exception e) {
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzk.zzb(e, "Unable to get advertising id");
            zzjnVar = new zzjn("", zzi, false);
        }
        hashMap.put(str, zzjnVar);
        return new Pair(zzjnVar.zza, Boolean.valueOf(zzjnVar.zzb));
    }

    @Deprecated
    public final String zzf(String str, boolean z) {
        String str2;
        zzg();
        if (z) {
            str2 = (String) zza(str).first;
        } else {
            str2 = "00000000-0000-0000-0000-000000000000";
        }
        MessageDigest zzF = zzlb.zzF();
        if (zzF == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, zzF.digest(str2.getBytes())));
    }

    @Override // com.google.android.gms.measurement.internal.zzkh
    public final void zzb() {
    }
}
