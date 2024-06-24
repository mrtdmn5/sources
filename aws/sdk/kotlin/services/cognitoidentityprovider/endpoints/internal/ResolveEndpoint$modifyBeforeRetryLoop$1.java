package aws.sdk.kotlin.services.cognitoidentityprovider.endpoints.internal;

import aws.smithy.kotlin.runtime.client.ProtocolRequestInterceptorContext;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ResolveEndpoint.kt */
@DebugMetadata(c = "aws.sdk.kotlin.services.cognitoidentityprovider.endpoints.internal.ResolveEndpoint", f = "ResolveEndpoint.kt", l = {33}, m = "modifyBeforeRetryLoop")
/* loaded from: classes.dex */
public final class ResolveEndpoint$modifyBeforeRetryLoop$1 extends ContinuationImpl {
    public ProtocolRequestInterceptorContext L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ ResolveEndpoint<Object> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResolveEndpoint$modifyBeforeRetryLoop$1(ResolveEndpoint<Object> resolveEndpoint, Continuation<? super ResolveEndpoint$modifyBeforeRetryLoop$1> continuation) {
        super(continuation);
        this.this$0 = resolveEndpoint;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.modifyBeforeRetryLoop(null, this);
    }
}
