package com.animaconnected.future;

import android.os.Handler;
import android.os.Looper;
import com.animaconnected.future.Promise;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public class Promise<T> {
    private Throwable mError;
    private T mResult;
    private State mState = State.PENDING;
    private final List<SuccessCallback<T>> mSuccessCallbacks = new ArrayList();
    private final List<FailCallback> mFailCallbacks = new ArrayList();
    private final List<AlwaysCallback> mAlwaysCallbacks = new ArrayList();
    private final Future<T> mFuture = new AnonymousClass1();

    /* renamed from: com.animaconnected.future.Promise$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements Future<T> {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void lambda$catchError$5(Class cls, Promise promise, MapCallback mapCallback, Throwable th) {
            if (!cls.isInstance(th)) {
                promise.reject(th);
                return;
            }
            try {
                promise.resolve(mapCallback.onResult(cls.cast(th)));
            } catch (Exception e) {
                promise.reject(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Future lambda$delay$9(long j, final Object obj) throws Exception {
            final Promise promise = new Promise();
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.animaconnected.future.Promise$1$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    Promise.this.resolve(obj);
                }
            }, j);
            return promise.getFuture();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$flatMap$2(FlatMapCallback flatMapCallback, final Promise promise, Object obj) {
            try {
                Future onResult = flatMapCallback.onResult(obj);
                if (onResult != null) {
                    onResult.success(new SuccessCallback() { // from class: com.animaconnected.future.Promise$1$$ExternalSyntheticLambda2
                        @Override // com.animaconnected.future.SuccessCallback
                        public final void onSuccess(Object obj2) {
                            Promise.this.resolve(obj2);
                        }
                    });
                    onResult.fail(new FailCallback() { // from class: com.animaconnected.future.Promise$1$$ExternalSyntheticLambda3
                        @Override // com.animaconnected.future.FailCallback
                        public final void onFail(Throwable th) {
                            Promise.this.reject(th);
                        }
                    });
                    return;
                }
                throw new RuntimeException("Callback returned no future.");
            } catch (Exception e) {
                promise.reject(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void lambda$map$6(MapCallback mapCallback, Promise promise, Object obj) {
            try {
                promise.resolve(mapCallback.onResult(obj));
            } catch (Exception e) {
                promise.reject(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$timeout$10(Promise promise) {
            if (promise.isPending()) {
                promise.reject(new TimeoutException("Timed out"));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$timeout$11(Promise promise, Handler handler, Runnable runnable, Object obj) {
            if (promise.isPending()) {
                handler.removeCallbacks(runnable);
                promise.resolve(obj);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$timeout$12(Promise promise, Handler handler, Runnable runnable, Throwable th) {
            if (promise.isPending()) {
                handler.removeCallbacks(runnable);
                promise.reject(th);
            }
        }

        @Override // com.animaconnected.future.Future
        public Future<T> always(AlwaysCallback alwaysCallback) {
            Promise.this.mAlwaysCallbacks.add(alwaysCallback);
            if (Promise.this.mState != State.PENDING) {
                alwaysCallback.onFinished();
            }
            return this;
        }

        @Override // com.animaconnected.future.Future
        public Future<T> catchError(MapCallback<Throwable, T> mapCallback) {
            return catchError(Throwable.class, mapCallback);
        }

        @Override // com.animaconnected.future.Future
        public Future<T> delay(final long j) {
            return flatMap(new FlatMapCallback() { // from class: com.animaconnected.future.Promise$1$$ExternalSyntheticLambda10
                @Override // com.animaconnected.future.FlatMapCallback
                public final Future onResult(Object obj) {
                    Future lambda$delay$9;
                    lambda$delay$9 = Promise.AnonymousClass1.lambda$delay$9(j, obj);
                    return lambda$delay$9;
                }
            });
        }

        @Override // com.animaconnected.future.Future
        public Future<T> fail(FailCallback failCallback) {
            Promise.this.mFailCallbacks.add(failCallback);
            if (Promise.this.mState == State.REJECTED) {
                failCallback.onFail(Promise.this.mError);
            }
            return this;
        }

        @Override // com.animaconnected.future.Future
        public <D> Future<D> flatMap(final FlatMapCallback<T, D> flatMapCallback) {
            final Promise promise = new Promise();
            success(new SuccessCallback() { // from class: com.animaconnected.future.Promise$1$$ExternalSyntheticLambda0
                @Override // com.animaconnected.future.SuccessCallback
                public final void onSuccess(Object obj) {
                    Promise.AnonymousClass1.lambda$flatMap$2(FlatMapCallback.this, promise, obj);
                }
            });
            fail(new FailCallback() { // from class: com.animaconnected.future.Promise$1$$ExternalSyntheticLambda1
                @Override // com.animaconnected.future.FailCallback
                public final void onFail(Throwable th) {
                    Promise.this.reject(th);
                }
            });
            return promise.getFuture();
        }

        @Override // com.animaconnected.future.Future
        public T get() {
            if (Promise.this.mState == State.RESOLVED) {
                return (T) Promise.this.mResult;
            }
            throw new IllegalStateException("The Future's value is not available!");
        }

        @Override // com.animaconnected.future.Future
        public <D> Future<D> map(final MapCallback<T, D> mapCallback) {
            final Promise promise = new Promise();
            success(new SuccessCallback() { // from class: com.animaconnected.future.Promise$1$$ExternalSyntheticLambda11
                @Override // com.animaconnected.future.SuccessCallback
                public final void onSuccess(Object obj) {
                    Promise.AnonymousClass1.lambda$map$6(MapCallback.this, promise, obj);
                }
            });
            fail(new FailCallback() { // from class: com.animaconnected.future.Promise$1$$ExternalSyntheticLambda12
                @Override // com.animaconnected.future.FailCallback
                public final void onFail(Throwable th) {
                    Promise.this.reject(th);
                }
            });
            return promise.getFuture();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.animaconnected.future.Future
        public Future<T> success(SuccessCallback<T> successCallback) {
            Promise.this.mSuccessCallbacks.add(successCallback);
            if (Promise.this.mState == State.RESOLVED) {
                successCallback.onSuccess(Promise.this.mResult);
            }
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [com.animaconnected.future.Promise$1$$ExternalSyntheticLambda4, java.lang.Runnable] */
        @Override // com.animaconnected.future.Future
        public Future<T> timeout(long j) {
            final Promise promise = new Promise();
            final Handler handler = new Handler();
            final ?? r2 = new Runnable() { // from class: com.animaconnected.future.Promise$1$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    Promise.AnonymousClass1.lambda$timeout$10(Promise.this);
                }
            };
            handler.postDelayed(r2, j);
            success(new SuccessCallback() { // from class: com.animaconnected.future.Promise$1$$ExternalSyntheticLambda5
                @Override // com.animaconnected.future.SuccessCallback
                public final void onSuccess(Object obj) {
                    Promise.AnonymousClass1.lambda$timeout$11(Promise.this, handler, r2, obj);
                }
            });
            fail(new FailCallback() { // from class: com.animaconnected.future.Promise$1$$ExternalSyntheticLambda6
                @Override // com.animaconnected.future.FailCallback
                public final void onFail(Throwable th) {
                    Promise.AnonymousClass1.lambda$timeout$12(Promise.this, handler, r2, th);
                }
            });
            return promise.getFuture();
        }

        @Override // com.animaconnected.future.Future
        public <E> Future<T> catchError(final Class<E> cls, final MapCallback<E, T> mapCallback) {
            final Promise promise = new Promise();
            success(new SuccessCallback() { // from class: com.animaconnected.future.Promise$1$$ExternalSyntheticLambda7
                @Override // com.animaconnected.future.SuccessCallback
                public final void onSuccess(Object obj) {
                    Promise.this.resolve(obj);
                }
            });
            fail(new FailCallback() { // from class: com.animaconnected.future.Promise$1$$ExternalSyntheticLambda8
                @Override // com.animaconnected.future.FailCallback
                public final void onFail(Throwable th) {
                    Promise.AnonymousClass1.lambda$catchError$5(cls, promise, mapCallback, th);
                }
            });
            return promise.getFuture();
        }
    }

    /* loaded from: classes.dex */
    public enum State {
        PENDING,
        RESOLVED,
        REJECTED
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isPending() {
        if (this.mState == State.PENDING) {
            return true;
        }
        return false;
    }

    private void notifyAlwaysCallback() {
        Iterator<AlwaysCallback> it = this.mAlwaysCallbacks.iterator();
        while (it.hasNext()) {
            it.next().onFinished();
        }
    }

    private void notifyFail() {
        Iterator<FailCallback> it = this.mFailCallbacks.iterator();
        while (it.hasNext()) {
            it.next().onFail(this.mError);
        }
    }

    private void notifySuccess() {
        Iterator<SuccessCallback<T>> it = this.mSuccessCallbacks.iterator();
        while (it.hasNext()) {
            it.next().onSuccess(this.mResult);
        }
    }

    public Future<T> getFuture() {
        return this.mFuture;
    }

    public void reject(Throwable th) {
        if (this.mState == State.PENDING) {
            this.mState = State.REJECTED;
            this.mError = th;
            notifyFail();
            notifyAlwaysCallback();
            return;
        }
        throw new IllegalStateException("Promise isn't pending!");
    }

    public void resolve(T t) {
        if (this.mState == State.PENDING) {
            this.mState = State.RESOLVED;
            this.mResult = t;
            notifySuccess();
            notifyAlwaysCallback();
            return;
        }
        throw new IllegalStateException("Promise isn't pending!");
    }
}
