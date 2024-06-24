package androidx.lifecycle;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.Lifecycle;
import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class LiveData<T> {
    public static final Object NOT_SET = new Object();
    public boolean mChangingActiveState;
    public volatile Object mData;
    public boolean mDispatchInvalidated;
    public boolean mDispatchingValue;
    public volatile Object mPendingData;
    public final AnonymousClass1 mPostValueRunnable;
    public int mVersion;
    public final Object mDataLock = new Object();
    public final SafeIterableMap<Observer<? super T>, LiveData<T>.ObserverWrapper> mObservers = new SafeIterableMap<>();
    public int mActiveCount = 0;

    /* loaded from: classes.dex */
    public class AlwaysActiveObserver extends LiveData<T>.ObserverWrapper {
        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        public final boolean shouldBeActive() {
            return true;
        }
    }

    /* loaded from: classes.dex */
    public class LifecycleBoundObserver extends LiveData<T>.ObserverWrapper implements LifecycleEventObserver {
        public final LifecycleOwner mOwner;

        public LifecycleBoundObserver(LifecycleOwner lifecycleOwner, Observer<? super T> observer) {
            super(observer);
            this.mOwner = lifecycleOwner;
        }

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        public final void detachObserver() {
            this.mOwner.getLifecycle().removeObserver(this);
        }

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        public final boolean isAttachedTo(LifecycleOwner lifecycleOwner) {
            if (this.mOwner == lifecycleOwner) {
                return true;
            }
            return false;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            LifecycleOwner lifecycleOwner2 = this.mOwner;
            Lifecycle.State currentState = lifecycleOwner2.getLifecycle().getCurrentState();
            if (currentState == Lifecycle.State.DESTROYED) {
                LiveData.this.removeObserver(this.mObserver);
                return;
            }
            Lifecycle.State state = null;
            while (state != currentState) {
                activeStateChanged(shouldBeActive());
                state = currentState;
                currentState = lifecycleOwner2.getLifecycle().getCurrentState();
            }
        }

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        public final boolean shouldBeActive() {
            return this.mOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED);
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [androidx.lifecycle.LiveData$1] */
    public LiveData() {
        Object obj = NOT_SET;
        this.mPendingData = obj;
        this.mPostValueRunnable = new Runnable() { // from class: androidx.lifecycle.LiveData.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public final void run() {
                Object obj2;
                synchronized (LiveData.this.mDataLock) {
                    obj2 = LiveData.this.mPendingData;
                    LiveData.this.mPendingData = LiveData.NOT_SET;
                }
                LiveData.this.setValue(obj2);
            }
        };
        this.mData = obj;
        this.mVersion = -1;
    }

    public static void assertMainThread(String str) {
        if (ArchTaskExecutor.getInstance().isMainThread()) {
        } else {
            throw new IllegalStateException(zzav$$ExternalSyntheticOutline0.m("Cannot invoke ", str, " on a background thread"));
        }
    }

    public final void considerNotify(LiveData<T>.ObserverWrapper observerWrapper) {
        if (!observerWrapper.mActive) {
            return;
        }
        if (!observerWrapper.shouldBeActive()) {
            observerWrapper.activeStateChanged(false);
            return;
        }
        int r0 = observerWrapper.mLastVersion;
        int r1 = this.mVersion;
        if (r0 >= r1) {
            return;
        }
        observerWrapper.mLastVersion = r1;
        observerWrapper.mObserver.onChanged((Object) this.mData);
    }

    public final void dispatchingValue(LiveData<T>.ObserverWrapper observerWrapper) {
        if (this.mDispatchingValue) {
            this.mDispatchInvalidated = true;
            return;
        }
        this.mDispatchingValue = true;
        do {
            this.mDispatchInvalidated = false;
            if (observerWrapper != null) {
                considerNotify(observerWrapper);
                observerWrapper = null;
            } else {
                SafeIterableMap<Observer<? super T>, LiveData<T>.ObserverWrapper> safeIterableMap = this.mObservers;
                safeIterableMap.getClass();
                SafeIterableMap.IteratorWithAdditions iteratorWithAdditions = new SafeIterableMap.IteratorWithAdditions();
                safeIterableMap.mIterators.put(iteratorWithAdditions, Boolean.FALSE);
                while (iteratorWithAdditions.hasNext()) {
                    considerNotify((ObserverWrapper) ((Map.Entry) iteratorWithAdditions.next()).getValue());
                    if (this.mDispatchInvalidated) {
                        break;
                    }
                }
            }
        } while (this.mDispatchInvalidated);
        this.mDispatchingValue = false;
    }

    public final void observe(LifecycleOwner lifecycleOwner, Observer<? super T> observer) {
        assertMainThread("observe");
        if (lifecycleOwner.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
            return;
        }
        LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(lifecycleOwner, observer);
        LiveData<T>.ObserverWrapper putIfAbsent = this.mObservers.putIfAbsent(observer, lifecycleBoundObserver);
        if (putIfAbsent != null && !putIfAbsent.isAttachedTo(lifecycleOwner)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (putIfAbsent != null) {
            return;
        }
        lifecycleOwner.getLifecycle().addObserver(lifecycleBoundObserver);
    }

    public final void observeForever(Observer<? super T> observer) {
        assertMainThread("observeForever");
        AlwaysActiveObserver alwaysActiveObserver = new AlwaysActiveObserver(observer);
        LiveData<T>.ObserverWrapper putIfAbsent = this.mObservers.putIfAbsent(observer, alwaysActiveObserver);
        if (!(putIfAbsent instanceof LifecycleBoundObserver)) {
            if (putIfAbsent != null) {
                return;
            }
            alwaysActiveObserver.activeStateChanged(true);
            return;
        }
        throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
    }

    public void removeObserver(Observer<? super T> observer) {
        assertMainThread("removeObserver");
        LiveData<T>.ObserverWrapper remove = this.mObservers.remove(observer);
        if (remove == null) {
            return;
        }
        remove.detachObserver();
        remove.activeStateChanged(false);
    }

    public void setValue(T t) {
        assertMainThread("setValue");
        this.mVersion++;
        this.mData = t;
        dispatchingValue(null);
    }

    /* loaded from: classes.dex */
    public abstract class ObserverWrapper {
        public boolean mActive;
        public int mLastVersion = -1;
        public final Observer<? super T> mObserver;

        public ObserverWrapper(Observer<? super T> observer) {
            this.mObserver = observer;
        }

        public final void activeStateChanged(boolean z) {
            int r6;
            boolean z2;
            boolean z3;
            if (z == this.mActive) {
                return;
            }
            this.mActive = z;
            if (z) {
                r6 = 1;
            } else {
                r6 = -1;
            }
            LiveData liveData = LiveData.this;
            int r2 = liveData.mActiveCount;
            liveData.mActiveCount = r6 + r2;
            if (!liveData.mChangingActiveState) {
                liveData.mChangingActiveState = true;
                while (true) {
                    try {
                        int r3 = liveData.mActiveCount;
                        if (r2 == r3) {
                            break;
                        }
                        if (r2 == 0 && r3 > 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (r2 > 0 && r3 == 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (z2) {
                            liveData.onActive();
                        } else if (z3) {
                            liveData.onInactive();
                        }
                        r2 = r3;
                    } finally {
                        liveData.mChangingActiveState = false;
                    }
                }
            }
            if (this.mActive) {
                liveData.dispatchingValue(this);
            }
        }

        public boolean isAttachedTo(LifecycleOwner lifecycleOwner) {
            return false;
        }

        public abstract boolean shouldBeActive();

        public void detachObserver() {
        }
    }

    public void onActive() {
    }

    public void onInactive() {
    }
}
