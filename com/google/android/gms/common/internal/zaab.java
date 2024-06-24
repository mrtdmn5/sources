package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public final class zaab implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int r1 = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c != 1) {
                if (c != 2) {
                    SafeParcelReader.skipUnknownField(parcel, readInt);
                } else {
                    arrayList = SafeParcelReader.createTypedList(parcel, readInt, MethodInvocation.CREATOR);
                }
            } else {
                r1 = SafeParcelReader.readInt(parcel, readInt);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new TelemetryData(r1, arrayList);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int r1) {
        return new TelemetryData[r1];
    }
}
