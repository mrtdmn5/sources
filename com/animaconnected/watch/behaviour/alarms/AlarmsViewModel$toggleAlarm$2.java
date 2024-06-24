package com.animaconnected.watch.behaviour.alarms;

import com.animaconnected.info.DateTimeUtilsKt;
import com.animaconnected.watch.provider.AlarmDay;
import com.animaconnected.watch.provider.WatchAlarm;
import com.animaconnected.watch.provider.WatchAlarmProvider;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AlarmsViewModel.kt */
@DebugMetadata(c = "com.animaconnected.watch.behaviour.alarms.AlarmsViewModel$toggleAlarm$2", f = "AlarmsViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AlarmsViewModel$toggleAlarm$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ WatchAlarm $alarm;
    final /* synthetic */ AlarmDay $alarmDay;
    final /* synthetic */ boolean $isSelected;
    int label;
    final /* synthetic */ AlarmsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlarmsViewModel$toggleAlarm$2(boolean z, WatchAlarm watchAlarm, AlarmDay alarmDay, AlarmsViewModel alarmsViewModel, Continuation<? super AlarmsViewModel$toggleAlarm$2> continuation) {
        super(2, continuation);
        this.$isSelected = z;
        this.$alarm = watchAlarm;
        this.$alarmDay = alarmDay;
        this.this$0 = alarmsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AlarmsViewModel$toggleAlarm$2(this.$isSelected, this.$alarm, this.$alarmDay, this.this$0, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.util.Set] */
    /* JADX WARN: Type inference failed for: r2v11, types: [java.util.Collection, java.util.LinkedHashSet] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.AbstractCollection, java.util.LinkedHashSet] */
    /* JADX WARN: Type inference failed for: r2v3 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Set linkedHashSet;
        WatchAlarmProvider watchAlarmProvider;
        boolean z;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$isSelected) {
                if (this.$alarm.getDaysEnabled().size() > 1) {
                    Set<AlarmDay> daysEnabled = this.$alarm.getDaysEnabled();
                    AlarmDay alarmDay = this.$alarmDay;
                    Intrinsics.checkNotNullParameter(daysEnabled, "<this>");
                    linkedHashSet = new LinkedHashSet(MapsKt__MapsJVMKt.mapCapacity(daysEnabled.size()));
                    boolean z2 = false;
                    for (Object obj2 : daysEnabled) {
                        if (!z2 && Intrinsics.areEqual(obj2, alarmDay)) {
                            z2 = true;
                            z = false;
                        } else {
                            z = true;
                        }
                        if (z) {
                            linkedHashSet.add(obj2);
                        }
                    }
                } else {
                    linkedHashSet = this.$alarm.getDaysEnabled();
                }
            } else {
                Set<AlarmDay> daysEnabled2 = this.$alarm.getDaysEnabled();
                AlarmDay alarmDay2 = this.$alarmDay;
                Intrinsics.checkNotNullParameter(daysEnabled2, "<this>");
                linkedHashSet = new LinkedHashSet(MapsKt__MapsJVMKt.mapCapacity(daysEnabled2.size() + 1));
                linkedHashSet.addAll(daysEnabled2);
                linkedHashSet.add(alarmDay2);
            }
            watchAlarmProvider = this.this$0.alarmsProvider;
            watchAlarmProvider.update(WatchAlarm.copy$default(this.$alarm, 0L, 0, 0, linkedHashSet, !r10.isEmpty(), false, 1000 * DateTimeUtilsKt.now().getEpochSeconds(), 39, null));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AlarmsViewModel$toggleAlarm$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
