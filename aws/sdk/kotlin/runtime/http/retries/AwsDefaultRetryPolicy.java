package aws.sdk.kotlin.runtime.http.retries;

import aws.smithy.kotlin.runtime.EmptyProtocolResponse;
import aws.smithy.kotlin.runtime.ProtocolResponse;
import aws.smithy.kotlin.runtime.ServiceErrorMetadata;
import aws.smithy.kotlin.runtime.ServiceException;
import aws.smithy.kotlin.runtime.http.HttpStatusCode;
import aws.smithy.kotlin.runtime.http.response.HttpResponse;
import aws.smithy.kotlin.runtime.retries.policy.RetryDirective;
import aws.smithy.kotlin.runtime.retries.policy.RetryErrorType;
import aws.smithy.kotlin.runtime.retries.policy.StandardRetryPolicy;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AwsDefaultRetryPolicy.kt */
/* loaded from: classes.dex */
public final class AwsDefaultRetryPolicy extends StandardRetryPolicy {
    public static final AwsDefaultRetryPolicy INSTANCE = new AwsDefaultRetryPolicy();
    public static final Map<String, RetryErrorType> knownErrorTypes;
    public static final Map<Integer, RetryErrorType> knownStatusCodes;

    static {
        RetryErrorType retryErrorType = RetryErrorType.Throttling;
        Pair pair = new Pair("BandwidthLimitExceeded", retryErrorType);
        Pair pair2 = new Pair("EC2ThrottledException", retryErrorType);
        RetryErrorType retryErrorType2 = RetryErrorType.Timeout;
        knownErrorTypes = MapsKt__MapsKt.mapOf(pair, pair2, new Pair("IDPCommunicationError", retryErrorType2), new Pair("LimitExceededException", retryErrorType), new Pair("PriorRequestNotComplete", retryErrorType), new Pair("ProvisionedThroughputExceededException", retryErrorType), new Pair("RequestLimitExceeded", retryErrorType), new Pair("RequestThrottled", retryErrorType), new Pair("RequestThrottledException", retryErrorType), new Pair("RequestTimeout", retryErrorType2), new Pair("RequestTimeoutException", retryErrorType2), new Pair("SlowDown", retryErrorType), new Pair("ThrottledException", retryErrorType), new Pair("Throttling", retryErrorType), new Pair("ThrottlingException", retryErrorType), new Pair("TooManyRequestsException", retryErrorType), new Pair("TransactionInProgressException", retryErrorType));
        knownStatusCodes = MapsKt__MapsKt.mapOf(new Pair(500, retryErrorType2), new Pair(502, retryErrorType2), new Pair(503, retryErrorType2), new Pair(504, retryErrorType2));
    }

    @Override // aws.smithy.kotlin.runtime.retries.policy.StandardRetryPolicy
    public final RetryDirective evaluateSpecificExceptions(Throwable ex) {
        HttpResponse httpResponse;
        Integer num;
        HttpStatusCode httpStatusCode;
        Intrinsics.checkNotNullParameter(ex, "ex");
        if (!(ex instanceof ServiceException)) {
            return null;
        }
        ServiceErrorMetadata sdkErrorMetadata = ((ServiceException) ex).getSdkErrorMetadata();
        RetryErrorType retryErrorType = knownErrorTypes.get((String) sdkErrorMetadata.attributes.getOrNull(ServiceErrorMetadata.ErrorCode));
        if (retryErrorType == null) {
            Map<Integer, RetryErrorType> map = knownStatusCodes;
            INSTANCE.getClass();
            Object obj = (ProtocolResponse) sdkErrorMetadata.attributes.getOrNull(ServiceErrorMetadata.ProtocolResponse);
            if (obj == null) {
                obj = EmptyProtocolResponse.INSTANCE;
            }
            if (obj instanceof HttpResponse) {
                httpResponse = (HttpResponse) obj;
            } else {
                httpResponse = null;
            }
            if (httpResponse != null && (httpStatusCode = httpResponse.status) != null) {
                num = Integer.valueOf(httpStatusCode.value);
            } else {
                num = null;
            }
            retryErrorType = map.get(num);
        }
        if (retryErrorType == null) {
            return null;
        }
        return new RetryDirective.RetryError(retryErrorType);
    }
}
