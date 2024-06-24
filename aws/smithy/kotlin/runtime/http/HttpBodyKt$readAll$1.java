package aws.smithy.kotlin.runtime.http;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: HttpBody.kt */
@DebugMetadata(c = "aws.smithy.kotlin.runtime.http.HttpBodyKt", f = "HttpBody.kt", l = {182, 186}, m = "readAll")
/* loaded from: classes.dex */
public final class HttpBodyKt$readAll$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return HttpBodyKt.readAll(null, this);
    }
}
