package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes3.dex */
public final class LatLngBounds extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<LatLngBounds> CREATOR = new zzf();
    public final LatLng northeast;
    public final LatLng southwest;

    /* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
    /* loaded from: classes3.dex */
    public static final class Builder {
        public double zza = Double.POSITIVE_INFINITY;
        public double zzb = Double.NEGATIVE_INFINITY;
        public double zzc = Double.NaN;
        public double zzd = Double.NaN;

        public final void include(LatLng latLng) {
            double d = this.zza;
            double d2 = latLng.latitude;
            this.zza = Math.min(d, d2);
            this.zzb = Math.max(this.zzb, d2);
            boolean isNaN = Double.isNaN(this.zzc);
            double d3 = latLng.longitude;
            if (isNaN) {
                this.zzc = d3;
                this.zzd = d3;
                return;
            }
            double d4 = this.zzc;
            double d5 = this.zzd;
            if (d4 <= d5) {
                if (d4 <= d3 && d3 <= d5) {
                    return;
                }
            } else if (d4 <= d3 || d3 <= d5) {
                return;
            }
            if (((d4 - d3) + 360.0d) % 360.0d < ((d3 - d5) + 360.0d) % 360.0d) {
                this.zzc = d3;
            } else {
                this.zzd = d3;
            }
        }
    }

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        boolean z;
        if (latLng != null) {
            if (latLng2 != null) {
                double d = latLng2.latitude;
                double d2 = latLng.latitude;
                if (d >= d2) {
                    z = true;
                } else {
                    z = false;
                }
                Preconditions.checkArgument(z, "southern latitude exceeds northern latitude (%s > %s)", Double.valueOf(d2), Double.valueOf(d));
                this.southwest = latLng;
                this.northeast = latLng2;
                return;
            }
            throw new NullPointerException("northeast must not be null.");
        }
        throw new NullPointerException("southwest must not be null.");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) obj;
        if (this.southwest.equals(latLngBounds.southwest) && this.northeast.equals(latLngBounds.northeast)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.southwest, this.northeast});
    }

    public final String toString() {
        Objects.ToStringHelper toStringHelper = new Objects.ToStringHelper(this);
        toStringHelper.add(this.southwest, "southwest");
        toStringHelper.add(this.northeast, "northeast");
        return toStringHelper.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r5) {
        int zza = OnTimeoutKt.zza(parcel, 20293);
        OnTimeoutKt.writeParcelable(parcel, 2, this.southwest, r5);
        OnTimeoutKt.writeParcelable(parcel, 3, this.northeast, r5);
        OnTimeoutKt.zzb(parcel, zza);
    }
}
