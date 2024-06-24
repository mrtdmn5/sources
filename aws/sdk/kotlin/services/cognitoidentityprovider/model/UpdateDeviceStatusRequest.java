package aws.sdk.kotlin.services.cognitoidentityprovider.model;

import aws.sdk.kotlin.services.cognitoidentity.endpoints.EndpointParameters$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UpdateDeviceStatusRequest.kt */
/* loaded from: classes.dex */
public final class UpdateDeviceStatusRequest {
    public final String accessToken;
    public final String deviceKey;
    public final DeviceRememberedStatusType deviceRememberedStatus;

    /* compiled from: UpdateDeviceStatusRequest.kt */
    /* loaded from: classes.dex */
    public static final class Builder {
        public String accessToken;
        public String deviceKey;
        public DeviceRememberedStatusType deviceRememberedStatus;
    }

    public UpdateDeviceStatusRequest(Builder builder) {
        this.accessToken = builder.accessToken;
        this.deviceKey = builder.deviceKey;
        this.deviceRememberedStatus = builder.deviceRememberedStatus;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || UpdateDeviceStatusRequest.class != obj.getClass()) {
            return false;
        }
        UpdateDeviceStatusRequest updateDeviceStatusRequest = (UpdateDeviceStatusRequest) obj;
        if (Intrinsics.areEqual(this.accessToken, updateDeviceStatusRequest.accessToken) && Intrinsics.areEqual(this.deviceKey, updateDeviceStatusRequest.deviceKey) && Intrinsics.areEqual(this.deviceRememberedStatus, updateDeviceStatusRequest.deviceRememberedStatus)) {
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
        String str2 = this.deviceKey;
        if (str2 != null) {
            r2 = str2.hashCode();
        } else {
            r2 = 0;
        }
        int r13 = (r12 + r2) * 31;
        DeviceRememberedStatusType deviceRememberedStatusType = this.deviceRememberedStatus;
        if (deviceRememberedStatusType != null) {
            r0 = deviceRememberedStatusType.hashCode();
        }
        return r13 + r0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("UpdateDeviceStatusRequest(accessToken=*** Sensitive Data Redacted ***,");
        StringBuilder m = EndpointParameters$$ExternalSyntheticOutline0.m(new StringBuilder("deviceKey="), this.deviceKey, ',', sb, "deviceRememberedStatus=");
        m.append(this.deviceRememberedStatus);
        sb.append(m.toString());
        sb.append(")");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
