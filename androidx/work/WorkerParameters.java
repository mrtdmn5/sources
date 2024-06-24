package androidx.work;

import android.net.Network;
import android.net.Uri;
import androidx.work.WorkerFactory;
import androidx.work.impl.utils.WorkForegroundUpdater;
import androidx.work.impl.utils.WorkProgressUpdater;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public final class WorkerParameters {
    public final Executor mBackgroundExecutor;
    public final ForegroundUpdater mForegroundUpdater;
    public final UUID mId;
    public final Data mInputData;
    public final ProgressUpdater mProgressUpdater;
    public final int mRunAttemptCount;
    public final RuntimeExtras mRuntimeExtras;
    public final HashSet mTags;
    public final TaskExecutor mWorkTaskExecutor;
    public final WorkerFactory mWorkerFactory;

    /* loaded from: classes.dex */
    public static class RuntimeExtras {
        public Network network;
        public List<String> triggeredContentAuthorities = Collections.emptyList();
        public List<Uri> triggeredContentUris = Collections.emptyList();
    }

    public WorkerParameters(UUID id, Data inputData, List tags, RuntimeExtras runtimeExtras, int runAttemptCount, ExecutorService backgroundExecutor, TaskExecutor workTaskExecutor, WorkerFactory.AnonymousClass1 workerFactory, WorkProgressUpdater progressUpdater, WorkForegroundUpdater foregroundUpdater) {
        this.mId = id;
        this.mInputData = inputData;
        this.mTags = new HashSet(tags);
        this.mRuntimeExtras = runtimeExtras;
        this.mRunAttemptCount = runAttemptCount;
        this.mBackgroundExecutor = backgroundExecutor;
        this.mWorkTaskExecutor = workTaskExecutor;
        this.mWorkerFactory = workerFactory;
        this.mProgressUpdater = progressUpdater;
        this.mForegroundUpdater = foregroundUpdater;
    }
}
