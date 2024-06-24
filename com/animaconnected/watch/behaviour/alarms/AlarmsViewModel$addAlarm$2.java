package com.animaconnected.watch.behaviour.alarms;

import com.animaconnected.info.DateTimeUtilsKt;
import com.animaconnected.watch.provider.AlarmDay;
import com.animaconnected.watch.provider.WatchAlarm;
import com.animaconnected.watch.provider.WatchAlarmProvider;
import j$.time.DayOfWeek;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.datetime.DayOfWeekKt;
import kotlinx.datetime.LocalDateTime;

/* compiled from: AlarmsViewModel.kt */
@DebugMetadata(c = "com.animaconnected.watch.behaviour.alarms.AlarmsViewModel$addAlarm$2", f = "AlarmsViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AlarmsViewModel$addAlarm$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AlarmsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlarmsViewModel$addAlarm$2(AlarmsViewModel alarmsViewModel, Continuation<? super AlarmsViewModel$addAlarm$2> continuation) {
        super(2, continuation);
        this.this$0 = alarmsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AlarmsViewModel$addAlarm$2(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        WatchAlarmProvider watchAlarmProvider;
        WatchAlarmProvider watchAlarmProvider2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            LocalDateTime localDateTime$default = DateTimeUtilsKt.getLocalDateTime$default(null, null, 3, null);
            watchAlarmProvider = this.this$0.alarmsProvider;
            WatchAlarm newAlarm = watchAlarmProvider.newAlarm();
            AlarmDay.Companion companion = AlarmDay.Companion;
            DayOfWeek dayOfWeek = localDateTime$default.value.getDayOfWeek();
            Intrinsics.checkNotNullExpressionValue(dayOfWeek, "value.dayOfWeek");
            List<DayOfWeek> list = DayOfWeekKt.allDaysOfWeek;
            WatchAlarm copy$default = WatchAlarm.copy$default(newAlarm, 0L, localDateTime$default.getHour(), localDateTime$default.getMinute(), SetsKt__SetsKt.setOf(companion.fromInt(dayOfWeek.ordinal() + 1)), true, false, 0L, 97, null);
            watchAlarmProvider2 = this.this$0.alarmsProvider;
            watchAlarmProvider2.update(copy$default);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AlarmsViewModel$addAlarm$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
