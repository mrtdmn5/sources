package aws.sdk.kotlin.services.cognitoidentity.model;

import aws.sdk.kotlin.runtime.AwsServiceException;
import aws.smithy.kotlin.runtime.ServiceErrorMetadata;
import aws.smithy.kotlin.runtime.ServiceException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResourceConflictException.kt */
/* loaded from: classes.dex */
public final class ResourceConflictException extends CognitoIdentityException {
    public final String message;

    /* compiled from: ResourceConflictException.kt */
    /* loaded from: classes.dex */
    public static final class Builder {
        public String message;
    }

    public ResourceConflictException(Builder builder) {
        this.message = builder.message;
        ((AwsServiceException) this).sdkErrorMetadata.attributes.set(ServiceErrorMetadata.ErrorType, ServiceException.ErrorType.Client);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ResourceConflictException.class == obj.getClass() && Intrinsics.areEqual(this.message, ((ResourceConflictException) obj).message)) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return this.message;
    }

    public final int hashCode() {
        String str = this.message;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return Credentials$$ExternalSyntheticOutline0.m(new StringBuilder("message="), this.message, new StringBuilder("ResourceConflictException("), ")", "StringBuilder().apply(builderAction).toString()");
    }
}
