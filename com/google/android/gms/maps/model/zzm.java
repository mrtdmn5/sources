package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes3.dex */
public final class zzm implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        ArrayList arrayList = null;
        Cap cap = null;
        Cap cap2 = null;
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = null;
        float f = 0.0f;
        float f2 = 0.0f;
        int r8 = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        int r15 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 2:
                    arrayList = SafeParcelReader.createTypedList(parcel, readInt, LatLng.CREATOR);
                    break;
                case 3:
                    f = SafeParcelReader.readFloat(parcel, readInt);
                    break;
                case 4:
                    r8 = SafeParcelReader.readInt(parcel, readInt);
                    break;
                case 5:
                    f2 = SafeParcelReader.readFloat(parcel, readInt);
                    break;
                case 6:
                    z = SafeParcelReader.readBoolean(parcel, readInt);
                    break;
                case 7:
                    z2 = SafeParcelReader.readBoolean(parcel, readInt);
                    break;
                case '\b':
                    z3 = SafeParcelReader.readBoolean(parcel, readInt);
                    break;
                case '\t':
                    cap = (Cap) SafeParcelReader.createParcelable(parcel, readInt, Cap.CREATOR);
                    break;
                case '\n':
                    cap2 = (Cap) SafeParcelReader.createParcelable(parcel, readInt, Cap.CREATOR);
                    break;
                case 11:
                    r15 = SafeParcelReader.readInt(parcel, readInt);
                    break;
                case '\f':
                    arrayList2 = SafeParcelReader.createTypedList(parcel, readInt, PatternItem.CREATOR);
                    break;
                case '\r':
                    arrayList3 = SafeParcelReader.createTypedList(parcel, readInt, StyleSpan.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readInt);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new PolylineOptions(arrayList, f, r8, f2, z, z2, z3, cap, cap2, r15, arrayList2, arrayList3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int r1) {
        return new PolylineOptions[r1];
    }
}
