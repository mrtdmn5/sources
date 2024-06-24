package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: com.google.android.gms:play-services-auth@@20.4.0 */
/* loaded from: classes3.dex */
public final class SignInConfiguration extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<SignInConfiguration> CREATOR = new zbu();
    public final String zba;
    public final GoogleSignInOptions zbb;

    public SignInConfiguration(String str, GoogleSignInOptions googleSignInOptions) {
        Preconditions.checkNotEmpty(str);
        this.zba = str;
        this.zbb = googleSignInOptions;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SignInConfiguration)) {
            return false;
        }
        SignInConfiguration signInConfiguration = (SignInConfiguration) obj;
        if (this.zba.equals(signInConfiguration.zba)) {
            GoogleSignInOptions googleSignInOptions = signInConfiguration.zbb;
            GoogleSignInOptions googleSignInOptions2 = this.zbb;
            if (googleSignInOptions2 == null) {
                if (googleSignInOptions == null) {
                    return true;
                }
            } else if (googleSignInOptions2.equals(googleSignInOptions)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int r0 = 1 * 31;
        int r1 = 0;
        String str = this.zba;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int r02 = (r0 + hashCode) * 31;
        GoogleSignInOptions googleSignInOptions = this.zbb;
        if (googleSignInOptions != null) {
            r1 = googleSignInOptions.hashCode();
        }
        return r02 + r1;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r5) {
        int zza = OnTimeoutKt.zza(parcel, 20293);
        OnTimeoutKt.writeString(parcel, 2, this.zba);
        OnTimeoutKt.writeParcelable(parcel, 5, this.zbb, r5);
        OnTimeoutKt.zzb(parcel, zza);
    }
}
