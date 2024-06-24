package com.google.android.gms.internal.fitness;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.zabv;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.request.zzk;

/* compiled from: com.google.android.gms:play-services-fitness@@21.1.0 */
/* loaded from: classes3.dex */
public final class zzdi extends zzah {
    public final /* synthetic */ DataSet zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdi(zabv zabvVar, DataSet dataSet) {
        super(zabvVar);
        this.zza = dataSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    public final void doExecute(Api.Client client) throws RemoteException {
        zzes zzesVar = new zzes(this);
        zzca zzcaVar = (zzca) ((zzaj) client).getService();
        zzk zzkVar = new zzk(this.zza, zzesVar);
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(zzcaVar.zzb);
        int r2 = zzc.$r8$clinit;
        obtain.writeInt(1);
        zzkVar.writeToParcel(obtain, 0);
        Parcel obtain2 = Parcel.obtain();
        try {
            zzcaVar.zza.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain.recycle();
            obtain2.recycle();
        }
    }
}
