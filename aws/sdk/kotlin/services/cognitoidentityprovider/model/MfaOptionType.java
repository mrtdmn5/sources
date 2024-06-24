package aws.sdk.kotlin.services.cognitoidentityprovider.model;

import aws.sdk.kotlin.services.cognitoidentity.endpoints.EndpointParameters$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MfaOptionType.kt */
/* loaded from: classes.dex */
public final class MfaOptionType {
    public final String attributeName;
    public final DeliveryMediumType deliveryMedium;

    /* compiled from: MfaOptionType.kt */
    /* loaded from: classes.dex */
    public static final class Builder {
        public String attributeName;
        public DeliveryMediumType deliveryMedium;
    }

    public MfaOptionType(Builder builder) {
        this.attributeName = builder.attributeName;
        this.deliveryMedium = builder.deliveryMedium;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MfaOptionType.class != obj.getClass()) {
            return false;
        }
        MfaOptionType mfaOptionType = (MfaOptionType) obj;
        if (Intrinsics.areEqual(this.attributeName, mfaOptionType.attributeName) && Intrinsics.areEqual(this.deliveryMedium, mfaOptionType.deliveryMedium)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int r1;
        int r0 = 0;
        String str = this.attributeName;
        if (str != null) {
            r1 = str.hashCode();
        } else {
            r1 = 0;
        }
        int r12 = r1 * 31;
        DeliveryMediumType deliveryMediumType = this.deliveryMedium;
        if (deliveryMediumType != null) {
            r0 = deliveryMediumType.hashCode();
        }
        return r12 + r0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("MfaOptionType(");
        StringBuilder m = EndpointParameters$$ExternalSyntheticOutline0.m(new StringBuilder("attributeName="), this.attributeName, ',', sb, "deliveryMedium=");
        m.append(this.deliveryMedium);
        sb.append(m.toString());
        sb.append(")");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
