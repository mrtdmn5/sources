package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public final class GoogleSignInOptionsExtensionParcelable extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GoogleSignInOptionsExtensionParcelable> CREATOR = new zaa();
    public final int zaa;
    public final int zab;
    public final Bundle zac;

    public GoogleSignInOptionsExtensionParcelable(int r1, int r2, Bundle bundle) {
        this.zaa = r1;
        this.zab = r2;
        this.zac = bundle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r4) {
        int zza = OnTimeoutKt.zza(parcel, 20293);
        OnTimeoutKt.writeInt(parcel, 1, this.zaa);
        OnTimeoutKt.writeInt(parcel, 2, this.zab);
        OnTimeoutKt.writeBundle(parcel, 3, this.zac);
        OnTimeoutKt.zzb(parcel, zza);
    }
}
