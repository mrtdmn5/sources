package io.ktor.client.plugins.api;

import io.ktor.client.statement.HttpResponse;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* compiled from: KtorCallContexts.kt */
@DebugMetadata(c = "io.ktor.client.plugins.api.ResponseHook$install$1", f = "KtorCallContexts.kt", l = {59}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ResponseHook$install$1 extends SuspendLambda implements Function3<PipelineContext<HttpResponse, Unit>, HttpResponse, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Function3<OnResponseContext, HttpResponse, Continuation<? super Unit>, Object> $handler;
    public /* synthetic */ PipelineContext L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ResponseHook$install$1(Function3<? super OnResponseContext, ? super HttpResponse, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super ResponseHook$install$1> continuation) {
        super(3, continuation);
        this.$handler = function3;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(PipelineContext<HttpResponse, Unit> pipelineContext, HttpResponse httpResponse, Continuation<? super Unit> continuation) {
        ResponseHook$install$1 responseHook$install$1 = new ResponseHook$install$1(this.$handler, continuation);
        responseHook$install$1.L$0 = pipelineContext;
        return responseHook$install$1.invokeSuspend(Unit.INSTANCE);
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
            OnResponseContext onResponseContext = new OnResponseContext();
            Object subject = pipelineContext.getSubject();
            this.label = 1;
            if (this.$handler.invoke(onResponseContext, subject, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }
}
