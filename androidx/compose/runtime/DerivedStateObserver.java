package androidx.compose.runtime;

/* compiled from: DerivedState.kt */
/* loaded from: classes.dex */
public interface DerivedStateObserver {
    void done(DerivedState<?> derivedState);

    void start(DerivedState<?> derivedState);
}
