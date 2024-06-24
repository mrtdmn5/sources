package aws.smithy.kotlin.runtime.http.operation;

import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.http.response.HttpCall;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: SdkOperationExecution.kt */
@DebugMetadata(c = "aws.smithy.kotlin.runtime.http.operation.DeserializeHandler", f = "SdkOperationExecution.kt", l = {265, 267, 273}, m = "call")
/* loaded from: classes.dex */
public final class DeserializeHandler$call$1 extends ContinuationImpl {
    public long J$0;
    public DeserializeHandler L$0;
    public Object L$1;
    public HttpCall L$2;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ DeserializeHandler<Input, Output> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializeHandler$call$1(DeserializeHandler<Input, Output> deserializeHandler, Continuation<? super DeserializeHandler$call$1> continuation) {
        super(continuation);
        this.this$0 = deserializeHandler;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.call((OperationRequest<HttpRequestBuilder>) null, (Continuation) this);
    }
}
