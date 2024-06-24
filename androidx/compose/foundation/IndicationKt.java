package androidx.compose.foundation;

import androidx.compose.animation.EnterExitTransitionKt$shrinkExpand$1$$ExternalSyntheticOutline0;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Indication.kt */
/* loaded from: classes.dex */
public final class IndicationKt {
    public static final StaticProvidableCompositionLocal LocalIndication = CompositionLocalKt.staticCompositionLocalOf(new Function0<Indication>() { // from class: androidx.compose.foundation.IndicationKt$LocalIndication$1
        @Override // kotlin.jvm.functions.Function0
        public final /* bridge */ /* synthetic */ Indication invoke() {
            return DefaultDebugIndication.INSTANCE;
        }
    });

    public static final Modifier indication(Modifier modifier, final InteractionSource interactionSource, final Indication indication) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.NoInspectorInfo, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.IndicationKt$indication$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Modifier invoke(Modifier modifier2, Composer composer, Integer num) {
                Composer composer2 = composer;
                EnterExitTransitionKt$shrinkExpand$1$$ExternalSyntheticOutline0.m(num, modifier2, "$this$composed", composer2, -353972293);
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                Indication indication2 = Indication.this;
                if (indication2 == null) {
                    indication2 = NoIndication.INSTANCE;
                }
                IndicationInstance rememberUpdatedInstance = indication2.rememberUpdatedInstance(interactionSource, composer2);
                composer2.startReplaceableGroup(1157296644);
                boolean changed = composer2.changed(rememberUpdatedInstance);
                Object rememberedValue = composer2.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.Empty) {
                    rememberedValue = new IndicationModifier(rememberUpdatedInstance);
                    composer2.updateRememberedValue(rememberedValue);
                }
                composer2.endReplaceableGroup();
                IndicationModifier indicationModifier = (IndicationModifier) rememberedValue;
                composer2.endReplaceableGroup();
                return indicationModifier;
            }
        });
    }
}
