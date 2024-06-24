package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DrawModifier.kt */
/* loaded from: classes.dex */
public final class CacheDrawModifierNodeImpl extends Modifier.Node implements CacheDrawModifierNode, ObserverModifierNode, BuildDrawCacheParams {
    public Function1<? super CacheDrawScope, DrawResult> block;
    public final CacheDrawScope cacheDrawScope;
    public boolean isCacheValid;

    public CacheDrawModifierNodeImpl(CacheDrawScope cacheDrawScope, Function1<? super CacheDrawScope, DrawResult> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.cacheDrawScope = cacheDrawScope;
        this.block = block;
        cacheDrawScope.cacheParams = this;
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public final void draw(ContentDrawScope contentDrawScope) {
        Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
        boolean z = this.isCacheValid;
        final CacheDrawScope cacheDrawScope = this.cacheDrawScope;
        if (!z) {
            cacheDrawScope.drawResult = null;
            ObserverModifierNodeKt.observeReads(this, new Function0<Unit>() { // from class: androidx.compose.ui.draw.CacheDrawModifierNodeImpl$getOrBuildCachedDrawBlock$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    CacheDrawModifierNodeImpl.this.block.invoke(cacheDrawScope);
                    return Unit.INSTANCE;
                }
            });
            if (cacheDrawScope.drawResult != null) {
                this.isCacheValid = true;
            } else {
                throw new IllegalStateException("DrawResult not defined, did you forget to call onDraw?".toString());
            }
        }
        DrawResult drawResult = cacheDrawScope.drawResult;
        Intrinsics.checkNotNull(drawResult);
        drawResult.block.invoke(contentDrawScope);
    }

    @Override // androidx.compose.ui.draw.BuildDrawCacheParams
    public final Density getDensity() {
        return DelegatableNodeKt.requireLayoutNode(this).density;
    }

    @Override // androidx.compose.ui.draw.BuildDrawCacheParams
    public final LayoutDirection getLayoutDirection() {
        return DelegatableNodeKt.requireLayoutNode(this).layoutDirection;
    }

    @Override // androidx.compose.ui.draw.BuildDrawCacheParams
    /* renamed from: getSize-NH-jbRc */
    public final long mo230getSizeNHjbRc() {
        return IntSizeKt.m595toSizeozmzZPI(DelegatableNodeKt.m441requireCoordinator64DMado(this, 128).measuredSize);
    }

    @Override // androidx.compose.ui.draw.CacheDrawModifierNode
    public final void invalidateDrawCache() {
        this.isCacheValid = false;
        this.cacheDrawScope.drawResult = null;
        DrawModifierNodeKt.invalidateDraw(this);
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public final void onMeasureResultChanged() {
        invalidateDrawCache();
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public final void onObservedReadsChanged() {
        invalidateDrawCache();
    }
}
