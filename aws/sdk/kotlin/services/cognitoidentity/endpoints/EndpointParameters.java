package aws.sdk.kotlin.services.cognitoidentity.endpoints;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: EndpointParameters.kt */
/* loaded from: classes.dex */
public final class EndpointParameters {
    public final String endpoint;
    public final String region;
    public final Boolean useDualStack;
    public final Boolean useFips;

    /* compiled from: EndpointParameters.kt */
    /* loaded from: classes.dex */
    public static final class Builder {
        public String endpoint;
        public String region;
        public Boolean useDualStack;
        public Boolean useFips;

        public Builder() {
            Boolean bool = Boolean.FALSE;
            this.useDualStack = bool;
            this.useFips = bool;
        }
    }

    public EndpointParameters(Builder builder) {
        this.endpoint = builder.endpoint;
        this.region = builder.region;
        Boolean bool = builder.useDualStack;
        if (bool != null) {
            this.useDualStack = bool;
            Boolean bool2 = builder.useFips;
            if (bool2 != null) {
                this.useFips = bool2;
                return;
            }
            throw new IllegalArgumentException("endpoint provider parameter #useFips is required".toString());
        }
        throw new IllegalArgumentException("endpoint provider parameter #useDualStack is required".toString());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EndpointParameters)) {
            return false;
        }
        EndpointParameters endpointParameters = (EndpointParameters) obj;
        if (Intrinsics.areEqual(this.endpoint, endpointParameters.endpoint) && Intrinsics.areEqual(this.region, endpointParameters.region) && Intrinsics.areEqual(this.useDualStack, endpointParameters.useDualStack) && Intrinsics.areEqual(this.useFips, endpointParameters.useFips)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int r1;
        int r2;
        int r22;
        int r0 = 0;
        String str = this.endpoint;
        if (str != null) {
            r1 = str.hashCode();
        } else {
            r1 = 0;
        }
        int r12 = r1 * 31;
        String str2 = this.region;
        if (str2 != null) {
            r2 = str2.hashCode();
        } else {
            r2 = 0;
        }
        int r13 = (r12 + r2) * 31;
        Boolean bool = this.useDualStack;
        if (bool != null) {
            r22 = bool.hashCode();
        } else {
            r22 = 0;
        }
        int r14 = (r13 + r22) * 31;
        Boolean bool2 = this.useFips;
        if (bool2 != null) {
            r0 = bool2.hashCode();
        }
        return r14 + r0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("EndpointParameters(");
        StringBuilder m = EndpointParameters$$ExternalSyntheticOutline0.m(EndpointParameters$$ExternalSyntheticOutline0.m(new StringBuilder("endpoint="), this.endpoint, ',', sb, "region="), this.region, ',', sb, "useDualStack=");
        m.append(this.useDualStack);
        m.append(',');
        sb.append(m.toString());
        sb.append("useFips=" + this.useFips + ')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
