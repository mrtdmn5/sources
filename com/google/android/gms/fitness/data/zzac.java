package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-fitness@@21.1.0 */
/* loaded from: classes3.dex */
public final class zzac implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        long j = 0;
        long j2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        zzb zzbVar = null;
        Long l = null;
        int r14 = 0;
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
                    str = SafeParcelReader.createString(parcel, readInt);
                    break;
                case 4:
                    str2 = SafeParcelReader.createString(parcel, readInt);
                    break;
                case 5:
                    str3 = SafeParcelReader.createString(parcel, readInt);
                    break;
                case 6:
                default:
                    SafeParcelReader.skipUnknownField(parcel, readInt);
                    break;
                case 7:
                    r14 = SafeParcelReader.readInt(parcel, readInt);
                    break;
                case '\b':
                    zzbVar = (zzb) SafeParcelReader.createParcelable(parcel, readInt, zzb.CREATOR);
                    break;
                case '\t':
                    int readSize = SafeParcelReader.readSize(parcel, readInt);
                    if (readSize == 0) {
                        l = null;
                        break;
                    } else {
                        SafeParcelReader.zza(parcel, readSize, 8);
                        l = Long.valueOf(parcel.readLong());
                        break;
                    }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new Session(j, j2, str, str2, str3, r14, zzbVar, l);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int r1) {
        return new Session[r1];
    }
}
