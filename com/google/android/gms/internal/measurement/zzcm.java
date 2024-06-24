package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzcm implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        long j = 0;
        long j2 = 0;
        boolean z = false;
        String str = null;
        String str2 = null;
        String str3 = null;
        Bundle bundle = null;
        String str4 = null;
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
                    z = SafeParcelReader.readBoolean(parcel, readInt);
                    break;
                case 4:
                    str = SafeParcelReader.createString(parcel, readInt);
                    break;
                case 5:
                    str2 = SafeParcelReader.createString(parcel, readInt);
                    break;
                case 6:
                    str3 = SafeParcelReader.createString(parcel, readInt);
                    break;
                case 7:
                    bundle = SafeParcelReader.createBundle(parcel, readInt);
                    break;
                case '\b':
                    str4 = SafeParcelReader.createString(parcel, readInt);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readInt);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzcl(j, j2, z, str, str2, str3, bundle, str4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int r1) {
        return new zzcl[r1];
    }
}
