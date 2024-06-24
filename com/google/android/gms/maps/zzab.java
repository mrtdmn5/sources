package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLngBounds;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes3.dex */
public final class zzab implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        byte b = -1;
        byte b2 = -1;
        byte b3 = -1;
        byte b4 = -1;
        byte b5 = -1;
        byte b6 = -1;
        byte b7 = -1;
        byte b8 = -1;
        byte b9 = -1;
        byte b10 = -1;
        byte b11 = -1;
        byte b12 = -1;
        int r8 = 0;
        CameraPosition cameraPosition = null;
        Float f = null;
        Float f2 = null;
        LatLngBounds latLngBounds = null;
        Integer num = null;
        String str = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 2:
                    b = SafeParcelReader.readByte(parcel, readInt);
                    break;
                case 3:
                    b2 = SafeParcelReader.readByte(parcel, readInt);
                    break;
                case 4:
                    r8 = SafeParcelReader.readInt(parcel, readInt);
                    break;
                case 5:
                    cameraPosition = (CameraPosition) SafeParcelReader.createParcelable(parcel, readInt, CameraPosition.CREATOR);
                    break;
                case 6:
                    b3 = SafeParcelReader.readByte(parcel, readInt);
                    break;
                case 7:
                    b4 = SafeParcelReader.readByte(parcel, readInt);
                    break;
                case '\b':
                    b5 = SafeParcelReader.readByte(parcel, readInt);
                    break;
                case '\t':
                    b6 = SafeParcelReader.readByte(parcel, readInt);
                    break;
                case '\n':
                    b7 = SafeParcelReader.readByte(parcel, readInt);
                    break;
                case 11:
                    b8 = SafeParcelReader.readByte(parcel, readInt);
                    break;
                case '\f':
                    b9 = SafeParcelReader.readByte(parcel, readInt);
                    break;
                case '\r':
                default:
                    SafeParcelReader.skipUnknownField(parcel, readInt);
                    break;
                case 14:
                    b10 = SafeParcelReader.readByte(parcel, readInt);
                    break;
                case 15:
                    b11 = SafeParcelReader.readByte(parcel, readInt);
                    break;
                case 16:
                    f = SafeParcelReader.readFloatObject(parcel, readInt);
                    break;
                case 17:
                    f2 = SafeParcelReader.readFloatObject(parcel, readInt);
                    break;
                case 18:
                    latLngBounds = (LatLngBounds) SafeParcelReader.createParcelable(parcel, readInt, LatLngBounds.CREATOR);
                    break;
                case 19:
                    b12 = SafeParcelReader.readByte(parcel, readInt);
                    break;
                case 20:
                    int readSize = SafeParcelReader.readSize(parcel, readInt);
                    if (readSize == 0) {
                        num = null;
                        break;
                    } else {
                        SafeParcelReader.zza(parcel, readSize, 4);
                        num = Integer.valueOf(parcel.readInt());
                        break;
                    }
                case 21:
                    str = SafeParcelReader.createString(parcel, readInt);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new GoogleMapOptions(b, b2, r8, cameraPosition, b3, b4, b5, b6, b7, b8, b9, b10, b11, f, f2, latLngBounds, b12, num, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int r1) {
        return new GoogleMapOptions[r1];
    }
}
