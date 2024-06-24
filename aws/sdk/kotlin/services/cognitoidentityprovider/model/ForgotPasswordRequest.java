package aws.sdk.kotlin.services.cognitoidentityprovider.model;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ForgotPasswordRequest.kt */
/* loaded from: classes.dex */
public final class ForgotPasswordRequest {
    public final AnalyticsMetadataType analyticsMetadata;
    public final String clientId;
    public final Map<String, String> clientMetadata;
    public final String secretHash;
    public final UserContextDataType userContextData;
    public final String username;

    /* compiled from: ForgotPasswordRequest.kt */
    /* loaded from: classes.dex */
    public static final class Builder {
        public AnalyticsMetadataType analyticsMetadata;
        public String clientId;
        public Map<String, String> clientMetadata;
        public String secretHash;
        public UserContextDataType userContextData;
        public String username;
    }

    public ForgotPasswordRequest(Builder builder) {
        this.analyticsMetadata = builder.analyticsMetadata;
        this.clientId = builder.clientId;
        this.clientMetadata = builder.clientMetadata;
        this.secretHash = builder.secretHash;
        this.userContextData = builder.userContextData;
        this.username = builder.username;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ForgotPasswordRequest.class != obj.getClass()) {
            return false;
        }
        ForgotPasswordRequest forgotPasswordRequest = (ForgotPasswordRequest) obj;
        if (Intrinsics.areEqual(this.analyticsMetadata, forgotPasswordRequest.analyticsMetadata) && Intrinsics.areEqual(this.clientId, forgotPasswordRequest.clientId) && Intrinsics.areEqual(this.clientMetadata, forgotPasswordRequest.clientMetadata) && Intrinsics.areEqual(this.secretHash, forgotPasswordRequest.secretHash) && Intrinsics.areEqual(this.userContextData, forgotPasswordRequest.userContextData) && Intrinsics.areEqual(this.username, forgotPasswordRequest.username)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int r1;
        int r2;
        int r22;
        int r23;
        int r24;
        int r0 = 0;
        AnalyticsMetadataType analyticsMetadataType = this.analyticsMetadata;
        if (analyticsMetadataType != null) {
            r1 = analyticsMetadataType.hashCode();
        } else {
            r1 = 0;
        }
        int r12 = r1 * 31;
        String str = this.clientId;
        if (str != null) {
            r2 = str.hashCode();
        } else {
            r2 = 0;
        }
        int r13 = (r12 + r2) * 31;
        Map<String, String> map = this.clientMetadata;
        if (map != null) {
            r22 = map.hashCode();
        } else {
            r22 = 0;
        }
        int r14 = (r13 + r22) * 31;
        String str2 = this.secretHash;
        if (str2 != null) {
            r23 = str2.hashCode();
        } else {
            r23 = 0;
        }
        int r15 = (r14 + r23) * 31;
        UserContextDataType userContextDataType = this.userContextData;
        if (userContextDataType != null) {
            r24 = userContextDataType.hashCode();
        } else {
            r24 = 0;
        }
        int r16 = (r15 + r24) * 31;
        String str3 = this.username;
        if (str3 != null) {
            r0 = str3.hashCode();
        }
        return r16 + r0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ForgotPasswordRequest(");
        sb.append("analyticsMetadata=" + this.analyticsMetadata + ',');
        sb.append("clientId=*** Sensitive Data Redacted ***,");
        sb.append("clientMetadata=" + this.clientMetadata + ',');
        sb.append("secretHash=*** Sensitive Data Redacted ***,");
        sb.append("userContextData=" + this.userContextData + ',');
        sb.append("username=*** Sensitive Data Redacted ***)");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
