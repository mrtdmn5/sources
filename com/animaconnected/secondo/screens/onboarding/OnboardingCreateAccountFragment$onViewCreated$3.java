package com.animaconnected.secondo.screens.onboarding;

import com.amazonaws.services.cognitoidentity.model.transform.CreateIdentityPoolRequestMarshaller$$ExternalSyntheticOutline0;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.provider.login.LoginState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: OnboardingCreateAccountFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.onboarding.OnboardingCreateAccountFragment$onViewCreated$3", f = "OnboardingCreateAccountFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class OnboardingCreateAccountFragment$onViewCreated$3 extends SuspendLambda implements Function3<FlowCollector<? super LoginState>, Throwable, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public OnboardingCreateAccountFragment$onViewCreated$3(Continuation<? super OnboardingCreateAccountFragment$onViewCreated$3> continuation) {
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
    public final Object invoke(FlowCollector<? super LoginState> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        OnboardingCreateAccountFragment$onViewCreated$3 onboardingCreateAccountFragment$onViewCreated$3 = new OnboardingCreateAccountFragment$onViewCreated$3(continuation);
        onboardingCreateAccountFragment$onViewCreated$3.L$0 = flowCollector;
        onboardingCreateAccountFragment$onViewCreated$3.L$1 = th;
        return onboardingCreateAccountFragment$onViewCreated$3.invokeSuspend(Unit.INSTANCE);
    }
}
