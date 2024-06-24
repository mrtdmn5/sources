package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes3.dex */
public final class zzw implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        StrokeStyle strokeStyle = null;
        double d = 0.0d;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c != 2) {
                if (c != 3) {
                    SafeParcelReader.skipUnknownField(parcel, readInt);
                } else {
                    SafeParcelReader.zzb(parcel, readInt, 8);
                    d = parcel.readDouble();
                }
            } else {
                strokeStyle = (StrokeStyle) SafeParcelReader.createParcelable(parcel, readInt, StrokeStyle.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new StyleSpan(strokeStyle, d);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int r1) {
        return new StyleSpan[r1];
    }
}
