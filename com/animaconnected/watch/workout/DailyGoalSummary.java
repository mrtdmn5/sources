package com.animaconnected.watch.workout;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import com.animaconnected.watch.workout.ListItem;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorkoutDataClasses.kt */
/* loaded from: classes3.dex */
public final class DailyGoalSummary extends ListItem {
    private final String exerciseSummary;
    private final ListItem.Type itemType;
    private final String moveSummary;
    private final String nbrOfDays;
    private final String standSummary;
    private final String title;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DailyGoalSummary(String title, String moveSummary, String standSummary, String exerciseSummary, String nbrOfDays) {
        super(null);
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(moveSummary, "moveSummary");
        Intrinsics.checkNotNullParameter(standSummary, "standSummary");
        Intrinsics.checkNotNullParameter(exerciseSummary, "exerciseSummary");
        Intrinsics.checkNotNullParameter(nbrOfDays, "nbrOfDays");
        this.title = title;
        this.moveSummary = moveSummary;
        this.standSummary = standSummary;
        this.exerciseSummary = exerciseSummary;
        this.nbrOfDays = nbrOfDays;
        this.itemType = ListItem.Type.DailyGoalSummary;
    }

    public static /* synthetic */ DailyGoalSummary copy$default(DailyGoalSummary dailyGoalSummary, String str, String str2, String str3, String str4, String str5, int r9, Object obj) {
        if ((r9 & 1) != 0) {
            str = dailyGoalSummary.title;
        }
        if ((r9 & 2) != 0) {
            str2 = dailyGoalSummary.moveSummary;
        }
        String str6 = str2;
        if ((r9 & 4) != 0) {
            str3 = dailyGoalSummary.standSummary;
        }
        String str7 = str3;
        if ((r9 & 8) != 0) {
            str4 = dailyGoalSummary.exerciseSummary;
        }
        String str8 = str4;
        if ((r9 & 16) != 0) {
            str5 = dailyGoalSummary.nbrOfDays;
        }
        return dailyGoalSummary.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.moveSummary;
    }

    public final String component3() {
        return this.standSummary;
    }

    public final String component4() {
        return this.exerciseSummary;
    }

    public final String component5() {
        return this.nbrOfDays;
    }

    public final DailyGoalSummary copy(String title, String moveSummary, String standSummary, String exerciseSummary, String nbrOfDays) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(moveSummary, "moveSummary");
        Intrinsics.checkNotNullParameter(standSummary, "standSummary");
        Intrinsics.checkNotNullParameter(exerciseSummary, "exerciseSummary");
        Intrinsics.checkNotNullParameter(nbrOfDays, "nbrOfDays");
        return new DailyGoalSummary(title, moveSummary, standSummary, exerciseSummary, nbrOfDays);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DailyGoalSummary)) {
            return false;
        }
        DailyGoalSummary dailyGoalSummary = (DailyGoalSummary) obj;
        if (Intrinsics.areEqual(this.title, dailyGoalSummary.title) && Intrinsics.areEqual(this.moveSummary, dailyGoalSummary.moveSummary) && Intrinsics.areEqual(this.standSummary, dailyGoalSummary.standSummary) && Intrinsics.areEqual(this.exerciseSummary, dailyGoalSummary.exerciseSummary) && Intrinsics.areEqual(this.nbrOfDays, dailyGoalSummary.nbrOfDays)) {
            return true;
        }
        return false;
    }

    public final String getExerciseSummary() {
        return this.exerciseSummary;
    }

    @Override // com.animaconnected.watch.workout.ListItem
    public ListItem.Type getItemType() {
        return this.itemType;
    }

    public final String getMoveSummary() {
        return this.moveSummary;
    }

    public final String getNbrOfDays() {
        return this.nbrOfDays;
    }

    public final String getStandSummary() {
        return this.standSummary;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return this.nbrOfDays.hashCode() + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.exerciseSummary, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.standSummary, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.moveSummary, this.title.hashCode() * 31, 31), 31), 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DailyGoalSummary(title=");
        sb.append(this.title);
        sb.append(", moveSummary=");
        sb.append(this.moveSummary);
        sb.append(", standSummary=");
        sb.append(this.standSummary);
        sb.append(", exerciseSummary=");
        sb.append(this.exerciseSummary);
        sb.append(", nbrOfDays=");
        return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.nbrOfDays, ')');
    }
}
