package aws.sdk.kotlin.services.cognitoidentityprovider.model;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserContextDataType.kt */
/* loaded from: classes.dex */
public final class UserContextDataType {
    public final String encodedData;

    /* compiled from: UserContextDataType.kt */
    /* loaded from: classes.dex */
    public static final class Builder {
        public String encodedData;
    }

    public UserContextDataType(Builder builder) {
        this.encodedData = builder.encodedData;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && UserContextDataType.class == obj.getClass() && Intrinsics.areEqual(this.encodedData, ((UserContextDataType) obj).encodedData) && Intrinsics.areEqual((Object) null, (Object) null)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int r1;
        String str = this.encodedData;
        if (str != null) {
            r1 = str.hashCode();
        } else {
            r1 = 0;
        }
        return (r1 * 31) + 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("UserContextDataType(");
        sb.append("encodedData=" + this.encodedData + ',');
        sb.append("ipAddress=null)");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
