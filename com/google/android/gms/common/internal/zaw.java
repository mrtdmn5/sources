package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public final class zaw implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int r4 = 0;
        boolean z = false;
        boolean z2 = false;
        IBinder iBinder = null;
        ConnectionResult connectionResult = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c != 1) {
                if (c != 2) {
                    if (c != 3) {
                        if (c != 4) {
                            if (c != 5) {
                                SafeParcelReader.skipUnknownField(parcel, readInt);
                            } else {
                                z2 = SafeParcelReader.readBoolean(parcel, readInt);
                            }
                        } else {
                            z = SafeParcelReader.readBoolean(parcel, readInt);
                        }
                    } else {
                        connectionResult = (ConnectionResult) SafeParcelReader.createParcelable(parcel, readInt, ConnectionResult.CREATOR);
                    }
                } else {
                    iBinder = SafeParcelReader.readIBinder(parcel, readInt);
                }
            } else {
                r4 = SafeParcelReader.readInt(parcel, readInt);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zav(r4, iBinder, connectionResult, z, z2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int r1) {
        return new zav[r1];
    }
}
