package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzr implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        boolean z;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = "";
        String str2 = str;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        Boolean bool = null;
        ArrayList<String> arrayList = null;
        String str10 = null;
        String str11 = null;
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        boolean z2 = true;
        boolean z3 = true;
        boolean z4 = false;
        int r29 = 0;
        boolean z5 = false;
        long j6 = -2147483648L;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 2:
                    str3 = SafeParcelReader.createString(parcel, readInt);
                    break;
                case 3:
                    str4 = SafeParcelReader.createString(parcel, readInt);
                    break;
                case 4:
                    str5 = SafeParcelReader.createString(parcel, readInt);
                    break;
                case 5:
                    str6 = SafeParcelReader.createString(parcel, readInt);
                    break;
                case 6:
                    j = SafeParcelReader.readLong(parcel, readInt);
                    break;
                case 7:
                    j2 = SafeParcelReader.readLong(parcel, readInt);
                    break;
                case '\b':
                    str7 = SafeParcelReader.createString(parcel, readInt);
                    break;
                case '\t':
                    z2 = SafeParcelReader.readBoolean(parcel, readInt);
                    break;
                case '\n':
                    z4 = SafeParcelReader.readBoolean(parcel, readInt);
                    break;
                case 11:
                    j6 = SafeParcelReader.readLong(parcel, readInt);
                    break;
                case '\f':
                    str8 = SafeParcelReader.createString(parcel, readInt);
                    break;
                case '\r':
                    j3 = SafeParcelReader.readLong(parcel, readInt);
                    break;
                case 14:
                    j4 = SafeParcelReader.readLong(parcel, readInt);
                    break;
                case 15:
                    r29 = SafeParcelReader.readInt(parcel, readInt);
                    break;
                case 16:
                    z3 = SafeParcelReader.readBoolean(parcel, readInt);
                    break;
                case 17:
                case 20:
                default:
                    SafeParcelReader.skipUnknownField(parcel, readInt);
                    break;
                case 18:
                    z5 = SafeParcelReader.readBoolean(parcel, readInt);
                    break;
                case 19:
                    str9 = SafeParcelReader.createString(parcel, readInt);
                    break;
                case 21:
                    int readSize = SafeParcelReader.readSize(parcel, readInt);
                    if (readSize == 0) {
                        bool = null;
                        break;
                    } else {
                        SafeParcelReader.zza(parcel, readSize, 4);
                        if (parcel.readInt() != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        bool = Boolean.valueOf(z);
                        break;
                    }
                case 22:
                    j5 = SafeParcelReader.readLong(parcel, readInt);
                    break;
                case 23:
                    int readSize2 = SafeParcelReader.readSize(parcel, readInt);
                    int dataPosition = parcel.dataPosition();
                    if (readSize2 == 0) {
                        arrayList = null;
                        break;
                    } else {
                        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
                        parcel.setDataPosition(dataPosition + readSize2);
                        arrayList = createStringArrayList;
                        break;
                    }
                case 24:
                    str10 = SafeParcelReader.createString(parcel, readInt);
                    break;
                case 25:
                    str = SafeParcelReader.createString(parcel, readInt);
                    break;
                case 26:
                    str2 = SafeParcelReader.createString(parcel, readInt);
                    break;
                case 27:
                    str11 = SafeParcelReader.createString(parcel, readInt);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzq(str3, str4, str5, str6, j, j2, str7, z2, z4, j6, str8, j3, j4, r29, z3, z5, str9, bool, j5, arrayList, str10, str, str2, str11);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int r1) {
        return new zzq[r1];
    }
}
