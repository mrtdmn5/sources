package io.ktor.utils.io.jvm.javaio;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;

/* compiled from: Blocking.kt */
/* loaded from: classes3.dex */
public final class BlockingAdapter$end$1 implements Continuation<Unit> {
    public final CoroutineContext context;
    public final /* synthetic */ BlockingAdapter this$0;

    public BlockingAdapter$end$1(BlockingAdapter blockingAdapter) {
        CoroutineContext coroutineContext;
        this.this$0 = blockingAdapter;
        Job job = blockingAdapter.parent;
        if (job != null) {
            coroutineContext = UnsafeBlockingTrampoline.INSTANCE.plus(job);
        } else {
            coroutineContext = UnsafeBlockingTrampoline.INSTANCE;
        }
        this.context = coroutineContext;
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return this.context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        Object obj2;
        boolean z;
        boolean z2;
        boolean z3;
        boolean areEqual;
        Throwable m1661exceptionOrNullimpl;
        Job job;
        Object m1661exceptionOrNullimpl2 = Result.m1661exceptionOrNullimpl(obj);
        if (m1661exceptionOrNullimpl2 == null) {
            m1661exceptionOrNullimpl2 = Unit.INSTANCE;
        }
        BlockingAdapter blockingAdapter = this.this$0;
        do {
            obj2 = blockingAdapter.state;
            z = obj2 instanceof Thread;
            z2 = true;
            if (z) {
                z3 = true;
            } else {
                z3 = obj2 instanceof Continuation;
            }
            if (z3) {
                areEqual = true;
            } else {
                areEqual = Intrinsics.areEqual(obj2, this);
            }
            if (areEqual) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = BlockingAdapter.state$FU;
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(blockingAdapter, obj2, m1661exceptionOrNullimpl2)) {
                        break;
                    } else if (atomicReferenceFieldUpdater.get(blockingAdapter) != obj2) {
                        z2 = false;
                        break;
                    }
                }
            } else {
                return;
            }
        } while (!z2);
        if (z) {
            PollersKt.getParkingImpl().unpark(obj2);
        } else if ((obj2 instanceof Continuation) && (m1661exceptionOrNullimpl = Result.m1661exceptionOrNullimpl(obj)) != null) {
            ((Continuation) obj2).resumeWith(ResultKt.createFailure(m1661exceptionOrNullimpl));
        }
        if ((obj instanceof Result.Failure) && !(Result.m1661exceptionOrNullimpl(obj) instanceof CancellationException) && (job = this.this$0.parent) != null) {
            job.cancel(null);
        }
        DisposableHandle disposableHandle = this.this$0.disposable;
        if (disposableHandle != null) {
            disposableHandle.dispose();
        }
    }
}
