package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.location.zzd;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
/* loaded from: classes3.dex */
public final class zzx implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        WorkSource workSource = new WorkSource();
        int r19 = 102;
        long j = 3600000;
        long j2 = 600000;
        long j3 = 0;
        long j4 = Long.MAX_VALUE;
        long j5 = Long.MAX_VALUE;
        int r30 = Integer.MAX_VALUE;
        float f = 0.0f;
        boolean z = false;
        int r35 = 0;
        int r36 = 0;
        boolean z2 = false;
        long j6 = -1;
        String str = null;
        zzd zzdVar = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 1:
                    r19 = SafeParcelReader.readInt(parcel, readInt);
                    break;
                case 2:
                    j = SafeParcelReader.readLong(parcel, readInt);
                    break;
                case 3:
                    j2 = SafeParcelReader.readLong(parcel, readInt);
                    break;
                case 4:
                default:
                    SafeParcelReader.skipUnknownField(parcel, readInt);
                    break;
                case 5:
                    j4 = SafeParcelReader.readLong(parcel, readInt);
                    break;
                case 6:
                    r30 = SafeParcelReader.readInt(parcel, readInt);
                    break;
                case 7:
                    f = SafeParcelReader.readFloat(parcel, readInt);
                    break;
                case '\b':
                    j3 = SafeParcelReader.readLong(parcel, readInt);
                    break;
                case '\t':
                    z = SafeParcelReader.readBoolean(parcel, readInt);
                    break;
                case '\n':
                    j5 = SafeParcelReader.readLong(parcel, readInt);
                    break;
                case 11:
                    j6 = SafeParcelReader.readLong(parcel, readInt);
                    break;
                case '\f':
                    r35 = SafeParcelReader.readInt(parcel, readInt);
                    break;
                case '\r':
                    r36 = SafeParcelReader.readInt(parcel, readInt);
                    break;
                case 14:
                    str = SafeParcelReader.createString(parcel, readInt);
                    break;
                case 15:
                    z2 = SafeParcelReader.readBoolean(parcel, readInt);
                    break;
                case 16:
                    workSource = (WorkSource) SafeParcelReader.createParcelable(parcel, readInt, WorkSource.CREATOR);
                    break;
                case 17:
                    zzdVar = (zzd) SafeParcelReader.createParcelable(parcel, readInt, zzd.CREATOR);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new LocationRequest(r19, j, j2, j3, j4, j5, r30, f, z, j6, r35, r36, str, z2, workSource, zzdVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int r1) {
        return new LocationRequest[r1];
    }
}
