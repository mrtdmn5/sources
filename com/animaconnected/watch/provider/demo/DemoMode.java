package com.animaconnected.watch.provider.demo;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DemoModeProvider.kt */
/* loaded from: classes3.dex */
public interface DemoMode {

    /* compiled from: DemoModeProvider.kt */
    /* loaded from: classes3.dex */
    public static final class Disabled implements DemoMode {
        private final boolean wasNeverActivated;

        public Disabled(boolean z) {
            this.wasNeverActivated = z;
        }

        public static /* synthetic */ Disabled copy$default(Disabled disabled, boolean z, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                z = disabled.wasNeverActivated;
            }
            return disabled.copy(z);
        }

        public final boolean component1() {
            return this.wasNeverActivated;
        }

        public final Disabled copy(boolean z) {
            return new Disabled(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof Disabled) && this.wasNeverActivated == ((Disabled) obj).wasNeverActivated) {
                return true;
            }
            return false;
        }

        public final boolean getWasNeverActivated() {
            return this.wasNeverActivated;
        }

        public int hashCode() {
            return Boolean.hashCode(this.wasNeverActivated);
        }

        public String toString() {
            return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(new StringBuilder("Disabled(wasNeverActivated="), this.wasNeverActivated, ')');
        }
    }

    /* compiled from: DemoModeProvider.kt */
    /* loaded from: classes3.dex */
    public interface Enabled extends DemoMode {

        /* compiled from: DemoModeProvider.kt */
        /* loaded from: classes3.dex */
        public static final class Idle implements Enabled {
            private final WatchDemoMode watchDemoMode;

            public Idle(WatchDemoMode watchDemoMode) {
                Intrinsics.checkNotNullParameter(watchDemoMode, "watchDemoMode");
                this.watchDemoMode = watchDemoMode;
            }

            public static /* synthetic */ Idle copy$default(Idle idle, WatchDemoMode watchDemoMode, int r2, Object obj) {
                if ((r2 & 1) != 0) {
                    watchDemoMode = idle.watchDemoMode;
                }
                return idle.copy(watchDemoMode);
            }

            public final WatchDemoMode component1() {
                return this.watchDemoMode;
            }

            public final Idle copy(WatchDemoMode watchDemoMode) {
                Intrinsics.checkNotNullParameter(watchDemoMode, "watchDemoMode");
                return new Idle(watchDemoMode);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof Idle) && this.watchDemoMode == ((Idle) obj).watchDemoMode) {
                    return true;
                }
                return false;
            }

            @Override // com.animaconnected.watch.provider.demo.DemoMode.Enabled
            public WatchDemoMode getWatchDemoMode() {
                return this.watchDemoMode;
            }

            public int hashCode() {
                return this.watchDemoMode.hashCode();
            }

            public String toString() {
                return "Idle(watchDemoMode=" + this.watchDemoMode + ')';
            }
        }

        /* compiled from: DemoModeProvider.kt */
        /* loaded from: classes3.dex */
        public static final class Processing implements Enabled {
            private final Float progress;
            private final WatchDemoMode watchDemoMode;

            public Processing(Float f, WatchDemoMode watchDemoMode) {
                Intrinsics.checkNotNullParameter(watchDemoMode, "watchDemoMode");
                this.progress = f;
                this.watchDemoMode = watchDemoMode;
            }

            public static /* synthetic */ Processing copy$default(Processing processing, Float f, WatchDemoMode watchDemoMode, int r3, Object obj) {
                if ((r3 & 1) != 0) {
                    f = processing.progress;
                }
                if ((r3 & 2) != 0) {
                    watchDemoMode = processing.watchDemoMode;
                }
                return processing.copy(f, watchDemoMode);
            }

            public final Float component1() {
                return this.progress;
            }

            public final WatchDemoMode component2() {
                return this.watchDemoMode;
            }

            public final Processing copy(Float f, WatchDemoMode watchDemoMode) {
                Intrinsics.checkNotNullParameter(watchDemoMode, "watchDemoMode");
                return new Processing(f, watchDemoMode);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Processing)) {
                    return false;
                }
                Processing processing = (Processing) obj;
                if (Intrinsics.areEqual(this.progress, processing.progress) && this.watchDemoMode == processing.watchDemoMode) {
                    return true;
                }
                return false;
            }

            public final Float getProgress() {
                return this.progress;
            }

            @Override // com.animaconnected.watch.provider.demo.DemoMode.Enabled
            public WatchDemoMode getWatchDemoMode() {
                return this.watchDemoMode;
            }

            public int hashCode() {
                int hashCode;
                Float f = this.progress;
                if (f == null) {
                    hashCode = 0;
                } else {
                    hashCode = f.hashCode();
                }
                return this.watchDemoMode.hashCode() + (hashCode * 31);
            }

            public String toString() {
                return "Processing(progress=" + this.progress + ", watchDemoMode=" + this.watchDemoMode + ')';
            }
        }

        static /* synthetic */ Processing toProcessing$default(Enabled enabled, Float f, int r2, Object obj) {
            if (obj == null) {
                if ((r2 & 1) != 0) {
                    f = null;
                }
                return enabled.toProcessing(f);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toProcessing");
        }

        WatchDemoMode getWatchDemoMode();

        default Idle toIdle() {
            return new Idle(getWatchDemoMode());
        }

        default Processing toProcessing(Float f) {
            return new Processing(f, getWatchDemoMode());
        }
    }

    default WatchDemoMode watchDemoModeToSync() {
        if (this instanceof Disabled) {
            boolean wasNeverActivated = ((Disabled) this).getWasNeverActivated();
            if (wasNeverActivated) {
                return null;
            }
            if (!wasNeverActivated) {
                return WatchDemoMode.None;
            }
            throw new NoWhenBranchMatchedException();
        }
        if (this instanceof Enabled) {
            return ((Enabled) this).getWatchDemoMode();
        }
        throw new NoWhenBranchMatchedException();
    }
}
