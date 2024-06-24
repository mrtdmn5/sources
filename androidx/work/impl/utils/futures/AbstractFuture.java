package androidx.work.impl.utils.futures;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class AbstractFuture<V> implements ListenableFuture<V> {
    public static final AtomicHelper ATOMIC_HELPER;
    public static final Object NULL;
    public volatile Listener listeners;
    public volatile Object value;
    public volatile Waiter waiters;
    public static final boolean GENERATE_CANCELLATION_CAUSES = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    public static final Logger log = Logger.getLogger(AbstractFuture.class.getName());

    /* loaded from: classes.dex */
    public static abstract class AtomicHelper {
        public abstract boolean casListeners(AbstractFuture<?> future, Listener expect, Listener update);

        public abstract boolean casValue(AbstractFuture<?> future, Object expect, Object update);

        public abstract boolean casWaiters(AbstractFuture<?> future, Waiter expect, Waiter update);

        public abstract void putNext(Waiter waiter, Waiter newValue);

        public abstract void putThread(Waiter waiter, Thread newValue);
    }

    /* loaded from: classes.dex */
    public static final class Cancellation {
        public static final Cancellation CAUSELESS_CANCELLED;
        public static final Cancellation CAUSELESS_INTERRUPTED;
        public final Throwable cause;
        public final boolean wasInterrupted;

        static {
            if (AbstractFuture.GENERATE_CANCELLATION_CAUSES) {
                CAUSELESS_CANCELLED = null;
                CAUSELESS_INTERRUPTED = null;
            } else {
                CAUSELESS_CANCELLED = new Cancellation(null, false);
                CAUSELESS_INTERRUPTED = new Cancellation(null, true);
            }
        }

        public Cancellation(Throwable wasInterrupted, boolean cause) {
            this.wasInterrupted = cause;
            this.cause = wasInterrupted;
        }
    }

    /* loaded from: classes.dex */
    public static final class Failure {
        public static final Failure FALLBACK_INSTANCE = new Failure(new Throwable() { // from class: androidx.work.impl.utils.futures.AbstractFuture.Failure.1
            @Override // java.lang.Throwable
            public final synchronized Throwable fillInStackTrace() {
                return this;
            }
        });
        public final Throwable exception;

        public Failure(Throwable exception) {
            boolean z = AbstractFuture.GENERATE_CANCELLATION_CAUSES;
            exception.getClass();
            this.exception = exception;
        }
    }

    /* loaded from: classes.dex */
    public static final class Listener {
        public static final Listener TOMBSTONE = new Listener(null, null);
        public final Executor executor;
        public Listener next;
        public final Runnable task;

        public Listener(Runnable task, Executor executor) {
            this.task = task;
            this.executor = executor;
        }
    }

    /* loaded from: classes.dex */
    public static final class SafeAtomicHelper extends AtomicHelper {
        public final AtomicReferenceFieldUpdater<AbstractFuture, Listener> listenersUpdater;
        public final AtomicReferenceFieldUpdater<AbstractFuture, Object> valueUpdater;
        public final AtomicReferenceFieldUpdater<Waiter, Waiter> waiterNextUpdater;
        public final AtomicReferenceFieldUpdater<Waiter, Thread> waiterThreadUpdater;
        public final AtomicReferenceFieldUpdater<AbstractFuture, Waiter> waitersUpdater;

        public SafeAtomicHelper(AtomicReferenceFieldUpdater<Waiter, Thread> waiterThreadUpdater, AtomicReferenceFieldUpdater<Waiter, Waiter> waiterNextUpdater, AtomicReferenceFieldUpdater<AbstractFuture, Waiter> waitersUpdater, AtomicReferenceFieldUpdater<AbstractFuture, Listener> listenersUpdater, AtomicReferenceFieldUpdater<AbstractFuture, Object> valueUpdater) {
            this.waiterThreadUpdater = waiterThreadUpdater;
            this.waiterNextUpdater = waiterNextUpdater;
            this.waitersUpdater = waitersUpdater;
            this.listenersUpdater = listenersUpdater;
            this.valueUpdater = valueUpdater;
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        public final boolean casListeners(AbstractFuture<?> future, Listener expect, Listener update) {
            AtomicReferenceFieldUpdater<AbstractFuture, Listener> atomicReferenceFieldUpdater;
            do {
                atomicReferenceFieldUpdater = this.listenersUpdater;
                if (atomicReferenceFieldUpdater.compareAndSet(future, expect, update)) {
                    return true;
                }
            } while (atomicReferenceFieldUpdater.get(future) == expect);
            return false;
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        public final boolean casValue(AbstractFuture<?> future, Object expect, Object update) {
            AtomicReferenceFieldUpdater<AbstractFuture, Object> atomicReferenceFieldUpdater;
            do {
                atomicReferenceFieldUpdater = this.valueUpdater;
                if (atomicReferenceFieldUpdater.compareAndSet(future, expect, update)) {
                    return true;
                }
            } while (atomicReferenceFieldUpdater.get(future) == expect);
            return false;
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        public final boolean casWaiters(AbstractFuture<?> future, Waiter expect, Waiter update) {
            AtomicReferenceFieldUpdater<AbstractFuture, Waiter> atomicReferenceFieldUpdater;
            do {
                atomicReferenceFieldUpdater = this.waitersUpdater;
                if (atomicReferenceFieldUpdater.compareAndSet(future, expect, update)) {
                    return true;
                }
            } while (atomicReferenceFieldUpdater.get(future) == expect);
            return false;
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        public final void putNext(Waiter waiter, Waiter newValue) {
            this.waiterNextUpdater.lazySet(waiter, newValue);
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        public final void putThread(Waiter waiter, Thread newValue) {
            this.waiterThreadUpdater.lazySet(waiter, newValue);
        }
    }

    /* loaded from: classes.dex */
    public static final class SetFuture<V> implements Runnable {
        public final ListenableFuture<? extends V> future;
        public final AbstractFuture<V> owner;

        public SetFuture(AbstractFuture<V> owner, ListenableFuture<? extends V> future) {
            this.owner = owner;
            this.future = future;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.owner.value != this) {
                return;
            }
            if (AbstractFuture.ATOMIC_HELPER.casValue(this.owner, this, AbstractFuture.getFutureValue(this.future))) {
                AbstractFuture.complete(this.owner);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class SynchronizedHelper extends AtomicHelper {
        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        public final boolean casListeners(AbstractFuture<?> future, Listener expect, Listener update) {
            synchronized (future) {
                if (future.listeners == expect) {
                    future.listeners = update;
                    return true;
                }
                return false;
            }
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        public final boolean casValue(AbstractFuture<?> future, Object expect, Object update) {
            synchronized (future) {
                if (future.value == expect) {
                    future.value = update;
                    return true;
                }
                return false;
            }
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        public final boolean casWaiters(AbstractFuture<?> future, Waiter expect, Waiter update) {
            synchronized (future) {
                if (future.waiters == expect) {
                    future.waiters = update;
                    return true;
                }
                return false;
            }
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        public final void putNext(Waiter waiter, Waiter newValue) {
            waiter.next = newValue;
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        public final void putThread(Waiter waiter, Thread newValue) {
            waiter.thread = newValue;
        }
    }

    /* loaded from: classes.dex */
    public static final class Waiter {
        public static final Waiter TOMBSTONE = new Waiter(0);
        public volatile Waiter next;
        public volatile Thread thread;

        public Waiter(int unused) {
        }

        public Waiter() {
            AbstractFuture.ATOMIC_HELPER.putThread(this, Thread.currentThread());
        }
    }

    static {
        AtomicHelper synchronizedHelper;
        try {
            synchronizedHelper = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Thread.class, "thread"), AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Waiter.class, "next"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Waiter.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Listener.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Object.class, "value"));
            th = null;
        } catch (Throwable th) {
            th = th;
            synchronizedHelper = new SynchronizedHelper();
        }
        ATOMIC_HELPER = synchronizedHelper;
        if (th != null) {
            log.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        NULL = new Object();
    }

    public static void complete(AbstractFuture<?> abstractFuture) {
        Listener listener;
        Listener listener2;
        Listener listener3 = null;
        while (true) {
            Waiter waiter = abstractFuture.waiters;
            if (ATOMIC_HELPER.casWaiters(abstractFuture, waiter, Waiter.TOMBSTONE)) {
                while (waiter != null) {
                    Thread thread = waiter.thread;
                    if (thread != null) {
                        waiter.thread = null;
                        LockSupport.unpark(thread);
                    }
                    waiter = waiter.next;
                }
                do {
                    listener = abstractFuture.listeners;
                } while (!ATOMIC_HELPER.casListeners(abstractFuture, listener, Listener.TOMBSTONE));
                while (true) {
                    listener2 = listener3;
                    listener3 = listener;
                    if (listener3 == null) {
                        break;
                    }
                    listener = listener3.next;
                    listener3.next = listener2;
                }
                while (listener2 != null) {
                    listener3 = listener2.next;
                    Runnable runnable = listener2.task;
                    if (runnable instanceof SetFuture) {
                        SetFuture setFuture = (SetFuture) runnable;
                        abstractFuture = setFuture.owner;
                        if (abstractFuture.value == setFuture) {
                            if (ATOMIC_HELPER.casValue(abstractFuture, setFuture, getFutureValue(setFuture.future))) {
                                break;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        executeListener(runnable, listener2.executor);
                    }
                    listener2 = listener3;
                }
                return;
            }
        }
    }

    public static void executeListener(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            log.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e);
        }
    }

    public static Object getFutureValue(ListenableFuture<?> future) {
        Object obj;
        if (future instanceof AbstractFuture) {
            Object obj2 = ((AbstractFuture) future).value;
            if (obj2 instanceof Cancellation) {
                Cancellation cancellation = (Cancellation) obj2;
                if (cancellation.wasInterrupted) {
                    if (cancellation.cause != null) {
                        return new Cancellation(cancellation.cause, false);
                    }
                    return Cancellation.CAUSELESS_CANCELLED;
                }
                return obj2;
            }
            return obj2;
        }
        boolean isCancelled = future.isCancelled();
        boolean z = true;
        if ((!GENERATE_CANCELLATION_CAUSES) & isCancelled) {
            return Cancellation.CAUSELESS_CANCELLED;
        }
        boolean z2 = false;
        while (true) {
            try {
                try {
                    obj = future.get();
                    break;
                } catch (CancellationException e) {
                    if (!isCancelled) {
                        return new Failure(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + future, e));
                    }
                    return new Cancellation(e, false);
                } catch (ExecutionException e2) {
                    return new Failure(e2.getCause());
                } catch (Throwable th) {
                    return new Failure(th);
                }
            } catch (InterruptedException unused) {
                z2 = z;
            } catch (Throwable th2) {
                if (z2) {
                    Thread.currentThread().interrupt();
                }
                throw th2;
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
        if (obj == null) {
            return NULL;
        }
        return obj;
    }

    public final void addDoneString(StringBuilder builder) {
        V v;
        String valueOf;
        boolean z = false;
        while (true) {
            try {
                try {
                    v = get();
                    break;
                } catch (InterruptedException unused) {
                    z = true;
                } catch (Throwable th) {
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            } catch (CancellationException unused2) {
                builder.append("CANCELLED");
                return;
            } catch (RuntimeException e) {
                builder.append("UNKNOWN, cause=[");
                builder.append(e.getClass());
                builder.append(" thrown from get()]");
                return;
            } catch (ExecutionException e2) {
                builder.append("FAILURE, cause=[");
                builder.append(e2.getCause());
                builder.append("]");
                return;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        builder.append("SUCCESS, result=[");
        if (v == this) {
            valueOf = "this future";
        } else {
            valueOf = String.valueOf(v);
        }
        builder.append(valueOf);
        builder.append("]");
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public final void addListener(Runnable listener, Executor executor) {
        executor.getClass();
        Listener listener2 = this.listeners;
        Listener listener3 = Listener.TOMBSTONE;
        if (listener2 != listener3) {
            Listener listener4 = new Listener(listener, executor);
            do {
                listener4.next = listener2;
                if (ATOMIC_HELPER.casListeners(this, listener2, listener4)) {
                    return;
                } else {
                    listener2 = this.listeners;
                }
            } while (listener2 != listener3);
        }
        executeListener(listener, executor);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean mayInterruptIfRunning) {
        boolean z;
        Cancellation cancellation;
        boolean z2;
        Object obj = this.value;
        if (obj == null) {
            z = true;
        } else {
            z = false;
        }
        if (!(z | (obj instanceof SetFuture))) {
            return false;
        }
        if (GENERATE_CANCELLATION_CAUSES) {
            cancellation = new Cancellation(new CancellationException("Future.cancel() was called."), mayInterruptIfRunning);
        } else if (mayInterruptIfRunning) {
            cancellation = Cancellation.CAUSELESS_INTERRUPTED;
        } else {
            cancellation = Cancellation.CAUSELESS_CANCELLED;
        }
        AbstractFuture<V> abstractFuture = this;
        boolean z3 = false;
        while (true) {
            if (ATOMIC_HELPER.casValue(abstractFuture, obj, cancellation)) {
                complete(abstractFuture);
                if (!(obj instanceof SetFuture)) {
                    return true;
                }
                ListenableFuture<? extends V> listenableFuture = ((SetFuture) obj).future;
                if (listenableFuture instanceof AbstractFuture) {
                    abstractFuture = (AbstractFuture) listenableFuture;
                    obj = abstractFuture.value;
                    if (obj == null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!(z2 | (obj instanceof SetFuture))) {
                        return true;
                    }
                    z3 = true;
                } else {
                    listenableFuture.cancel(mayInterruptIfRunning);
                    return true;
                }
            } else {
                obj = abstractFuture.value;
                if (!(obj instanceof SetFuture)) {
                    return z3;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00bc  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00ad -> B:33:0x00b3). Please report as a decompilation issue!!! */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final V get(long r18, java.util.concurrent.TimeUnit r20) throws java.lang.InterruptedException, java.util.concurrent.TimeoutException, java.util.concurrent.ExecutionException {
        /*
            Method dump skipped, instructions count: 369
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.futures.AbstractFuture.get(long, java.util.concurrent.TimeUnit):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final V getDoneValue(Object obj) throws ExecutionException {
        if (!(obj instanceof Cancellation)) {
            if (!(obj instanceof Failure)) {
                if (obj == NULL) {
                    return null;
                }
                return obj;
            }
            throw new ExecutionException(((Failure) obj).exception);
        }
        Throwable th = ((Cancellation) obj).cause;
        CancellationException cancellationException = new CancellationException("Task was cancelled.");
        cancellationException.initCause(th);
        throw cancellationException;
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.value instanceof Cancellation;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        boolean z;
        if (this.value != null) {
            z = true;
        } else {
            z = false;
        }
        return (!(r0 instanceof SetFuture)) & z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String pendingToString() {
        String valueOf;
        Object obj = this.value;
        if (obj instanceof SetFuture) {
            StringBuilder sb = new StringBuilder("setFuture=[");
            ListenableFuture<? extends V> listenableFuture = ((SetFuture) obj).future;
            if (listenableFuture == this) {
                valueOf = "this future";
            } else {
                valueOf = String.valueOf(listenableFuture);
            }
            return ComponentActivity$2$$ExternalSyntheticOutline0.m(sb, valueOf, "]");
        }
        if (this instanceof ScheduledFuture) {
            return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
        }
        return null;
    }

    public final void removeWaiter(Waiter node) {
        node.thread = null;
        while (true) {
            Waiter waiter = this.waiters;
            if (waiter == Waiter.TOMBSTONE) {
                return;
            }
            Waiter waiter2 = null;
            while (waiter != null) {
                Waiter waiter3 = waiter.next;
                if (waiter.thread != null) {
                    waiter2 = waiter;
                } else if (waiter2 != null) {
                    waiter2.next = waiter3;
                    if (waiter2.thread == null) {
                        break;
                    }
                } else if (!ATOMIC_HELPER.casWaiters(this, waiter, waiter3)) {
                    break;
                }
                waiter = waiter3;
            }
            return;
        }
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (this.value instanceof Cancellation) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            addDoneString(sb);
        } else {
            try {
                str = pendingToString();
            } catch (RuntimeException e) {
                str = "Exception thrown from implementation: " + e.getClass();
            }
            if (str != null && !str.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(str);
                sb.append("]");
            } else if (isDone()) {
                addDoneString(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // java.util.concurrent.Future
    public final V get() throws InterruptedException, ExecutionException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.value;
            if ((obj2 != null) & (!(obj2 instanceof SetFuture))) {
                return getDoneValue(obj2);
            }
            Waiter waiter = this.waiters;
            Waiter waiter2 = Waiter.TOMBSTONE;
            if (waiter != waiter2) {
                Waiter waiter3 = new Waiter();
                do {
                    AtomicHelper atomicHelper = ATOMIC_HELPER;
                    atomicHelper.putNext(waiter3, waiter);
                    if (atomicHelper.casWaiters(this, waiter, waiter3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.value;
                            } else {
                                removeWaiter(waiter3);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof SetFuture))));
                        return getDoneValue(obj);
                    }
                    waiter = this.waiters;
                } while (waiter != waiter2);
            }
            return getDoneValue(this.value);
        }
        throw new InterruptedException();
    }
}
