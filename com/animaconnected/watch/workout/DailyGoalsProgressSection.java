package com.animaconnected.watch.workout;

import androidx.compose.ui.text.intl.LocaleList$$ExternalSyntheticOutline0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorkoutDataClasses.kt */
/* loaded from: classes3.dex */
public final class DailyGoalsProgressSection {
    private final DailyGoalSummary header;
    private final List<DailyGoalsProgressItem> items;

    public DailyGoalsProgressSection(DailyGoalSummary header, List<DailyGoalsProgressItem> items) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(items, "items");
        this.header = header;
        this.items = items;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DailyGoalsProgressSection copy$default(DailyGoalsProgressSection dailyGoalsProgressSection, DailyGoalSummary dailyGoalSummary, List list, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            dailyGoalSummary = dailyGoalsProgressSection.header;
        }
        if ((r3 & 2) != 0) {
            list = dailyGoalsProgressSection.items;
        }
        return dailyGoalsProgressSection.copy(dailyGoalSummary, list);
    }

    public final DailyGoalSummary component1() {
        return this.header;
    }

    public final List<DailyGoalsProgressItem> component2() {
        return this.items;
    }

    public final DailyGoalsProgressSection copy(DailyGoalSummary header, List<DailyGoalsProgressItem> items) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(items, "items");
        return new DailyGoalsProgressSection(header, items);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DailyGoalsProgressSection)) {
            return false;
        }
        DailyGoalsProgressSection dailyGoalsProgressSection = (DailyGoalsProgressSection) obj;
        if (Intrinsics.areEqual(this.header, dailyGoalsProgressSection.header) && Intrinsics.areEqual(this.items, dailyGoalsProgressSection.items)) {
            return true;
        }
        return false;
    }

    public final DailyGoalSummary getHeader() {
        return this.header;
    }

    public final List<DailyGoalsProgressItem> getItems() {
        return this.items;
    }

    public int hashCode() {
        return this.items.hashCode() + (this.header.hashCode() * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DailyGoalsProgressSection(header=");
        sb.append(this.header);
        sb.append(", items=");
        return LocaleList$$ExternalSyntheticOutline0.m(sb, this.items, ')');
    }
}
