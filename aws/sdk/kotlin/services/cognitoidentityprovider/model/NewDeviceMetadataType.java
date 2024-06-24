package aws.sdk.kotlin.services.cognitoidentityprovider.model;

import aws.sdk.kotlin.services.cognitoidentity.endpoints.EndpointParameters$$ExternalSyntheticOutline0;
import aws.sdk.kotlin.services.cognitoidentity.model.Credentials$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NewDeviceMetadataType.kt */
/* loaded from: classes.dex */
public final class NewDeviceMetadataType {
    public final String deviceGroupKey;
    public final String deviceKey;

    /* compiled from: NewDeviceMetadataType.kt */
    /* loaded from: classes.dex */
    public static final class Builder {
        public String deviceGroupKey;
        public String deviceKey;
    }

    public NewDeviceMetadataType(Builder builder) {
        this.deviceGroupKey = builder.deviceGroupKey;
        this.deviceKey = builder.deviceKey;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || NewDeviceMetadataType.class != obj.getClass()) {
            return false;
        }
        NewDeviceMetadataType newDeviceMetadataType = (NewDeviceMetadataType) obj;
        if (Intrinsics.areEqual(this.deviceGroupKey, newDeviceMetadataType.deviceGroupKey) && Intrinsics.areEqual(this.deviceKey, newDeviceMetadataType.deviceKey)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int r1;
        int r0 = 0;
        String str = this.deviceGroupKey;
        if (str != null) {
            r1 = str.hashCode();
        } else {
            r1 = 0;
        }
        int r12 = r1 * 31;
        String str2 = this.deviceKey;
        if (str2 != null) {
            r0 = str2.hashCode();
        }
        return r12 + r0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("NewDeviceMetadataType(");
        return Credentials$$ExternalSyntheticOutline0.m(EndpointParameters$$ExternalSyntheticOutline0.m(new StringBuilder("deviceGroupKey="), this.deviceGroupKey, ',', sb, "deviceKey="), this.deviceKey, sb, ")", "StringBuilder().apply(builderAction).toString()");
    }
}
