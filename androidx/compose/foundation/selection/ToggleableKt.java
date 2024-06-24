package androidx.compose.foundation.selection;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectableValueKt$NoInspectorInfo$1;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.state.ToggleableState;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* compiled from: Toggleable.kt */
/* loaded from: classes.dex */
public final class ToggleableKt {
    /* renamed from: toggleable-O2vRcR0, reason: not valid java name */
    public static final Modifier m108toggleableO2vRcR0(final boolean z, MutableInteractionSource interactionSource, Indication indication, boolean z2, Role role, final Function1 onValueChange) {
        ToggleableState toggleableState;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        InspectableValueKt$NoInspectorInfo$1 inspectableValueKt$NoInspectorInfo$1 = InspectableValueKt.NoInspectorInfo;
        if (z) {
            toggleableState = ToggleableState.On;
        } else {
            toggleableState = ToggleableState.Off;
        }
        return InspectableValueKt.inspectableWrapper(companion, inspectableValueKt$NoInspectorInfo$1, m109triStateToggleableO2vRcR0(toggleableState, interactionSource, indication, z2, role, new Function0<Unit>() { // from class: androidx.compose.foundation.selection.ToggleableKt$toggleable$4$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                onValueChange.invoke(Boolean.valueOf(!z));
                return Unit.INSTANCE;
            }
        }));
    }

    /* renamed from: triStateToggleable-O2vRcR0, reason: not valid java name */
    public static final Modifier m109triStateToggleableO2vRcR0(final ToggleableState state, MutableInteractionSource interactionSource, Indication indication, boolean z, Role role, Function0 onClick) {
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        return InspectableValueKt.inspectableWrapper(companion, InspectableValueKt.NoInspectorInfo, SemanticsModifierKt.semantics(ClickableKt.m25clickableO2vRcR0$default(companion, interactionSource, indication, z, role, onClick, 8), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.selection.ToggleableKt$triStateToggleable$4$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                SemanticsPropertyReceiver semantics = semanticsPropertyReceiver;
                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                KProperty<Object>[] kPropertyArr = SemanticsPropertiesKt.$$delegatedProperties;
                ToggleableState toggleableState = ToggleableState.this;
                Intrinsics.checkNotNullParameter(toggleableState, "<set-?>");
                SemanticsProperties.ToggleableState.setValue(semantics, SemanticsPropertiesKt.$$delegatedProperties[18], toggleableState);
                return Unit.INSTANCE;
            }
        }));
    }
}
