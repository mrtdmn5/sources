package com.animaconnected.secondo.screens.settings.profile;

import android.content.Context;
import android.view.View;
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

/* compiled from: ProfileFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.settings.profile.ProfileFragment$onCreateView$2$4", f = "ProfileFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ProfileFragment$onCreateView$2$4 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ProfileFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileFragment$onCreateView$2$4(ProfileFragment profileFragment, Continuation<? super ProfileFragment$onCreateView$2$4> continuation) {
        super(2, continuation);
        this.this$0 = profileFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProfileFragment$onCreateView$2$4(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((ProfileFragment$onCreateView$2$4) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
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
            final ProfileFragment profileFragment = this.this$0;
            ProfileWeightDialogKt.showWeightDialog(requireContext, profile, new Function1<Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.profile.ProfileFragment$onCreateView$2$4.1

                /* compiled from: ProfileFragment.kt */
                @DebugMetadata(c = "com.animaconnected.secondo.screens.settings.profile.ProfileFragment$onCreateView$2$4$1$1", f = "ProfileFragment.kt", l = {74}, m = "invokeSuspend")
                /* renamed from: com.animaconnected.secondo.screens.settings.profile.ProfileFragment$onCreateView$2$4$1$1, reason: invalid class name and collision with other inner class name */
                /* loaded from: classes3.dex */
                public static final class C00701 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ Integer $weight;
                    int label;
                    final /* synthetic */ ProfileFragment this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C00701(ProfileFragment profileFragment, Integer num, Continuation<? super C00701> continuation) {
                        super(2, continuation);
                        this.this$0 = profileFragment;
                        this.$weight = num;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C00701(this.this$0, this.$weight, continuation);
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
                            Integer num = this.$weight;
                            this.label = 1;
                            if (profileViewModel.setWeight(num, this) == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        }
                        return Unit.INSTANCE;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((C00701) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }
                }

                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke2(num);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Integer num) {
                    BuildersKt.launch$default(Hashing.getLifecycleScope(ProfileFragment.this), null, null, new C00701(ProfileFragment.this, num, null), 3);
                }
            });
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
