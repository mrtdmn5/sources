package kotlinx.coroutines.flow;

import java.util.Arrays;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.DisposeOnCancel;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.flow.internal.ChannelFlowOperatorImpl;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.internal.Symbol;

/* compiled from: SharedFlow.kt */
/* loaded from: classes4.dex */
public class SharedFlowImpl<T> extends AbstractSharedFlow<SharedFlowSlot> implements MutableSharedFlow<T>, Flow, FusibleFlow<T> {
    public Object[] buffer;
    public final int bufferCapacity;
    public int bufferSize;
    public long minCollectorIndex;
    public final BufferOverflow onBufferOverflow;
    public int queueSize;
    public final int replay;
    public long replayIndex;

    /* compiled from: SharedFlow.kt */
    /* loaded from: classes4.dex */
    public static final class Emitter implements DisposableHandle {
        public final Continuation<Unit> cont;
        public final SharedFlowImpl<?> flow;
        public final long index;
        public final Object value;

        public Emitter(SharedFlowImpl sharedFlowImpl, long j, Object obj, CancellableContinuationImpl cancellableContinuationImpl) {
            this.flow = sharedFlowImpl;
            this.index = j;
            this.value = obj;
            this.cont = cancellableContinuationImpl;
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public final void dispose() {
            SharedFlowImpl<?> sharedFlowImpl = this.flow;
            synchronized (sharedFlowImpl) {
                if (this.index >= sharedFlowImpl.getHead()) {
                    Object[] objArr = sharedFlowImpl.buffer;
                    Intrinsics.checkNotNull(objArr);
                    int r2 = (int) this.index;
                    if (objArr[(objArr.length - 1) & r2] == this) {
                        objArr[r2 & (objArr.length - 1)] = SharedFlowKt.NO_VALUE;
                        sharedFlowImpl.cleanupTailLocked();
                        Unit unit = Unit.INSTANCE;
                    }
                }
            }
        }
    }

    /* compiled from: SharedFlow.kt */
    /* loaded from: classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[BufferOverflow.values().length];
            try {
                r0[BufferOverflow.SUSPEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[BufferOverflow.DROP_LATEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public SharedFlowImpl(int r1, int r2, BufferOverflow bufferOverflow) {
        this.replay = r1;
        this.bufferCapacity = r2;
        this.onBufferOverflow = bufferOverflow;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00af, code lost:            throw r8.getCancellationException();     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0091 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static kotlin.coroutines.intrinsics.CoroutineSingletons collect$suspendImpl(kotlinx.coroutines.flow.SharedFlowImpl r8, kotlinx.coroutines.flow.FlowCollector r9, kotlin.coroutines.Continuation r10) {
        /*
            Method dump skipped, instructions count: 202
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.collect$suspendImpl(kotlinx.coroutines.flow.SharedFlowImpl, kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):kotlin.coroutines.intrinsics.CoroutineSingletons");
    }

    public final Object awaitValue(SharedFlowSlot sharedFlowSlot, SharedFlowImpl$collect$1 sharedFlowImpl$collect$1) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt__IntrinsicsJvmKt.intercepted(sharedFlowImpl$collect$1));
        cancellableContinuationImpl.initCancellability();
        synchronized (this) {
            if (tryPeekLocked(sharedFlowSlot) < 0) {
                sharedFlowSlot.cont = cancellableContinuationImpl;
            } else {
                cancellableContinuationImpl.resumeWith(Unit.INSTANCE);
            }
            Unit unit = Unit.INSTANCE;
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return result;
        }
        return Unit.INSTANCE;
    }

    public final void cleanupTailLocked() {
        if (this.bufferCapacity == 0 && this.queueSize <= 1) {
            return;
        }
        Object[] objArr = this.buffer;
        Intrinsics.checkNotNull(objArr);
        while (this.queueSize > 0) {
            long head = getHead();
            int r3 = this.bufferSize;
            int r4 = this.queueSize;
            if (objArr[((int) ((head + (r3 + r4)) - 1)) & (objArr.length - 1)] == SharedFlowKt.NO_VALUE) {
                this.queueSize = r4 - 1;
                objArr[((int) (getHead() + this.bufferSize + this.queueSize)) & (objArr.length - 1)] = null;
            } else {
                return;
            }
        }
    }

    @Override // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector<? super T> flowCollector, Continuation<?> continuation) {
        return collect$suspendImpl(this, flowCollector, continuation);
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public final SharedFlowSlot createSlot() {
        return new SharedFlowSlot();
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public final AbstractSharedFlowSlot[] createSlotArray() {
        return new SharedFlowSlot[2];
    }

    public final void dropOldestLocked() {
        Object[] objArr;
        Object[] objArr2 = this.buffer;
        Intrinsics.checkNotNull(objArr2);
        objArr2[((int) getHead()) & (objArr2.length - 1)] = null;
        this.bufferSize--;
        long head = getHead() + 1;
        if (this.replayIndex < head) {
            this.replayIndex = head;
        }
        if (this.minCollectorIndex < head) {
            if (this.nCollectors != 0 && (objArr = this.slots) != null) {
                for (Object obj : objArr) {
                    if (obj != null) {
                        SharedFlowSlot sharedFlowSlot = (SharedFlowSlot) obj;
                        long j = sharedFlowSlot.index;
                        if (j >= 0 && j < head) {
                            sharedFlowSlot.index = head;
                        }
                    }
                }
            }
            this.minCollectorIndex = head;
        }
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow, kotlinx.coroutines.flow.FlowCollector
    public final Object emit(T t, Continuation<? super Unit> continuation) {
        Continuation<Unit>[] continuationArr;
        Emitter emitter;
        if (tryEmit(t)) {
            return Unit.INSTANCE;
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        cancellableContinuationImpl.initCancellability();
        Continuation<Unit>[] continuationArr2 = AbstractSharedFlowKt.EMPTY_RESUMES;
        synchronized (this) {
            if (tryEmitLocked(t)) {
                cancellableContinuationImpl.resumeWith(Unit.INSTANCE);
                continuationArr = findSlotsToResumeLocked(continuationArr2);
                emitter = null;
            } else {
                Emitter emitter2 = new Emitter(this, this.bufferSize + this.queueSize + getHead(), t, cancellableContinuationImpl);
                enqueueLocked(emitter2);
                this.queueSize++;
                if (this.bufferCapacity == 0) {
                    continuationArr2 = findSlotsToResumeLocked(continuationArr2);
                }
                continuationArr = continuationArr2;
                emitter = emitter2;
            }
        }
        if (emitter != null) {
            cancellableContinuationImpl.invokeOnCancellation(new DisposeOnCancel(emitter));
        }
        for (Continuation<Unit> continuation2 : continuationArr) {
            if (continuation2 != null) {
                continuation2.resumeWith(Unit.INSTANCE);
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (result != coroutineSingletons) {
            result = Unit.INSTANCE;
        }
        if (result != coroutineSingletons) {
            return Unit.INSTANCE;
        }
        return result;
    }

    public final void enqueueLocked(Object obj) {
        int r0 = this.bufferSize + this.queueSize;
        Object[] objArr = this.buffer;
        if (objArr == null) {
            objArr = growBuffer(0, 2, null);
        } else if (r0 >= objArr.length) {
            objArr = growBuffer(r0, objArr.length * 2, objArr);
        }
        objArr[((int) (getHead() + r0)) & (objArr.length - 1)] = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.lang.Object[], java.lang.Object] */
    public final Continuation<Unit>[] findSlotsToResumeLocked(Continuation<Unit>[] continuationArr) {
        Object[] objArr;
        SharedFlowSlot sharedFlowSlot;
        CancellableContinuationImpl cancellableContinuationImpl;
        int length = continuationArr.length;
        if (this.nCollectors != 0 && (objArr = this.slots) != null) {
            int length2 = objArr.length;
            int r3 = 0;
            continuationArr = continuationArr;
            while (r3 < length2) {
                Object obj = objArr[r3];
                if (obj != null && (cancellableContinuationImpl = (sharedFlowSlot = (SharedFlowSlot) obj).cont) != null && tryPeekLocked(sharedFlowSlot) >= 0) {
                    int length3 = continuationArr.length;
                    continuationArr = continuationArr;
                    if (length >= length3) {
                        ?? copyOf = Arrays.copyOf(continuationArr, Math.max(2, continuationArr.length * 2));
                        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
                        continuationArr = copyOf;
                    }
                    continuationArr[length] = cancellableContinuationImpl;
                    sharedFlowSlot.cont = null;
                    length++;
                }
                r3++;
                continuationArr = continuationArr;
            }
        }
        return continuationArr;
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public final Flow<T> fuse(CoroutineContext coroutineContext, int r3, BufferOverflow bufferOverflow) {
        if ((r3 == 0 || r3 == -3) && bufferOverflow == BufferOverflow.SUSPEND) {
            return this;
        }
        return new ChannelFlowOperatorImpl(r3, coroutineContext, bufferOverflow, this);
    }

    public final long getHead() {
        return Math.min(this.minCollectorIndex, this.replayIndex);
    }

    public final Object[] growBuffer(int r8, int r9, Object[] objArr) {
        boolean z;
        if (r9 > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            Object[] objArr2 = new Object[r9];
            this.buffer = objArr2;
            if (objArr == null) {
                return objArr2;
            }
            long head = getHead();
            for (int r0 = 0; r0 < r8; r0++) {
                int r4 = (int) (r0 + head);
                objArr2[r4 & (r9 - 1)] = objArr[(objArr.length - 1) & r4];
            }
            return objArr2;
        }
        throw new IllegalStateException("Buffer size overflow".toString());
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public final void resetReplayCache() {
        synchronized (this) {
            updateBufferLocked(getHead() + this.bufferSize, this.minCollectorIndex, getHead() + this.bufferSize, getHead() + this.bufferSize + this.queueSize);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public final boolean tryEmit(T t) {
        int r1;
        boolean z;
        Continuation<Unit>[] continuationArr = AbstractSharedFlowKt.EMPTY_RESUMES;
        synchronized (this) {
            if (tryEmitLocked(t)) {
                continuationArr = findSlotsToResumeLocked(continuationArr);
                z = true;
            } else {
                z = false;
            }
        }
        for (Continuation<Unit> continuation : continuationArr) {
            if (continuation != null) {
                continuation.resumeWith(Unit.INSTANCE);
            }
        }
        return z;
    }

    public final boolean tryEmitLocked(T t) {
        int r0 = this.nCollectors;
        int r1 = this.replay;
        if (r0 == 0) {
            if (r1 != 0) {
                enqueueLocked(t);
                int r02 = this.bufferSize + 1;
                this.bufferSize = r02;
                if (r02 > r1) {
                    dropOldestLocked();
                }
                this.minCollectorIndex = getHead() + this.bufferSize;
            }
            return true;
        }
        int r03 = this.bufferSize;
        int r2 = this.bufferCapacity;
        if (r03 >= r2 && this.minCollectorIndex <= this.replayIndex) {
            int r04 = WhenMappings.$EnumSwitchMapping$0[this.onBufferOverflow.ordinal()];
            if (r04 != 1) {
                if (r04 == 2) {
                    return true;
                }
            } else {
                return false;
            }
        }
        enqueueLocked(t);
        int r05 = this.bufferSize + 1;
        this.bufferSize = r05;
        if (r05 > r2) {
            dropOldestLocked();
        }
        long head = getHead() + this.bufferSize;
        long j = this.replayIndex;
        if (((int) (head - j)) > r1) {
            updateBufferLocked(j + 1, this.minCollectorIndex, getHead() + this.bufferSize, getHead() + this.bufferSize + this.queueSize);
        }
        return true;
    }

    public final long tryPeekLocked(SharedFlowSlot sharedFlowSlot) {
        long j = sharedFlowSlot.index;
        if (j < getHead() + this.bufferSize) {
            return j;
        }
        if (this.bufferCapacity > 0 || j > getHead() || this.queueSize == 0) {
            return -1L;
        }
        return j;
    }

    public final Object tryTakeValue(SharedFlowSlot sharedFlowSlot) {
        Object obj;
        Continuation<Unit>[] continuationArr = AbstractSharedFlowKt.EMPTY_RESUMES;
        synchronized (this) {
            long tryPeekLocked = tryPeekLocked(sharedFlowSlot);
            if (tryPeekLocked < 0) {
                obj = SharedFlowKt.NO_VALUE;
            } else {
                long j = sharedFlowSlot.index;
                Object[] objArr = this.buffer;
                Intrinsics.checkNotNull(objArr);
                Object obj2 = objArr[((int) tryPeekLocked) & (objArr.length - 1)];
                if (obj2 instanceof Emitter) {
                    obj2 = ((Emitter) obj2).value;
                }
                sharedFlowSlot.index = tryPeekLocked + 1;
                Object obj3 = obj2;
                continuationArr = updateCollectorIndexLocked$kotlinx_coroutines_core(j);
                obj = obj3;
            }
        }
        for (Continuation<Unit> continuation : continuationArr) {
            if (continuation != null) {
                continuation.resumeWith(Unit.INSTANCE);
            }
        }
        return obj;
    }

    public final void updateBufferLocked(long j, long j2, long j3, long j4) {
        long min = Math.min(j2, j);
        for (long head = getHead(); head < min; head++) {
            Object[] objArr = this.buffer;
            Intrinsics.checkNotNull(objArr);
            objArr[((int) head) & (objArr.length - 1)] = null;
        }
        this.replayIndex = j;
        this.minCollectorIndex = j2;
        this.bufferSize = (int) (j3 - min);
        this.queueSize = (int) (j4 - j3);
    }

    public final Continuation<Unit>[] updateCollectorIndexLocked$kotlinx_coroutines_core(long j) {
        int r8;
        long j2;
        long j3;
        long j4;
        boolean z;
        long j5;
        Object[] objArr;
        long j6 = this.minCollectorIndex;
        Continuation<Unit>[] continuationArr = AbstractSharedFlowKt.EMPTY_RESUMES;
        if (j > j6) {
            return continuationArr;
        }
        long head = getHead();
        long j7 = this.bufferSize + head;
        int r0 = this.bufferCapacity;
        if (r0 == 0 && this.queueSize > 0) {
            j7++;
        }
        if (this.nCollectors != 0 && (objArr = this.slots) != null) {
            for (Object obj : objArr) {
                if (obj != null) {
                    long j8 = ((SharedFlowSlot) obj).index;
                    if (j8 >= 0 && j8 < j7) {
                        j7 = j8;
                    }
                }
            }
        }
        if (j7 <= this.minCollectorIndex) {
            return continuationArr;
        }
        long head2 = getHead() + this.bufferSize;
        if (this.nCollectors > 0) {
            r8 = Math.min(this.queueSize, r0 - ((int) (head2 - j7)));
        } else {
            r8 = this.queueSize;
        }
        long j9 = this.queueSize + head2;
        Symbol symbol = SharedFlowKt.NO_VALUE;
        if (r8 > 0) {
            continuationArr = new Continuation[r8];
            Object[] objArr2 = this.buffer;
            Intrinsics.checkNotNull(objArr2);
            long j10 = head2;
            int r17 = 0;
            while (true) {
                if (head2 < j9) {
                    j2 = j7;
                    int r4 = (int) head2;
                    Object obj2 = objArr2[(objArr2.length - 1) & r4];
                    if (obj2 != symbol) {
                        j3 = j9;
                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                        Emitter emitter = (Emitter) obj2;
                        int r13 = r17 + 1;
                        continuationArr[r17] = emitter.cont;
                        objArr2[r4 & (objArr2.length - 1)] = symbol;
                        objArr2[((int) j10) & (objArr2.length - 1)] = emitter.value;
                        j5 = 1;
                        j10++;
                        if (r13 >= r8) {
                            break;
                        }
                        r17 = r13;
                    } else {
                        j3 = j9;
                        j5 = 1;
                    }
                    head2 += j5;
                    j7 = j2;
                    j9 = j3;
                } else {
                    j2 = j7;
                    j3 = j9;
                    break;
                }
            }
            head2 = j10;
        } else {
            j2 = j7;
            j3 = j9;
        }
        Continuation<Unit>[] continuationArr2 = continuationArr;
        int r1 = (int) (head2 - head);
        if (this.nCollectors == 0) {
            j4 = head2;
        } else {
            j4 = j2;
        }
        long max = Math.max(this.replayIndex, head2 - Math.min(this.replay, r1));
        if (r0 == 0 && max < j3) {
            Object[] objArr3 = this.buffer;
            Intrinsics.checkNotNull(objArr3);
            if (Intrinsics.areEqual(objArr3[((int) max) & (objArr3.length - 1)], symbol)) {
                head2++;
                max++;
            }
        }
        updateBufferLocked(max, j4, head2, j3);
        cleanupTailLocked();
        if (continuationArr2.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return findSlotsToResumeLocked(continuationArr2);
        }
        return continuationArr2;
    }
}
