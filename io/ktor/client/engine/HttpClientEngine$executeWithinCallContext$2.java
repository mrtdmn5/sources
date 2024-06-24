package io.ktor.client.engine;

import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpResponseData;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* compiled from: HttpClientEngine.kt */
@DebugMetadata(c = "io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$2", f = "HttpClientEngine.kt", l = {99}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class HttpClientEngine$executeWithinCallContext$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super HttpResponseData>, Object> {
    public final /* synthetic */ HttpRequestData $requestData;
    public int label;
    public final /* synthetic */ HttpClientEngine this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpClientEngine$executeWithinCallContext$2(HttpClientEngine httpClientEngine, HttpRequestData httpRequestData, Continuation<? super HttpClientEngine$executeWithinCallContext$2> continuation) {
        super(2, continuation);
        this.this$0 = httpClientEngine;
        this.$requestData = httpRequestData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HttpClientEngine$executeWithinCallContext$2(this.this$0, this.$requestData, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super HttpResponseData> continuation) {
        return ((HttpClientEngine$executeWithinCallContext$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean z;
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
            HttpClientEngine httpClientEngine = this.this$0;
            Job job = (Job) httpClientEngine.getCoroutineContext().get(Job.Key.$$INSTANCE);
            if (job != null) {
                z = job.isActive();
            } else {
                z = false;
            }
            if (!(!z)) {
                this.label = 1;
                obj = httpClientEngine.execute(this.$requestData, this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                throw new ClientEngineClosedException(0);
            }
        }
        return obj;
    }
}
