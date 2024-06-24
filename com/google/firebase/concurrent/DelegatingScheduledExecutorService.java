package com.google.firebase.concurrent;

import androidx.concurrent.futures.AbstractResolvableFuture;
import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes3.dex */
public final class DelegatingScheduledExecutorService implements ScheduledExecutorService {
    public final ExecutorService delegate;
    public final ScheduledExecutorService scheduler;

    public DelegatingScheduledExecutorService(ExecutorService executorService, ScheduledExecutorService scheduledExecutorService) {
        this.delegate = executorService;
        this.scheduler = scheduledExecutorService;
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.delegate.awaitTermination(j, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.delegate.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.delegate.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> T invokeAny(Collection<? extends Callable<T>> collection) throws ExecutionException, InterruptedException {
        return (T) this.delegate.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isShutdown() {
        return this.delegate.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isTerminated() {
        return this.delegate.isTerminated();
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture<?> schedule(final Runnable runnable, final long j, final TimeUnit timeUnit) {
        return new DelegatingScheduledFuture(new DelegatingScheduledFuture.Resolver() { // from class: com.google.firebase.concurrent.DelegatingScheduledExecutorService$$ExternalSyntheticLambda1
            @Override // com.google.firebase.concurrent.DelegatingScheduledFuture.Resolver
            public final ScheduledFuture addCompleter(final DelegatingScheduledFuture.AnonymousClass1 anonymousClass1) {
                final DelegatingScheduledExecutorService delegatingScheduledExecutorService = DelegatingScheduledExecutorService.this;
                delegatingScheduledExecutorService.getClass();
                final Runnable runnable2 = runnable;
                return delegatingScheduledExecutorService.scheduler.schedule(new Runnable() { // from class: com.google.firebase.concurrent.DelegatingScheduledExecutorService$$ExternalSyntheticLambda6
                    @Override // java.lang.Runnable
                    public final void run() {
                        DelegatingScheduledExecutorService delegatingScheduledExecutorService2 = DelegatingScheduledExecutorService.this;
                        delegatingScheduledExecutorService2.getClass();
                        final Runnable runnable3 = runnable2;
                        final DelegatingScheduledFuture.Completer completer = anonymousClass1;
                        delegatingScheduledExecutorService2.delegate.execute(new Runnable() { // from class: com.google.firebase.concurrent.DelegatingScheduledExecutorService$$ExternalSyntheticLambda10
                            @Override // java.lang.Runnable
                            public final void run() {
                                Runnable runnable4 = runnable3;
                                DelegatingScheduledFuture.Completer completer2 = completer;
                                try {
                                    runnable4.run();
                                    DelegatingScheduledFuture delegatingScheduledFuture = DelegatingScheduledFuture.this;
                                    delegatingScheduledFuture.getClass();
                                    if (AbstractResolvableFuture.ATOMIC_HELPER.casValue(delegatingScheduledFuture, null, AbstractResolvableFuture.NULL)) {
                                        AbstractResolvableFuture.complete(delegatingScheduledFuture);
                                    }
                                } catch (Exception e) {
                                    ((DelegatingScheduledFuture.AnonymousClass1) completer2).setException(e);
                                }
                            }
                        });
                    }
                }, j, timeUnit);
            }
        });
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture<?> scheduleAtFixedRate(final Runnable runnable, final long j, final long j2, final TimeUnit timeUnit) {
        return new DelegatingScheduledFuture(new DelegatingScheduledFuture.Resolver() { // from class: com.google.firebase.concurrent.DelegatingScheduledExecutorService$$ExternalSyntheticLambda3
            @Override // com.google.firebase.concurrent.DelegatingScheduledFuture.Resolver
            public final ScheduledFuture addCompleter(final DelegatingScheduledFuture.AnonymousClass1 anonymousClass1) {
                long j3 = j;
                long j4 = j2;
                TimeUnit timeUnit2 = timeUnit;
                final DelegatingScheduledExecutorService delegatingScheduledExecutorService = DelegatingScheduledExecutorService.this;
                ScheduledExecutorService scheduledExecutorService = delegatingScheduledExecutorService.scheduler;
                final Runnable runnable2 = runnable;
                return scheduledExecutorService.scheduleAtFixedRate(new Runnable() { // from class: com.google.firebase.concurrent.DelegatingScheduledExecutorService$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        DelegatingScheduledExecutorService delegatingScheduledExecutorService2 = DelegatingScheduledExecutorService.this;
                        delegatingScheduledExecutorService2.getClass();
                        final Runnable runnable3 = runnable2;
                        final DelegatingScheduledFuture.Completer completer = anonymousClass1;
                        delegatingScheduledExecutorService2.delegate.execute(new Runnable() { // from class: com.google.firebase.concurrent.DelegatingScheduledExecutorService$$ExternalSyntheticLambda9
                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    runnable3.run();
                                } catch (Exception e) {
                                    ((DelegatingScheduledFuture.AnonymousClass1) completer).setException(e);
                                    throw e;
                                }
                            }
                        });
                    }
                }, j3, j4, timeUnit2);
            }
        });
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture<?> scheduleWithFixedDelay(final Runnable runnable, final long j, final long j2, final TimeUnit timeUnit) {
        return new DelegatingScheduledFuture(new DelegatingScheduledFuture.Resolver() { // from class: com.google.firebase.concurrent.DelegatingScheduledExecutorService$$ExternalSyntheticLambda2
            @Override // com.google.firebase.concurrent.DelegatingScheduledFuture.Resolver
            public final ScheduledFuture addCompleter(final DelegatingScheduledFuture.AnonymousClass1 anonymousClass1) {
                long j3 = j;
                long j4 = j2;
                TimeUnit timeUnit2 = timeUnit;
                final DelegatingScheduledExecutorService delegatingScheduledExecutorService = DelegatingScheduledExecutorService.this;
                ScheduledExecutorService scheduledExecutorService = delegatingScheduledExecutorService.scheduler;
                final Runnable runnable2 = runnable;
                return scheduledExecutorService.scheduleWithFixedDelay(new Runnable() { // from class: com.google.firebase.concurrent.DelegatingScheduledExecutorService$$ExternalSyntheticLambda5
                    @Override // java.lang.Runnable
                    public final void run() {
                        DelegatingScheduledExecutorService delegatingScheduledExecutorService2 = DelegatingScheduledExecutorService.this;
                        delegatingScheduledExecutorService2.getClass();
                        final Runnable runnable3 = runnable2;
                        final DelegatingScheduledFuture.Completer completer = anonymousClass1;
                        delegatingScheduledExecutorService2.delegate.execute(new Runnable() { // from class: com.google.firebase.concurrent.DelegatingScheduledExecutorService$$ExternalSyntheticLambda11
                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    runnable3.run();
                                } catch (Exception e) {
                                    ((DelegatingScheduledFuture.AnonymousClass1) completer).setException(e);
                                }
                            }
                        });
                    }
                }, j3, j4, timeUnit2);
            }
        });
    }

    @Override // java.util.concurrent.ExecutorService
    public final void shutdown() {
        throw new UnsupportedOperationException("Shutting down is not allowed.");
    }

    @Override // java.util.concurrent.ExecutorService
    public final List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException("Shutting down is not allowed.");
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> Future<T> submit(Callable<T> callable) {
        return this.delegate.submit(callable);
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException {
        return this.delegate.invokeAll(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return (T) this.delegate.invokeAny(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final <V> ScheduledFuture<V> schedule(final Callable<V> callable, final long j, final TimeUnit timeUnit) {
        return new DelegatingScheduledFuture(new DelegatingScheduledFuture.Resolver() { // from class: com.google.firebase.concurrent.DelegatingScheduledExecutorService$$ExternalSyntheticLambda0
            @Override // com.google.firebase.concurrent.DelegatingScheduledFuture.Resolver
            public final ScheduledFuture addCompleter(final DelegatingScheduledFuture.AnonymousClass1 anonymousClass1) {
                final DelegatingScheduledExecutorService delegatingScheduledExecutorService = DelegatingScheduledExecutorService.this;
                delegatingScheduledExecutorService.getClass();
                final Callable callable2 = callable;
                return delegatingScheduledExecutorService.scheduler.schedule(new Callable() { // from class: com.google.firebase.concurrent.DelegatingScheduledExecutorService$$ExternalSyntheticLambda7
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        DelegatingScheduledExecutorService delegatingScheduledExecutorService2 = DelegatingScheduledExecutorService.this;
                        delegatingScheduledExecutorService2.getClass();
                        final Callable callable3 = callable2;
                        final DelegatingScheduledFuture.Completer completer = anonymousClass1;
                        return delegatingScheduledExecutorService2.delegate.submit(new Runnable() { // from class: com.google.firebase.concurrent.DelegatingScheduledExecutorService$$ExternalSyntheticLambda8
                            @Override // java.lang.Runnable
                            public final void run() {
                                Callable callable4 = callable3;
                                DelegatingScheduledFuture.Completer completer2 = completer;
                                try {
                                    Object call = callable4.call();
                                    DelegatingScheduledFuture delegatingScheduledFuture = DelegatingScheduledFuture.this;
                                    delegatingScheduledFuture.getClass();
                                    if (call == null) {
                                        call = AbstractResolvableFuture.NULL;
                                    }
                                    if (AbstractResolvableFuture.ATOMIC_HELPER.casValue(delegatingScheduledFuture, null, call)) {
                                        AbstractResolvableFuture.complete(delegatingScheduledFuture);
                                    }
                                } catch (Exception e) {
                                    ((DelegatingScheduledFuture.AnonymousClass1) completer2).setException(e);
                                }
                            }
                        });
                    }
                }, j, timeUnit);
            }
        });
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> Future<T> submit(Runnable runnable, T t) {
        return this.delegate.submit(runnable, t);
    }

    @Override // java.util.concurrent.ExecutorService
    public final Future<?> submit(Runnable runnable) {
        return this.delegate.submit(runnable);
    }
}
