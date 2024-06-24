package com.google.android.gms.location;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.internal.location.zzb;
import com.google.android.gms.internal.location.zzbo;
import com.google.android.gms.internal.location.zzc;
import com.google.android.gms.internal.location.zzct;
import com.google.android.gms.internal.location.zzcu;
import com.google.android.gms.internal.location.zzcw;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
/* loaded from: classes3.dex */
public abstract class zzq extends zzb implements zzr {
    public static final /* synthetic */ int $r8$clinit = 0;

    public zzq() {
        super("com.google.android.gms.location.ILocationCallback");
    }

    @Override // com.google.android.gms.internal.location.zzb
    public final boolean zza(int r3, Parcel parcel) throws RemoteException {
        ListenerHolder listenerHolder;
        ListenerHolder listenerHolder2;
        if (r3 != 1) {
            if (r3 != 2) {
                if (r3 != 3) {
                    return false;
                }
                ((zzcw) this).zzf();
            } else {
                LocationAvailability locationAvailability = (LocationAvailability) zzc.zza(parcel, LocationAvailability.CREATOR);
                zzc.zzb(parcel);
                zzbo zzboVar = (zzbo) ((zzcw) this).zza;
                synchronized (zzboVar) {
                    listenerHolder2 = zzboVar.zzc;
                }
                listenerHolder2.notifyListener(new zzcu(locationAvailability));
            }
        } else {
            LocationResult locationResult = (LocationResult) zzc.zza(parcel, LocationResult.CREATOR);
            zzc.zzb(parcel);
            zzbo zzboVar2 = (zzbo) ((zzcw) this).zza;
            synchronized (zzboVar2) {
                listenerHolder = zzboVar2.zzc;
            }
            listenerHolder.notifyListener(new zzct(locationResult));
        }
        return true;
    }
}
