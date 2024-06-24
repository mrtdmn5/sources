package io.ktor.client.plugins.logging;

import io.ktor.client.statement.HttpResponse;
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
@DebugMetadata(c = "io.ktor.client.plugins.logging.Logging$setupResponseLogging$1", f = "Logging.kt", l = {184, 191, 191}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class Logging$setupResponseLogging$1 extends SuspendLambda implements Function3<PipelineContext<HttpResponse, Unit>, HttpResponse, Continuation<? super Unit>, Object> {
    public /* synthetic */ Object L$0;
    public /* synthetic */ Object L$1;
    public StringBuilder L$2;
    public int label;
    public final /* synthetic */ Logging this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Logging$setupResponseLogging$1(Logging logging, Continuation<? super Logging$setupResponseLogging$1> continuation) {
        super(3, continuation);
        this.this$0 = logging;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(PipelineContext<HttpResponse, Unit> pipelineContext, HttpResponse httpResponse, Continuation<? super Unit> continuation) {
        Logging$setupResponseLogging$1 logging$setupResponseLogging$1 = new Logging$setupResponseLogging$1(this.this$0, continuation);
        logging$setupResponseLogging$1.L$0 = pipelineContext;
        logging$setupResponseLogging$1.L$1 = httpResponse;
        return logging$setupResponseLogging$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Throwable th;
        HttpResponse httpResponse;
        HttpClientCallLogger httpClientCallLogger;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        StringBuilder sb = this.label;
        boolean z = true;
        Logging logging = this.this$0;
        try {
            if (sb != 0) {
                if (sb != 1) {
                    if (sb != 2) {
                        if (sb != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        th = (Throwable) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        throw th;
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                StringBuilder sb2 = this.L$2;
                httpClientCallLogger = (HttpClientCallLogger) this.L$1;
                httpResponse = (HttpResponse) this.L$0;
                ResultKt.throwOnFailure(obj);
                sb = sb2;
            } else {
                ResultKt.throwOnFailure(obj);
                PipelineContext pipelineContext = (PipelineContext) this.L$0;
                httpResponse = (HttpResponse) this.L$1;
                if (logging.level != LogLevel.NONE && !httpResponse.getCall().getAttributes().contains(LoggingKt.DisableLogging)) {
                    httpClientCallLogger = (HttpClientCallLogger) httpResponse.getCall().getAttributes().get(LoggingKt.ClientCallLogger);
                    StringBuilder sb3 = new StringBuilder();
                    LoggingUtilsKt.logResponseHeader(sb3, httpResponse.getCall().getResponse(), logging.level, logging.sanitizedHeaders);
                    Object subject = pipelineContext.getSubject();
                    this.L$0 = httpResponse;
                    this.L$1 = httpClientCallLogger;
                    this.L$2 = sb3;
                    this.label = 1;
                    sb = sb3;
                    if (pipelineContext.proceedWith(subject, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    return Unit.INSTANCE;
                }
            }
            String sb4 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb4, "header.toString()");
            httpClientCallLogger.logResponseHeader(sb4);
            if (!logging.level.getBody()) {
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.label = 2;
                if (httpClientCallLogger.closeResponseLog(this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            return Unit.INSTANCE;
        } catch (Throwable th2) {
            try {
                Logging.access$logResponseException(logging, sb, httpResponse.getCall().getRequest(), th2);
            } catch (Throwable th3) {
                th = th3;
                z = false;
            }
            try {
                throw th2;
            } catch (Throwable th4) {
                th = th4;
                String sb5 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb5, "header.toString()");
                httpClientCallLogger.logResponseHeader(sb5);
                if (z || !logging.level.getBody()) {
                    this.L$0 = th;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = 3;
                    if (httpClientCallLogger.closeResponseLog(this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    th = th;
                    throw th;
                }
                throw th;
            }
        }
    }
}
