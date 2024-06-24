package androidx.compose.material;

import androidx.compose.animation.EnterExitTransitionKt$shrinkExpand$1$$ExternalSyntheticOutline0;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.DpKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InteractiveComponentSize.kt */
/* loaded from: classes.dex */
public final class InteractiveComponentSizeKt {
    public static final StaticProvidableCompositionLocal LocalMinimumInteractiveComponentEnforcement = CompositionLocalKt.staticCompositionLocalOf(new Function0<Boolean>() { // from class: androidx.compose.material.InteractiveComponentSizeKt$LocalMinimumInteractiveComponentEnforcement$1
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.TRUE;
        }
    });
    public static final long minimumInteractiveComponentSize;

    static {
        float f = 48;
        minimumInteractiveComponentSize = DpKt.m582DpSizeYgX7TsA(f, f);
    }

    public static final Modifier minimumInteractiveComponentSize(Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.NoInspectorInfo, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.material.InteractiveComponentSizeKt$minimumInteractiveComponentSize$2
            @Override // kotlin.jvm.functions.Function3
            public final Modifier invoke(Modifier modifier2, Composer composer, Integer num) {
                Modifier modifier3;
                Composer composer2 = composer;
                EnterExitTransitionKt$shrinkExpand$1$$ExternalSyntheticOutline0.m(num, modifier2, "$this$composed", composer2, 1964721376);
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                if (((Boolean) composer2.consume(InteractiveComponentSizeKt.LocalMinimumInteractiveComponentEnforcement)).booleanValue()) {
                    modifier3 = new MinimumInteractiveComponentSizeModifier(InteractiveComponentSizeKt.minimumInteractiveComponentSize);
                } else {
                    modifier3 = Modifier.Companion.$$INSTANCE;
                }
                composer2.endReplaceableGroup();
                return modifier3;
            }
        });
    }
}
