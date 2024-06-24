package com.google.firebase.crashlytics.internal.common;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.common.CrashlyticsController;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public final class CrashlyticsBackgroundWorker {
    public final Executor executor;
    public Task<Void> tail = Tasks.forResult(null);
    public final Object tailLock = new Object();
    public final ThreadLocal<Boolean> isExecutorThread = new ThreadLocal<>();

    /* renamed from: com.google.firebase.crashlytics.internal.common.CrashlyticsBackgroundWorker$1 */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            CrashlyticsBackgroundWorker.this.isExecutorThread.set(Boolean.TRUE);
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.common.CrashlyticsBackgroundWorker$2 */
    /* loaded from: classes3.dex */
    public final class AnonymousClass2 implements Callable<Void> {
        public final /* synthetic */ Runnable val$runnable;

        public AnonymousClass2(CrashlyticsController.AnonymousClass6 anonymousClass6) {
            r1 = anonymousClass6;
        }

        @Override // java.util.concurrent.Callable
        public final Void call() throws Exception {
            r1.run();
            return null;
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.common.CrashlyticsBackgroundWorker$3 */
    /* loaded from: classes3.dex */
    public final class AnonymousClass3 implements Continuation<Void, Object> {
        public final /* synthetic */ Callable val$callable;

        public AnonymousClass3(Callable callable) {
            this.val$callable = callable;
        }

        @Override // com.google.android.gms.tasks.Continuation
        public final Object then(Task<Void> task) throws Exception {
            return this.val$callable.call();
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.common.CrashlyticsBackgroundWorker$4 */
    /* loaded from: classes3.dex */
    public final class AnonymousClass4 implements Continuation<Object, Void> {
        @Override // com.google.android.gms.tasks.Continuation
        public final /* bridge */ /* synthetic */ Void then(Task<Object> task) throws Exception {
            return null;
        }
    }

    public CrashlyticsBackgroundWorker(Executor executor) {
        this.executor = executor;
        executor.execute(new Runnable() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsBackgroundWorker.1
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                CrashlyticsBackgroundWorker.this.isExecutorThread.set(Boolean.TRUE);
            }
        });
    }

    public final <T> Task<T> submit(Callable<T> callable) {
        Task<T> task;
        synchronized (this.tailLock) {
            task = (Task<T>) this.tail.continueWith(this.executor, new AnonymousClass3(callable));
            this.tail = task.continueWith(this.executor, new AnonymousClass4());
        }
        return task;
    }
}
