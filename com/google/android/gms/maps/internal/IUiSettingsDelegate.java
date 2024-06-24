package com.google.android.gms.maps.internal;

import android.os.IInterface;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes3.dex */
public interface IUiSettingsDelegate extends IInterface {
    void setCompassEnabled(boolean z) throws RemoteException;

    void setMapToolbarEnabled() throws RemoteException;

    void setMyLocationButtonEnabled() throws RemoteException;

    void setRotateGesturesEnabled(boolean z) throws RemoteException;

    void setScrollGesturesEnabled(boolean z) throws RemoteException;

    void setZoomGesturesEnabled(boolean z) throws RemoteException;
}
