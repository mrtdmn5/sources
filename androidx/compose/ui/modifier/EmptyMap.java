package androidx.compose.ui.modifier;

import androidx.transition.PathMotion;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ModifierLocalModifierNode.kt */
/* loaded from: classes.dex */
public final class EmptyMap extends PathMotion {
    public static final EmptyMap INSTANCE = new EmptyMap();

    @Override // androidx.transition.PathMotion
    public final boolean contains$ui_release(ModifierLocal<?> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return false;
    }

    @Override // androidx.transition.PathMotion
    public final Object get$ui_release(ProvidableModifierLocal key) {
        Intrinsics.checkNotNullParameter(key, "key");
        throw new IllegalStateException("".toString());
    }
}
