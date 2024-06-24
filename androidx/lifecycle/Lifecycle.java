package androidx.lifecycle;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Lifecycle.kt */
/* loaded from: classes.dex */
public abstract class Lifecycle {
    public final AtomicReference<Object> internalScopeRef = new AtomicReference<>();

    /* compiled from: Lifecycle.kt */
    /* loaded from: classes.dex */
    public enum Event {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY;

        public static final Companion Companion = new Companion();

        /* compiled from: Lifecycle.kt */
        /* loaded from: classes.dex */
        public static final class Companion {

            /* compiled from: Lifecycle.kt */
            /* loaded from: classes.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] r0 = new int[State.values().length];
                    try {
                        r0[State.CREATED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        r0[State.STARTED.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        r0[State.RESUMED.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        r0[State.DESTROYED.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        r0[State.INITIALIZED.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    $EnumSwitchMapping$0 = r0;
                }
            }

            public static Event downFrom(State state) {
                Intrinsics.checkNotNullParameter(state, "state");
                int r1 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
                if (r1 != 1) {
                    if (r1 != 2) {
                        if (r1 != 3) {
                            return null;
                        }
                        return Event.ON_PAUSE;
                    }
                    return Event.ON_STOP;
                }
                return Event.ON_DESTROY;
            }

            public static Event upFrom(State state) {
                Intrinsics.checkNotNullParameter(state, "state");
                int r1 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
                if (r1 != 1) {
                    if (r1 != 2) {
                        if (r1 != 5) {
                            return null;
                        }
                        return Event.ON_CREATE;
                    }
                    return Event.ON_RESUME;
                }
                return Event.ON_START;
            }

            public static Event upTo(State state) {
                Intrinsics.checkNotNullParameter(state, "state");
                int r1 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
                if (r1 != 1) {
                    if (r1 != 2) {
                        if (r1 != 3) {
                            return null;
                        }
                        return Event.ON_RESUME;
                    }
                    return Event.ON_START;
                }
                return Event.ON_CREATE;
            }
        }

        /* compiled from: Lifecycle.kt */
        /* loaded from: classes.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] r0 = new int[Event.values().length];
                try {
                    r0[Event.ON_CREATE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    r0[Event.ON_STOP.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    r0[Event.ON_START.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    r0[Event.ON_PAUSE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    r0[Event.ON_RESUME.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    r0[Event.ON_DESTROY.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    r0[Event.ON_ANY.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                $EnumSwitchMapping$0 = r0;
            }
        }

        public static final Event downFrom(State state) {
            Companion.getClass();
            return Companion.downFrom(state);
        }

        public static final Event downTo(State state) {
            Companion.getClass();
            Intrinsics.checkNotNullParameter(state, "state");
            int r1 = Companion.WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
            if (r1 != 1) {
                if (r1 != 2) {
                    if (r1 != 4) {
                        return null;
                    }
                    return ON_DESTROY;
                }
                return ON_PAUSE;
            }
            return ON_STOP;
        }

        public static final Event upFrom(State state) {
            Companion.getClass();
            return Companion.upFrom(state);
        }

        public static final Event upTo(State state) {
            Companion.getClass();
            return Companion.upTo(state);
        }

        public final State getTargetState() {
            switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
                case 1:
                case 2:
                    return State.CREATED;
                case 3:
                case 4:
                    return State.STARTED;
                case 5:
                    return State.RESUMED;
                case 6:
                    return State.DESTROYED;
                default:
                    throw new IllegalArgumentException(this + " has no target state");
            }
        }
    }

    /* compiled from: Lifecycle.kt */
    /* loaded from: classes.dex */
    public enum State {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public final boolean isAtLeast(State state) {
            Intrinsics.checkNotNullParameter(state, "state");
            if (compareTo(state) >= 0) {
                return true;
            }
            return false;
        }
    }

    public abstract void addObserver(LifecycleObserver lifecycleObserver);

    public abstract State getCurrentState();

    public abstract void removeObserver(LifecycleObserver lifecycleObserver);
}
