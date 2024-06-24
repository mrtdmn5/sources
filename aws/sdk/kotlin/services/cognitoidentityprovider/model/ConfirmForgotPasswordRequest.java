package aws.sdk.kotlin.services.cognitoidentityprovider.model;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConfirmForgotPasswordRequest.kt */
/* loaded from: classes.dex */
public final class ConfirmForgotPasswordRequest {
    public final AnalyticsMetadataType analyticsMetadata;
    public final String clientId;
    public final Map<String, String> clientMetadata;
    public final String confirmationCode;
    public final String password;
    public final String secretHash;
    public final UserContextDataType userContextData;
    public final String username;

    /* compiled from: ConfirmForgotPasswordRequest.kt */
    /* loaded from: classes.dex */
    public static final class Builder {
        public AnalyticsMetadataType analyticsMetadata;
        public String clientId;
        public Map<String, String> clientMetadata;
        public String confirmationCode;
        public String password;
        public String secretHash;
        public UserContextDataType userContextData;
        public String username;
    }

    public ConfirmForgotPasswordRequest(Builder builder) {
        this.analyticsMetadata = builder.analyticsMetadata;
        this.clientId = builder.clientId;
        this.clientMetadata = builder.clientMetadata;
        this.confirmationCode = builder.confirmationCode;
        this.password = builder.password;
        this.secretHash = builder.secretHash;
        this.userContextData = builder.userContextData;
        this.username = builder.username;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ConfirmForgotPasswordRequest.class != obj.getClass()) {
            return false;
        }
        ConfirmForgotPasswordRequest confirmForgotPasswordRequest = (ConfirmForgotPasswordRequest) obj;
        if (Intrinsics.areEqual(this.analyticsMetadata, confirmForgotPasswordRequest.analyticsMetadata) && Intrinsics.areEqual(this.clientId, confirmForgotPasswordRequest.clientId) && Intrinsics.areEqual(this.clientMetadata, confirmForgotPasswordRequest.clientMetadata) && Intrinsics.areEqual(this.confirmationCode, confirmForgotPasswordRequest.confirmationCode) && Intrinsics.areEqual(this.password, confirmForgotPasswordRequest.password) && Intrinsics.areEqual(this.secretHash, confirmForgotPasswordRequest.secretHash) && Intrinsics.areEqual(this.userContextData, confirmForgotPasswordRequest.userContextData) && Intrinsics.areEqual(this.username, confirmForgotPasswordRequest.username)) {
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
        String str2 = this.confirmationCode;
        if (str2 != null) {
            r23 = str2.hashCode();
        } else {
            r23 = 0;
        }
        int r15 = (r14 + r23) * 31;
        String str3 = this.password;
        if (str3 != null) {
            r24 = str3.hashCode();
        } else {
            r24 = 0;
        }
        int r16 = (r15 + r24) * 31;
        String str4 = this.secretHash;
        if (str4 != null) {
            r25 = str4.hashCode();
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
        String str5 = this.username;
        if (str5 != null) {
            r0 = str5.hashCode();
        }
        return r18 + r0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ConfirmForgotPasswordRequest(");
        sb.append("analyticsMetadata=" + this.analyticsMetadata + ',');
        sb.append("clientId=*** Sensitive Data Redacted ***,");
        sb.append("clientMetadata=" + this.clientMetadata + ',');
        sb.append("confirmationCode=" + this.confirmationCode + ',');
        sb.append("password=*** Sensitive Data Redacted ***,secretHash=*** Sensitive Data Redacted ***,");
        sb.append("userContextData=" + this.userContextData + ',');
        sb.append("username=*** Sensitive Data Redacted ***)");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
