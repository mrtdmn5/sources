package com.google.android.gms.maps.internal;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.maps.GoogleMapOptions;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes3.dex */
public interface IMapFragmentDelegate extends IInterface {
    void getMapAsync(zzas zzasVar) throws RemoteException;

    void onCreate(Bundle bundle) throws RemoteException;

    IObjectWrapper onCreateView(ObjectWrapper objectWrapper, ObjectWrapper objectWrapper2, Bundle bundle) throws RemoteException;

    void onDestroy() throws RemoteException;

    void onDestroyView() throws RemoteException;

    void onInflate(ObjectWrapper objectWrapper, GoogleMapOptions googleMapOptions, Bundle bundle) throws RemoteException;

    void onLowMemory() throws RemoteException;

    void onPause() throws RemoteException;

    void onResume() throws RemoteException;

    void onSaveInstanceState(Bundle bundle) throws RemoteException;

    void onStart() throws RemoteException;

    void onStop() throws RemoteException;
}
