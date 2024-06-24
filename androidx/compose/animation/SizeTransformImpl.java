package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.unit.IntSize;
import kotlin.jvm.functions.Function2;

/* compiled from: AnimatedContent.kt */
/* loaded from: classes.dex */
public final class SizeTransformImpl implements SizeTransform {
    public final boolean clip;
    public final Function2<IntSize, IntSize, FiniteAnimationSpec<IntSize>> sizeAnimationSpec;

    /* JADX WARN: Multi-variable type inference failed */
    public SizeTransformImpl(boolean z, Function2<? super IntSize, ? super IntSize, ? extends FiniteAnimationSpec<IntSize>> function2) {
        this.clip = z;
        this.sizeAnimationSpec = function2;
    }

    @Override // androidx.compose.animation.SizeTransform
    /* renamed from: createAnimationSpec-TemP2vQ */
    public final FiniteAnimationSpec<IntSize> mo8createAnimationSpecTemP2vQ(long j, long j2) {
        return this.sizeAnimationSpec.invoke(new IntSize(j), new IntSize(j2));
    }

    @Override // androidx.compose.animation.SizeTransform
    public final boolean getClip() {
        return this.clip;
    }
}
