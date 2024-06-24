package io.ktor.client.plugins.api;

import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

/* compiled from: KtorCallContexts.kt */
@DebugMetadata(c = "io.ktor.client.plugins.api.RequestHook$install$1", f = "KtorCallContexts.kt", l = {46}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class RequestHook$install$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Function4<OnRequestContext, HttpRequestBuilder, Object, Continuation<? super Unit>, Object> $handler;
    public /* synthetic */ PipelineContext L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RequestHook$install$1(Function4<? super OnRequestContext, ? super HttpRequestBuilder, Object, ? super Continuation<? super Unit>, ? extends Object> function4, Continuation<? super RequestHook$install$1> continuation) {
        super(3, continuation);
        this.$handler = function4;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation<? super Unit> continuation) {
        RequestHook$install$1 requestHook$install$1 = new RequestHook$install$1(this.$handler, continuation);
        requestHook$install$1.L$0 = pipelineContext;
        return requestHook$install$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
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
            OnRequestContext onRequestContext = new OnRequestContext();
            TContext tcontext = pipelineContext.context;
            Object subject = pipelineContext.getSubject();
            this.label = 1;
            if (this.$handler.invoke(onRequestContext, tcontext, subject, this) == obj2) {
                return obj2;
            }
        }
        return Unit.INSTANCE;
    }
}
