package androidx.work.impl.constraints.trackers;

import android.content.Context;
import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public abstract class ConstraintTracker<T> {
    public static final String TAG = Logger.tagWithPrefix("ConstraintTracker");
    public final Context mAppContext;
    public T mCurrentState;
    public final TaskExecutor mTaskExecutor;
    public final Object mLock = new Object();
    public final LinkedHashSet mListeners = new LinkedHashSet();

    public ConstraintTracker(Context context, TaskExecutor taskExecutor) {
        this.mAppContext = context.getApplicationContext();
        this.mTaskExecutor = taskExecutor;
    }

    public abstract T getInitialState();

    public final void setState(T newState) {
        synchronized (this.mLock) {
            T t = this.mCurrentState;
            if (t != newState && (t == null || !t.equals(newState))) {
                this.mCurrentState = newState;
                final ArrayList arrayList = new ArrayList(this.mListeners);
                ((WorkManagerTaskExecutor) this.mTaskExecutor).mMainThreadExecutor.execute(new Runnable() { // from class: androidx.work.impl.constraints.trackers.ConstraintTracker.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            ((ConstraintListener) it.next()).onConstraintChanged(ConstraintTracker.this.mCurrentState);
                        }
                    }
                });
            }
        }
    }

    public abstract void startTracking();

    public abstract void stopTracking();
}
