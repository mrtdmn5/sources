package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectableModifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Focusable.kt */
/* loaded from: classes.dex */
public final class FocusableKt {
    public static final InspectableModifier focusGroupInspectorInfo = new InspectableModifier(InspectableValueKt.NoInspectorInfo);
    public static final FocusableKt$FocusableInNonTouchModeElement$1 FocusableInNonTouchModeElement = new ModifierNodeElement<FocusableInNonTouchMode>() { // from class: androidx.compose.foundation.FocusableKt$FocusableInNonTouchModeElement$1
        @Override // androidx.compose.ui.node.ModifierNodeElement
        public final FocusableInNonTouchMode create() {
            return new FocusableInNonTouchMode();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return false;
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public final int hashCode() {
            return System.identityHashCode(this);
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public final void update(FocusableInNonTouchMode focusableInNonTouchMode) {
            FocusableInNonTouchMode node = focusableInNonTouchMode;
            Intrinsics.checkNotNullParameter(node, "node");
        }
    };

    public static final Modifier focusable(MutableInteractionSource mutableInteractionSource, Modifier modifier, boolean z) {
        Modifier modifier2;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        if (z) {
            modifier2 = new FocusableElement(mutableInteractionSource).then(FocusTargetNode.FocusTargetElement.INSTANCE);
        } else {
            modifier2 = Modifier.Companion.$$INSTANCE;
        }
        return modifier.then(modifier2);
    }
}
