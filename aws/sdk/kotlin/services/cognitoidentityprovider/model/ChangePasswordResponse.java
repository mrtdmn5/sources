package aws.sdk.kotlin.services.cognitoidentityprovider.model;

import kotlin.jvm.internal.Reflection;

/* compiled from: ChangePasswordResponse.kt */
/* loaded from: classes.dex */
public final class ChangePasswordResponse {
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ChangePasswordResponse.class == obj.getClass()) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Reflection.getOrCreateKotlinClass(ChangePasswordResponse.class).hashCode();
    }

    public final String toString() {
        return "ChangePasswordResponse()";
    }
}
