package io.ktor.utils.io.core.internal;

import io.ktor.utils.io.core.Input;
import io.ktor.utils.io.core.Output;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Unsafe.kt */
/* loaded from: classes3.dex */
public final class UnsafeKt {
    public static final byte[] EmptyByteArray = new byte[0];

    public static final void completeReadHead(Input input, ChunkBuffer current) {
        boolean z;
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(current, "current");
        if (current == input) {
            return;
        }
        int r0 = current.writePosition;
        int r1 = current.readPosition;
        if (r0 > r1) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            input.ensureNext(current);
            return;
        }
        int r02 = current.limit;
        int r2 = current.capacity;
        if (r2 - r02 < 8) {
            ChunkBuffer next = current.getNext();
            if (next == null) {
                input.fixGapAfterReadFallback(current);
                return;
            }
            int r12 = current.writePosition - current.readPosition;
            int min = Math.min(r12, 8 - (r2 - current.limit));
            if (next.startGap < min) {
                input.fixGapAfterReadFallback(current);
                return;
            }
            next.releaseStartGap$ktor_io(next.readPosition - min);
            if (r12 > min) {
                current.limit = r2;
                input.headEndExclusive = current.writePosition;
                input.setTailRemaining(input.tailRemaining + min);
                return;
            } else {
                input.set_head(next);
                input.setTailRemaining(input.tailRemaining - ((next.writePosition - next.readPosition) - min));
                current.cleanNext();
                current.release(input.pool);
                return;
            }
        }
        input.headPosition = r1;
    }

    public static final ChunkBuffer prepareReadFirstHead(Input input, int r2) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        return input.prepareReadLoop(r2, input.getHead());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final ChunkBuffer prepareReadNextHead(Input input, ChunkBuffer chunkBuffer) {
        boolean z;
        Intrinsics.checkNotNullParameter(input, "<this>");
        if (chunkBuffer == input) {
            if (input.headPosition == input.headEndExclusive && input.tailRemaining == 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return (ChunkBuffer) input;
            }
            return null;
        }
        return input.ensureNext(chunkBuffer);
    }

    public static final ChunkBuffer prepareWriteHead(Output output, int r2, ChunkBuffer chunkBuffer) {
        ChunkBuffer chunkBuffer2;
        Intrinsics.checkNotNullParameter(output, "<this>");
        if (chunkBuffer != null) {
            output.afterHeadWrite();
        }
        int r3 = output.tailEndExclusive;
        int r0 = output.tailPosition;
        if (r3 - r0 >= r2 && (chunkBuffer2 = output._tail) != null) {
            chunkBuffer2.commitWrittenUntilIndex(r0);
            return chunkBuffer2;
        }
        ChunkBuffer borrow = output.pool.borrow();
        borrow.reserveEndGap();
        output.appendSingleChunk$ktor_io(borrow);
        return borrow;
    }
}
