package com.google.android.gms.maps.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.maps.zzi;
import com.google.android.gms.maps.GoogleMapOptions;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes3.dex */
public interface zzf extends IInterface {
    int zzd() throws RemoteException;

    ICameraUpdateFactoryDelegate zze() throws RemoteException;

    IMapFragmentDelegate zzf(ObjectWrapper objectWrapper) throws RemoteException;

    IMapViewDelegate zzg(ObjectWrapper objectWrapper, GoogleMapOptions googleMapOptions) throws RemoteException;

    zzi zzj() throws RemoteException;

    void zzk(ObjectWrapper objectWrapper) throws RemoteException;

    void zzl(ObjectWrapper objectWrapper, int r2) throws RemoteException;
}
