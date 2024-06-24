package com.animaconnected.secondo.app;

import com.animaconnected.firebase.AppEvents;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.model.alarms.DaysOfWeek;
import com.animaconnected.watch.provider.AlarmDay;
import com.animaconnected.watch.provider.WatchAlarm;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: AppAnalytics.kt */
@DebugMetadata(c = "com.animaconnected.secondo.app.AppAnalytics$onAlarmsChanged$1", f = "AppAnalytics.kt", l = {105}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class AppAnalytics$onAlarmsChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AppAnalytics this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppAnalytics$onAlarmsChanged$1(AppAnalytics appAnalytics, Continuation<? super AppAnalytics$onAlarmsChanged$1> continuation) {
        super(2, continuation);
        this.this$0 = appAnalytics;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AppAnalytics$onAlarmsChanged$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AppEvents appEvents;
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
            CommonFlow<List<WatchAlarm>> alarms = ProviderFactory.INSTANCE.getWatchAlarmProvider().getAlarms();
            this.label = 1;
            obj = FlowKt.first(alarms, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        AppAnalytics appAnalytics = this.this$0;
        int r12 = 0;
        for (Object obj2 : (List) obj) {
            int r3 = r12 + 1;
            if (r12 >= 0) {
                WatchAlarm watchAlarm = (WatchAlarm) obj2;
                appEvents = appAnalytics.appEvents;
                Set<AlarmDay> daysEnabled = watchAlarm.getDaysEnabled();
                ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(daysEnabled, 10));
                Iterator<T> it = daysEnabled.iterator();
                while (it.hasNext()) {
                    arrayList.add(new Integer(((AlarmDay) it.next()).getIsoDayNumber()));
                }
                appEvents.alarmChanged(r12, new DaysOfWeek(CollectionsKt___CollectionsKt.toSet(arrayList)).toBitSet(), watchAlarm.getHour(), watchAlarm.getMinute());
                r12 = r3;
            } else {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
                throw null;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AppAnalytics$onAlarmsChanged$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
