package aws.sdk.kotlin.services.cognitoidentityprovider.model;

import aws.sdk.kotlin.services.cognitoidentity.endpoints.EndpointParameters$$ExternalSyntheticOutline0;
import aws.sdk.kotlin.services.cognitoidentity.model.Credentials$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceSecretVerifierConfigType.kt */
/* loaded from: classes.dex */
public final class DeviceSecretVerifierConfigType {
    public final String passwordVerifier;
    public final String salt;

    /* compiled from: DeviceSecretVerifierConfigType.kt */
    /* loaded from: classes.dex */
    public static final class Builder {
        public String passwordVerifier;
        public String salt;
    }

    public DeviceSecretVerifierConfigType(Builder builder) {
        this.passwordVerifier = builder.passwordVerifier;
        this.salt = builder.salt;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DeviceSecretVerifierConfigType.class != obj.getClass()) {
            return false;
        }
        DeviceSecretVerifierConfigType deviceSecretVerifierConfigType = (DeviceSecretVerifierConfigType) obj;
        if (Intrinsics.areEqual(this.passwordVerifier, deviceSecretVerifierConfigType.passwordVerifier) && Intrinsics.areEqual(this.salt, deviceSecretVerifierConfigType.salt)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int r1;
        int r0 = 0;
        String str = this.passwordVerifier;
        if (str != null) {
            r1 = str.hashCode();
        } else {
            r1 = 0;
        }
        int r12 = r1 * 31;
        String str2 = this.salt;
        if (str2 != null) {
            r0 = str2.hashCode();
        }
        return r12 + r0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("DeviceSecretVerifierConfigType(");
        return Credentials$$ExternalSyntheticOutline0.m(EndpointParameters$$ExternalSyntheticOutline0.m(new StringBuilder("passwordVerifier="), this.passwordVerifier, ',', sb, "salt="), this.salt, sb, ")", "StringBuilder().apply(builderAction).toString()");
    }
}
