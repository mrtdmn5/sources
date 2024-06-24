package com.animaconnected.watch.workout;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import com.animaconnected.watch.ServiceLocator;
import com.animaconnected.watch.device.DateFormatter;
import com.animaconnected.watch.fitness.Days;
import com.animaconnected.watch.fitness.EntriesAmount;
import com.animaconnected.watch.fitness.TimePeriod;
import com.animaconnected.watch.provider.DateTimeFormattersKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* compiled from: WorkoutDatePickerViewModel.kt */
/* loaded from: classes3.dex */
public final class HistoryState {
    private final DateFormatter dateFormat;
    private final String dateTimeHeaderText;
    private final String dateTimeText;
    private final HistoryPeriodTab historyTab;
    private final boolean isNextDateClickable;
    private final boolean isPrevDateClickable;
    private final EntriesAmount nbrOfEntries;
    private final TimePeriod selectedTimePeriod;
    private final TimePeriod timePeriod;

    public HistoryState() {
        this(null, null, null, null, null, null, null, false, false, 511, null);
    }

    public static /* synthetic */ HistoryState copy$default(HistoryState historyState, HistoryPeriodTab historyPeriodTab, TimePeriod timePeriod, TimePeriod timePeriod2, EntriesAmount entriesAmount, DateFormatter dateFormatter, String str, String str2, boolean z, boolean z2, int r20, Object obj) {
        HistoryPeriodTab historyPeriodTab2;
        TimePeriod timePeriod3;
        TimePeriod timePeriod4;
        EntriesAmount entriesAmount2;
        DateFormatter dateFormatter2;
        String str3;
        String str4;
        boolean z3;
        boolean z4;
        if ((r20 & 1) != 0) {
            historyPeriodTab2 = historyState.historyTab;
        } else {
            historyPeriodTab2 = historyPeriodTab;
        }
        if ((r20 & 2) != 0) {
            timePeriod3 = historyState.timePeriod;
        } else {
            timePeriod3 = timePeriod;
        }
        if ((r20 & 4) != 0) {
            timePeriod4 = historyState.selectedTimePeriod;
        } else {
            timePeriod4 = timePeriod2;
        }
        if ((r20 & 8) != 0) {
            entriesAmount2 = historyState.nbrOfEntries;
        } else {
            entriesAmount2 = entriesAmount;
        }
        if ((r20 & 16) != 0) {
            dateFormatter2 = historyState.dateFormat;
        } else {
            dateFormatter2 = dateFormatter;
        }
        if ((r20 & 32) != 0) {
            str3 = historyState.dateTimeHeaderText;
        } else {
            str3 = str;
        }
        if ((r20 & 64) != 0) {
            str4 = historyState.dateTimeText;
        } else {
            str4 = str2;
        }
        if ((r20 & 128) != 0) {
            z3 = historyState.isNextDateClickable;
        } else {
            z3 = z;
        }
        if ((r20 & 256) != 0) {
            z4 = historyState.isPrevDateClickable;
        } else {
            z4 = z2;
        }
        return historyState.copy(historyPeriodTab2, timePeriod3, timePeriod4, entriesAmount2, dateFormatter2, str3, str4, z3, z4);
    }

    public final HistoryPeriodTab component1() {
        return this.historyTab;
    }

    public final TimePeriod component2() {
        return this.timePeriod;
    }

    public final TimePeriod component3() {
        return this.selectedTimePeriod;
    }

    public final EntriesAmount component4() {
        return this.nbrOfEntries;
    }

    public final DateFormatter component5() {
        return this.dateFormat;
    }

    public final String component6() {
        return this.dateTimeHeaderText;
    }

    public final String component7() {
        return this.dateTimeText;
    }

    public final boolean component8() {
        return this.isNextDateClickable;
    }

    public final boolean component9() {
        return this.isPrevDateClickable;
    }

    public final HistoryState copy(HistoryPeriodTab historyTab, TimePeriod timePeriod, TimePeriod selectedTimePeriod, EntriesAmount nbrOfEntries, DateFormatter dateFormat, String dateTimeHeaderText, String dateTimeText, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(historyTab, "historyTab");
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        Intrinsics.checkNotNullParameter(selectedTimePeriod, "selectedTimePeriod");
        Intrinsics.checkNotNullParameter(nbrOfEntries, "nbrOfEntries");
        Intrinsics.checkNotNullParameter(dateFormat, "dateFormat");
        Intrinsics.checkNotNullParameter(dateTimeHeaderText, "dateTimeHeaderText");
        Intrinsics.checkNotNullParameter(dateTimeText, "dateTimeText");
        return new HistoryState(historyTab, timePeriod, selectedTimePeriod, nbrOfEntries, dateFormat, dateTimeHeaderText, dateTimeText, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HistoryState)) {
            return false;
        }
        HistoryState historyState = (HistoryState) obj;
        if (this.historyTab == historyState.historyTab && Intrinsics.areEqual(this.timePeriod, historyState.timePeriod) && Intrinsics.areEqual(this.selectedTimePeriod, historyState.selectedTimePeriod) && Intrinsics.areEqual(this.nbrOfEntries, historyState.nbrOfEntries) && Intrinsics.areEqual(this.dateFormat, historyState.dateFormat) && Intrinsics.areEqual(this.dateTimeHeaderText, historyState.dateTimeHeaderText) && Intrinsics.areEqual(this.dateTimeText, historyState.dateTimeText) && this.isNextDateClickable == historyState.isNextDateClickable && this.isPrevDateClickable == historyState.isPrevDateClickable) {
            return true;
        }
        return false;
    }

    public final DateFormatter getDateFormat() {
        return this.dateFormat;
    }

    public final String getDateTimeHeaderText() {
        return this.dateTimeHeaderText;
    }

    public final String getDateTimeText() {
        return this.dateTimeText;
    }

    public final HistoryPeriodTab getHistoryTab() {
        return this.historyTab;
    }

    public final EntriesAmount getNbrOfEntries() {
        return this.nbrOfEntries;
    }

    public final TimePeriod getSelectedTimePeriod() {
        return this.selectedTimePeriod;
    }

    public final TimePeriod getTimePeriod() {
        return this.timePeriod;
    }

    public int hashCode() {
        return Boolean.hashCode(this.isPrevDateClickable) + JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.isNextDateClickable, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.dateTimeText, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.dateTimeHeaderText, (this.dateFormat.hashCode() + ((this.nbrOfEntries.hashCode() + ((this.selectedTimePeriod.hashCode() + ((this.timePeriod.hashCode() + (this.historyTab.hashCode() * 31)) * 31)) * 31)) * 31)) * 31, 31), 31), 31);
    }

    public final boolean isNextDateClickable() {
        return this.isNextDateClickable;
    }

    public final boolean isPrevDateClickable() {
        return this.isPrevDateClickable;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("HistoryState(historyTab=");
        sb.append(this.historyTab);
        sb.append(", timePeriod=");
        sb.append(this.timePeriod);
        sb.append(", selectedTimePeriod=");
        sb.append(this.selectedTimePeriod);
        sb.append(", nbrOfEntries=");
        sb.append(this.nbrOfEntries);
        sb.append(", dateFormat=");
        sb.append(this.dateFormat);
        sb.append(", dateTimeHeaderText=");
        sb.append(this.dateTimeHeaderText);
        sb.append(", dateTimeText=");
        sb.append(this.dateTimeText);
        sb.append(", isNextDateClickable=");
        sb.append(this.isNextDateClickable);
        sb.append(", isPrevDateClickable=");
        return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.isPrevDateClickable, ')');
    }

    public HistoryState(HistoryPeriodTab historyTab, TimePeriod timePeriod, TimePeriod selectedTimePeriod, EntriesAmount nbrOfEntries, DateFormatter dateFormat, String dateTimeHeaderText, String dateTimeText, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(historyTab, "historyTab");
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        Intrinsics.checkNotNullParameter(selectedTimePeriod, "selectedTimePeriod");
        Intrinsics.checkNotNullParameter(nbrOfEntries, "nbrOfEntries");
        Intrinsics.checkNotNullParameter(dateFormat, "dateFormat");
        Intrinsics.checkNotNullParameter(dateTimeHeaderText, "dateTimeHeaderText");
        Intrinsics.checkNotNullParameter(dateTimeText, "dateTimeText");
        this.historyTab = historyTab;
        this.timePeriod = timePeriod;
        this.selectedTimePeriod = selectedTimePeriod;
        this.nbrOfEntries = nbrOfEntries;
        this.dateFormat = dateFormat;
        this.dateTimeHeaderText = dateTimeHeaderText;
        this.dateTimeText = dateTimeText;
        this.isNextDateClickable = z;
        this.isPrevDateClickable = z2;
    }

    public /* synthetic */ HistoryState(HistoryPeriodTab historyPeriodTab, TimePeriod timePeriod, TimePeriod timePeriod2, EntriesAmount entriesAmount, DateFormatter dateFormatter, String str, String str2, boolean z, boolean z2, int r20, DefaultConstructorMarker defaultConstructorMarker) {
        this((r20 & 1) != 0 ? HistoryPeriodTab.Week : historyPeriodTab, (r20 & 2) != 0 ? TimePeriod.Companion.week$default(TimePeriod.Companion, null, null, 3, null) : timePeriod, (r20 & 4) != 0 ? TimePeriod.Companion.day$default(TimePeriod.Companion, null, null, 3, null) : timePeriod2, (r20 & 8) != 0 ? Days.INSTANCE : entriesAmount, (r20 & 16) != 0 ? DateTimeFormattersKt.getShortDayNameInWeekFormatter(ServiceLocator.INSTANCE.getStringsBackend()) : dateFormatter, (r20 & 32) != 0 ? "" : str, (r20 & 64) == 0 ? str2 : "", (r20 & 128) != 0 ? false : z, (r20 & 256) == 0 ? z2 : false);
    }
}
