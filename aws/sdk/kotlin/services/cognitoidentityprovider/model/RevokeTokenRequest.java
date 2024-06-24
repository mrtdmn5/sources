package aws.sdk.kotlin.services.cognitoidentityprovider.model;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: RevokeTokenRequest.kt */
/* loaded from: classes.dex */
public final class RevokeTokenRequest {
    public final String clientId;
    public final String clientSecret;
    public final String token;

    /* compiled from: RevokeTokenRequest.kt */
    /* loaded from: classes.dex */
    public static final class Builder {
        public String clientId;
        public String clientSecret;
        public String token;
    }

    public RevokeTokenRequest(Builder builder) {
        this.clientId = builder.clientId;
        this.clientSecret = builder.clientSecret;
        this.token = builder.token;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || RevokeTokenRequest.class != obj.getClass()) {
            return false;
        }
        RevokeTokenRequest revokeTokenRequest = (RevokeTokenRequest) obj;
        if (Intrinsics.areEqual(this.clientId, revokeTokenRequest.clientId) && Intrinsics.areEqual(this.clientSecret, revokeTokenRequest.clientSecret) && Intrinsics.areEqual(this.token, revokeTokenRequest.token)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int r1;
        int r2;
        int r0 = 0;
        String str = this.clientId;
        if (str != null) {
            r1 = str.hashCode();
        } else {
            r1 = 0;
        }
        int r12 = r1 * 31;
        String str2 = this.clientSecret;
        if (str2 != null) {
            r2 = str2.hashCode();
        } else {
            r2 = 0;
        }
        int r13 = (r12 + r2) * 31;
        String str3 = this.token;
        if (str3 != null) {
            r0 = str3.hashCode();
        }
        return r13 + r0;
    }

    public final String toString() {
        return "RevokeTokenRequest(clientId=*** Sensitive Data Redacted ***,clientSecret=*** Sensitive Data Redacted ***,token=*** Sensitive Data Redacted ***)";
    }
}
