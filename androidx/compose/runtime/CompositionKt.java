package androidx.compose.runtime;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: Composition.kt */
/* loaded from: classes.dex */
public final class CompositionKt {
    public static final Object PendingApplyNoModifications = new Object();

    public static final CompositionImpl Composition(AbstractApplier abstractApplier, CompositionContext parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return new CompositionImpl(parent, abstractApplier);
    }
}
