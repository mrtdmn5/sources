package com.google.android.gms.internal.fitness;

import android.os.BadParcelableException;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-fitness@@21.1.0 */
/* loaded from: classes3.dex */
public class zzb extends Binder implements IInterface {
    public zzb() {
        attachInterface(this, "com.google.android.gms.fitness.internal.IStatusCallback");
    }

    @Override // android.os.Binder
    public final boolean onTransact(int r3, Parcel parcel, Parcel parcel2, int r6) throws RemoteException {
        Status createFromParcel;
        if (r3 > 16777215) {
            if (super.onTransact(r3, parcel, parcel2, r6)) {
                return true;
            }
        } else {
            parcel.enforceInterface(getInterfaceDescriptor());
        }
        zzco zzcoVar = (zzco) this;
        if (r3 == 1) {
            Parcelable.Creator<Status> creator = Status.CREATOR;
            int r62 = zzc.$r8$clinit;
            if (parcel.readInt() == 0) {
                createFromParcel = null;
            } else {
                createFromParcel = creator.createFromParcel(parcel);
            }
            Status status = createFromParcel;
            int dataAvail = parcel.dataAvail();
            if (dataAvail <= 0) {
                ((zzes) zzcoVar).zza.setResult(status);
                return true;
            }
            throw new BadParcelableException(SubMenuBuilder$$ExternalSyntheticOutline0.m("Parcel data not fully consumed, unread size: ", dataAvail));
        }
        return false;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }
}
