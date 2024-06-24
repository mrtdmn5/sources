package com.amazonaws.retry;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.retry.RetryPolicy;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Random;

/* loaded from: classes.dex */
public class PredefinedRetryPolicies {
    private static final int BASE_DELAY_IN_MILLISECONDS = 100;
    public static final int DEFAULT_MAX_ERROR_RETRY = 3;
    public static final int DYNAMODB_DEFAULT_MAX_ERROR_RETRY = 10;
    public static final RetryPolicy NO_RETRY_POLICY = new RetryPolicy(RetryPolicy.RetryCondition.NO_RETRY_CONDITION, RetryPolicy.BackoffStrategy.NO_DELAY, 0, false);
    public static final RetryPolicy.RetryCondition DEFAULT_RETRY_CONDITION = new SDKDefaultRetryCondition();
    private static final int MAX_BACKOFF_IN_MILLISECONDS = 20000;
    public static final RetryPolicy.BackoffStrategy DEFAULT_BACKOFF_STRATEGY = new SDKDefaultBackoffStrategy(100, MAX_BACKOFF_IN_MILLISECONDS);
    public static final RetryPolicy DEFAULT = getDefaultRetryPolicy();
    public static final RetryPolicy DYNAMODB_DEFAULT = getDynamoDBDefaultRetryPolicy();

    /* loaded from: classes.dex */
    public static final class SDKDefaultBackoffStrategy implements RetryPolicy.BackoffStrategy {
        private final int baseDelayMs;
        private final int maxDelayMs;
        private final Random random;

        @Override // com.amazonaws.retry.RetryPolicy.BackoffStrategy
        public final long delayBeforeNextRetry(AmazonWebServiceRequest amazonWebServiceRequest, AmazonClientException amazonClientException, int r4) {
            if (r4 <= 0) {
                return 0L;
            }
            return this.random.nextInt(Math.min(this.maxDelayMs, (1 << r4) * this.baseDelayMs));
        }

        private SDKDefaultBackoffStrategy(int r2, int r3) {
            this.random = new Random();
            this.baseDelayMs = r2;
            this.maxDelayMs = r3;
        }
    }

    /* loaded from: classes.dex */
    public static class SDKDefaultRetryCondition implements RetryPolicy.RetryCondition {
        @Override // com.amazonaws.retry.RetryPolicy.RetryCondition
        public boolean shouldRetry(AmazonWebServiceRequest amazonWebServiceRequest, AmazonClientException amazonClientException, int r4) {
            if ((amazonClientException.getCause() instanceof IOException) && !(amazonClientException.getCause() instanceof InterruptedIOException)) {
                return true;
            }
            if (amazonClientException instanceof AmazonServiceException) {
                AmazonServiceException amazonServiceException = (AmazonServiceException) amazonClientException;
                int statusCode = amazonServiceException.getStatusCode();
                if (statusCode == 500 || statusCode == 503 || statusCode == 502 || statusCode == 504 || RetryUtils.isThrottlingException(amazonServiceException) || RetryUtils.isClockSkewError(amazonServiceException)) {
                    return true;
                }
                return false;
            }
            return false;
        }
    }

    public static RetryPolicy getDefaultRetryPolicy() {
        return new RetryPolicy(DEFAULT_RETRY_CONDITION, DEFAULT_BACKOFF_STRATEGY, 3, true);
    }

    public static RetryPolicy getDefaultRetryPolicyWithCustomMaxRetries(int r4) {
        return new RetryPolicy(DEFAULT_RETRY_CONDITION, DEFAULT_BACKOFF_STRATEGY, r4, false);
    }

    public static RetryPolicy getDynamoDBDefaultRetryPolicy() {
        return new RetryPolicy(DEFAULT_RETRY_CONDITION, DEFAULT_BACKOFF_STRATEGY, 10, true);
    }

    public static RetryPolicy getDynamoDBDefaultRetryPolicyWithCustomMaxRetries(int r4) {
        return new RetryPolicy(DEFAULT_RETRY_CONDITION, DEFAULT_BACKOFF_STRATEGY, r4, false);
    }
}
