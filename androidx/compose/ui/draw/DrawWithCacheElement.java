package androidx.compose.ui.draw;

import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DrawModifier.kt */
/* loaded from: classes.dex */
final class DrawWithCacheElement extends ModifierNodeElement<CacheDrawModifierNodeImpl> {
    public final Function1<CacheDrawScope, DrawResult> onBuildDrawCache;

    /* JADX WARN: Multi-variable type inference failed */
    public DrawWithCacheElement(Function1<? super CacheDrawScope, DrawResult> onBuildDrawCache) {
        Intrinsics.checkNotNullParameter(onBuildDrawCache, "onBuildDrawCache");
        this.onBuildDrawCache = onBuildDrawCache;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final CacheDrawModifierNodeImpl create() {
        return new CacheDrawModifierNodeImpl(new CacheDrawScope(), this.onBuildDrawCache);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof DrawWithCacheElement) && Intrinsics.areEqual(this.onBuildDrawCache, ((DrawWithCacheElement) obj).onBuildDrawCache)) {
            return true;
        }
        return false;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final int hashCode() {
        return this.onBuildDrawCache.hashCode();
    }

    public final String toString() {
        return "DrawWithCacheElement(onBuildDrawCache=" + this.onBuildDrawCache + ')';
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(CacheDrawModifierNodeImpl cacheDrawModifierNodeImpl) {
        CacheDrawModifierNodeImpl node = cacheDrawModifierNodeImpl;
        Intrinsics.checkNotNullParameter(node, "node");
        Function1<CacheDrawScope, DrawResult> value = this.onBuildDrawCache;
        Intrinsics.checkNotNullParameter(value, "value");
        node.block = value;
        node.invalidateDrawCache();
    }
}
