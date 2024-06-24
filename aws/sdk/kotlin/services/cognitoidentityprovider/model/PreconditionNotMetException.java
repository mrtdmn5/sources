package aws.sdk.kotlin.services.cognitoidentityprovider.model;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: PreconditionNotMetException.kt */
/* loaded from: classes.dex */
public final class PreconditionNotMetException extends CognitoIdentityProviderException {
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PreconditionNotMetException.class != obj.getClass()) {
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
        return "PreconditionNotMetException(message=null)";
    }
}
