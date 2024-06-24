package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzcf;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzhk implements Runnable {
    public final /* synthetic */ zzcf zza;
    public final /* synthetic */ zzhx zzb;

    public zzhk(zzhx zzhxVar, zzcf zzcfVar) {
        this.zzb = zzhxVar;
        this.zza = zzcfVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0093 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0086  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            r9 = this;
            com.google.android.gms.measurement.internal.zzhx r0 = r9.zzb
            com.google.android.gms.measurement.internal.zzfr r1 = r0.zzt
            com.google.android.gms.measurement.internal.zzkc r1 = r1.zzo
            com.google.android.gms.measurement.internal.zzfr.zzQ(r1)
            com.google.android.gms.internal.measurement.zzpa r2 = com.google.android.gms.internal.measurement.zzpa.zza
            com.google.android.gms.internal.measurement.zzii r2 = r2.zzb
            java.lang.Object r2 = r2.zza()
            com.google.android.gms.internal.measurement.zzpb r2 = (com.google.android.gms.internal.measurement.zzpb) r2
            r2.zza()
            com.google.android.gms.measurement.internal.zzfr r1 = r1.zzt
            com.google.android.gms.measurement.internal.zzag r2 = r1.zzk
            com.google.android.gms.measurement.internal.zzdt r3 = com.google.android.gms.measurement.internal.zzdu.zzau
            r4 = 0
            boolean r2 = r2.zzs(r4, r3)
            if (r2 == 0) goto L73
            com.google.android.gms.measurement.internal.zzew r2 = r1.zzl
            com.google.android.gms.measurement.internal.zzfr.zzP(r2)
            com.google.android.gms.measurement.internal.zzai r2 = r2.zzc()
            com.google.android.gms.measurement.internal.zzah r3 = com.google.android.gms.measurement.internal.zzah.ANALYTICS_STORAGE
            boolean r2 = r2.zzi(r3)
            if (r2 != 0) goto L41
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzm
            com.google.android.gms.measurement.internal.zzfr.zzR(r1)
            java.lang.String r2 = "Analytics storage consent denied; will not get session id"
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzi
            r1.zza(r2)
            goto L7f
        L41:
            com.google.android.gms.measurement.internal.zzew r2 = r1.zzl
            com.google.android.gms.measurement.internal.zzfr.zzP(r2)
            okhttp3.Dns$Companion$DnsSystem r1 = r1.zzr
            r1.getClass()
            long r5 = java.lang.System.currentTimeMillis()
            boolean r1 = r2.zzk(r5)
            if (r1 != 0) goto L7f
            com.google.android.gms.measurement.internal.zzfr.zzP(r2)
            com.google.android.gms.measurement.internal.zzes r1 = r2.zzk
            long r5 = r1.zza()
            r7 = 0
            int r1 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r1 != 0) goto L65
            goto L7f
        L65:
            com.google.android.gms.measurement.internal.zzfr.zzP(r2)
            com.google.android.gms.measurement.internal.zzes r1 = r2.zzk
            long r1 = r1.zza()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            goto L80
        L73:
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzm
            com.google.android.gms.measurement.internal.zzfr.zzR(r1)
            java.lang.String r2 = "getSessionId has been disabled."
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzi
            r1.zza(r2)
        L7f:
            r1 = r4
        L80:
            com.google.android.gms.measurement.internal.zzfr r0 = r0.zzt
            com.google.android.gms.internal.measurement.zzcf r2 = r9.zza
            if (r1 == 0) goto L93
            com.google.android.gms.measurement.internal.zzlb r0 = r0.zzp
            com.google.android.gms.measurement.internal.zzfr.zzP(r0)
            long r3 = r1.longValue()
            r0.zzU(r2, r3)
            return
        L93:
            r2.zze(r4)     // Catch: android.os.RemoteException -> L97
            return
        L97:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzm
            com.google.android.gms.measurement.internal.zzfr.zzR(r0)
            java.lang.String r2 = "getSessionId failed with exception"
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzd
            r0.zzb(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhk.run():void");
    }
}
