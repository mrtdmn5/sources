package com.animaconnected.watch.behaviour.alarms;

import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.ServiceLocator;
import com.animaconnected.watch.device.DateFormatter;
import com.animaconnected.watch.device.StringsBackend;
import com.animaconnected.watch.provider.AlarmDay;
import com.animaconnected.watch.provider.DateTimeFormattersKt;
import com.animaconnected.watch.provider.WatchAlarm;
import com.animaconnected.watch.provider.WatchAlarmProvider;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.TimeZone;
import kotlinx.datetime.TimeZoneKt;

/* compiled from: AlarmsViewModel.kt */
/* loaded from: classes3.dex */
public final class AlarmsViewModel {
    private final CommonFlow<List<WatchAlarm>> alarms;
    private final WatchAlarmProvider alarmsProvider;
    private final int maxAlarmAmount;

    public AlarmsViewModel() {
        WatchAlarmProvider alarmsProvider = ServiceLocator.INSTANCE.getAlarmsProvider();
        this.alarmsProvider = alarmsProvider;
        this.alarms = alarmsProvider.getAlarms();
        this.maxAlarmAmount = alarmsProvider.getMaxNumberOfAlarms();
    }

    public final Object addAlarm(Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.Default, new AlarmsViewModel$addAlarm$2(this, null), continuation);
        if (withContext == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    public final Object deleteAlarm(WatchAlarm watchAlarm, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.Default, new AlarmsViewModel$deleteAlarm$2(this, watchAlarm, null), continuation);
        if (withContext == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    public final CommonFlow<List<WatchAlarm>> getAlarms() {
        return this.alarms;
    }

    public final CommonFlow<List<WatchAlarm>> getAlarmsFlow() {
        return this.alarmsProvider.getAlarms();
    }

    public final int getMaxAlarmAmount() {
        return this.maxAlarmAmount;
    }

    public final String getTimeString(WatchAlarm alarm) {
        Intrinsics.checkNotNullParameter(alarm, "alarm");
        LocalDateTime localDateTime = new LocalDateTime(0, 1, 1, alarm.getHour(), alarm.getMinute(), 0, 96, 0);
        TimeZone.Companion.getClass();
        return DateFormatter.format$default(StringsBackend.createDateFormatter$default(ServiceLocator.INSTANCE.getStringsBackend(), DateTimeFormattersKt.getHourMinuteFormat(), false, 2, null), TimeZoneKt.toInstant(localDateTime, TimeZone.Companion.currentSystemDefault()).toEpochMilliseconds(), null, false, 6, null);
    }

    public final Object toggleAlarm(boolean z, AlarmDay alarmDay, WatchAlarm watchAlarm, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.Default, new AlarmsViewModel$toggleAlarm$2(z, watchAlarm, alarmDay, this, null), continuation);
        if (withContext == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    public final Object updateAlarm(WatchAlarm watchAlarm, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.Default, new AlarmsViewModel$updateAlarm$2(this, watchAlarm, null), continuation);
        if (withContext == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return withContext;
        }
        return Unit.INSTANCE;
    }
}
