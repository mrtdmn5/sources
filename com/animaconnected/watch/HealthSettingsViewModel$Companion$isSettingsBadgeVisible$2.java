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
@DebugMetadata(c = "com.animaconnected.watch.HealthSettingsViewModel$Companion$isSettingsBadgeVisible$2", f = "HealthSettingsViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class HealthSettingsViewModel$Companion$isSettingsBadgeVisible$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    int label;

    public HealthSettingsViewModel$Companion$isSettingsBadgeVisible$2(Continuation<? super HealthSettingsViewModel$Companion$isSettingsBadgeVisible$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HealthSettingsViewModel$Companion$isSettingsBadgeVisible$2(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        BasicStorage storage;
        boolean z;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            storage = HealthSettingsViewModel.Companion.getStorage();
            Boolean bool = storage.getBoolean(Command.SETTINGS);
            if (bool != null) {
                z = bool.booleanValue();
            } else {
                z = true;
            }
            return Boolean.valueOf(z);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((HealthSettingsViewModel$Companion$isSettingsBadgeVisible$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
