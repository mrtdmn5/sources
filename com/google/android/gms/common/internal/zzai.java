package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public final class zzai implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c != 1) {
                if (c != 2) {
                    if (c != 3) {
                        if (c != 4) {
                            if (c != 5) {
                                SafeParcelReader.skipUnknownField(parcel, readInt);
                            } else {
                                r5 = SafeParcelReader.readInt(parcel, readInt);
                            }
                        } else {
                            r4 = SafeParcelReader.readInt(parcel, readInt);
                        }
                    } else {
                        z2 = SafeParcelReader.readBoolean(parcel, readInt);
                    }
                } else {
                    z = SafeParcelReader.readBoolean(parcel, readInt);
                }
            } else {
                r3 = SafeParcelReader.readInt(parcel, readInt);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new RootTelemetryConfiguration(r3, r4, r5, z, z2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int r1) {
        return new RootTelemetryConfiguration[r1];
    }
}
