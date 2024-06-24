package kotlinx.coroutines.test.internal;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DefaultExecutorKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* compiled from: TestMainDispatcher.kt */
/* loaded from: classes4.dex */
public final class TestMainDispatcher extends MainCoroutineDispatcher implements Delay {
    public final NonConcurrentlyModifiable<CoroutineDispatcher> delegate;

    /* compiled from: TestMainDispatcher.kt */
    /* loaded from: classes4.dex */
    public static final class NonConcurrentlyModifiable<T> {
        private volatile Object _value;
        private volatile Object exceptionWhenReading;
        public final String name = "Dispatchers.Main";
        private volatile Object reader;
        private volatile int readers;
        private volatile Object writer;
        public static final AtomicReferenceFieldUpdater reader$FU = AtomicReferenceFieldUpdater.newUpdater(NonConcurrentlyModifiable.class, Object.class, "reader");
        public static final AtomicIntegerFieldUpdater readers$FU = AtomicIntegerFieldUpdater.newUpdater(NonConcurrentlyModifiable.class, "readers");
        public static final AtomicReferenceFieldUpdater writer$FU = AtomicReferenceFieldUpdater.newUpdater(NonConcurrentlyModifiable.class, Object.class, "writer");
        public static final AtomicReferenceFieldUpdater exceptionWhenReading$FU = AtomicReferenceFieldUpdater.newUpdater(NonConcurrentlyModifiable.class, Object.class, "exceptionWhenReading");
        public static final AtomicReferenceFieldUpdater _value$FU = AtomicReferenceFieldUpdater.newUpdater(NonConcurrentlyModifiable.class, Object.class, "_value");

        public NonConcurrentlyModifiable(MainCoroutineDispatcher mainCoroutineDispatcher) {
            this._value = mainCoroutineDispatcher;
        }

        public final T getValue() {
            reader$FU.set(this, new Throwable("reader location"));
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = readers$FU;
            atomicIntegerFieldUpdater.incrementAndGet(this);
            Throwable th = (Throwable) writer$FU.get(this);
            if (th != null) {
                exceptionWhenReading$FU.set(this, new IllegalStateException(ComponentActivity$2$$ExternalSyntheticOutline0.m(new StringBuilder(), this.name, " is used concurrently with setting it"), th));
            }
            T t = (T) _value$FU.get(this);
            atomicIntegerFieldUpdater.decrementAndGet(this);
            return t;
        }
    }

    public TestMainDispatcher(MainCoroutineDispatcher mainCoroutineDispatcher) {
        this.delegate = new NonConcurrentlyModifiable<>(mainCoroutineDispatcher);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        this.delegate.getValue().dispatch(coroutineContext, runnable);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        this.delegate.getValue().dispatchYield(coroutineContext, runnable);
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher
    public final MainCoroutineDispatcher getImmediate() {
        MainCoroutineDispatcher mainCoroutineDispatcher;
        MainCoroutineDispatcher immediate;
        CoroutineDispatcher value = this.delegate.getValue();
        if (value instanceof MainCoroutineDispatcher) {
            mainCoroutineDispatcher = (MainCoroutineDispatcher) value;
        } else {
            mainCoroutineDispatcher = null;
        }
        if (mainCoroutineDispatcher == null || (immediate = mainCoroutineDispatcher.getImmediate()) == null) {
            return this;
        }
        return immediate;
    }

    @Override // kotlinx.coroutines.Delay
    public final DisposableHandle invokeOnTimeout(long j, Runnable runnable, CoroutineContext coroutineContext) {
        Delay delay;
        CoroutineContext.Element value = this.delegate.getValue();
        if (value instanceof Delay) {
            delay = (Delay) value;
        } else {
            delay = null;
        }
        if (delay == null) {
            delay = DefaultExecutorKt.DefaultDelay;
        }
        return delay.invokeOnTimeout(j, runnable, coroutineContext);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        return this.delegate.getValue().isDispatchNeeded(coroutineContext);
    }

    @Override // kotlinx.coroutines.Delay
    public final void scheduleResumeAfterDelay(long j, CancellableContinuationImpl cancellableContinuationImpl) {
        Delay delay;
        CoroutineContext.Element value = this.delegate.getValue();
        if (value instanceof Delay) {
            delay = (Delay) value;
        } else {
            delay = null;
        }
        if (delay == null) {
            delay = DefaultExecutorKt.DefaultDelay;
        }
        delay.scheduleResumeAfterDelay(j, cancellableContinuationImpl);
    }
}
