package aws.sdk.kotlin.services.cognitoidentityprovider.model;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConfirmDeviceResponse.kt */
/* loaded from: classes.dex */
public final class ConfirmDeviceResponse {
    public final boolean userConfirmationNecessary;

    /* compiled from: ConfirmDeviceResponse.kt */
    /* loaded from: classes.dex */
    public static final class Builder {
        public boolean userConfirmationNecessary;
    }

    public ConfirmDeviceResponse(Builder builder) {
        this.userConfirmationNecessary = builder.userConfirmationNecessary;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ConfirmDeviceResponse.class == obj.getClass() && this.userConfirmationNecessary == ((ConfirmDeviceResponse) obj).userConfirmationNecessary) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.userConfirmationNecessary);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ConfirmDeviceResponse(");
        sb.append("userConfirmationNecessary=" + this.userConfirmationNecessary);
        sb.append(")");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
