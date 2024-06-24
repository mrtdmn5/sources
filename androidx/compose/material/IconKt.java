package androidx.compose.material;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorPainterKt;

/* compiled from: Icon.kt */
/* loaded from: classes.dex */
public final class IconKt {
    public static final Modifier DefaultIconSizeModifier;

    static {
        int r0 = Modifier.$r8$clinit;
        DefaultIconSizeModifier = SizeKt.m91size3ABfNKs(Modifier.Companion.$$INSTANCE, 24);
    }

    /* renamed from: Icon-ww6aTOc, reason: not valid java name */
    public static final void m188Iconww6aTOc(ImageVector imageVector, String str, Modifier modifier, Composer composer, int r12, int r13) {
        long j;
        composer.startReplaceableGroup(-800853103);
        if ((r13 & 4) != 0) {
            modifier = Modifier.Companion.$$INSTANCE;
        }
        Modifier modifier2 = modifier;
        if ((r13 & 8) != 0) {
            j = ColorKt.Color(Color.m322getRedimpl(r0), Color.m321getGreenimpl(r0), Color.m319getBlueimpl(r0), ((Number) composer.consume(ContentAlphaKt.LocalContentAlpha)).floatValue(), Color.m320getColorSpaceimpl(((Color) composer.consume(ContentColorKt.LocalContentColor)).value));
        } else {
            j = 0;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        m187Iconww6aTOc(VectorPainterKt.rememberVectorPainter(imageVector, composer), str, modifier2, j, composer, (r12 & 112) | 8 | (r12 & 896) | (r12 & 7168), 0);
        composer.endReplaceableGroup();
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00cf, code lost:            if ((java.lang.Float.isInfinite(androidx.compose.ui.geometry.Size.m276getWidthimpl(r5)) && java.lang.Float.isInfinite(androidx.compose.ui.geometry.Size.m274getHeightimpl(r5))) != false) goto L36;     */
    /* renamed from: Icon-ww6aTOc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m187Iconww6aTOc(final androidx.compose.ui.graphics.painter.Painter r15, final java.lang.String r16, androidx.compose.ui.Modifier r17, long r18, androidx.compose.runtime.Composer r20, final int r21, final int r22) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.IconKt.m187Iconww6aTOc(androidx.compose.ui.graphics.painter.Painter, java.lang.String, androidx.compose.ui.Modifier, long, androidx.compose.runtime.Composer, int, int):void");
    }
}
