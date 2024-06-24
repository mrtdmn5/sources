package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
/* loaded from: classes3.dex */
public abstract class zzch extends zzbn implements zzci {
    public zzch() {
        super("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    @Override // com.google.android.gms.internal.measurement.zzbn
    public final boolean zza(int r8, Parcel parcel, Parcel parcel2) throws RemoteException {
        if (r8 != 1) {
            if (r8 != 2) {
                return false;
            }
            int zzd = ((zzdw) this).zzd();
            parcel2.writeNoException();
            parcel2.writeInt(zzd);
        } else {
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            Bundle bundle = (Bundle) zzbo.zza(parcel, Bundle.CREATOR);
            long readLong = parcel.readLong();
            zzbo.zzc(parcel);
            ((zzdw) this).zze(readLong, bundle, readString, readString2);
            parcel2.writeNoException();
        }
        return true;
    }
}
