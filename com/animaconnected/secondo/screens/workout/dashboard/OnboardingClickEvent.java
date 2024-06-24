package com.animaconnected.secondo.screens.workout.dashboard;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: HealthDashboardScreen.kt */
/* loaded from: classes3.dex */
public abstract class OnboardingClickEvent extends ClickEvent {
    public static final int $stable = 0;

    /* compiled from: HealthDashboardScreen.kt */
    /* loaded from: classes3.dex */
    public static final class DailyGoal extends OnboardingClickEvent {
        public static final int $stable = 0;
        public static final DailyGoal INSTANCE = new DailyGoal();

        private DailyGoal() {
            super(null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DailyGoal)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1992062152;
        }

        public String toString() {
            return "DailyGoal";
        }
    }

    /* compiled from: HealthDashboardScreen.kt */
    /* loaded from: classes3.dex */
    public static final class LetsGo extends OnboardingClickEvent {
        public static final int $stable = 0;
        public static final LetsGo INSTANCE = new LetsGo();

        private LetsGo() {
            super(null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LetsGo)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1558174252;
        }

        public String toString() {
            return "LetsGo";
        }
    }

    /* compiled from: HealthDashboardScreen.kt */
    /* loaded from: classes3.dex */
    public static final class Metric extends OnboardingClickEvent {
        public static final int $stable = 0;
        public static final Metric INSTANCE = new Metric();

        private Metric() {
            super(null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Metric)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1529545020;
        }

        public String toString() {
            return "Metric";
        }
    }

    /* compiled from: HealthDashboardScreen.kt */
    /* loaded from: classes3.dex */
    public static final class Workout extends OnboardingClickEvent {
        public static final int $stable = 0;
        public static final Workout INSTANCE = new Workout();

        private Workout() {
            super(null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Workout)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 398089225;
        }

        public String toString() {
            return com.animaconnected.watch.behaviour.workout.Workout.TYPE;
        }
    }

    public /* synthetic */ OnboardingClickEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private OnboardingClickEvent() {
        super(null);
    }
}
