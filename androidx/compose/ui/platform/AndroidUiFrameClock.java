package androidx.compose.ui.platform;

import android.view.Choreographer;
import androidx.compose.runtime.MonotonicFrameClock;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* compiled from: AndroidUiFrameClock.android.kt */
/* loaded from: classes.dex */
public final class AndroidUiFrameClock implements MonotonicFrameClock {
    public final Choreographer choreographer;
    public final AndroidUiDispatcher dispatcher;

    public AndroidUiFrameClock(Choreographer choreographer, AndroidUiDispatcher androidUiDispatcher) {
        this.choreographer = choreographer;
        this.dispatcher = androidUiDispatcher;
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2, types: [androidx.compose.ui.platform.AndroidUiFrameClock$withFrameNanos$2$callback$1, java.lang.Object, android.view.Choreographer$FrameCallback] */
    @Override // androidx.compose.runtime.MonotonicFrameClock
    public final <R> Object withFrameNanos(final Function1<? super Long, ? extends R> function1, Continuation<? super R> continuation) {
        final AndroidUiDispatcher androidUiDispatcher = this.dispatcher;
        if (androidUiDispatcher == null) {
            CoroutineContext.Element element = continuation.getContext().get(ContinuationInterceptor.Key.$$INSTANCE);
            if (element instanceof AndroidUiDispatcher) {
                androidUiDispatcher = (AndroidUiDispatcher) element;
            } else {
                androidUiDispatcher = null;
            }
        }
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        cancellableContinuationImpl.initCancellability();
        final ?? r6 = new Choreographer.FrameCallback(cancellableContinuationImpl, this, function1) { // from class: androidx.compose.ui.platform.AndroidUiFrameClock$withFrameNanos$2$callback$1
            public final /* synthetic */ CancellableContinuation<R> $co;
            public final /* synthetic */ Function1<Long, R> $onFrame;

            {
                this.$onFrame = function1;
            }

            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j) {
                Object createFailure;
                try {
                    createFailure = this.$onFrame.invoke(Long.valueOf(j));
                } catch (Throwable th) {
                    createFailure = ResultKt.createFailure(th);
                }
                this.$co.resumeWith(createFailure);
            }
        };
        if (androidUiDispatcher != null && Intrinsics.areEqual(androidUiDispatcher.choreographer, this.choreographer)) {
            synchronized (androidUiDispatcher.lock) {
                androidUiDispatcher.toRunOnFrame.add(r6);
                if (!androidUiDispatcher.scheduledFrameDispatch) {
                    androidUiDispatcher.scheduledFrameDispatch = true;
                    androidUiDispatcher.choreographer.postFrameCallback(androidUiDispatcher.dispatchCallback);
                }
                Unit unit = Unit.INSTANCE;
            }
            cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.compose.ui.platform.AndroidUiFrameClock$withFrameNanos$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Throwable th) {
                    AndroidUiDispatcher androidUiDispatcher2 = AndroidUiDispatcher.this;
                    Choreographer.FrameCallback callback = r6;
                    androidUiDispatcher2.getClass();
                    Intrinsics.checkNotNullParameter(callback, "callback");
                    synchronized (androidUiDispatcher2.lock) {
                        androidUiDispatcher2.toRunOnFrame.remove(callback);
                    }
                    return Unit.INSTANCE;
                }
            });
        } else {
            this.choreographer.postFrameCallback(r6);
            cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.compose.ui.platform.AndroidUiFrameClock$withFrameNanos$2$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Throwable th) {
                    AndroidUiFrameClock.this.choreographer.removeFrameCallback(r6);
                    return Unit.INSTANCE;
                }
            });
        }
        Object result = cancellableContinuationImpl.getResult();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return result;
    }
}
