package androidx.compose.runtime;

/* compiled from: RecomposeScopeImpl.kt */
/* loaded from: classes.dex */
public interface RecomposeScopeOwner {
    InvalidationResult invalidate(RecomposeScopeImpl recomposeScopeImpl, Object obj);

    void recomposeScopeReleased(RecomposeScopeImpl recomposeScopeImpl);

    void recordReadOf(Object obj);
}
