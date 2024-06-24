package androidx.work.impl.utils.taskexecutor;

import android.os.Handler;
import android.os.Looper;
import androidx.work.impl.utils.SerialExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public final class WorkManagerTaskExecutor implements TaskExecutor {
    public final SerialExecutor mBackgroundExecutor;
    public final Handler mMainThreadHandler = new Handler(Looper.getMainLooper());
    public final AnonymousClass1 mMainThreadExecutor = new AnonymousClass1();

    /* renamed from: androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements Executor {
        public AnonymousClass1() {
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable command) {
            WorkManagerTaskExecutor.this.mMainThreadHandler.post(command);
        }
    }

    public WorkManagerTaskExecutor(ExecutorService backgroundExecutor) {
        this.mBackgroundExecutor = new SerialExecutor(backgroundExecutor);
    }

    public final void executeOnBackgroundThread(Runnable runnable) {
        this.mBackgroundExecutor.execute(runnable);
    }
}
