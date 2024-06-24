package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import retrofit2.CallAdapter;

@IgnoreJRERequirement
/* loaded from: classes4.dex */
public final class CompletableFutureCallAdapterFactory extends CallAdapter.Factory {
    public static final CompletableFutureCallAdapterFactory INSTANCE = new CompletableFutureCallAdapterFactory();

    @IgnoreJRERequirement
    /* loaded from: classes4.dex */
    public static final class BodyCallAdapter<R> implements CallAdapter<R, CompletableFuture<R>> {
        public final Type responseType;

        @IgnoreJRERequirement
        /* loaded from: classes4.dex */
        public class BodyCallback implements Callback<R> {
            public final CompletableFuture<R> future;

            public BodyCallback(CallCancelCompletableFuture callCancelCompletableFuture) {
                this.future = callCancelCompletableFuture;
            }

            @Override // retrofit2.Callback
            public final void onFailure(Call<R> call, Throwable th) {
                this.future.completeExceptionally(th);
            }

            @Override // retrofit2.Callback
            public final void onResponse(Call<R> call, Response<R> response) {
                boolean z = response.rawResponse.isSuccessful;
                CompletableFuture<R> completableFuture = this.future;
                if (z) {
                    completableFuture.complete(response.body);
                } else {
                    completableFuture.completeExceptionally(new HttpException(response));
                }
            }
        }

        public BodyCallAdapter(Type type) {
            this.responseType = type;
        }

        @Override // retrofit2.CallAdapter
        public final Object adapt(OkHttpCall okHttpCall) {
            CallCancelCompletableFuture callCancelCompletableFuture = new CallCancelCompletableFuture(okHttpCall);
            okHttpCall.enqueue(new BodyCallback(callCancelCompletableFuture));
            return callCancelCompletableFuture;
        }

        @Override // retrofit2.CallAdapter
        public final Type responseType() {
            return this.responseType;
        }
    }

    @IgnoreJRERequirement
    /* loaded from: classes4.dex */
    public static final class CallCancelCompletableFuture<T> extends CompletableFuture<T> {
        public final Call<?> call;

        public CallCancelCompletableFuture(OkHttpCall okHttpCall) {
            this.call = okHttpCall;
        }

        @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
        public final boolean cancel(boolean z) {
            if (z) {
                this.call.cancel();
            }
            return super.cancel(z);
        }
    }

    @IgnoreJRERequirement
    /* loaded from: classes4.dex */
    public static final class ResponseCallAdapter<R> implements CallAdapter<R, CompletableFuture<Response<R>>> {
        public final Type responseType;

        @IgnoreJRERequirement
        /* loaded from: classes4.dex */
        public class ResponseCallback implements Callback<R> {
            public final CompletableFuture<Response<R>> future;

            public ResponseCallback(CallCancelCompletableFuture callCancelCompletableFuture) {
                this.future = callCancelCompletableFuture;
            }

            @Override // retrofit2.Callback
            public final void onFailure(Call<R> call, Throwable th) {
                this.future.completeExceptionally(th);
            }

            @Override // retrofit2.Callback
            public final void onResponse(Call<R> call, Response<R> response) {
                this.future.complete(response);
            }
        }

        public ResponseCallAdapter(Type type) {
            this.responseType = type;
        }

        @Override // retrofit2.CallAdapter
        public final Object adapt(OkHttpCall okHttpCall) {
            CallCancelCompletableFuture callCancelCompletableFuture = new CallCancelCompletableFuture(okHttpCall);
            okHttpCall.enqueue(new ResponseCallback(callCancelCompletableFuture));
            return callCancelCompletableFuture;
        }

        @Override // retrofit2.CallAdapter
        public final Type responseType() {
            return this.responseType;
        }
    }

    @Override // retrofit2.CallAdapter.Factory
    public final CallAdapter get(Type type, Annotation[] annotationArr) {
        if (Utils.getRawType(type) != CompletableFuture.class) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            Type parameterUpperBound = Utils.getParameterUpperBound(0, (ParameterizedType) type);
            if (Utils.getRawType(parameterUpperBound) != Response.class) {
                return new BodyCallAdapter(parameterUpperBound);
            }
            if (parameterUpperBound instanceof ParameterizedType) {
                return new ResponseCallAdapter(Utils.getParameterUpperBound(0, (ParameterizedType) parameterUpperBound));
            }
            throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
        }
        throw new IllegalStateException("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
    }
}
