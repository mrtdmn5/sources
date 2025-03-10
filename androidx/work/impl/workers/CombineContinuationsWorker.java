package androidx.work.impl.workers;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

/* loaded from: classes.dex */
public class CombineContinuationsWorker extends Worker {
    public CombineContinuationsWorker(Context context, WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @Override // androidx.work.Worker
    public final ListenableWorker.Result.Success doWork() {
        return new ListenableWorker.Result.Success(getInputData());
    }
}
