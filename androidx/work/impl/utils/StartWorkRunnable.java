package androidx.work.impl.utils;

import androidx.work.WorkerParameters;
import androidx.work.impl.WorkManagerImpl;

/* loaded from: classes.dex */
public final class StartWorkRunnable implements Runnable {
    public final WorkerParameters.RuntimeExtras mRuntimeExtras;
    public final WorkManagerImpl mWorkManagerImpl;
    public final String mWorkSpecId;

    public StartWorkRunnable(WorkManagerImpl workManagerImpl, String workSpecId, WorkerParameters.RuntimeExtras runtimeExtras) {
        this.mWorkManagerImpl = workManagerImpl;
        this.mWorkSpecId = workSpecId;
        this.mRuntimeExtras = runtimeExtras;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.mWorkManagerImpl.mProcessor.startWork(this.mWorkSpecId, this.mRuntimeExtras);
    }
}
