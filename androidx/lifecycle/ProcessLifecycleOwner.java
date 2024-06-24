package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.os.Handler;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ReportFragment;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProcessLifecycleOwner.kt */
/* loaded from: classes.dex */
public final class ProcessLifecycleOwner implements LifecycleOwner {
    public static final ProcessLifecycleOwner newInstance = new ProcessLifecycleOwner();
    public Handler handler;
    public int resumedCounter;
    public int startedCounter;
    public boolean pauseSent = true;
    public boolean stopSent = true;
    public final LifecycleRegistry registry = new LifecycleRegistry(this);
    public final ProcessLifecycleOwner$$ExternalSyntheticLambda0 delayedPauseRunnable = new Runnable() { // from class: androidx.lifecycle.ProcessLifecycleOwner$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            ProcessLifecycleOwner this$0 = ProcessLifecycleOwner.this;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            int r1 = this$0.resumedCounter;
            LifecycleRegistry lifecycleRegistry = this$0.registry;
            if (r1 == 0) {
                this$0.pauseSent = true;
                lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
            }
            if (this$0.startedCounter == 0 && this$0.pauseSent) {
                lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
                this$0.stopSent = true;
            }
        }
    };
    public final ProcessLifecycleOwner$initializationListener$1 initializationListener = new ReportFragment.ActivityInitializationListener() { // from class: androidx.lifecycle.ProcessLifecycleOwner$initializationListener$1
        @Override // androidx.lifecycle.ReportFragment.ActivityInitializationListener
        public final void onResume() {
            ProcessLifecycleOwner.this.activityResumed$lifecycle_process_release();
        }

        @Override // androidx.lifecycle.ReportFragment.ActivityInitializationListener
        public final void onStart() {
            ProcessLifecycleOwner processLifecycleOwner = ProcessLifecycleOwner.this;
            int r1 = processLifecycleOwner.startedCounter + 1;
            processLifecycleOwner.startedCounter = r1;
            if (r1 == 1 && processLifecycleOwner.stopSent) {
                processLifecycleOwner.registry.handleLifecycleEvent(Lifecycle.Event.ON_START);
                processLifecycleOwner.stopSent = false;
            }
        }

        @Override // androidx.lifecycle.ReportFragment.ActivityInitializationListener
        public final void onCreate() {
        }
    };

    /* compiled from: ProcessLifecycleOwner.kt */
    /* loaded from: classes.dex */
    public static final class Api29Impl {
        public static final void registerActivityLifecycleCallbacks(Activity activity, Application.ActivityLifecycleCallbacks callback) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(callback, "callback");
            activity.registerActivityLifecycleCallbacks(callback);
        }
    }

    public final void activityResumed$lifecycle_process_release() {
        int r0 = this.resumedCounter + 1;
        this.resumedCounter = r0;
        if (r0 == 1) {
            if (this.pauseSent) {
                this.registry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
                this.pauseSent = false;
            } else {
                Handler handler = this.handler;
                Intrinsics.checkNotNull(handler);
                handler.removeCallbacks(this.delayedPauseRunnable);
            }
        }
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return this.registry;
    }
}
