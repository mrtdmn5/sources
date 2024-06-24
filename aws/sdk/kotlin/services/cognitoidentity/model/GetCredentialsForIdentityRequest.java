package aws.sdk.kotlin.services.cognitoidentity.model;

import aws.sdk.kotlin.services.cognitoidentity.endpoints.EndpointParameters$$ExternalSyntheticOutline0;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetCredentialsForIdentityRequest.kt */
/* loaded from: classes.dex */
public final class GetCredentialsForIdentityRequest {
    public final String identityId;
    public final Map<String, String> logins;

    /* compiled from: GetCredentialsForIdentityRequest.kt */
    /* loaded from: classes.dex */
    public static final class Builder {
        public String identityId;
        public Map<String, String> logins;
    }

    public GetCredentialsForIdentityRequest(Builder builder) {
        this.identityId = builder.identityId;
        this.logins = builder.logins;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || GetCredentialsForIdentityRequest.class != obj.getClass()) {
            return false;
        }
        GetCredentialsForIdentityRequest getCredentialsForIdentityRequest = (GetCredentialsForIdentityRequest) obj;
        if (Intrinsics.areEqual((Object) null, (Object) null) && Intrinsics.areEqual(this.identityId, getCredentialsForIdentityRequest.identityId) && Intrinsics.areEqual(this.logins, getCredentialsForIdentityRequest.logins)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int r1;
        int r0 = 0;
        String str = this.identityId;
        if (str != null) {
            r1 = str.hashCode();
        } else {
            r1 = 0;
        }
        int r12 = (r1 + 0) * 31;
        Map<String, String> map = this.logins;
        if (map != null) {
            r0 = map.hashCode();
        }
        return r12 + r0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("GetCredentialsForIdentityRequest(customRoleArn=null,");
        StringBuilder m = EndpointParameters$$ExternalSyntheticOutline0.m(new StringBuilder("identityId="), this.identityId, ',', sb, "logins=");
        m.append(this.logins);
        sb.append(m.toString());
        sb.append(")");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
