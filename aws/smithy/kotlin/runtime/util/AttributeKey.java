package aws.smithy.kotlin.runtime.util;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: Attributes.kt */
/* loaded from: classes.dex */
public final class AttributeKey<T> {
    public final String name;

    public AttributeKey(String str) {
        this.name = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof AttributeKey) && Intrinsics.areEqual(this.name, ((AttributeKey) obj).name)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.name.hashCode();
    }

    public final String toString() {
        String str = this.name;
        if (StringsKt__StringsJVMKt.isBlank(str)) {
            return super.toString();
        }
        return "ExecutionAttributeKey: " + str;
    }
}
