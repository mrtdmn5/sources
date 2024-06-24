package aws.smithy.kotlin.runtime.http.operation;

import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.http.response.HttpCall;
import aws.smithy.kotlin.runtime.io.Handler;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: SdkOperationExecution.kt */
@DebugMetadata(c = "aws.smithy.kotlin.runtime.http.operation.HttpCallMiddleware", f = "SdkOperationExecution.kt", l = {295, 297}, m = "handle")
/* loaded from: classes.dex */
public final class HttpCallMiddleware$handle$1<H extends Handler<? super OperationRequest<HttpRequestBuilder>, ? extends HttpCall>> extends ContinuationImpl {
    public HttpCallMiddleware L$0;
    public OperationRequest L$1;
    public Handler L$2;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ HttpCallMiddleware this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpCallMiddleware$handle$1(HttpCallMiddleware httpCallMiddleware, Continuation<? super HttpCallMiddleware$handle$1> continuation) {
        super(continuation);
        this.this$0 = httpCallMiddleware;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.handle2((OperationRequest<HttpRequestBuilder>) null, (OperationRequest<HttpRequestBuilder>) null, this);
    }
}
