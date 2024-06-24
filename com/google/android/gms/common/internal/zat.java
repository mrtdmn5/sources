package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public final class zat extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zat> CREATOR = new zau();
    public final int zaa;
    public final Account zab;
    public final int zac;
    public final GoogleSignInAccount zad;

    public zat(int r1, Account account, int r3, GoogleSignInAccount googleSignInAccount) {
        this.zaa = r1;
        this.zab = account;
        this.zac = r3;
        this.zad = googleSignInAccount;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r5) {
        int zza = OnTimeoutKt.zza(parcel, 20293);
        OnTimeoutKt.writeInt(parcel, 1, this.zaa);
        OnTimeoutKt.writeParcelable(parcel, 2, this.zab, r5);
        OnTimeoutKt.writeInt(parcel, 3, this.zac);
        OnTimeoutKt.writeParcelable(parcel, 4, this.zad, r5);
        OnTimeoutKt.zzb(parcel, zza);
    }
}
