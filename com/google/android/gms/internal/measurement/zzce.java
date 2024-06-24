package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
/* loaded from: classes3.dex */
public abstract class zzce extends zzbn implements zzcf {
    public zzce() {
        super("com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }

    @Override // com.google.android.gms.internal.measurement.zzbn
    public final boolean zza(int r2, Parcel parcel, Parcel parcel2) throws RemoteException {
        if (r2 == 1) {
            Bundle bundle = (Bundle) zzbo.zza(parcel, Bundle.CREATOR);
            zzbo.zzc(parcel);
            ((zzbz) this).zze(bundle);
            parcel2.writeNoException();
            return true;
        }
        return false;
    }
}
