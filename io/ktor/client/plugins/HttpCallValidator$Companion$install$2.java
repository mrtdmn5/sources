package io.ktor.client.plugins;

import com.animaconnected.secondo.R;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.statement.HttpResponseContainer;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function3;

/* compiled from: HttpCallValidator.kt */
@DebugMetadata(c = "io.ktor.client.plugins.HttpCallValidator$Companion$install$2", f = "HttpCallValidator.kt", l = {R.styleable.AppTheme_stepsHistoryGoalLegendColorDetail, R.styleable.AppTheme_stepsHistoryHintBackgroundColorActivity}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class HttpCallValidator$Companion$install$2 extends SuspendLambda implements Function3<PipelineContext<HttpResponseContainer, HttpClientCall>, HttpResponseContainer, Continuation<? super Unit>, Object> {
    public final /* synthetic */ HttpCallValidator $plugin;
    public /* synthetic */ Object L$0;
    public /* synthetic */ HttpResponseContainer L$1;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpCallValidator$Companion$install$2(HttpCallValidator httpCallValidator, Continuation<? super HttpCallValidator$Companion$install$2> continuation) {
        super(3, continuation);
        this.$plugin = httpCallValidator;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(PipelineContext<HttpResponseContainer, HttpClientCall> pipelineContext, HttpResponseContainer httpResponseContainer, Continuation<? super Unit> continuation) {
        HttpCallValidator$Companion$install$2 httpCallValidator$Companion$install$2 = new HttpCallValidator$Companion$install$2(this.$plugin, continuation);
        httpCallValidator$Companion$install$2.L$0 = pipelineContext;
        httpCallValidator$Companion$install$2.L$1 = httpResponseContainer;
        return httpCallValidator$Companion$install$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [io.ktor.util.pipeline.PipelineContext] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v8 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        ?? r1 = this.label;
        try {
            if (r1 != 0) {
                if (r1 != 1) {
                    if (r1 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Throwable th = (Throwable) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    throw th;
                }
                PipelineContext pipelineContext = (PipelineContext) this.L$0;
                ResultKt.throwOnFailure(obj);
                r1 = pipelineContext;
            } else {
                ResultKt.throwOnFailure(obj);
                PipelineContext pipelineContext2 = (PipelineContext) this.L$0;
                HttpResponseContainer httpResponseContainer = this.L$1;
                this.L$0 = pipelineContext2;
                this.label = 1;
                Object proceedWith = pipelineContext2.proceedWith(httpResponseContainer, this);
                r1 = pipelineContext2;
                if (proceedWith == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            return Unit.INSTANCE;
        } catch (Throwable th2) {
            Throwable unwrapCancellationException = AutoCloseableKt.unwrapCancellationException(th2);
            HttpRequest request = ((HttpClientCall) r1.context).getRequest();
            this.L$0 = unwrapCancellationException;
            this.label = 2;
            if (HttpCallValidator.access$processException(this.$plugin, unwrapCancellationException, request, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
            throw unwrapCancellationException;
        }
    }
}
