package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;

/* compiled from: ContentAlpha.kt */
/* loaded from: classes.dex */
public final class ContentAlpha {
    public static float contentAlpha(float f, float f2, Composer composer) {
        composer.startReplaceableGroup(-1528360391);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        long j = ((Color) composer.consume(ContentColorKt.LocalContentColor)).value;
        if (!((Colors) composer.consume(ColorsKt.LocalColors)).isLight() ? ColorKt.m326luminance8_81llA(j) >= 0.5d : ColorKt.m326luminance8_81llA(j) <= 0.5d) {
            f = f2;
        }
        composer.endReplaceableGroup();
        return f;
    }

    public static float getDisabled(Composer composer, int r1) {
        composer.startReplaceableGroup(621183615);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        float contentAlpha = contentAlpha(0.38f, 0.38f, composer);
        composer.endReplaceableGroup();
        return contentAlpha;
    }

    public static float getHigh(Composer composer) {
        composer.startReplaceableGroup(629162431);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        float contentAlpha = contentAlpha(1.0f, 0.87f, composer);
        composer.endReplaceableGroup();
        return contentAlpha;
    }

    public static float getMedium(Composer composer) {
        composer.startReplaceableGroup(1999054879);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        float contentAlpha = contentAlpha(0.74f, 0.6f, composer);
        composer.endReplaceableGroup();
        return contentAlpha;
    }
}
