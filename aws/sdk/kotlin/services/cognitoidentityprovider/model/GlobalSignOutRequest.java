package aws.sdk.kotlin.services.cognitoidentityprovider.model;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: GlobalSignOutRequest.kt */
/* loaded from: classes.dex */
public final class GlobalSignOutRequest {
    public final String accessToken;

    /* compiled from: GlobalSignOutRequest.kt */
    /* loaded from: classes.dex */
    public static final class Builder {
        public String accessToken;
    }

    public GlobalSignOutRequest(Builder builder) {
        this.accessToken = builder.accessToken;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && GlobalSignOutRequest.class == obj.getClass() && Intrinsics.areEqual(this.accessToken, ((GlobalSignOutRequest) obj).accessToken)) {
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
        return "GlobalSignOutRequest(accessToken=*** Sensitive Data Redacted ***)";
    }
}
