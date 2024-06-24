package aws.smithy.kotlin.runtime.http.engine.okhttp;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.JobImpl;

/* compiled from: StreamingRequestBody.kt */
@DebugMetadata(c = "aws.smithy.kotlin.runtime.http.engine.okhttp.StreamingRequestBody", f = "StreamingRequestBody.kt", l = {76}, m = "transferBody")
/* loaded from: classes.dex */
public final class StreamingRequestBody$transferBody$1 extends ContinuationImpl {
    public JobImpl L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ StreamingRequestBody this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamingRequestBody$transferBody$1(StreamingRequestBody streamingRequestBody, Continuation<? super StreamingRequestBody$transferBody$1> continuation) {
        super(continuation);
        this.this$0 = streamingRequestBody;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return StreamingRequestBody.access$transferBody(this.this$0, this, null);
    }
}
