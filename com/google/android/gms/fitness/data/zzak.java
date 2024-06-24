package com.google.android.gms.fitness.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-fitness@@21.1.0 */
/* loaded from: classes3.dex */
public final class zzak implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int r5 = 0;
        boolean z = false;
        float f = 0.0f;
        String str = null;
        Bundle bundle = null;
        int[] r10 = null;
        float[] fArr = null;
        byte[] bArr = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 1:
                    r5 = SafeParcelReader.readInt(parcel, readInt);
                    break;
                case 2:
                    z = SafeParcelReader.readBoolean(parcel, readInt);
                    break;
                case 3:
                    f = SafeParcelReader.readFloat(parcel, readInt);
                    break;
                case 4:
                    str = SafeParcelReader.createString(parcel, readInt);
                    break;
                case 5:
                    bundle = SafeParcelReader.createBundle(parcel, readInt);
                    break;
                case 6:
                    r10 = SafeParcelReader.createIntArray(parcel, readInt);
                    break;
                case 7:
                    int readSize = SafeParcelReader.readSize(parcel, readInt);
                    int dataPosition = parcel.dataPosition();
                    if (readSize == 0) {
                        fArr = null;
                        break;
                    } else {
                        float[] createFloatArray = parcel.createFloatArray();
                        parcel.setDataPosition(dataPosition + readSize);
                        fArr = createFloatArray;
                        break;
                    }
                case '\b':
                    int readSize2 = SafeParcelReader.readSize(parcel, readInt);
                    int dataPosition2 = parcel.dataPosition();
                    if (readSize2 == 0) {
                        bArr = null;
                        break;
                    } else {
                        byte[] createByteArray = parcel.createByteArray();
                        parcel.setDataPosition(dataPosition2 + readSize2);
                        bArr = createByteArray;
                        break;
                    }
                default:
                    SafeParcelReader.skipUnknownField(parcel, readInt);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new Value(r5, z, f, str, bundle, r10, fArr, bArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int r1) {
        return new Value[r1];
    }
}
