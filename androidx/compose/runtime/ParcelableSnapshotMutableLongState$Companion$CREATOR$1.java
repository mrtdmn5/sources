package androidx.compose.runtime;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ParcelableSnapshotMutableLongState.kt */
/* loaded from: classes.dex */
public final class ParcelableSnapshotMutableLongState$Companion$CREATOR$1 implements Parcelable.Creator<ParcelableSnapshotMutableLongState> {
    @Override // android.os.Parcelable.Creator
    public final ParcelableSnapshotMutableLongState createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        return new ParcelableSnapshotMutableLongState(parcel.readLong());
    }

    @Override // android.os.Parcelable.Creator
    public final ParcelableSnapshotMutableLongState[] newArray(int r1) {
        return new ParcelableSnapshotMutableLongState[r1];
    }
}
