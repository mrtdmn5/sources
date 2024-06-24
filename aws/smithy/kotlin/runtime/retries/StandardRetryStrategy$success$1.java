package aws.smithy.kotlin.runtime.retries;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: StandardRetryStrategy.kt */
@DebugMetadata(c = "aws.smithy.kotlin.runtime.retries.StandardRetryStrategy", f = "StandardRetryStrategy.kt", l = {91}, m = "success")
/* loaded from: classes.dex */
public final class StandardRetryStrategy$success$1<R> extends ContinuationImpl {
    public int I$0;
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ StandardRetryStrategy this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StandardRetryStrategy$success$1(StandardRetryStrategy standardRetryStrategy, Continuation<? super StandardRetryStrategy$success$1> continuation) {
        super(continuation);
        this.this$0 = standardRetryStrategy;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.success(null, 0, null, this);
    }
}
