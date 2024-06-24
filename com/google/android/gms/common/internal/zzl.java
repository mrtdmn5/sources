package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public final class zzl implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        RootTelemetryConfiguration rootTelemetryConfiguration = null;
        int[] r7 = null;
        int[] r9 = null;
        boolean z = false;
        boolean z2 = false;
        int r8 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 1:
                    rootTelemetryConfiguration = (RootTelemetryConfiguration) SafeParcelReader.createParcelable(parcel, readInt, RootTelemetryConfiguration.CREATOR);
                    break;
                case 2:
                    z = SafeParcelReader.readBoolean(parcel, readInt);
                    break;
                case 3:
                    z2 = SafeParcelReader.readBoolean(parcel, readInt);
                    break;
                case 4:
                    r7 = SafeParcelReader.createIntArray(parcel, readInt);
                    break;
                case 5:
                    r8 = SafeParcelReader.readInt(parcel, readInt);
                    break;
                case 6:
                    r9 = SafeParcelReader.createIntArray(parcel, readInt);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readInt);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new ConnectionTelemetryConfiguration(rootTelemetryConfiguration, z, z2, r7, r8, r9);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int r1) {
        return new ConnectionTelemetryConfiguration[r1];
    }
}
