package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes3.dex */
public final class zzc implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        LatLng latLng = null;
        ArrayList arrayList = null;
        double d = 0.0d;
        float f = 0.0f;
        float f2 = 0.0f;
        int r12 = 0;
        int r13 = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 2:
                    latLng = (LatLng) SafeParcelReader.createParcelable(parcel, readInt, LatLng.CREATOR);
                    break;
                case 3:
                    SafeParcelReader.zzb(parcel, readInt, 8);
                    d = parcel.readDouble();
                    break;
                case 4:
                    f = SafeParcelReader.readFloat(parcel, readInt);
                    break;
                case 5:
                    r12 = SafeParcelReader.readInt(parcel, readInt);
                    break;
                case 6:
                    r13 = SafeParcelReader.readInt(parcel, readInt);
                    break;
                case 7:
                    f2 = SafeParcelReader.readFloat(parcel, readInt);
                    break;
                case '\b':
                    z = SafeParcelReader.readBoolean(parcel, readInt);
                    break;
                case '\t':
                    z2 = SafeParcelReader.readBoolean(parcel, readInt);
                    break;
                case '\n':
                    arrayList = SafeParcelReader.createTypedList(parcel, readInt, PatternItem.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readInt);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new CircleOptions(latLng, d, f, r12, r13, f2, z, z2, arrayList);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int r1) {
        return new CircleOptions[r1];
    }
}
