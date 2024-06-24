package com.amplifyframework.statemachine;

/* compiled from: State.kt */
/* loaded from: classes.dex */
public interface State {

    /* compiled from: State.kt */
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static String getType(State state) {
            return state.getClass().getSimpleName();
        }
    }

    boolean equals(Object obj);

    String getType();

    int hashCode();

    String toString();
}
