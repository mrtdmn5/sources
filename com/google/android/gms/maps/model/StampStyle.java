package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes3.dex */
public final class StampStyle extends AbstractSafeParcelable {
    public static final Parcelable.Creator<StampStyle> CREATOR = new zzo();
    public final BitmapDescriptor zza;

    public StampStyle(IBinder iBinder) {
        this.zza = new BitmapDescriptor(IObjectWrapper.Stub.asInterface(iBinder));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r4) {
        int zza = OnTimeoutKt.zza(parcel, 20293);
        OnTimeoutKt.writeIBinder(parcel, 2, this.zza.zza.asBinder());
        OnTimeoutKt.zzb(parcel, zza);
    }
}
