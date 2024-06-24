package androidx.compose.runtime;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ParcelableSnapshotMutableState.kt */
/* loaded from: classes.dex */
public final class ParcelableSnapshotMutableState$Companion$CREATOR$1 implements Parcelable.ClassLoaderCreator<ParcelableSnapshotMutableState<Object>> {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        return createFromParcel2(parcel, (ClassLoader) null);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int r1) {
        return new ParcelableSnapshotMutableState[r1];
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    public final /* bridge */ /* synthetic */ ParcelableSnapshotMutableState<Object> createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return createFromParcel2(parcel, classLoader);
    }

    /* renamed from: createFromParcel, reason: avoid collision after fix types in other method */
    public static ParcelableSnapshotMutableState createFromParcel2(Parcel parcel, ClassLoader classLoader) {
        SnapshotMutationPolicy snapshotMutationPolicy;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        if (classLoader == null) {
            classLoader = ParcelableSnapshotMutableState$Companion$CREATOR$1.class.getClassLoader();
        }
        Object readValue = parcel.readValue(classLoader);
        int readInt = parcel.readInt();
        if (readInt == 0) {
            snapshotMutationPolicy = NeverEqualPolicy.INSTANCE;
        } else if (readInt == 1) {
            snapshotMutationPolicy = StructuralEqualityPolicy.INSTANCE;
        } else if (readInt == 2) {
            snapshotMutationPolicy = ReferentialEqualityPolicy.INSTANCE;
        } else {
            throw new IllegalStateException(ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m("Unsupported MutableState policy ", readInt, " was restored"));
        }
        return new ParcelableSnapshotMutableState(readValue, snapshotMutationPolicy);
    }
}
