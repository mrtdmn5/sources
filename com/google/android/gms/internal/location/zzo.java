package com.google.android.gms.internal.location;

import android.location.Location;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.location.LastLocationRequest;
import com.google.android.gms.location.LocationRequest;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
/* loaded from: classes3.dex */
public interface zzo extends IInterface {
    @Deprecated
    Location zzd() throws RemoteException;

    @Deprecated
    void zzj(LastLocationRequest lastLocationRequest, zzcm zzcmVar) throws RemoteException;

    void zzk(zzdb zzdbVar, LocationRequest locationRequest, zzcl zzclVar) throws RemoteException;

    void zzy(zzdb zzdbVar, zzcl zzclVar) throws RemoteException;

    @Deprecated
    void zzz(zzdf zzdfVar) throws RemoteException;
}
