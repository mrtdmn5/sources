package com.animaconnected.secondo.behaviour.distress.api;

import com.animaconnected.secondo.behaviour.distress.model.Subject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* compiled from: DistressApi.kt */
@DebugMetadata(c = "com.animaconnected.secondo.behaviour.distress.api.DistressApi$registerTokenFuture$1", f = "DistressApi.kt", l = {189}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DistressApi$registerTokenFuture$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ String $token;
    final /* synthetic */ Subject $userId;
    int label;
    final /* synthetic */ DistressApi this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DistressApi$registerTokenFuture$1(DistressApi distressApi, String str, Subject subject, Continuation<? super DistressApi$registerTokenFuture$1> continuation) {
        super(1, continuation);
        this.this$0 = distressApi;
        this.$token = str;
        this.$userId = subject;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new DistressApi$registerTokenFuture$1(this.this$0, this.$token, this.$userId, continuation);
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
            DistressApi distressApi = this.this$0;
            String str = this.$token;
            Subject subject = this.$userId;
            this.label = 1;
            if (distressApi.registerToken(str, subject, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((DistressApi$registerTokenFuture$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
