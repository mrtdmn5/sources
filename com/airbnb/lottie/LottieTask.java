package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import com.airbnb.lottie.utils.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* loaded from: classes.dex */
public final class LottieTask<T> {
    public static final ExecutorService EXECUTOR = Executors.newCachedThreadPool();
    public final LinkedHashSet failureListeners;
    public final Handler handler;
    public volatile LottieResult<T> result;
    public final LinkedHashSet successListeners;

    /* loaded from: classes.dex */
    public class LottieFutureTask extends FutureTask<LottieResult<T>> {
        public LottieFutureTask(Callable<LottieResult<T>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        public final void done() {
            LottieTask lottieTask = LottieTask.this;
            if (isCancelled()) {
                return;
            }
            try {
                lottieTask.setResult(get());
            } catch (InterruptedException | ExecutionException e) {
                lottieTask.setResult(new LottieResult<>(e));
            }
        }
    }

    public LottieTask() {
        throw null;
    }

    public LottieTask(Callable<LottieResult<T>> callable, boolean z) {
        this.successListeners = new LinkedHashSet(1);
        this.failureListeners = new LinkedHashSet(1);
        this.handler = new Handler(Looper.getMainLooper());
        this.result = null;
        if (z) {
            try {
                setResult(callable.call());
                return;
            } catch (Throwable th) {
                setResult(new LottieResult<>(th));
                return;
            }
        }
        EXECUTOR.execute(new LottieFutureTask(callable));
    }

    public final synchronized void addFailureListener(LottieListener lottieListener) {
        Throwable th;
        LottieResult<T> lottieResult = this.result;
        if (lottieResult != null && (th = lottieResult.exception) != null) {
            lottieListener.onResult(th);
        }
        this.failureListeners.add(lottieListener);
    }

    public final synchronized void addListener(LottieListener lottieListener) {
        T t;
        LottieResult<T> lottieResult = this.result;
        if (lottieResult != null && (t = lottieResult.value) != null) {
            lottieListener.onResult(t);
        }
        this.successListeners.add(lottieListener);
    }

    public final void setResult(LottieResult<T> lottieResult) {
        if (this.result == null) {
            this.result = lottieResult;
            this.handler.post(new Runnable() { // from class: com.airbnb.lottie.LottieTask$$ExternalSyntheticLambda0
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public final void run() {
                    LottieTask lottieTask = LottieTask.this;
                    LottieResult<T> lottieResult2 = lottieTask.result;
                    if (lottieResult2 != 0) {
                        V v = lottieResult2.value;
                        if (v != 0) {
                            synchronized (lottieTask) {
                                Iterator it = new ArrayList(lottieTask.successListeners).iterator();
                                while (it.hasNext()) {
                                    ((LottieListener) it.next()).onResult(v);
                                }
                            }
                            return;
                        }
                        Throwable th = lottieResult2.exception;
                        synchronized (lottieTask) {
                            ArrayList arrayList = new ArrayList(lottieTask.failureListeners);
                            if (arrayList.isEmpty()) {
                                Logger.warning("Lottie encountered an error but no failure listener was added:", th);
                                return;
                            }
                            Iterator it2 = arrayList.iterator();
                            while (it2.hasNext()) {
                                ((LottieListener) it2.next()).onResult(th);
                            }
                        }
                    }
                }
            });
            return;
        }
        throw new IllegalStateException("A task may only be set once.");
    }
}
