package aws.sdk.kotlin.services.cognitoidentityprovider.model;

import kotlin.jvm.internal.Reflection;

/* compiled from: DeleteUserResponse.kt */
/* loaded from: classes.dex */
public final class DeleteUserResponse {
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && DeleteUserResponse.class == obj.getClass()) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Reflection.getOrCreateKotlinClass(DeleteUserResponse.class).hashCode();
    }

    public final String toString() {
        return "DeleteUserResponse()";
    }
}
