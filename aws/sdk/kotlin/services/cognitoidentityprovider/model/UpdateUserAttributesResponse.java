package aws.sdk.kotlin.services.cognitoidentityprovider.model;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UpdateUserAttributesResponse.kt */
/* loaded from: classes.dex */
public final class UpdateUserAttributesResponse {
    public final List<CodeDeliveryDetailsType> codeDeliveryDetailsList;

    /* compiled from: UpdateUserAttributesResponse.kt */
    /* loaded from: classes.dex */
    public static final class Builder {
        public List<CodeDeliveryDetailsType> codeDeliveryDetailsList;
    }

    public UpdateUserAttributesResponse(Builder builder) {
        this.codeDeliveryDetailsList = builder.codeDeliveryDetailsList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && UpdateUserAttributesResponse.class == obj.getClass() && Intrinsics.areEqual(this.codeDeliveryDetailsList, ((UpdateUserAttributesResponse) obj).codeDeliveryDetailsList)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        List<CodeDeliveryDetailsType> list = this.codeDeliveryDetailsList;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("UpdateUserAttributesResponse(");
        sb.append("codeDeliveryDetailsList=" + this.codeDeliveryDetailsList);
        sb.append(")");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
