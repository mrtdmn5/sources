package androidx.compose.runtime;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Effects.kt */
/* loaded from: classes.dex */
public final class DisposableEffectImpl implements RememberObserver {
    public final Function1<DisposableEffectScope, DisposableEffectResult> effect;
    public DisposableEffectResult onDispose;

    /* JADX WARN: Multi-variable type inference failed */
    public DisposableEffectImpl(Function1<? super DisposableEffectScope, ? extends DisposableEffectResult> effect) {
        Intrinsics.checkNotNullParameter(effect, "effect");
        this.effect = effect;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onForgotten() {
        DisposableEffectResult disposableEffectResult = this.onDispose;
        if (disposableEffectResult != null) {
            disposableEffectResult.dispose();
        }
        this.onDispose = null;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onRemembered() {
        this.onDispose = this.effect.invoke(EffectsKt.InternalDisposableEffectScope);
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onAbandoned() {
    }
}
