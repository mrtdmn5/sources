package androidx.compose.material;

import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.ui.Modifier;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Card.kt */
/* loaded from: classes.dex */
public final class CardKt {
    /* renamed from: Card-F-jzlyU, reason: not valid java name */
    public static final void m162CardFjzlyU(Modifier modifier, RoundedCornerShape roundedCornerShape, float f, Function2 content, Composer composer, int r19, int r20) {
        Modifier modifier2;
        CornerBasedShape cornerBasedShape;
        long j;
        float f2;
        Intrinsics.checkNotNullParameter(content, "content");
        composer.startReplaceableGroup(1956755640);
        if ((r20 & 1) != 0) {
            modifier2 = Modifier.Companion.$$INSTANCE;
        } else {
            modifier2 = modifier;
        }
        if ((r20 & 2) != 0) {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            cornerBasedShape = ((Shapes) composer.consume(ShapesKt.LocalShapes)).medium;
        } else {
            cornerBasedShape = roundedCornerShape;
        }
        long j2 = 0;
        if ((r20 & 4) != 0) {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
            j = ((Colors) composer.consume(ColorsKt.LocalColors)).m174getSurface0d7_KjU();
        } else {
            j = 0;
        }
        if ((r20 & 8) != 0) {
            j2 = ColorsKt.m176contentColorForek8zF_U(j, composer);
        }
        if ((r20 & 32) != 0) {
            f2 = 1;
        } else {
            f2 = f;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$13 = ComposerKt.removeCurrentGroupInstance;
        SurfaceKt.m205SurfaceFjzlyU(modifier2, cornerBasedShape, j, j2, null, f2, content, composer, (r19 & 14) | (r19 & 112) | (r19 & 896) | (r19 & 7168) | (57344 & r19) | (458752 & r19) | (r19 & 3670016), 0);
        composer.endReplaceableGroup();
    }
}
