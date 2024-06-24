package androidx.work.impl;

import android.text.TextUtils;
import androidx.work.ExistingWorkPolicy;
import androidx.work.Logger;
import androidx.work.Operation;
import androidx.work.WorkContinuation;
import androidx.work.WorkRequest;
import androidx.work.impl.utils.EnqueueRunnable;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class WorkContinuationImpl extends WorkContinuation {
    public static final String TAG = Logger.tagWithPrefix("WorkContinuationImpl");
    public final ArrayList mAllIds;
    public boolean mEnqueued;
    public final ExistingWorkPolicy mExistingWorkPolicy;
    public final ArrayList mIds;
    public final String mName;
    public OperationImpl mOperation;
    public final List<WorkContinuationImpl> mParents;
    public final List<? extends WorkRequest> mWork;
    public final WorkManagerImpl mWorkManagerImpl;

    public WorkContinuationImpl() {
        throw null;
    }

    public WorkContinuationImpl(WorkManagerImpl workManagerImpl, String str, ExistingWorkPolicy existingWorkPolicy, List list) {
        this.mWorkManagerImpl = workManagerImpl;
        this.mName = str;
        this.mExistingWorkPolicy = existingWorkPolicy;
        this.mWork = list;
        this.mParents = null;
        this.mIds = new ArrayList(list.size());
        this.mAllIds = new ArrayList();
        for (int r1 = 0; r1 < list.size(); r1++) {
            String str2 = ((WorkRequest) list.get(r1)).mId.toString();
            this.mIds.add(str2);
            this.mAllIds.add(str2);
        }
    }

    public static boolean hasCycles(WorkContinuationImpl continuation, HashSet visited) {
        visited.addAll(continuation.mIds);
        HashSet prerequisitesFor = prerequisitesFor(continuation);
        Iterator it = visited.iterator();
        while (it.hasNext()) {
            if (prerequisitesFor.contains((String) it.next())) {
                return true;
            }
        }
        List<WorkContinuationImpl> list = continuation.mParents;
        if (list != null && !list.isEmpty()) {
            Iterator<WorkContinuationImpl> it2 = list.iterator();
            while (it2.hasNext()) {
                if (hasCycles(it2.next(), visited)) {
                    return true;
                }
            }
        }
        visited.removeAll(continuation.mIds);
        return false;
    }

    public static HashSet prerequisitesFor(WorkContinuationImpl continuation) {
        HashSet hashSet = new HashSet();
        List<WorkContinuationImpl> list = continuation.mParents;
        if (list != null && !list.isEmpty()) {
            Iterator<WorkContinuationImpl> it = list.iterator();
            while (it.hasNext()) {
                hashSet.addAll(it.next().mIds);
            }
        }
        return hashSet;
    }

    public final Operation enqueue() {
        if (!this.mEnqueued) {
            EnqueueRunnable enqueueRunnable = new EnqueueRunnable(this);
            ((WorkManagerTaskExecutor) this.mWorkManagerImpl.mWorkTaskExecutor).executeOnBackgroundThread(enqueueRunnable);
            this.mOperation = enqueueRunnable.mOperation;
        } else {
            Logger.get().warning(TAG, String.format("Already enqueued work ids (%s)", TextUtils.join(", ", this.mIds)), new Throwable[0]);
        }
        return this.mOperation;
    }
}
