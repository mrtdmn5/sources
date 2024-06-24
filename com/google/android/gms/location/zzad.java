package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
/* loaded from: classes3.dex */
public final class zzad implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int r5 = 1;
        int r6 = 1;
        long j = -1;
        long j2 = -1;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c != 1) {
                if (c != 2) {
                    if (c != 3) {
                        if (c != 4) {
                            SafeParcelReader.skipUnknownField(parcel, readInt);
                        } else {
                            j2 = SafeParcelReader.readLong(parcel, readInt);
                        }
                    } else {
                        j = SafeParcelReader.readLong(parcel, readInt);
                    }
                } else {
                    r6 = SafeParcelReader.readInt(parcel, readInt);
                }
            } else {
                r5 = SafeParcelReader.readInt(parcel, readInt);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzac(r5, r6, j, j2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int r1) {
        return new zzac[r1];
    }
}
