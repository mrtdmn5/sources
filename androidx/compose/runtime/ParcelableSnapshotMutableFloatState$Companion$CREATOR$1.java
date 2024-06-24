package androidx.compose.runtime;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ParcelableSnapshotMutableFloatState.kt */
/* loaded from: classes.dex */
public final class ParcelableSnapshotMutableFloatState$Companion$CREATOR$1 implements Parcelable.Creator<ParcelableSnapshotMutableFloatState> {
    @Override // android.os.Parcelable.Creator
    public final ParcelableSnapshotMutableFloatState createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        return new ParcelableSnapshotMutableFloatState(parcel.readFloat());
    }

    @Override // android.os.Parcelable.Creator
    public final ParcelableSnapshotMutableFloatState[] newArray(int r1) {
        return new ParcelableSnapshotMutableFloatState[r1];
    }
}
