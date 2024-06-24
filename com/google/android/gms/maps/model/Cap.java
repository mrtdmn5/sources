package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$$ExternalSyntheticOutline0;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes3.dex */
public class Cap extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Cap> CREATOR = new zzb();
    public final int zzb;
    public final BitmapDescriptor zzc;
    public final Float zzd;

    public Cap() {
        throw null;
    }

    public Cap(int r5, BitmapDescriptor bitmapDescriptor, Float f) {
        boolean z = f != null && f.floatValue() > 0.0f;
        if (r5 == 3) {
            r0 = bitmapDescriptor != null && z;
            r5 = 3;
        }
        Preconditions.checkArgument(String.format("Invalid Cap: type=%s bitmapDescriptor=%s bitmapRefWidth=%s", Integer.valueOf(r5), bitmapDescriptor, f), r0);
        this.zzb = r5;
        this.zzc = bitmapDescriptor;
        this.zzd = f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cap)) {
            return false;
        }
        Cap cap = (Cap) obj;
        if (this.zzb == cap.zzb && Objects.equal(this.zzc, cap.zzc) && Objects.equal(this.zzd, cap.zzd)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zzb), this.zzc, this.zzd});
    }

    public String toString() {
        return ConstraintWidget$$ExternalSyntheticOutline0.m(new StringBuilder("[Cap: type="), this.zzb, "]");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r4) {
        IBinder asBinder;
        int zza = OnTimeoutKt.zza(parcel, 20293);
        OnTimeoutKt.writeInt(parcel, 2, this.zzb);
        BitmapDescriptor bitmapDescriptor = this.zzc;
        if (bitmapDescriptor == null) {
            asBinder = null;
        } else {
            asBinder = bitmapDescriptor.zza.asBinder();
        }
        OnTimeoutKt.writeIBinder(parcel, 3, asBinder);
        OnTimeoutKt.writeFloatObject(parcel, 4, this.zzd);
        OnTimeoutKt.zzb(parcel, zza);
    }

    public final Cap zza() {
        boolean z;
        int r0 = this.zzb;
        if (r0 != 0) {
            boolean z2 = true;
            if (r0 != 1) {
                if (r0 != 2) {
                    if (r0 != 3) {
                        Log.w("Cap", "Unknown Cap type: " + r0);
                        return this;
                    }
                    BitmapDescriptor bitmapDescriptor = this.zzc;
                    if (bitmapDescriptor != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Preconditions.checkState("bitmapDescriptor must not be null", z);
                    Float f = this.zzd;
                    if (f == null) {
                        z2 = false;
                    }
                    Preconditions.checkState("bitmapRefWidth must not be null", z2);
                    return new CustomCap(bitmapDescriptor, f.floatValue());
                }
                return new RoundCap();
            }
            return new SquareCap();
        }
        return new ButtCap();
    }
}
