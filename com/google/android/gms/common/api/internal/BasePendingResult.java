package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.base.zau;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
@KeepName
/* loaded from: classes3.dex */
public abstract class BasePendingResult<R extends Result> extends PendingResult<R> {
    public static final zaq zaa = new zaq();

    @KeepName
    private zas mResultGuardian;
    public Result zaj;
    public Status zak;
    public volatile boolean zal;
    public boolean zan;
    public final Object zae = new Object();
    public final CountDownLatch zaf = new CountDownLatch(1);
    public final ArrayList zag = new ArrayList();
    public final AtomicReference zai = new AtomicReference();
    public boolean zaq = false;

    /* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
    /* loaded from: classes3.dex */
    public static class CallbackHandler<R extends Result> extends zau {
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int r0 = message.what;
            if (r0 != 1) {
                if (r0 != 2) {
                    Log.wtf("BasePendingResult", "Don't know how to handle message: " + r0, new Exception());
                    return;
                }
                ((BasePendingResult) message.obj).forceFailureUnlessReady(Status.RESULT_TIMEOUT);
                return;
            }
            Pair pair = (Pair) message.obj;
            ResultCallback resultCallback = (ResultCallback) pair.first;
            Result result = (Result) pair.second;
            try {
                resultCallback.onResult();
            } catch (RuntimeException e) {
                BasePendingResult.zal(result);
                throw e;
            }
        }
    }

    @Deprecated
    public BasePendingResult() {
        new CallbackHandler(Looper.getMainLooper());
        new WeakReference(null);
    }

    public static void zal(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e) {
                Log.w("BasePendingResult", "Unable to release ".concat(String.valueOf(result)), e);
            }
        }
    }

    public final void addStatusListener(PendingResult.StatusListener statusListener) {
        synchronized (this.zae) {
            if (isReady()) {
                statusListener.onComplete(this.zak);
            } else {
                this.zag.add(statusListener);
            }
        }
    }

    public abstract R createFailedResult(Status status);

    @Deprecated
    public final void forceFailureUnlessReady(Status status) {
        synchronized (this.zae) {
            if (!isReady()) {
                setResult((BasePendingResult<R>) createFailedResult(status));
                this.zan = true;
            }
        }
    }

    public final boolean isReady() {
        if (this.zaf.getCount() == 0) {
            return true;
        }
        return false;
    }

    public /* bridge */ /* synthetic */ void setResult(Status status) {
        setResult((BasePendingResult<R>) status);
    }

    public final Result zaa() {
        Result result;
        synchronized (this.zae) {
            Preconditions.checkState("Result has already been consumed.", !this.zal);
            Preconditions.checkState("Result is not ready.", isReady());
            result = this.zaj;
            this.zaj = null;
            this.zal = true;
        }
        if (((zadb) this.zai.getAndSet(null)) == null) {
            Preconditions.checkNotNull(result);
            return result;
        }
        throw null;
    }

    public final void zab(Result result) {
        this.zaj = result;
        this.zak = result.getStatus();
        this.zaf.countDown();
        if (this.zaj instanceof Releasable) {
            this.mResultGuardian = new zas(this);
        }
        ArrayList arrayList = this.zag;
        int size = arrayList.size();
        for (int r1 = 0; r1 < size; r1++) {
            ((PendingResult.StatusListener) arrayList.get(r1)).onComplete(this.zak);
        }
        arrayList.clear();
    }

    public final void setResult(R r) {
        synchronized (this.zae) {
            if (!this.zan) {
                isReady();
                Preconditions.checkState("Results have already been set", !isReady());
                Preconditions.checkState("Result has already been consumed", !this.zal);
                zab(r);
                return;
            }
            zal(r);
        }
    }

    public BasePendingResult(zabv zabvVar) {
        Looper mainLooper;
        if (zabvVar != null) {
            mainLooper = zabvVar.zaa.zag;
        } else {
            mainLooper = Looper.getMainLooper();
        }
        new CallbackHandler(mainLooper);
        new WeakReference(zabvVar);
    }
}
