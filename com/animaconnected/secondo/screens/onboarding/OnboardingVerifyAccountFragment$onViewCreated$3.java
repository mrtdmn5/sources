package com.animaconnected.secondo.screens.onboarding;

import com.animaconnected.secondo.databinding.FragmentOnboardingVerifyAccountBinding;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnboardingVerifyAccountFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.onboarding.OnboardingVerifyAccountFragment$onViewCreated$3", f = "OnboardingVerifyAccountFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class OnboardingVerifyAccountFragment$onViewCreated$3 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ OnboardingVerifyAccountFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnboardingVerifyAccountFragment$onViewCreated$3(OnboardingVerifyAccountFragment onboardingVerifyAccountFragment, Continuation<? super OnboardingVerifyAccountFragment$onViewCreated$3> continuation) {
        super(2, continuation);
        this.this$0 = onboardingVerifyAccountFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        OnboardingVerifyAccountFragment$onViewCreated$3 onboardingVerifyAccountFragment$onViewCreated$3 = new OnboardingVerifyAccountFragment$onViewCreated$3(this.this$0, continuation);
        onboardingVerifyAccountFragment$onViewCreated$3.Z$0 = ((Boolean) obj).booleanValue();
        return onboardingVerifyAccountFragment$onViewCreated$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
        return invoke(bool.booleanValue(), continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FragmentOnboardingVerifyAccountBinding fragmentOnboardingVerifyAccountBinding;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            boolean z = this.Z$0;
            fragmentOnboardingVerifyAccountBinding = this.this$0.binding;
            if (fragmentOnboardingVerifyAccountBinding != null) {
                fragmentOnboardingVerifyAccountBinding.btnContinue.setEnabled(z);
                return Unit.INSTANCE;
            }
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            throw null;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public final Object invoke(boolean z, Continuation<? super Unit> continuation) {
        return ((OnboardingVerifyAccountFragment$onViewCreated$3) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
