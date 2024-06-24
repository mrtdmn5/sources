package com.animaconnected.secondo.screens.onboarding;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.RepeatOnLifecycleKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* compiled from: OnboardingSplashFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.onboarding.OnboardingSplashFragment$onViewCreated$1", f = "OnboardingSplashFragment.kt", l = {38}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class OnboardingSplashFragment$onViewCreated$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ OnboardingSplashFragment this$0;

    /* compiled from: OnboardingSplashFragment.kt */
    @DebugMetadata(c = "com.animaconnected.secondo.screens.onboarding.OnboardingSplashFragment$onViewCreated$1$1", f = "OnboardingSplashFragment.kt", l = {39}, m = "invokeSuspend")
    /* renamed from: com.animaconnected.secondo.screens.onboarding.OnboardingSplashFragment$onViewCreated$1$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ OnboardingSplashFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(OnboardingSplashFragment onboardingSplashFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = onboardingSplashFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            long j;
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
                j = this.this$0.minimumSplash;
                this.label = 1;
                if (DelayKt.m1695delayVtjQ1oo(j, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            this.this$0.getOnboarding().setSplashDone();
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnboardingSplashFragment$onViewCreated$1(OnboardingSplashFragment onboardingSplashFragment, Continuation<? super OnboardingSplashFragment$onViewCreated$1> continuation) {
        super(2, continuation);
        this.this$0 = onboardingSplashFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OnboardingSplashFragment$onViewCreated$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            OnboardingSplashFragment onboardingSplashFragment = this.this$0;
            Lifecycle.State state = Lifecycle.State.RESUMED;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(onboardingSplashFragment, null);
            this.label = 1;
            Object repeatOnLifecycle = RepeatOnLifecycleKt.repeatOnLifecycle(onboardingSplashFragment.getLifecycle(), state, anonymousClass1, this);
            if (repeatOnLifecycle != obj2) {
                repeatOnLifecycle = Unit.INSTANCE;
            }
            if (repeatOnLifecycle == obj2) {
                return obj2;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OnboardingSplashFragment$onViewCreated$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
