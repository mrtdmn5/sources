package com.amplifyframework.auth.cognito;

import aws.sdk.kotlin.services.cognitoidentityprovider.model.AliasExistsException;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.CodeDeliveryFailureException;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.CodeMismatchException;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.ExpiredCodeException;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.InvalidParameterException;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.InvalidPasswordException;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.LimitExceededException;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.MfaMethodNotFoundException;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.NotAuthorizedException;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.PasswordResetRequiredException;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.ResourceNotFoundException;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.SoftwareTokenMfaNotFoundException;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.TooManyFailedAttemptsException;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.TooManyRequestsException;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.UserNotConfirmedException;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.UserNotFoundException;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.UsernameExistsException;
import com.amplifyframework.auth.AuthException;
import com.amplifyframework.auth.cognito.exceptions.service.CodeExpiredException;
import com.amplifyframework.auth.cognito.exceptions.service.FailedAttemptsLimitExceededException;
import com.amplifyframework.auth.cognito.exceptions.service.MFAMethodNotFoundException;
import com.amplifyframework.auth.cognito.exceptions.service.SoftwareTokenMFANotFoundException;
import com.amplifyframework.auth.exceptions.UnknownException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CognitoAuthExceptionConverter.kt */
/* loaded from: classes.dex */
public final class CognitoAuthExceptionConverter {
    public static final Companion Companion = new Companion(null);
    private static final String defaultRecoveryMessage = "See attached exception for more details.";

    /* compiled from: CognitoAuthExceptionConverter.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AuthException lookup(Exception error, String fallbackMessage) {
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(fallbackMessage, "fallbackMessage");
            if (error instanceof UserNotFoundException) {
                return new com.amplifyframework.auth.cognito.exceptions.service.UserNotFoundException(error);
            }
            if (error instanceof UserNotConfirmedException) {
                return new com.amplifyframework.auth.cognito.exceptions.service.UserNotConfirmedException(error);
            }
            if (error instanceof UsernameExistsException) {
                return new com.amplifyframework.auth.cognito.exceptions.service.UsernameExistsException(error);
            }
            if (error instanceof AliasExistsException) {
                return new com.amplifyframework.auth.cognito.exceptions.service.AliasExistsException(error);
            }
            if (error instanceof InvalidPasswordException) {
                return new com.amplifyframework.auth.cognito.exceptions.service.InvalidPasswordException(error);
            }
            if (error instanceof InvalidParameterException) {
                return new com.amplifyframework.auth.cognito.exceptions.service.InvalidParameterException(error);
            }
            if (error instanceof ExpiredCodeException) {
                return new CodeExpiredException(error);
            }
            if (error instanceof CodeMismatchException) {
                return new com.amplifyframework.auth.cognito.exceptions.service.CodeMismatchException(error);
            }
            if (error instanceof CodeDeliveryFailureException) {
                return new com.amplifyframework.auth.cognito.exceptions.service.CodeDeliveryFailureException(error);
            }
            if (error instanceof LimitExceededException) {
                return new com.amplifyframework.auth.cognito.exceptions.service.LimitExceededException(error);
            }
            if (error instanceof MfaMethodNotFoundException) {
                return new MFAMethodNotFoundException(error);
            }
            if (error instanceof NotAuthorizedException) {
                return new com.amplifyframework.auth.exceptions.NotAuthorizedException(null, null, error, 3, null);
            }
            if (error instanceof ResourceNotFoundException) {
                return new com.amplifyframework.auth.cognito.exceptions.service.ResourceNotFoundException(error);
            }
            if (error instanceof SoftwareTokenMfaNotFoundException) {
                return new SoftwareTokenMFANotFoundException(error);
            }
            if (error instanceof TooManyFailedAttemptsException) {
                return new FailedAttemptsLimitExceededException(error);
            }
            if (error instanceof TooManyRequestsException) {
                return new com.amplifyframework.auth.cognito.exceptions.service.TooManyRequestsException(error);
            }
            if (error instanceof PasswordResetRequiredException) {
                return new com.amplifyframework.auth.cognito.exceptions.service.PasswordResetRequiredException(error);
            }
            return new UnknownException(fallbackMessage, error);
        }

        private Companion() {
        }
    }
}
