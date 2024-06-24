package androidx.compose.ui.draw;

import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.unit.Density;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DrawModifier.kt */
/* loaded from: classes.dex */
public final class CacheDrawScope implements Density {
    public BuildDrawCacheParams cacheParams = EmptyBuildDrawCacheParams.INSTANCE;
    public DrawResult drawResult;

    @Override // androidx.compose.ui.unit.Density
    public final float getDensity() {
        return this.cacheParams.getDensity().getDensity();
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getFontScale() {
        return this.cacheParams.getDensity().getFontScale();
    }

    /* renamed from: getSize-NH-jbRc, reason: not valid java name */
    public final long m231getSizeNHjbRc() {
        return this.cacheParams.mo230getSizeNHjbRc();
    }

    public final DrawResult onDrawWithContent(Function1<? super ContentDrawScope, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        DrawResult drawResult = new DrawResult(block);
        this.drawResult = drawResult;
        return drawResult;
    }
}
