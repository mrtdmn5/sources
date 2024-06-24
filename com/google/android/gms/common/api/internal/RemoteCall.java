package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public interface RemoteCall<T, U> {
    void accept(Api.Client client, Object obj) throws RemoteException;
}
