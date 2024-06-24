package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth@@20.4.0 */
/* loaded from: classes3.dex */
public final class zbk extends zbl {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    public final void doExecute(Api.Client client) throws RemoteException {
        zbe zbeVar = (zbe) client;
        zbs zbsVar = (zbs) zbeVar.getService();
        zbj zbjVar = new zbj(this);
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(zbsVar.zbb);
        int r3 = com.google.android.gms.internal.p000authapi.zbc.$r8$clinit;
        obtain.writeStrongBinder(zbjVar);
        GoogleSignInOptions googleSignInOptions = zbeVar.zba;
        if (googleSignInOptions == null) {
            obtain.writeInt(0);
        } else {
            obtain.writeInt(1);
            googleSignInOptions.writeToParcel(obtain, 0);
        }
        Parcel obtain2 = Parcel.obtain();
        try {
            zbsVar.zba.transact(103, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain.recycle();
            obtain2.recycle();
        }
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* bridge */ /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }
}
