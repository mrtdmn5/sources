package io.ktor.utils.io;

import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ChildHandle;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.StandaloneCoroutine;

/* compiled from: Coroutines.kt */
/* loaded from: classes3.dex */
public final class ChannelJob implements Job {
    public final ByteChannel channel;
    public final Job delegate;

    public ChannelJob(StandaloneCoroutine standaloneCoroutine, ByteBufferChannel byteBufferChannel) {
        this.delegate = standaloneCoroutine;
        this.channel = byteBufferChannel;
    }

    @Override // kotlinx.coroutines.Job
    public final ChildHandle attachChild(JobSupport jobSupport) {
        return this.delegate.attachChild(jobSupport);
    }

    @Override // kotlinx.coroutines.Job
    public final void cancel(CancellationException cancellationException) {
        this.delegate.cancel(cancellationException);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        return (R) this.delegate.fold(r, operation);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (E) this.delegate.get(key);
    }

    @Override // kotlinx.coroutines.Job
    public final CancellationException getCancellationException() {
        return this.delegate.getCancellationException();
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key<?> getKey() {
        return this.delegate.getKey();
    }

    @Override // kotlinx.coroutines.Job
    public final DisposableHandle invokeOnCompletion(Function1<? super Throwable, Unit> function1) {
        return this.delegate.invokeOnCompletion(function1);
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isActive() {
        return this.delegate.isActive();
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCancelled() {
        return this.delegate.isCancelled();
    }

    @Override // kotlinx.coroutines.Job
    public final Object join(Continuation<? super Unit> continuation) {
        return this.delegate.join(continuation);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.delegate.minusKey(key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext plus(CoroutineContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.delegate.plus(context);
    }

    @Override // kotlinx.coroutines.Job
    public final boolean start() {
        return this.delegate.start();
    }

    public final String toString() {
        return "ChannelJob[" + this.delegate + ']';
    }

    @Override // kotlinx.coroutines.Job
    public final DisposableHandle invokeOnCompletion(boolean z, boolean z2, Function1<? super Throwable, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        return this.delegate.invokeOnCompletion(z, z2, handler);
    }
}
