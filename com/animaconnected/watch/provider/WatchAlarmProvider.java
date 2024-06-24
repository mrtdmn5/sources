package com.animaconnected.watch.provider;

import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.device.HybridAlarm;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: WatchAlarmProvider.kt */
/* loaded from: classes3.dex */
public interface WatchAlarmProvider {
    void delete(WatchAlarm watchAlarm);

    CommonFlow<List<WatchAlarm>> getAlarms();

    Object getHybridAlarms(boolean z, Continuation<? super List<HybridAlarm>> continuation);

    int getMaxNumberOfAlarms();

    Object migrate(WatchAlarm watchAlarm, Continuation<? super Unit> continuation);

    WatchAlarm newAlarm();

    void registerListener(WatchAlarmProviderListener watchAlarmProviderListener);

    void unregisterListener(WatchAlarmProviderListener watchAlarmProviderListener);

    void update(WatchAlarm watchAlarm);
}
