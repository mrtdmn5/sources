package aws.smithy.kotlin.runtime.http.operation;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: SdkOperationExecution.kt */
@DebugMetadata(c = "aws.smithy.kotlin.runtime.http.operation.SdkOperationExecutionKt", f = "SdkOperationExecution.kt", l = {313, 317, 320}, m = "httpTraceMiddleware")
/* loaded from: classes.dex */
public final class SdkOperationExecutionKt$httpTraceMiddleware$1 extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return SdkOperationExecutionKt.access$httpTraceMiddleware(null, null, this);
    }
}
