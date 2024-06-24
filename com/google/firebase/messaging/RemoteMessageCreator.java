package com.google.firebase.messaging;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes3.dex */
public final class RemoteMessageCreator implements Parcelable.Creator<RemoteMessage> {
    @Override // android.os.Parcelable.Creator
    public final RemoteMessage createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        Bundle bundle = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            if (((char) readInt) != 2) {
                SafeParcelReader.skipUnknownField(parcel, readInt);
            } else {
                bundle = SafeParcelReader.createBundle(parcel, readInt);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new RemoteMessage(bundle);
    }

    @Override // android.os.Parcelable.Creator
    public final RemoteMessage[] newArray(int r1) {
        return new RemoteMessage[r1];
    }
}
