package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.animaconnected.firebase.AnalyticsConstants;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public final class Feature extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Feature> CREATOR = new zzc();
    public final String zza;

    @Deprecated
    public final int zzb;
    public final long zzc;

    public Feature(String str, int r2, long j) {
        this.zza = str;
        this.zzb = r2;
        this.zzc = j;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Feature) {
            Feature feature = (Feature) obj;
            String str = this.zza;
            if (((str != null && str.equals(feature.zza)) || (str == null && feature.zza == null)) && getVersion() == feature.getVersion()) {
                return true;
            }
        }
        return false;
    }

    public final long getVersion() {
        long j = this.zzc;
        if (j == -1) {
            return this.zzb;
        }
        return j;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, Long.valueOf(getVersion())});
    }

    public final String toString() {
        Objects.ToStringHelper toStringHelper = new Objects.ToStringHelper(this);
        toStringHelper.add(this.zza, "name");
        toStringHelper.add(Long.valueOf(getVersion()), AnalyticsConstants.KEY_VERSION);
        return toStringHelper.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r5) {
        int zza = OnTimeoutKt.zza(parcel, 20293);
        OnTimeoutKt.writeString(parcel, 1, this.zza);
        OnTimeoutKt.writeInt(parcel, 2, this.zzb);
        OnTimeoutKt.writeLong(parcel, 3, getVersion());
        OnTimeoutKt.zzb(parcel, zza);
    }

    public Feature(String str, long j) {
        this.zza = str;
        this.zzc = j;
        this.zzb = -1;
    }
}
