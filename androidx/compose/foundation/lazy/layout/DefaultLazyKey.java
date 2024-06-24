package androidx.compose.foundation.lazy.layout;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Lazy.android.kt */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class DefaultLazyKey implements Parcelable {
    public static final Parcelable.Creator<DefaultLazyKey> CREATOR = new DefaultLazyKey$Companion$CREATOR$1();
    public final int index;

    public DefaultLazyKey(int r1) {
        this.index = r1;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof DefaultLazyKey) && this.index == ((DefaultLazyKey) obj).index) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.index);
    }

    public final String toString() {
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(new StringBuilder("DefaultLazyKey(index="), this.index, ')');
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.index);
    }
}
