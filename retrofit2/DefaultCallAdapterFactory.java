package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;
import okhttp3.Request;
import retrofit2.CallAdapter;
import retrofit2.DefaultCallAdapterFactory;

/* loaded from: classes4.dex */
public final class DefaultCallAdapterFactory extends CallAdapter.Factory {
    public final Executor callbackExecutor;

    /* renamed from: retrofit2.DefaultCallAdapterFactory$1 */
    /* loaded from: classes4.dex */
    public final class AnonymousClass1 implements CallAdapter<Object, Call<?>> {
        public final /* synthetic */ Executor val$executor;
        public final /* synthetic */ Type val$responseType;

        public AnonymousClass1(Type type, Executor executor) {
            r1 = type;
            r2 = executor;
        }

        @Override // retrofit2.CallAdapter
        public final Object adapt(OkHttpCall okHttpCall) {
            Executor executor = r2;
            if (executor != null) {
                return new ExecutorCallbackCall(executor, okHttpCall);
            }
            return okHttpCall;
        }

        @Override // retrofit2.CallAdapter
        public final Type responseType() {
            return r1;
        }
    }

    /* loaded from: classes4.dex */
    public static final class ExecutorCallbackCall<T> implements Call<T> {
        public final Executor callbackExecutor;
        public final Call<T> delegate;

        /* renamed from: retrofit2.DefaultCallAdapterFactory$ExecutorCallbackCall$1 */
        /* loaded from: classes4.dex */
        public class AnonymousClass1 implements Callback<T> {
            public final /* synthetic */ Callback val$callback;

            public AnonymousClass1(Callback callback) {
                this.val$callback = callback;
            }

            @Override // retrofit2.Callback
            public final void onFailure(Call<T> call, final Throwable th) {
                Executor executor = ExecutorCallbackCall.this.callbackExecutor;
                final Callback callback = this.val$callback;
                executor.execute(new Runnable() { // from class: retrofit2.DefaultCallAdapterFactory$ExecutorCallbackCall$1$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        callback.onFailure(DefaultCallAdapterFactory.ExecutorCallbackCall.this, th);
                    }
                });
            }

            @Override // retrofit2.Callback
            public final void onResponse(Call<T> call, final Response<T> response) {
                Executor executor = ExecutorCallbackCall.this.callbackExecutor;
                final Callback callback = this.val$callback;
                executor.execute(new Runnable() { // from class: retrofit2.DefaultCallAdapterFactory$ExecutorCallbackCall$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        DefaultCallAdapterFactory.ExecutorCallbackCall executorCallbackCall = DefaultCallAdapterFactory.ExecutorCallbackCall.this;
                        boolean isCanceled = executorCallbackCall.delegate.isCanceled();
                        Callback callback2 = callback;
                        if (isCanceled) {
                            callback2.onFailure(executorCallbackCall, new IOException("Canceled"));
                        } else {
                            callback2.onResponse(executorCallbackCall, response);
                        }
                    }
                });
            }
        }

        public ExecutorCallbackCall(Executor executor, Call<T> call) {
            this.callbackExecutor = executor;
            this.delegate = call;
        }

        @Override // retrofit2.Call
        public final void cancel() {
            this.delegate.cancel();
        }

        @Override // retrofit2.Call
        public final void enqueue(Callback<T> callback) {
            this.delegate.enqueue(new AnonymousClass1(callback));
        }

        @Override // retrofit2.Call
        public final boolean isCanceled() {
            return this.delegate.isCanceled();
        }

        @Override // retrofit2.Call
        public final Request request() {
            return this.delegate.request();
        }

        @Override // retrofit2.Call
        public final Call<T> clone() {
            return new ExecutorCallbackCall(this.callbackExecutor, this.delegate.clone());
        }
    }

    public DefaultCallAdapterFactory(Executor executor) {
        this.callbackExecutor = executor;
    }

    @Override // retrofit2.CallAdapter.Factory
    public final CallAdapter get(Type type, Annotation[] annotationArr) {
        Executor executor = null;
        if (Utils.getRawType(type) != Call.class) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            Type parameterUpperBound = Utils.getParameterUpperBound(0, (ParameterizedType) type);
            if (!Utils.isAnnotationPresent(annotationArr, SkipCallbackExecutor.class)) {
                executor = this.callbackExecutor;
            }
            return new CallAdapter<Object, Call<?>>() { // from class: retrofit2.DefaultCallAdapterFactory.1
                public final /* synthetic */ Executor val$executor;
                public final /* synthetic */ Type val$responseType;

                public AnonymousClass1(Type parameterUpperBound2, Executor executor2) {
                    r1 = parameterUpperBound2;
                    r2 = executor2;
                }

                @Override // retrofit2.CallAdapter
                public final Object adapt(OkHttpCall okHttpCall) {
                    Executor executor2 = r2;
                    if (executor2 != null) {
                        return new ExecutorCallbackCall(executor2, okHttpCall);
                    }
                    return okHttpCall;
                }

                @Override // retrofit2.CallAdapter
                public final Type responseType() {
                    return r1;
                }
            };
        }
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }
}
