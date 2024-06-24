package androidx.compose.ui.platform;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: InspectableValue.kt */
/* loaded from: classes.dex */
public final class ValueElement {
    public final String name;
    public final Object value;

    public ValueElement(String str, Object obj) {
        this.name = str;
        this.value = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ValueElement)) {
            return false;
        }
        ValueElement valueElement = (ValueElement) obj;
        if (Intrinsics.areEqual(this.name, valueElement.name) && Intrinsics.areEqual(this.value, valueElement.value)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2 = this.name.hashCode() * 31;
        Object obj = this.value;
        if (obj == null) {
            hashCode = 0;
        } else {
            hashCode = obj.hashCode();
        }
        return hashCode2 + hashCode;
    }

    public final String toString() {
        return "ValueElement(name=" + this.name + ", value=" + this.value + ')';
    }
}
