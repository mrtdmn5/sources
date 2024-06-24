package aws.sdk.kotlin.services.cognitoidentityprovider.model;

import aws.sdk.kotlin.services.cognitoidentity.endpoints.EndpointParameters$$ExternalSyntheticOutline0;
import aws.sdk.kotlin.services.cognitoidentity.model.Credentials$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CodeDeliveryDetailsType.kt */
/* loaded from: classes.dex */
public final class CodeDeliveryDetailsType {
    public final String attributeName;
    public final DeliveryMediumType deliveryMedium;
    public final String destination;

    /* compiled from: CodeDeliveryDetailsType.kt */
    /* loaded from: classes.dex */
    public static final class Builder {
        public String attributeName;
        public DeliveryMediumType deliveryMedium;
        public String destination;
    }

    public CodeDeliveryDetailsType(Builder builder) {
        this.attributeName = builder.attributeName;
        this.deliveryMedium = builder.deliveryMedium;
        this.destination = builder.destination;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || CodeDeliveryDetailsType.class != obj.getClass()) {
            return false;
        }
        CodeDeliveryDetailsType codeDeliveryDetailsType = (CodeDeliveryDetailsType) obj;
        if (Intrinsics.areEqual(this.attributeName, codeDeliveryDetailsType.attributeName) && Intrinsics.areEqual(this.deliveryMedium, codeDeliveryDetailsType.deliveryMedium) && Intrinsics.areEqual(this.destination, codeDeliveryDetailsType.destination)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int r1;
        int r2;
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
            r2 = deliveryMediumType.hashCode();
        } else {
            r2 = 0;
        }
        int r13 = (r12 + r2) * 31;
        String str2 = this.destination;
        if (str2 != null) {
            r0 = str2.hashCode();
        }
        return r13 + r0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("CodeDeliveryDetailsType(");
        StringBuilder m = EndpointParameters$$ExternalSyntheticOutline0.m(new StringBuilder("attributeName="), this.attributeName, ',', sb, "deliveryMedium=");
        m.append(this.deliveryMedium);
        m.append(',');
        sb.append(m.toString());
        return Credentials$$ExternalSyntheticOutline0.m(new StringBuilder("destination="), this.destination, sb, ")", "StringBuilder().apply(builderAction).toString()");
    }
}
