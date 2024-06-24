package androidx.lifecycle;

import android.os.Handler;
import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ServiceLifecycleDispatcher.kt */
/* loaded from: classes.dex */
public final class ServiceLifecycleDispatcher {
    public final Handler handler;
    public DispatchRunnable lastDispatchRunnable;
    public final LifecycleRegistry registry;

    /* compiled from: ServiceLifecycleDispatcher.kt */
    /* loaded from: classes.dex */
    public static final class DispatchRunnable implements Runnable {
        public final Lifecycle.Event event;
        public final LifecycleRegistry registry;
        public boolean wasExecuted;

        public DispatchRunnable(LifecycleRegistry registry, Lifecycle.Event event) {
            Intrinsics.checkNotNullParameter(registry, "registry");
            Intrinsics.checkNotNullParameter(event, "event");
            this.registry = registry;
            this.event = event;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (!this.wasExecuted) {
                this.registry.handleLifecycleEvent(this.event);
                this.wasExecuted = true;
            }
        }
    }

    public ServiceLifecycleDispatcher(LifecycleOwner provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        this.registry = new LifecycleRegistry(provider);
        this.handler = new Handler();
    }

    public final void postDispatchRunnable(Lifecycle.Event event) {
        DispatchRunnable dispatchRunnable = this.lastDispatchRunnable;
        if (dispatchRunnable != null) {
            dispatchRunnable.run();
        }
        DispatchRunnable dispatchRunnable2 = new DispatchRunnable(this.registry, event);
        this.lastDispatchRunnable = dispatchRunnable2;
        this.handler.postAtFrontOfQueue(dispatchRunnable2);
    }
}
