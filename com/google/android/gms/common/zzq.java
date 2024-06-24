package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzq> CREATOR = new zzr();
    public final boolean zza;
    public final String zzb;
    public final int zzc;
    public final int zzd;

    public zzq(String str, int r5, int r6, boolean z) {
        this.zza = z;
        this.zzb = str;
        this.zzc = zzy.zza(r5) - 1;
        int r4 = 1;
        int[] r52 = {1, 2, 3};
        int r0 = 0;
        while (true) {
            if (r0 >= 3) {
                break;
            }
            int r1 = r52[r0];
            int r2 = r1 - 1;
            if (r1 != 0) {
                if (r2 == r6) {
                    r4 = r1;
                    break;
                }
                r0++;
            } else {
                throw null;
            }
        }
        this.zzd = r4 - 1;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r4) {
        int zza = OnTimeoutKt.zza(parcel, 20293);
        OnTimeoutKt.writeBoolean(parcel, 1, this.zza);
        OnTimeoutKt.writeString(parcel, 2, this.zzb);
        OnTimeoutKt.writeInt(parcel, 3, this.zzc);
        OnTimeoutKt.writeInt(parcel, 4, this.zzd);
        OnTimeoutKt.zzb(parcel, zza);
    }
}
