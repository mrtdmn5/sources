package com.animaconnected.watch.workout;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import com.animaconnected.watch.workout.ListItem;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorkoutDataClasses.kt */
/* loaded from: classes3.dex */
public final class ActivitySummary extends ListItem {
    private final ListItem.Type itemType;
    private final String month;
    private final String nbrOfBikes;
    private final String nbrOfOthers;
    private final String nbrOfRuns;
    private final String nbrOfWalks;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivitySummary(String month, String nbrOfRuns, String nbrOfWalks, String nbrOfBikes, String nbrOfOthers) {
        super(null);
        Intrinsics.checkNotNullParameter(month, "month");
        Intrinsics.checkNotNullParameter(nbrOfRuns, "nbrOfRuns");
        Intrinsics.checkNotNullParameter(nbrOfWalks, "nbrOfWalks");
        Intrinsics.checkNotNullParameter(nbrOfBikes, "nbrOfBikes");
        Intrinsics.checkNotNullParameter(nbrOfOthers, "nbrOfOthers");
        this.month = month;
        this.nbrOfRuns = nbrOfRuns;
        this.nbrOfWalks = nbrOfWalks;
        this.nbrOfBikes = nbrOfBikes;
        this.nbrOfOthers = nbrOfOthers;
        this.itemType = ListItem.Type.ActivitySummary;
    }

    public static /* synthetic */ ActivitySummary copy$default(ActivitySummary activitySummary, String str, String str2, String str3, String str4, String str5, int r9, Object obj) {
        if ((r9 & 1) != 0) {
            str = activitySummary.month;
        }
        if ((r9 & 2) != 0) {
            str2 = activitySummary.nbrOfRuns;
        }
        String str6 = str2;
        if ((r9 & 4) != 0) {
            str3 = activitySummary.nbrOfWalks;
        }
        String str7 = str3;
        if ((r9 & 8) != 0) {
            str4 = activitySummary.nbrOfBikes;
        }
        String str8 = str4;
        if ((r9 & 16) != 0) {
            str5 = activitySummary.nbrOfOthers;
        }
        return activitySummary.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.month;
    }

    public final String component2() {
        return this.nbrOfRuns;
    }

    public final String component3() {
        return this.nbrOfWalks;
    }

    public final String component4() {
        return this.nbrOfBikes;
    }

    public final String component5() {
        return this.nbrOfOthers;
    }

    public final ActivitySummary copy(String month, String nbrOfRuns, String nbrOfWalks, String nbrOfBikes, String nbrOfOthers) {
        Intrinsics.checkNotNullParameter(month, "month");
        Intrinsics.checkNotNullParameter(nbrOfRuns, "nbrOfRuns");
        Intrinsics.checkNotNullParameter(nbrOfWalks, "nbrOfWalks");
        Intrinsics.checkNotNullParameter(nbrOfBikes, "nbrOfBikes");
        Intrinsics.checkNotNullParameter(nbrOfOthers, "nbrOfOthers");
        return new ActivitySummary(month, nbrOfRuns, nbrOfWalks, nbrOfBikes, nbrOfOthers);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivitySummary)) {
            return false;
        }
        ActivitySummary activitySummary = (ActivitySummary) obj;
        if (Intrinsics.areEqual(this.month, activitySummary.month) && Intrinsics.areEqual(this.nbrOfRuns, activitySummary.nbrOfRuns) && Intrinsics.areEqual(this.nbrOfWalks, activitySummary.nbrOfWalks) && Intrinsics.areEqual(this.nbrOfBikes, activitySummary.nbrOfBikes) && Intrinsics.areEqual(this.nbrOfOthers, activitySummary.nbrOfOthers)) {
            return true;
        }
        return false;
    }

    @Override // com.animaconnected.watch.workout.ListItem
    public ListItem.Type getItemType() {
        return this.itemType;
    }

    public final String getMonth() {
        return this.month;
    }

    public final String getNbrOfBikes() {
        return this.nbrOfBikes;
    }

    public final String getNbrOfOthers() {
        return this.nbrOfOthers;
    }

    public final String getNbrOfRuns() {
        return this.nbrOfRuns;
    }

    public final String getNbrOfWalks() {
        return this.nbrOfWalks;
    }

    public int hashCode() {
        return this.nbrOfOthers.hashCode() + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.nbrOfBikes, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.nbrOfWalks, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.nbrOfRuns, this.month.hashCode() * 31, 31), 31), 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ActivitySummary(month=");
        sb.append(this.month);
        sb.append(", nbrOfRuns=");
        sb.append(this.nbrOfRuns);
        sb.append(", nbrOfWalks=");
        sb.append(this.nbrOfWalks);
        sb.append(", nbrOfBikes=");
        sb.append(this.nbrOfBikes);
        sb.append(", nbrOfOthers=");
        return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.nbrOfOthers, ')');
    }
}
