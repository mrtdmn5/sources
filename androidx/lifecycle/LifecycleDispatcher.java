package androidx.lifecycle;

import android.app.Activity;
import android.os.Bundle;
import androidx.lifecycle.ReportFragment;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LifecycleDispatcher.kt */
/* loaded from: classes.dex */
public final class LifecycleDispatcher {
    public static final AtomicBoolean initialized = new AtomicBoolean(false);

    /* compiled from: LifecycleDispatcher.kt */
    /* loaded from: classes.dex */
    public static final class DispatcherActivityCallback extends EmptyActivityLifecycleCallbacks {
        @Override // androidx.lifecycle.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            int r2 = ReportFragment.$r8$clinit;
            ReportFragment.Companion.injectIfNeededIn(activity);
        }
    }
}
