package aws.smithy.kotlin.runtime.retries;

import aws.smithy.kotlin.runtime.retries.delay.RetryToken;
import aws.smithy.kotlin.runtime.retries.policy.RetryDirective;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: StandardRetryStrategy.kt */
@DebugMetadata(c = "aws.smithy.kotlin.runtime.retries.StandardRetryStrategy", f = "StandardRetryStrategy.kt", l = {51, 59, 69, 70, 76}, m = "doTryLoop")
/* loaded from: classes.dex */
public final class StandardRetryStrategy$doTryLoop$1<R> extends ContinuationImpl {
    public int I$0;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public RetryToken L$3;
    public Object L$4;
    public RetryDirective L$5;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ StandardRetryStrategy this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StandardRetryStrategy$doTryLoop$1(StandardRetryStrategy standardRetryStrategy, Continuation<? super StandardRetryStrategy$doTryLoop$1> continuation) {
        super(continuation);
        this.this$0 = standardRetryStrategy;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.doTryLoop(null, null, 0, null, this);
    }
}
