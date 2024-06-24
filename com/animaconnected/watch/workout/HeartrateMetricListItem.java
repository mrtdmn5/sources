package com.animaconnected.watch.workout;

import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.workout.ListItem;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorkoutDataClasses.kt */
/* loaded from: classes3.dex */
public final class HeartrateMetricListItem implements MetricListItem<HeartrateMetricItem> {
    private final ListItem.Type itemType;
    private final WorkoutMetricType type;
    private final CommonFlow<HeartrateMetricItem> valueFlow;

    public HeartrateMetricListItem(WorkoutMetricType type, CommonFlow<HeartrateMetricItem> valueFlow, ListItem.Type itemType) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(valueFlow, "valueFlow");
        Intrinsics.checkNotNullParameter(itemType, "itemType");
        this.type = type;
        this.valueFlow = valueFlow;
        this.itemType = itemType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HeartrateMetricListItem copy$default(HeartrateMetricListItem heartrateMetricListItem, WorkoutMetricType workoutMetricType, CommonFlow commonFlow, ListItem.Type type, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            workoutMetricType = heartrateMetricListItem.type;
        }
        if ((r4 & 2) != 0) {
            commonFlow = heartrateMetricListItem.valueFlow;
        }
        if ((r4 & 4) != 0) {
            type = heartrateMetricListItem.itemType;
        }
        return heartrateMetricListItem.copy(workoutMetricType, commonFlow, type);
    }

    public final WorkoutMetricType component1() {
        return this.type;
    }

    public final CommonFlow<HeartrateMetricItem> component2() {
        return this.valueFlow;
    }

    public final ListItem.Type component3() {
        return this.itemType;
    }

    public final HeartrateMetricListItem copy(WorkoutMetricType type, CommonFlow<HeartrateMetricItem> valueFlow, ListItem.Type itemType) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(valueFlow, "valueFlow");
        Intrinsics.checkNotNullParameter(itemType, "itemType");
        return new HeartrateMetricListItem(type, valueFlow, itemType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HeartrateMetricListItem)) {
            return false;
        }
        HeartrateMetricListItem heartrateMetricListItem = (HeartrateMetricListItem) obj;
        if (this.type == heartrateMetricListItem.type && Intrinsics.areEqual(this.valueFlow, heartrateMetricListItem.valueFlow) && this.itemType == heartrateMetricListItem.itemType) {
            return true;
        }
        return false;
    }

    @Override // com.animaconnected.watch.workout.MetricListItem
    public ListItem.Type getItemType() {
        return this.itemType;
    }

    @Override // com.animaconnected.watch.workout.MetricListItem
    public WorkoutMetricType getType() {
        return this.type;
    }

    @Override // com.animaconnected.watch.workout.MetricListItem
    public CommonFlow<HeartrateMetricItem> getValueFlow() {
        return this.valueFlow;
    }

    public int hashCode() {
        return this.itemType.hashCode() + ((this.valueFlow.hashCode() + (this.type.hashCode() * 31)) * 31);
    }

    public String toString() {
        return "HeartrateMetricListItem(type=" + this.type + ", valueFlow=" + this.valueFlow + ", itemType=" + this.itemType + ')';
    }

    public /* synthetic */ HeartrateMetricListItem(WorkoutMetricType workoutMetricType, CommonFlow commonFlow, ListItem.Type type, int r4, DefaultConstructorMarker defaultConstructorMarker) {
        this(workoutMetricType, commonFlow, (r4 & 4) != 0 ? ListItem.Type.Metric : type);
    }
}
