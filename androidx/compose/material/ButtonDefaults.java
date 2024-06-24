package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;

/* compiled from: Button.kt */
/* loaded from: classes.dex */
public final class ButtonDefaults {
    public static final PaddingValuesImpl ContentPadding;
    public static final PaddingValuesImpl TextButtonContentPadding;
    public static final float MinWidth = 64;
    public static final float MinHeight = 36;
    public static final float OutlinedBorderSize = 1;

    static {
        float f = 16;
        float f2 = 8;
        ContentPadding = new PaddingValuesImpl(f, f2, f, f2);
        TextButtonContentPadding = new PaddingValuesImpl(f2, f2, f2, f2);
    }

    /* renamed from: buttonColors-ro_MJ88, reason: not valid java name */
    public static DefaultButtonColors m160buttonColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int r21, int r22) {
        long j5;
        long j6;
        long j7;
        long j8;
        long Color;
        long Color2;
        composer.startReplaceableGroup(1870371134);
        if ((r22 & 1) != 0) {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            j5 = ((Colors) composer.consume(ColorsKt.LocalColors)).m170getPrimary0d7_KjU();
        } else {
            j5 = j;
        }
        if ((r22 & 2) != 0) {
            j6 = ColorsKt.m176contentColorForek8zF_U(j5, composer);
        } else {
            j6 = j2;
        }
        if ((r22 & 4) != 0) {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = ColorsKt.LocalColors;
            Color2 = ColorKt.Color(Color.m322getRedimpl(r2), Color.m321getGreenimpl(r2), Color.m319getBlueimpl(r2), 0.12f, Color.m320getColorSpaceimpl(((Colors) composer.consume(staticProvidableCompositionLocal)).m169getOnSurface0d7_KjU()));
            j7 = ColorKt.m324compositeOverOWjLjI(Color2, ((Colors) composer.consume(staticProvidableCompositionLocal)).m174getSurface0d7_KjU());
        } else {
            j7 = j3;
        }
        if ((r22 & 8) != 0) {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$13 = ComposerKt.removeCurrentGroupInstance;
            Color = ColorKt.Color(Color.m322getRedimpl(r1), Color.m321getGreenimpl(r1), Color.m319getBlueimpl(r1), ContentAlpha.getDisabled(composer, 6), Color.m320getColorSpaceimpl(((Colors) composer.consume(ColorsKt.LocalColors)).m169getOnSurface0d7_KjU()));
            j8 = Color;
        } else {
            j8 = j4;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$14 = ComposerKt.removeCurrentGroupInstance;
        DefaultButtonColors defaultButtonColors = new DefaultButtonColors(j5, j6, j7, j8);
        composer.endReplaceableGroup();
        return defaultButtonColors;
    }

    /* renamed from: outlinedButtonColors-RGew2ao, reason: not valid java name */
    public static DefaultButtonColors m161outlinedButtonColorsRGew2ao(long j, long j2, Composer composer, int r14) {
        long j3;
        composer.startReplaceableGroup(-2124406093);
        if ((r14 & 1) != 0) {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            j = ((Colors) composer.consume(ColorsKt.LocalColors)).m174getSurface0d7_KjU();
        }
        long j4 = j;
        if ((r14 & 2) != 0) {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
            j2 = ((Colors) composer.consume(ColorsKt.LocalColors)).m170getPrimary0d7_KjU();
        }
        long j5 = j2;
        if ((r14 & 4) != 0) {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$13 = ComposerKt.removeCurrentGroupInstance;
            j3 = ColorKt.Color(Color.m322getRedimpl(r9), Color.m321getGreenimpl(r9), Color.m319getBlueimpl(r9), ContentAlpha.getDisabled(composer, 6), Color.m320getColorSpaceimpl(((Colors) composer.consume(ColorsKt.LocalColors)).m169getOnSurface0d7_KjU()));
        } else {
            j3 = 0;
        }
        long j6 = j3;
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$14 = ComposerKt.removeCurrentGroupInstance;
        DefaultButtonColors defaultButtonColors = new DefaultButtonColors(j4, j5, j4, j6);
        composer.endReplaceableGroup();
        return defaultButtonColors;
    }
}
