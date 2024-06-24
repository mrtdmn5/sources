package aws.smithy.kotlin.runtime.retries;

import aws.smithy.kotlin.runtime.retries.policy.RetryPolicy;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

/* compiled from: StandardRetryStrategy.kt */
@DebugMetadata(c = "aws.smithy.kotlin.runtime.retries.StandardRetryStrategy", f = "StandardRetryStrategy.kt", l = {32, 32}, m = "retry")
/* loaded from: classes.dex */
public final class StandardRetryStrategy$retry$1<R> extends ContinuationImpl {
    public int I$0;
    public StandardRetryStrategy L$0;
    public Function1 L$1;
    public RetryPolicy L$2;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ StandardRetryStrategy this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StandardRetryStrategy$retry$1(StandardRetryStrategy standardRetryStrategy, Continuation<? super StandardRetryStrategy$retry$1> continuation) {
        super(continuation);
        this.this$0 = standardRetryStrategy;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.retry(null, null, this);
    }
}
