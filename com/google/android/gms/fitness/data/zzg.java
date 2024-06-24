package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-fitness@@21.1.0 */
/* loaded from: classes3.dex */
public final class zzg implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        DataSource dataSource = null;
        Value[] valueArr = null;
        DataSource dataSource2 = null;
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c != 1) {
                if (c != 3) {
                    if (c != 4) {
                        if (c != 5) {
                            if (c != 6) {
                                if (c != 7) {
                                    SafeParcelReader.skipUnknownField(parcel, readInt);
                                } else {
                                    j3 = SafeParcelReader.readLong(parcel, readInt);
                                }
                            } else {
                                dataSource2 = (DataSource) SafeParcelReader.createParcelable(parcel, readInt, DataSource.CREATOR);
                            }
                        } else {
                            valueArr = (Value[]) SafeParcelReader.createTypedArray(parcel, readInt, Value.CREATOR);
                        }
                    } else {
                        j2 = SafeParcelReader.readLong(parcel, readInt);
                    }
                } else {
                    j = SafeParcelReader.readLong(parcel, readInt);
                }
            } else {
                dataSource = (DataSource) SafeParcelReader.createParcelable(parcel, readInt, DataSource.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new DataPoint(dataSource, j, j2, valueArr, dataSource2, j3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int r1) {
        return new DataPoint[r1];
    }
}
