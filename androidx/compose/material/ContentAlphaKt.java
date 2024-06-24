package androidx.compose.material;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.DynamicProvidableCompositionLocal;
import kotlin.jvm.functions.Function0;

/* compiled from: ContentAlpha.kt */
/* loaded from: classes.dex */
public final class ContentAlphaKt {
    public static final DynamicProvidableCompositionLocal LocalContentAlpha = CompositionLocalKt.compositionLocalOf$default(new Function0<Float>() { // from class: androidx.compose.material.ContentAlphaKt$LocalContentAlpha$1
        @Override // kotlin.jvm.functions.Function0
        public final Float invoke() {
            return Float.valueOf(1.0f);
        }
    });
}
