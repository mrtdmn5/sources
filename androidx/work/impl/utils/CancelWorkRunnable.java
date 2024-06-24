package androidx.work.impl.utils;

import androidx.work.Logger;
import androidx.work.Operation;
import androidx.work.WorkInfo;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.Processor;
import androidx.work.impl.Scheduler;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.WorkerWrapper;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.DependencyDao_Impl;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkSpecDao_Impl;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public abstract class CancelWorkRunnable implements Runnable {
    public final OperationImpl mOperation = new OperationImpl();

    public static void cancel(WorkManagerImpl workManagerImpl, String workSpecId) {
        WorkDatabase workDatabase = workManagerImpl.mWorkDatabase;
        WorkSpecDao workSpecDao = workDatabase.workSpecDao();
        DependencyDao dependencyDao = workDatabase.dependencyDao();
        LinkedList linkedList = new LinkedList();
        linkedList.add(workSpecId);
        while (!linkedList.isEmpty()) {
            String str = (String) linkedList.remove();
            WorkSpecDao_Impl workSpecDao_Impl = (WorkSpecDao_Impl) workSpecDao;
            WorkInfo.State state = workSpecDao_Impl.getState(str);
            if (state != WorkInfo.State.SUCCEEDED && state != WorkInfo.State.FAILED) {
                workSpecDao_Impl.setState(WorkInfo.State.CANCELLED, str);
            }
            linkedList.addAll(((DependencyDao_Impl) dependencyDao).getDependentWorkIds(str));
        }
        Processor processor = workManagerImpl.mProcessor;
        synchronized (processor.mLock) {
            boolean z = false;
            Logger.get().debug(Processor.TAG, String.format("Processor cancelling %s", workSpecId), new Throwable[0]);
            processor.mCancelledIds.add(workSpecId);
            WorkerWrapper workerWrapper = (WorkerWrapper) processor.mForegroundWorkMap.remove(workSpecId);
            if (workerWrapper != null) {
                z = true;
            }
            if (workerWrapper == null) {
                workerWrapper = (WorkerWrapper) processor.mEnqueuedWorkMap.remove(workSpecId);
            }
            Processor.interrupt(workSpecId, workerWrapper);
            if (z) {
                processor.stopForegroundService();
            }
        }
        Iterator<Scheduler> it = workManagerImpl.mSchedulers.iterator();
        while (it.hasNext()) {
            it.next().cancel(workSpecId);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        OperationImpl operationImpl = this.mOperation;
        try {
            runInternal();
            operationImpl.setState(Operation.SUCCESS);
        } catch (Throwable th) {
            operationImpl.setState(new Operation.State.FAILURE(th));
        }
    }

    public abstract void runInternal();
}
