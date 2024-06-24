package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;

/* compiled from: ElevationOverlay.kt */
/* loaded from: classes.dex */
public final class DefaultElevationOverlay implements ElevationOverlay {
    public static final DefaultElevationOverlay INSTANCE = new DefaultElevationOverlay();

    @Override // androidx.compose.material.ElevationOverlay
    /* renamed from: apply-7g2Lkgo, reason: not valid java name */
    public final long mo179apply7g2Lkgo(long j, float f, Composer composer, int r7) {
        long Color;
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        Colors colors = (Colors) composer.consume(ColorsKt.LocalColors);
        if (Float.compare(f, 0) > 0 && !colors.isLight()) {
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = ElevationOverlayKt.LocalElevationOverlay;
            Color = ColorKt.Color(Color.m322getRedimpl(r6), Color.m321getGreenimpl(r6), Color.m319getBlueimpl(r6), ((((float) Math.log(f + 1)) * 4.5f) + 2.0f) / 100.0f, Color.m320getColorSpaceimpl(ColorsKt.m176contentColorForek8zF_U(j, composer)));
            return ColorKt.m324compositeOverOWjLjI(Color, j);
        }
        return j;
    }
}
