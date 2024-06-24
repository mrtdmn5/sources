package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes3.dex */
public final class zzi implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        LatLng latLng = null;
        String str = null;
        String str2 = null;
        IBinder iBinder = null;
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        float f6 = 0.5f;
        float f7 = 1.0f;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 2:
                    latLng = (LatLng) SafeParcelReader.createParcelable(parcel, readInt, LatLng.CREATOR);
                    break;
                case 3:
                    str = SafeParcelReader.createString(parcel, readInt);
                    break;
                case 4:
                    str2 = SafeParcelReader.createString(parcel, readInt);
                    break;
                case 5:
                    iBinder = SafeParcelReader.readIBinder(parcel, readInt);
                    break;
                case 6:
                    f = SafeParcelReader.readFloat(parcel, readInt);
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
                    z3 = SafeParcelReader.readBoolean(parcel, readInt);
                    break;
                case 11:
                    f3 = SafeParcelReader.readFloat(parcel, readInt);
                    break;
                case '\f':
                    f6 = SafeParcelReader.readFloat(parcel, readInt);
                    break;
                case '\r':
                    f4 = SafeParcelReader.readFloat(parcel, readInt);
                    break;
                case 14:
                    f7 = SafeParcelReader.readFloat(parcel, readInt);
                    break;
                case 15:
                    f5 = SafeParcelReader.readFloat(parcel, readInt);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readInt);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new MarkerOptions(latLng, str, str2, iBinder, f, f2, z, z2, z3, f3, f6, f4, f7, f5);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int r1) {
        return new MarkerOptions[r1];
    }
}
