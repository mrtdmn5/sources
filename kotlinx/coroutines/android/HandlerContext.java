package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import androidx.compose.ui.tooling.ComposableInvoker$$ExternalSyntheticOutline0;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.NonDisposableHandle;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* compiled from: HandlerDispatcher.kt */
/* loaded from: classes4.dex */
public final class HandlerContext extends HandlerDispatcher {
    private volatile HandlerContext _immediate;
    public final Handler handler;
    public final HandlerContext immediate;
    public final boolean invokeImmediately;
    public final String name;

    public HandlerContext() {
        throw null;
    }

    public HandlerContext(Handler handler, String str, boolean z) {
        this.handler = handler;
        this.name = str;
        this.invokeImmediately = z;
        this._immediate = z ? this : null;
        HandlerContext handlerContext = this._immediate;
        if (handlerContext == null) {
            handlerContext = new HandlerContext(handler, str, true);
            this._immediate = handlerContext;
        }
        this.immediate = handlerContext;
    }

    public final void cancelOnRejection(CoroutineContext coroutineContext, Runnable runnable) {
        JobKt.cancel(coroutineContext, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        Dispatchers.IO.dispatch(coroutineContext, runnable);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        if (!this.handler.post(runnable)) {
            cancelOnRejection(coroutineContext, runnable);
        }
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof HandlerContext) && ((HandlerContext) obj).handler == this.handler) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher
    public final MainCoroutineDispatcher getImmediate() {
        return this.immediate;
    }

    public final int hashCode() {
        return System.identityHashCode(this.handler);
    }

    @Override // kotlinx.coroutines.android.HandlerDispatcher, kotlinx.coroutines.Delay
    public final DisposableHandle invokeOnTimeout(long j, final Runnable runnable, CoroutineContext coroutineContext) {
        if (j > 4611686018427387903L) {
            j = 4611686018427387903L;
        }
        if (this.handler.postDelayed(runnable, j)) {
            return new DisposableHandle() { // from class: kotlinx.coroutines.android.HandlerContext$$ExternalSyntheticLambda0
                @Override // kotlinx.coroutines.DisposableHandle
                public final void dispose() {
                    HandlerContext.this.handler.removeCallbacks(runnable);
                }
            };
        }
        cancelOnRejection(coroutineContext, runnable);
        return NonDisposableHandle.INSTANCE;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        if (this.invokeImmediately && Intrinsics.areEqual(Looper.myLooper(), this.handler.getLooper())) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlinx.coroutines.android.HandlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1, java.lang.Runnable] */
    @Override // kotlinx.coroutines.Delay
    public final void scheduleResumeAfterDelay(long j, final CancellableContinuationImpl cancellableContinuationImpl) {
        final ?? r0 = new Runnable() { // from class: kotlinx.coroutines.android.HandlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                cancellableContinuationImpl.resumeUndispatched(this, Unit.INSTANCE);
            }
        };
        if (j > 4611686018427387903L) {
            j = 4611686018427387903L;
        }
        if (this.handler.postDelayed(r0, j)) {
            cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.android.HandlerContext$scheduleResumeAfterDelay$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Throwable th) {
                    HandlerContext.this.handler.removeCallbacks(r0);
                    return Unit.INSTANCE;
                }
            });
        } else {
            cancelOnRejection(cancellableContinuationImpl.context, r0);
        }
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher, kotlinx.coroutines.CoroutineDispatcher
    public final String toString() {
        MainCoroutineDispatcher mainCoroutineDispatcher;
        String str;
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        MainCoroutineDispatcher mainCoroutineDispatcher2 = MainDispatcherLoader.dispatcher;
        if (this == mainCoroutineDispatcher2) {
            str = "Dispatchers.Main";
        } else {
            try {
                mainCoroutineDispatcher = mainCoroutineDispatcher2.getImmediate();
            } catch (UnsupportedOperationException unused) {
                mainCoroutineDispatcher = null;
            }
            if (this == mainCoroutineDispatcher) {
                str = "Dispatchers.Main.immediate";
            } else {
                str = null;
            }
        }
        if (str == null) {
            String str2 = this.name;
            if (str2 == null) {
                str2 = this.handler.toString();
            }
            if (this.invokeImmediately) {
                return ComposableInvoker$$ExternalSyntheticOutline0.m(str2, ".immediate");
            }
            return str2;
        }
        return str;
    }

    public HandlerContext(Handler handler) {
        this(handler, null, false);
    }
}
