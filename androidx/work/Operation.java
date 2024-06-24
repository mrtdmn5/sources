package androidx.work;

import android.annotation.SuppressLint;

/* loaded from: classes.dex */
public interface Operation {

    @SuppressLint({"SyntheticAccessor"})
    public static final State.SUCCESS SUCCESS = new State.SUCCESS();

    @SuppressLint({"SyntheticAccessor"})
    public static final State.IN_PROGRESS IN_PROGRESS = new State.IN_PROGRESS();

    /* loaded from: classes.dex */
    public static abstract class State {

        /* loaded from: classes.dex */
        public static final class FAILURE extends State {
            public final Throwable mThrowable;

            public FAILURE(Throwable exception) {
                this.mThrowable = exception;
            }

            public final String toString() {
                return String.format("FAILURE (%s)", this.mThrowable.getMessage());
            }
        }

        /* loaded from: classes.dex */
        public static final class IN_PROGRESS extends State {
            public final String toString() {
                return "IN_PROGRESS";
            }
        }

        /* loaded from: classes.dex */
        public static final class SUCCESS extends State {
            public final String toString() {
                return "SUCCESS";
            }
        }
    }
}
