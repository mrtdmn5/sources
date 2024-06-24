package com.animaconnected.watch.workout;

import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.workout.ListItem;

/* compiled from: WorkoutDataClasses.kt */
/* loaded from: classes3.dex */
public interface MetricListItem<T> {
    ListItem.Type getItemType();

    WorkoutMetricType getType();

    CommonFlow<T> getValueFlow();
}
