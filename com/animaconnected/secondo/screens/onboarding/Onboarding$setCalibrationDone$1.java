package com.animaconnected.secondo.screens.onboarding;

import com.animaconnected.secondo.screens.onboarding.Onboarding;
import com.animaconnected.watch.account.profile.ProfileViewModel;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Onboarding.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.onboarding.Onboarding$setCalibrationDone$1", f = "Onboarding.kt", l = {473}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class Onboarding$setCalibrationDone$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ Onboarding this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Onboarding$setCalibrationDone$1(Onboarding onboarding, Continuation<? super Onboarding$setCalibrationDone$1> continuation) {
        super(2, continuation);
        this.this$0 = onboarding;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Onboarding$setCalibrationDone$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
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
            Onboarding.setHandled$default(this.this$0, Onboarding.State.CALIBRATION, false, 2, null);
            if (this.this$0.getHasDisplay()) {
                ProfileViewModel profileViewModel = this.this$0.getProfileViewModel();
                this.label = 1;
                if (profileViewModel.fetchFitnessConfig(this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
        }
        this.this$0.updateState();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Onboarding$setCalibrationDone$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
