package androidx.compose.ui.modifier;

import androidx.transition.PathMotion;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ModifierLocalModifierNode.kt */
/* loaded from: classes.dex */
public final class BackwardsCompatLocalMap extends PathMotion {
    public ModifierLocalProvider<?> element;

    public BackwardsCompatLocalMap(ModifierLocalProvider<?> element) {
        Intrinsics.checkNotNullParameter(element, "element");
        this.element = element;
    }

    @Override // androidx.transition.PathMotion
    public final boolean contains$ui_release(ModifierLocal<?> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (key == this.element.getKey()) {
            return true;
        }
        return false;
    }

    @Override // androidx.transition.PathMotion
    public final Object get$ui_release(ProvidableModifierLocal key) {
        boolean z;
        Intrinsics.checkNotNullParameter(key, "key");
        if (key == this.element.getKey()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return this.element.getValue();
        }
        throw new IllegalStateException("Check failed.".toString());
    }
}
