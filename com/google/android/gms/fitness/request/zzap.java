package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.Session;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-fitness@@21.1.0 */
/* loaded from: classes3.dex */
public final class zzap implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        Session session = null;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        IBinder iBinder = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c != 1) {
                if (c != 2) {
                    if (c != 3) {
                        if (c != 4) {
                            SafeParcelReader.skipUnknownField(parcel, readInt);
                        } else {
                            iBinder = SafeParcelReader.readIBinder(parcel, readInt);
                        }
                    } else {
                        arrayList2 = SafeParcelReader.createTypedList(parcel, readInt, DataPoint.CREATOR);
                    }
                } else {
                    arrayList = SafeParcelReader.createTypedList(parcel, readInt, DataSet.CREATOR);
                }
            } else {
                session = (Session) SafeParcelReader.createParcelable(parcel, readInt, Session.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new SessionInsertRequest(session, arrayList, arrayList2, iBinder);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int r1) {
        return new SessionInsertRequest[r1];
    }
}
