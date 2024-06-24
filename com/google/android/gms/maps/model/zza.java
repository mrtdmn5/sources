package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes3.dex */
public final class zza implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        LatLng latLng = null;
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c != 2) {
                if (c != 3) {
                    if (c != 4) {
                        if (c != 5) {
                            SafeParcelReader.skipUnknownField(parcel, readInt);
                        } else {
                            f3 = SafeParcelReader.readFloat(parcel, readInt);
                        }
                    } else {
                        f2 = SafeParcelReader.readFloat(parcel, readInt);
                    }
                } else {
                    f = SafeParcelReader.readFloat(parcel, readInt);
                }
            } else {
                latLng = (LatLng) SafeParcelReader.createParcelable(parcel, readInt, LatLng.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new CameraPosition(latLng, f, f2, f3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int r1) {
        return new CameraPosition[r1];
    }
}
