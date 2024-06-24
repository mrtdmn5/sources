package aws.smithy.kotlin.runtime.http.engine.okhttp;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okio.BufferedSink;

/* compiled from: StreamingRequestBody.kt */
@DebugMetadata(c = "aws.smithy.kotlin.runtime.http.engine.okhttp.StreamingRequestBody$doWriteTo$2", f = "StreamingRequestBody.kt", l = {67}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class StreamingRequestBody$doWriteTo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Long>, Object> {
    public final /* synthetic */ BufferedSink $sink;
    public int label;
    public final /* synthetic */ StreamingRequestBody this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamingRequestBody$doWriteTo$2(StreamingRequestBody streamingRequestBody, Continuation continuation, BufferedSink bufferedSink) {
        super(2, continuation);
        this.this$0 = streamingRequestBody;
        this.$sink = bufferedSink;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StreamingRequestBody$doWriteTo$2(this.this$0, continuation, this.$sink);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Long> continuation) {
        return ((StreamingRequestBody$doWriteTo$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = StreamingRequestBody.access$transferBody(this.this$0, this, this.$sink);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return obj;
    }
}
