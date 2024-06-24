package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
/* loaded from: classes3.dex */
public final class zzw implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int r7 = 1000;
        int r8 = 1;
        int r9 = 1;
        long j = 0;
        zzac[] zzacVarArr = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 1:
                    r8 = SafeParcelReader.readInt(parcel, readInt);
                    break;
                case 2:
                    r9 = SafeParcelReader.readInt(parcel, readInt);
                    break;
                case 3:
                    j = SafeParcelReader.readLong(parcel, readInt);
                    break;
                case 4:
                    r7 = SafeParcelReader.readInt(parcel, readInt);
                    break;
                case 5:
                    zzacVarArr = (zzac[]) SafeParcelReader.createTypedArray(parcel, readInt, zzac.CREATOR);
                    break;
                case 6:
                    SafeParcelReader.readBoolean(parcel, readInt);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readInt);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new LocationAvailability(r7, r8, r9, j, zzacVarArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int r1) {
        return new LocationAvailability[r1];
    }
}
