package com.animaconnected.secondo.screens.onboarding;

import com.animaconnected.secondo.provider.login.LoginState;
import com.animaconnected.secondo.provider.login.LoginViewModel;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;

/* compiled from: OnboardingLoginWithEmailFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.onboarding.OnboardingLoginWithEmailFragment$onViewCreated$2", f = "OnboardingLoginWithEmailFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class OnboardingLoginWithEmailFragment$onViewCreated$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ OnboardingLoginWithEmailFragment this$0;

    /* compiled from: OnboardingLoginWithEmailFragment.kt */
    @DebugMetadata(c = "com.animaconnected.secondo.screens.onboarding.OnboardingLoginWithEmailFragment$onViewCreated$2$1", f = "OnboardingLoginWithEmailFragment.kt", l = {68}, m = "invokeSuspend")
    /* renamed from: com.animaconnected.secondo.screens.onboarding.OnboardingLoginWithEmailFragment$onViewCreated$2$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<LoginState, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ OnboardingLoginWithEmailFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(OnboardingLoginWithEmailFragment onboardingLoginWithEmailFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = onboardingLoginWithEmailFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(LoginState loginState, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(loginState, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object onSuccessfulLogin;
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
                LoginState loginState = (LoginState) this.L$0;
                if (Intrinsics.areEqual(loginState, LoginState.SignedIn.INSTANCE)) {
                    OnboardingLoginWithEmailFragment onboardingLoginWithEmailFragment = this.this$0;
                    this.label = 1;
                    onSuccessfulLogin = onboardingLoginWithEmailFragment.onSuccessfulLogin(this);
                    if (onSuccessfulLogin == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else if (Intrinsics.areEqual(loginState, LoginState.ConfirmSignUp.INSTANCE)) {
                    this.this$0.getOnboardingViewController().gotoNextFragment(OnboardingVerifyAccountFragment.Companion.newInstance(), true);
                } else if (!Intrinsics.areEqual(loginState, LoginState.Uninitialized.INSTANCE)) {
                    Intrinsics.areEqual(loginState, LoginState.Idle.INSTANCE);
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnboardingLoginWithEmailFragment$onViewCreated$2(OnboardingLoginWithEmailFragment onboardingLoginWithEmailFragment, Continuation<? super OnboardingLoginWithEmailFragment$onViewCreated$2> continuation) {
        super(2, continuation);
        this.this$0 = onboardingLoginWithEmailFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        OnboardingLoginWithEmailFragment$onViewCreated$2 onboardingLoginWithEmailFragment$onViewCreated$2 = new OnboardingLoginWithEmailFragment$onViewCreated$2(this.this$0, continuation);
        onboardingLoginWithEmailFragment$onViewCreated$2.L$0 = obj;
        return onboardingLoginWithEmailFragment$onViewCreated$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        LoginViewModel loginViewModel;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            loginViewModel = this.this$0.loginViewModel;
            if (loginViewModel != null) {
                FlowKt.launchIn(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(new AnonymousClass1(this.this$0, null), loginViewModel.getLoginState()), coroutineScope);
                return Unit.INSTANCE;
            }
            Intrinsics.throwUninitializedPropertyAccessException("loginViewModel");
            throw null;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OnboardingLoginWithEmailFragment$onViewCreated$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
