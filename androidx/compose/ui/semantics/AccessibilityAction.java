package androidx.compose.ui.semantics;

import kotlin.Function;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SemanticsProperties.kt */
/* loaded from: classes.dex */
public final class AccessibilityAction<T extends Function<? extends Boolean>> {
    public final T action;
    public final String label;

    public AccessibilityAction(String str, T t) {
        this.label = str;
        this.action = t;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccessibilityAction)) {
            return false;
        }
        AccessibilityAction accessibilityAction = (AccessibilityAction) obj;
        if (Intrinsics.areEqual(this.label, accessibilityAction.label) && Intrinsics.areEqual(this.action, accessibilityAction.action)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int r1;
        int r0 = 0;
        String str = this.label;
        if (str != null) {
            r1 = str.hashCode();
        } else {
            r1 = 0;
        }
        int r12 = r1 * 31;
        T t = this.action;
        if (t != null) {
            r0 = t.hashCode();
        }
        return r12 + r0;
    }

    public final String toString() {
        return "AccessibilityAction(label=" + this.label + ", action=" + this.action + ')';
    }
}
