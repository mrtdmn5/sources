package com.google.android.gms.measurement.internal;

import android.database.sqlite.SQLiteException;
import android.os.SystemClock;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import okhttp3.Dns$Companion$DnsSystem;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzkk implements zzej {
    public final /* synthetic */ zzkt zzb;

    public zzkk(zzkt zzktVar, String str) {
        this.zzb = zzktVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzej
    public final void zza(String str, int r10, Throwable th, byte[] bArr, Map map) {
        zzam zzamVar;
        long longValue;
        zzkt zzktVar = this.zzb;
        zzktVar.zzaz().zzg();
        zzktVar.zzB$1();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } finally {
                zzktVar.zzu = false;
                zzktVar.zzae();
            }
        }
        ArrayList arrayList = zzktVar.zzy;
        Preconditions.checkNotNull(arrayList);
        zzktVar.zzy = null;
        if (r10 != 200) {
            if (r10 == 204) {
                r10 = 204;
            }
            zzktVar.zzay().zzl.zzc(Integer.valueOf(r10), th, "Network upload failed. Will retry later. code, error");
            zzes zzesVar = zzktVar.zzk.zzd;
            ((Dns$Companion$DnsSystem) zzktVar.zzav()).getClass();
            zzesVar.zzb(System.currentTimeMillis());
            if (r10 != 503 || r10 == 429) {
                zzes zzesVar2 = zzktVar.zzk.zzb;
                ((Dns$Companion$DnsSystem) zzktVar.zzav()).getClass();
                zzesVar2.zzb(System.currentTimeMillis());
            }
            zzam zzamVar2 = zzktVar.zze;
            zzkt.zzal(zzamVar2);
            zzamVar2.zzy(arrayList);
            zzktVar.zzag();
        }
        if (th == null) {
            try {
                zzes zzesVar3 = zzktVar.zzk.zzc;
                ((Dns$Companion$DnsSystem) zzktVar.zzav()).getClass();
                zzesVar3.zzb(System.currentTimeMillis());
                zzktVar.zzk.zzd.zzb(0L);
                zzktVar.zzag();
                zzktVar.zzay().zzl.zzc(Integer.valueOf(r10), Integer.valueOf(bArr.length), "Successful upload. Got network response. code, size");
                zzam zzamVar3 = zzktVar.zze;
                zzkt.zzal(zzamVar3);
                zzamVar3.zzw();
            } catch (SQLiteException e) {
                zzktVar.zzay().zzd.zzb(e, "Database error while trying to delete uploaded bundles");
                ((Dns$Companion$DnsSystem) zzktVar.zzav()).getClass();
                zzktVar.zza = SystemClock.elapsedRealtime();
                zzktVar.zzay().zzl.zzb(Long.valueOf(zzktVar.zza), "Disable upload, time");
            }
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Long l = (Long) it.next();
                    try {
                        zzamVar = zzktVar.zze;
                        zzkt.zzal(zzamVar);
                        longValue = l.longValue();
                        zzamVar.zzg();
                        zzamVar.zzW();
                    } catch (SQLiteException e2) {
                        ArrayList arrayList2 = zzktVar.zzz;
                        if (arrayList2 == null || !arrayList2.contains(l)) {
                            throw e2;
                        }
                    }
                    try {
                        if (zzamVar.zzh().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                            throw new SQLiteException("Deleted fewer rows from queue than expected");
                            break;
                        }
                    } catch (SQLiteException e3) {
                        zzeh zzehVar = zzamVar.zzt.zzm;
                        zzfr.zzR(zzehVar);
                        zzehVar.zzd.zzb(e3, "Failed to delete a bundle in a queue table");
                        throw e3;
                        break;
                    }
                }
                zzam zzamVar4 = zzktVar.zze;
                zzkt.zzal(zzamVar4);
                zzamVar4.zzC();
                zzam zzamVar5 = zzktVar.zze;
                zzkt.zzal(zzamVar5);
                zzamVar5.zzx();
                zzktVar.zzz = null;
                zzen zzenVar = zzktVar.zzd;
                zzkt.zzal(zzenVar);
                if (zzenVar.zza() && zzktVar.zzai()) {
                    zzktVar.zzX();
                } else {
                    zzktVar.zzA = -1L;
                    zzktVar.zzag();
                }
                zzktVar.zza = 0L;
            } catch (Throwable th2) {
                zzam zzamVar6 = zzktVar.zze;
                zzkt.zzal(zzamVar6);
                zzamVar6.zzx();
                throw th2;
            }
        }
        zzktVar.zzay().zzl.zzc(Integer.valueOf(r10), th, "Network upload failed. Will retry later. code, error");
        zzes zzesVar4 = zzktVar.zzk.zzd;
        ((Dns$Companion$DnsSystem) zzktVar.zzav()).getClass();
        zzesVar4.zzb(System.currentTimeMillis());
        if (r10 != 503) {
        }
        zzes zzesVar22 = zzktVar.zzk.zzb;
        ((Dns$Companion$DnsSystem) zzktVar.zzav()).getClass();
        zzesVar22.zzb(System.currentTimeMillis());
        zzam zzamVar22 = zzktVar.zze;
        zzkt.zzal(zzamVar22);
        zzamVar22.zzy(arrayList);
        zzktVar.zzag();
    }
}
