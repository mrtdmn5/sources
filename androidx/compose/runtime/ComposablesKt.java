package androidx.compose.runtime;

import androidx.compose.runtime.ComposerImpl;

/* compiled from: Composables.kt */
/* loaded from: classes.dex */
public final class ComposablesKt {
    public static final int getCurrentCompositeKeyHash(Composer composer) {
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        return composer.getCompoundKeyHash();
    }

    public static final void invalidApplier() {
        throw new IllegalStateException("Invalid applier".toString());
    }

    public static final CompositionContext rememberCompositionContext(Composer composer) {
        composer.startReplaceableGroup(-1165786124);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        ComposerImpl.CompositionContextImpl buildContext = composer.buildContext();
        composer.endReplaceableGroup();
        return buildContext;
    }
}
