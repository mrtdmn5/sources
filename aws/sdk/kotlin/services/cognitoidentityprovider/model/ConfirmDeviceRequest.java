package aws.sdk.kotlin.services.cognitoidentityprovider.model;

import aws.sdk.kotlin.services.cognitoidentity.endpoints.EndpointParameters$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConfirmDeviceRequest.kt */
/* loaded from: classes.dex */
public final class ConfirmDeviceRequest {
    public final String accessToken;
    public final String deviceKey;
    public final String deviceName;
    public final DeviceSecretVerifierConfigType deviceSecretVerifierConfig;

    /* compiled from: ConfirmDeviceRequest.kt */
    /* loaded from: classes.dex */
    public static final class Builder {
        public String accessToken;
        public String deviceKey;
        public String deviceName;
        public DeviceSecretVerifierConfigType deviceSecretVerifierConfig;
    }

    public ConfirmDeviceRequest(Builder builder) {
        this.accessToken = builder.accessToken;
        this.deviceKey = builder.deviceKey;
        this.deviceName = builder.deviceName;
        this.deviceSecretVerifierConfig = builder.deviceSecretVerifierConfig;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ConfirmDeviceRequest.class != obj.getClass()) {
            return false;
        }
        ConfirmDeviceRequest confirmDeviceRequest = (ConfirmDeviceRequest) obj;
        if (Intrinsics.areEqual(this.accessToken, confirmDeviceRequest.accessToken) && Intrinsics.areEqual(this.deviceKey, confirmDeviceRequest.deviceKey) && Intrinsics.areEqual(this.deviceName, confirmDeviceRequest.deviceName) && Intrinsics.areEqual(this.deviceSecretVerifierConfig, confirmDeviceRequest.deviceSecretVerifierConfig)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int r1;
        int r2;
        int r22;
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
        String str3 = this.deviceName;
        if (str3 != null) {
            r22 = str3.hashCode();
        } else {
            r22 = 0;
        }
        int r14 = (r13 + r22) * 31;
        DeviceSecretVerifierConfigType deviceSecretVerifierConfigType = this.deviceSecretVerifierConfig;
        if (deviceSecretVerifierConfigType != null) {
            r0 = deviceSecretVerifierConfigType.hashCode();
        }
        return r14 + r0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ConfirmDeviceRequest(accessToken=*** Sensitive Data Redacted ***,");
        StringBuilder m = EndpointParameters$$ExternalSyntheticOutline0.m(EndpointParameters$$ExternalSyntheticOutline0.m(new StringBuilder("deviceKey="), this.deviceKey, ',', sb, "deviceName="), this.deviceName, ',', sb, "deviceSecretVerifierConfig=");
        m.append(this.deviceSecretVerifierConfig);
        sb.append(m.toString());
        sb.append(")");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
