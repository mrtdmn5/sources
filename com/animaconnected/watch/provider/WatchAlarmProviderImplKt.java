package com.animaconnected.watch.provider;

import com.animaconnected.watch.model.alarms.Alarms;
import com.animaconnected.watch.model.alarms.DaysOfWeek;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WatchAlarmProviderImpl.kt */
/* loaded from: classes3.dex */
public final class WatchAlarmProviderImplKt {
    public static final Alarms copy(Alarms alarms, int r12, int r13, DaysOfWeek daysOfWeek, boolean z, boolean z2, long j) {
        Intrinsics.checkNotNullParameter(alarms, "<this>");
        Intrinsics.checkNotNullParameter(daysOfWeek, "daysOfWeek");
        return new Alarms(alarms.get_id(), r12, r13, daysOfWeek, z, z2, j);
    }

    public static /* synthetic */ Alarms copy$default(Alarms alarms, int r6, int r7, DaysOfWeek daysOfWeek, boolean z, boolean z2, long j, int r13, Object obj) {
        if ((r13 & 1) != 0) {
            r6 = alarms.getHour();
        }
        if ((r13 & 2) != 0) {
            r7 = alarms.getMinutes();
        }
        int r14 = r7;
        if ((r13 & 4) != 0) {
            daysOfWeek = alarms.getDaysofweek();
        }
        DaysOfWeek daysOfWeek2 = daysOfWeek;
        if ((r13 & 8) != 0) {
            z = alarms.getEnabled();
        }
        boolean z3 = z;
        if ((r13 & 16) != 0) {
            z2 = alarms.getDelete_after_use();
        }
        boolean z4 = z2;
        if ((r13 & 32) != 0) {
            j = alarms.getLast_modified();
        }
        return copy(alarms, r6, r14, daysOfWeek2, z3, z4, j);
    }
}
