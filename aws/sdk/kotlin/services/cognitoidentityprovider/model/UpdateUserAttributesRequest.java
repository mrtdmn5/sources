package aws.sdk.kotlin.services.cognitoidentityprovider.model;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UpdateUserAttributesRequest.kt */
/* loaded from: classes.dex */
public final class UpdateUserAttributesRequest {
    public final String accessToken;
    public final Map<String, String> clientMetadata;
    public final List<AttributeType> userAttributes;

    /* compiled from: UpdateUserAttributesRequest.kt */
    /* loaded from: classes.dex */
    public static final class Builder {
        public String accessToken;
        public Map<String, String> clientMetadata;
        public List<AttributeType> userAttributes;
    }

    public UpdateUserAttributesRequest(Builder builder) {
        this.accessToken = builder.accessToken;
        this.clientMetadata = builder.clientMetadata;
        this.userAttributes = builder.userAttributes;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || UpdateUserAttributesRequest.class != obj.getClass()) {
            return false;
        }
        UpdateUserAttributesRequest updateUserAttributesRequest = (UpdateUserAttributesRequest) obj;
        if (Intrinsics.areEqual(this.accessToken, updateUserAttributesRequest.accessToken) && Intrinsics.areEqual(this.clientMetadata, updateUserAttributesRequest.clientMetadata) && Intrinsics.areEqual(this.userAttributes, updateUserAttributesRequest.userAttributes)) {
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
        Map<String, String> map = this.clientMetadata;
        if (map != null) {
            r2 = map.hashCode();
        } else {
            r2 = 0;
        }
        int r13 = (r12 + r2) * 31;
        List<AttributeType> list = this.userAttributes;
        if (list != null) {
            r0 = list.hashCode();
        }
        return r13 + r0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("UpdateUserAttributesRequest(accessToken=*** Sensitive Data Redacted ***,");
        sb.append("clientMetadata=" + this.clientMetadata + ',');
        StringBuilder sb2 = new StringBuilder("userAttributes=");
        sb2.append(this.userAttributes);
        sb.append(sb2.toString());
        sb.append(")");
        String sb3 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }
}
