package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes3.dex */
public final class StrokeStyle extends AbstractSafeParcelable {
    public static final Parcelable.Creator<StrokeStyle> CREATOR = new zzv();
    public final float zza;
    public final int zzb;
    public final int zzc;
    public final boolean zzd;
    public final StampStyle zze;

    public StrokeStyle(float f, int r2, int r3, boolean z, StampStyle stampStyle) {
        this.zza = f;
        this.zzb = r2;
        this.zzc = r3;
        this.zzd = z;
        this.zze = stampStyle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r5) {
        int zza = OnTimeoutKt.zza(parcel, 20293);
        OnTimeoutKt.writeFloat(parcel, 2, this.zza);
        OnTimeoutKt.writeInt(parcel, 3, this.zzb);
        OnTimeoutKt.writeInt(parcel, 4, this.zzc);
        OnTimeoutKt.writeBoolean(parcel, 5, this.zzd);
        OnTimeoutKt.writeParcelable(parcel, 6, this.zze, r5);
        OnTimeoutKt.zzb(parcel, zza);
    }
}
