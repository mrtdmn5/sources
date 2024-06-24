package androidx.compose.material;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.DynamicProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import kotlin.jvm.functions.Function0;

/* compiled from: ContentColor.kt */
/* loaded from: classes.dex */
public final class ContentColorKt {
    public static final DynamicProvidableCompositionLocal LocalContentColor = CompositionLocalKt.compositionLocalOf$default(new Function0<Color>() { // from class: androidx.compose.material.ContentColorKt$LocalContentColor$1
        @Override // kotlin.jvm.functions.Function0
        public final Color invoke() {
            return new Color(Color.Black);
        }
    });
}
