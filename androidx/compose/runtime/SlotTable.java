package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: SlotTable.kt */
/* loaded from: classes.dex */
public final class SlotTable implements Iterable<Object>, KMappedMarker {
    public int groupsSize;
    public int readers;
    public int slotsSize;
    public int version;
    public boolean writer;
    public int[] groups = new int[0];
    public Object[] slots = new Object[0];
    public ArrayList<Anchor> anchors = new ArrayList<>();

    public final Anchor anchor() {
        boolean z;
        if (!this.writer) {
            int r0 = this.groupsSize;
            if (r0 > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                ArrayList<Anchor> arrayList = this.anchors;
                int search = SlotTableKt.search(arrayList, 0, r0);
                if (search < 0) {
                    Anchor anchor = new Anchor(0);
                    arrayList.add(-(search + 1), anchor);
                    return anchor;
                }
                Anchor anchor2 = arrayList.get(search);
                Intrinsics.checkNotNullExpressionValue(anchor2, "get(location)");
                return anchor2;
            }
            throw new IllegalArgumentException("Parameter index is out of range".toString());
        }
        ComposerKt.composeRuntimeError("use active SlotWriter to create an anchor location instead ".toString());
        throw null;
    }

    public final int anchorIndex(Anchor anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        boolean z = true;
        if (!this.writer) {
            int r3 = anchor.location;
            if (r3 == Integer.MIN_VALUE) {
                z = false;
            }
            if (z) {
                return r3;
            }
            throw new IllegalArgumentException("Anchor refers to a group that was removed".toString());
        }
        ComposerKt.composeRuntimeError("Use active SlotWriter to determine anchor location instead".toString());
        throw null;
    }

    public final boolean groupContainsAnchor(int r5, Anchor anchor) {
        boolean z;
        boolean z2;
        if (!this.writer) {
            if (r5 >= 0 && r5 < this.groupsSize) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                if (ownsAnchor(anchor)) {
                    int access$groupSize = SlotTableKt.access$groupSize(this.groups, r5) + r5;
                    int r6 = anchor.location;
                    if (r5 <= r6 && r6 < access$groupSize) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        return true;
                    }
                }
                return false;
            }
            ComposerKt.composeRuntimeError("Invalid group index".toString());
            throw null;
        }
        ComposerKt.composeRuntimeError("Writer is active".toString());
        throw null;
    }

    @Override // java.lang.Iterable
    public final Iterator<Object> iterator() {
        return new GroupIterator(0, this.groupsSize, this);
    }

    public final SlotReader openReader() {
        if (!this.writer) {
            this.readers++;
            return new SlotReader(this);
        }
        throw new IllegalStateException("Cannot read while a writer is pending".toString());
    }

    public final SlotWriter openWriter() {
        boolean z;
        if (!this.writer) {
            if (this.readers <= 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this.writer = true;
                this.version++;
                return new SlotWriter(this);
            }
            ComposerKt.composeRuntimeError("Cannot start a writer when a reader is pending".toString());
            throw null;
        }
        ComposerKt.composeRuntimeError("Cannot start a writer when another writer is pending".toString());
        throw null;
    }

    public final boolean ownsAnchor(Anchor anchor) {
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        int r0 = anchor.location;
        if (r0 != Integer.MIN_VALUE) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            int search = SlotTableKt.search(this.anchors, r0, this.groupsSize);
            if (search >= 0 && Intrinsics.areEqual(this.anchors.get(search), anchor)) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }
}
