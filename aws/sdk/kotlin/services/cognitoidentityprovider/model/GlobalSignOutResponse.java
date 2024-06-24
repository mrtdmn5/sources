package aws.sdk.kotlin.services.cognitoidentityprovider.model;

import kotlin.jvm.internal.Reflection;

/* compiled from: GlobalSignOutResponse.kt */
/* loaded from: classes.dex */
public final class GlobalSignOutResponse {
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && GlobalSignOutResponse.class == obj.getClass()) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Reflection.getOrCreateKotlinClass(GlobalSignOutResponse.class).hashCode();
    }

    public final String toString() {
        return "GlobalSignOutResponse()";
    }
}
