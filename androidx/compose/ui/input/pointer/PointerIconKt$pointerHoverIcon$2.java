package androidx.compose.ui.input.pointer;

import androidx.compose.animation.EnterExitTransitionKt$shrinkExpand$1$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.TextPointerIcon_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer$Companion$Empty$1;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: PointerIcon.kt */
/* loaded from: classes.dex */
public final class PointerIconKt$pointerHoverIcon$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    public final /* synthetic */ PointerIcon $icon = TextPointerIcon_androidKt.textPointerIcon;
    public final /* synthetic */ boolean $overrideDescendants;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PointerIconKt$pointerHoverIcon$2(boolean z) {
        super(3);
        this.$overrideDescendants = z;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Modifier invoke(Modifier modifier, Composer composer, Integer num) {
        Modifier modifier2 = modifier;
        Composer composer2 = composer;
        EnterExitTransitionKt$shrinkExpand$1$$ExternalSyntheticOutline0.m(num, modifier2, "$this$composed", composer2, 811087536);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        PointerIconService pointerIconService = (PointerIconService) composer2.consume(CompositionLocalsKt.LocalPointerIconService);
        Modifier modifier3 = Modifier.Companion.$$INSTANCE;
        if (pointerIconService != null) {
            final PointerIconKt$pointerHoverIcon$2$onSetIcon$1 pointerIconKt$pointerHoverIcon$2$onSetIcon$1 = new Function1<PointerIcon, Unit>() { // from class: androidx.compose.ui.input.pointer.PointerIconKt$pointerHoverIcon$2$onSetIcon$1
                public PointerIconKt$pointerHoverIcon$2$onSetIcon$1() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(PointerIcon pointerIcon) {
                    PointerIconService.this.setIcon(pointerIcon);
                    return Unit.INSTANCE;
                }
            };
            composer2.startReplaceableGroup(-492369756);
            Object rememberedValue = composer2.rememberedValue();
            Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
            final boolean z = this.$overrideDescendants;
            final PointerIcon pointerIcon = this.$icon;
            if (rememberedValue == composer$Companion$Empty$1) {
                rememberedValue = new PointerIconModifierLocal(pointerIcon, z, pointerIconKt$pointerHoverIcon$2$onSetIcon$1);
                composer2.updateRememberedValue(rememberedValue);
            }
            composer2.endReplaceableGroup();
            final PointerIconModifierLocal pointerIconModifierLocal = (PointerIconModifierLocal) rememberedValue;
            Object[] objArr = {pointerIconModifierLocal, pointerIcon, Boolean.valueOf(z), pointerIconKt$pointerHoverIcon$2$onSetIcon$1};
            composer2.startReplaceableGroup(-568225417);
            boolean z2 = false;
            boolean z3 = false;
            for (int r7 = 0; r7 < 4; r7++) {
                z3 |= composer2.changed(objArr[r7]);
            }
            Object rememberedValue2 = composer2.rememberedValue();
            if (z3 || rememberedValue2 == composer$Companion$Empty$1) {
                rememberedValue2 = new Function0<Unit>() { // from class: androidx.compose.ui.input.pointer.PointerIconKt$pointerHoverIcon$2$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        PointerIconModifierLocal pointerIconModifierLocal2 = PointerIconModifierLocal.this;
                        pointerIconModifierLocal2.getClass();
                        PointerIcon icon = pointerIcon;
                        Intrinsics.checkNotNullParameter(icon, "icon");
                        Function1<PointerIcon, Unit> onSetIcon = pointerIconKt$pointerHoverIcon$2$onSetIcon$1;
                        Intrinsics.checkNotNullParameter(onSetIcon, "onSetIcon");
                        if (!Intrinsics.areEqual(pointerIconModifierLocal2.icon, icon) && pointerIconModifierLocal2.isHovered && !pointerIconModifierLocal2.isPaused) {
                            onSetIcon.invoke(icon);
                        }
                        pointerIconModifierLocal2.icon = icon;
                        pointerIconModifierLocal2.overrideDescendants = z;
                        pointerIconModifierLocal2.onSetIcon = onSetIcon;
                        return Unit.INSTANCE;
                    }
                };
                composer2.updateRememberedValue(rememberedValue2);
            }
            composer2.endReplaceableGroup();
            EffectsKt.SideEffect((Function0) rememberedValue2, composer2);
            PointerIconModifierLocal parentInfo = pointerIconModifierLocal.getParentInfo();
            if (parentInfo == null || !parentInfo.hasOverride()) {
                z2 = true;
            }
            if (z2) {
                composer2.startReplaceableGroup(1157296644);
                boolean changed = composer2.changed(pointerIconModifierLocal);
                Object rememberedValue3 = composer2.rememberedValue();
                if (changed || rememberedValue3 == composer$Companion$Empty$1) {
                    rememberedValue3 = new PointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1(pointerIconModifierLocal, null);
                    composer2.updateRememberedValue(rememberedValue3);
                }
                composer2.endReplaceableGroup();
                modifier3 = SuspendingPointerInputFilterKt.pointerInput(modifier2, pointerIconModifierLocal, (Function2) rememberedValue3);
            }
            modifier3 = pointerIconModifierLocal.then(modifier3);
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
        composer2.endReplaceableGroup();
        return modifier3;
    }
}
