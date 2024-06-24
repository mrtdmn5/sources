package aws.smithy.kotlin.runtime.http;

import aws.smithy.kotlin.runtime.http.engine.HttpClientEngine;
import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import aws.smithy.kotlin.runtime.http.response.HttpCall;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: SdkHttpClient.kt */
@DebugMetadata(c = "aws.smithy.kotlin.runtime.http.SdkHttpClient$executeWithCallContext$2", f = "SdkHttpClient.kt", l = {39}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SdkHttpClient$executeWithCallContext$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super HttpCall>, Object> {
    public final /* synthetic */ ExecutionContext $context;
    public final /* synthetic */ HttpRequest $request;
    public int label;
    public final /* synthetic */ SdkHttpClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SdkHttpClient$executeWithCallContext$2(SdkHttpClient sdkHttpClient, ExecutionContext executionContext, HttpRequest httpRequest, Continuation<? super SdkHttpClient$executeWithCallContext$2> continuation) {
        super(2, continuation);
        this.this$0 = sdkHttpClient;
        this.$context = executionContext;
        this.$request = httpRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SdkHttpClient$executeWithCallContext$2(this.this$0, this.$context, this.$request, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super HttpCall> continuation) {
        return ((SdkHttpClient$executeWithCallContext$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            HttpClientEngine httpClientEngine = this.this$0.engine;
            this.label = 1;
            obj = httpClientEngine.roundTrip(this.$context, this.$request, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return obj;
    }
}
