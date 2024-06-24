package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
/* loaded from: classes3.dex */
public final class zzdc implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int r4 = 0;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        PendingIntent pendingIntent = null;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 1:
                    r4 = SafeParcelReader.readInt(parcel, readInt);
                    break;
                case 2:
                    iBinder = SafeParcelReader.readIBinder(parcel, readInt);
                    break;
                case 3:
                    iBinder2 = SafeParcelReader.readIBinder(parcel, readInt);
                    break;
                case 4:
                    pendingIntent = (PendingIntent) SafeParcelReader.createParcelable(parcel, readInt, PendingIntent.CREATOR);
                    break;
                case 5:
                    str = SafeParcelReader.createString(parcel, readInt);
                    break;
                case 6:
                    str2 = SafeParcelReader.createString(parcel, readInt);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readInt);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzdb(r4, iBinder, iBinder2, pendingIntent, str, str2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int r1) {
        return new zzdb[r1];
    }
}
