package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public final class zzr extends com.google.android.gms.internal.common.zza {
    public zzr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    public final IObjectWrapper zze(ObjectWrapper objectWrapper, String str, int r4, ObjectWrapper objectWrapper2) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.common.zzc.zzf(zza, objectWrapper);
        zza.writeString(str);
        zza.writeInt(r4);
        com.google.android.gms.internal.common.zzc.zzf(zza, objectWrapper2);
        Parcel zzB = zzB(zza, 2);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzB.readStrongBinder());
        zzB.recycle();
        return asInterface;
    }

    public final IObjectWrapper zzf(ObjectWrapper objectWrapper, String str, int r4, ObjectWrapper objectWrapper2) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.common.zzc.zzf(zza, objectWrapper);
        zza.writeString(str);
        zza.writeInt(r4);
        com.google.android.gms.internal.common.zzc.zzf(zza, objectWrapper2);
        Parcel zzB = zzB(zza, 3);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzB.readStrongBinder());
        zzB.recycle();
        return asInterface;
    }
}
