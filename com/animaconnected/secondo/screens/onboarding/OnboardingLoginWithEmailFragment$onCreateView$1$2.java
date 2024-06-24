package com.animaconnected.secondo.screens.onboarding;

import android.view.View;
import com.animaconnected.secondo.databinding.FragmentOnboardingLoginWithEmailBinding;
import com.animaconnected.secondo.provider.login.LoginViewModel;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnboardingLoginWithEmailFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.onboarding.OnboardingLoginWithEmailFragment$onCreateView$1$2", f = "OnboardingLoginWithEmailFragment.kt", l = {45}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class OnboardingLoginWithEmailFragment$onCreateView$1$2 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentOnboardingLoginWithEmailBinding $this_apply;
    int label;
    final /* synthetic */ OnboardingLoginWithEmailFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnboardingLoginWithEmailFragment$onCreateView$1$2(OnboardingLoginWithEmailFragment onboardingLoginWithEmailFragment, FragmentOnboardingLoginWithEmailBinding fragmentOnboardingLoginWithEmailBinding, Continuation<? super OnboardingLoginWithEmailFragment$onCreateView$1$2> continuation) {
        super(2, continuation);
        this.this$0 = onboardingLoginWithEmailFragment;
        this.$this_apply = fragmentOnboardingLoginWithEmailBinding;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OnboardingLoginWithEmailFragment$onCreateView$1$2(this.this$0, this.$this_apply, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((OnboardingLoginWithEmailFragment$onCreateView$1$2) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        LoginViewModel loginViewModel;
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
            loginViewModel = this.this$0.loginViewModel;
            if (loginViewModel != null) {
                String valueOf = String.valueOf(this.$this_apply.layoutEmail.editText.getText());
                String valueOf2 = String.valueOf(this.$this_apply.layoutPassword.etPassword.getText());
                this.label = 1;
                if (loginViewModel.signInWithEmail(valueOf, valueOf2, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("loginViewModel");
                throw null;
            }
        }
        return Unit.INSTANCE;
    }
}
