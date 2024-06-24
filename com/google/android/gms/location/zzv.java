package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.location.zzd;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
/* loaded from: classes3.dex */
public final class zzv implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        long j = Long.MAX_VALUE;
        int r8 = 0;
        boolean z = false;
        String str = null;
        zzd zzdVar = null;
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
                                zzdVar = (zzd) SafeParcelReader.createParcelable(parcel, readInt, zzd.CREATOR);
                            }
                        } else {
                            str = SafeParcelReader.createString(parcel, readInt);
                        }
                    } else {
                        z = SafeParcelReader.readBoolean(parcel, readInt);
                    }
                } else {
                    r8 = SafeParcelReader.readInt(parcel, readInt);
                }
            } else {
                j = SafeParcelReader.readLong(parcel, readInt);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new LastLocationRequest(j, r8, z, str, zzdVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int r1) {
        return new LastLocationRequest[r1];
    }
}
