package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public final class zzad extends com.google.android.gms.internal.common.zza implements zzaf {
    public zzad(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    @Override // com.google.android.gms.common.internal.zzaf
    public final com.google.android.gms.common.zzq zze(com.google.android.gms.common.zzo zzoVar) throws RemoteException {
        Parcel zza = zza();
        int r1 = com.google.android.gms.internal.common.zzc.$r8$clinit;
        zza.writeInt(1);
        zzoVar.writeToParcel(zza, 0);
        Parcel zzB = zzB(zza, 6);
        com.google.android.gms.common.zzq zzqVar = (com.google.android.gms.common.zzq) com.google.android.gms.internal.common.zzc.zza(zzB, com.google.android.gms.common.zzq.CREATOR);
        zzB.recycle();
        return zzqVar;
    }

    @Override // com.google.android.gms.common.internal.zzaf
    public final boolean zzh(com.google.android.gms.common.zzs zzsVar, ObjectWrapper objectWrapper) throws RemoteException {
        Parcel zza = zza();
        int r1 = com.google.android.gms.internal.common.zzc.$r8$clinit;
        boolean z = true;
        zza.writeInt(1);
        zzsVar.writeToParcel(zza, 0);
        com.google.android.gms.internal.common.zzc.zzf(zza, objectWrapper);
        Parcel zzB = zzB(zza, 5);
        if (zzB.readInt() == 0) {
            z = false;
        }
        zzB.recycle();
        return z;
    }

    @Override // com.google.android.gms.common.internal.zzaf
    public final boolean zzi() throws RemoteException {
        boolean z;
        Parcel zzB = zzB(zza(), 7);
        int r1 = com.google.android.gms.internal.common.zzc.$r8$clinit;
        if (zzB.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        zzB.recycle();
        return z;
    }
}
