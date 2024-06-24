package androidx.work;

import androidx.work.impl.utils.futures.AbstractFuture;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobImpl;

/* compiled from: ListenableFuture.kt */
/* loaded from: classes.dex */
public final class JobListenableFuture<R> implements ListenableFuture<R> {
    public final Job job;
    public final SettableFuture<R> underlying;

    public JobListenableFuture(JobImpl jobImpl) {
        SettableFuture<R> settableFuture = new SettableFuture<>();
        this.job = jobImpl;
        this.underlying = settableFuture;
        jobImpl.invokeOnCompletion(new Function1<Throwable, Unit>(this) { // from class: androidx.work.JobListenableFuture.1
            public final /* synthetic */ JobListenableFuture<Object> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Throwable th) {
                Throwable th2 = th;
                JobListenableFuture<Object> jobListenableFuture = this.this$0;
                if (th2 == null) {
                    if (!jobListenableFuture.underlying.isDone()) {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                } else if (th2 instanceof CancellationException) {
                    jobListenableFuture.underlying.cancel(true);
                } else {
                    SettableFuture<Object> settableFuture2 = jobListenableFuture.underlying;
                    Throwable cause = th2.getCause();
                    if (cause != null) {
                        th2 = cause;
                    }
                    settableFuture2.setException(th2);
                }
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public final void addListener(Runnable runnable, Executor executor) {
        this.underlying.addListener(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        return this.underlying.cancel(z);
    }

    @Override // java.util.concurrent.Future
    public final R get() {
        return this.underlying.get();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.underlying.value instanceof AbstractFuture.Cancellation;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.underlying.isDone();
    }

    @Override // java.util.concurrent.Future
    public final R get(long j, TimeUnit timeUnit) {
        return this.underlying.get(j, timeUnit);
    }
}
