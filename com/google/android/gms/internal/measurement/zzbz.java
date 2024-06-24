package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzbz extends zzce {
    public final AtomicReference zza = new AtomicReference();
    public boolean zzb;

    /* JADX WARN: Code restructure failed: missing block: B:2:0x0002, code lost:            r1 = r1.get("r");     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object zzf(android.os.Bundle r1, java.lang.Class r2) {
        /*
            if (r1 == 0) goto L2c
            java.lang.String r0 = "r"
            java.lang.Object r1 = r1.get(r0)
            if (r1 == 0) goto L2c
            java.lang.Object r1 = r2.cast(r1)     // Catch: java.lang.ClassCastException -> Lf
            goto L2d
        Lf:
            r0 = move-exception
            java.lang.String r2 = r2.getCanonicalName()
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getCanonicalName()
            java.lang.Object[] r1 = new java.lang.Object[]{r2, r1}
            java.lang.String r2 = "Unexpected object type. Expected, Received: %s, %s"
            java.lang.String r1 = java.lang.String.format(r2, r1)
            java.lang.String r2 = "AM"
            android.util.Log.w(r2, r1, r0)
            throw r0
        L2c:
            r1 = 0
        L2d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzbz.zzf(android.os.Bundle, java.lang.Class):java.lang.Object");
    }

    public final Bundle zzb(long j) {
        Bundle bundle;
        synchronized (this.zza) {
            if (!this.zzb) {
                try {
                    this.zza.wait(j);
                } catch (InterruptedException unused) {
                    return null;
                }
            }
            bundle = (Bundle) this.zza.get();
        }
        return bundle;
    }

    public final String zzd(long j) {
        return (String) zzf(zzb(j), String.class);
    }

    @Override // com.google.android.gms.internal.measurement.zzcf
    public final void zze(Bundle bundle) {
        synchronized (this.zza) {
            try {
                this.zza.set(bundle);
                this.zzb = true;
            } finally {
                this.zza.notify();
            }
        }
    }
}
