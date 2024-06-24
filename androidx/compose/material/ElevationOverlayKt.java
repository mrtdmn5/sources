package androidx.compose.material;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.DynamicProvidableCompositionLocal;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.functions.Function0;

/* compiled from: ElevationOverlay.kt */
/* loaded from: classes.dex */
public final class ElevationOverlayKt {
    public static final StaticProvidableCompositionLocal LocalElevationOverlay = CompositionLocalKt.staticCompositionLocalOf(new Function0<ElevationOverlay>() { // from class: androidx.compose.material.ElevationOverlayKt$LocalElevationOverlay$1
        @Override // kotlin.jvm.functions.Function0
        public final /* bridge */ /* synthetic */ ElevationOverlay invoke() {
            return DefaultElevationOverlay.INSTANCE;
        }
    });
    public static final DynamicProvidableCompositionLocal LocalAbsoluteElevation = CompositionLocalKt.compositionLocalOf$default(new Function0<Dp>() { // from class: androidx.compose.material.ElevationOverlayKt$LocalAbsoluteElevation$1
        @Override // kotlin.jvm.functions.Function0
        public final Dp invoke() {
            return new Dp(0);
        }
    });
}
