package aws.sdk.kotlin.services.cognitoidentityprovider.model;

import kotlin.jvm.internal.Reflection;

/* compiled from: RevokeTokenResponse.kt */
/* loaded from: classes.dex */
public final class RevokeTokenResponse {
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && RevokeTokenResponse.class == obj.getClass()) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Reflection.getOrCreateKotlinClass(RevokeTokenResponse.class).hashCode();
    }

    public final String toString() {
        return "RevokeTokenResponse()";
    }
}
