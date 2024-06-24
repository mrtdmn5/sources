package com.animaconnected.watch.account.strava;

import io.ktor.client.plugins.auth.providers.BearerTokens;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* compiled from: StravaClient.kt */
@DebugMetadata(c = "com.animaconnected.watch.account.strava.StravaClient$client$1", f = "StravaClient.kt", l = {52}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class StravaClient$client$1 extends SuspendLambda implements Function1<Continuation<? super BearerTokens>, Object> {
    int label;
    final /* synthetic */ StravaClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StravaClient$client$1(StravaClient stravaClient, Continuation<? super StravaClient$client$1> continuation) {
        super(1, continuation);
        this.this$0 = stravaClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new StravaClient$client$1(this.this$0, continuation);
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
            StravaClient stravaClient = this.this$0;
            this.label = 1;
            obj = stravaClient.refreshTokens(this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super BearerTokens> continuation) {
        return ((StravaClient$client$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
