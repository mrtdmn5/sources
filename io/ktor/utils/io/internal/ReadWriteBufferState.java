package io.ktor.utils.io.internal;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReadWriteBufferState.kt */
/* loaded from: classes3.dex */
public abstract class ReadWriteBufferState {
    public final ByteBuffer backingBuffer;
    public final RingBufferCapacity capacity;

    /* compiled from: ReadWriteBufferState.kt */
    /* loaded from: classes3.dex */
    public static final class IdleEmpty extends ReadWriteBufferState {
        public static final IdleEmpty INSTANCE = new IdleEmpty();

        public IdleEmpty() {
            super(ReadWriteBufferStateKt.EmptyByteBuffer, ReadWriteBufferStateKt.EmptyCapacity);
        }

        public final String toString() {
            return "IDLE(empty)";
        }
    }

    /* compiled from: ReadWriteBufferState.kt */
    /* loaded from: classes3.dex */
    public static final class IdleNonEmpty extends ReadWriteBufferState {
        public final Initial initial;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IdleNonEmpty(Initial initial) {
            super(initial.backingBuffer, initial.capacity);
            Intrinsics.checkNotNullParameter(initial, "initial");
            this.initial = initial;
        }

        @Override // io.ktor.utils.io.internal.ReadWriteBufferState
        public final ReadWriteBufferState startReading$ktor_io() {
            return this.initial.readingState;
        }

        @Override // io.ktor.utils.io.internal.ReadWriteBufferState
        public final ReadWriteBufferState startWriting$ktor_io() {
            return this.initial.writingState;
        }

        public final String toString() {
            return "IDLE(with buffer)";
        }
    }

    /* compiled from: ReadWriteBufferState.kt */
    /* loaded from: classes3.dex */
    public static final class Initial extends ReadWriteBufferState {
        public final IdleNonEmpty idleState;
        public final ByteBuffer readBuffer;
        public final Reading readingState;
        public final ReadingWriting readingWritingState;
        public final ByteBuffer writeBuffer;
        public final Writing writingState;

        public /* synthetic */ Initial(ByteBuffer byteBuffer) {
            this(8, byteBuffer);
        }

        @Override // io.ktor.utils.io.internal.ReadWriteBufferState
        public final ByteBuffer getReadBuffer() {
            return this.readBuffer;
        }

        @Override // io.ktor.utils.io.internal.ReadWriteBufferState
        public final ByteBuffer getWriteBuffer() {
            return this.writeBuffer;
        }

        @Override // io.ktor.utils.io.internal.ReadWriteBufferState
        public final ReadWriteBufferState startReading$ktor_io() {
            return this.readingState;
        }

        @Override // io.ktor.utils.io.internal.ReadWriteBufferState
        public final ReadWriteBufferState startWriting$ktor_io() {
            return this.writingState;
        }

        public final String toString() {
            return "Initial";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Initial(int r5, ByteBuffer backingBuffer) {
            super(backingBuffer, new RingBufferCapacity(backingBuffer.capacity() - r5));
            Intrinsics.checkNotNullParameter(backingBuffer, "backingBuffer");
            if (backingBuffer.position() == 0) {
                if (backingBuffer.limit() == backingBuffer.capacity()) {
                    ByteBuffer duplicate = backingBuffer.duplicate();
                    Intrinsics.checkNotNullExpressionValue(duplicate, "backingBuffer.duplicate()");
                    this.writeBuffer = duplicate;
                    ByteBuffer duplicate2 = backingBuffer.duplicate();
                    Intrinsics.checkNotNullExpressionValue(duplicate2, "backingBuffer.duplicate()");
                    this.readBuffer = duplicate2;
                    this.idleState = new IdleNonEmpty(this);
                    this.readingState = new Reading(this);
                    this.writingState = new Writing(this);
                    this.readingWritingState = new ReadingWriting(this);
                    return;
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    /* compiled from: ReadWriteBufferState.kt */
    /* loaded from: classes3.dex */
    public static final class Reading extends ReadWriteBufferState {
        public final Initial initial;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Reading(Initial initial) {
            super(initial.backingBuffer, initial.capacity);
            Intrinsics.checkNotNullParameter(initial, "initial");
            this.initial = initial;
        }

        @Override // io.ktor.utils.io.internal.ReadWriteBufferState
        public final ByteBuffer getReadBuffer() {
            return this.initial.readBuffer;
        }

        @Override // io.ktor.utils.io.internal.ReadWriteBufferState
        public final ReadWriteBufferState startWriting$ktor_io() {
            return this.initial.readingWritingState;
        }

        @Override // io.ktor.utils.io.internal.ReadWriteBufferState
        public final ReadWriteBufferState stopReading$ktor_io() {
            return this.initial.idleState;
        }

        public final String toString() {
            return "Reading";
        }
    }

    /* compiled from: ReadWriteBufferState.kt */
    /* loaded from: classes3.dex */
    public static final class ReadingWriting extends ReadWriteBufferState {
        public final Initial initial;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ReadingWriting(Initial initial) {
            super(initial.backingBuffer, initial.capacity);
            Intrinsics.checkNotNullParameter(initial, "initial");
            this.initial = initial;
        }

        @Override // io.ktor.utils.io.internal.ReadWriteBufferState
        public final ByteBuffer getReadBuffer() {
            return this.initial.readBuffer;
        }

        @Override // io.ktor.utils.io.internal.ReadWriteBufferState
        public final ByteBuffer getWriteBuffer() {
            return this.initial.writeBuffer;
        }

        @Override // io.ktor.utils.io.internal.ReadWriteBufferState
        public final ReadWriteBufferState stopReading$ktor_io() {
            return this.initial.writingState;
        }

        @Override // io.ktor.utils.io.internal.ReadWriteBufferState
        public final ReadWriteBufferState stopWriting$ktor_io() {
            return this.initial.readingState;
        }

        public final String toString() {
            return "Reading+Writing";
        }
    }

    /* compiled from: ReadWriteBufferState.kt */
    /* loaded from: classes3.dex */
    public static final class Terminated extends ReadWriteBufferState {
        public static final Terminated INSTANCE = new Terminated();

        public Terminated() {
            super(ReadWriteBufferStateKt.EmptyByteBuffer, ReadWriteBufferStateKt.EmptyCapacity);
        }

        public final String toString() {
            return "Terminated";
        }
    }

    /* compiled from: ReadWriteBufferState.kt */
    /* loaded from: classes3.dex */
    public static final class Writing extends ReadWriteBufferState {
        public final Initial initial;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Writing(Initial initial) {
            super(initial.backingBuffer, initial.capacity);
            Intrinsics.checkNotNullParameter(initial, "initial");
            this.initial = initial;
        }

        @Override // io.ktor.utils.io.internal.ReadWriteBufferState
        public final ByteBuffer getWriteBuffer() {
            return this.initial.writeBuffer;
        }

        @Override // io.ktor.utils.io.internal.ReadWriteBufferState
        public final ReadWriteBufferState startReading$ktor_io() {
            return this.initial.readingWritingState;
        }

        @Override // io.ktor.utils.io.internal.ReadWriteBufferState
        public final ReadWriteBufferState stopWriting$ktor_io() {
            return this.initial.idleState;
        }

        public final String toString() {
            return "Writing";
        }
    }

    public ReadWriteBufferState(ByteBuffer byteBuffer, RingBufferCapacity ringBufferCapacity) {
        this.backingBuffer = byteBuffer;
        this.capacity = ringBufferCapacity;
    }

    public ByteBuffer getReadBuffer() {
        throw new IllegalStateException(("read buffer is not available in state " + this).toString());
    }

    public ByteBuffer getWriteBuffer() {
        throw new IllegalStateException(("write buffer is not available in state " + this).toString());
    }

    public ReadWriteBufferState startReading$ktor_io() {
        throw new IllegalStateException(("ByteChannel[state: " + this + "] Concurrent reading is not supported").toString());
    }

    public ReadWriteBufferState startWriting$ktor_io() {
        throw new IllegalStateException(("ByteChannel[state: " + this + "] Concurrent writing is not supported").toString());
    }

    public ReadWriteBufferState stopReading$ktor_io() {
        throw new IllegalStateException(("Unable to stop reading in state " + this).toString());
    }

    public ReadWriteBufferState stopWriting$ktor_io() {
        throw new IllegalStateException(("Unable to stop writing in state " + this).toString());
    }
}
