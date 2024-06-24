package com.animaconnected.secondo.screens.onboarding;

import com.animaconnected.secondo.databinding.FragmentOnboardingCreateAccountBinding;
import com.animaconnected.secondo.screens.settings.FormUiState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnboardingCreateAccountFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.onboarding.OnboardingCreateAccountFragment$onViewCreated$5", f = "OnboardingCreateAccountFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class OnboardingCreateAccountFragment$onViewCreated$5 extends SuspendLambda implements Function2<FormUiState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ OnboardingCreateAccountFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnboardingCreateAccountFragment$onViewCreated$5(OnboardingCreateAccountFragment onboardingCreateAccountFragment, Continuation<? super OnboardingCreateAccountFragment$onViewCreated$5> continuation) {
        super(2, continuation);
        this.this$0 = onboardingCreateAccountFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        OnboardingCreateAccountFragment$onViewCreated$5 onboardingCreateAccountFragment$onViewCreated$5 = new OnboardingCreateAccountFragment$onViewCreated$5(this.this$0, continuation);
        onboardingCreateAccountFragment$onViewCreated$5.L$0 = obj;
        return onboardingCreateAccountFragment$onViewCreated$5;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FormUiState formUiState, Continuation<? super Unit> continuation) {
        return ((OnboardingCreateAccountFragment$onViewCreated$5) create(formUiState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FragmentOnboardingCreateAccountBinding fragmentOnboardingCreateAccountBinding;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            FormUiState formUiState = (FormUiState) this.L$0;
            fragmentOnboardingCreateAccountBinding = this.this$0.binding;
            if (fragmentOnboardingCreateAccountBinding != null) {
                fragmentOnboardingCreateAccountBinding.btnContinue.setEnabled(formUiState.isFormValid());
                return Unit.INSTANCE;
            }
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            throw null;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
