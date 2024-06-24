package com.google.android.gms.measurement.api;

import android.os.BadParcelableException;
import android.os.NetworkOnMainThreadException;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.internal.measurement.zzdq;
import com.google.android.gms.internal.measurement.zzdw;
import com.google.android.gms.internal.measurement.zzef;
import com.google.android.gms.measurement.internal.zzgs;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.2.0 */
/* loaded from: classes3.dex */
public final class AppMeasurementSdk {
    public final zzef zza;

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.2.0 */
    /* loaded from: classes3.dex */
    public interface OnEventListener extends zzgs {
    }

    public AppMeasurementSdk(zzef zzefVar) {
        this.zza = zzefVar;
    }

    public final void registerOnMeasurementEventListener(OnEventListener onEventListener) {
        zzef zzefVar = this.zza;
        zzefVar.getClass();
        synchronized (zzefVar.zzf) {
            for (int r2 = 0; r2 < zzefVar.zzf.size(); r2++) {
                if (onEventListener.equals(((Pair) zzefVar.zzf.get(r2)).first)) {
                    Log.w(zzefVar.zzd, "OnEventListener already registered.");
                    return;
                }
            }
            zzdw zzdwVar = new zzdw(onEventListener);
            zzefVar.zzf.add(new Pair(onEventListener, zzdwVar));
            if (zzefVar.zzj != null) {
                try {
                    zzefVar.zzj.registerOnMeasurementEventListener(zzdwVar);
                    return;
                } catch (BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException unused) {
                    Log.w(zzefVar.zzd, "Failed to register event listener on calling thread. Trying again on the dynamite thread.");
                }
            }
            zzefVar.zzV(new zzdq(zzefVar, zzdwVar));
        }
    }
}
