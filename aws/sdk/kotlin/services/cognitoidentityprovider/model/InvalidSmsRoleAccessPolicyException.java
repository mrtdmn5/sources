package aws.sdk.kotlin.services.cognitoidentityprovider.model;

import aws.sdk.kotlin.runtime.AwsServiceException;
import aws.sdk.kotlin.services.cognitoidentity.model.Credentials$$ExternalSyntheticOutline0;
import aws.smithy.kotlin.runtime.ServiceErrorMetadata;
import aws.smithy.kotlin.runtime.ServiceException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InvalidSmsRoleAccessPolicyException.kt */
/* loaded from: classes.dex */
public final class InvalidSmsRoleAccessPolicyException extends CognitoIdentityProviderException {
    public final String message;

    /* compiled from: InvalidSmsRoleAccessPolicyException.kt */
    /* loaded from: classes.dex */
    public static final class Builder {
        public String message;
    }

    public InvalidSmsRoleAccessPolicyException(Builder builder) {
        this.message = builder.message;
        ((AwsServiceException) this).sdkErrorMetadata.attributes.set(ServiceErrorMetadata.ErrorType, ServiceException.ErrorType.Client);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && InvalidSmsRoleAccessPolicyException.class == obj.getClass() && Intrinsics.areEqual(this.message, ((InvalidSmsRoleAccessPolicyException) obj).message)) {
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
        return Credentials$$ExternalSyntheticOutline0.m(new StringBuilder("message="), this.message, new StringBuilder("InvalidSmsRoleAccessPolicyException("), ")", "StringBuilder().apply(builderAction).toString()");
    }
}
