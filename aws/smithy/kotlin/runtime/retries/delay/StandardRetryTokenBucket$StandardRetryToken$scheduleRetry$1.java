package aws.smithy.kotlin.runtime.retries.delay;

import aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: StandardRetryTokenBucket.kt */
@DebugMetadata(c = "aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket$StandardRetryToken", f = "StandardRetryTokenBucket.kt", l = {106}, m = "scheduleRetry")
/* loaded from: classes.dex */
public final class StandardRetryTokenBucket$StandardRetryToken$scheduleRetry$1 extends ContinuationImpl {
    public int I$0;
    public StandardRetryTokenBucket.StandardRetryToken L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ StandardRetryTokenBucket.StandardRetryToken this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StandardRetryTokenBucket$StandardRetryToken$scheduleRetry$1(StandardRetryTokenBucket.StandardRetryToken standardRetryToken, Continuation<? super StandardRetryTokenBucket$StandardRetryToken$scheduleRetry$1> continuation) {
        super(continuation);
        this.this$0 = standardRetryToken;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.scheduleRetry(null, this);
    }
}
