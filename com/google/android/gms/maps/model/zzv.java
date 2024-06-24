package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes3.dex */
public final class zzv implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        float f = 0.0f;
        int r6 = 0;
        int r7 = 0;
        boolean z = false;
        StampStyle stampStyle = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c != 2) {
                if (c != 3) {
                    if (c != 4) {
                        if (c != 5) {
                            if (c != 6) {
                                SafeParcelReader.skipUnknownField(parcel, readInt);
                            } else {
                                stampStyle = (StampStyle) SafeParcelReader.createParcelable(parcel, readInt, StampStyle.CREATOR);
                            }
                        } else {
                            z = SafeParcelReader.readBoolean(parcel, readInt);
                        }
                    } else {
                        r7 = SafeParcelReader.readInt(parcel, readInt);
                    }
                } else {
                    r6 = SafeParcelReader.readInt(parcel, readInt);
                }
            } else {
                f = SafeParcelReader.readFloat(parcel, readInt);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new StrokeStyle(f, r6, r7, z, stampStyle);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int r1) {
        return new StrokeStyle[r1];
    }
}
