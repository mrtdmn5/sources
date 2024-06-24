package aws.sdk.kotlin.services.cognitoidentityprovider.model;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: AttributeType.kt */
/* loaded from: classes.dex */
public final class AttributeType {
    public final String name;
    public final String value;

    /* compiled from: AttributeType.kt */
    /* loaded from: classes.dex */
    public static final class Builder {
        public String name;
        public String value;
    }

    public AttributeType(Builder builder) {
        this.name = builder.name;
        this.value = builder.value;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AttributeType.class != obj.getClass()) {
            return false;
        }
        AttributeType attributeType = (AttributeType) obj;
        if (Intrinsics.areEqual(this.name, attributeType.name) && Intrinsics.areEqual(this.value, attributeType.value)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int r1;
        int r0 = 0;
        String str = this.name;
        if (str != null) {
            r1 = str.hashCode();
        } else {
            r1 = 0;
        }
        int r12 = r1 * 31;
        String str2 = this.value;
        if (str2 != null) {
            r0 = str2.hashCode();
        }
        return r12 + r0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AttributeType(");
        sb.append("name=" + this.name + ',');
        sb.append("value=*** Sensitive Data Redacted ***)");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
