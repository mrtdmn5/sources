package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public final class zzb implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int r1 = 0;
        PendingIntent pendingIntent = null;
        String str = null;
        int r2 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c != 1) {
                if (c != 2) {
                    if (c != 3) {
                        if (c != 4) {
                            SafeParcelReader.skipUnknownField(parcel, readInt);
                        } else {
                            str = SafeParcelReader.createString(parcel, readInt);
                        }
                    } else {
                        pendingIntent = (PendingIntent) SafeParcelReader.createParcelable(parcel, readInt, PendingIntent.CREATOR);
                    }
                } else {
                    r2 = SafeParcelReader.readInt(parcel, readInt);
                }
            } else {
                r1 = SafeParcelReader.readInt(parcel, readInt);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new ConnectionResult(r1, r2, pendingIntent, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int r1) {
        return new ConnectionResult[r1];
    }
}
