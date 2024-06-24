package aws.sdk.kotlin.services.cognitoidentity.model;

import aws.sdk.kotlin.services.cognitoidentity.endpoints.EndpointParameters$$ExternalSyntheticOutline0;
import aws.smithy.kotlin.runtime.time.Instant;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Credentials.kt */
/* loaded from: classes.dex */
public final class Credentials {
    public final String accessKeyId;
    public final Instant expiration;
    public final String secretKey;
    public final String sessionToken;

    /* compiled from: Credentials.kt */
    /* loaded from: classes.dex */
    public static final class Builder {
        public String accessKeyId;
        public Instant expiration;
        public String secretKey;
        public String sessionToken;
    }

    public Credentials(Builder builder) {
        this.accessKeyId = builder.accessKeyId;
        this.expiration = builder.expiration;
        this.secretKey = builder.secretKey;
        this.sessionToken = builder.sessionToken;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Credentials.class != obj.getClass()) {
            return false;
        }
        Credentials credentials = (Credentials) obj;
        if (Intrinsics.areEqual(this.accessKeyId, credentials.accessKeyId) && Intrinsics.areEqual(this.expiration, credentials.expiration) && Intrinsics.areEqual(this.secretKey, credentials.secretKey) && Intrinsics.areEqual(this.sessionToken, credentials.sessionToken)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int r1;
        int r2;
        int r22;
        int r0 = 0;
        String str = this.accessKeyId;
        if (str != null) {
            r1 = str.hashCode();
        } else {
            r1 = 0;
        }
        int r12 = r1 * 31;
        Instant instant = this.expiration;
        if (instant != null) {
            r2 = instant.hashCode();
        } else {
            r2 = 0;
        }
        int r13 = (r12 + r2) * 31;
        String str2 = this.secretKey;
        if (str2 != null) {
            r22 = str2.hashCode();
        } else {
            r22 = 0;
        }
        int r14 = (r13 + r22) * 31;
        String str3 = this.sessionToken;
        if (str3 != null) {
            r0 = str3.hashCode();
        }
        return r14 + r0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Credentials(");
        StringBuilder m = EndpointParameters$$ExternalSyntheticOutline0.m(new StringBuilder("accessKeyId="), this.accessKeyId, ',', sb, "expiration=");
        m.append(this.expiration);
        m.append(',');
        sb.append(m.toString());
        return Credentials$$ExternalSyntheticOutline0.m(EndpointParameters$$ExternalSyntheticOutline0.m(new StringBuilder("secretKey="), this.secretKey, ',', sb, "sessionToken="), this.sessionToken, sb, ")", "StringBuilder().apply(builderAction).toString()");
    }
}
