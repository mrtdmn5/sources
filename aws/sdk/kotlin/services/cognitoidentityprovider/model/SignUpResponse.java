package aws.sdk.kotlin.services.cognitoidentityprovider.model;

import aws.sdk.kotlin.services.cognitoidentity.model.Credentials$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* compiled from: SignUpResponse.kt */
/* loaded from: classes.dex */
public final class SignUpResponse {
    public final CodeDeliveryDetailsType codeDeliveryDetails;
    public final boolean userConfirmed;
    public final String userSub;

    /* compiled from: SignUpResponse.kt */
    /* loaded from: classes.dex */
    public static final class Builder {
        public CodeDeliveryDetailsType codeDeliveryDetails;
        public boolean userConfirmed;
        public String userSub;
    }

    public SignUpResponse(Builder builder) {
        this.codeDeliveryDetails = builder.codeDeliveryDetails;
        this.userConfirmed = builder.userConfirmed;
        this.userSub = builder.userSub;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SignUpResponse.class != obj.getClass()) {
            return false;
        }
        SignUpResponse signUpResponse = (SignUpResponse) obj;
        if (Intrinsics.areEqual(this.codeDeliveryDetails, signUpResponse.codeDeliveryDetails) && this.userConfirmed == signUpResponse.userConfirmed && Intrinsics.areEqual(this.userSub, signUpResponse.userSub)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int r1;
        int r0 = 0;
        CodeDeliveryDetailsType codeDeliveryDetailsType = this.codeDeliveryDetails;
        if (codeDeliveryDetailsType != null) {
            r1 = codeDeliveryDetailsType.hashCode();
        } else {
            r1 = 0;
        }
        int m = JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.userConfirmed, r1 * 31, 31);
        String str = this.userSub;
        if (str != null) {
            r0 = str.hashCode();
        }
        return m + r0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SignUpResponse(");
        sb.append("codeDeliveryDetails=" + this.codeDeliveryDetails + ',');
        sb.append("userConfirmed=" + this.userConfirmed + ',');
        return Credentials$$ExternalSyntheticOutline0.m(new StringBuilder("userSub="), this.userSub, sb, ")", "StringBuilder().apply(builderAction).toString()");
    }
}
