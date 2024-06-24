package aws.sdk.kotlin.services.cognitoidentityprovider.model;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeleteUserRequest.kt */
/* loaded from: classes.dex */
public final class DeleteUserRequest {
    public final String accessToken;

    /* compiled from: DeleteUserRequest.kt */
    /* loaded from: classes.dex */
    public static final class Builder {
        public String accessToken;
    }

    public DeleteUserRequest(Builder builder) {
        this.accessToken = builder.accessToken;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && DeleteUserRequest.class == obj.getClass() && Intrinsics.areEqual(this.accessToken, ((DeleteUserRequest) obj).accessToken)) {
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
        return "DeleteUserRequest(accessToken=*** Sensitive Data Redacted ***)";
    }
}
