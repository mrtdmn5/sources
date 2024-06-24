package androidx.compose.runtime;

import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.internal.ContextScope;

/* compiled from: Effects.kt */
/* loaded from: classes.dex */
public final class CompositionScopedCoroutineScopeCanceller implements RememberObserver {
    public final CoroutineScope coroutineScope;

    public CompositionScopedCoroutineScopeCanceller(ContextScope contextScope) {
        this.coroutineScope = contextScope;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onAbandoned() {
        CoroutineScopeKt.cancel(this.coroutineScope, new LeftCompositionCancellationException());
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onForgotten() {
        CoroutineScopeKt.cancel(this.coroutineScope, new LeftCompositionCancellationException());
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onRemembered() {
    }
}
