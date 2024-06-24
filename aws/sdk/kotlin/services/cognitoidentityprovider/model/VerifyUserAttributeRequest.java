package aws.sdk.kotlin.services.cognitoidentityprovider.model;

import aws.sdk.kotlin.services.cognitoidentity.endpoints.EndpointParameters$$ExternalSyntheticOutline0;
import aws.sdk.kotlin.services.cognitoidentity.model.Credentials$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VerifyUserAttributeRequest.kt */
/* loaded from: classes.dex */
public final class VerifyUserAttributeRequest {
    public final String accessToken;
    public final String attributeName;
    public final String code;

    /* compiled from: VerifyUserAttributeRequest.kt */
    /* loaded from: classes.dex */
    public static final class Builder {
        public String accessToken;
        public String attributeName;
        public String code;
    }

    public VerifyUserAttributeRequest(Builder builder) {
        this.accessToken = builder.accessToken;
        this.attributeName = builder.attributeName;
        this.code = builder.code;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || VerifyUserAttributeRequest.class != obj.getClass()) {
            return false;
        }
        VerifyUserAttributeRequest verifyUserAttributeRequest = (VerifyUserAttributeRequest) obj;
        if (Intrinsics.areEqual(this.accessToken, verifyUserAttributeRequest.accessToken) && Intrinsics.areEqual(this.attributeName, verifyUserAttributeRequest.attributeName) && Intrinsics.areEqual(this.code, verifyUserAttributeRequest.code)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int r1;
        int r2;
        int r0 = 0;
        String str = this.accessToken;
        if (str != null) {
            r1 = str.hashCode();
        } else {
            r1 = 0;
        }
        int r12 = r1 * 31;
        String str2 = this.attributeName;
        if (str2 != null) {
            r2 = str2.hashCode();
        } else {
            r2 = 0;
        }
        int r13 = (r12 + r2) * 31;
        String str3 = this.code;
        if (str3 != null) {
            r0 = str3.hashCode();
        }
        return r13 + r0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("VerifyUserAttributeRequest(accessToken=*** Sensitive Data Redacted ***,");
        return Credentials$$ExternalSyntheticOutline0.m(EndpointParameters$$ExternalSyntheticOutline0.m(new StringBuilder("attributeName="), this.attributeName, ',', sb, "code="), this.code, sb, ")", "StringBuilder().apply(builderAction).toString()");
    }
}
