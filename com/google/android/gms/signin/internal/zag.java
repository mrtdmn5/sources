package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.List;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public final class zag extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<zag> CREATOR = new zah();
    public final List zaa;
    public final String zab;

    public zag(ArrayList arrayList, String str) {
        this.zaa = arrayList;
        this.zab = str;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        if (this.zab != null) {
            return Status.RESULT_SUCCESS;
        }
        return Status.RESULT_CANCELED;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r4) {
        int zza = OnTimeoutKt.zza(parcel, 20293);
        List<String> list = this.zaa;
        if (list != null) {
            int zza2 = OnTimeoutKt.zza(parcel, 1);
            parcel.writeStringList(list);
            OnTimeoutKt.zzb(parcel, zza2);
        }
        OnTimeoutKt.writeString(parcel, 2, this.zab);
        OnTimeoutKt.zzb(parcel, zza);
    }
}
