package kotlinx.coroutines;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.Symbol;

/* compiled from: Await.kt */
/* loaded from: classes4.dex */
public final class AwaitAll<T> {
    public static final AtomicIntegerFieldUpdater notCompletedCount$FU = AtomicIntegerFieldUpdater.newUpdater(AwaitAll.class, "notCompletedCount");
    public final Deferred<T>[] deferreds;
    private volatile int notCompletedCount;

    /* compiled from: Await.kt */
    /* loaded from: classes4.dex */
    public final class AwaitAllNode extends JobNode {
        public static final AtomicReferenceFieldUpdater _disposer$FU = AtomicReferenceFieldUpdater.newUpdater(AwaitAllNode.class, Object.class, "_disposer");
        private volatile Object _disposer;
        public final CancellableContinuation<List<? extends T>> continuation;
        public DisposableHandle handle;

        public AwaitAllNode(CancellableContinuationImpl cancellableContinuationImpl) {
            this.continuation = cancellableContinuationImpl;
        }

        @Override // kotlin.jvm.functions.Function1
        public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.CompletionHandlerBase
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            CancellableContinuation<List<? extends T>> cancellableContinuation = this.continuation;
            if (th != null) {
                Symbol tryResumeWithException = cancellableContinuation.tryResumeWithException(th);
                if (tryResumeWithException != null) {
                    cancellableContinuation.completeResume(tryResumeWithException);
                    DisposeHandlersOnCancel disposeHandlersOnCancel = (DisposeHandlersOnCancel) _disposer$FU.get(this);
                    if (disposeHandlersOnCancel != null) {
                        disposeHandlersOnCancel.disposeAll();
                        return;
                    }
                    return;
                }
                return;
            }
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = AwaitAll.notCompletedCount$FU;
            AwaitAll<T> awaitAll = AwaitAll.this;
            if (atomicIntegerFieldUpdater.decrementAndGet(awaitAll) == 0) {
                Deferred<T>[] deferredArr = awaitAll.deferreds;
                ArrayList arrayList = new ArrayList(deferredArr.length);
                for (Deferred<T> deferred : deferredArr) {
                    arrayList.add(deferred.getCompleted());
                }
                cancellableContinuation.resumeWith(arrayList);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AwaitAll(Deferred<? extends T>[] deferredArr) {
        this.deferreds = deferredArr;
        this.notCompletedCount = deferredArr.length;
    }

    /* compiled from: Await.kt */
    /* loaded from: classes4.dex */
    public final class DisposeHandlersOnCancel extends CancelHandler {
        public final AwaitAll<T>.AwaitAllNode[] nodes;

        public DisposeHandlersOnCancel(AwaitAllNode[] awaitAllNodeArr) {
            this.nodes = awaitAllNodeArr;
        }

        public final void disposeAll() {
            for (AwaitAll<T>.AwaitAllNode awaitAllNode : this.nodes) {
                DisposableHandle disposableHandle = awaitAllNode.handle;
                if (disposableHandle != null) {
                    disposableHandle.dispose();
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("handle");
                    throw null;
                }
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Throwable th) {
            disposeAll();
            return Unit.INSTANCE;
        }

        public final String toString() {
            return "DisposeHandlersOnCancel[" + this.nodes + ']';
        }

        @Override // kotlinx.coroutines.CancelHandlerBase
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            disposeAll();
        }
    }
}
