package com.animaconnected.secondo.screens.notification.alarm.utils;

import android.content.Context;
import com.animaconnected.watch.provider.AlarmDay;
import com.animaconnected.watch.provider.WeekDayFormatter;
import com.kronaby.watch.app.R;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WeekDayFormatter.kt */
/* loaded from: classes3.dex */
public final class WeekDayFormatterKt {
    public static final String getAlarmDescription(final WeekDayFormatter weekDayFormatter, Context context, Set<? extends AlarmDay> days) {
        Intrinsics.checkNotNullParameter(weekDayFormatter, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(days, "days");
        if (days.isEmpty()) {
            return "";
        }
        if (days.size() == 1) {
            return context.getString(R.string.silentalarm_every) + ' ' + weekDayFormatter.getLongWeekday((AlarmDay) CollectionsKt___CollectionsKt.first(days));
        }
        AlarmDay.Companion companion = AlarmDay.Companion;
        if (Intrinsics.areEqual(days, CollectionsKt___CollectionsKt.toSet(companion.getWeekend()))) {
            String string = context.getString(R.string.silentalarm_weekend);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
        if (Intrinsics.areEqual(days, CollectionsKt___CollectionsKt.toSet(companion.getWeekdays()))) {
            String string2 = context.getString(R.string.silentalarm_weekdays);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return string2;
        }
        if (Intrinsics.areEqual(days, CollectionsKt___CollectionsKt.toSet(companion.getAll()))) {
            String string3 = context.getString(R.string.silentalarm_everyday);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            return string3;
        }
        return CollectionsKt___CollectionsKt.joinToString$default(days, null, null, null, new Function1<AlarmDay, CharSequence>() { // from class: com.animaconnected.secondo.screens.notification.alarm.utils.WeekDayFormatterKt$getAlarmDescription$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(AlarmDay it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return WeekDayFormatter.this.getMediumWeekday(it);
            }
        }, 31);
    }
}
