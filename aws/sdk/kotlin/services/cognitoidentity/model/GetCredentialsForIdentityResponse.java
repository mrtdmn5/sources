package aws.sdk.kotlin.services.cognitoidentity.model;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetCredentialsForIdentityResponse.kt */
/* loaded from: classes.dex */
public final class GetCredentialsForIdentityResponse {
    public final Credentials credentials;
    public final String identityId;

    /* compiled from: GetCredentialsForIdentityResponse.kt */
    /* loaded from: classes.dex */
    public static final class Builder {
        public Credentials credentials;
        public String identityId;
    }

    public GetCredentialsForIdentityResponse(Builder builder) {
        this.credentials = builder.credentials;
        this.identityId = builder.identityId;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || GetCredentialsForIdentityResponse.class != obj.getClass()) {
            return false;
        }
        GetCredentialsForIdentityResponse getCredentialsForIdentityResponse = (GetCredentialsForIdentityResponse) obj;
        if (Intrinsics.areEqual(this.credentials, getCredentialsForIdentityResponse.credentials) && Intrinsics.areEqual(this.identityId, getCredentialsForIdentityResponse.identityId)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int r1;
        int r0 = 0;
        Credentials credentials = this.credentials;
        if (credentials != null) {
            r1 = credentials.hashCode();
        } else {
            r1 = 0;
        }
        int r12 = r1 * 31;
        String str = this.identityId;
        if (str != null) {
            r0 = str.hashCode();
        }
        return r12 + r0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("GetCredentialsForIdentityResponse(");
        sb.append("credentials=" + this.credentials + ',');
        return Credentials$$ExternalSyntheticOutline0.m(new StringBuilder("identityId="), this.identityId, sb, ")", "StringBuilder().apply(builderAction).toString()");
    }
}
