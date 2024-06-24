package aws.sdk.kotlin.services.cognitoidentityprovider.model;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: ForgotPasswordResponse.kt */
/* loaded from: classes.dex */
public final class ForgotPasswordResponse {
    public final CodeDeliveryDetailsType codeDeliveryDetails;

    /* compiled from: ForgotPasswordResponse.kt */
    /* loaded from: classes.dex */
    public static final class Builder {
        public CodeDeliveryDetailsType codeDeliveryDetails;
    }

    public ForgotPasswordResponse(Builder builder) {
        this.codeDeliveryDetails = builder.codeDeliveryDetails;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ForgotPasswordResponse.class == obj.getClass() && Intrinsics.areEqual(this.codeDeliveryDetails, ((ForgotPasswordResponse) obj).codeDeliveryDetails)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        CodeDeliveryDetailsType codeDeliveryDetailsType = this.codeDeliveryDetails;
        if (codeDeliveryDetailsType != null) {
            return codeDeliveryDetailsType.hashCode();
        }
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ForgotPasswordResponse(");
        sb.append("codeDeliveryDetails=" + this.codeDeliveryDetails);
        sb.append(")");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
