package androidx.lifecycle;

import android.annotation.SuppressLint;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.FastSafeIterableMap;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.Lifecycle;
import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LifecycleRegistry.kt */
/* loaded from: classes.dex */
public final class LifecycleRegistry extends Lifecycle {
    public int addingObserverCounter;
    public final boolean enforceMainThread;
    public boolean handlingEvent;
    public final WeakReference<LifecycleOwner> lifecycleOwner;
    public boolean newEventOccurred;
    public FastSafeIterableMap<LifecycleObserver, ObserverWithState> observerMap;
    public final ArrayList<Lifecycle.State> parentStates;
    public Lifecycle.State state;

    /* compiled from: LifecycleRegistry.kt */
    /* loaded from: classes.dex */
    public static final class ObserverWithState {
        public final LifecycleEventObserver lifecycleObserver;
        public Lifecycle.State state;

        public ObserverWithState(LifecycleObserver lifecycleObserver, Lifecycle.State initialState) {
            LifecycleEventObserver reflectiveGenericLifecycleObserver;
            Intrinsics.checkNotNullParameter(initialState, "initialState");
            Intrinsics.checkNotNull(lifecycleObserver);
            HashMap hashMap = Lifecycling.callbackCache;
            boolean z = lifecycleObserver instanceof LifecycleEventObserver;
            boolean z2 = lifecycleObserver instanceof DefaultLifecycleObserver;
            if (z && z2) {
                reflectiveGenericLifecycleObserver = new DefaultLifecycleObserverAdapter((DefaultLifecycleObserver) lifecycleObserver, (LifecycleEventObserver) lifecycleObserver);
            } else if (z2) {
                reflectiveGenericLifecycleObserver = new DefaultLifecycleObserverAdapter((DefaultLifecycleObserver) lifecycleObserver, null);
            } else if (z) {
                reflectiveGenericLifecycleObserver = (LifecycleEventObserver) lifecycleObserver;
            } else {
                Class<?> cls = lifecycleObserver.getClass();
                if (Lifecycling.getObserverConstructorType(cls) == 2) {
                    Object obj = Lifecycling.classToAdapters.get(cls);
                    Intrinsics.checkNotNull(obj);
                    List list = (List) obj;
                    if (list.size() == 1) {
                        reflectiveGenericLifecycleObserver = new SingleGeneratedAdapterObserver(Lifecycling.createGeneratedAdapter((Constructor) list.get(0), lifecycleObserver));
                    } else {
                        int size = list.size();
                        GeneratedAdapter[] generatedAdapterArr = new GeneratedAdapter[size];
                        for (int r3 = 0; r3 < size; r3++) {
                            generatedAdapterArr[r3] = Lifecycling.createGeneratedAdapter((Constructor) list.get(r3), lifecycleObserver);
                        }
                        reflectiveGenericLifecycleObserver = new CompositeGeneratedAdaptersObserver(generatedAdapterArr);
                    }
                } else {
                    reflectiveGenericLifecycleObserver = new ReflectiveGenericLifecycleObserver(lifecycleObserver);
                }
            }
            this.lifecycleObserver = reflectiveGenericLifecycleObserver;
            this.state = initialState;
        }

        public final void dispatchEvent(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            Lifecycle.State targetState = event.getTargetState();
            Lifecycle.State state1 = this.state;
            Intrinsics.checkNotNullParameter(state1, "state1");
            if (targetState != null && targetState.compareTo(state1) < 0) {
                state1 = targetState;
            }
            this.state = state1;
            this.lifecycleObserver.onStateChanged(lifecycleOwner, event);
            this.state = targetState;
        }
    }

    public LifecycleRegistry(LifecycleOwner provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        this.enforceMainThread = true;
        this.observerMap = new FastSafeIterableMap<>();
        this.state = Lifecycle.State.INITIALIZED;
        this.parentStates = new ArrayList<>();
        this.lifecycleOwner = new WeakReference<>(provider);
    }

    @Override // androidx.lifecycle.Lifecycle
    public final void addObserver(LifecycleObserver observer) {
        LifecycleOwner lifecycleOwner;
        boolean z;
        Intrinsics.checkNotNullParameter(observer, "observer");
        enforceMainThreadIfNeeded("addObserver");
        Lifecycle.State state = this.state;
        Lifecycle.State state2 = Lifecycle.State.DESTROYED;
        if (state != state2) {
            state2 = Lifecycle.State.INITIALIZED;
        }
        ObserverWithState observerWithState = new ObserverWithState(observer, state2);
        if (this.observerMap.putIfAbsent(observer, observerWithState) != null || (lifecycleOwner = this.lifecycleOwner.get()) == null) {
            return;
        }
        if (this.addingObserverCounter == 0 && !this.handlingEvent) {
            z = false;
        } else {
            z = true;
        }
        Lifecycle.State calculateTargetState = calculateTargetState(observer);
        this.addingObserverCounter++;
        while (observerWithState.state.compareTo(calculateTargetState) < 0 && this.observerMap.mHashMap.containsKey(observer)) {
            Lifecycle.State state3 = observerWithState.state;
            ArrayList<Lifecycle.State> arrayList = this.parentStates;
            arrayList.add(state3);
            Lifecycle.Event.Companion companion = Lifecycle.Event.Companion;
            Lifecycle.State state4 = observerWithState.state;
            companion.getClass();
            Lifecycle.Event upFrom = Lifecycle.Event.Companion.upFrom(state4);
            if (upFrom != null) {
                observerWithState.dispatchEvent(lifecycleOwner, upFrom);
                arrayList.remove(arrayList.size() - 1);
                calculateTargetState = calculateTargetState(observer);
            } else {
                throw new IllegalStateException("no event up from " + observerWithState.state);
            }
        }
        if (!z) {
            sync();
        }
        this.addingObserverCounter--;
    }

    public final Lifecycle.State calculateTargetState(LifecycleObserver lifecycleObserver) {
        SafeIterableMap.Entry<LifecycleObserver, ObserverWithState> entry;
        Lifecycle.State state;
        ObserverWithState observerWithState;
        FastSafeIterableMap<LifecycleObserver, ObserverWithState> fastSafeIterableMap = this.observerMap;
        Lifecycle.State state2 = null;
        if (fastSafeIterableMap.mHashMap.containsKey(lifecycleObserver)) {
            entry = fastSafeIterableMap.mHashMap.get(lifecycleObserver).mPrevious;
        } else {
            entry = null;
        }
        if (entry != null && (observerWithState = entry.mValue) != null) {
            state = observerWithState.state;
        } else {
            state = null;
        }
        ArrayList<Lifecycle.State> arrayList = this.parentStates;
        if (!arrayList.isEmpty()) {
            state2 = arrayList.get(arrayList.size() - 1);
        }
        Lifecycle.State state1 = this.state;
        Intrinsics.checkNotNullParameter(state1, "state1");
        if (state == null || state.compareTo(state1) >= 0) {
            state = state1;
        }
        if (state2 == null || state2.compareTo(state) >= 0) {
            return state;
        }
        return state2;
    }

    @SuppressLint({"RestrictedApi"})
    public final void enforceMainThreadIfNeeded(String str) {
        if (this.enforceMainThread && !ArchTaskExecutor.getInstance().isMainThread()) {
            throw new IllegalStateException(zzav$$ExternalSyntheticOutline0.m("Method ", str, " must be called on the main thread").toString());
        }
    }

    @Override // androidx.lifecycle.Lifecycle
    public final Lifecycle.State getCurrentState() {
        return this.state;
    }

    public final void handleLifecycleEvent(Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        enforceMainThreadIfNeeded("handleLifecycleEvent");
        moveToState(event.getTargetState());
    }

    public final void moveToState(Lifecycle.State state) {
        boolean z;
        Lifecycle.State state2 = this.state;
        if (state2 == state) {
            return;
        }
        if (state2 == Lifecycle.State.INITIALIZED && state == Lifecycle.State.DESTROYED) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            this.state = state;
            if (!this.handlingEvent && this.addingObserverCounter == 0) {
                this.handlingEvent = true;
                sync();
                this.handlingEvent = false;
                if (this.state == Lifecycle.State.DESTROYED) {
                    this.observerMap = new FastSafeIterableMap<>();
                    return;
                }
                return;
            }
            this.newEventOccurred = true;
            return;
        }
        throw new IllegalStateException(("no event down from " + this.state + " in component " + this.lifecycleOwner.get()).toString());
    }

    @Override // androidx.lifecycle.Lifecycle
    public final void removeObserver(LifecycleObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        enforceMainThreadIfNeeded("removeObserver");
        this.observerMap.remove(observer);
    }

    public final void setCurrentState(Lifecycle.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        enforceMainThreadIfNeeded("setCurrentState");
        moveToState(state);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0162 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void sync() {
        /*
            Method dump skipped, instructions count: 365
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.LifecycleRegistry.sync():void");
    }
}
