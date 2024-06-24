package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;

/* compiled from: MaterialTheme.kt */
/* loaded from: classes.dex */
public final class MaterialTheme {
    public static Colors getColors(Composer composer) {
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        return (Colors) composer.consume(ColorsKt.LocalColors);
    }

    public static Typography getTypography(Composer composer) {
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        return (Typography) composer.consume(TypographyKt.LocalTypography);
    }
}
