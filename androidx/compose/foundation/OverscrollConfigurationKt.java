package androidx.compose.foundation;

import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.DynamicProvidableCompositionLocal;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.jvm.functions.Function0;

/* compiled from: OverscrollConfiguration.kt */
/* loaded from: classes.dex */
public final class OverscrollConfigurationKt {
    public static final DynamicProvidableCompositionLocal LocalOverscrollConfiguration = CompositionLocalKt.compositionLocalOf$default(new Function0<OverscrollConfiguration>() { // from class: androidx.compose.foundation.OverscrollConfigurationKt$LocalOverscrollConfiguration$1
        @Override // kotlin.jvm.functions.Function0
        public final OverscrollConfiguration invoke() {
            float f = 0;
            return new OverscrollConfiguration(ColorKt.Color(4284900966L), new PaddingValuesImpl(f, f, f, f));
        }
    });
}
