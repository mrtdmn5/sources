package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.animaconnected.cloud.amazon.AWSLambda$$ExternalSyntheticLambda2;
import com.animaconnected.secondo.screens.workout.DebugWorkoutMapFragment;
import com.google.android.gms.maps.zzj;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes3.dex */
public abstract class zzan extends com.google.android.gms.internal.maps.zzb {
    public zzan() {
        super("com.google.android.gms.maps.internal.IOnMapLoadedCallback");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    public final boolean zza(int r1, Parcel parcel, Parcel parcel2) throws RemoteException {
        if (r1 == 1) {
            DebugWorkoutMapFragment.onCreateView$lambda$4$lambda$3$lambda$1((DebugWorkoutMapFragment) ((AWSLambda$$ExternalSyntheticLambda2) ((zzj) this).zza).f$0);
            parcel2.writeNoException();
            return true;
        }
        return false;
    }
}
