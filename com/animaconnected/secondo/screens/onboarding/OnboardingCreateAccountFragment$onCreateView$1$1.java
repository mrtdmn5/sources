package com.animaconnected.secondo.screens.onboarding;

import android.view.View;
import com.animaconnected.secondo.databinding.FragmentOnboardingCreateAccountBinding;
import com.animaconnected.secondo.provider.login.LoginViewModel;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnboardingCreateAccountFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.onboarding.OnboardingCreateAccountFragment$onCreateView$1$1", f = "OnboardingCreateAccountFragment.kt", l = {36}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class OnboardingCreateAccountFragment$onCreateView$1$1 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ OnboardingCreateAccountFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnboardingCreateAccountFragment$onCreateView$1$1(OnboardingCreateAccountFragment onboardingCreateAccountFragment, Continuation<? super OnboardingCreateAccountFragment$onCreateView$1$1> continuation) {
        super(2, continuation);
        this.this$0 = onboardingCreateAccountFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OnboardingCreateAccountFragment$onCreateView$1$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((OnboardingCreateAccountFragment$onCreateView$1$1) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        LoginViewModel loginViewModel;
        FragmentOnboardingCreateAccountBinding fragmentOnboardingCreateAccountBinding;
        FragmentOnboardingCreateAccountBinding fragmentOnboardingCreateAccountBinding2;
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
                fragmentOnboardingCreateAccountBinding = this.this$0.binding;
                if (fragmentOnboardingCreateAccountBinding != null) {
                    String valueOf = String.valueOf(fragmentOnboardingCreateAccountBinding.layoutEmail.editText.getText());
                    fragmentOnboardingCreateAccountBinding2 = this.this$0.binding;
                    if (fragmentOnboardingCreateAccountBinding2 != null) {
                        String valueOf2 = String.valueOf(fragmentOnboardingCreateAccountBinding2.layoutPassword.etPassword.getText());
                        this.label = 1;
                        if (loginViewModel.signUp(valueOf, valueOf2, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        throw null;
                    }
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    throw null;
                }
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("loginViewModel");
                throw null;
            }
        }
        return Unit.INSTANCE;
    }
}
