package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-fitness@@21.1.0 */
/* loaded from: classes3.dex */
public final class zzz implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        Value[] valueArr = null;
        int r12 = 0;
        int r13 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 1:
                    j = SafeParcelReader.readLong(parcel, readInt);
                    break;
                case 2:
                    j2 = SafeParcelReader.readLong(parcel, readInt);
                    break;
                case 3:
                    valueArr = (Value[]) SafeParcelReader.createTypedArray(parcel, readInt, Value.CREATOR);
                    break;
                case 4:
                    r12 = SafeParcelReader.readInt(parcel, readInt);
                    break;
                case 5:
                    r13 = SafeParcelReader.readInt(parcel, readInt);
                    break;
                case 6:
                    j3 = SafeParcelReader.readLong(parcel, readInt);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readInt);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new RawDataPoint(j, j2, valueArr, r12, r13, j3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int r1) {
        return new RawDataPoint[r1];
    }
}
