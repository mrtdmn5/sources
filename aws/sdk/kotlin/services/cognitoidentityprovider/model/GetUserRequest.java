package aws.sdk.kotlin.services.cognitoidentityprovider.model;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetUserRequest.kt */
/* loaded from: classes.dex */
public final class GetUserRequest {
    public final String accessToken;

    /* compiled from: GetUserRequest.kt */
    /* loaded from: classes.dex */
    public static final class Builder {
        public String accessToken;
    }

    public GetUserRequest(Builder builder) {
        this.accessToken = builder.accessToken;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && GetUserRequest.class == obj.getClass() && Intrinsics.areEqual(this.accessToken, ((GetUserRequest) obj).accessToken)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        String str = this.accessToken;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "GetUserRequest(accessToken=*** Sensitive Data Redacted ***)";
    }
}
