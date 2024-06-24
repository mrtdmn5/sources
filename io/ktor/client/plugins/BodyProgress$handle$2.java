package io.ktor.client.plugins;

import io.ktor.client.statement.HttpResponse;
import io.ktor.client.utils.ByteChannelUtilsKt;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.functions.Function3;

/* compiled from: BodyProgress.kt */
@DebugMetadata(c = "io.ktor.client.plugins.BodyProgress$handle$2", f = "BodyProgress.kt", l = {45}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class BodyProgress$handle$2 extends SuspendLambda implements Function3<PipelineContext<HttpResponse, Unit>, HttpResponse, Continuation<? super Unit>, Object> {
    public /* synthetic */ PipelineContext L$0;
    public /* synthetic */ HttpResponse L$1;
    public int label;

    public BodyProgress$handle$2(Continuation<? super BodyProgress$handle$2> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(PipelineContext<HttpResponse, Unit> pipelineContext, HttpResponse httpResponse, Continuation<? super Unit> continuation) {
        BodyProgress$handle$2 bodyProgress$handle$2 = new BodyProgress$handle$2(continuation);
        bodyProgress$handle$2.L$0 = pipelineContext;
        bodyProgress$handle$2.L$1 = httpResponse;
        return bodyProgress$handle$2.invokeSuspend(Unit.INSTANCE);
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
            PipelineContext pipelineContext = this.L$0;
            HttpResponse httpResponse = this.L$1;
            Function3 function3 = (Function3) httpResponse.getCall().getRequest().getAttributes().getOrNull(BodyProgressKt.DownloadProgressListenerAttributeKey);
            if (function3 == null) {
                return Unit.INSTANCE;
            }
            HttpResponse response = ProgressionUtilKt.wrapWithContent(httpResponse.getCall(), ByteChannelUtilsKt.observable(httpResponse.getContent(), httpResponse.getCoroutineContext(), HttpMessagePropertiesKt.contentLength(httpResponse), function3)).getResponse();
            this.L$0 = null;
            this.label = 1;
            if (pipelineContext.proceedWith(response, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }
}
