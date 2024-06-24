package androidx.loader.content;

import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import androidx.core.os.OperationCanceledException;
import androidx.loader.app.LoaderManagerImpl;
import androidx.loader.content.Loader;
import androidx.loader.content.ModernAsyncTask;
import com.google.android.gms.auth.api.signin.internal.zbc;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public abstract class AsyncTaskLoader<D> extends Loader<D> {
    public volatile AsyncTaskLoader<D>.LoadTask mCancellingTask;
    public final Executor mExecutor;
    public volatile AsyncTaskLoader<D>.LoadTask mTask;

    /* loaded from: classes.dex */
    public final class LoadTask extends ModernAsyncTask<Void, Void, D> implements Runnable {
        public final CountDownLatch mDone = new CountDownLatch(1);

        public LoadTask() {
        }

        @Override // androidx.loader.content.ModernAsyncTask
        public final void doInBackground(Object[] objArr) {
            try {
                AsyncTaskLoader.this.onLoadInBackground();
            } catch (OperationCanceledException e) {
                if (this.mCancelled.get()) {
                } else {
                    throw e;
                }
            }
        }

        @Override // androidx.loader.content.ModernAsyncTask
        public final void onCancelled(D d) {
            CountDownLatch countDownLatch = this.mDone;
            try {
                AsyncTaskLoader asyncTaskLoader = AsyncTaskLoader.this;
                if (asyncTaskLoader.mCancellingTask == this) {
                    SystemClock.uptimeMillis();
                    asyncTaskLoader.mCancellingTask = null;
                    asyncTaskLoader.executePendingTask();
                }
            } finally {
                countDownLatch.countDown();
            }
        }

        @Override // androidx.loader.content.ModernAsyncTask
        public final void onPostExecute(D d) {
            try {
                AsyncTaskLoader asyncTaskLoader = AsyncTaskLoader.this;
                if (asyncTaskLoader.mTask != this) {
                    if (asyncTaskLoader.mCancellingTask == this) {
                        SystemClock.uptimeMillis();
                        asyncTaskLoader.mCancellingTask = null;
                        asyncTaskLoader.executePendingTask();
                    }
                } else if (!asyncTaskLoader.mAbandoned) {
                    SystemClock.uptimeMillis();
                    asyncTaskLoader.mTask = null;
                    Loader.OnLoadCompleteListener<D> onLoadCompleteListener = asyncTaskLoader.mListener;
                    if (onLoadCompleteListener != null) {
                        LoaderManagerImpl.LoaderInfo loaderInfo = (LoaderManagerImpl.LoaderInfo) onLoadCompleteListener;
                        if (Looper.myLooper() == Looper.getMainLooper()) {
                            loaderInfo.setValue(d);
                        } else {
                            loaderInfo.postValue(d);
                        }
                    }
                }
            } finally {
                this.mDone.countDown();
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            AsyncTaskLoader.this.executePendingTask();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsyncTaskLoader(Context context) {
        super(context);
        ThreadPoolExecutor threadPoolExecutor = ModernAsyncTask.THREAD_POOL_EXECUTOR;
        this.mExecutor = threadPoolExecutor;
    }

    public final void executePendingTask() {
        if (this.mCancellingTask == null && this.mTask != null) {
            this.mTask.getClass();
            AsyncTaskLoader<D>.LoadTask loadTask = this.mTask;
            Executor executor = this.mExecutor;
            if (loadTask.mStatus != ModernAsyncTask.Status.PENDING) {
                int r0 = ModernAsyncTask.AnonymousClass4.$SwitchMap$androidx$loader$content$ModernAsyncTask$Status[loadTask.mStatus.ordinal()];
                if (r0 != 1) {
                    if (r0 != 2) {
                        throw new IllegalStateException("We should never reach this state");
                    }
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
                }
                throw new IllegalStateException("Cannot execute task: the task is already running.");
            }
            loadTask.mStatus = ModernAsyncTask.Status.RUNNING;
            loadTask.mWorker.mParams = null;
            executor.execute(loadTask.mFuture);
        }
    }

    public final void onLoadInBackground() {
        zbc zbcVar = (zbc) this;
        Iterator it = zbcVar.zbb.iterator();
        if (!it.hasNext()) {
            try {
                zbcVar.zba.tryAcquire(0, 5L, TimeUnit.SECONDS);
                return;
            } catch (InterruptedException e) {
                Log.i("GACSignInLoader", "Unexpected InterruptedException", e);
                Thread.currentThread().interrupt();
                return;
            }
        }
        ((GoogleApiClient) it.next()).getClass();
        throw new UnsupportedOperationException();
    }
}
