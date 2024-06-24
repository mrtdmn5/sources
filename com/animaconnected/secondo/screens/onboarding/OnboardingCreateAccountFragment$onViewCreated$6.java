package com.animaconnected.secondo.screens.onboarding;

import com.amazonaws.services.cognitoidentity.model.transform.CreateIdentityPoolRequestMarshaller$$ExternalSyntheticOutline0;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.screens.settings.FormUiState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: OnboardingCreateAccountFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.onboarding.OnboardingCreateAccountFragment$onViewCreated$6", f = "OnboardingCreateAccountFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class OnboardingCreateAccountFragment$onViewCreated$6 extends SuspendLambda implements Function3<FlowCollector<? super FormUiState>, Throwable, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public OnboardingCreateAccountFragment$onViewCreated$6(Continuation<? super OnboardingCreateAccountFragment$onViewCreated$6> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            LogKt.debug$default(this.L$0, CreateIdentityPoolRequestMarshaller$$ExternalSyntheticOutline0.m((Throwable) this.L$1, new StringBuilder("Something went wrong: ")), (String) null, (Throwable) null, false, 14, (Object) null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(FlowCollector<? super FormUiState> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        OnboardingCreateAccountFragment$onViewCreated$6 onboardingCreateAccountFragment$onViewCreated$6 = new OnboardingCreateAccountFragment$onViewCreated$6(continuation);
        onboardingCreateAccountFragment$onViewCreated$6.L$0 = flowCollector;
        onboardingCreateAccountFragment$onViewCreated$6.L$1 = th;
        return onboardingCreateAccountFragment$onViewCreated$6.invokeSuspend(Unit.INSTANCE);
    }
}
