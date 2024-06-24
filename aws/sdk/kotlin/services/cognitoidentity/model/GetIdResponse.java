package aws.sdk.kotlin.services.cognitoidentity.model;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetIdResponse.kt */
/* loaded from: classes.dex */
public final class GetIdResponse {
    public final String identityId;

    /* compiled from: GetIdResponse.kt */
    /* loaded from: classes.dex */
    public static final class Builder {
        public String identityId;
    }

    public GetIdResponse(Builder builder) {
        this.identityId = builder.identityId;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && GetIdResponse.class == obj.getClass() && Intrinsics.areEqual(this.identityId, ((GetIdResponse) obj).identityId)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        String str = this.identityId;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return Credentials$$ExternalSyntheticOutline0.m(new StringBuilder("identityId="), this.identityId, new StringBuilder("GetIdResponse("), ")", "StringBuilder().apply(builderAction).toString()");
    }
}
