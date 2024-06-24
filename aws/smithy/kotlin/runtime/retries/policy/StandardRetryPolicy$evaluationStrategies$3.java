package aws.smithy.kotlin.runtime.retries.policy;

import aws.smithy.kotlin.runtime.ServiceErrorMetadata;
import aws.smithy.kotlin.runtime.ServiceException;
import aws.smithy.kotlin.runtime.retries.policy.RetryDirective;
import aws.smithy.kotlin.runtime.util.AttributesImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StandardRetryPolicy.kt */
/* loaded from: classes.dex */
public /* synthetic */ class StandardRetryPolicy$evaluationStrategies$3 extends FunctionReferenceImpl implements Function1<ServiceException, RetryDirective> {
    public StandardRetryPolicy$evaluationStrategies$3(Object obj) {
        super(1, obj, StandardRetryPolicy.class, "evaluateServiceException", "evaluateServiceException(Laws/smithy/kotlin/runtime/ServiceException;)Laws/smithy/kotlin/runtime/retries/policy/RetryDirective;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final RetryDirective invoke(ServiceException serviceException) {
        ServiceException p0 = serviceException;
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((StandardRetryPolicy) this.receiver).getClass();
        ServiceErrorMetadata sdkErrorMetadata = p0.getSdkErrorMetadata();
        boolean isRetryable = sdkErrorMetadata.isRetryable();
        AttributesImpl attributesImpl = sdkErrorMetadata.attributes;
        if (isRetryable) {
            ServiceException.ErrorType errorType = (ServiceException.ErrorType) attributesImpl.getOrNull(ServiceErrorMetadata.ErrorType);
            if (errorType == null) {
                errorType = ServiceException.ErrorType.Unknown;
            }
            if (errorType == ServiceException.ErrorType.Server) {
                return new RetryDirective.RetryError(RetryErrorType.ServerSide);
            }
        }
        if (sdkErrorMetadata.isRetryable()) {
            ServiceException.ErrorType errorType2 = (ServiceException.ErrorType) attributesImpl.getOrNull(ServiceErrorMetadata.ErrorType);
            if (errorType2 == null) {
                errorType2 = ServiceException.ErrorType.Unknown;
            }
            if (errorType2 == ServiceException.ErrorType.Client) {
                return new RetryDirective.RetryError(RetryErrorType.ClientSide);
            }
        }
        return null;
    }
}
