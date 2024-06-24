package com.animaconnected.secondo.provider.analytics;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AnalyticsConfigHelper.kt */
@DebugMetadata(c = "com.animaconnected.secondo.provider.analytics.AnalyticsConfigHelper$sendAppConfigIfAppHasBeenUpdated$1", f = "AnalyticsConfigHelper.kt", l = {31}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AnalyticsConfigHelper$sendAppConfigIfAppHasBeenUpdated$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AnalyticsConfigHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnalyticsConfigHelper$sendAppConfigIfAppHasBeenUpdated$1(AnalyticsConfigHelper analyticsConfigHelper, Continuation<? super AnalyticsConfigHelper$sendAppConfigIfAppHasBeenUpdated$1> continuation) {
        super(2, continuation);
        this.this$0 = analyticsConfigHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AnalyticsConfigHelper$sendAppConfigIfAppHasBeenUpdated$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object sendFullAppConfig;
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
            AnalyticsConfigHelper analyticsConfigHelper = this.this$0;
            this.label = 1;
            sendFullAppConfig = analyticsConfigHelper.sendFullAppConfig(this);
            if (sendFullAppConfig == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AnalyticsConfigHelper$sendAppConfigIfAppHasBeenUpdated$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
