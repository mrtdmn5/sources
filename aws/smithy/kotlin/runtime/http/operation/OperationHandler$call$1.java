package aws.smithy.kotlin.runtime.http.operation;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: SdkOperationExecution.kt */
@DebugMetadata(c = "aws.smithy.kotlin.runtime.http.operation.OperationHandler", f = "SdkOperationExecution.kt", l = {190, 193}, m = "call")
/* loaded from: classes.dex */
public final class OperationHandler$call$1 extends ContinuationImpl {
    public OperationHandler L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ OperationHandler<Input, Output> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperationHandler$call$1(OperationHandler<Input, Output> operationHandler, Continuation<? super OperationHandler$call$1> continuation) {
        super(continuation);
        this.this$0 = operationHandler;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.call((OperationRequest) null, (Continuation) this);
    }
}
