package aws.smithy.kotlin.runtime.http.operation;

import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.io.Handler;
import kotlin.coroutines.Continuation;

/* compiled from: SdkOperationExecution.kt */
/* loaded from: classes.dex */
public final class MutateHandler<Output> implements Handler<OperationRequest<HttpRequestBuilder>, Output> {
    public final Handler<OperationRequest<HttpRequestBuilder>, Output> inner;

    /* JADX WARN: Multi-variable type inference failed */
    public MutateHandler(Handler<? super OperationRequest<HttpRequestBuilder>, ? extends Output> handler) {
        this.inner = handler;
    }

    @Override // aws.smithy.kotlin.runtime.io.Handler
    public final Object call(OperationRequest<HttpRequestBuilder> operationRequest, Continuation continuation) {
        return this.inner.call(operationRequest, continuation);
    }
}
