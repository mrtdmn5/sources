package androidx.work;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintSet$$ExternalSyntheticOutline0;

/* loaded from: classes.dex */
public abstract class WorkerFactory {
    public static final String TAG = Logger.tagWithPrefix("WorkerFactory");

    /* renamed from: androidx.work.WorkerFactory$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public final class AnonymousClass1 extends WorkerFactory {
    }

    public final ListenableWorker createWorkerWithDefaultFallback(Context appContext, String workerClassName, WorkerParameters workerParameters) {
        Class cls;
        String str = TAG;
        ListenableWorker listenableWorker = null;
        try {
            cls = Class.forName(workerClassName).asSubclass(ListenableWorker.class);
        } catch (Throwable th) {
            Logger.get().error(str, ConstraintSet$$ExternalSyntheticOutline0.m("Invalid class: ", workerClassName), th);
            cls = null;
        }
        if (cls != null) {
            try {
                listenableWorker = (ListenableWorker) cls.getDeclaredConstructor(Context.class, WorkerParameters.class).newInstance(appContext, workerParameters);
            } catch (Throwable th2) {
                Logger.get().error(str, ConstraintSet$$ExternalSyntheticOutline0.m("Could not instantiate ", workerClassName), th2);
            }
        }
        if (listenableWorker != null && listenableWorker.isUsed()) {
            throw new IllegalStateException(String.format("WorkerFactory (%s) returned an instance of a ListenableWorker (%s) which has already been invoked. createWorker() must always return a new instance of a ListenableWorker.", getClass().getName(), workerClassName));
        }
        return listenableWorker;
    }
}
