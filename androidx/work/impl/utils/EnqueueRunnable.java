package androidx.work.impl.utils;

import androidx.work.Logger;
import androidx.work.Operation;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import java.util.HashSet;

/* loaded from: classes.dex */
public final class EnqueueRunnable implements Runnable {
    public static final String TAG = Logger.tagWithPrefix("EnqueueRunnable");
    public final OperationImpl mOperation = new OperationImpl();
    public final WorkContinuationImpl mWorkContinuation;

    public EnqueueRunnable(WorkContinuationImpl workContinuation) {
        this.mWorkContinuation = workContinuation;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x033f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0287  */
    /* JADX WARN: Type inference failed for: r10v9, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean processContinuation(androidx.work.impl.WorkContinuationImpl r22) {
        /*
            Method dump skipped, instructions count: 850
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.EnqueueRunnable.processContinuation(androidx.work.impl.WorkContinuationImpl):boolean");
    }

    @Override // java.lang.Runnable
    public final void run() {
        OperationImpl operationImpl = this.mOperation;
        WorkContinuationImpl workContinuationImpl = this.mWorkContinuation;
        try {
            workContinuationImpl.getClass();
            WorkManagerImpl workManagerImpl = workContinuationImpl.mWorkManagerImpl;
            if (!WorkContinuationImpl.hasCycles(workContinuationImpl, new HashSet())) {
                WorkDatabase workDatabase = workManagerImpl.mWorkDatabase;
                workDatabase.beginTransaction();
                try {
                    boolean processContinuation = processContinuation(workContinuationImpl);
                    workDatabase.setTransactionSuccessful();
                    if (processContinuation) {
                        PackageManagerHelper.setComponentEnabled(workManagerImpl.mContext, RescheduleReceiver.class, true);
                        Schedulers.schedule(workManagerImpl.mConfiguration, workManagerImpl.mWorkDatabase, workManagerImpl.mSchedulers);
                    }
                    operationImpl.setState(Operation.SUCCESS);
                    return;
                } finally {
                    workDatabase.endTransaction();
                }
            }
            throw new IllegalStateException(String.format("WorkContinuation has cycles (%s)", workContinuationImpl));
        } catch (Throwable th) {
            operationImpl.setState(new Operation.State.FAILURE(th));
        }
    }
}
