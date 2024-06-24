package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: com.google.android.gms:play-services-auth@@20.4.0 */
/* loaded from: classes3.dex */
public class SignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<SignInAccount> CREATOR = new zbc();

    @Deprecated
    public final String zba;

    @Deprecated
    public final String zbb;
    public final GoogleSignInAccount zbc;

    public SignInAccount(String str, GoogleSignInAccount googleSignInAccount, String str2) {
        this.zbc = googleSignInAccount;
        Preconditions.checkNotEmpty("8.3 and 8.4 SDKs require non-null email", str);
        this.zba = str;
        Preconditions.checkNotEmpty("8.3 and 8.4 SDKs require non-null userId", str2);
        this.zbb = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r5) {
        int zza = OnTimeoutKt.zza(parcel, 20293);
        OnTimeoutKt.writeString(parcel, 4, this.zba);
        OnTimeoutKt.writeParcelable(parcel, 7, this.zbc, r5);
        OnTimeoutKt.writeString(parcel, 8, this.zbb);
        OnTimeoutKt.zzb(parcel, zza);
    }
}
