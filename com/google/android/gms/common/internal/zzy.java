package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public abstract class zzy extends com.google.android.gms.internal.common.zzb implements zzz {
    public static final /* synthetic */ int $r8$clinit = 0;

    public zzy() {
        super("com.google.android.gms.common.internal.ICertData");
    }

    @Override // com.google.android.gms.internal.common.zzb
    public final boolean zza(int r2, Parcel parcel, Parcel parcel2) throws RemoteException {
        if (r2 != 1) {
            if (r2 != 2) {
                return false;
            }
            parcel2.writeNoException();
            parcel2.writeInt(((com.google.android.gms.common.zzj) this).zza);
        } else {
            IObjectWrapper zzd = ((com.google.android.gms.common.zzj) this).zzd();
            parcel2.writeNoException();
            com.google.android.gms.internal.common.zzc.zzf(parcel2, zzd);
        }
        return true;
    }
}
