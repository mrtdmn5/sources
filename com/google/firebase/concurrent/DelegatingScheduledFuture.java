package com.google.firebase.concurrent;

import android.annotation.SuppressLint;
import androidx.concurrent.futures.AbstractResolvableFuture;
import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes3.dex */
public final class DelegatingScheduledFuture<V> extends AbstractResolvableFuture<V> implements ScheduledFuture<V> {
    public final ScheduledFuture<?> upstreamFuture;

    /* renamed from: com.google.firebase.concurrent.DelegatingScheduledFuture$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements Completer<V> {
        public AnonymousClass1() {
        }

        public final void setException(Exception exc) {
            DelegatingScheduledFuture delegatingScheduledFuture = DelegatingScheduledFuture.this;
            delegatingScheduledFuture.getClass();
            if (AbstractResolvableFuture.ATOMIC_HELPER.casValue(delegatingScheduledFuture, null, new AbstractResolvableFuture.Failure(exc))) {
                AbstractResolvableFuture.complete(delegatingScheduledFuture);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface Completer<T> {
    }

    /* loaded from: classes3.dex */
    public interface Resolver<T> {
        ScheduledFuture addCompleter(AnonymousClass1 anonymousClass1);
    }

    public DelegatingScheduledFuture(Resolver<V> resolver) {
        this.upstreamFuture = resolver.addCompleter(new AnonymousClass1());
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture
    public final void afterDone() {
        boolean z;
        ScheduledFuture<?> scheduledFuture = this.upstreamFuture;
        Object obj = this.value;
        if ((obj instanceof AbstractResolvableFuture.Cancellation) && ((AbstractResolvableFuture.Cancellation) obj).wasInterrupted) {
            z = true;
        } else {
            z = false;
        }
        scheduledFuture.cancel(z);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Delayed delayed) {
        return this.upstreamFuture.compareTo(delayed);
    }

    @Override // java.util.concurrent.Delayed
    public final long getDelay(TimeUnit timeUnit) {
        return this.upstreamFuture.getDelay(timeUnit);
    }
}
