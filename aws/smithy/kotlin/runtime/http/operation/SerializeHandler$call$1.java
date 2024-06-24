package aws.smithy.kotlin.runtime.http.operation;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: SdkOperationExecution.kt */
@DebugMetadata(c = "aws.smithy.kotlin.runtime.http.operation.SerializeHandler", f = "SdkOperationExecution.kt", l = {217, 224, 231}, m = "call")
/* loaded from: classes.dex */
public final class SerializeHandler$call$1 extends ContinuationImpl {
    public long J$0;
    public SerializeHandler L$0;
    public OperationRequest L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ SerializeHandler<Input, Output> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SerializeHandler$call$1(SerializeHandler<Input, Output> serializeHandler, Continuation<? super SerializeHandler$call$1> continuation) {
        super(continuation);
        this.this$0 = serializeHandler;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.call((OperationRequest) null, (Continuation) this);
    }
}
