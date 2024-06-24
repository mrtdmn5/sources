package com.animaconnected.secondo.screens.onboarding;

import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.provider.login.LoginState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: OnboardingVerifyAccountFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.onboarding.OnboardingVerifyAccountFragment$onViewCreated$5", f = "OnboardingVerifyAccountFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class OnboardingVerifyAccountFragment$onViewCreated$5 extends SuspendLambda implements Function3<FlowCollector<? super LoginState>, Throwable, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ OnboardingVerifyAccountFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnboardingVerifyAccountFragment$onViewCreated$5(OnboardingVerifyAccountFragment onboardingVerifyAccountFragment, Continuation<? super OnboardingVerifyAccountFragment$onViewCreated$5> continuation) {
        super(3, continuation);
        this.this$0 = onboardingVerifyAccountFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            LogKt.debug$default(this.L$0, this.this$0.getName(), (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingVerifyAccountFragment$onViewCreated$5.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Something went wrong with collecting loginState";
                }
            }, 6, (Object) null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(FlowCollector<? super LoginState> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        OnboardingVerifyAccountFragment$onViewCreated$5 onboardingVerifyAccountFragment$onViewCreated$5 = new OnboardingVerifyAccountFragment$onViewCreated$5(this.this$0, continuation);
        onboardingVerifyAccountFragment$onViewCreated$5.L$0 = flowCollector;
        return onboardingVerifyAccountFragment$onViewCreated$5.invokeSuspend(Unit.INSTANCE);
    }
}
