package aws.sdk.kotlin.services.cognitoidentityprovider.model;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChangePasswordRequest.kt */
/* loaded from: classes.dex */
public final class ChangePasswordRequest {
    public final String accessToken;
    public final String previousPassword;
    public final String proposedPassword;

    /* compiled from: ChangePasswordRequest.kt */
    /* loaded from: classes.dex */
    public static final class Builder {
        public String accessToken;
        public String previousPassword;
        public String proposedPassword;
    }

    public ChangePasswordRequest(Builder builder) {
        this.accessToken = builder.accessToken;
        this.previousPassword = builder.previousPassword;
        this.proposedPassword = builder.proposedPassword;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ChangePasswordRequest.class != obj.getClass()) {
            return false;
        }
        ChangePasswordRequest changePasswordRequest = (ChangePasswordRequest) obj;
        if (Intrinsics.areEqual(this.accessToken, changePasswordRequest.accessToken) && Intrinsics.areEqual(this.previousPassword, changePasswordRequest.previousPassword) && Intrinsics.areEqual(this.proposedPassword, changePasswordRequest.proposedPassword)) {
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
        String str2 = this.previousPassword;
        if (str2 != null) {
            r2 = str2.hashCode();
        } else {
            r2 = 0;
        }
        int r13 = (r12 + r2) * 31;
        String str3 = this.proposedPassword;
        if (str3 != null) {
            r0 = str3.hashCode();
        }
        return r13 + r0;
    }

    public final String toString() {
        return "ChangePasswordRequest(accessToken=*** Sensitive Data Redacted ***,previousPassword=*** Sensitive Data Redacted ***,proposedPassword=*** Sensitive Data Redacted ***)";
    }
}
