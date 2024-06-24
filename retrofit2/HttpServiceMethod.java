package retrofit2;

import java.lang.reflect.Method;
import kotlin.KotlinNullPointerException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import okhttp3.Call;
import okhttp3.Request;
import okhttp3.ResponseBody;

/* loaded from: classes4.dex */
public abstract class HttpServiceMethod<ResponseT, ReturnT> extends ServiceMethod<ReturnT> {
    public final Call.Factory callFactory;
    public final RequestFactory requestFactory;
    public final Converter<ResponseBody, ResponseT> responseConverter;

    /* loaded from: classes4.dex */
    public static final class CallAdapted<ResponseT, ReturnT> extends HttpServiceMethod<ResponseT, ReturnT> {
        public final CallAdapter<ResponseT, ReturnT> callAdapter;

        public CallAdapted(RequestFactory requestFactory, Call.Factory factory, Converter<ResponseBody, ResponseT> converter, CallAdapter<ResponseT, ReturnT> callAdapter) {
            super(requestFactory, factory, converter);
            this.callAdapter = callAdapter;
        }

        @Override // retrofit2.HttpServiceMethod
        public final Object adapt(OkHttpCall okHttpCall, Object[] objArr) {
            return this.callAdapter.adapt(okHttpCall);
        }
    }

    /* loaded from: classes4.dex */
    public static final class SuspendForBody<ResponseT> extends HttpServiceMethod<ResponseT, Object> {
        public final CallAdapter<ResponseT, Call<ResponseT>> callAdapter;
        public final boolean isNullable;

        public SuspendForBody(RequestFactory requestFactory, Call.Factory factory, Converter converter, CallAdapter callAdapter) {
            super(requestFactory, factory, converter);
            this.callAdapter = callAdapter;
            this.isNullable = false;
        }

        @Override // retrofit2.HttpServiceMethod
        public final Object adapt(OkHttpCall okHttpCall, Object[] objArr) {
            final Call call = (Call) this.callAdapter.adapt(okHttpCall);
            Continuation continuation = (Continuation) objArr[objArr.length - 1];
            try {
                if (this.isNullable) {
                    final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
                    cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: retrofit2.KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$2
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(Throwable th) {
                            Call.this.cancel();
                            return Unit.INSTANCE;
                        }
                    });
                    call.enqueue(new Callback<Object>() { // from class: retrofit2.KotlinExtensions$await$4$2
                        @Override // retrofit2.Callback
                        public final void onFailure(Call<Object> call2, Throwable t) {
                            Intrinsics.checkParameterIsNotNull(call2, "call");
                            Intrinsics.checkParameterIsNotNull(t, "t");
                            cancellableContinuationImpl.resumeWith(ResultKt.createFailure(t));
                        }

                        @Override // retrofit2.Callback
                        public final void onResponse(Call<Object> call2, Response<Object> response) {
                            Intrinsics.checkParameterIsNotNull(call2, "call");
                            Intrinsics.checkParameterIsNotNull(response, "response");
                            boolean z = response.rawResponse.isSuccessful;
                            CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
                            if (z) {
                                cancellableContinuation.resumeWith(response.body);
                            } else {
                                cancellableContinuation.resumeWith(ResultKt.createFailure(new HttpException(response)));
                            }
                        }
                    });
                    Object result = cancellableContinuationImpl.getResult();
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    return result;
                }
                final CancellableContinuationImpl cancellableContinuationImpl2 = new CancellableContinuationImpl(1, IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
                cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: retrofit2.KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Throwable th) {
                        Call.this.cancel();
                        return Unit.INSTANCE;
                    }
                });
                call.enqueue(new Callback<Object>() { // from class: retrofit2.KotlinExtensions$await$2$2
                    @Override // retrofit2.Callback
                    public final void onFailure(Call<Object> call2, Throwable t) {
                        Intrinsics.checkParameterIsNotNull(call2, "call");
                        Intrinsics.checkParameterIsNotNull(t, "t");
                        cancellableContinuationImpl2.resumeWith(ResultKt.createFailure(t));
                    }

                    @Override // retrofit2.Callback
                    public final void onResponse(Call<Object> call2, Response<Object> response) {
                        Intrinsics.checkParameterIsNotNull(call2, "call");
                        Intrinsics.checkParameterIsNotNull(response, "response");
                        boolean z = response.rawResponse.isSuccessful;
                        CancellableContinuation cancellableContinuation = cancellableContinuationImpl2;
                        if (z) {
                            Object obj = response.body;
                            if (obj == null) {
                                Request request = call2.request();
                                request.getClass();
                                ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Invocation.class);
                                Object cast = JvmClassMappingKt.getJavaClass(orCreateKotlinClass).cast(request.tags.get(orCreateKotlinClass));
                                if (cast != null) {
                                    StringBuilder sb = new StringBuilder("Response from ");
                                    Method method = ((Invocation) cast).method;
                                    Intrinsics.checkExpressionValueIsNotNull(method, "method");
                                    Class<?> declaringClass = method.getDeclaringClass();
                                    Intrinsics.checkExpressionValueIsNotNull(declaringClass, "method.declaringClass");
                                    sb.append(declaringClass.getName());
                                    sb.append('.');
                                    sb.append(method.getName());
                                    sb.append(" was null but response body type was declared as non-null");
                                    cancellableContinuation.resumeWith(ResultKt.createFailure(new KotlinNullPointerException(sb.toString())));
                                    return;
                                }
                                KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException();
                                Intrinsics.sanitizeStackTrace(Intrinsics.class.getName(), kotlinNullPointerException);
                                throw kotlinNullPointerException;
                            }
                            cancellableContinuation.resumeWith(obj);
                            return;
                        }
                        cancellableContinuation.resumeWith(ResultKt.createFailure(new HttpException(response)));
                    }
                });
                Object result2 = cancellableContinuationImpl2.getResult();
                CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                return result2;
            } catch (Exception e) {
                return KotlinExtensions.suspendAndThrow(e, continuation);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class SuspendForResponse<ResponseT> extends HttpServiceMethod<ResponseT, Object> {
        public final CallAdapter<ResponseT, Call<ResponseT>> callAdapter;

        public SuspendForResponse(RequestFactory requestFactory, Call.Factory factory, Converter<ResponseBody, ResponseT> converter, CallAdapter<ResponseT, Call<ResponseT>> callAdapter) {
            super(requestFactory, factory, converter);
            this.callAdapter = callAdapter;
        }

        @Override // retrofit2.HttpServiceMethod
        public final Object adapt(OkHttpCall okHttpCall, Object[] objArr) {
            final Call call = (Call) this.callAdapter.adapt(okHttpCall);
            Continuation continuation = (Continuation) objArr[objArr.length - 1];
            try {
                final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
                cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: retrofit2.KotlinExtensions$awaitResponse$$inlined$suspendCancellableCoroutine$lambda$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Throwable th) {
                        Call.this.cancel();
                        return Unit.INSTANCE;
                    }
                });
                call.enqueue(new Callback<Object>() { // from class: retrofit2.KotlinExtensions$awaitResponse$2$2
                    @Override // retrofit2.Callback
                    public final void onFailure(Call<Object> call2, Throwable t) {
                        Intrinsics.checkParameterIsNotNull(call2, "call");
                        Intrinsics.checkParameterIsNotNull(t, "t");
                        cancellableContinuationImpl.resumeWith(ResultKt.createFailure(t));
                    }

                    @Override // retrofit2.Callback
                    public final void onResponse(Call<Object> call2, Response<Object> response) {
                        Intrinsics.checkParameterIsNotNull(call2, "call");
                        Intrinsics.checkParameterIsNotNull(response, "response");
                        cancellableContinuationImpl.resumeWith(response);
                    }
                });
                Object result = cancellableContinuationImpl.getResult();
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                return result;
            } catch (Exception e) {
                return KotlinExtensions.suspendAndThrow(e, continuation);
            }
        }
    }

    public HttpServiceMethod(RequestFactory requestFactory, Call.Factory factory, Converter<ResponseBody, ResponseT> converter) {
        this.requestFactory = requestFactory;
        this.callFactory = factory;
        this.responseConverter = converter;
    }

    public abstract Object adapt(OkHttpCall okHttpCall, Object[] objArr);

    @Override // retrofit2.ServiceMethod
    public final ReturnT invoke(Object[] objArr) {
        return (ReturnT) adapt(new OkHttpCall(this.requestFactory, objArr, this.callFactory, this.responseConverter), objArr);
    }
}
