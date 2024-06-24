package com.google.android.gms.internal.base;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public final class zac {
    public static final /* synthetic */ int $r8$clinit = 0;

    static {
        zac.class.getClassLoader();
    }

    public static Parcelable zaa(Parcel parcel, Parcelable.Creator creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return (Parcelable) creator.createFromParcel(parcel);
    }

    public static void zab(Parcel parcel) {
        int dataAvail = parcel.dataAvail();
        if (dataAvail <= 0) {
        } else {
            throw new BadParcelableException(SubMenuBuilder$$ExternalSyntheticOutline0.m("Parcel data not fully consumed, unread size: ", dataAvail));
        }
    }
}
