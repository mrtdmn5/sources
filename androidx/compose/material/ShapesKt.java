package androidx.compose.material;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import kotlin.jvm.functions.Function0;

/* compiled from: Shapes.kt */
/* loaded from: classes.dex */
public final class ShapesKt {
    public static final StaticProvidableCompositionLocal LocalShapes = CompositionLocalKt.staticCompositionLocalOf(new Function0<Shapes>() { // from class: androidx.compose.material.ShapesKt$LocalShapes$1
        @Override // kotlin.jvm.functions.Function0
        public final Shapes invoke() {
            return new Shapes(0);
        }
    });
}
