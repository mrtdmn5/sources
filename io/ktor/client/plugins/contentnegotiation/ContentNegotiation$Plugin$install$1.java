package io.ktor.client.plugins.contentnegotiation;

import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* compiled from: ContentNegotiation.kt */
@DebugMetadata(c = "io.ktor.client.plugins.contentnegotiation.ContentNegotiation$Plugin$install$1", f = "ContentNegotiation.kt", l = {251, 252}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ContentNegotiation$Plugin$install$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {
    public final /* synthetic */ ContentNegotiation $plugin;
    public /* synthetic */ PipelineContext L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentNegotiation$Plugin$install$1(ContentNegotiation contentNegotiation, Continuation<? super ContentNegotiation$Plugin$install$1> continuation) {
        super(3, continuation);
        this.$plugin = contentNegotiation;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation<? super Unit> continuation) {
        ContentNegotiation$Plugin$install$1 contentNegotiation$Plugin$install$1 = new ContentNegotiation$Plugin$install$1(this.$plugin, continuation);
        contentNegotiation$Plugin$install$1.L$0 = pipelineContext;
        return contentNegotiation$Plugin$install$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        PipelineContext pipelineContext;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 != 1) {
                if (r1 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            pipelineContext = this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            pipelineContext = this.L$0;
            HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) pipelineContext.context;
            Object subject = pipelineContext.getSubject();
            this.L$0 = pipelineContext;
            this.label = 1;
            obj = this.$plugin.convertRequest$ktor_client_content_negotiation(httpRequestBuilder, subject, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        if (obj == null) {
            return Unit.INSTANCE;
        }
        this.L$0 = null;
        this.label = 2;
        if (pipelineContext.proceedWith(obj, this) == coroutineSingletons) {
            return coroutineSingletons;
        }
        return Unit.INSTANCE;
    }
}
