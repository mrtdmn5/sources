package aws.sdk.kotlin.services.cognitoidentityprovider.model;

import aws.sdk.kotlin.services.cognitoidentity.endpoints.EndpointParameters$$ExternalSyntheticOutline0;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetUserAttributeVerificationCodeRequest.kt */
/* loaded from: classes.dex */
public final class GetUserAttributeVerificationCodeRequest {
    public final String accessToken;
    public final String attributeName;
    public final Map<String, String> clientMetadata;

    /* compiled from: GetUserAttributeVerificationCodeRequest.kt */
    /* loaded from: classes.dex */
    public static final class Builder {
        public String accessToken;
        public String attributeName;
        public Map<String, String> clientMetadata;
    }

    public GetUserAttributeVerificationCodeRequest(Builder builder) {
        this.accessToken = builder.accessToken;
        this.attributeName = builder.attributeName;
        this.clientMetadata = builder.clientMetadata;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || GetUserAttributeVerificationCodeRequest.class != obj.getClass()) {
            return false;
        }
        GetUserAttributeVerificationCodeRequest getUserAttributeVerificationCodeRequest = (GetUserAttributeVerificationCodeRequest) obj;
        if (Intrinsics.areEqual(this.accessToken, getUserAttributeVerificationCodeRequest.accessToken) && Intrinsics.areEqual(this.attributeName, getUserAttributeVerificationCodeRequest.attributeName) && Intrinsics.areEqual(this.clientMetadata, getUserAttributeVerificationCodeRequest.clientMetadata)) {
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
        Map<String, String> map = this.clientMetadata;
        if (map != null) {
            r0 = map.hashCode();
        }
        return r13 + r0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("GetUserAttributeVerificationCodeRequest(accessToken=*** Sensitive Data Redacted ***,");
        StringBuilder m = EndpointParameters$$ExternalSyntheticOutline0.m(new StringBuilder("attributeName="), this.attributeName, ',', sb, "clientMetadata=");
        m.append(this.clientMetadata);
        sb.append(m.toString());
        sb.append(")");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
