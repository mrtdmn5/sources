package aws.smithy.kotlin.runtime.http.operation;

import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.http.response.HttpCall;
import aws.smithy.kotlin.runtime.io.Handler;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: SdkOperationExecution.kt */
/* loaded from: classes.dex */
public final /* synthetic */ class SdkOperationExecutionKt$decorate$1 extends FunctionReferenceImpl implements Function3<OperationRequest<HttpRequestBuilder>, Handler<? super OperationRequest<HttpRequestBuilder>, ? extends HttpCall>, Continuation<? super HttpCall>, Object> {
    public static final SdkOperationExecutionKt$decorate$1 INSTANCE = new SdkOperationExecutionKt$decorate$1();

    public SdkOperationExecutionKt$decorate$1() {
        super(3, SdkOperationExecutionKt.class, "httpTraceMiddleware", "httpTraceMiddleware(Laws/smithy/kotlin/runtime/http/operation/OperationRequest;Laws/smithy/kotlin/runtime/io/Handler;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 1);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(OperationRequest<HttpRequestBuilder> operationRequest, Handler<? super OperationRequest<HttpRequestBuilder>, ? extends HttpCall> handler, Continuation<? super HttpCall> continuation) {
        return SdkOperationExecutionKt.access$httpTraceMiddleware(operationRequest, handler, continuation);
    }
}
