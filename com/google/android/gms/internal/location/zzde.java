package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.location.LocationRequest;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
/* loaded from: classes3.dex */
public final class zzde implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        LocationRequest locationRequest = null;
        ArrayList arrayList = null;
        String str = null;
        String str2 = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        long j = Long.MAX_VALUE;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c != 1) {
                if (c != 5) {
                    switch (c) {
                        case '\b':
                            z = SafeParcelReader.readBoolean(parcel, readInt);
                            break;
                        case '\t':
                            z2 = SafeParcelReader.readBoolean(parcel, readInt);
                            break;
                        case '\n':
                            str = SafeParcelReader.createString(parcel, readInt);
                            break;
                        case 11:
                            z3 = SafeParcelReader.readBoolean(parcel, readInt);
                            break;
                        case '\f':
                            z4 = SafeParcelReader.readBoolean(parcel, readInt);
                            break;
                        case '\r':
                            str2 = SafeParcelReader.createString(parcel, readInt);
                            break;
                        case 14:
                            j = SafeParcelReader.readLong(parcel, readInt);
                            break;
                        default:
                            SafeParcelReader.skipUnknownField(parcel, readInt);
                            break;
                    }
                } else {
                    arrayList = SafeParcelReader.createTypedList(parcel, readInt, ClientIdentity.CREATOR);
                }
            } else {
                locationRequest = (LocationRequest) SafeParcelReader.createParcelable(parcel, readInt, LocationRequest.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzdd(locationRequest, arrayList, z, z2, str, z3, z4, str2, j);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int r1) {
        return new zzdd[r1];
    }
}
