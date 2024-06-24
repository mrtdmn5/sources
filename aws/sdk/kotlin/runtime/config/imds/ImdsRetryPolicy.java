package aws.sdk.kotlin.runtime.config.imds;

import aws.smithy.kotlin.runtime.http.HttpStatusCode;
import aws.smithy.kotlin.runtime.retries.policy.RetryDirective;
import aws.smithy.kotlin.runtime.retries.policy.RetryErrorType;
import aws.smithy.kotlin.runtime.retries.policy.RetryPolicy;
import java.util.Map;
import kotlin.Result;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import mu.KLogger;
import mu.internal.LocationAwareKLogger;
import mu.internal.LocationIgnorantKLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LocationAwareLogger;

/* compiled from: ImdsRetryPolicy.kt */
/* loaded from: classes.dex */
public final class ImdsRetryPolicy implements RetryPolicy<Object> {
    @Override // aws.smithy.kotlin.runtime.retries.policy.RetryPolicy
    public final RetryDirective evaluate(Object obj) {
        int r6;
        HttpStatusCode.Category category;
        KLogger locationIgnorantKLogger;
        IntRange intRange;
        boolean z;
        if (!(obj instanceof Result.Failure)) {
            return RetryDirective.TerminateAndSucceed.INSTANCE;
        }
        final Throwable m1661exceptionOrNullimpl = Result.m1661exceptionOrNullimpl(obj);
        Intrinsics.checkNotNull(m1661exceptionOrNullimpl);
        if (m1661exceptionOrNullimpl instanceof EC2MetadataError) {
            HttpStatusCode httpStatusCode = HttpStatusCode.OK;
            Map<Integer, HttpStatusCode> map = HttpStatusCode.byValue;
            int r0 = ((EC2MetadataError) m1661exceptionOrNullimpl).statusCode;
            HttpStatusCode httpStatusCode2 = map.get(Integer.valueOf(r0));
            if (httpStatusCode2 == null) {
                httpStatusCode2 = new HttpStatusCode(r0, "Unknown HttpStatusCode");
            }
            HttpStatusCode.Category.Companion.getClass();
            HttpStatusCode.Category[] values = HttpStatusCode.Category.values();
            int length = values.length;
            int r5 = 0;
            while (true) {
                r6 = httpStatusCode2.value;
                if (r5 < length) {
                    category = values[r5];
                    intRange = category.range;
                    int r9 = intRange.first;
                    if (r6 <= intRange.last && r9 <= r6) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        break;
                    }
                    r5++;
                } else {
                    category = null;
                    break;
                }
            }
            if (category != null) {
                if (category == HttpStatusCode.Category.SERVER_ERROR) {
                    return new RetryDirective.RetryError(RetryErrorType.ServerSide);
                }
                if (Intrinsics.areEqual(httpStatusCode2, HttpStatusCode.Unauthorized)) {
                    return new RetryDirective.RetryError(RetryErrorType.ServerSide);
                }
                String qualifiedName = Reflection.getOrCreateKotlinClass(ImdsRetryPolicy.class).getQualifiedName();
                if (qualifiedName != null) {
                    Logger logger = LoggerFactory.getLogger(qualifiedName);
                    Intrinsics.checkNotNullExpressionValue(logger, "LoggerFactory.getLogger(name)");
                    if (logger instanceof LocationAwareLogger) {
                        locationIgnorantKLogger = new LocationAwareKLogger((LocationAwareLogger) logger);
                    } else {
                        locationIgnorantKLogger = new LocationIgnorantKLogger(logger);
                    }
                    locationIgnorantKLogger.debug(new Function0<Object>() { // from class: aws.sdk.kotlin.runtime.config.imds.ImdsRetryPolicy$evaluate$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            StringBuilder sb = new StringBuilder("Non retryable IMDS error: statusCode=");
                            Throwable th = m1661exceptionOrNullimpl;
                            sb.append(((EC2MetadataError) th).statusCode);
                            sb.append("; ");
                            sb.append(th.getMessage());
                            return sb.toString();
                        }
                    });
                    return RetryDirective.TerminateAndFail.INSTANCE;
                }
                throw new IllegalArgumentException("getLogger<T> cannot be used on an anonymous object".toString());
            }
            throw new IllegalStateException(("Invalid HTTP code " + r6).toString());
        }
        return RetryDirective.TerminateAndFail.INSTANCE;
    }
}
