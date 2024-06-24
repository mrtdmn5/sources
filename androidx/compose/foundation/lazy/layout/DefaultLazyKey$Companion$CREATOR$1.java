package androidx.compose.foundation.lazy.layout;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Lazy.android.kt */
/* loaded from: classes.dex */
public final class DefaultLazyKey$Companion$CREATOR$1 implements Parcelable.Creator<DefaultLazyKey> {
    @Override // android.os.Parcelable.Creator
    public final DefaultLazyKey createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        return new DefaultLazyKey(parcel.readInt());
    }

    @Override // android.os.Parcelable.Creator
    public final DefaultLazyKey[] newArray(int r1) {
        return new DefaultLazyKey[r1];
    }
}
