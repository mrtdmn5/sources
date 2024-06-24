package androidx.compose.runtime.snapshots;

/* compiled from: SnapshotStateList.kt */
/* loaded from: classes.dex */
public final class SnapshotStateListKt {
    public static final Object sync = new Object();

    public static final void access$validateRange(int r3, int r4) {
        boolean z;
        if (r3 >= 0 && r3 < r4) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return;
        }
        throw new IndexOutOfBoundsException("index (" + r3 + ") is out of bound of [0, " + r4 + ')');
    }
}
