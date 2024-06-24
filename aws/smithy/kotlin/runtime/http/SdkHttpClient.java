package aws.smithy.kotlin.runtime.http;

import aws.smithy.kotlin.runtime.http.engine.HttpClientEngine;
import aws.smithy.kotlin.runtime.http.engine.HttpClientEngineClosedException;
import aws.smithy.kotlin.runtime.http.engine.SdkRequestContextElement;
import aws.smithy.kotlin.runtime.http.operation.OperationRequest;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.http.request.RealHttpRequest;
import aws.smithy.kotlin.runtime.http.response.HttpCall;
import aws.smithy.kotlin.runtime.io.Handler;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import aws.smithy.kotlin.runtime.tracing.CoroutineContextUtilsKt;
import aws.smithy.kotlin.runtime.tracing.TraceSpanContextElement;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobImpl;
import kotlinx.coroutines.JobKt;

/* compiled from: SdkHttpClient.kt */
/* loaded from: classes.dex */
public final class SdkHttpClient implements Handler<OperationRequest<HttpRequestBuilder>, HttpCall> {
    public final HttpClientEngine engine;

    public SdkHttpClient(HttpClientEngine engine) {
        Intrinsics.checkNotNullParameter(engine, "engine");
        this.engine = engine;
    }

    @Override // aws.smithy.kotlin.runtime.io.Handler
    public final Object call(OperationRequest<HttpRequestBuilder> operationRequest, Continuation<? super HttpCall> continuation) {
        OperationRequest<HttpRequestBuilder> operationRequest2 = operationRequest;
        return executeWithCallContext(operationRequest2.context, operationRequest2.subject.build(), continuation);
    }

    public final Object executeWithCallContext(ExecutionContext executionContext, RealHttpRequest realHttpRequest, Continuation continuation) {
        HttpClientEngine httpClientEngine = this.engine;
        if (JobKt.getJob(httpClientEngine.getCoroutineContext()).isActive()) {
            CoroutineContext outerContext = continuation.getContext();
            Intrinsics.checkNotNullParameter(outerContext, "outerContext");
            CoroutineContext coroutineContext = httpClientEngine.getCoroutineContext();
            Job.Key key = Job.Key.$$INSTANCE;
            final JobImpl jobImpl = new JobImpl((Job) coroutineContext.get(key));
            CoroutineContext plus = httpClientEngine.getCoroutineContext().plus(jobImpl).plus(new CoroutineName("request-context")).plus(new TraceSpanContextElement(CoroutineContextUtilsKt.getTraceSpan(outerContext)));
            Job job = (Job) outerContext.get(key);
            if (job != null) {
                final DisposableHandle invokeOnCompletion$default = Job.DefaultImpls.invokeOnCompletion$default(job, true, new Function1<Throwable, Unit>() { // from class: aws.smithy.kotlin.runtime.http.engine.CoroutineUtilsKt$attachToOuterJob$cleanupHandler$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Throwable th) {
                        Throwable th2 = th;
                        if (th2 != null) {
                            jobImpl.cancel(ExceptionsKt.CancellationException(th2.getMessage(), th2));
                        }
                        return Unit.INSTANCE;
                    }
                }, 2);
                jobImpl.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: aws.smithy.kotlin.runtime.http.engine.CoroutineUtilsKt$attachToOuterJob$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Throwable th) {
                        DisposableHandle.this.dispose();
                        return Unit.INSTANCE;
                    }
                });
            }
            return BuildersKt.withContext(plus.plus(new SdkRequestContextElement(plus)), new SdkHttpClient$executeWithCallContext$2(this, executionContext, realHttpRequest, null), continuation);
        }
        throw new HttpClientEngineClosedException(0);
    }
}
