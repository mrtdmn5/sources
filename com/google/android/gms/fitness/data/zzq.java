package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-fitness@@21.1.0 */
/* loaded from: classes3.dex */
public final class zzq implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        Boolean bool = null;
        int r4 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            boolean z = true;
            if (c != 1) {
                if (c != 2) {
                    if (c != 3) {
                        SafeParcelReader.skipUnknownField(parcel, readInt);
                    } else {
                        int readSize = SafeParcelReader.readSize(parcel, readInt);
                        if (readSize == 0) {
                            bool = null;
                        } else {
                            SafeParcelReader.zza(parcel, readSize, 4);
                            if (parcel.readInt() == 0) {
                                z = false;
                            }
                            bool = Boolean.valueOf(z);
                        }
                    }
                } else {
                    r4 = SafeParcelReader.readInt(parcel, readInt);
                }
            } else {
                str = SafeParcelReader.createString(parcel, readInt);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new Field(str, r4, bool);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int r1) {
        return new Field[r1];
    }
}
