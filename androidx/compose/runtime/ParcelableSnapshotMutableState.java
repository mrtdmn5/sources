package androidx.compose.runtime;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ParcelableSnapshotMutableState.kt */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class ParcelableSnapshotMutableState<T> extends SnapshotMutableStateImpl<T> implements Parcelable {
    public static final Parcelable.Creator<ParcelableSnapshotMutableState<Object>> CREATOR = new ParcelableSnapshotMutableState$Companion$CREATOR$1();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ParcelableSnapshotMutableState(T t, SnapshotMutationPolicy<T> policy) {
        super(t, policy);
        Intrinsics.checkNotNullParameter(policy, "policy");
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r3) {
        int r32;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeValue(getValue());
        NeverEqualPolicy neverEqualPolicy = NeverEqualPolicy.INSTANCE;
        SnapshotMutationPolicy<T> snapshotMutationPolicy = this.policy;
        if (Intrinsics.areEqual(snapshotMutationPolicy, neverEqualPolicy)) {
            r32 = 0;
        } else if (Intrinsics.areEqual(snapshotMutationPolicy, StructuralEqualityPolicy.INSTANCE)) {
            r32 = 1;
        } else if (Intrinsics.areEqual(snapshotMutationPolicy, ReferentialEqualityPolicy.INSTANCE)) {
            r32 = 2;
        } else {
            throw new IllegalStateException("Only known types of MutableState's SnapshotMutationPolicy are supported");
        }
        parcel.writeInt(r32);
    }
}
