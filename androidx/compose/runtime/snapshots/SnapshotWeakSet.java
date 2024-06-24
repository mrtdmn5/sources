package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.WeakReference;

/* compiled from: SnapshotWeakSet.kt */
/* loaded from: classes.dex */
public final class SnapshotWeakSet<T> {
    public int size;
    public int[] hashes = new int[16];
    public WeakReference<T>[] values = new WeakReference[16];
}
