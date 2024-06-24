package androidx.compose.ui.semantics;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: SemanticsProperties.kt */
/* loaded from: classes.dex */
public final class CustomAccessibilityAction {
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomAccessibilityAction)) {
            return false;
        }
        CustomAccessibilityAction customAccessibilityAction = (CustomAccessibilityAction) obj;
        customAccessibilityAction.getClass();
        if (!Intrinsics.areEqual((Object) null, (Object) null)) {
            return false;
        }
        customAccessibilityAction.getClass();
        if (Intrinsics.areEqual((Object) null, (Object) null)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return "CustomAccessibilityAction(label=null, action=null)";
    }
}
