package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-fitness@@21.1.0 */
/* loaded from: classes3.dex */
public final class zzj implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        DataType dataType = null;
        Device device = null;
        zzb zzbVar = null;
        String str = null;
        int r5 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c != 1) {
                if (c != 3) {
                    if (c != 4) {
                        if (c != 5) {
                            if (c != 6) {
                                SafeParcelReader.skipUnknownField(parcel, readInt);
                            } else {
                                str = SafeParcelReader.createString(parcel, readInt);
                            }
                        } else {
                            zzbVar = (zzb) SafeParcelReader.createParcelable(parcel, readInt, zzb.CREATOR);
                        }
                    } else {
                        device = (Device) SafeParcelReader.createParcelable(parcel, readInt, Device.CREATOR);
                    }
                } else {
                    r5 = SafeParcelReader.readInt(parcel, readInt);
                }
            } else {
                dataType = (DataType) SafeParcelReader.createParcelable(parcel, readInt, DataType.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new DataSource(dataType, r5, device, zzbVar, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int r1) {
        return new DataSource[r1];
    }
}
