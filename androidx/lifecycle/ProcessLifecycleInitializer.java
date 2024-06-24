package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleDispatcher;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.startup.AppInitializer;
import androidx.startup.Initializer;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProcessLifecycleInitializer.kt */
/* loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements Initializer<LifecycleOwner> {
    @Override // androidx.startup.Initializer
    public final LifecycleOwner create(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        AppInitializer appInitializer = AppInitializer.getInstance(context);
        Intrinsics.checkNotNullExpressionValue(appInitializer, "getInstance(context)");
        if (appInitializer.mDiscovered.contains(ProcessLifecycleInitializer.class)) {
            if (!LifecycleDispatcher.initialized.getAndSet(true)) {
                Context applicationContext = context.getApplicationContext();
                Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
                ((Application) applicationContext).registerActivityLifecycleCallbacks(new LifecycleDispatcher.DispatcherActivityCallback());
            }
            final ProcessLifecycleOwner processLifecycleOwner = ProcessLifecycleOwner.newInstance;
            processLifecycleOwner.getClass();
            processLifecycleOwner.handler = new Handler();
            processLifecycleOwner.registry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
            Context applicationContext2 = context.getApplicationContext();
            Intrinsics.checkNotNull(applicationContext2, "null cannot be cast to non-null type android.app.Application");
            ((Application) applicationContext2).registerActivityLifecycleCallbacks(new EmptyActivityLifecycleCallbacks() { // from class: androidx.lifecycle.ProcessLifecycleOwner$attach$1
                @Override // androidx.lifecycle.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity, Bundle bundle) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    if (Build.VERSION.SDK_INT < 29) {
                        int r3 = ReportFragment.$r8$clinit;
                        Fragment findFragmentByTag = activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
                        Intrinsics.checkNotNull(findFragmentByTag, "null cannot be cast to non-null type androidx.lifecycle.ReportFragment");
                        ((ReportFragment) findFragmentByTag).processListener = ProcessLifecycleOwner.this.initializationListener;
                    }
                }

                @Override // androidx.lifecycle.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    ProcessLifecycleOwner processLifecycleOwner2 = ProcessLifecycleOwner.this;
                    int r0 = processLifecycleOwner2.resumedCounter - 1;
                    processLifecycleOwner2.resumedCounter = r0;
                    if (r0 == 0) {
                        Handler handler = processLifecycleOwner2.handler;
                        Intrinsics.checkNotNull(handler);
                        handler.postDelayed(processLifecycleOwner2.delayedPauseRunnable, 700L);
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPreCreated(Activity activity, Bundle bundle) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    final ProcessLifecycleOwner processLifecycleOwner2 = ProcessLifecycleOwner.this;
                    ProcessLifecycleOwner.Api29Impl.registerActivityLifecycleCallbacks(activity, new EmptyActivityLifecycleCallbacks() { // from class: androidx.lifecycle.ProcessLifecycleOwner$attach$1$onActivityPreCreated$1
                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public void onActivityPostResumed(Activity activity2) {
                            Intrinsics.checkNotNullParameter(activity2, "activity");
                            ProcessLifecycleOwner.this.activityResumed$lifecycle_process_release();
                        }

                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public void onActivityPostStarted(Activity activity2) {
                            Intrinsics.checkNotNullParameter(activity2, "activity");
                            ProcessLifecycleOwner processLifecycleOwner3 = ProcessLifecycleOwner.this;
                            int r0 = processLifecycleOwner3.startedCounter + 1;
                            processLifecycleOwner3.startedCounter = r0;
                            if (r0 == 1 && processLifecycleOwner3.stopSent) {
                                processLifecycleOwner3.registry.handleLifecycleEvent(Lifecycle.Event.ON_START);
                                processLifecycleOwner3.stopSent = false;
                            }
                        }
                    });
                }

                @Override // androidx.lifecycle.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    ProcessLifecycleOwner processLifecycleOwner2 = ProcessLifecycleOwner.this;
                    int r0 = processLifecycleOwner2.startedCounter - 1;
                    processLifecycleOwner2.startedCounter = r0;
                    if (r0 == 0 && processLifecycleOwner2.pauseSent) {
                        processLifecycleOwner2.registry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
                        processLifecycleOwner2.stopSent = true;
                    }
                }
            });
            return processLifecycleOwner;
        }
        throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml".toString());
    }

    @Override // androidx.startup.Initializer
    public final List<Class<? extends Initializer<?>>> dependencies() {
        return EmptyList.INSTANCE;
    }
}
