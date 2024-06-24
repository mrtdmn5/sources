package com.animaconnected.secondo.screens.onboarding;

import android.view.View;
import com.amplifyframework.auth.AuthProvider;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnboardingLoginFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.onboarding.OnboardingLoginFragment$onViewCreated$1$2", f = "OnboardingLoginFragment.kt", l = {46}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class OnboardingLoginFragment$onViewCreated$1$2 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ OnboardingLoginFragment this$0;

    /* compiled from: OnboardingLoginFragment.kt */
    @DebugMetadata(c = "com.animaconnected.secondo.screens.onboarding.OnboardingLoginFragment$onViewCreated$1$2$1", f = "OnboardingLoginFragment.kt", l = {47}, m = "invokeSuspend")
    /* renamed from: com.animaconnected.secondo.screens.onboarding.OnboardingLoginFragment$onViewCreated$1$2$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ OnboardingLoginFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(OnboardingLoginFragment onboardingLoginFragment, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.this$0 = onboardingLoginFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object loginWithSocialProvider;
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
                OnboardingLoginFragment onboardingLoginFragment = this.this$0;
                AuthProvider google = AuthProvider.google();
                Intrinsics.checkNotNullExpressionValue(google, "google(...)");
                this.label = 1;
                loginWithSocialProvider = onboardingLoginFragment.loginWithSocialProvider(google, this);
                if (loginWithSocialProvider == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnboardingLoginFragment$onViewCreated$1$2(OnboardingLoginFragment onboardingLoginFragment, Continuation<? super OnboardingLoginFragment$onViewCreated$1$2> continuation) {
        super(2, continuation);
        this.this$0 = onboardingLoginFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OnboardingLoginFragment$onViewCreated$1$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((OnboardingLoginFragment$onViewCreated$1$2) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object handleSignInUnavailable;
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
            OnboardingLoginFragment onboardingLoginFragment = this.this$0;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(onboardingLoginFragment, null);
            this.label = 1;
            handleSignInUnavailable = onboardingLoginFragment.handleSignInUnavailable(anonymousClass1, this);
            if (handleSignInUnavailable == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }
}
