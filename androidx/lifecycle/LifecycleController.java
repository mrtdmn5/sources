package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* compiled from: LifecycleController.kt */
/* loaded from: classes.dex */
public final class LifecycleController {
    public final DispatchQueue dispatchQueue;
    public final Lifecycle lifecycle;
    public final Lifecycle.State minState;
    public final LifecycleController$$ExternalSyntheticLambda0 observer;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [androidx.lifecycle.LifecycleObserver, androidx.lifecycle.LifecycleController$$ExternalSyntheticLambda0] */
    public LifecycleController(Lifecycle lifecycle, Lifecycle.State minState, DispatchQueue dispatchQueue, final Job job) {
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        Intrinsics.checkNotNullParameter(minState, "minState");
        Intrinsics.checkNotNullParameter(dispatchQueue, "dispatchQueue");
        this.lifecycle = lifecycle;
        this.minState = minState;
        this.dispatchQueue = dispatchQueue;
        ?? r3 = new LifecycleEventObserver() { // from class: androidx.lifecycle.LifecycleController$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                LifecycleController this$0 = LifecycleController.this;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                Job parentJob = job;
                Intrinsics.checkNotNullParameter(parentJob, "$parentJob");
                if (lifecycleOwner.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
                    parentJob.cancel(null);
                    this$0.finish();
                    return;
                }
                int compareTo = lifecycleOwner.getLifecycle().getCurrentState().compareTo(this$0.minState);
                DispatchQueue dispatchQueue2 = this$0.dispatchQueue;
                if (compareTo < 0) {
                    dispatchQueue2.paused = true;
                } else if (dispatchQueue2.paused) {
                    if (!dispatchQueue2.finished) {
                        dispatchQueue2.paused = false;
                        dispatchQueue2.drainQueue();
                        return;
                    }
                    throw new IllegalStateException("Cannot resume a finished dispatcher".toString());
                }
            }
        };
        this.observer = r3;
        if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
            job.cancel(null);
            finish();
        } else {
            lifecycle.addObserver(r3);
        }
    }

    public final void finish() {
        this.lifecycle.removeObserver(this.observer);
        DispatchQueue dispatchQueue = this.dispatchQueue;
        dispatchQueue.finished = true;
        dispatchQueue.drainQueue();
    }
}
