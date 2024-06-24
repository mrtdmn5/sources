package com.animaconnected.secondo.screens.onboarding;

import android.content.Context;
import android.view.View;
import com.animaconnected.secondo.screens.settings.profile.ProfileDateOfBirthDialogKt;
import com.animaconnected.watch.account.profile.ProfileViewModel;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.google.common.collect.Hashing;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: OnboardingProfile.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.onboarding.OnboardingProfile$onCreateView$1$1", f = "OnboardingProfile.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class OnboardingProfile$onCreateView$1$1 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ OnboardingProfile this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnboardingProfile$onCreateView$1$1(OnboardingProfile onboardingProfile, Continuation<? super OnboardingProfile$onCreateView$1$1> continuation) {
        super(2, continuation);
        this.this$0 = onboardingProfile;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OnboardingProfile$onCreateView$1$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((OnboardingProfile$onCreateView$1$1) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FitnessProvider fitnessProvider;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Context requireContext = this.this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            fitnessProvider = this.this$0.fitnessProvider;
            FitnessProvider.Profile profile = fitnessProvider.getProfile();
            final OnboardingProfile onboardingProfile = this.this$0;
            ProfileDateOfBirthDialogKt.showDateOfBirthDialog(requireContext, profile, new Function1<Long, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingProfile$onCreateView$1$1.1

                /* compiled from: OnboardingProfile.kt */
                @DebugMetadata(c = "com.animaconnected.secondo.screens.onboarding.OnboardingProfile$onCreateView$1$1$1$1", f = "OnboardingProfile.kt", l = {63}, m = "invokeSuspend")
                /* renamed from: com.animaconnected.secondo.screens.onboarding.OnboardingProfile$onCreateView$1$1$1$1, reason: invalid class name and collision with other inner class name */
                /* loaded from: classes3.dex */
                public static final class C00561 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ Long $dateOfBirthTs;
                    int label;
                    final /* synthetic */ OnboardingProfile this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C00561(OnboardingProfile onboardingProfile, Long l, Continuation<? super C00561> continuation) {
                        super(2, continuation);
                        this.this$0 = onboardingProfile;
                        this.$dateOfBirthTs = l;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C00561(this.this$0, this.$dateOfBirthTs, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        ProfileViewModel profileViewModel;
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
                            profileViewModel = this.this$0.getProfileViewModel();
                            Long l = this.$dateOfBirthTs;
                            this.label = 1;
                            if (profileViewModel.setDateOfBirth(l, this) == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        }
                        return Unit.INSTANCE;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((C00561) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }
                }

                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                    invoke2(l);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Long l) {
                    BuildersKt.launch$default(Hashing.getLifecycleScope(OnboardingProfile.this), null, null, new C00561(OnboardingProfile.this, l, null), 3);
                }
            });
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
