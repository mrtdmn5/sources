package androidx.compose.runtime;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ParcelableSnapshotMutableIntState.kt */
/* loaded from: classes.dex */
public final class ParcelableSnapshotMutableIntState$Companion$CREATOR$1 implements Parcelable.Creator<ParcelableSnapshotMutableIntState> {
    @Override // android.os.Parcelable.Creator
    public final ParcelableSnapshotMutableIntState createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        return new ParcelableSnapshotMutableIntState(parcel.readInt());
    }

    @Override // android.os.Parcelable.Creator
    public final ParcelableSnapshotMutableIntState[] newArray(int r1) {
        return new ParcelableSnapshotMutableIntState[r1];
    }
}
