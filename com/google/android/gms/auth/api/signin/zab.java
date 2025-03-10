package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public final class zab implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int r7 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Uri uri = null;
        String str5 = null;
        String str6 = null;
        ArrayList arrayList = null;
        String str7 = null;
        String str8 = null;
        long j = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 1:
                    r7 = SafeParcelReader.readInt(parcel, readInt);
                    break;
                case 2:
                    str = SafeParcelReader.createString(parcel, readInt);
                    break;
                case 3:
                    str2 = SafeParcelReader.createString(parcel, readInt);
                    break;
                case 4:
                    str3 = SafeParcelReader.createString(parcel, readInt);
                    break;
                case 5:
                    str4 = SafeParcelReader.createString(parcel, readInt);
                    break;
                case 6:
                    uri = (Uri) SafeParcelReader.createParcelable(parcel, readInt, Uri.CREATOR);
                    break;
                case 7:
                    str5 = SafeParcelReader.createString(parcel, readInt);
                    break;
                case '\b':
                    j = SafeParcelReader.readLong(parcel, readInt);
                    break;
                case '\t':
                    str6 = SafeParcelReader.createString(parcel, readInt);
                    break;
                case '\n':
                    arrayList = SafeParcelReader.createTypedList(parcel, readInt, Scope.CREATOR);
                    break;
                case 11:
                    str7 = SafeParcelReader.createString(parcel, readInt);
                    break;
                case '\f':
                    str8 = SafeParcelReader.createString(parcel, readInt);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readInt);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new GoogleSignInAccount(r7, str, str2, str3, str4, uri, str5, j, str6, arrayList, str7, str8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int r1) {
        return new GoogleSignInAccount[r1];
    }
}
