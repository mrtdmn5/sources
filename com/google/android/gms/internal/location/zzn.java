package com.google.android.gms.internal.location;

import android.location.Location;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.LastLocationRequest;
import com.google.android.gms.location.LocationRequest;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
/* loaded from: classes3.dex */
public final class zzn extends zza implements zzo {
    public zzn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.internal.IGoogleLocationManagerService");
    }

    @Override // com.google.android.gms.internal.location.zzo
    public final Location zzd() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.zzb);
        obtain = Parcel.obtain();
        try {
            this.zza.transact(7, obtain, obtain, 0);
            obtain.readException();
            obtain.recycle();
            return (Location) zzc.zza(obtain, Location.CREATOR);
        } catch (RuntimeException e) {
            throw e;
        } finally {
            obtain.recycle();
        }
    }

    @Override // com.google.android.gms.internal.location.zzo
    public final void zzj(LastLocationRequest lastLocationRequest, zzcm zzcmVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.zzb);
        zzc.zzd(obtain, lastLocationRequest);
        obtain.writeStrongBinder(zzcmVar);
        zzc(obtain, 82);
    }

    @Override // com.google.android.gms.internal.location.zzo
    public final void zzk(zzdb zzdbVar, LocationRequest locationRequest, zzcl zzclVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.zzb);
        zzc.zzd(obtain, zzdbVar);
        zzc.zzd(obtain, locationRequest);
        obtain.writeStrongBinder(zzclVar);
        zzc(obtain, 88);
    }

    @Override // com.google.android.gms.internal.location.zzo
    public final void zzy(zzdb zzdbVar, zzcl zzclVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.zzb);
        zzc.zzd(obtain, zzdbVar);
        obtain.writeStrongBinder(zzclVar);
        zzc(obtain, 89);
    }

    @Override // com.google.android.gms.internal.location.zzo
    public final void zzz(zzdf zzdfVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.zzb);
        zzc.zzd(obtain, zzdfVar);
        zzc(obtain, 59);
    }
}
