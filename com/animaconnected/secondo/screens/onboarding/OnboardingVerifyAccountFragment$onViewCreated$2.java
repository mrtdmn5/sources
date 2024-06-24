package com.animaconnected.secondo.screens.onboarding;

import com.animaconnected.secondo.utils.Loading;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: OnboardingVerifyAccountFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.onboarding.OnboardingVerifyAccountFragment$onViewCreated$2", f = "OnboardingVerifyAccountFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class OnboardingVerifyAccountFragment$onViewCreated$2 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    final /* synthetic */ Loading $loading;
    /* synthetic */ boolean Z$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnboardingVerifyAccountFragment$onViewCreated$2(Loading loading, Continuation<? super OnboardingVerifyAccountFragment$onViewCreated$2> continuation) {
        super(2, continuation);
        this.$loading = loading;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        OnboardingVerifyAccountFragment$onViewCreated$2 onboardingVerifyAccountFragment$onViewCreated$2 = new OnboardingVerifyAccountFragment$onViewCreated$2(this.$loading, continuation);
        onboardingVerifyAccountFragment$onViewCreated$2.Z$0 = ((Boolean) obj).booleanValue();
        return onboardingVerifyAccountFragment$onViewCreated$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
        return invoke(bool.booleanValue(), continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$loading.invalidate(this.Z$0);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public final Object invoke(boolean z, Continuation<? super Unit> continuation) {
        return ((OnboardingVerifyAccountFragment$onViewCreated$2) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
