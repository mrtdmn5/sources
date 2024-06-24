package com.google.android.gms.internal.location;

import android.location.Location;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
/* loaded from: classes3.dex */
public abstract class zzp extends zzb {
    public zzp() {
        super("com.google.android.gms.location.internal.ILocationStatusCallback");
    }

    @Override // com.google.android.gms.internal.location.zzb
    public final boolean zza(int r3, Parcel parcel) throws RemoteException {
        if (r3 == 1) {
            Status status = (Status) zzc.zza(parcel, Status.CREATOR);
            Location location = (Location) zzc.zza(parcel, Location.CREATOR);
            zzc.zzb(parcel);
            TaskUtil.setResultOrApiException(status, location, ((zzcm) this).zza);
            return true;
        }
        return false;
    }
}
