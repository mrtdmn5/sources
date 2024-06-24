package com.animaconnected.secondo.screens.workout.dashboard;

import androidx.compose.ui.geometry.Rect;
import com.animaconnected.watch.workout.WorkoutMetricType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HealthDashboardScreen.kt */
/* loaded from: classes3.dex */
public abstract class ClickEvent {
    public static final int $stable = 0;

    /* compiled from: HealthDashboardScreen.kt */
    /* loaded from: classes3.dex */
    public static final class Back extends ClickEvent {
        public static final int $stable = 0;
        public static final Back INSTANCE = new Back();

        private Back() {
            super(null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Back)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1209907626;
        }

        public String toString() {
            return "Back";
        }
    }

    /* compiled from: HealthDashboardScreen.kt */
    /* loaded from: classes3.dex */
    public static final class DailyGoal extends ClickEvent {
        public static final int $stable = 0;
        private final Rect rect;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DailyGoal(Rect rect) {
            super(null);
            Intrinsics.checkNotNullParameter(rect, "rect");
            this.rect = rect;
        }

        public static /* synthetic */ DailyGoal copy$default(DailyGoal dailyGoal, Rect rect, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                rect = dailyGoal.rect;
            }
            return dailyGoal.copy(rect);
        }

        public final Rect component1() {
            return this.rect;
        }

        public final DailyGoal copy(Rect rect) {
            Intrinsics.checkNotNullParameter(rect, "rect");
            return new DailyGoal(rect);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof DailyGoal) && Intrinsics.areEqual(this.rect, ((DailyGoal) obj).rect)) {
                return true;
            }
            return false;
        }

        public final Rect getRect() {
            return this.rect;
        }

        public int hashCode() {
            return this.rect.hashCode();
        }

        public String toString() {
            return "DailyGoal(rect=" + this.rect + ')';
        }
    }

    /* compiled from: HealthDashboardScreen.kt */
    /* loaded from: classes3.dex */
    public static final class HealthSettings extends ClickEvent {
        public static final int $stable = 0;
        public static final HealthSettings INSTANCE = new HealthSettings();

        private HealthSettings() {
            super(null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof HealthSettings)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 608733518;
        }

        public String toString() {
            return "HealthSettings";
        }
    }

    /* compiled from: HealthDashboardScreen.kt */
    /* loaded from: classes3.dex */
    public static final class Metric extends ClickEvent {
        public static final int $stable = 0;
        private final Rect cardRect;
        private final WorkoutMetricType type;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Metric(WorkoutMetricType type, Rect cardRect) {
            super(null);
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(cardRect, "cardRect");
            this.type = type;
            this.cardRect = cardRect;
        }

        public static /* synthetic */ Metric copy$default(Metric metric, WorkoutMetricType workoutMetricType, Rect rect, int r3, Object obj) {
            if ((r3 & 1) != 0) {
                workoutMetricType = metric.type;
            }
            if ((r3 & 2) != 0) {
                rect = metric.cardRect;
            }
            return metric.copy(workoutMetricType, rect);
        }

        public final WorkoutMetricType component1() {
            return this.type;
        }

        public final Rect component2() {
            return this.cardRect;
        }

        public final Metric copy(WorkoutMetricType type, Rect cardRect) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(cardRect, "cardRect");
            return new Metric(type, cardRect);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Metric)) {
                return false;
            }
            Metric metric = (Metric) obj;
            if (this.type == metric.type && Intrinsics.areEqual(this.cardRect, metric.cardRect)) {
                return true;
            }
            return false;
        }

        public final Rect getCardRect() {
            return this.cardRect;
        }

        public final WorkoutMetricType getType() {
            return this.type;
        }

        public int hashCode() {
            return this.cardRect.hashCode() + (this.type.hashCode() * 31);
        }

        public String toString() {
            return "Metric(type=" + this.type + ", cardRect=" + this.cardRect + ')';
        }
    }

    /* compiled from: HealthDashboardScreen.kt */
    /* loaded from: classes3.dex */
    public static final class Session extends ClickEvent {
        public static final int $stable = 0;
        private final Rect cardRect;
        private final long timestamp;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Session(long j, Rect cardRect) {
            super(null);
            Intrinsics.checkNotNullParameter(cardRect, "cardRect");
            this.timestamp = j;
            this.cardRect = cardRect;
        }

        public static /* synthetic */ Session copy$default(Session session, long j, Rect rect, int r4, Object obj) {
            if ((r4 & 1) != 0) {
                j = session.timestamp;
            }
            if ((r4 & 2) != 0) {
                rect = session.cardRect;
            }
            return session.copy(j, rect);
        }

        public final long component1() {
            return this.timestamp;
        }

        public final Rect component2() {
            return this.cardRect;
        }

        public final Session copy(long j, Rect cardRect) {
            Intrinsics.checkNotNullParameter(cardRect, "cardRect");
            return new Session(j, cardRect);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Session)) {
                return false;
            }
            Session session = (Session) obj;
            if (this.timestamp == session.timestamp && Intrinsics.areEqual(this.cardRect, session.cardRect)) {
                return true;
            }
            return false;
        }

        public final Rect getCardRect() {
            return this.cardRect;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public int hashCode() {
            return this.cardRect.hashCode() + (Long.hashCode(this.timestamp) * 31);
        }

        public String toString() {
            return "Session(timestamp=" + this.timestamp + ", cardRect=" + this.cardRect + ')';
        }
    }

    /* compiled from: HealthDashboardScreen.kt */
    /* loaded from: classes3.dex */
    public static final class WorkoutHistory extends ClickEvent {
        public static final int $stable = 0;
        public static final WorkoutHistory INSTANCE = new WorkoutHistory();

        private WorkoutHistory() {
            super(null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof WorkoutHistory)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1267007002;
        }

        public String toString() {
            return "WorkoutHistory";
        }
    }

    public /* synthetic */ ClickEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ClickEvent() {
    }
}
