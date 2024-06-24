package io.ktor.client.plugins;

import io.ktor.client.content.ObservableContent;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BodyProgress.kt */
@DebugMetadata(c = "io.ktor.client.plugins.BodyProgress$handle$1", f = "BodyProgress.kt", l = {38}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class BodyProgress$handle$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {
    public /* synthetic */ PipelineContext L$0;
    public /* synthetic */ Object L$1;
    public int label;

    public BodyProgress$handle$1(Continuation<? super BodyProgress$handle$1> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation<? super Unit> continuation) {
        BodyProgress$handle$1 bodyProgress$handle$1 = new BodyProgress$handle$1(continuation);
        bodyProgress$handle$1.L$0 = pipelineContext;
        bodyProgress$handle$1.L$1 = obj;
        return bodyProgress$handle$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
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
            Object obj2 = this.L$1;
            Function3 function3 = (Function3) ((HttpRequestBuilder) pipelineContext.context).attributes.getOrNull(BodyProgressKt.UploadProgressListenerAttributeKey);
            if (function3 == null) {
                return Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type io.ktor.http.content.OutgoingContent");
            ObservableContent observableContent = new ObservableContent((OutgoingContent) obj2, ((HttpRequestBuilder) pipelineContext.context).executionContext, function3);
            this.L$0 = null;
            this.label = 1;
            if (pipelineContext.proceedWith(observableContent, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }
}
