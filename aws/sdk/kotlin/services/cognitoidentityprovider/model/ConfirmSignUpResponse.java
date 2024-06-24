package aws.sdk.kotlin.services.cognitoidentityprovider.model;

import kotlin.jvm.internal.Reflection;

/* compiled from: ConfirmSignUpResponse.kt */
/* loaded from: classes.dex */
public final class ConfirmSignUpResponse {
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ConfirmSignUpResponse.class == obj.getClass()) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Reflection.getOrCreateKotlinClass(ConfirmSignUpResponse.class).hashCode();
    }

    public final String toString() {
        return "ConfirmSignUpResponse()";
    }
}
