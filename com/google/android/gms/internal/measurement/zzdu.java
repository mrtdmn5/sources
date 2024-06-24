package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import android.os.SystemClock;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.2.0 */
/* loaded from: classes3.dex */
public abstract class zzdu implements Runnable {
    public final long zzh;
    public final long zzi;
    public final boolean zzj;
    public final /* synthetic */ zzef zzk;

    public zzdu(zzef zzefVar, boolean z) {
        this.zzk = zzefVar;
        zzefVar.zza.getClass();
        this.zzh = System.currentTimeMillis();
        zzefVar.zza.getClass();
        this.zzi = SystemClock.elapsedRealtime();
        this.zzj = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzef zzefVar = this.zzk;
        if (zzefVar.zzh) {
            zzb();
            return;
        }
        try {
            zza();
        } catch (Exception e) {
            zzefVar.zzT(e, false, this.zzj);
            zzb();
        }
    }

    public abstract void zza() throws RemoteException;

    public void zzb() {
    }
}
