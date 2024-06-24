package com.google.android.gms.maps.internal;

import android.os.BadParcelableException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import com.google.android.gms.internal.maps.zzc;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes3.dex */
public abstract class zzar extends com.google.android.gms.internal.maps.zzb implements zzas {
    public zzar() {
        super("com.google.android.gms.maps.internal.IOnMapReadyCallback");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    public final boolean zza(int r4, Parcel parcel, Parcel parcel2) throws RemoteException {
        IGoogleMapDelegate zzgVar;
        if (r4 == 1) {
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder == null) {
                zzgVar = null;
            } else {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                if (queryLocalInterface instanceof IGoogleMapDelegate) {
                    zzgVar = (IGoogleMapDelegate) queryLocalInterface;
                } else {
                    zzgVar = new zzg(readStrongBinder);
                }
            }
            int r1 = zzc.$r8$clinit;
            int dataAvail = parcel.dataAvail();
            if (dataAvail <= 0) {
                zzb(zzgVar);
                parcel2.writeNoException();
                return true;
            }
            throw new BadParcelableException(SubMenuBuilder$$ExternalSyntheticOutline0.m("Parcel data not fully consumed, unread size: ", dataAvail));
        }
        return false;
    }
}
