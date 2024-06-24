package io.ktor.client.plugins.logging;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.HttpResponseContainer;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Logging.kt */
@DebugMetadata(c = "io.ktor.client.plugins.logging.Logging$setupResponseLogging$2", f = "Logging.kt", l = {201, 206, 207}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class Logging$setupResponseLogging$2 extends SuspendLambda implements Function3<PipelineContext<HttpResponseContainer, HttpClientCall>, HttpResponseContainer, Continuation<? super Unit>, Object> {
    public /* synthetic */ Object L$0;
    public HttpClientCallLogger L$1;
    public int label;
    public final /* synthetic */ Logging this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Logging$setupResponseLogging$2(Logging logging, Continuation<? super Logging$setupResponseLogging$2> continuation) {
        super(3, continuation);
        this.this$0 = logging;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(PipelineContext<HttpResponseContainer, HttpClientCall> pipelineContext, HttpResponseContainer httpResponseContainer, Continuation<? super Unit> continuation) {
        Logging$setupResponseLogging$2 logging$setupResponseLogging$2 = new Logging$setupResponseLogging$2(this.this$0, continuation);
        logging$setupResponseLogging$2.L$0 = pipelineContext;
        return logging$setupResponseLogging$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [io.ktor.util.pipeline.PipelineContext] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        HttpClientCallLogger httpClientCallLogger;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        ?? r1 = this.label;
        Logging logging = this.this$0;
        try {
        } catch (Throwable th) {
            th = th;
            StringBuilder sb = new StringBuilder();
            HttpClientCallLogger httpClientCallLogger2 = (HttpClientCallLogger) ((HttpClientCall) r1.context).getAttributes().get(LoggingKt.ClientCallLogger);
            Logging.access$logResponseException(logging, sb, ((HttpClientCall) r1.context).getRequest(), th);
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "log.toString()");
            this.L$0 = th;
            this.L$1 = httpClientCallLogger2;
            this.label = 2;
            if (httpClientCallLogger2.logResponseException(sb2, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
            httpClientCallLogger = httpClientCallLogger2;
        }
        if (r1 != 0) {
            if (r1 != 1) {
                if (r1 != 2) {
                    if (r1 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Throwable th2 = (Throwable) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    throw th2;
                }
                httpClientCallLogger = this.L$1;
                Throwable th3 = (Throwable) this.L$0;
                ResultKt.throwOnFailure(obj);
                th = th3;
                this.L$0 = th;
                this.L$1 = null;
                this.label = 3;
                if (httpClientCallLogger.closeResponseLog(this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                throw th;
            }
            PipelineContext pipelineContext = (PipelineContext) this.L$0;
            ResultKt.throwOnFailure(obj);
            r1 = pipelineContext;
        } else {
            ResultKt.throwOnFailure(obj);
            PipelineContext pipelineContext2 = (PipelineContext) this.L$0;
            if (logging.level != LogLevel.NONE && !((HttpClientCall) pipelineContext2.context).getAttributes().contains(LoggingKt.DisableLogging)) {
                this.L$0 = pipelineContext2;
                this.label = 1;
                Object proceed = pipelineContext2.proceed(this);
                r1 = pipelineContext2;
                if (proceed == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                return Unit.INSTANCE;
            }
        }
        return Unit.INSTANCE;
    }
}
