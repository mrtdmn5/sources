package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
/* loaded from: classes3.dex */
public final class zzg extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<zzg> CREATOR;
    public final Status zzb;

    static {
        new zzg(Status.RESULT_SUCCESS);
        CREATOR = new zzh();
    }

    public zzg(Status status) {
        this.zzb = status;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zzb;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r5) {
        int zza = OnTimeoutKt.zza(parcel, 20293);
        OnTimeoutKt.writeParcelable(parcel, 1, this.zzb, r5);
        OnTimeoutKt.zzb(parcel, zza);
    }
}
