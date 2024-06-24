package androidx.compose.runtime;

import androidx.compose.runtime.BroadcastFrameClock;
import java.util.ArrayList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CancellableContinuationImpl;

/* compiled from: BroadcastFrameClock.kt */
/* loaded from: classes.dex */
public final class BroadcastFrameClock implements MonotonicFrameClock {
    public Throwable failureCause;
    public final Function0<Unit> onNewAwaiters;
    public final Object lock = new Object();
    public List<FrameAwaiter<?>> awaiters = new ArrayList();
    public List<FrameAwaiter<?>> spareList = new ArrayList();

    /* compiled from: BroadcastFrameClock.kt */
    /* loaded from: classes.dex */
    public static final class FrameAwaiter<R> {
        public final Continuation<R> continuation;
        public final Function1<Long, R> onFrame;

        public FrameAwaiter(Function1 onFrame, CancellableContinuationImpl cancellableContinuationImpl) {
            Intrinsics.checkNotNullParameter(onFrame, "onFrame");
            this.onFrame = onFrame;
            this.continuation = cancellableContinuationImpl;
        }
    }

    public BroadcastFrameClock(Recomposer$broadcastFrameClock$1 recomposer$broadcastFrameClock$1) {
        this.onNewAwaiters = recomposer$broadcastFrameClock$1;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        return operation.invoke(r, this);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (E) CoroutineContext.Element.DefaultImpls.get(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return CoroutineContext.Element.DefaultImpls.minusKey(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext plus(CoroutineContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return CoroutineContext.DefaultImpls.plus(this, context);
    }

    public final void sendFrame(long j) {
        Object createFailure;
        synchronized (this.lock) {
            List<FrameAwaiter<?>> list = this.awaiters;
            this.awaiters = this.spareList;
            this.spareList = list;
            int size = list.size();
            for (int r3 = 0; r3 < size; r3++) {
                FrameAwaiter<?> frameAwaiter = list.get(r3);
                frameAwaiter.getClass();
                try {
                    createFailure = frameAwaiter.onFrame.invoke(Long.valueOf(j));
                } catch (Throwable th) {
                    createFailure = ResultKt.createFailure(th);
                }
                frameAwaiter.continuation.resumeWith(createFailure);
            }
            list.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [T, androidx.compose.runtime.BroadcastFrameClock$FrameAwaiter] */
    @Override // androidx.compose.runtime.MonotonicFrameClock
    public final <R> Object withFrameNanos(Function1<? super Long, ? extends R> function1, Continuation<? super R> continuation) {
        boolean z;
        Function0<Unit> function0;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        cancellableContinuationImpl.initCancellability();
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        synchronized (this.lock) {
            Throwable th = this.failureCause;
            if (th != null) {
                cancellableContinuationImpl.resumeWith(ResultKt.createFailure(th));
            } else {
                ref$ObjectRef.element = new FrameAwaiter(function1, cancellableContinuationImpl);
                if (!this.awaiters.isEmpty()) {
                    z = true;
                } else {
                    z = false;
                }
                List<FrameAwaiter<?>> list = this.awaiters;
                T t = ref$ObjectRef.element;
                if (t != 0) {
                    list.add((FrameAwaiter) t);
                    boolean z2 = !z;
                    cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.compose.runtime.BroadcastFrameClock$withFrameNanos$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(Throwable th2) {
                            BroadcastFrameClock broadcastFrameClock = BroadcastFrameClock.this;
                            Object obj = broadcastFrameClock.lock;
                            Ref$ObjectRef<BroadcastFrameClock.FrameAwaiter<R>> ref$ObjectRef2 = ref$ObjectRef;
                            synchronized (obj) {
                                List<BroadcastFrameClock.FrameAwaiter<?>> list2 = broadcastFrameClock.awaiters;
                                T t2 = ref$ObjectRef2.element;
                                if (t2 != 0) {
                                    list2.remove((BroadcastFrameClock.FrameAwaiter) t2);
                                } else {
                                    Intrinsics.throwUninitializedPropertyAccessException("awaiter");
                                    throw null;
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    });
                    if (z2 && (function0 = this.onNewAwaiters) != null) {
                        try {
                            function0.invoke();
                        } catch (Throwable th2) {
                            synchronized (this.lock) {
                                if (this.failureCause == null) {
                                    this.failureCause = th2;
                                    List<FrameAwaiter<?>> list2 = this.awaiters;
                                    int size = list2.size();
                                    for (int r3 = 0; r3 < size; r3++) {
                                        list2.get(r3).continuation.resumeWith(ResultKt.createFailure(th2));
                                    }
                                    this.awaiters.clear();
                                    Unit unit = Unit.INSTANCE;
                                }
                            }
                        }
                    }
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("awaiter");
                    throw null;
                }
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return result;
    }
}
