package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes3.dex */
public final class PatternItem extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PatternItem> CREATOR = new zzj();
    public final int zzb;
    public final Float zzc;

    public PatternItem(int r4, Float f) {
        boolean z = true;
        if (r4 != 1 && (f == null || f.floatValue() < 0.0f)) {
            z = false;
        }
        Preconditions.checkArgument("Invalid PatternItem: type=" + r4 + " length=" + f, z);
        this.zzb = r4;
        this.zzc = f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PatternItem)) {
            return false;
        }
        PatternItem patternItem = (PatternItem) obj;
        if (this.zzb == patternItem.zzb && Objects.equal(this.zzc, patternItem.zzc)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zzb), this.zzc});
    }

    public final String toString() {
        return "[PatternItem: type=" + this.zzb + " length=" + this.zzc + "]";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r4) {
        int zza = OnTimeoutKt.zza(parcel, 20293);
        OnTimeoutKt.writeInt(parcel, 2, this.zzb);
        OnTimeoutKt.writeFloatObject(parcel, 3, this.zzc);
        OnTimeoutKt.zzb(parcel, zza);
    }
}
