package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorJobImpl;
import org.slf4j.Logger;

/* compiled from: HttpRequestLifecycle.kt */
@DebugMetadata(c = "io.ktor.client.plugins.HttpRequestLifecycle$Plugin$install$1", f = "HttpRequestLifecycle.kt", l = {38}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class HttpRequestLifecycle$Plugin$install$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {
    public final /* synthetic */ HttpClient $scope;
    public /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpRequestLifecycle$Plugin$install$1(HttpClient httpClient, Continuation<? super HttpRequestLifecycle$Plugin$install$1> continuation) {
        super(3, continuation);
        this.$scope = httpClient;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation<? super Unit> continuation) {
        HttpRequestLifecycle$Plugin$install$1 httpRequestLifecycle$Plugin$install$1 = new HttpRequestLifecycle$Plugin$install$1(this.$scope, continuation);
        httpRequestLifecycle$Plugin$install$1.L$0 = pipelineContext;
        return httpRequestLifecycle$Plugin$install$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CompletableJob completableJob;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                completableJob = (CompletableJob) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Throwable th) {
                    th = th;
                    try {
                        completableJob.completeExceptionally(th);
                        throw th;
                    } catch (Throwable th2) {
                        completableJob.complete();
                        throw th2;
                    }
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            PipelineContext pipelineContext = (PipelineContext) this.L$0;
            final SupervisorJobImpl supervisorJobImpl = new SupervisorJobImpl(((HttpRequestBuilder) pipelineContext.context).executionContext);
            CoroutineContext.Element element = this.$scope.coroutineContext.get(Job.Key.$$INSTANCE);
            Intrinsics.checkNotNull(element);
            Logger logger = HttpRequestLifecycleKt.LOGGER;
            final DisposableHandle invokeOnCompletion = ((Job) element).invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: io.ktor.client.plugins.HttpRequestLifecycleKt$attachToClientEngineJob$handler$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Throwable th3) {
                    Throwable th4 = th3;
                    CompletableJob completableJob2 = supervisorJobImpl;
                    if (th4 != null) {
                        HttpRequestLifecycleKt.LOGGER.trace("Cancelling request because engine Job failed with error: " + th4);
                        completableJob2.cancel(ExceptionsKt.CancellationException("Engine failed", th4));
                    } else {
                        HttpRequestLifecycleKt.LOGGER.trace("Cancelling request because engine Job completed");
                        completableJob2.complete();
                    }
                    return Unit.INSTANCE;
                }
            });
            supervisorJobImpl.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: io.ktor.client.plugins.HttpRequestLifecycleKt$attachToClientEngineJob$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Throwable th3) {
                    DisposableHandle.this.dispose();
                    return Unit.INSTANCE;
                }
            });
            try {
                HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) pipelineContext.context;
                httpRequestBuilder.getClass();
                httpRequestBuilder.executionContext = supervisorJobImpl;
                this.L$0 = supervisorJobImpl;
                this.label = 1;
                if (pipelineContext.proceed(this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                completableJob = supervisorJobImpl;
            } catch (Throwable th3) {
                th = th3;
                completableJob = supervisorJobImpl;
                completableJob.completeExceptionally(th);
                throw th;
            }
        }
        completableJob.complete();
        return Unit.INSTANCE;
    }
}
