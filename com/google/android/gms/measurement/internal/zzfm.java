package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzfm extends FutureTask implements Comparable {
    public final boolean zza;
    public final /* synthetic */ zzfo zzb;
    public final long zzc;
    public final String zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfm(zzfo zzfoVar, Runnable runnable, boolean z, String str) {
        super(runnable, null);
        this.zzb = zzfoVar;
        long andIncrement = zzfo.zza.getAndIncrement();
        this.zzc = andIncrement;
        this.zzd = str;
        this.zza = z;
        if (andIncrement == Long.MAX_VALUE) {
            zzeh zzehVar = zzfoVar.zzt.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzd.zza("Tasks index overflow");
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        zzfm zzfmVar = (zzfm) obj;
        boolean z = zzfmVar.zza;
        boolean z2 = this.zza;
        if (z2 != z) {
            if (!z2) {
                return 1;
            }
            return -1;
        }
        long j = zzfmVar.zzc;
        long j2 = this.zzc;
        if (j2 < j) {
            return -1;
        }
        if (j2 > j) {
            return 1;
        }
        zzeh zzehVar = this.zzb.zzt.zzm;
        zzfr.zzR(zzehVar);
        zzehVar.zze.zzb(Long.valueOf(j2), "Two tasks share the same index. index");
        return 0;
    }

    @Override // java.util.concurrent.FutureTask
    public final void setException(Throwable th) {
        zzeh zzehVar = this.zzb.zzt.zzm;
        zzfr.zzR(zzehVar);
        zzehVar.zzd.zzb(th, this.zzd);
        super.setException(th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfm(zzfo zzfoVar, Callable callable, boolean z) {
        super(callable);
        this.zzb = zzfoVar;
        long andIncrement = zzfo.zza.getAndIncrement();
        this.zzc = andIncrement;
        this.zzd = "Task exception on worker thread";
        this.zza = z;
        if (andIncrement == Long.MAX_VALUE) {
            zzeh zzehVar = zzfoVar.zzt.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzd.zza("Tasks index overflow");
        }
    }
}
