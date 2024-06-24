package aws.sdk.kotlin.services.cognitoidentityprovider.model;

import aws.sdk.kotlin.services.cognitoidentity.model.Credentials$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthenticationResultType.kt */
/* loaded from: classes.dex */
public final class AuthenticationResultType {
    public final String accessToken;
    public final int expiresIn;
    public final String idToken;
    public final NewDeviceMetadataType newDeviceMetadata;
    public final String refreshToken;
    public final String tokenType;

    /* compiled from: AuthenticationResultType.kt */
    /* loaded from: classes.dex */
    public static final class Builder {
        public String accessToken;
        public int expiresIn;
        public String idToken;
        public NewDeviceMetadataType newDeviceMetadata;
        public String refreshToken;
        public String tokenType;
    }

    public AuthenticationResultType(Builder builder) {
        this.accessToken = builder.accessToken;
        this.expiresIn = builder.expiresIn;
        this.idToken = builder.idToken;
        this.newDeviceMetadata = builder.newDeviceMetadata;
        this.refreshToken = builder.refreshToken;
        this.tokenType = builder.tokenType;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AuthenticationResultType.class != obj.getClass()) {
            return false;
        }
        AuthenticationResultType authenticationResultType = (AuthenticationResultType) obj;
        if (Intrinsics.areEqual(this.accessToken, authenticationResultType.accessToken) && this.expiresIn == authenticationResultType.expiresIn && Intrinsics.areEqual(this.idToken, authenticationResultType.idToken) && Intrinsics.areEqual(this.newDeviceMetadata, authenticationResultType.newDeviceMetadata) && Intrinsics.areEqual(this.refreshToken, authenticationResultType.refreshToken) && Intrinsics.areEqual(this.tokenType, authenticationResultType.tokenType)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int r1;
        int r2;
        int r22;
        int r23;
        int r0 = 0;
        String str = this.accessToken;
        if (str != null) {
            r1 = str.hashCode();
        } else {
            r1 = 0;
        }
        int r12 = ((r1 * 31) + this.expiresIn) * 31;
        String str2 = this.idToken;
        if (str2 != null) {
            r2 = str2.hashCode();
        } else {
            r2 = 0;
        }
        int r13 = (r12 + r2) * 31;
        NewDeviceMetadataType newDeviceMetadataType = this.newDeviceMetadata;
        if (newDeviceMetadataType != null) {
            r22 = newDeviceMetadataType.hashCode();
        } else {
            r22 = 0;
        }
        int r14 = (r13 + r22) * 31;
        String str3 = this.refreshToken;
        if (str3 != null) {
            r23 = str3.hashCode();
        } else {
            r23 = 0;
        }
        int r15 = (r14 + r23) * 31;
        String str4 = this.tokenType;
        if (str4 != null) {
            r0 = str4.hashCode();
        }
        return r15 + r0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AuthenticationResultType(accessToken=*** Sensitive Data Redacted ***,");
        sb.append("expiresIn=" + this.expiresIn + ',');
        sb.append("idToken=*** Sensitive Data Redacted ***,");
        sb.append("newDeviceMetadata=" + this.newDeviceMetadata + ',');
        sb.append("refreshToken=*** Sensitive Data Redacted ***,");
        return Credentials$$ExternalSyntheticOutline0.m(new StringBuilder("tokenType="), this.tokenType, sb, ")", "StringBuilder().apply(builderAction).toString()");
    }
}
