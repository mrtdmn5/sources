package aws.sdk.kotlin.runtime.config.imds;

import aws.smithy.kotlin.runtime.http.operation.OperationRequest;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: TokenMiddleware.kt */
@DebugMetadata(c = "aws.sdk.kotlin.runtime.config.imds.TokenMiddleware", f = "TokenMiddleware.kt", l = {45}, m = "modifyRequest")
/* loaded from: classes.dex */
public final class TokenMiddleware$modifyRequest$1 extends ContinuationImpl {
    public OperationRequest L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ TokenMiddleware this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TokenMiddleware$modifyRequest$1(TokenMiddleware tokenMiddleware, Continuation<? super TokenMiddleware$modifyRequest$1> continuation) {
        super(continuation);
        this.this$0 = tokenMiddleware;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.modifyRequest((OperationRequest<HttpRequestBuilder>) null, this);
    }
}
