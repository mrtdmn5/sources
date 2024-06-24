package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;

/* compiled from: Drawer.kt */
/* loaded from: classes.dex */
public final class DrawerDefaults {
    public static final float Elevation = 16;

    public static long getScrimColor(Composer composer) {
        long Color;
        composer.startReplaceableGroup(617225966);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        Color = ColorKt.Color(Color.m322getRedimpl(r0), Color.m321getGreenimpl(r0), Color.m319getBlueimpl(r0), 0.32f, Color.m320getColorSpaceimpl(((Colors) composer.consume(ColorsKt.LocalColors)).m169getOnSurface0d7_KjU()));
        composer.endReplaceableGroup();
        return Color;
    }
}
