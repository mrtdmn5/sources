package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes3.dex */
public final class zzb implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int r1 = 0;
        BitmapDescriptor bitmapDescriptor = null;
        IBinder iBinder = null;
        Float f = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c != 2) {
                if (c != 3) {
                    if (c != 4) {
                        SafeParcelReader.skipUnknownField(parcel, readInt);
                    } else {
                        f = SafeParcelReader.readFloatObject(parcel, readInt);
                    }
                } else {
                    iBinder = SafeParcelReader.readIBinder(parcel, readInt);
                }
            } else {
                r1 = SafeParcelReader.readInt(parcel, readInt);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        if (iBinder != null) {
            bitmapDescriptor = new BitmapDescriptor(IObjectWrapper.Stub.asInterface(iBinder));
        }
        return new Cap(r1, bitmapDescriptor, f);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int r1) {
        return new Cap[r1];
    }
}
