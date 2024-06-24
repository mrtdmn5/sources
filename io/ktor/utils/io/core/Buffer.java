package io.ktor.utils.io.core;

import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import androidx.appcompat.widget.SuggestionsAdapter$$ExternalSyntheticOutline0;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$$ExternalSyntheticOutline0;
import java.nio.ByteBuffer;

/* compiled from: Buffer.kt */
/* loaded from: classes3.dex */
public class Buffer {
    public final int capacity;
    public int limit;
    public final ByteBuffer memory;
    public int readPosition;
    public int startGap;
    public int writePosition;

    public Buffer(ByteBuffer byteBuffer) {
        this.memory = byteBuffer;
        this.limit = byteBuffer.limit();
        this.capacity = byteBuffer.limit();
    }

    public final void commitWritten(int r4) {
        int r0 = this.writePosition;
        int r1 = r0 + r4;
        if (r4 >= 0 && r1 <= this.limit) {
            this.writePosition = r1;
        } else {
            BufferKt.commitWrittenFailed(r4, this.limit - r0);
            throw null;
        }
    }

    public final void commitWrittenUntilIndex(int r4) {
        int r0 = this.limit;
        int r1 = this.writePosition;
        if (r4 >= r1) {
            if (r4 >= r0) {
                if (r4 == r0) {
                    this.writePosition = r4;
                    return;
                } else {
                    BufferKt.commitWrittenFailed(r4 - r1, r0 - r1);
                    throw null;
                }
            }
            this.writePosition = r4;
            return;
        }
        BufferKt.commitWrittenFailed(r4 - r1, r0 - r1);
        throw null;
    }

    public final void discardExact(int r4) {
        if (r4 == 0) {
            return;
        }
        int r0 = this.readPosition;
        int r1 = r0 + r4;
        if (r4 >= 0 && r1 <= this.writePosition) {
            this.readPosition = r1;
        } else {
            BufferKt.discardFailed(r4, this.writePosition - r0);
            throw null;
        }
    }

    public final void releaseStartGap$ktor_io(int r4) {
        boolean z;
        boolean z2 = true;
        if (r4 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (r4 > this.readPosition) {
                z2 = false;
            }
            if (z2) {
                this.readPosition = r4;
                if (this.startGap > r4) {
                    this.startGap = r4;
                    return;
                }
                return;
            }
            StringBuilder m = SuggestionsAdapter$$ExternalSyntheticOutline0.m("newReadPosition shouldn't be ahead of the read position: ", r4, " > ");
            m.append(this.readPosition);
            throw new IllegalArgumentException(m.toString().toString());
        }
        throw new IllegalArgumentException(SubMenuBuilder$$ExternalSyntheticOutline0.m("newReadPosition shouldn't be negative: ", r4).toString());
    }

    public final void reserveEndGap() {
        int r0 = this.capacity;
        int r1 = r0 - 8;
        int r2 = this.writePosition;
        if (r1 >= r2) {
            this.limit = r1;
            return;
        }
        if (r1 >= 0) {
            if (r1 >= this.startGap) {
                if (this.readPosition == r2) {
                    this.limit = r1;
                    this.readPosition = r1;
                    this.writePosition = r1;
                    return;
                } else {
                    throw new IllegalArgumentException("Unable to reserve end gap 8: there are already " + (this.writePosition - this.readPosition) + " content bytes at offset " + this.readPosition);
                }
            }
            throw new IllegalArgumentException(ConstraintWidget$$ExternalSyntheticOutline0.m(new StringBuilder("End gap 8 is too big: there are already "), this.startGap, " bytes reserved in the beginning"));
        }
        throw new IllegalArgumentException(SubMenuBuilder$$ExternalSyntheticOutline0.m("End gap 8 is too big: capacity is ", r0));
    }

    public final void resetForWrite(int r2) {
        int r0 = this.startGap;
        this.readPosition = r0;
        this.writePosition = r0;
        this.limit = r2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Buffer(");
        sb.append(this.writePosition - this.readPosition);
        sb.append(" used, ");
        sb.append(this.limit - this.writePosition);
        sb.append(" free, ");
        int r1 = this.startGap;
        int r2 = this.limit;
        int r3 = this.capacity;
        sb.append((r3 - r2) + r1);
        sb.append(" reserved of ");
        sb.append(r3);
        sb.append(')');
        return sb.toString();
    }
}
