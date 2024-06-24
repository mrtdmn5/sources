package com.animaconnected.secondo.screens.settings.health;

import androidx.compose.material.ModalBottomSheetState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: HealthSettings.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$HealthSettingsScreen$hideSheet$1", f = "HealthSettings.kt", l = {109}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class HealthSettingsKt$HealthSettingsScreen$hideSheet$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ModalBottomSheetState $sheetState;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HealthSettingsKt$HealthSettingsScreen$hideSheet$1(ModalBottomSheetState modalBottomSheetState, Continuation<? super HealthSettingsKt$HealthSettingsScreen$hideSheet$1> continuation) {
        super(2, continuation);
        this.$sheetState = modalBottomSheetState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HealthSettingsKt$HealthSettingsScreen$hideSheet$1(this.$sheetState, continuation);
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
            ModalBottomSheetState modalBottomSheetState = this.$sheetState;
            this.label = 1;
            if (modalBottomSheetState.hide(this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HealthSettingsKt$HealthSettingsScreen$hideSheet$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
