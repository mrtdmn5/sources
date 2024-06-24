package io.ktor.client.plugins;

import com.animaconnected.secondo.R;
import io.ktor.client.request.HttpRequestBuilder;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.Job;

/* compiled from: HttpTimeout.kt */
@DebugMetadata(c = "io.ktor.client.plugins.HttpTimeout$Plugin$install$1$1$killer$1", f = "HttpTimeout.kt", l = {R.styleable.AppTheme_tabTextColor}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class HttpTimeout$Plugin$install$1$1$killer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Job $executionContext;
    public final /* synthetic */ HttpRequestBuilder $request;
    public final /* synthetic */ Long $requestTimeout;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpTimeout$Plugin$install$1$1$killer$1(Long l, HttpRequestBuilder httpRequestBuilder, Job job, Continuation<? super HttpTimeout$Plugin$install$1$1$killer$1> continuation) {
        super(2, continuation);
        this.$requestTimeout = l;
        this.$request = httpRequestBuilder;
        this.$executionContext = job;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HttpTimeout$Plugin$install$1$1$killer$1(this.$requestTimeout, this.$request, this.$executionContext, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HttpTimeout$Plugin$install$1$1$killer$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            long longValue = this.$requestTimeout.longValue();
            this.label = 1;
            if (DelayKt.delay(longValue, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        HttpRequestBuilder httpRequestBuilder = this.$request;
        HttpRequestTimeoutException httpRequestTimeoutException = new HttpRequestTimeoutException(httpRequestBuilder);
        HttpTimeoutKt.LOGGER.trace("Request timeout: " + httpRequestBuilder.url);
        String message = httpRequestTimeoutException.getMessage();
        Intrinsics.checkNotNull(message);
        this.$executionContext.cancel(ExceptionsKt.CancellationException(message, httpRequestTimeoutException));
        return Unit.INSTANCE;
    }
}
