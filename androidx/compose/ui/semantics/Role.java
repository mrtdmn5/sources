package androidx.compose.ui.semantics;

/* compiled from: SemanticsProperties.kt */
/* loaded from: classes.dex */
public final class Role {
    public final int value;

    public final boolean equals(Object obj) {
        if (!(obj instanceof Role)) {
            return false;
        }
        if (this.value != ((Role) obj).value) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Integer.hashCode(this.value);
    }

    public final String toString() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int r0 = this.value;
        boolean z7 = false;
        if (r0 == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return "Button";
        }
        if (r0 == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return "Checkbox";
        }
        if (r0 == 2) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            return "Switch";
        }
        if (r0 == 3) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            return "RadioButton";
        }
        if (r0 == 4) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            return "Tab";
        }
        if (r0 == 5) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z6) {
            return "Image";
        }
        if (r0 == 6) {
            z7 = true;
        }
        if (z7) {
            return "DropdownList";
        }
        return "Unknown";
    }
}
