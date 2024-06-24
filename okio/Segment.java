package okio;

import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: Segment.kt */
/* loaded from: classes4.dex */
public final class Segment {
    public final byte[] data;
    public int limit;
    public Segment next;
    public final boolean owner;
    public int pos;
    public Segment prev;
    public boolean shared;

    public Segment() {
        this.data = new byte[DfuBaseService.ERROR_REMOTE_MASK];
        this.owner = true;
        this.shared = false;
    }

    public final Segment pop() {
        Segment segment = this.next;
        if (segment == this) {
            segment = null;
        }
        Segment segment2 = this.prev;
        Intrinsics.checkNotNull(segment2);
        segment2.next = this.next;
        Segment segment3 = this.next;
        Intrinsics.checkNotNull(segment3);
        segment3.prev = this.prev;
        this.next = null;
        this.prev = null;
        return segment;
    }

    public final void push(Segment segment) {
        segment.prev = this;
        segment.next = this.next;
        Segment segment2 = this.next;
        Intrinsics.checkNotNull(segment2);
        segment2.prev = segment;
        this.next = segment;
    }

    public final Segment sharedCopy() {
        this.shared = true;
        return new Segment(this.data, this.pos, this.limit, true);
    }

    public final void writeTo(Segment segment, int r7) {
        if (segment.owner) {
            int r0 = segment.limit;
            int r1 = r0 + r7;
            byte[] bArr = segment.data;
            if (r1 > 8192) {
                if (!segment.shared) {
                    int r4 = segment.pos;
                    if (r1 - r4 <= 8192) {
                        ArraysKt___ArraysJvmKt.copyInto(0, bArr, r4, bArr, r0);
                        segment.limit -= segment.pos;
                        segment.pos = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            int r02 = segment.limit;
            int r12 = this.pos;
            ArraysKt___ArraysJvmKt.copyInto(r02, this.data, r12, bArr, r12 + r7);
            segment.limit += r7;
            this.pos += r7;
            return;
        }
        throw new IllegalStateException("only owner can write".toString());
    }

    public Segment(byte[] data, int r3, int r4, boolean z) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
        this.pos = r3;
        this.limit = r4;
        this.shared = z;
        this.owner = false;
    }
}
