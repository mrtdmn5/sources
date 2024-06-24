package aws.sdk.kotlin.runtime.auth.credentials.internal.sso.model;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResourceNotFoundException.kt */
/* loaded from: classes.dex */
public final class ResourceNotFoundException extends SsoException {
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ResourceNotFoundException.class != obj.getClass()) {
            return false;
        }
        if (Intrinsics.areEqual((Object) null, (Object) null)) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return null;
    }

    public final int hashCode() {
        return 0;
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return "ResourceNotFoundException(message=null)";
    }
}
