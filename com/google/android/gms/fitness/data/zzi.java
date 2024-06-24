package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-fitness@@21.1.0 */
/* loaded from: classes3.dex */
public final class zzi implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        ArrayList arrayList = new ArrayList();
        int r2 = 0;
        DataSource dataSource = null;
        ArrayList arrayList2 = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c != 1) {
                if (c != 1000) {
                    if (c != 3) {
                        if (c != 4) {
                            SafeParcelReader.skipUnknownField(parcel, readInt);
                        } else {
                            arrayList2 = SafeParcelReader.createTypedList(parcel, readInt, DataSource.CREATOR);
                        }
                    } else {
                        ClassLoader classLoader = zzi.class.getClassLoader();
                        int readSize = SafeParcelReader.readSize(parcel, readInt);
                        int dataPosition = parcel.dataPosition();
                        if (readSize != 0) {
                            parcel.readList(arrayList, classLoader);
                            parcel.setDataPosition(dataPosition + readSize);
                        }
                    }
                } else {
                    r2 = SafeParcelReader.readInt(parcel, readInt);
                }
            } else {
                dataSource = (DataSource) SafeParcelReader.createParcelable(parcel, readInt, DataSource.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new DataSet(r2, dataSource, arrayList, arrayList2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int r1) {
        return new DataSet[r1];
    }
}
