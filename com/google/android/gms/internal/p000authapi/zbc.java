package com.google.android.gms.internal.p000authapi;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;

/* compiled from: com.google.android.gms:play-services-auth@@20.4.0 */
/* loaded from: classes3.dex */
public final class zbc {
    public static final /* synthetic */ int $r8$clinit = 0;

    static {
        zbc.class.getClassLoader();
    }

    public static Parcelable zba(Parcel parcel, Parcelable.Creator creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return (Parcelable) creator.createFromParcel(parcel);
    }

    public static void zbb(Parcel parcel) {
        int dataAvail = parcel.dataAvail();
        if (dataAvail <= 0) {
        } else {
            throw new BadParcelableException(SubMenuBuilder$$ExternalSyntheticOutline0.m("Parcel data not fully consumed, unread size: ", dataAvail));
        }
    }
}
