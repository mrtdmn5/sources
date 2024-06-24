package com.animaconnected.watch.behaviour.alarms;

import com.animaconnected.watch.provider.WatchAlarm;
import com.animaconnected.watch.provider.WatchAlarmProvider;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AlarmsViewModel.kt */
@DebugMetadata(c = "com.animaconnected.watch.behaviour.alarms.AlarmsViewModel$deleteAlarm$2", f = "AlarmsViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AlarmsViewModel$deleteAlarm$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ WatchAlarm $alarm;
    int label;
    final /* synthetic */ AlarmsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlarmsViewModel$deleteAlarm$2(AlarmsViewModel alarmsViewModel, WatchAlarm watchAlarm, Continuation<? super AlarmsViewModel$deleteAlarm$2> continuation) {
        super(2, continuation);
        this.this$0 = alarmsViewModel;
        this.$alarm = watchAlarm;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AlarmsViewModel$deleteAlarm$2(this.this$0, this.$alarm, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        WatchAlarmProvider watchAlarmProvider;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            watchAlarmProvider = this.this$0.alarmsProvider;
            watchAlarmProvider.delete(this.$alarm);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AlarmsViewModel$deleteAlarm$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
