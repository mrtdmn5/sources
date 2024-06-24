package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public final class zzb implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int r4 = 0;
        int r5 = 0;
        String str = null;
        PendingIntent pendingIntent = null;
        ConnectionResult connectionResult = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c != 1) {
                if (c != 2) {
                    if (c != 3) {
                        if (c != 4) {
                            if (c != 1000) {
                                SafeParcelReader.skipUnknownField(parcel, readInt);
                            } else {
                                r4 = SafeParcelReader.readInt(parcel, readInt);
                            }
                        } else {
                            connectionResult = (ConnectionResult) SafeParcelReader.createParcelable(parcel, readInt, ConnectionResult.CREATOR);
                        }
                    } else {
                        pendingIntent = (PendingIntent) SafeParcelReader.createParcelable(parcel, readInt, PendingIntent.CREATOR);
                    }
                } else {
                    str = SafeParcelReader.createString(parcel, readInt);
                }
            } else {
                r5 = SafeParcelReader.readInt(parcel, readInt);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new Status(r4, r5, str, pendingIntent, connectionResult);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int r1) {
        return new Status[r1];
    }
}
