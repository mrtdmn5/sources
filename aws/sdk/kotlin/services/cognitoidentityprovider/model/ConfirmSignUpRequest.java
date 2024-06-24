package aws.sdk.kotlin.services.cognitoidentityprovider.model;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* compiled from: ConfirmSignUpRequest.kt */
/* loaded from: classes.dex */
public final class ConfirmSignUpRequest {
    public final AnalyticsMetadataType analyticsMetadata;
    public final String clientId;
    public final Map<String, String> clientMetadata;
    public final String confirmationCode;
    public final String secretHash;
    public final UserContextDataType userContextData;
    public final String username;

    /* compiled from: ConfirmSignUpRequest.kt */
    /* loaded from: classes.dex */
    public static final class Builder {
        public AnalyticsMetadataType analyticsMetadata;
        public String clientId;
        public Map<String, String> clientMetadata;
        public String confirmationCode;
        public String secretHash;
        public UserContextDataType userContextData;
        public String username;
    }

    public ConfirmSignUpRequest(Builder builder) {
        this.analyticsMetadata = builder.analyticsMetadata;
        this.clientId = builder.clientId;
        this.clientMetadata = builder.clientMetadata;
        this.confirmationCode = builder.confirmationCode;
        this.secretHash = builder.secretHash;
        this.userContextData = builder.userContextData;
        this.username = builder.username;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ConfirmSignUpRequest.class != obj.getClass()) {
            return false;
        }
        ConfirmSignUpRequest confirmSignUpRequest = (ConfirmSignUpRequest) obj;
        if (Intrinsics.areEqual(this.analyticsMetadata, confirmSignUpRequest.analyticsMetadata) && Intrinsics.areEqual(this.clientId, confirmSignUpRequest.clientId) && Intrinsics.areEqual(this.clientMetadata, confirmSignUpRequest.clientMetadata) && Intrinsics.areEqual(this.confirmationCode, confirmSignUpRequest.confirmationCode) && Intrinsics.areEqual(this.secretHash, confirmSignUpRequest.secretHash) && Intrinsics.areEqual(this.userContextData, confirmSignUpRequest.userContextData) && Intrinsics.areEqual(this.username, confirmSignUpRequest.username)) {
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
        int m = JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(false, (r14 + r23) * 31, 31);
        String str3 = this.secretHash;
        if (str3 != null) {
            r24 = str3.hashCode();
        } else {
            r24 = 0;
        }
        int r15 = (m + r24) * 31;
        UserContextDataType userContextDataType = this.userContextData;
        if (userContextDataType != null) {
            r25 = userContextDataType.hashCode();
        } else {
            r25 = 0;
        }
        int r16 = (r15 + r25) * 31;
        String str4 = this.username;
        if (str4 != null) {
            r0 = str4.hashCode();
        }
        return r16 + r0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ConfirmSignUpRequest(");
        sb.append("analyticsMetadata=" + this.analyticsMetadata + ',');
        sb.append("clientId=*** Sensitive Data Redacted ***,");
        sb.append("clientMetadata=" + this.clientMetadata + ',');
        sb.append("confirmationCode=" + this.confirmationCode + ',');
        sb.append("forceAliasCreation=false,secretHash=*** Sensitive Data Redacted ***,");
        sb.append("userContextData=" + this.userContextData + ',');
        sb.append("username=*** Sensitive Data Redacted ***)");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
