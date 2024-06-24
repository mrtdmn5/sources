package aws.sdk.kotlin.services.cognitoidentity.model;

import aws.sdk.kotlin.services.cognitoidentity.endpoints.EndpointParameters$$ExternalSyntheticOutline0;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetIdRequest.kt */
/* loaded from: classes.dex */
public final class GetIdRequest {
    public final String identityPoolId;
    public final Map<String, String> logins;

    /* compiled from: GetIdRequest.kt */
    /* loaded from: classes.dex */
    public static final class Builder {
        public String identityPoolId;
        public Map<String, String> logins;
    }

    public GetIdRequest(Builder builder) {
        this.identityPoolId = builder.identityPoolId;
        this.logins = builder.logins;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || GetIdRequest.class != obj.getClass()) {
            return false;
        }
        GetIdRequest getIdRequest = (GetIdRequest) obj;
        if (Intrinsics.areEqual((Object) null, (Object) null) && Intrinsics.areEqual(this.identityPoolId, getIdRequest.identityPoolId) && Intrinsics.areEqual(this.logins, getIdRequest.logins)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int r1;
        int r0 = 0;
        String str = this.identityPoolId;
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
        StringBuilder sb = new StringBuilder("GetIdRequest(accountId=null,");
        StringBuilder m = EndpointParameters$$ExternalSyntheticOutline0.m(new StringBuilder("identityPoolId="), this.identityPoolId, ',', sb, "logins=");
        m.append(this.logins);
        sb.append(m.toString());
        sb.append(")");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
