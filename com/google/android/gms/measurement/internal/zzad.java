package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzad implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        String str2 = null;
        zzkw zzkwVar = null;
        String str3 = null;
        zzaw zzawVar = null;
        zzaw zzawVar2 = null;
        zzaw zzawVar3 = null;
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        boolean z = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 2:
                    str = SafeParcelReader.createString(parcel, readInt);
                    break;
                case 3:
                    str2 = SafeParcelReader.createString(parcel, readInt);
                    break;
                case 4:
                    zzkwVar = (zzkw) SafeParcelReader.createParcelable(parcel, readInt, zzkw.CREATOR);
                    break;
                case 5:
                    j = SafeParcelReader.readLong(parcel, readInt);
                    break;
                case 6:
                    z = SafeParcelReader.readBoolean(parcel, readInt);
                    break;
                case 7:
                    str3 = SafeParcelReader.createString(parcel, readInt);
                    break;
                case '\b':
                    zzawVar = (zzaw) SafeParcelReader.createParcelable(parcel, readInt, zzaw.CREATOR);
                    break;
                case '\t':
                    j2 = SafeParcelReader.readLong(parcel, readInt);
                    break;
                case '\n':
                    zzawVar2 = (zzaw) SafeParcelReader.createParcelable(parcel, readInt, zzaw.CREATOR);
                    break;
                case 11:
                    j3 = SafeParcelReader.readLong(parcel, readInt);
                    break;
                case '\f':
                    zzawVar3 = (zzaw) SafeParcelReader.createParcelable(parcel, readInt, zzaw.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readInt);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzac(str, str2, zzkwVar, j, z, str3, zzawVar, j2, zzawVar2, j3, zzawVar3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int r1) {
        return new zzac[r1];
    }
}
