package aws.sdk.kotlin.runtime.config.imds;

import aws.smithy.kotlin.runtime.http.response.HttpCall;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: TokenMiddleware.kt */
@DebugMetadata(c = "aws.sdk.kotlin.runtime.config.imds.TokenMiddleware", f = "TokenMiddleware.kt", l = {68, 73, 86, 86}, m = "getToken")
/* loaded from: classes.dex */
public final class TokenMiddleware$getToken$1 extends ContinuationImpl {
    public long J$0;
    public Object L$0;
    public HttpCall L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ TokenMiddleware this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TokenMiddleware$getToken$1(TokenMiddleware tokenMiddleware, Continuation<? super TokenMiddleware$getToken$1> continuation) {
        super(continuation);
        this.this$0 = tokenMiddleware;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return TokenMiddleware.access$getToken(this.this$0, null, null, this);
    }
}
