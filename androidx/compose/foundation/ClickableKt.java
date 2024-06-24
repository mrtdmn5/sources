package androidx.compose.foundation;

import androidx.compose.animation.EnterExitTransitionKt$shrinkExpand$1$$ExternalSyntheticOutline0;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableModifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectableValueKt$NoInspectorInfo$1;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ValueElementSequence;
import androidx.compose.ui.semantics.Role;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Clickable.kt */
/* loaded from: classes.dex */
public final class ClickableKt {
    /* renamed from: clickable-O2vRcR0 */
    public static final Modifier m24clickableO2vRcR0(Modifier clickable, final MutableInteractionSource interactionSource, Indication indication, final boolean z, String str, Role role, Function0<Unit> onClick) {
        Intrinsics.checkNotNullParameter(clickable, "$this$clickable");
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        InspectableValueKt$NoInspectorInfo$1 inspectableValueKt$NoInspectorInfo$1 = InspectableValueKt.NoInspectorInfo;
        Modifier hoverable = HoverableKt.hoverable(interactionSource, IndicationKt.indication(Modifier.Companion.$$INSTANCE, interactionSource, indication), z);
        InspectableModifier inspectableModifier = FocusableKt.focusGroupInspectorInfo;
        Intrinsics.checkNotNullParameter(hoverable, "<this>");
        Function1<InspectorInfo, Unit> function1 = new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.FocusableKt$focusableInNonTouchMode$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(InspectorInfo inspectorInfo) {
                InspectorInfo inspectable = inspectorInfo;
                Intrinsics.checkNotNullParameter(inspectable, "$this$inspectable");
                Boolean valueOf = Boolean.valueOf(z);
                ValueElementSequence valueElementSequence = inspectable.properties;
                valueElementSequence.set(valueOf, "enabled");
                valueElementSequence.set(interactionSource, "interactionSource");
                return Unit.INSTANCE;
            }
        };
        FocusableKt$FocusableInNonTouchModeElement$1 other = FocusableKt.FocusableInNonTouchModeElement;
        Intrinsics.checkNotNullParameter(other, "other");
        return InspectableValueKt.inspectableWrapper(clickable, inspectableValueKt$NoInspectorInfo$1, InspectableValueKt.inspectableWrapper(hoverable, function1, FocusableKt.focusable(interactionSource, other, z)).then(new ClickableElement(interactionSource, z, str, role, onClick)));
    }

    /* renamed from: clickable-O2vRcR0$default */
    public static /* synthetic */ Modifier m25clickableO2vRcR0$default(Modifier modifier, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z, Role role, Function0 function0, int r13) {
        if ((r13 & 4) != 0) {
            z = true;
        }
        boolean z2 = z;
        if ((r13 & 16) != 0) {
            role = null;
        }
        return m24clickableO2vRcR0(modifier, mutableInteractionSource, indication, z2, null, role, function0);
    }

    /* renamed from: clickable-XHw0xAI$default */
    public static Modifier m26clickableXHw0xAI$default(Modifier clickable, final Function0 onClick) {
        Intrinsics.checkNotNullParameter(clickable, "$this$clickable");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        InspectableValueKt$NoInspectorInfo$1 inspectableValueKt$NoInspectorInfo$1 = InspectableValueKt.NoInspectorInfo;
        final boolean z = true;
        final String str = null;
        final byte b = 0 == true ? 1 : 0;
        return ComposedModifierKt.composed(clickable, inspectableValueKt$NoInspectorInfo$1, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.ClickableKt$clickable$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                Composer composer2 = composer;
                EnterExitTransitionKt$shrinkExpand$1$$ExternalSyntheticOutline0.m(num, modifier, "$this$composed", composer2, -756081143);
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                Indication indication = (Indication) composer2.consume(IndicationKt.LocalIndication);
                composer2.startReplaceableGroup(-492369756);
                Object rememberedValue = composer2.rememberedValue();
                if (rememberedValue == Composer.Companion.Empty) {
                    rememberedValue = new MutableInteractionSourceImpl();
                    composer2.updateRememberedValue(rememberedValue);
                }
                composer2.endReplaceableGroup();
                Modifier m24clickableO2vRcR0 = ClickableKt.m24clickableO2vRcR0(companion, (MutableInteractionSource) rememberedValue, indication, z, str, b, onClick);
                composer2.endReplaceableGroup();
                return m24clickableO2vRcR0;
            }
        });
    }
}
