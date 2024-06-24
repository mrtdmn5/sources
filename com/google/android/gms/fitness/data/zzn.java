package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-fitness@@21.1.0 */
/* loaded from: classes3.dex */
public final class zzn implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        int r4 = 0;
        int r5 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c != 1) {
                if (c != 2) {
                    if (c != 4) {
                        if (c != 5) {
                            if (c != 6) {
                                SafeParcelReader.skipUnknownField(parcel, readInt);
                            } else {
                                r5 = SafeParcelReader.readInt(parcel, readInt);
                            }
                        } else {
                            r4 = SafeParcelReader.readInt(parcel, readInt);
                        }
                    } else {
                        str3 = SafeParcelReader.createString(parcel, readInt);
                    }
                } else {
                    str2 = SafeParcelReader.createString(parcel, readInt);
                }
            } else {
                str = SafeParcelReader.createString(parcel, readInt);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new Device(r4, r5, str, str2, str3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int r1) {
        return new Device[r1];
    }
}
