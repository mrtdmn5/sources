package aws.smithy.kotlin.runtime.http.middleware;

import aws.smithy.kotlin.runtime.http.operation.OperationRequest;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ResolveEndpoint.kt */
@DebugMetadata(c = "aws.smithy.kotlin.runtime.http.middleware.ResolveEndpoint", f = "ResolveEndpoint.kt", l = {28}, m = "modifyRequest")
/* loaded from: classes.dex */
public final class ResolveEndpoint$modifyRequest$1 extends ContinuationImpl {
    public OperationRequest L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ ResolveEndpoint<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResolveEndpoint$modifyRequest$1(ResolveEndpoint<T> resolveEndpoint, Continuation<? super ResolveEndpoint$modifyRequest$1> continuation) {
        super(continuation);
        this.this$0 = resolveEndpoint;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.modifyRequest((OperationRequest<HttpRequestBuilder>) null, this);
    }
}
