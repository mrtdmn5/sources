package aws.sdk.kotlin.services.cognitoidentityprovider.model;

import aws.sdk.kotlin.services.cognitoidentity.model.Credentials$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnalyticsMetadataType.kt */
/* loaded from: classes.dex */
public final class AnalyticsMetadataType {
    public final String analyticsEndpointId;

    /* compiled from: AnalyticsMetadataType.kt */
    /* loaded from: classes.dex */
    public static final class Builder {
        public String analyticsEndpointId;
    }

    public AnalyticsMetadataType(Builder builder) {
        this.analyticsEndpointId = builder.analyticsEndpointId;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && AnalyticsMetadataType.class == obj.getClass() && Intrinsics.areEqual(this.analyticsEndpointId, ((AnalyticsMetadataType) obj).analyticsEndpointId)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        String str = this.analyticsEndpointId;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return Credentials$$ExternalSyntheticOutline0.m(new StringBuilder("analyticsEndpointId="), this.analyticsEndpointId, new StringBuilder("AnalyticsMetadataType("), ")", "StringBuilder().apply(builderAction).toString()");
    }
}
