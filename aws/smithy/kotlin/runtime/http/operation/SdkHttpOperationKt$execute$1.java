package aws.smithy.kotlin.runtime.http.operation;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;

/* compiled from: SdkHttpOperation.kt */
@DebugMetadata(c = "aws.smithy.kotlin.runtime.http.operation.SdkHttpOperationKt", f = "SdkHttpOperation.kt", l = {98, 99, 101, 101}, m = "execute")
/* loaded from: classes.dex */
public final class SdkHttpOperationKt$execute$1<I, O, R> extends ContinuationImpl {
    public Object L$0;
    public Function2 L$1;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return SdkHttpOperationKt.execute(null, null, null, null, this);
    }
}
