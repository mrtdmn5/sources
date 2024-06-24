package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes3.dex */
public final class StyleSpan extends AbstractSafeParcelable {
    public static final Parcelable.Creator<StyleSpan> CREATOR = new zzw();
    public final StrokeStyle zza;
    public final double zzb;

    public StyleSpan(StrokeStyle strokeStyle, double d) {
        if (d > 0.0d) {
            this.zza = strokeStyle;
            this.zzb = d;
            return;
        }
        throw new IllegalArgumentException("A style must be applied to some segments on a polyline.");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r5) {
        int zza = OnTimeoutKt.zza(parcel, 20293);
        OnTimeoutKt.writeParcelable(parcel, 2, this.zza, r5);
        parcel.writeInt(524291);
        parcel.writeDouble(this.zzb);
        OnTimeoutKt.zzb(parcel, zza);
    }
}
