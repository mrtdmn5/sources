package androidx.compose.ui.draw;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PainterModifier.kt */
/* loaded from: classes.dex */
public final class PainterModifierKt {
    public static Modifier paint$default(Modifier modifier, Painter painter, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int r14) {
        boolean z;
        if ((r14 & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        boolean z2 = z;
        if ((r14 & 4) != 0) {
            alignment = Alignment.Companion.Center;
        }
        Alignment alignment2 = alignment;
        if ((r14 & 8) != 0) {
            contentScale = ContentScale.Companion.Inside;
        }
        ContentScale contentScale2 = contentScale;
        if ((r14 & 16) != 0) {
            f = 1.0f;
        }
        float f2 = f;
        if ((r14 & 32) != 0) {
            colorFilter = null;
        }
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(painter, "painter");
        Intrinsics.checkNotNullParameter(alignment2, "alignment");
        Intrinsics.checkNotNullParameter(contentScale2, "contentScale");
        return modifier.then(new PainterElement(painter, z2, alignment2, contentScale2, f2, colorFilter));
    }
}
