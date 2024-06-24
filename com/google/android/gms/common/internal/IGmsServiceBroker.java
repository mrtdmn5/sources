package com.google.android.gms.common.internal;

import android.os.IInterface;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public interface IGmsServiceBroker extends IInterface {
    void getService(zzd zzdVar, GetServiceRequest getServiceRequest) throws RemoteException;
}
