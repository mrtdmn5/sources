package com.animaconnected.secondo.screens.settings.configuration;

import com.animaconnected.watch.fitness.SessionType;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WorkoutTypeSelection.kt */
/* loaded from: classes3.dex */
public final class WorkoutType {
    private final String name;
    private final Function1<SessionType, Unit> onClick;
    private final SessionType type;

    /* JADX WARN: Multi-variable type inference failed */
    public WorkoutType(String name, SessionType type, Function1<? super SessionType, Unit> onClick) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.name = name;
        this.type = type;
        this.onClick = onClick;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WorkoutType copy$default(WorkoutType workoutType, String str, SessionType sessionType, Function1 function1, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            str = workoutType.name;
        }
        if ((r4 & 2) != 0) {
            sessionType = workoutType.type;
        }
        if ((r4 & 4) != 0) {
            function1 = workoutType.onClick;
        }
        return workoutType.copy(str, sessionType, function1);
    }

    public final String component1() {
        return this.name;
    }

    public final SessionType component2() {
        return this.type;
    }

    public final Function1<SessionType, Unit> component3() {
        return this.onClick;
    }

    public final WorkoutType copy(String name, SessionType type, Function1<? super SessionType, Unit> onClick) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        return new WorkoutType(name, type, onClick);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WorkoutType)) {
            return false;
        }
        WorkoutType workoutType = (WorkoutType) obj;
        if (Intrinsics.areEqual(this.name, workoutType.name) && this.type == workoutType.type && Intrinsics.areEqual(this.onClick, workoutType.onClick)) {
            return true;
        }
        return false;
    }

    public final String getName() {
        return this.name;
    }

    public final Function1<SessionType, Unit> getOnClick() {
        return this.onClick;
    }

    public final SessionType getType() {
        return this.type;
    }

    public int hashCode() {
        return this.onClick.hashCode() + ((this.type.hashCode() + (this.name.hashCode() * 31)) * 31);
    }

    public String toString() {
        return "WorkoutType(name=" + this.name + ", type=" + this.type + ", onClick=" + this.onClick + ')';
    }
}
