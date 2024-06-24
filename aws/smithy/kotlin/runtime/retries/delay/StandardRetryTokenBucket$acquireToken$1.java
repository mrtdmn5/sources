package aws.smithy.kotlin.runtime.retries.delay;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: StandardRetryTokenBucket.kt */
@DebugMetadata(c = "aws.smithy.kotlin.runtime.retries.delay.StandardRetryTokenBucket", f = "StandardRetryTokenBucket.kt", l = {42}, m = "acquireToken")
/* loaded from: classes.dex */
public final class StandardRetryTokenBucket$acquireToken$1 extends ContinuationImpl {
    public StandardRetryTokenBucket L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ StandardRetryTokenBucket this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StandardRetryTokenBucket$acquireToken$1(StandardRetryTokenBucket standardRetryTokenBucket, Continuation<? super StandardRetryTokenBucket$acquireToken$1> continuation) {
        super(continuation);
        this.this$0 = standardRetryTokenBucket;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.acquireToken(this);
    }
}
