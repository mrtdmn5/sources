package com.amplifyframework.statemachine;

import com.amplifyframework.statemachine.State;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StateResolution.kt */
/* loaded from: classes.dex */
public final class StateResolution<T extends State> {
    public static final Companion Companion = new Companion(null);
    private final List<Action> actions;
    private final T newState;

    /* compiled from: StateResolution.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final <T extends State> StateResolution<T> from(T _state) {
            Intrinsics.checkNotNullParameter(_state, "_state");
            return new StateResolution<>(_state, null, 2, 0 == true ? 1 : 0);
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StateResolution(T newState, List<? extends Action> actions) {
        Intrinsics.checkNotNullParameter(newState, "newState");
        Intrinsics.checkNotNullParameter(actions, "actions");
        this.newState = newState;
        this.actions = actions;
    }

    public final List<Action> getActions() {
        return this.actions;
    }

    public final T getNewState() {
        return this.newState;
    }

    public /* synthetic */ StateResolution(State state, List list, int r3, DefaultConstructorMarker defaultConstructorMarker) {
        this(state, (r3 & 2) != 0 ? EmptyList.INSTANCE : list);
    }
}
