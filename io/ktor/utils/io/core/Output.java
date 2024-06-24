package io.ktor.utils.io.core;

import com.amazonaws.services.s3.internal.Constants;
import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.UTF8Kt;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.Closeable;
import java.nio.ByteBuffer;
import kotlin.text.Charsets;

/* compiled from: Output.kt */
/* loaded from: classes3.dex */
public abstract class Output implements Appendable, Closeable {
    public ChunkBuffer _head;
    public ChunkBuffer _tail;
    public int chainedSize;
    public final ObjectPool<ChunkBuffer> pool;
    public int tailEndExclusive;
    public int tailInitialPosition;
    public ByteBuffer tailMemory = Memory.Empty;
    public int tailPosition;

    public Output(ObjectPool<ChunkBuffer> objectPool) {
        this.pool = objectPool;
    }

    public final void afterHeadWrite() {
        ChunkBuffer chunkBuffer = this._tail;
        if (chunkBuffer != null) {
            this.tailPosition = chunkBuffer.writePosition;
        }
    }

    @Override // java.lang.Appendable
    public Output append(char c) {
        ChunkBuffer borrow;
        int r0 = this.tailPosition;
        int r1 = this.tailEndExclusive;
        int r4 = 4;
        if (r1 - r0 >= 3) {
            ByteBuffer byteBuffer = this.tailMemory;
            if (c >= 0 && c < 128) {
                byteBuffer.put(r0, (byte) c);
                r4 = 1;
            } else {
                if (128 <= c && c < 2048) {
                    byteBuffer.put(r0, (byte) (((c >> 6) & 31) | 192));
                    byteBuffer.put(r0 + 1, (byte) ((c & '?') | 128));
                    r4 = 2;
                } else {
                    if (2048 <= c && c < 0) {
                        byteBuffer.put(r0, (byte) (((c >> '\f') & 15) | 224));
                        byteBuffer.put(r0 + 1, (byte) (((c >> 6) & 63) | 128));
                        byteBuffer.put(r0 + 2, (byte) ((c & '?') | 128));
                        r4 = 3;
                    } else {
                        if (0 <= c && c < 0) {
                            r9 = true;
                        }
                        if (!r9) {
                            UTF8Kt.malformedCodePoint(c);
                            throw null;
                        }
                        byteBuffer.put(r0, (byte) (((c >> 18) & 7) | 240));
                        byteBuffer.put(r0 + 1, (byte) (((c >> '\f') & 63) | 128));
                        byteBuffer.put(r0 + 2, (byte) (((c >> 6) & 63) | 128));
                        byteBuffer.put(r0 + 3, (byte) ((c & '?') | 128));
                    }
                }
            }
            this.tailPosition = r0 + r4;
            return this;
        }
        if (r1 - r0 >= 3 && (borrow = this._tail) != null) {
            borrow.commitWrittenUntilIndex(r0);
        } else {
            borrow = this.pool.borrow();
            borrow.reserveEndGap();
            appendSingleChunk$ktor_io(borrow);
        }
        try {
            ByteBuffer byteBuffer2 = borrow.memory;
            int r2 = borrow.writePosition;
            if (c >= 0 && c < 128) {
                byteBuffer2.put(r2, (byte) c);
                r4 = 1;
            } else {
                if (128 <= c && c < 2048) {
                    byteBuffer2.put(r2, (byte) (((c >> 6) & 31) | 192));
                    byteBuffer2.put(r2 + 1, (byte) ((c & '?') | 128));
                    r4 = 2;
                } else {
                    if (2048 <= c && c < 0) {
                        byteBuffer2.put(r2, (byte) (((c >> '\f') & 15) | 224));
                        byteBuffer2.put(r2 + 1, (byte) (((c >> 6) & 63) | 128));
                        byteBuffer2.put(r2 + 2, (byte) ((c & '?') | 128));
                        r4 = 3;
                    } else {
                        if (!(0 <= c && c < 0)) {
                            UTF8Kt.malformedCodePoint(c);
                            throw null;
                        }
                        byteBuffer2.put(r2, (byte) (((c >> 18) & 7) | 240));
                        byteBuffer2.put(r2 + 1, (byte) (((c >> '\f') & 63) | 128));
                        byteBuffer2.put(r2 + 2, (byte) (((c >> 6) & 63) | 128));
                        byteBuffer2.put(r2 + 3, (byte) ((c & '?') | 128));
                    }
                }
            }
            borrow.commitWritten(r4);
            if (r4 >= 0) {
                return this;
            }
            throw new IllegalStateException("The returned value shouldn't be negative".toString());
        } finally {
            afterHeadWrite();
        }
    }

    public final void appendChainImpl(ChunkBuffer chunkBuffer, ChunkBuffer chunkBuffer2, int r5) {
        ChunkBuffer chunkBuffer3 = this._tail;
        if (chunkBuffer3 == null) {
            this._head = chunkBuffer;
            this.chainedSize = 0;
        } else {
            chunkBuffer3.setNext(chunkBuffer);
            int r3 = this.tailPosition;
            chunkBuffer3.commitWrittenUntilIndex(r3);
            this.chainedSize = (r3 - this.tailInitialPosition) + this.chainedSize;
        }
        this._tail = chunkBuffer2;
        this.chainedSize += r5;
        this.tailMemory = chunkBuffer2.memory;
        this.tailPosition = chunkBuffer2.writePosition;
        this.tailInitialPosition = chunkBuffer2.readPosition;
        this.tailEndExclusive = chunkBuffer2.limit;
    }

    public final void appendSingleChunk$ktor_io(ChunkBuffer chunkBuffer) {
        boolean z;
        if (chunkBuffer.getNext() == null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            appendChainImpl(chunkBuffer, chunkBuffer, 0);
            return;
        }
        throw new IllegalStateException("It should be a single buffer chunk.".toString());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        try {
            ObjectPool<ChunkBuffer> objectPool = this.pool;
            ChunkBuffer stealAll$ktor_io = stealAll$ktor_io();
            if (stealAll$ktor_io != null) {
                ChunkBuffer chunkBuffer = stealAll$ktor_io;
                do {
                    try {
                        mo1656flush62zg_DM(chunkBuffer.memory);
                        chunkBuffer = chunkBuffer.getNext();
                    } finally {
                        BuffersKt.releaseAll(stealAll$ktor_io, objectPool);
                    }
                } while (chunkBuffer != null);
            }
        } finally {
            closeDestination();
        }
    }

    public abstract void closeDestination();

    /* renamed from: flush-62zg_DM */
    public abstract void mo1656flush62zg_DM(ByteBuffer byteBuffer);

    public final int get_size() {
        return (this.tailPosition - this.tailInitialPosition) + this.chainedSize;
    }

    public final ChunkBuffer stealAll$ktor_io() {
        ChunkBuffer chunkBuffer = this._head;
        if (chunkBuffer == null) {
            return null;
        }
        ChunkBuffer chunkBuffer2 = this._tail;
        if (chunkBuffer2 != null) {
            chunkBuffer2.commitWrittenUntilIndex(this.tailPosition);
        }
        this._head = null;
        this._tail = null;
        this.tailPosition = 0;
        this.tailEndExclusive = 0;
        this.tailInitialPosition = 0;
        this.chainedSize = 0;
        this.tailMemory = Memory.Empty;
        return chunkBuffer;
    }

    public final void writeByte(byte b) {
        int r0 = this.tailPosition;
        if (r0 < this.tailEndExclusive) {
            this.tailPosition = r0 + 1;
            this.tailMemory.put(r0, b);
            return;
        }
        ChunkBuffer borrow = this.pool.borrow();
        borrow.reserveEndGap();
        appendSingleChunk$ktor_io(borrow);
        int r1 = borrow.writePosition;
        if (r1 != borrow.limit) {
            borrow.memory.put(r1, b);
            borrow.writePosition = r1 + 1;
            this.tailPosition++;
            return;
        }
        throw new InsufficientSpaceException("No free space in the buffer to write a byte");
    }

    @Override // java.lang.Appendable
    public Output append(CharSequence charSequence) {
        if (charSequence == null) {
            append(0, 4, Constants.NULL_VERSION_ID);
        } else {
            append(0, charSequence.length(), charSequence);
        }
        return this;
    }

    public Output append(int r2, int r3, CharSequence charSequence) {
        if (charSequence == null) {
            return append(r2, r3, Constants.NULL_VERSION_ID);
        }
        StringsKt.writeText(this, charSequence, r2, r3, Charsets.UTF_8);
        return this;
    }
}
