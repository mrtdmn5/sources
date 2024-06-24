package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: com.google.android.gms:play-services-fitness@@21.1.0 */
/* loaded from: classes3.dex */
public class MapValue extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<MapValue> CREATOR = new zzw();
    public final int zza;
    public final float zzb;

    public MapValue(float f, int r2) {
        this.zza = r2;
        this.zzb = f;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapValue)) {
            return false;
        }
        MapValue mapValue = (MapValue) obj;
        int r1 = mapValue.zza;
        int r3 = this.zza;
        if (r3 == r1) {
            float f = this.zzb;
            float f2 = mapValue.zzb;
            if (r3 != 2) {
                if (f == f2) {
                    return true;
                }
                return false;
            }
            if (r3 == 2) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState("Value is not in float format", z);
            if (mapValue.zza == 2) {
                z2 = true;
            } else {
                z2 = false;
            }
            Preconditions.checkState("Value is not in float format", z2);
            if (f == f2) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (int) this.zzb;
    }

    public final String toString() {
        boolean z;
        int r0 = this.zza;
        if (r0 != 2) {
            return "unknown";
        }
        if (r0 == 2) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState("Value is not in float format", z);
        return Float.toString(this.zzb);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r4) {
        int zza = OnTimeoutKt.zza(parcel, 20293);
        OnTimeoutKt.writeInt(parcel, 1, this.zza);
        OnTimeoutKt.writeFloat(parcel, 2, this.zzb);
        OnTimeoutKt.zzb(parcel, zza);
    }
}
