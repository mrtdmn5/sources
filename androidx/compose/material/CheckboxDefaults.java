package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;

/* compiled from: Checkbox.kt */
/* loaded from: classes.dex */
public final class CheckboxDefaults {
    /* renamed from: colors-zjMxDiM, reason: not valid java name */
    public static DefaultCheckboxColors m163colorszjMxDiM(long j, long j2, long j3, long j4, Composer composer, int r35) {
        long j5;
        long j6;
        long j7;
        long j8;
        long j9;
        long Color;
        long Color2;
        long Color3;
        long Color4;
        long Color5;
        composer.startReplaceableGroup(469524104);
        if ((r35 & 1) != 0) {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            j5 = ((Colors) composer.consume(ColorsKt.LocalColors)).m172getSecondary0d7_KjU();
        } else {
            j5 = j;
        }
        if ((r35 & 2) != 0) {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
            Color5 = ColorKt.Color(Color.m322getRedimpl(r3), Color.m321getGreenimpl(r3), Color.m319getBlueimpl(r3), 0.6f, Color.m320getColorSpaceimpl(((Colors) composer.consume(ColorsKt.LocalColors)).m169getOnSurface0d7_KjU()));
            j6 = Color5;
        } else {
            j6 = j2;
        }
        if ((r35 & 4) != 0) {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$13 = ComposerKt.removeCurrentGroupInstance;
            j7 = ((Colors) composer.consume(ColorsKt.LocalColors)).m174getSurface0d7_KjU();
        } else {
            j7 = j3;
        }
        if ((r35 & 8) != 0) {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$14 = ComposerKt.removeCurrentGroupInstance;
            Color4 = ColorKt.Color(Color.m322getRedimpl(r7), Color.m321getGreenimpl(r7), Color.m319getBlueimpl(r7), ContentAlpha.getDisabled(composer, 6), Color.m320getColorSpaceimpl(((Colors) composer.consume(ColorsKt.LocalColors)).m169getOnSurface0d7_KjU()));
            j8 = Color4;
        } else {
            j8 = j4;
        }
        if ((r35 & 16) != 0) {
            j9 = ColorKt.Color(Color.m322getRedimpl(j5), Color.m321getGreenimpl(j5), Color.m319getBlueimpl(j5), ContentAlpha.getDisabled(composer, 6), Color.m320getColorSpaceimpl(j5));
        } else {
            j9 = 0;
        }
        long j10 = j9;
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$15 = ComposerKt.removeCurrentGroupInstance;
        Object[] objArr = {new Color(j5), new Color(j6), new Color(j7), new Color(j8), new Color(j10)};
        composer.startReplaceableGroup(-568225417);
        boolean z = false;
        for (int r6 = 0; r6 < 5; r6++) {
            z |= composer.changed(objArr[r6]);
        }
        Object rememberedValue = composer.rememberedValue();
        if (z || rememberedValue == Composer.Companion.Empty) {
            Color = ColorKt.Color(Color.m322getRedimpl(j7), Color.m321getGreenimpl(j7), Color.m319getBlueimpl(j7), 0.0f, Color.m320getColorSpaceimpl(j7));
            Color2 = ColorKt.Color(Color.m322getRedimpl(j5), Color.m321getGreenimpl(j5), Color.m319getBlueimpl(j5), 0.0f, Color.m320getColorSpaceimpl(j5));
            Color3 = ColorKt.Color(Color.m322getRedimpl(j8), Color.m321getGreenimpl(j8), Color.m319getBlueimpl(j8), 0.0f, Color.m320getColorSpaceimpl(j8));
            long j11 = j8;
            DefaultCheckboxColors defaultCheckboxColors = new DefaultCheckboxColors(j7, Color, j5, Color2, j11, Color3, j10, j5, j6, j11, j10);
            composer.updateRememberedValue(defaultCheckboxColors);
            rememberedValue = defaultCheckboxColors;
        }
        composer.endReplaceableGroup();
        DefaultCheckboxColors defaultCheckboxColors2 = (DefaultCheckboxColors) rememberedValue;
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$16 = ComposerKt.removeCurrentGroupInstance;
        composer.endReplaceableGroup();
        return defaultCheckboxColors2;
    }
}
