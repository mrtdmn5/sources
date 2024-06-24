package aws.sdk.kotlin.services.cognitoidentityprovider.model;

import kotlin.jvm.internal.Reflection;

/* compiled from: ConfirmForgotPasswordResponse.kt */
/* loaded from: classes.dex */
public final class ConfirmForgotPasswordResponse {
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ConfirmForgotPasswordResponse.class == obj.getClass()) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Reflection.getOrCreateKotlinClass(ConfirmForgotPasswordResponse.class).hashCode();
    }

    public final String toString() {
        return "ConfirmForgotPasswordResponse()";
    }
}
