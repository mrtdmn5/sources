package kotlinx.coroutines.sync;

import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import io.ktor.http.UrlKt;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectInstance;

/* compiled from: Semaphore.kt */
/* loaded from: classes4.dex */
public class SemaphoreImpl implements Semaphore {
    private volatile int _availablePermits;
    private volatile long deqIdx;
    private volatile long enqIdx;
    private volatile Object head;
    public final SemaphoreImpl$onCancellationRelease$1 onCancellationRelease;
    public final int permits;
    private volatile Object tail;
    public static final AtomicReferenceFieldUpdater head$FU = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, "head");
    public static final AtomicLongFieldUpdater deqIdx$FU = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "deqIdx");
    public static final AtomicReferenceFieldUpdater tail$FU = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, "tail");
    public static final AtomicLongFieldUpdater enqIdx$FU = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "enqIdx");
    public static final AtomicIntegerFieldUpdater _availablePermits$FU = AtomicIntegerFieldUpdater.newUpdater(SemaphoreImpl.class, "_availablePermits");

    /* JADX WARN: Type inference failed for: r6v6, types: [kotlinx.coroutines.sync.SemaphoreImpl$onCancellationRelease$1] */
    public SemaphoreImpl(int r6, int r7) {
        boolean z;
        this.permits = r6;
        if (r6 > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (r7 >= 0 && r7 <= r6) {
                SemaphoreSegment semaphoreSegment = new SemaphoreSegment(0L, null, 2);
                this.head = semaphoreSegment;
                this.tail = semaphoreSegment;
                this._availablePermits = r6 - r7;
                this.onCancellationRelease = new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.sync.SemaphoreImpl$onCancellationRelease$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Throwable th) {
                        SemaphoreImpl.this.release();
                        return Unit.INSTANCE;
                    }
                };
                return;
            }
            throw new IllegalArgumentException(SubMenuBuilder$$ExternalSyntheticOutline0.m("The number of acquired permits should be in 0..", r6).toString());
        }
        throw new IllegalArgumentException(SubMenuBuilder$$ExternalSyntheticOutline0.m("Semaphore should have at least 1 permit, but had ", r6).toString());
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public final Object acquire(ContinuationImpl continuationImpl) {
        int andDecrement;
        do {
            andDecrement = _availablePermits$FU.getAndDecrement(this);
        } while (andDecrement > this.permits);
        if (andDecrement > 0) {
            return Unit.INSTANCE;
        }
        CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuationImpl));
        try {
            if (!addAcquireToQueue(orCreateCancellableContinuation)) {
                acquire(orCreateCancellableContinuation);
            }
            Object result = orCreateCancellableContinuation.getResult();
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (result != coroutineSingletons) {
                result = Unit.INSTANCE;
            }
            return result == coroutineSingletons ? result : Unit.INSTANCE;
        } catch (Throwable th) {
            orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0058, code lost:            r10 = true;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean addAcquireToQueue(kotlinx.coroutines.Waiter r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = kotlinx.coroutines.sync.SemaphoreImpl.tail$FU
            java.lang.Object r3 = r2.get(r0)
            kotlinx.coroutines.sync.SemaphoreSegment r3 = (kotlinx.coroutines.sync.SemaphoreSegment) r3
            java.util.concurrent.atomic.AtomicLongFieldUpdater r4 = kotlinx.coroutines.sync.SemaphoreImpl.enqIdx$FU
            long r4 = r4.getAndIncrement(r0)
            kotlinx.coroutines.sync.SemaphoreImpl$addAcquireToQueue$createNewSegment$1 r6 = kotlinx.coroutines.sync.SemaphoreImpl$addAcquireToQueue$createNewSegment$1.INSTANCE
            int r7 = kotlinx.coroutines.sync.SemaphoreKt.SEGMENT_SIZE
            long r7 = (long) r7
            long r7 = r4 / r7
        L19:
            java.lang.Object r9 = kotlinx.coroutines.internal.ConcurrentLinkedListKt.findSegmentInternal(r3, r7, r6)
            boolean r10 = io.ktor.http.UrlKt.m1650isClosedimpl(r9)
            if (r10 != 0) goto L66
            kotlinx.coroutines.internal.Segment r10 = io.ktor.http.UrlKt.m1649getSegmentimpl(r9)
        L27:
            java.lang.Object r13 = r2.get(r0)
            kotlinx.coroutines.internal.Segment r13 = (kotlinx.coroutines.internal.Segment) r13
            long r14 = r13.id
            long r11 = r10.id
            int r11 = (r14 > r11 ? 1 : (r14 == r11 ? 0 : -1))
            if (r11 < 0) goto L36
            goto L58
        L36:
            boolean r11 = r10.tryIncPointers$kotlinx_coroutines_core()
            if (r11 != 0) goto L3e
            r10 = 0
            goto L59
        L3e:
            boolean r11 = r2.compareAndSet(r0, r13, r10)
            if (r11 == 0) goto L46
            r11 = 1
            goto L4d
        L46:
            java.lang.Object r11 = r2.get(r0)
            if (r11 == r13) goto L3e
            r11 = 0
        L4d:
            if (r11 == 0) goto L5c
            boolean r10 = r13.decPointers$kotlinx_coroutines_core()
            if (r10 == 0) goto L58
            r13.remove()
        L58:
            r10 = 1
        L59:
            if (r10 == 0) goto L19
            goto L66
        L5c:
            boolean r11 = r10.decPointers$kotlinx_coroutines_core()
            if (r11 == 0) goto L27
            r10.remove()
            goto L27
        L66:
            kotlinx.coroutines.internal.Segment r2 = io.ktor.http.UrlKt.m1649getSegmentimpl(r9)
            kotlinx.coroutines.sync.SemaphoreSegment r2 = (kotlinx.coroutines.sync.SemaphoreSegment) r2
            int r3 = kotlinx.coroutines.sync.SemaphoreKt.SEGMENT_SIZE
            long r6 = (long) r3
            long r4 = r4 % r6
            int r3 = (int) r4
            java.util.concurrent.atomic.AtomicReferenceArray r4 = r2.acquirers
        L73:
            r5 = 0
            boolean r5 = r4.compareAndSet(r3, r5, r1)
            if (r5 == 0) goto L7c
            r4 = 1
            goto L83
        L7c:
            java.lang.Object r5 = r4.get(r3)
            if (r5 == 0) goto L73
            r4 = 0
        L83:
            if (r4 == 0) goto L8a
            r1.invokeOnCancellation(r2, r3)
            r1 = 1
            return r1
        L8a:
            kotlinx.coroutines.internal.Symbol r5 = kotlinx.coroutines.sync.SemaphoreKt.PERMIT
            kotlinx.coroutines.internal.Symbol r6 = kotlinx.coroutines.sync.SemaphoreKt.TAKEN
            java.util.concurrent.atomic.AtomicReferenceArray r7 = r2.acquirers
        L90:
            boolean r2 = r7.compareAndSet(r3, r5, r6)
            if (r2 == 0) goto L98
            r2 = 1
            goto L9f
        L98:
            java.lang.Object r2 = r7.get(r3)
            if (r2 == r5) goto L90
            r2 = 0
        L9f:
            if (r2 == 0) goto Lac
            kotlinx.coroutines.CancellableContinuation r1 = (kotlinx.coroutines.CancellableContinuation) r1
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            kotlinx.coroutines.sync.SemaphoreImpl$onCancellationRelease$1 r3 = r0.onCancellationRelease
            r1.resume(r2, r3)
            r8 = 1
            return r8
        Lac:
            r9 = 0
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.SemaphoreImpl.addAcquireToQueue(kotlinx.coroutines.Waiter):boolean");
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public final void release() {
        int r2;
        Object findSegmentInternal;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        do {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = _availablePermits$FU;
            int andIncrement = atomicIntegerFieldUpdater.getAndIncrement(this);
            int r3 = this.permits;
            if (andIncrement < r3) {
                if (andIncrement >= 0) {
                    return;
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = head$FU;
                SemaphoreSegment semaphoreSegment = (SemaphoreSegment) atomicReferenceFieldUpdater.get(this);
                long andIncrement2 = deqIdx$FU.getAndIncrement(this);
                long j = andIncrement2 / SemaphoreKt.SEGMENT_SIZE;
                SemaphoreImpl$tryResumeNextFromQueue$createNewSegment$1 semaphoreImpl$tryResumeNextFromQueue$createNewSegment$1 = SemaphoreImpl$tryResumeNextFromQueue$createNewSegment$1.INSTANCE;
                do {
                    findSegmentInternal = ConcurrentLinkedListKt.findSegmentInternal(semaphoreSegment, j, semaphoreImpl$tryResumeNextFromQueue$createNewSegment$1);
                    if (UrlKt.m1650isClosedimpl(findSegmentInternal)) {
                        break;
                    }
                    Segment m1649getSegmentimpl = UrlKt.m1649getSegmentimpl(findSegmentInternal);
                    while (true) {
                        Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                        if (segment.id >= m1649getSegmentimpl.id) {
                            break;
                        }
                        if (!m1649getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                            z4 = false;
                            break;
                        }
                        while (true) {
                            if (atomicReferenceFieldUpdater.compareAndSet(this, segment, m1649getSegmentimpl)) {
                                z5 = true;
                                break;
                            } else if (atomicReferenceFieldUpdater.get(this) != segment) {
                                z5 = false;
                                break;
                            }
                        }
                        if (z5) {
                            if (segment.decPointers$kotlinx_coroutines_core()) {
                                segment.remove();
                            }
                        } else if (m1649getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                            m1649getSegmentimpl.remove();
                        }
                    }
                    z4 = true;
                } while (!z4);
                SemaphoreSegment semaphoreSegment2 = (SemaphoreSegment) UrlKt.m1649getSegmentimpl(findSegmentInternal);
                semaphoreSegment2.cleanPrev();
                if (semaphoreSegment2.id <= j) {
                    int r22 = (int) (andIncrement2 % SemaphoreKt.SEGMENT_SIZE);
                    Symbol symbol = SemaphoreKt.PERMIT;
                    AtomicReferenceArray atomicReferenceArray = semaphoreSegment2.acquirers;
                    Object andSet = atomicReferenceArray.getAndSet(r22, symbol);
                    if (andSet == null) {
                        int r32 = SemaphoreKt.MAX_SPIN_CYCLES;
                        int r4 = 0;
                        while (true) {
                            if (r4 < r32) {
                                if (atomicReferenceArray.get(r22) == SemaphoreKt.TAKEN) {
                                    z = true;
                                    break;
                                }
                                r4++;
                            } else {
                                Symbol symbol2 = SemaphoreKt.PERMIT;
                                Symbol symbol3 = SemaphoreKt.BROKEN;
                                while (true) {
                                    if (atomicReferenceArray.compareAndSet(r22, symbol2, symbol3)) {
                                        z2 = true;
                                        z3 = true;
                                        break;
                                    } else if (atomicReferenceArray.get(r22) != symbol2) {
                                        z2 = true;
                                        z3 = false;
                                        break;
                                    }
                                }
                                z = z3 ^ z2;
                            }
                        }
                    } else if (andSet != SemaphoreKt.CANCELLED) {
                        if (andSet instanceof CancellableContinuation) {
                            CancellableContinuation cancellableContinuation = (CancellableContinuation) andSet;
                            Symbol tryResume = cancellableContinuation.tryResume(Unit.INSTANCE, this.onCancellationRelease);
                            if (tryResume != null) {
                                cancellableContinuation.completeResume(tryResume);
                                z = true;
                            }
                        } else if (andSet instanceof SelectInstance) {
                            z = ((SelectInstance) andSet).trySelect(this, Unit.INSTANCE);
                        } else {
                            throw new IllegalStateException(("unexpected: " + andSet).toString());
                        }
                    }
                }
                z = false;
            } else {
                do {
                    r2 = atomicIntegerFieldUpdater.get(this);
                    if (r2 <= r3) {
                        break;
                    }
                } while (!atomicIntegerFieldUpdater.compareAndSet(this, r2, r3));
                throw new IllegalStateException(("The number of released permits cannot be greater than " + r3).toString());
            }
        } while (!z);
    }

    public final void acquire(CancellableContinuation<? super Unit> cancellableContinuation) {
        while (true) {
            int andDecrement = _availablePermits$FU.getAndDecrement(this);
            if (andDecrement <= this.permits) {
                if (andDecrement > 0) {
                    cancellableContinuation.resume(Unit.INSTANCE, this.onCancellationRelease);
                    return;
                } else if (addAcquireToQueue((Waiter) cancellableContinuation)) {
                    return;
                }
            }
        }
    }
}
