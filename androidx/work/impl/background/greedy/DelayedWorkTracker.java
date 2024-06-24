package androidx.work.impl.background.greedy;

import androidx.work.Logger;
import androidx.work.impl.DefaultRunnableScheduler;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class DelayedWorkTracker {
    public static final String TAG = Logger.tagWithPrefix("DelayedWorkTracker");
    public final GreedyScheduler mGreedyScheduler;
    public final DefaultRunnableScheduler mRunnableScheduler;
    public final HashMap mRunnables = new HashMap();

    public DelayedWorkTracker(GreedyScheduler scheduler, DefaultRunnableScheduler runnableScheduler) {
        this.mGreedyScheduler = scheduler;
        this.mRunnableScheduler = runnableScheduler;
    }
}
