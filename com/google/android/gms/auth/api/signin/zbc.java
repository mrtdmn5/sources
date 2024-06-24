package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-auth@@20.4.0 */
/* loaded from: classes3.dex */
public final class zbc implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = "";
        GoogleSignInAccount googleSignInAccount = null;
        String str2 = "";
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c != 4) {
                if (c != 7) {
                    if (c != '\b') {
                        SafeParcelReader.skipUnknownField(parcel, readInt);
                    } else {
                        str2 = SafeParcelReader.createString(parcel, readInt);
                    }
                } else {
                    googleSignInAccount = (GoogleSignInAccount) SafeParcelReader.createParcelable(parcel, readInt, GoogleSignInAccount.CREATOR);
                }
            } else {
                str = SafeParcelReader.createString(parcel, readInt);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new SignInAccount(str, googleSignInAccount, str2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int r1) {
        return new SignInAccount[r1];
    }
}
