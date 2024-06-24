package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public final class zan implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int r8 = 0;
        int r9 = 0;
        int r10 = 0;
        int r17 = 0;
        long j = 0;
        long j2 = 0;
        String str = null;
        String str2 = null;
        int r18 = -1;
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
                    r10 = SafeParcelReader.readInt(parcel, readInt);
                    break;
                case 4:
                    j = SafeParcelReader.readLong(parcel, readInt);
                    break;
                case 5:
                    j2 = SafeParcelReader.readLong(parcel, readInt);
                    break;
                case 6:
                    str = SafeParcelReader.createString(parcel, readInt);
                    break;
                case 7:
                    str2 = SafeParcelReader.createString(parcel, readInt);
                    break;
                case '\b':
                    r17 = SafeParcelReader.readInt(parcel, readInt);
                    break;
                case '\t':
                    r18 = SafeParcelReader.readInt(parcel, readInt);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readInt);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new MethodInvocation(r8, r9, r10, j, j2, str, str2, r17, r18);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int r1) {
        return new MethodInvocation[r1];
    }
}
