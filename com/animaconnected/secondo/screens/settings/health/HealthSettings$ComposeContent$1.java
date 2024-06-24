package com.animaconnected.secondo.screens.settings.health;

import com.animaconnected.watch.HealthSettingsViewModel;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: HealthSettings.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.settings.health.HealthSettings$ComposeContent$1", f = "HealthSettings.kt", l = {63}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class HealthSettings$ComposeContent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public HealthSettings$ComposeContent$1(Continuation<? super HealthSettings$ComposeContent$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HealthSettings$ComposeContent$1(continuation);
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
            HealthSettingsViewModel.Companion companion = HealthSettingsViewModel.Companion;
            this.label = 1;
            if (companion.setSettingsBadgeVisibility(false, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HealthSettings$ComposeContent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
