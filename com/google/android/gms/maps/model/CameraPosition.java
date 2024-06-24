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
public final class CameraPosition extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<CameraPosition> CREATOR = new zza();
    public final float bearing;
    public final LatLng target;
    public final float tilt;
    public final float zoom;

    public CameraPosition(LatLng latLng, float f, float f2, float f3) {
        boolean z;
        if (latLng != null) {
            if (f2 >= 0.0f && f2 <= 90.0f) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "Tilt needs to be between 0 and 90 inclusive: %s", Float.valueOf(f2));
            this.target = latLng;
            this.zoom = f;
            this.tilt = f2 + 0.0f;
            this.bearing = (((double) f3) <= 0.0d ? (f3 % 360.0f) + 360.0f : f3) % 360.0f;
            return;
        }
        throw new NullPointerException("camera target must not be null.");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CameraPosition)) {
            return false;
        }
        CameraPosition cameraPosition = (CameraPosition) obj;
        if (this.target.equals(cameraPosition.target) && Float.floatToIntBits(this.zoom) == Float.floatToIntBits(cameraPosition.zoom) && Float.floatToIntBits(this.tilt) == Float.floatToIntBits(cameraPosition.tilt) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(cameraPosition.bearing)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.target, Float.valueOf(this.zoom), Float.valueOf(this.tilt), Float.valueOf(this.bearing)});
    }

    public final String toString() {
        Objects.ToStringHelper toStringHelper = new Objects.ToStringHelper(this);
        toStringHelper.add(this.target, "target");
        toStringHelper.add(Float.valueOf(this.zoom), "zoom");
        toStringHelper.add(Float.valueOf(this.tilt), "tilt");
        toStringHelper.add(Float.valueOf(this.bearing), "bearing");
        return toStringHelper.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r5) {
        int zza = OnTimeoutKt.zza(parcel, 20293);
        OnTimeoutKt.writeParcelable(parcel, 2, this.target, r5);
        OnTimeoutKt.writeFloat(parcel, 3, this.zoom);
        OnTimeoutKt.writeFloat(parcel, 4, this.tilt);
        OnTimeoutKt.writeFloat(parcel, 5, this.bearing);
        OnTimeoutKt.zzb(parcel, zza);
    }
}
