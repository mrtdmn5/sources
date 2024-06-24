package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public final class zae implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        ArrayList arrayList = null;
        int r4 = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        ArrayList arrayList2 = null;
        Account account = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 1:
                    r4 = SafeParcelReader.readInt(parcel, readInt);
                    break;
                case 2:
                    arrayList2 = SafeParcelReader.createTypedList(parcel, readInt, Scope.CREATOR);
                    break;
                case 3:
                    account = (Account) SafeParcelReader.createParcelable(parcel, readInt, Account.CREATOR);
                    break;
                case 4:
                    z = SafeParcelReader.readBoolean(parcel, readInt);
                    break;
                case 5:
                    z2 = SafeParcelReader.readBoolean(parcel, readInt);
                    break;
                case 6:
                    z3 = SafeParcelReader.readBoolean(parcel, readInt);
                    break;
                case 7:
                    str = SafeParcelReader.createString(parcel, readInt);
                    break;
                case '\b':
                    str2 = SafeParcelReader.createString(parcel, readInt);
                    break;
                case '\t':
                    arrayList = SafeParcelReader.createTypedList(parcel, readInt, GoogleSignInOptionsExtensionParcelable.CREATOR);
                    break;
                case '\n':
                    str3 = SafeParcelReader.createString(parcel, readInt);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readInt);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new GoogleSignInOptions(r4, arrayList2, account, z, z2, z3, str, str2, GoogleSignInOptions.zam(arrayList), str3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int r1) {
        return new GoogleSignInOptions[r1];
    }
}
