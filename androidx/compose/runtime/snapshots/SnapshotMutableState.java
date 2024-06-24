package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;

/* compiled from: SnapshotMutableState.kt */
/* loaded from: classes.dex */
public interface SnapshotMutableState<T> extends MutableState<T> {
    SnapshotMutationPolicy<T> getPolicy();
}
