package com.animaconnected.watch;

import com.animaconnected.watch.device.BasicStorage;
import com.animaconnected.watch.device.Command;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: HealthSettingsViewModel.kt */
@DebugMetadata(c = "com.animaconnected.watch.HealthSettingsViewModel$Companion$setSettingsBadgeVisibility$2", f = "HealthSettingsViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class HealthSettingsViewModel$Companion$setSettingsBadgeVisibility$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isVisible;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HealthSettingsViewModel$Companion$setSettingsBadgeVisibility$2(boolean z, Continuation<? super HealthSettingsViewModel$Companion$setSettingsBadgeVisibility$2> continuation) {
        super(2, continuation);
        this.$isVisible = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HealthSettingsViewModel$Companion$setSettingsBadgeVisibility$2(this.$isVisible, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        BasicStorage storage;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            storage = HealthSettingsViewModel.Companion.getStorage();
            storage.put(Command.SETTINGS, this.$isVisible);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HealthSettingsViewModel$Companion$setSettingsBadgeVisibility$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
