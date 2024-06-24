package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
/* loaded from: classes3.dex */
public abstract class zzj extends zzb implements zzk {
    public zzj() {
        super("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
    }

    @Override // com.google.android.gms.internal.location.zzb
    public final boolean zza(int r2, Parcel parcel) throws RemoteException {
        if (r2 != 1) {
            if (r2 != 2) {
                return false;
            }
            zze();
        } else {
            zzg zzgVar = (zzg) zzc.zza(parcel, zzg.CREATOR);
            zzc.zzb(parcel);
            zzd(zzgVar);
        }
        return true;
    }
}
