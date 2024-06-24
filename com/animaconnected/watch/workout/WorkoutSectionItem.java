package com.animaconnected.watch.workout;

import androidx.compose.ui.text.intl.LocaleList$$ExternalSyntheticOutline0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorkoutDataClasses.kt */
/* loaded from: classes3.dex */
public final class WorkoutSectionItem {
    private final ActivitySummary header;
    private final List<SessionListItem> items;

    public WorkoutSectionItem(ActivitySummary header, List<SessionListItem> items) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(items, "items");
        this.header = header;
        this.items = items;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WorkoutSectionItem copy$default(WorkoutSectionItem workoutSectionItem, ActivitySummary activitySummary, List list, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            activitySummary = workoutSectionItem.header;
        }
        if ((r3 & 2) != 0) {
            list = workoutSectionItem.items;
        }
        return workoutSectionItem.copy(activitySummary, list);
    }

    public final ActivitySummary component1() {
        return this.header;
    }

    public final List<SessionListItem> component2() {
        return this.items;
    }

    public final WorkoutSectionItem copy(ActivitySummary header, List<SessionListItem> items) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(items, "items");
        return new WorkoutSectionItem(header, items);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WorkoutSectionItem)) {
            return false;
        }
        WorkoutSectionItem workoutSectionItem = (WorkoutSectionItem) obj;
        if (Intrinsics.areEqual(this.header, workoutSectionItem.header) && Intrinsics.areEqual(this.items, workoutSectionItem.items)) {
            return true;
        }
        return false;
    }

    public final ActivitySummary getHeader() {
        return this.header;
    }

    public final List<SessionListItem> getItems() {
        return this.items;
    }

    public int hashCode() {
        return this.items.hashCode() + (this.header.hashCode() * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("WorkoutSectionItem(header=");
        sb.append(this.header);
        sb.append(", items=");
        return LocaleList$$ExternalSyntheticOutline0.m(sb, this.items, ')');
    }
}
