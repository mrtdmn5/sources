package com.animaconnected.secondo.screens.onboarding;

import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.account.profile.ProfileState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: OnboardingProfile.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.onboarding.OnboardingProfile$onViewCreated$3", f = "OnboardingProfile.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class OnboardingProfile$onViewCreated$3 extends SuspendLambda implements Function3<FlowCollector<? super ProfileState>, Throwable, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ OnboardingProfile this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnboardingProfile$onViewCreated$3(OnboardingProfile onboardingProfile, Continuation<? super OnboardingProfile$onViewCreated$3> continuation) {
        super(3, continuation);
        this.this$0 = onboardingProfile;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            LogKt.debug$default(this.L$0, "Something went wrong with collecting profile attributes", this.this$0.getName(), (Throwable) this.L$1, false, 8, (Object) null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(FlowCollector<? super ProfileState> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        OnboardingProfile$onViewCreated$3 onboardingProfile$onViewCreated$3 = new OnboardingProfile$onViewCreated$3(this.this$0, continuation);
        onboardingProfile$onViewCreated$3.L$0 = flowCollector;
        onboardingProfile$onViewCreated$3.L$1 = th;
        return onboardingProfile$onViewCreated$3.invokeSuspend(Unit.INSTANCE);
    }
}
