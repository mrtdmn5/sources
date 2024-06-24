package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public final class zau implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int r1 = 0;
        Account account = null;
        GoogleSignInAccount googleSignInAccount = null;
        int r2 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c != 1) {
                if (c != 2) {
                    if (c != 3) {
                        if (c != 4) {
                            SafeParcelReader.skipUnknownField(parcel, readInt);
                        } else {
                            googleSignInAccount = (GoogleSignInAccount) SafeParcelReader.createParcelable(parcel, readInt, GoogleSignInAccount.CREATOR);
                        }
                    } else {
                        r2 = SafeParcelReader.readInt(parcel, readInt);
                    }
                } else {
                    account = (Account) SafeParcelReader.createParcelable(parcel, readInt, Account.CREATOR);
                }
            } else {
                r1 = SafeParcelReader.readInt(parcel, readInt);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zat(r1, account, r2, googleSignInAccount);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int r1) {
        return new zat[r1];
    }
}
