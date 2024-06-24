package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.maps.zza;
import com.google.android.gms.internal.maps.zzc;
import com.google.android.gms.internal.maps.zzh;
import com.google.android.gms.internal.maps.zzi;
import com.google.android.gms.maps.GoogleMapOptions;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes3.dex */
public final class zze extends zza implements zzf {
    public zze(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.ICreator");
    }

    @Override // com.google.android.gms.maps.internal.zzf
    public final int zzd() throws RemoteException {
        Parcel zzH = zzH(zza(), 9);
        int readInt = zzH.readInt();
        zzH.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.maps.internal.zzf
    public final ICameraUpdateFactoryDelegate zze() throws RemoteException {
        ICameraUpdateFactoryDelegate zzbVar;
        Parcel zzH = zzH(zza(), 4);
        IBinder readStrongBinder = zzH.readStrongBinder();
        if (readStrongBinder == null) {
            zzbVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            if (queryLocalInterface instanceof ICameraUpdateFactoryDelegate) {
                zzbVar = (ICameraUpdateFactoryDelegate) queryLocalInterface;
            } else {
                zzbVar = new zzb(readStrongBinder);
            }
        }
        zzH.recycle();
        return zzbVar;
    }

    @Override // com.google.android.gms.maps.internal.zzf
    public final IMapFragmentDelegate zzf(ObjectWrapper objectWrapper) throws RemoteException {
        IMapFragmentDelegate zzkVar;
        Parcel zza = zza();
        zzc.zzg(zza, objectWrapper);
        Parcel zzH = zzH(zza, 2);
        IBinder readStrongBinder = zzH.readStrongBinder();
        if (readStrongBinder == null) {
            zzkVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            if (queryLocalInterface instanceof IMapFragmentDelegate) {
                zzkVar = (IMapFragmentDelegate) queryLocalInterface;
            } else {
                zzkVar = new zzk(readStrongBinder);
            }
        }
        zzH.recycle();
        return zzkVar;
    }

    @Override // com.google.android.gms.maps.internal.zzf
    public final IMapViewDelegate zzg(ObjectWrapper objectWrapper, GoogleMapOptions googleMapOptions) throws RemoteException {
        IMapViewDelegate zzlVar;
        Parcel zza = zza();
        zzc.zzg(zza, objectWrapper);
        zzc.zze(zza, googleMapOptions);
        Parcel zzH = zzH(zza, 3);
        IBinder readStrongBinder = zzH.readStrongBinder();
        if (readStrongBinder == null) {
            zzlVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
            if (queryLocalInterface instanceof IMapViewDelegate) {
                zzlVar = (IMapViewDelegate) queryLocalInterface;
            } else {
                zzlVar = new zzl(readStrongBinder);
            }
        }
        zzH.recycle();
        return zzlVar;
    }

    @Override // com.google.android.gms.maps.internal.zzf
    public final zzi zzj() throws RemoteException {
        zzi zzgVar;
        Parcel zzH = zzH(zza(), 5);
        IBinder readStrongBinder = zzH.readStrongBinder();
        int r2 = zzh.$r8$clinit;
        if (readStrongBinder == null) {
            zzgVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            if (queryLocalInterface instanceof zzi) {
                zzgVar = (zzi) queryLocalInterface;
            } else {
                zzgVar = new com.google.android.gms.internal.maps.zzg(readStrongBinder);
            }
        }
        zzH.recycle();
        return zzgVar;
    }

    @Override // com.google.android.gms.maps.internal.zzf
    public final void zzk(ObjectWrapper objectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzc.zzg(zza, objectWrapper);
        zza.writeInt(12451000);
        zzc(zza, 6);
    }

    @Override // com.google.android.gms.maps.internal.zzf
    public final void zzl(ObjectWrapper objectWrapper, int r3) throws RemoteException {
        Parcel zza = zza();
        zzc.zzg(zza, objectWrapper);
        zza.writeInt(r3);
        zzc(zza, 10);
    }
}
