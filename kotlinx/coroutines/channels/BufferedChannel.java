package kotlinx.coroutines.channels;

import androidx.compose.runtime.ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0;
import io.ktor.http.UrlKt;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ExceptionsKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.OnUndeliveredElementKt$bindCancellationFun$1;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause1Impl;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;
import kotlinx.coroutines.selects.SelectKt$DUMMY_PROCESS_RESULT_FUNCTION$1;
import kotlinx.coroutines.selects.TrySelectDetailedResult;

/* compiled from: BufferedChannel.kt */
/* loaded from: classes4.dex */
public class BufferedChannel<E> implements Channel<E> {
    private volatile Object _closeCause;
    private volatile long bufferEnd;
    private volatile Object bufferEndSegment;
    public final int capacity;
    private volatile Object closeHandler;
    private volatile long completedExpandBuffersAndPauseFlag;
    public final Function1<E, Unit> onUndeliveredElement;
    public final BufferedChannel$onUndeliveredElementReceiveCancellationConstructor$1$1 onUndeliveredElementReceiveCancellationConstructor;
    private volatile Object receiveSegment;
    private volatile long receivers;
    private volatile Object sendSegment;
    private volatile long sendersAndCloseStatus;
    public static final AtomicLongFieldUpdater sendersAndCloseStatus$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "sendersAndCloseStatus");
    public static final AtomicLongFieldUpdater receivers$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "receivers");
    public static final AtomicLongFieldUpdater bufferEnd$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "bufferEnd");
    public static final AtomicLongFieldUpdater completedExpandBuffersAndPauseFlag$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "completedExpandBuffersAndPauseFlag");
    public static final AtomicReferenceFieldUpdater sendSegment$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "sendSegment");
    public static final AtomicReferenceFieldUpdater receiveSegment$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "receiveSegment");
    public static final AtomicReferenceFieldUpdater bufferEndSegment$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "bufferEndSegment");
    public static final AtomicReferenceFieldUpdater _closeCause$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "_closeCause");
    public static final AtomicReferenceFieldUpdater closeHandler$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "closeHandler");

    /* compiled from: BufferedChannel.kt */
    /* loaded from: classes4.dex */
    public final class BufferedChannelIterator implements ChannelIterator<E>, Waiter {
        public CancellableContinuationImpl<? super Boolean> continuation;
        public Object receiveResult = BufferedChannelKt.NO_RECEIVE_RESULT;

        public BufferedChannelIterator() {
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public final Object hasNext(ContinuationImpl continuationImpl) {
            ChannelSegment<E> channelSegment;
            Boolean bool;
            ChannelSegment<E> channelSegment2;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = BufferedChannel.receiveSegment$FU;
            BufferedChannel<E> bufferedChannel = BufferedChannel.this;
            ChannelSegment<E> channelSegment3 = (ChannelSegment) atomicReferenceFieldUpdater.get(bufferedChannel);
            while (!bufferedChannel.isClosedForReceive()) {
                long andIncrement = BufferedChannel.receivers$FU.getAndIncrement(bufferedChannel);
                long j = BufferedChannelKt.SEGMENT_SIZE;
                long j2 = andIncrement / j;
                int r11 = (int) (andIncrement % j);
                if (channelSegment3.id != j2) {
                    ChannelSegment<E> findSegmentReceive = bufferedChannel.findSegmentReceive(j2, channelSegment3);
                    if (findSegmentReceive == null) {
                        continue;
                    } else {
                        channelSegment = findSegmentReceive;
                    }
                } else {
                    channelSegment = channelSegment3;
                }
                Object updateCellReceive = bufferedChannel.updateCellReceive(channelSegment, r11, andIncrement, null);
                Symbol symbol = BufferedChannelKt.SUSPEND;
                if (updateCellReceive != symbol) {
                    Symbol symbol2 = BufferedChannelKt.FAILED;
                    if (updateCellReceive == symbol2) {
                        if (andIncrement < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                            channelSegment.cleanPrev();
                        }
                        channelSegment3 = channelSegment;
                    } else {
                        if (updateCellReceive == BufferedChannelKt.SUSPEND_NO_WAITER) {
                            BufferedChannel<E> bufferedChannel2 = BufferedChannel.this;
                            CancellableContinuationImpl<? super Boolean> orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuationImpl));
                            try {
                                this.continuation = orCreateCancellableContinuation;
                                Object updateCellReceive2 = bufferedChannel2.updateCellReceive(channelSegment, r11, andIncrement, this);
                                if (updateCellReceive2 == symbol) {
                                    invokeOnCancellation(channelSegment, r11);
                                } else {
                                    OnUndeliveredElementKt$bindCancellationFun$1 onUndeliveredElementKt$bindCancellationFun$1 = null;
                                    CoroutineContext coroutineContext = orCreateCancellableContinuation.context;
                                    Function1<E, Unit> function1 = bufferedChannel2.onUndeliveredElement;
                                    if (updateCellReceive2 == symbol2) {
                                        if (andIncrement < bufferedChannel2.getSendersCounter$kotlinx_coroutines_core()) {
                                            channelSegment.cleanPrev();
                                        }
                                        ChannelSegment<E> channelSegment4 = (ChannelSegment) BufferedChannel.receiveSegment$FU.get(bufferedChannel2);
                                        while (true) {
                                            if (bufferedChannel2.isClosedForReceive()) {
                                                CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.continuation;
                                                Intrinsics.checkNotNull(cancellableContinuationImpl);
                                                this.continuation = null;
                                                this.receiveResult = BufferedChannelKt.CHANNEL_CLOSED;
                                                Throwable closeCause = bufferedChannel.getCloseCause();
                                                if (closeCause == null) {
                                                    cancellableContinuationImpl.resumeWith(Boolean.FALSE);
                                                } else {
                                                    cancellableContinuationImpl.resumeWith(ResultKt.createFailure(closeCause));
                                                }
                                            } else {
                                                long andIncrement2 = BufferedChannel.receivers$FU.getAndIncrement(bufferedChannel2);
                                                long j3 = BufferedChannelKt.SEGMENT_SIZE;
                                                long j4 = andIncrement2 / j3;
                                                int r12 = (int) (andIncrement2 % j3);
                                                if (channelSegment4.id != j4) {
                                                    ChannelSegment<E> findSegmentReceive2 = bufferedChannel2.findSegmentReceive(j4, channelSegment4);
                                                    if (findSegmentReceive2 != null) {
                                                        channelSegment2 = findSegmentReceive2;
                                                    }
                                                } else {
                                                    channelSegment2 = channelSegment4;
                                                }
                                                Function1<E, Unit> function12 = function1;
                                                Object updateCellReceive3 = bufferedChannel2.updateCellReceive(channelSegment2, r12, andIncrement2, this);
                                                if (updateCellReceive3 == BufferedChannelKt.SUSPEND) {
                                                    invokeOnCancellation(channelSegment2, r12);
                                                    break;
                                                }
                                                if (updateCellReceive3 == BufferedChannelKt.FAILED) {
                                                    if (andIncrement2 < bufferedChannel2.getSendersCounter$kotlinx_coroutines_core()) {
                                                        channelSegment2.cleanPrev();
                                                    }
                                                    channelSegment4 = channelSegment2;
                                                    function1 = function12;
                                                } else if (updateCellReceive3 != BufferedChannelKt.SUSPEND_NO_WAITER) {
                                                    channelSegment2.cleanPrev();
                                                    this.receiveResult = updateCellReceive3;
                                                    this.continuation = null;
                                                    bool = Boolean.TRUE;
                                                    if (function12 != null) {
                                                        onUndeliveredElementKt$bindCancellationFun$1 = new OnUndeliveredElementKt$bindCancellationFun$1(function12, updateCellReceive3, coroutineContext);
                                                    }
                                                } else {
                                                    throw new IllegalStateException("unexpected".toString());
                                                }
                                            }
                                        }
                                    } else {
                                        channelSegment.cleanPrev();
                                        this.receiveResult = updateCellReceive2;
                                        this.continuation = null;
                                        bool = Boolean.TRUE;
                                        if (function1 != null) {
                                            onUndeliveredElementKt$bindCancellationFun$1 = new OnUndeliveredElementKt$bindCancellationFun$1(function1, updateCellReceive2, coroutineContext);
                                        }
                                    }
                                    orCreateCancellableContinuation.resume(bool, onUndeliveredElementKt$bindCancellationFun$1);
                                }
                                Object result = orCreateCancellableContinuation.getResult();
                                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                                return result;
                            } catch (Throwable th) {
                                orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                                throw th;
                            }
                        }
                        channelSegment.cleanPrev();
                        this.receiveResult = updateCellReceive;
                        return Boolean.TRUE;
                    }
                } else {
                    throw new IllegalStateException("unreachable".toString());
                }
            }
            this.receiveResult = BufferedChannelKt.CHANNEL_CLOSED;
            Throwable closeCause2 = bufferedChannel.getCloseCause();
            if (closeCause2 == null) {
                return Boolean.FALSE;
            }
            int r1 = StackTraceRecoveryKt.$r8$clinit;
            throw closeCause2;
        }

        @Override // kotlinx.coroutines.Waiter
        public final void invokeOnCancellation(Segment<?> segment, int r3) {
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.continuation;
            if (cancellableContinuationImpl != null) {
                cancellableContinuationImpl.invokeOnCancellation(segment, r3);
            }
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public final E next() {
            boolean z;
            E e = (E) this.receiveResult;
            Symbol symbol = BufferedChannelKt.NO_RECEIVE_RESULT;
            if (e != symbol) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this.receiveResult = symbol;
                if (e != BufferedChannelKt.CHANNEL_CLOSED) {
                    return e;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater = BufferedChannel.sendersAndCloseStatus$FU;
                Throwable receiveException = BufferedChannel.this.getReceiveException();
                int r1 = StackTraceRecoveryKt.$r8$clinit;
                throw receiveException;
            }
            throw new IllegalStateException("`hasNext()` has not been invoked".toString());
        }
    }

    /* compiled from: BufferedChannel.kt */
    /* loaded from: classes4.dex */
    public static final class SendBroadcast implements Waiter {
        @Override // kotlinx.coroutines.Waiter
        public final void invokeOnCancellation(Segment<?> segment, int r2) {
            throw null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [kotlin.jvm.functions.Function1<? super E, kotlin.Unit>, kotlin.jvm.functions.Function1<E, kotlin.Unit>] */
    /* JADX WARN: Type inference failed for: r9v8, types: [kotlinx.coroutines.channels.BufferedChannel$onUndeliveredElementReceiveCancellationConstructor$1$1] */
    public BufferedChannel(int r9, Function1<? super E, Unit> function1) {
        boolean z;
        long j;
        BufferedChannel$onUndeliveredElementReceiveCancellationConstructor$1$1 bufferedChannel$onUndeliveredElementReceiveCancellationConstructor$1$1;
        this.capacity = r9;
        this.onUndeliveredElement = function1;
        if (r9 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            ChannelSegment<Object> channelSegment = BufferedChannelKt.NULL_SEGMENT;
            if (r9 != 0) {
                if (r9 != Integer.MAX_VALUE) {
                    j = r9;
                } else {
                    j = Long.MAX_VALUE;
                }
            } else {
                j = 0;
            }
            this.bufferEnd = j;
            this.completedExpandBuffersAndPauseFlag = getBufferEndCounter();
            ChannelSegment<Object> channelSegment2 = new ChannelSegment<>(0L, null, this, 3);
            this.sendSegment = channelSegment2;
            this.receiveSegment = channelSegment2;
            if (isRendezvousOrUnlimited()) {
                channelSegment2 = BufferedChannelKt.NULL_SEGMENT;
                Intrinsics.checkNotNull(channelSegment2, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
            }
            this.bufferEndSegment = channelSegment2;
            if (function1 != 0) {
                bufferedChannel$onUndeliveredElementReceiveCancellationConstructor$1$1 = new Function3<SelectInstance<?>, Object, Object, Function1<? super Throwable, ? extends Unit>>(this) { // from class: kotlinx.coroutines.channels.BufferedChannel$onUndeliveredElementReceiveCancellationConstructor$1$1
                    public final /* synthetic */ BufferedChannel<E> this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                        this.this$0 = this;
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Function1<? super Throwable, ? extends Unit> invoke(SelectInstance<?> selectInstance, Object obj, final Object obj2) {
                        final SelectInstance<?> selectInstance2 = selectInstance;
                        final BufferedChannel<E> bufferedChannel = this.this$0;
                        return new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.channels.BufferedChannel$onUndeliveredElementReceiveCancellationConstructor$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(Throwable th) {
                                Symbol symbol = BufferedChannelKt.CHANNEL_CLOSED;
                                Object obj3 = obj2;
                                if (obj3 != symbol) {
                                    OnUndeliveredElementKt.callUndeliveredElement(bufferedChannel.onUndeliveredElement, obj3, selectInstance2.getContext());
                                }
                                return Unit.INSTANCE;
                            }
                        };
                    }
                };
            } else {
                bufferedChannel$onUndeliveredElementReceiveCancellationConstructor$1$1 = null;
            }
            this.onUndeliveredElementReceiveCancellationConstructor = bufferedChannel$onUndeliveredElementReceiveCancellationConstructor$1$1;
            this._closeCause = BufferedChannelKt.NO_CLOSE_CAUSE;
            return;
        }
        throw new IllegalArgumentException(ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m("Invalid channel capacity: ", r9, ", should be >=0").toString());
    }

    public static final ChannelSegment access$findSegmentSend(BufferedChannel bufferedChannel, long j, ChannelSegment channelSegment) {
        Object findSegmentInternal;
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j2;
        long j3;
        boolean z;
        bufferedChannel.getClass();
        ChannelSegment<Object> channelSegment2 = BufferedChannelKt.NULL_SEGMENT;
        BufferedChannelKt$createSegmentFunction$1 bufferedChannelKt$createSegmentFunction$1 = BufferedChannelKt$createSegmentFunction$1.INSTANCE;
        do {
            findSegmentInternal = ConcurrentLinkedListKt.findSegmentInternal(channelSegment, j, bufferedChannelKt$createSegmentFunction$1);
            if (UrlKt.m1650isClosedimpl(findSegmentInternal)) {
                break;
            }
            Segment m1649getSegmentimpl = UrlKt.m1649getSegmentimpl(findSegmentInternal);
            while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = sendSegment$FU;
                Segment segment = (Segment) atomicReferenceFieldUpdater.get(bufferedChannel);
                z = true;
                if (segment.id >= m1649getSegmentimpl.id) {
                    break;
                }
                boolean z2 = false;
                if (!m1649getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                    z = false;
                    break;
                }
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(bufferedChannel, segment, m1649getSegmentimpl)) {
                        z2 = true;
                        break;
                    }
                    if (atomicReferenceFieldUpdater.get(bufferedChannel) != segment) {
                        break;
                    }
                }
                if (z2) {
                    if (segment.decPointers$kotlinx_coroutines_core()) {
                        segment.remove();
                    }
                } else if (m1649getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                    m1649getSegmentimpl.remove();
                }
            }
        } while (!z);
        if (UrlKt.m1650isClosedimpl(findSegmentInternal)) {
            bufferedChannel.isClosedForSend();
            if (channelSegment.id * BufferedChannelKt.SEGMENT_SIZE < bufferedChannel.getReceiversCounter$kotlinx_coroutines_core()) {
                channelSegment.cleanPrev();
            }
        } else {
            ChannelSegment channelSegment3 = (ChannelSegment) UrlKt.m1649getSegmentimpl(findSegmentInternal);
            long j4 = channelSegment3.id;
            if (j4 > j) {
                long j5 = j4 * BufferedChannelKt.SEGMENT_SIZE;
                do {
                    atomicLongFieldUpdater = sendersAndCloseStatus$FU;
                    j2 = atomicLongFieldUpdater.get(bufferedChannel);
                    j3 = 1152921504606846975L & j2;
                    if (j3 >= j5) {
                        break;
                    }
                    ChannelSegment<Object> channelSegment4 = BufferedChannelKt.NULL_SEGMENT;
                } while (!atomicLongFieldUpdater.compareAndSet(bufferedChannel, j2, (((int) (j2 >> 60)) << 60) + j3));
                if (channelSegment3.id * BufferedChannelKt.SEGMENT_SIZE < bufferedChannel.getReceiversCounter$kotlinx_coroutines_core()) {
                    channelSegment3.cleanPrev();
                }
            } else {
                return channelSegment3;
            }
        }
        return null;
    }

    public static final int access$updateCellSend(BufferedChannel bufferedChannel, ChannelSegment channelSegment, int r6, Object obj, long j, Object obj2, boolean z) {
        bufferedChannel.getClass();
        channelSegment.setElementLazy(r6, obj);
        if (z) {
            return bufferedChannel.updateCellSendSlow(channelSegment, r6, obj, j, obj2, z);
        }
        Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(r6);
        if (state$kotlinx_coroutines_core == null) {
            if (bufferedChannel.bufferOrRendezvousSend(j)) {
                if (channelSegment.casState$kotlinx_coroutines_core(null, r6, BufferedChannelKt.BUFFERED)) {
                    return 1;
                }
            } else {
                if (obj2 == null) {
                    return 3;
                }
                if (channelSegment.casState$kotlinx_coroutines_core(null, r6, obj2)) {
                    return 2;
                }
            }
        } else if (state$kotlinx_coroutines_core instanceof Waiter) {
            channelSegment.setElementLazy(r6, null);
            if (bufferedChannel.tryResumeReceiver(state$kotlinx_coroutines_core, obj)) {
                channelSegment.setState$kotlinx_coroutines_core(r6, BufferedChannelKt.DONE_RCV);
                return 0;
            }
            Symbol symbol = BufferedChannelKt.INTERRUPTED_RCV;
            if (channelSegment.data.getAndSet((r6 * 2) + 1, symbol) != symbol) {
                channelSegment.onCancelledRequest(r6, true);
            }
            return 5;
        }
        return bufferedChannel.updateCellSendSlow(channelSegment, r6, obj, j, obj2, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* renamed from: receiveCatching-JP2dKIU$suspendImpl, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <E> java.lang.Object m1697receiveCatchingJP2dKIU$suspendImpl(kotlinx.coroutines.channels.BufferedChannel<E> r14, kotlin.coroutines.Continuation<? super kotlinx.coroutines.channels.ChannelResult<? extends E>> r15) {
        /*
            boolean r0 = r15 instanceof kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1
            if (r0 == 0) goto L13
            r0 = r15
            kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1 r0 = (kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1 r0 = new kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1
            r0.<init>(r14, r15)
        L18:
            r6 = r0
            java.lang.Object r15 = r6.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L35
            if (r1 != r2) goto L2d
            kotlin.ResultKt.throwOnFailure(r15)
            kotlinx.coroutines.channels.ChannelResult r15 = (kotlinx.coroutines.channels.ChannelResult) r15
            java.lang.Object r14 = r15.holder
            goto L9d
        L2d:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L35:
            kotlin.ResultKt.throwOnFailure(r15)
            r15 = 0
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = kotlinx.coroutines.channels.BufferedChannel.receiveSegment$FU
            java.lang.Object r1 = r1.get(r14)
            kotlinx.coroutines.channels.ChannelSegment r1 = (kotlinx.coroutines.channels.ChannelSegment) r1
        L41:
            boolean r3 = r14.isClosedForReceive()
            if (r3 == 0) goto L51
            java.lang.Throwable r14 = r14.getCloseCause()
            kotlinx.coroutines.channels.ChannelResult$Closed r15 = new kotlinx.coroutines.channels.ChannelResult$Closed
            r15.<init>(r14)
            goto La3
        L51:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = kotlinx.coroutines.channels.BufferedChannel.receivers$FU
            long r4 = r3.getAndIncrement(r14)
            int r3 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            long r7 = (long) r3
            long r7 = r4 / r7
            long r9 = (long) r3
            long r9 = r4 % r9
            int r3 = (int) r9
            long r9 = r1.id
            int r9 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r9 == 0) goto L6f
            kotlinx.coroutines.channels.ChannelSegment r7 = r14.findSegmentReceive(r7, r1)
            if (r7 != 0) goto L6d
            goto L41
        L6d:
            r13 = r7
            goto L70
        L6f:
            r13 = r1
        L70:
            r7 = r14
            r8 = r13
            r9 = r3
            r10 = r4
            r12 = r15
            java.lang.Object r1 = r7.updateCellReceive(r8, r9, r10, r12)
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND
            if (r1 == r7) goto La4
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.FAILED
            if (r1 != r7) goto L8e
            long r7 = r14.getSendersCounter$kotlinx_coroutines_core()
            int r1 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r1 >= 0) goto L8c
            r13.cleanPrev()
        L8c:
            r1 = r13
            goto L41
        L8e:
            kotlinx.coroutines.internal.Symbol r15 = kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND_NO_WAITER
            if (r1 != r15) goto L9f
            r6.label = r2
            r1 = r14
            r2 = r13
            java.lang.Object r14 = r1.m1699receiveCatchingOnNoWaiterSuspendGKJJFZk(r2, r3, r4, r6)
            if (r14 != r0) goto L9d
            return r0
        L9d:
            r15 = r14
            goto La3
        L9f:
            r13.cleanPrev()
            r15 = r1
        La3:
            return r15
        La4:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "unexpected"
            java.lang.String r15 = r15.toString()
            r14.<init>(r15)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.m1697receiveCatchingJP2dKIU$suspendImpl(kotlinx.coroutines.channels.BufferedChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean bufferOrRendezvousSend(long j) {
        if (j >= getBufferEndCounter() && j >= getReceiversCounter$kotlinx_coroutines_core() + this.capacity) {
            return false;
        }
        return true;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void cancel(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new CancellationException("Channel was cancelled");
        }
        closeOrCancelImpl(cancellationException, true);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final boolean close(Throwable th) {
        return closeOrCancelImpl(th, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0025, code lost:            r0 = kotlinx.coroutines.channels.BufferedChannelKt.NO_CLOSE_CAUSE;     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0027, code lost:            r1 = kotlinx.coroutines.channels.BufferedChannel._closeCause$FU;     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0030, code lost:            if (r1.compareAndSet(r15, r0, r16) == false) goto L12;     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0038, code lost:            if (r1.get(r15) == r0) goto L50;     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003a, code lost:            r13 = false;     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003c, code lost:            if (r17 == false) goto L20;     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003e, code lost:            r2 = r10.get(r15);        r4 = kotlinx.coroutines.channels.BufferedChannelKt.NULL_SEGMENT;     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004f, code lost:            if (r10.compareAndSet(r15, r2, (3 << 60) + (r2 & 1152921504606846975L)) == false) goto L52;     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0074, code lost:            isClosedForSend();     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0077, code lost:            if (r13 == false) goto L44;     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0079, code lost:            r0 = kotlinx.coroutines.channels.BufferedChannel.closeHandler$FU;        r1 = r0.get(r15);     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007f, code lost:            if (r1 != null) goto L33;     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0081, code lost:            r2 = kotlinx.coroutines.channels.BufferedChannelKt.CLOSE_HANDLER_CLOSED;     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x008a, code lost:            if (r0.compareAndSet(r15, r1, r2) == false) goto L37;     */
    /* JADX WARN: Code restructure failed: missing block: B:2:0x000b, code lost:            if (r17 != false) goto L4;     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0092, code lost:            if (r0.get(r15) == r1) goto L60;     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0094, code lost:            r0 = false;     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0095, code lost:            if (r0 == false) goto L56;     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0097, code lost:            if (r1 != null) goto L43;     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x009a, code lost:            kotlin.jvm.internal.TypeIntrinsics.beforeCheckcastToFunctionOfArity(1, r1);        ((kotlin.jvm.functions.Function1) r1).invoke(getCloseCause());     */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x000d, code lost:            r2 = r10.get(r15);     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x008c, code lost:            r0 = true;     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0084, code lost:            r2 = kotlinx.coroutines.channels.BufferedChannelKt.CLOSE_HANDLER_INVOKED;     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00a6, code lost:            return r13;     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0052, code lost:            r2 = r10.get(r15);        r0 = (int) (r2 >> 60);     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0059, code lost:            if (r0 == 0) goto L25;     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0014, code lost:            if (((int) (r2 >> 60)) != 0) goto L46;     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x005b, code lost:            if (r0 == 1) goto L24;     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x005e, code lost:            r0 = r2 & 1152921504606846975L;        r4 = kotlinx.coroutines.channels.BufferedChannelKt.NULL_SEGMENT;        r4 = 3;     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0072, code lost:            if (r10.compareAndSet(r15, r2, (r4 << 60) + r0) == false) goto L63;     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0064, code lost:            r0 = r2 & 1152921504606846975L;        r4 = kotlinx.coroutines.channels.BufferedChannelKt.NULL_SEGMENT;        r4 = 2;     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0016, code lost:            r4 = kotlinx.coroutines.channels.BufferedChannelKt.NULL_SEGMENT;     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0032, code lost:            r13 = true;     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0023, code lost:            if (r10.compareAndSet(r15, r2, (1 << 60) + (r2 & 1152921504606846975L)) == false) goto L47;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean closeOrCancelImpl(java.lang.Throwable r16, boolean r17) {
        /*
            r15 = this;
            r6 = r15
            r7 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            r9 = 60
            java.util.concurrent.atomic.AtomicLongFieldUpdater r10 = kotlinx.coroutines.channels.BufferedChannel.sendersAndCloseStatus$FU
            r11 = 1
            if (r17 == 0) goto L25
        Ld:
            long r2 = r10.get(r15)
            long r0 = r2 >> r9
            int r0 = (int) r0
            if (r0 != 0) goto L25
            long r0 = r2 & r7
            kotlinx.coroutines.channels.ChannelSegment<java.lang.Object> r4 = kotlinx.coroutines.channels.BufferedChannelKt.NULL_SEGMENT
            long r4 = (long) r11
            long r4 = r4 << r9
            long r4 = r4 + r0
            r0 = r10
            r1 = r15
            boolean r0 = r0.compareAndSet(r1, r2, r4)
            if (r0 == 0) goto Ld
        L25:
            kotlinx.coroutines.internal.Symbol r0 = kotlinx.coroutines.channels.BufferedChannelKt.NO_CLOSE_CAUSE
        L27:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = kotlinx.coroutines.channels.BufferedChannel._closeCause$FU
            r2 = r16
            boolean r3 = r1.compareAndSet(r15, r0, r2)
            r12 = 0
            if (r3 == 0) goto L34
            r13 = r11
            goto L3b
        L34:
            java.lang.Object r1 = r1.get(r15)
            if (r1 == r0) goto L27
            r13 = r12
        L3b:
            r14 = 3
            if (r17 == 0) goto L52
        L3e:
            long r2 = r10.get(r15)
            long r0 = r2 & r7
            kotlinx.coroutines.channels.ChannelSegment<java.lang.Object> r4 = kotlinx.coroutines.channels.BufferedChannelKt.NULL_SEGMENT
            long r4 = (long) r14
            long r4 = r4 << r9
            long r4 = r4 + r0
            r0 = r10
            r1 = r15
            boolean r0 = r0.compareAndSet(r1, r2, r4)
            if (r0 == 0) goto L3e
            goto L74
        L52:
            long r2 = r10.get(r15)
            long r0 = r2 >> r9
            int r0 = (int) r0
            if (r0 == 0) goto L64
            if (r0 == r11) goto L5e
            goto L74
        L5e:
            long r0 = r2 & r7
            kotlinx.coroutines.channels.ChannelSegment<java.lang.Object> r4 = kotlinx.coroutines.channels.BufferedChannelKt.NULL_SEGMENT
            r4 = r14
            goto L69
        L64:
            long r0 = r2 & r7
            kotlinx.coroutines.channels.ChannelSegment<java.lang.Object> r4 = kotlinx.coroutines.channels.BufferedChannelKt.NULL_SEGMENT
            r4 = 2
        L69:
            long r4 = (long) r4
            long r4 = r4 << r9
            long r4 = r4 + r0
            r0 = r10
            r1 = r15
            boolean r0 = r0.compareAndSet(r1, r2, r4)
            if (r0 == 0) goto L52
        L74:
            r15.isClosedForSend()
            if (r13 == 0) goto La6
        L79:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = kotlinx.coroutines.channels.BufferedChannel.closeHandler$FU
            java.lang.Object r1 = r0.get(r15)
            if (r1 != 0) goto L84
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.BufferedChannelKt.CLOSE_HANDLER_CLOSED
            goto L86
        L84:
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.BufferedChannelKt.CLOSE_HANDLER_INVOKED
        L86:
            boolean r3 = r0.compareAndSet(r15, r1, r2)
            if (r3 == 0) goto L8e
            r0 = r11
            goto L95
        L8e:
            java.lang.Object r3 = r0.get(r15)
            if (r3 == r1) goto L86
            r0 = r12
        L95:
            if (r0 == 0) goto L79
            if (r1 != 0) goto L9a
            goto La6
        L9a:
            kotlin.jvm.internal.TypeIntrinsics.beforeCheckcastToFunctionOfArity(r11, r1)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            java.lang.Throwable r0 = r15.getCloseCause()
            r1.invoke(r0)
        La6:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.closeOrCancelImpl(java.lang.Throwable, boolean):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0097, code lost:            r1 = (kotlinx.coroutines.channels.ChannelSegment) ((kotlinx.coroutines.internal.ConcurrentLinkedListNode) kotlinx.coroutines.internal.ConcurrentLinkedListNode._prev$FU.get(r1));     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final kotlinx.coroutines.channels.ChannelSegment<E> completeClose(long r13) {
        /*
            Method dump skipped, instructions count: 308
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.completeClose(long):kotlinx.coroutines.channels.ChannelSegment");
    }

    public final void dropFirstElementUntilTheSpecifiedCellIsInTheBuffer(long j) {
        UndeliveredElementException callUndeliveredElementCatchingException;
        ChannelSegment<E> channelSegment = (ChannelSegment) receiveSegment$FU.get(this);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = receivers$FU;
            long j2 = atomicLongFieldUpdater.get(this);
            if (j < Math.max(this.capacity + j2, getBufferEndCounter())) {
                return;
            }
            if (atomicLongFieldUpdater.compareAndSet(this, j2, j2 + 1)) {
                long j3 = BufferedChannelKt.SEGMENT_SIZE;
                long j4 = j2 / j3;
                int r1 = (int) (j2 % j3);
                if (channelSegment.id != j4) {
                    ChannelSegment<E> findSegmentReceive = findSegmentReceive(j4, channelSegment);
                    if (findSegmentReceive == null) {
                        continue;
                    } else {
                        channelSegment = findSegmentReceive;
                    }
                }
                Object updateCellReceive = updateCellReceive(channelSegment, r1, j2, null);
                if (updateCellReceive == BufferedChannelKt.FAILED) {
                    if (j2 < getSendersCounter$kotlinx_coroutines_core()) {
                        channelSegment.cleanPrev();
                    }
                } else {
                    channelSegment.cleanPrev();
                    Function1<E, Unit> function1 = this.onUndeliveredElement;
                    if (function1 != null && (callUndeliveredElementCatchingException = OnUndeliveredElementKt.callUndeliveredElementCatchingException(function1, updateCellReceive, null)) != null) {
                        throw callUndeliveredElementCatchingException;
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0158, code lost:            r13 = r2;     */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0012 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00db A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x019c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void expandBuffer() {
        /*
            Method dump skipped, instructions count: 425
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.expandBuffer():void");
    }

    public final ChannelSegment<E> findSegmentReceive(long j, ChannelSegment<E> channelSegment) {
        Object findSegmentInternal;
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j2;
        boolean z;
        boolean z2;
        boolean z3;
        ChannelSegment<Object> channelSegment2 = BufferedChannelKt.NULL_SEGMENT;
        BufferedChannelKt$createSegmentFunction$1 bufferedChannelKt$createSegmentFunction$1 = BufferedChannelKt$createSegmentFunction$1.INSTANCE;
        do {
            findSegmentInternal = ConcurrentLinkedListKt.findSegmentInternal(channelSegment, j, bufferedChannelKt$createSegmentFunction$1);
            if (UrlKt.m1650isClosedimpl(findSegmentInternal)) {
                break;
            }
            Segment m1649getSegmentimpl = UrlKt.m1649getSegmentimpl(findSegmentInternal);
            while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = receiveSegment$FU;
                Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                if (segment.id >= m1649getSegmentimpl.id) {
                    break;
                }
                if (!m1649getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                    z2 = false;
                    break;
                }
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, segment, m1649getSegmentimpl)) {
                        z3 = true;
                        break;
                    }
                    if (atomicReferenceFieldUpdater.get(this) != segment) {
                        z3 = false;
                        break;
                    }
                }
                if (z3) {
                    if (segment.decPointers$kotlinx_coroutines_core()) {
                        segment.remove();
                    }
                } else if (m1649getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                    m1649getSegmentimpl.remove();
                }
            }
            z2 = true;
        } while (!z2);
        if (UrlKt.m1650isClosedimpl(findSegmentInternal)) {
            isClosedForSend();
            if (channelSegment.id * BufferedChannelKt.SEGMENT_SIZE < getSendersCounter$kotlinx_coroutines_core()) {
                channelSegment.cleanPrev();
            }
        } else {
            ChannelSegment<E> channelSegment3 = (ChannelSegment) UrlKt.m1649getSegmentimpl(findSegmentInternal);
            boolean isRendezvousOrUnlimited = isRendezvousOrUnlimited();
            long j3 = channelSegment3.id;
            if (!isRendezvousOrUnlimited && j <= getBufferEndCounter() / BufferedChannelKt.SEGMENT_SIZE) {
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = bufferEndSegment$FU;
                    Segment segment2 = (Segment) atomicReferenceFieldUpdater2.get(this);
                    if (segment2.id >= j3) {
                        break;
                    }
                    if (!channelSegment3.tryIncPointers$kotlinx_coroutines_core()) {
                        break;
                    }
                    while (true) {
                        if (atomicReferenceFieldUpdater2.compareAndSet(this, segment2, channelSegment3)) {
                            z = true;
                            break;
                        }
                        if (atomicReferenceFieldUpdater2.get(this) != segment2) {
                            z = false;
                            break;
                        }
                    }
                    if (z) {
                        if (segment2.decPointers$kotlinx_coroutines_core()) {
                            segment2.remove();
                        }
                    } else if (channelSegment3.decPointers$kotlinx_coroutines_core()) {
                        channelSegment3.remove();
                    }
                }
            }
            if (j3 > j) {
                long j4 = j3 * BufferedChannelKt.SEGMENT_SIZE;
                do {
                    atomicLongFieldUpdater = receivers$FU;
                    j2 = atomicLongFieldUpdater.get(this);
                    if (j2 >= j4) {
                        break;
                    }
                } while (!atomicLongFieldUpdater.compareAndSet(this, j2, j4));
                if (channelSegment3.id * BufferedChannelKt.SEGMENT_SIZE < getSendersCounter$kotlinx_coroutines_core()) {
                    channelSegment3.cleanPrev();
                }
            } else {
                return channelSegment3;
            }
        }
        return null;
    }

    public final long getBufferEndCounter() {
        return bufferEnd$FU.get(this);
    }

    public final Throwable getCloseCause() {
        return (Throwable) _closeCause$FU.get(this);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final SelectClause1<ChannelResult<E>> getOnReceiveCatching() {
        BufferedChannel$onReceiveCatching$1 bufferedChannel$onReceiveCatching$1 = BufferedChannel$onReceiveCatching$1.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceiveCatching$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        TypeIntrinsics.beforeCheckcastToFunctionOfArity(3, bufferedChannel$onReceiveCatching$1);
        BufferedChannel$onReceiveCatching$2 bufferedChannel$onReceiveCatching$2 = BufferedChannel$onReceiveCatching$2.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceiveCatching$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        TypeIntrinsics.beforeCheckcastToFunctionOfArity(3, bufferedChannel$onReceiveCatching$2);
        return new SelectClause1Impl(this, bufferedChannel$onReceiveCatching$1, bufferedChannel$onReceiveCatching$2, this.onUndeliveredElementReceiveCancellationConstructor);
    }

    public final Throwable getReceiveException() {
        Throwable closeCause = getCloseCause();
        if (closeCause == null) {
            return new ClosedReceiveChannelException();
        }
        return closeCause;
    }

    public final long getReceiversCounter$kotlinx_coroutines_core() {
        return receivers$FU.get(this);
    }

    public final Throwable getSendException() {
        Throwable closeCause = getCloseCause();
        if (closeCause == null) {
            return new ClosedSendChannelException();
        }
        return closeCause;
    }

    public final long getSendersCounter$kotlinx_coroutines_core() {
        return sendersAndCloseStatus$FU.get(this) & 1152921504606846975L;
    }

    public final void incCompletedExpandBufferAttempts(long j) {
        boolean z;
        boolean z2;
        AtomicLongFieldUpdater atomicLongFieldUpdater = completedExpandBuffersAndPauseFlag$FU;
        if ((atomicLongFieldUpdater.addAndGet(this, j) & 4611686018427387904L) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return;
        }
        do {
            if ((atomicLongFieldUpdater.get(this) & 4611686018427387904L) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
        } while (z2);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final void invokeOnClose(ProduceKt$awaitClose$4$1 produceKt$awaitClose$4$1) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        boolean z;
        boolean z2;
        while (true) {
            atomicReferenceFieldUpdater = closeHandler$FU;
            if (atomicReferenceFieldUpdater.compareAndSet(this, null, produceKt$awaitClose$4$1)) {
                z = true;
                break;
            } else if (atomicReferenceFieldUpdater.get(this) != null) {
                z = false;
                break;
            }
        }
        if (z) {
            return;
        }
        do {
            Object obj = atomicReferenceFieldUpdater.get(this);
            Symbol symbol = BufferedChannelKt.CLOSE_HANDLER_CLOSED;
            if (obj == symbol) {
                Symbol symbol2 = BufferedChannelKt.CLOSE_HANDLER_INVOKED;
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, symbol, symbol2)) {
                        z2 = true;
                        break;
                    } else if (atomicReferenceFieldUpdater.get(this) != symbol) {
                        z2 = false;
                        break;
                    }
                }
            } else {
                if (obj == BufferedChannelKt.CLOSE_HANDLER_INVOKED) {
                    throw new IllegalStateException("Another handler was already registered and successfully invoked".toString());
                }
                throw new IllegalStateException(("Another handler is already registered: " + obj).toString());
            }
        } while (!z2);
        produceKt$awaitClose$4$1.invoke(getCloseCause());
    }

    /* JADX WARN: Code restructure failed: missing block: B:127:0x0187, code lost:            r0 = false;     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x00c1, code lost:            r0 = (kotlinx.coroutines.channels.ChannelSegment) ((kotlinx.coroutines.internal.ConcurrentLinkedListNode) kotlinx.coroutines.internal.ConcurrentLinkedListNode._prev$FU.get(r0));     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean isClosed(long r18, boolean r20) {
        /*
            Method dump skipped, instructions count: 412
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.isClosed(long, boolean):boolean");
    }

    public final boolean isClosedForReceive() {
        return isClosed(sendersAndCloseStatus$FU.get(this), true);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final boolean isClosedForSend() {
        return isClosed(sendersAndCloseStatus$FU.get(this), false);
    }

    public boolean isConflatedDropOldest() {
        return false;
    }

    public final boolean isRendezvousOrUnlimited() {
        long bufferEndCounter = getBufferEndCounter();
        if (bufferEndCounter != 0 && bufferEndCounter != Long.MAX_VALUE) {
            return false;
        }
        return true;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final ChannelIterator<E> iterator() {
        return new BufferedChannelIterator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void moveSegmentBufferEndToSpecifiedOrLast(long j, ChannelSegment<E> channelSegment) {
        boolean z;
        ChannelSegment<E> channelSegment2;
        ChannelSegment<E> channelSegment3;
        while (channelSegment.id < j && (channelSegment3 = (ChannelSegment) channelSegment.getNext()) != null) {
            channelSegment = channelSegment3;
        }
        while (true) {
            if (channelSegment.isRemoved() && (channelSegment2 = (ChannelSegment) channelSegment.getNext()) != null) {
                channelSegment = channelSegment2;
            } else {
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = bufferEndSegment$FU;
                    Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                    z = true;
                    if (segment.id >= channelSegment.id) {
                        break;
                    }
                    boolean z2 = false;
                    if (!channelSegment.tryIncPointers$kotlinx_coroutines_core()) {
                        z = false;
                        break;
                    }
                    while (true) {
                        if (atomicReferenceFieldUpdater.compareAndSet(this, segment, channelSegment)) {
                            z2 = true;
                            break;
                        } else if (atomicReferenceFieldUpdater.get(this) != segment) {
                            break;
                        }
                    }
                    if (z2) {
                        if (segment.decPointers$kotlinx_coroutines_core()) {
                            segment.remove();
                        }
                    } else if (channelSegment.decPointers$kotlinx_coroutines_core()) {
                        channelSegment.remove();
                    }
                }
                if (z) {
                    return;
                }
            }
        }
    }

    public final Object onClosedSend(E e, Continuation<? super Unit> continuation) {
        UndeliveredElementException callUndeliveredElementCatchingException;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        cancellableContinuationImpl.initCancellability();
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        if (function1 != null && (callUndeliveredElementCatchingException = OnUndeliveredElementKt.callUndeliveredElementCatchingException(function1, e, null)) != null) {
            ExceptionsKt.addSuppressed(callUndeliveredElementCatchingException, getSendException());
            cancellableContinuationImpl.resumeWith(ResultKt.createFailure(callUndeliveredElementCatchingException));
        } else {
            cancellableContinuationImpl.resumeWith(ResultKt.createFailure(getSendException()));
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return result;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0, types: [kotlinx.coroutines.internal.Symbol] */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v2, types: [kotlinx.coroutines.CancellableContinuationImpl] */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final Object receive(Continuation<? super E> continuation) {
        ChannelSegment<E> channelSegment;
        CancellableContinuationImpl cancellableContinuationImpl;
        OnUndeliveredElementKt$bindCancellationFun$1 onUndeliveredElementKt$bindCancellationFun$1;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = receiveSegment$FU;
        ChannelSegment<E> channelSegment2 = (ChannelSegment) atomicReferenceFieldUpdater.get(this);
        while (!isClosedForReceive()) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = receivers$FU;
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(this);
            long j = BufferedChannelKt.SEGMENT_SIZE;
            long j2 = andIncrement / j;
            int r12 = (int) (andIncrement % j);
            if (channelSegment2.id != j2) {
                ChannelSegment<E> findSegmentReceive = findSegmentReceive(j2, channelSegment2);
                if (findSegmentReceive == null) {
                    continue;
                } else {
                    channelSegment = findSegmentReceive;
                }
            } else {
                channelSegment = channelSegment2;
            }
            Object updateCellReceive = updateCellReceive(channelSegment, r12, andIncrement, null);
            ?? r14 = BufferedChannelKt.SUSPEND;
            if (updateCellReceive != r14) {
                Symbol symbol = BufferedChannelKt.FAILED;
                if (updateCellReceive == symbol) {
                    if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                        channelSegment.cleanPrev();
                    }
                    channelSegment2 = channelSegment;
                } else if (updateCellReceive == BufferedChannelKt.SUSPEND_NO_WAITER) {
                    CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
                    try {
                        Object updateCellReceive2 = updateCellReceive(channelSegment, r12, andIncrement, orCreateCancellableContinuation);
                        try {
                            if (updateCellReceive2 == r14) {
                                cancellableContinuationImpl = orCreateCancellableContinuation;
                                cancellableContinuationImpl.invokeOnCancellation(channelSegment, r12);
                            } else {
                                cancellableContinuationImpl = orCreateCancellableContinuation;
                                Function1<E, Unit> function1 = this.onUndeliveredElement;
                                CoroutineContext coroutineContext = cancellableContinuationImpl.context;
                                if (updateCellReceive2 == symbol) {
                                    if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                                        channelSegment.cleanPrev();
                                    }
                                    ChannelSegment<E> channelSegment3 = (ChannelSegment) atomicReferenceFieldUpdater.get(this);
                                    while (true) {
                                        if (isClosedForReceive()) {
                                            cancellableContinuationImpl.resumeWith(ResultKt.createFailure(getReceiveException()));
                                            break;
                                        }
                                        long andIncrement2 = atomicLongFieldUpdater.getAndIncrement(this);
                                        long j3 = BufferedChannelKt.SEGMENT_SIZE;
                                        long j4 = andIncrement2 / j3;
                                        int r8 = (int) (andIncrement2 % j3);
                                        if (channelSegment3.id != j4) {
                                            ChannelSegment<E> findSegmentReceive2 = findSegmentReceive(j4, channelSegment3);
                                            if (findSegmentReceive2 != null) {
                                                channelSegment3 = findSegmentReceive2;
                                            }
                                        }
                                        CoroutineContext coroutineContext2 = coroutineContext;
                                        updateCellReceive2 = updateCellReceive(channelSegment3, r8, andIncrement2, cancellableContinuationImpl);
                                        if (updateCellReceive2 == BufferedChannelKt.SUSPEND) {
                                            cancellableContinuationImpl.invokeOnCancellation(channelSegment3, r8);
                                            break;
                                        }
                                        if (updateCellReceive2 == BufferedChannelKt.FAILED) {
                                            if (andIncrement2 < getSendersCounter$kotlinx_coroutines_core()) {
                                                channelSegment3.cleanPrev();
                                            }
                                            coroutineContext = coroutineContext2;
                                        } else if (updateCellReceive2 != BufferedChannelKt.SUSPEND_NO_WAITER) {
                                            channelSegment3.cleanPrev();
                                            if (function1 != null) {
                                                onUndeliveredElementKt$bindCancellationFun$1 = new OnUndeliveredElementKt$bindCancellationFun$1(function1, updateCellReceive2, coroutineContext2);
                                            }
                                        } else {
                                            throw new IllegalStateException("unexpected".toString());
                                        }
                                    }
                                } else {
                                    channelSegment.cleanPrev();
                                    if (function1 != null) {
                                        onUndeliveredElementKt$bindCancellationFun$1 = new OnUndeliveredElementKt$bindCancellationFun$1(function1, updateCellReceive2, coroutineContext);
                                        cancellableContinuationImpl.resume(updateCellReceive2, onUndeliveredElementKt$bindCancellationFun$1);
                                    }
                                    onUndeliveredElementKt$bindCancellationFun$1 = null;
                                    cancellableContinuationImpl.resume(updateCellReceive2, onUndeliveredElementKt$bindCancellationFun$1);
                                }
                            }
                            Object result = cancellableContinuationImpl.getResult();
                            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                            return result;
                        } catch (Throwable th) {
                            th = th;
                            r14.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        r14 = orCreateCancellableContinuation;
                    }
                } else {
                    channelSegment.cleanPrev();
                    return updateCellReceive;
                }
            } else {
                throw new IllegalStateException("unexpected".toString());
            }
        }
        Throwable receiveException = getReceiveException();
        int r1 = StackTraceRecoveryKt.$r8$clinit;
        throw receiveException;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* renamed from: receiveCatching-JP2dKIU, reason: not valid java name */
    public final Object mo1698receiveCatchingJP2dKIU(CombineKt$combineInternal$2 combineKt$combineInternal$2) {
        return m1697receiveCatchingJP2dKIU$suspendImpl(this, combineKt$combineInternal$2);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* renamed from: receiveCatchingOnNoWaiterSuspend-GKJJFZk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m1699receiveCatchingOnNoWaiterSuspendGKJJFZk(kotlinx.coroutines.channels.ChannelSegment<E> r11, int r12, long r13, kotlin.coroutines.Continuation<? super kotlinx.coroutines.channels.ChannelResult<? extends E>> r15) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.m1699receiveCatchingOnNoWaiterSuspendGKJJFZk(kotlinx.coroutines.channels.ChannelSegment, int, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void resumeWaiterOnClosedChannel(Waiter waiter, boolean z) {
        Throwable sendException;
        if (!(waiter instanceof SendBroadcast)) {
            if (waiter instanceof CancellableContinuation) {
                Continuation continuation = (Continuation) waiter;
                if (z) {
                    sendException = getReceiveException();
                } else {
                    sendException = getSendException();
                }
                continuation.resumeWith(ResultKt.createFailure(sendException));
                return;
            }
            if (waiter instanceof ReceiveCatching) {
                ((ReceiveCatching) waiter).cont.resumeWith(new ChannelResult(new ChannelResult.Closed(getCloseCause())));
                return;
            }
            if (waiter instanceof BufferedChannelIterator) {
                BufferedChannelIterator bufferedChannelIterator = (BufferedChannelIterator) waiter;
                CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = bufferedChannelIterator.continuation;
                Intrinsics.checkNotNull(cancellableContinuationImpl);
                bufferedChannelIterator.continuation = null;
                bufferedChannelIterator.receiveResult = BufferedChannelKt.CHANNEL_CLOSED;
                Throwable closeCause = BufferedChannel.this.getCloseCause();
                if (closeCause == null) {
                    cancellableContinuationImpl.resumeWith(Boolean.FALSE);
                    return;
                } else {
                    cancellableContinuationImpl.resumeWith(ResultKt.createFailure(closeCause));
                    return;
                }
            }
            if (waiter instanceof SelectInstance) {
                ((SelectInstance) waiter).trySelect(this, BufferedChannelKt.CHANNEL_CLOSED);
                return;
            } else {
                throw new IllegalStateException(("Unexpected waiter: " + waiter).toString());
            }
        }
        ((SendBroadcast) waiter).getClass();
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x01ab, code lost:            return kotlin.Unit.INSTANCE;     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:79:? A[RETURN, SYNTHETIC] */
    @Override // kotlinx.coroutines.channels.SendChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object send(E r24, kotlin.coroutines.Continuation<? super kotlin.Unit> r25) {
        /*
            Method dump skipped, instructions count: 428
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.send(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:108:0x01c9, code lost:            r3 = (kotlinx.coroutines.channels.ChannelSegment) r3.getNext();     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x01d0, code lost:            if (r3 != null) goto L101;     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String toString() {
        /*
            Method dump skipped, instructions count: 507
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.toString():java.lang.String");
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* renamed from: tryReceive-PtdJZtk, reason: not valid java name */
    public final Object mo1700tryReceivePtdJZtk() {
        ChannelSegment<E> channelSegment;
        Waiter waiter;
        AtomicLongFieldUpdater atomicLongFieldUpdater = receivers$FU;
        long j = atomicLongFieldUpdater.get(this);
        long j2 = sendersAndCloseStatus$FU.get(this);
        if (isClosed(j2, true)) {
            return new ChannelResult.Closed(getCloseCause());
        }
        long j3 = j2 & 1152921504606846975L;
        Object obj = ChannelResult.failed;
        if (j >= j3) {
            return obj;
        }
        Object obj2 = BufferedChannelKt.INTERRUPTED_RCV;
        ChannelSegment<E> channelSegment2 = (ChannelSegment) receiveSegment$FU.get(this);
        while (!isClosedForReceive()) {
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(this);
            long j4 = BufferedChannelKt.SEGMENT_SIZE;
            long j5 = andIncrement / j4;
            int r11 = (int) (andIncrement % j4);
            if (channelSegment2.id != j5) {
                ChannelSegment<E> findSegmentReceive = findSegmentReceive(j5, channelSegment2);
                if (findSegmentReceive == null) {
                    continue;
                } else {
                    channelSegment = findSegmentReceive;
                }
            } else {
                channelSegment = channelSegment2;
            }
            Object updateCellReceive = updateCellReceive(channelSegment, r11, andIncrement, obj2);
            if (updateCellReceive == BufferedChannelKt.SUSPEND) {
                if (obj2 instanceof Waiter) {
                    waiter = (Waiter) obj2;
                } else {
                    waiter = null;
                }
                if (waiter != null) {
                    waiter.invokeOnCancellation(channelSegment, r11);
                }
                waitExpandBufferCompletion$kotlinx_coroutines_core(andIncrement);
                channelSegment.onSlotCleaned();
            } else if (updateCellReceive == BufferedChannelKt.FAILED) {
                if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                    channelSegment.cleanPrev();
                }
                channelSegment2 = channelSegment;
            } else if (updateCellReceive != BufferedChannelKt.SUSPEND_NO_WAITER) {
                channelSegment.cleanPrev();
                obj = updateCellReceive;
            } else {
                throw new IllegalStateException("unexpected".toString());
            }
            return obj;
        }
        return new ChannelResult.Closed(getCloseCause());
    }

    public final boolean tryResumeReceiver(Object obj, E e) {
        if (obj instanceof SelectInstance) {
            return ((SelectInstance) obj).trySelect(this, e);
        }
        boolean z = obj instanceof ReceiveCatching;
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        OnUndeliveredElementKt$bindCancellationFun$1 onUndeliveredElementKt$bindCancellationFun$1 = null;
        if (z) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
            ChannelResult channelResult = new ChannelResult(e);
            CancellableContinuationImpl<ChannelResult<? extends E>> cancellableContinuationImpl = ((ReceiveCatching) obj).cont;
            if (function1 != null) {
                onUndeliveredElementKt$bindCancellationFun$1 = new OnUndeliveredElementKt$bindCancellationFun$1(function1, e, cancellableContinuationImpl.context);
            }
            return BufferedChannelKt.tryResume0(cancellableContinuationImpl, channelResult, onUndeliveredElementKt$bindCancellationFun$1);
        }
        if (obj instanceof BufferedChannelIterator) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
            BufferedChannelIterator bufferedChannelIterator = (BufferedChannelIterator) obj;
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl2 = bufferedChannelIterator.continuation;
            Intrinsics.checkNotNull(cancellableContinuationImpl2);
            bufferedChannelIterator.continuation = null;
            bufferedChannelIterator.receiveResult = e;
            Boolean bool = Boolean.TRUE;
            Function1<E, Unit> function12 = BufferedChannel.this.onUndeliveredElement;
            if (function12 != null) {
                onUndeliveredElementKt$bindCancellationFun$1 = new OnUndeliveredElementKt$bindCancellationFun$1(function12, e, cancellableContinuationImpl2.context);
            }
            return BufferedChannelKt.tryResume0(cancellableContinuationImpl2, bool, onUndeliveredElementKt$bindCancellationFun$1);
        }
        if (obj instanceof CancellableContinuation) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
            CancellableContinuation cancellableContinuation = (CancellableContinuation) obj;
            if (function1 != null) {
                onUndeliveredElementKt$bindCancellationFun$1 = new OnUndeliveredElementKt$bindCancellationFun$1(function1, e, cancellableContinuation.getContext());
            }
            return BufferedChannelKt.tryResume0(cancellableContinuation, e, onUndeliveredElementKt$bindCancellationFun$1);
        }
        throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
    }

    public final boolean tryResumeSender(Object obj, ChannelSegment<E> channelSegment, int r6) {
        TrySelectDetailedResult trySelectDetailedResult;
        if (obj instanceof CancellableContinuation) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            return BufferedChannelKt.tryResume0((CancellableContinuation) obj, Unit.INSTANCE, null);
        }
        if (obj instanceof SelectInstance) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
            int trySelectInternal = ((SelectImplementation) obj).trySelectInternal(this, Unit.INSTANCE);
            SelectKt$DUMMY_PROCESS_RESULT_FUNCTION$1 selectKt$DUMMY_PROCESS_RESULT_FUNCTION$1 = SelectKt.DUMMY_PROCESS_RESULT_FUNCTION;
            if (trySelectInternal != 0) {
                if (trySelectInternal != 1) {
                    if (trySelectInternal != 2) {
                        if (trySelectInternal == 3) {
                            trySelectDetailedResult = TrySelectDetailedResult.ALREADY_SELECTED;
                        } else {
                            throw new IllegalStateException(("Unexpected internal result: " + trySelectInternal).toString());
                        }
                    } else {
                        trySelectDetailedResult = TrySelectDetailedResult.CANCELLED;
                    }
                } else {
                    trySelectDetailedResult = TrySelectDetailedResult.REREGISTER;
                }
            } else {
                trySelectDetailedResult = TrySelectDetailedResult.SUCCESSFUL;
            }
            if (trySelectDetailedResult == TrySelectDetailedResult.REREGISTER) {
                channelSegment.setElementLazy(r6, null);
            }
            if (trySelectDetailedResult == TrySelectDetailedResult.SUCCESSFUL) {
                return true;
            }
            return false;
        }
        if (obj instanceof SendBroadcast) {
            ((SendBroadcast) obj).getClass();
            BufferedChannelKt.tryResume0(null, Boolean.TRUE, null);
            throw null;
        }
        throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x00d5, code lost:            return kotlin.Unit.INSTANCE;     */
    @Override // kotlinx.coroutines.channels.SendChannel
    /* renamed from: trySend-JP2dKIU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo1701trySendJP2dKIU(E r23) {
        /*
            Method dump skipped, instructions count: 214
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.mo1701trySendJP2dKIU(java.lang.Object):java.lang.Object");
    }

    public final Object updateCellReceive(ChannelSegment<E> channelSegment, int r10, long j, Object obj) {
        Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(r10);
        AtomicReferenceArray atomicReferenceArray = channelSegment.data;
        AtomicLongFieldUpdater atomicLongFieldUpdater = sendersAndCloseStatus$FU;
        if (state$kotlinx_coroutines_core == null) {
            if (j >= (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    return BufferedChannelKt.SUSPEND_NO_WAITER;
                }
                if (channelSegment.casState$kotlinx_coroutines_core(state$kotlinx_coroutines_core, r10, obj)) {
                    expandBuffer();
                    return BufferedChannelKt.SUSPEND;
                }
            }
        } else if (state$kotlinx_coroutines_core == BufferedChannelKt.BUFFERED && channelSegment.casState$kotlinx_coroutines_core(state$kotlinx_coroutines_core, r10, BufferedChannelKt.DONE_RCV)) {
            expandBuffer();
            Object obj2 = atomicReferenceArray.get(r10 * 2);
            channelSegment.setElementLazy(r10, null);
            return obj2;
        }
        while (true) {
            Object state$kotlinx_coroutines_core2 = channelSegment.getState$kotlinx_coroutines_core(r10);
            if (state$kotlinx_coroutines_core2 != null && state$kotlinx_coroutines_core2 != BufferedChannelKt.IN_BUFFER) {
                if (state$kotlinx_coroutines_core2 == BufferedChannelKt.BUFFERED) {
                    if (channelSegment.casState$kotlinx_coroutines_core(state$kotlinx_coroutines_core2, r10, BufferedChannelKt.DONE_RCV)) {
                        expandBuffer();
                        Object obj3 = atomicReferenceArray.get(r10 * 2);
                        channelSegment.setElementLazy(r10, null);
                        return obj3;
                    }
                } else {
                    Symbol symbol = BufferedChannelKt.INTERRUPTED_SEND;
                    if (state$kotlinx_coroutines_core2 == symbol) {
                        return BufferedChannelKt.FAILED;
                    }
                    if (state$kotlinx_coroutines_core2 == BufferedChannelKt.POISONED) {
                        return BufferedChannelKt.FAILED;
                    }
                    if (state$kotlinx_coroutines_core2 == BufferedChannelKt.CHANNEL_CLOSED) {
                        expandBuffer();
                        return BufferedChannelKt.FAILED;
                    }
                    if (state$kotlinx_coroutines_core2 != BufferedChannelKt.RESUMING_BY_EB && channelSegment.casState$kotlinx_coroutines_core(state$kotlinx_coroutines_core2, r10, BufferedChannelKt.RESUMING_BY_RCV)) {
                        boolean z = state$kotlinx_coroutines_core2 instanceof WaiterEB;
                        if (z) {
                            state$kotlinx_coroutines_core2 = ((WaiterEB) state$kotlinx_coroutines_core2).waiter;
                        }
                        if (tryResumeSender(state$kotlinx_coroutines_core2, channelSegment, r10)) {
                            channelSegment.setState$kotlinx_coroutines_core(r10, BufferedChannelKt.DONE_RCV);
                            expandBuffer();
                            Object obj4 = atomicReferenceArray.get(r10 * 2);
                            channelSegment.setElementLazy(r10, null);
                            return obj4;
                        }
                        channelSegment.setState$kotlinx_coroutines_core(r10, symbol);
                        channelSegment.onCancelledRequest(r10, false);
                        if (z) {
                            expandBuffer();
                        }
                        return BufferedChannelKt.FAILED;
                    }
                }
            } else if (j < (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                if (channelSegment.casState$kotlinx_coroutines_core(state$kotlinx_coroutines_core2, r10, BufferedChannelKt.POISONED)) {
                    expandBuffer();
                    return BufferedChannelKt.FAILED;
                }
            } else {
                if (obj == null) {
                    return BufferedChannelKt.SUSPEND_NO_WAITER;
                }
                if (channelSegment.casState$kotlinx_coroutines_core(state$kotlinx_coroutines_core2, r10, obj)) {
                    expandBuffer();
                    return BufferedChannelKt.SUSPEND;
                }
            }
        }
    }

    public final int updateCellSendSlow(ChannelSegment<E> channelSegment, int r8, E e, long j, Object obj, boolean z) {
        while (true) {
            Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(r8);
            if (state$kotlinx_coroutines_core == null) {
                if (!bufferOrRendezvousSend(j) || z) {
                    if (z) {
                        if (channelSegment.casState$kotlinx_coroutines_core(null, r8, BufferedChannelKt.INTERRUPTED_SEND)) {
                            channelSegment.onCancelledRequest(r8, false);
                            return 4;
                        }
                    } else {
                        if (obj == null) {
                            return 3;
                        }
                        if (channelSegment.casState$kotlinx_coroutines_core(null, r8, obj)) {
                            return 2;
                        }
                    }
                } else if (channelSegment.casState$kotlinx_coroutines_core(null, r8, BufferedChannelKt.BUFFERED)) {
                    return 1;
                }
            } else if (state$kotlinx_coroutines_core == BufferedChannelKt.IN_BUFFER) {
                if (channelSegment.casState$kotlinx_coroutines_core(state$kotlinx_coroutines_core, r8, BufferedChannelKt.BUFFERED)) {
                    return 1;
                }
            } else {
                Symbol symbol = BufferedChannelKt.INTERRUPTED_RCV;
                if (state$kotlinx_coroutines_core == symbol) {
                    channelSegment.setElementLazy(r8, null);
                    return 5;
                }
                if (state$kotlinx_coroutines_core == BufferedChannelKt.POISONED) {
                    channelSegment.setElementLazy(r8, null);
                    return 5;
                }
                if (state$kotlinx_coroutines_core == BufferedChannelKt.CHANNEL_CLOSED) {
                    channelSegment.setElementLazy(r8, null);
                    isClosedForSend();
                    return 4;
                }
                channelSegment.setElementLazy(r8, null);
                if (state$kotlinx_coroutines_core instanceof WaiterEB) {
                    state$kotlinx_coroutines_core = ((WaiterEB) state$kotlinx_coroutines_core).waiter;
                }
                if (tryResumeReceiver(state$kotlinx_coroutines_core, e)) {
                    channelSegment.setState$kotlinx_coroutines_core(r8, BufferedChannelKt.DONE_RCV);
                    return 0;
                }
                if (channelSegment.data.getAndSet((r8 * 2) + 1, symbol) != symbol) {
                    channelSegment.onCancelledRequest(r8, true);
                }
                return 5;
            }
        }
    }

    public final void waitExpandBufferCompletion$kotlinx_coroutines_core(long j) {
        long j2;
        boolean z;
        long j3;
        if (isRendezvousOrUnlimited()) {
            return;
        }
        do {
        } while (getBufferEndCounter() <= j);
        int r0 = BufferedChannelKt.EXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS;
        int r1 = 0;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = completedExpandBuffersAndPauseFlag$FU;
            if (r1 < r0) {
                long bufferEndCounter = getBufferEndCounter();
                if (bufferEndCounter == (atomicLongFieldUpdater.get(this) & 4611686018427387903L) && bufferEndCounter == getBufferEndCounter()) {
                    return;
                } else {
                    r1++;
                }
            } else {
                do {
                    j2 = atomicLongFieldUpdater.get(this);
                } while (!atomicLongFieldUpdater.compareAndSet(this, j2, 4611686018427387904L + (j2 & 4611686018427387903L)));
                while (true) {
                    long bufferEndCounter2 = getBufferEndCounter();
                    long j4 = atomicLongFieldUpdater.get(this);
                    long j5 = j4 & 4611686018427387903L;
                    if ((j4 & 4611686018427387904L) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (bufferEndCounter2 == j5 && bufferEndCounter2 == getBufferEndCounter()) {
                        break;
                    } else if (!z) {
                        atomicLongFieldUpdater.compareAndSet(this, j4, j5 + 4611686018427387904L);
                    }
                }
                do {
                    j3 = atomicLongFieldUpdater.get(this);
                } while (!atomicLongFieldUpdater.compareAndSet(this, j3, 0 + (j3 & 4611686018427387903L)));
                return;
            }
        }
    }
}
