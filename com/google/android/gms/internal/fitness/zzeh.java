package com.google.android.gms.internal.fitness;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.zabv;
import com.google.android.gms.fitness.request.SessionInsertRequest;

/* compiled from: com.google.android.gms:play-services-fitness@@21.1.0 */
/* loaded from: classes3.dex */
public final class zzeh extends zzbf {
    public final /* synthetic */ SessionInsertRequest zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzeh(zabv zabvVar, SessionInsertRequest sessionInsertRequest) {
        super(zabvVar);
        this.zza = sessionInsertRequest;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    public final void doExecute(Api.Client client) throws RemoteException {
        zzes zzesVar = new zzes(this);
        zzcd zzcdVar = (zzcd) ((zzbh) client).getService();
        SessionInsertRequest sessionInsertRequest = this.zza;
        SessionInsertRequest sessionInsertRequest2 = new SessionInsertRequest(sessionInsertRequest.zzb, sessionInsertRequest.zzc, sessionInsertRequest.zzd, zzesVar);
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(zzcdVar.zzb);
        int r2 = zzc.$r8$clinit;
        obtain.writeInt(1);
        sessionInsertRequest2.writeToParcel(obtain, 0);
        Parcel obtain2 = Parcel.obtain();
        try {
            zzcdVar.zza.transact(3, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain.recycle();
            obtain2.recycle();
        }
    }
}
