package androidx.compose.runtime;

import androidx.compose.runtime.DerivedSnapshotState;

/* compiled from: DerivedState.kt */
/* loaded from: classes.dex */
public interface DerivedState<T> extends State<T> {
    DerivedSnapshotState.ResultRecord getCurrentRecord();

    SnapshotMutationPolicy<T> getPolicy();
}
