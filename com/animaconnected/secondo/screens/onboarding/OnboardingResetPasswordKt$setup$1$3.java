package com.animaconnected.secondo.screens.onboarding;

import android.view.View;
import com.animaconnected.secondo.databinding.FragmentOnboardingResetPasswordBinding;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: OnboardingResetPassword.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.onboarding.OnboardingResetPasswordKt$setup$1$3", f = "OnboardingResetPassword.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class OnboardingResetPasswordKt$setup$1$3 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<String, Unit> $onSaveClick;
    final /* synthetic */ FragmentOnboardingResetPasswordBinding $this_apply;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public OnboardingResetPasswordKt$setup$1$3(Function1<? super String, Unit> function1, FragmentOnboardingResetPasswordBinding fragmentOnboardingResetPasswordBinding, Continuation<? super OnboardingResetPasswordKt$setup$1$3> continuation) {
        super(2, continuation);
        this.$onSaveClick = function1;
        this.$this_apply = fragmentOnboardingResetPasswordBinding;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OnboardingResetPasswordKt$setup$1$3(this.$onSaveClick, this.$this_apply, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((OnboardingResetPasswordKt$setup$1$3) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$onSaveClick.invoke(String.valueOf(this.$this_apply.layoutPassword.etPassword.getText()));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
