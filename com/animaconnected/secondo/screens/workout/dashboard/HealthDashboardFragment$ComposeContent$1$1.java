package com.animaconnected.secondo.screens.workout.dashboard;

import androidx.compose.runtime.MutableState;
import com.animaconnected.watch.HealthSettingsViewModel;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: HealthDashboardFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.workout.dashboard.HealthDashboardFragment$ComposeContent$1$1", f = "HealthDashboardFragment.kt", l = {63}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class HealthDashboardFragment$ComposeContent$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $showBadge$delegate;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HealthDashboardFragment$ComposeContent$1$1(MutableState<Boolean> mutableState, Continuation<? super HealthDashboardFragment$ComposeContent$1$1> continuation) {
        super(2, continuation);
        this.$showBadge$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HealthDashboardFragment$ComposeContent$1$1(this.$showBadge$delegate, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableState<Boolean> mutableState;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                mutableState = (MutableState) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            MutableState<Boolean> mutableState2 = this.$showBadge$delegate;
            HealthSettingsViewModel.Companion companion = HealthSettingsViewModel.Companion;
            this.L$0 = mutableState2;
            this.label = 1;
            Object isSettingsBadgeVisible = companion.isSettingsBadgeVisible(this);
            if (isSettingsBadgeVisible == coroutineSingletons) {
                return coroutineSingletons;
            }
            mutableState = mutableState2;
            obj = isSettingsBadgeVisible;
        }
        HealthDashboardFragment.ComposeContent$lambda$4(mutableState, ((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HealthDashboardFragment$ComposeContent$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
