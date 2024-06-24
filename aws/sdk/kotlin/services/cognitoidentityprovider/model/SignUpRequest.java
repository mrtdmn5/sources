package aws.sdk.kotlin.services.cognitoidentityprovider.model;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SignUpRequest.kt */
/* loaded from: classes.dex */
public final class SignUpRequest {
    public final AnalyticsMetadataType analyticsMetadata;
    public final String clientId;
    public final Map<String, String> clientMetadata;
    public final String password;
    public final String secretHash;
    public final List<AttributeType> userAttributes;
    public final UserContextDataType userContextData;
    public final String username;
    public final List<AttributeType> validationData;

    /* compiled from: SignUpRequest.kt */
    /* loaded from: classes.dex */
    public static final class Builder {
        public AnalyticsMetadataType analyticsMetadata;
        public String clientId;
        public Map<String, String> clientMetadata;
        public String password;
        public String secretHash;
        public List<AttributeType> userAttributes;
        public UserContextDataType userContextData;
        public String username;
        public List<AttributeType> validationData;
    }

    public SignUpRequest(Builder builder) {
        this.analyticsMetadata = builder.analyticsMetadata;
        this.clientId = builder.clientId;
        this.clientMetadata = builder.clientMetadata;
        this.password = builder.password;
        this.secretHash = builder.secretHash;
        this.userAttributes = builder.userAttributes;
        this.userContextData = builder.userContextData;
        this.username = builder.username;
        this.validationData = builder.validationData;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SignUpRequest.class != obj.getClass()) {
            return false;
        }
        SignUpRequest signUpRequest = (SignUpRequest) obj;
        if (Intrinsics.areEqual(this.analyticsMetadata, signUpRequest.analyticsMetadata) && Intrinsics.areEqual(this.clientId, signUpRequest.clientId) && Intrinsics.areEqual(this.clientMetadata, signUpRequest.clientMetadata) && Intrinsics.areEqual(this.password, signUpRequest.password) && Intrinsics.areEqual(this.secretHash, signUpRequest.secretHash) && Intrinsics.areEqual(this.userAttributes, signUpRequest.userAttributes) && Intrinsics.areEqual(this.userContextData, signUpRequest.userContextData) && Intrinsics.areEqual(this.username, signUpRequest.username) && Intrinsics.areEqual(this.validationData, signUpRequest.validationData)) {
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
        int r25;
        int r26;
        int r27;
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
        String str2 = this.password;
        if (str2 != null) {
            r23 = str2.hashCode();
        } else {
            r23 = 0;
        }
        int r15 = (r14 + r23) * 31;
        String str3 = this.secretHash;
        if (str3 != null) {
            r24 = str3.hashCode();
        } else {
            r24 = 0;
        }
        int r16 = (r15 + r24) * 31;
        List<AttributeType> list = this.userAttributes;
        if (list != null) {
            r25 = list.hashCode();
        } else {
            r25 = 0;
        }
        int r17 = (r16 + r25) * 31;
        UserContextDataType userContextDataType = this.userContextData;
        if (userContextDataType != null) {
            r26 = userContextDataType.hashCode();
        } else {
            r26 = 0;
        }
        int r18 = (r17 + r26) * 31;
        String str4 = this.username;
        if (str4 != null) {
            r27 = str4.hashCode();
        } else {
            r27 = 0;
        }
        int r19 = (r18 + r27) * 31;
        List<AttributeType> list2 = this.validationData;
        if (list2 != null) {
            r0 = list2.hashCode();
        }
        return r19 + r0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SignUpRequest(");
        sb.append("analyticsMetadata=" + this.analyticsMetadata + ',');
        sb.append("clientId=*** Sensitive Data Redacted ***,");
        sb.append("clientMetadata=" + this.clientMetadata + ',');
        sb.append("password=*** Sensitive Data Redacted ***,secretHash=*** Sensitive Data Redacted ***,");
        sb.append("userAttributes=" + this.userAttributes + ',');
        sb.append("userContextData=" + this.userContextData + ',');
        sb.append("username=*** Sensitive Data Redacted ***,");
        sb.append("validationData=" + this.validationData);
        sb.append(")");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
