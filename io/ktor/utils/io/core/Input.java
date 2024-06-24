package io.ktor.utils.io.core;

import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import androidx.appcompat.widget.SuggestionsAdapter$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HeightInLinesModifierKt$$ExternalSyntheticOutline0;
import androidx.compose.runtime.ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0;
import androidx.profileinstaller.FileSectionType$$ExternalSyntheticOutline0;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.Closeable;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Input.kt */
/* loaded from: classes3.dex */
public abstract class Input implements Closeable {
    public ChunkBuffer _head;
    public int headEndExclusive;
    public ByteBuffer headMemory;
    public int headPosition;
    public boolean noMoreChunksAvailable;
    public final ObjectPool<ChunkBuffer> pool;
    public long tailRemaining;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Input() {
        /*
            r4 = this;
            io.ktor.utils.io.core.internal.ChunkBuffer r0 = io.ktor.utils.io.core.internal.ChunkBuffer.Empty
            long r1 = io.ktor.utils.io.core.BuffersKt.remainingAll(r0)
            io.ktor.utils.io.core.internal.ChunkBuffer$Companion$Pool$1 r3 = io.ktor.utils.io.core.internal.ChunkBuffer.Pool
            r4.<init>(r0, r1, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.Input.<init>():void");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        release();
        if (!this.noMoreChunksAvailable) {
            this.noMoreChunksAvailable = true;
        }
        closeSource();
    }

    public abstract void closeSource();

    public final void discardExact(int r7) {
        boolean z;
        int r0 = 0;
        if (r7 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            int r1 = r7;
            while (r1 != 0) {
                ChunkBuffer prepareRead = prepareRead();
                if (prepareRead == null) {
                    break;
                }
                int min = Math.min(prepareRead.writePosition - prepareRead.readPosition, r1);
                prepareRead.discardExact(min);
                this.headPosition += min;
                if (prepareRead.writePosition - prepareRead.readPosition == 0) {
                    releaseHead$ktor_io(prepareRead);
                }
                r1 -= min;
                r0 += min;
            }
            if (r0 == r7) {
                return;
            } else {
                throw new EOFException(ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m("Unable to discard ", r7, " bytes due to end of packet"));
            }
        }
        throw new IllegalArgumentException(SubMenuBuilder$$ExternalSyntheticOutline0.m("Negative discard is not allowed: ", r7).toString());
    }

    public final ChunkBuffer doFill() {
        if (this.noMoreChunksAvailable) {
            return null;
        }
        ChunkBuffer fill = fill();
        boolean z = true;
        if (fill == null) {
            this.noMoreChunksAvailable = true;
            return null;
        }
        ChunkBuffer findTail = BuffersKt.findTail(this._head);
        if (findTail == ChunkBuffer.Empty) {
            set_head(fill);
            long j = 0;
            if (this.tailRemaining != 0) {
                z = false;
            }
            if (z) {
                ChunkBuffer next = fill.getNext();
                if (next != null) {
                    j = BuffersKt.remainingAll(next);
                }
                setTailRemaining(j);
            } else {
                throw new IllegalStateException("It should be no tail remaining bytes if current tail is EmptyBuffer");
            }
        } else {
            findTail.setNext(fill);
            setTailRemaining(BuffersKt.remainingAll(fill) + this.tailRemaining);
        }
        return fill;
    }

    public final ChunkBuffer ensureNext(ChunkBuffer current) {
        boolean z;
        Intrinsics.checkNotNullParameter(current, "current");
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = ChunkBuffer.nextRef$FU;
        ChunkBuffer chunkBuffer = ChunkBuffer.Empty;
        while (current != chunkBuffer) {
            ChunkBuffer cleanNext = current.cleanNext();
            current.release(this.pool);
            if (cleanNext == null) {
                set_head(chunkBuffer);
                setTailRemaining(0L);
                current = chunkBuffer;
            } else {
                if (cleanNext.writePosition > cleanNext.readPosition) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    set_head(cleanNext);
                    setTailRemaining(this.tailRemaining - (cleanNext.writePosition - cleanNext.readPosition));
                    return cleanNext;
                }
                current = cleanNext;
            }
        }
        return doFill();
    }

    public ChunkBuffer fill() {
        ObjectPool<ChunkBuffer> objectPool = this.pool;
        ChunkBuffer borrow = objectPool.borrow();
        try {
            borrow.reserveEndGap();
            mo1657fill62zg_DM(borrow.memory);
            boolean z = true;
            this.noMoreChunksAvailable = true;
            if (borrow.writePosition <= borrow.readPosition) {
                z = false;
            }
            if (!z) {
                borrow.release(objectPool);
                return null;
            }
            borrow.commitWritten(0);
            return borrow;
        } catch (Throwable th) {
            borrow.release(objectPool);
            throw th;
        }
    }

    /* renamed from: fill-62zg_DM */
    public abstract void mo1657fill62zg_DM(ByteBuffer byteBuffer);

    public final void fixGapAfterReadFallback(ChunkBuffer chunkBuffer) {
        if (this.noMoreChunksAvailable && chunkBuffer.getNext() == null) {
            this.headPosition = chunkBuffer.readPosition;
            this.headEndExclusive = chunkBuffer.writePosition;
            setTailRemaining(0L);
            return;
        }
        int r0 = chunkBuffer.writePosition - chunkBuffer.readPosition;
        int min = Math.min(r0, 8 - (chunkBuffer.capacity - chunkBuffer.limit));
        ObjectPool<ChunkBuffer> objectPool = this.pool;
        if (r0 > min) {
            ChunkBuffer borrow = objectPool.borrow();
            ChunkBuffer borrow2 = objectPool.borrow();
            borrow.reserveEndGap();
            borrow2.reserveEndGap();
            borrow.setNext(borrow2);
            borrow2.setNext(chunkBuffer.cleanNext());
            BufferAppendKt.writeBufferAppend(borrow, chunkBuffer, r0 - min);
            BufferAppendKt.writeBufferAppend(borrow2, chunkBuffer, min);
            set_head(borrow);
            setTailRemaining(BuffersKt.remainingAll(borrow2));
        } else {
            ChunkBuffer borrow3 = objectPool.borrow();
            borrow3.reserveEndGap();
            borrow3.setNext(chunkBuffer.cleanNext());
            BufferAppendKt.writeBufferAppend(borrow3, chunkBuffer, r0);
            set_head(borrow3);
        }
        chunkBuffer.release(objectPool);
    }

    public final boolean getEndOfInput() {
        if (this.headEndExclusive - this.headPosition == 0 && this.tailRemaining == 0 && (this.noMoreChunksAvailable || doFill() == null)) {
            return true;
        }
        return false;
    }

    public final ChunkBuffer getHead() {
        ChunkBuffer chunkBuffer = this._head;
        int r1 = this.headPosition;
        if (r1 >= 0 && r1 <= chunkBuffer.writePosition) {
            if (chunkBuffer.readPosition != r1) {
                chunkBuffer.readPosition = r1;
            }
            return chunkBuffer;
        }
        int r2 = chunkBuffer.readPosition;
        BufferKt.discardFailed(r1 - r2, chunkBuffer.writePosition - r2);
        throw null;
    }

    public final long getRemaining() {
        return (this.headEndExclusive - this.headPosition) + this.tailRemaining;
    }

    public final ChunkBuffer prepareRead() {
        ChunkBuffer head = getHead();
        if (this.headEndExclusive - this.headPosition >= 1) {
            return head;
        }
        return prepareReadLoop(1, head);
    }

    public final ChunkBuffer prepareReadLoop(int r9, ChunkBuffer chunkBuffer) {
        boolean z;
        while (true) {
            int r0 = this.headEndExclusive - this.headPosition;
            if (r0 >= r9) {
                return chunkBuffer;
            }
            ChunkBuffer next = chunkBuffer.getNext();
            if (next == null && (next = doFill()) == null) {
                return null;
            }
            if (r0 == 0) {
                if (chunkBuffer != ChunkBuffer.Empty) {
                    releaseHead$ktor_io(chunkBuffer);
                }
                chunkBuffer = next;
            } else {
                int writeBufferAppend = BufferAppendKt.writeBufferAppend(chunkBuffer, next, r9 - r0);
                this.headEndExclusive = chunkBuffer.writePosition;
                setTailRemaining(this.tailRemaining - writeBufferAppend);
                int r3 = next.writePosition;
                int r4 = next.readPosition;
                boolean z2 = true;
                if (r3 > r4) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    chunkBuffer.setNext(null);
                    chunkBuffer.setNext(next.cleanNext());
                    next.release(this.pool);
                } else {
                    if (writeBufferAppend < 0) {
                        z2 = false;
                    }
                    if (z2) {
                        if (r4 >= writeBufferAppend) {
                            next.startGap = writeBufferAppend;
                        } else if (r4 == r3) {
                            if (writeBufferAppend > next.limit) {
                                int r92 = next.capacity;
                                if (writeBufferAppend > r92) {
                                    throw new IllegalArgumentException(HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("Start gap ", writeBufferAppend, " is bigger than the capacity ", r92));
                                }
                                StringBuilder m = SuggestionsAdapter$$ExternalSyntheticOutline0.m("Unable to reserve ", writeBufferAppend, " start gap: there are already ");
                                m.append(r92 - next.limit);
                                m.append(" bytes reserved in the end");
                                throw new IllegalStateException(m.toString());
                            }
                            next.writePosition = writeBufferAppend;
                            next.readPosition = writeBufferAppend;
                            next.startGap = writeBufferAppend;
                        } else {
                            StringBuilder m2 = SuggestionsAdapter$$ExternalSyntheticOutline0.m("Unable to reserve ", writeBufferAppend, " start gap: there are already ");
                            m2.append(next.writePosition - next.readPosition);
                            m2.append(" content bytes starting at offset ");
                            m2.append(next.readPosition);
                            throw new IllegalStateException(m2.toString());
                        }
                    } else {
                        throw new IllegalArgumentException(SubMenuBuilder$$ExternalSyntheticOutline0.m("startGap shouldn't be negative: ", writeBufferAppend).toString());
                    }
                }
                if (chunkBuffer.writePosition - chunkBuffer.readPosition >= r9) {
                    return chunkBuffer;
                }
                if (r9 > 8) {
                    throw new IllegalStateException(ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m("minSize of ", r9, " is too big (should be less than 8)"));
                }
            }
        }
    }

    public final void release() {
        ChunkBuffer head = getHead();
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = ChunkBuffer.nextRef$FU;
        ChunkBuffer chunkBuffer = ChunkBuffer.Empty;
        if (head != chunkBuffer) {
            set_head(chunkBuffer);
            setTailRemaining(0L);
            BuffersKt.releaseAll(head, this.pool);
        }
    }

    public final void releaseHead$ktor_io(ChunkBuffer chunkBuffer) {
        ChunkBuffer cleanNext = chunkBuffer.cleanNext();
        if (cleanNext == null) {
            cleanNext = ChunkBuffer.Empty;
        }
        set_head(cleanNext);
        setTailRemaining(this.tailRemaining - (cleanNext.writePosition - cleanNext.readPosition));
        chunkBuffer.release(this.pool);
    }

    public final void setTailRemaining(long j) {
        boolean z;
        if (j >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.tailRemaining = j;
            return;
        }
        throw new IllegalArgumentException(FileSectionType$$ExternalSyntheticOutline0.m("tailRemaining shouldn't be negative: ", j).toString());
    }

    public final void set_head(ChunkBuffer chunkBuffer) {
        this._head = chunkBuffer;
        this.headMemory = chunkBuffer.memory;
        this.headPosition = chunkBuffer.readPosition;
        this.headEndExclusive = chunkBuffer.writePosition;
    }

    public Input(ChunkBuffer head, long j, ObjectPool<ChunkBuffer> pool) {
        Intrinsics.checkNotNullParameter(head, "head");
        Intrinsics.checkNotNullParameter(pool, "pool");
        this.pool = pool;
        this._head = head;
        this.headMemory = head.memory;
        this.headPosition = head.readPosition;
        this.headEndExclusive = head.writePosition;
        this.tailRemaining = j - (r3 - r6);
    }
}
