package com.amazonaws.retry;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonWebServiceRequest;

/* loaded from: classes.dex */
public final class RetryPolicy {
    private final BackoffStrategy backoffStrategy;
    private final boolean honorMaxErrorRetryInClientConfig;
    private final int maxErrorRetry;
    private final RetryCondition retryCondition;

    /* loaded from: classes.dex */
    public interface BackoffStrategy {
        public static final BackoffStrategy NO_DELAY = new BackoffStrategy() { // from class: com.amazonaws.retry.RetryPolicy.BackoffStrategy.1
            @Override // com.amazonaws.retry.RetryPolicy.BackoffStrategy
            public long delayBeforeNextRetry(AmazonWebServiceRequest amazonWebServiceRequest, AmazonClientException amazonClientException, int r3) {
                return 0L;
            }
        };

        long delayBeforeNextRetry(AmazonWebServiceRequest amazonWebServiceRequest, AmazonClientException amazonClientException, int r3);
    }

    /* loaded from: classes.dex */
    public interface RetryCondition {
        public static final RetryCondition NO_RETRY_CONDITION = new RetryCondition() { // from class: com.amazonaws.retry.RetryPolicy.RetryCondition.1
            @Override // com.amazonaws.retry.RetryPolicy.RetryCondition
            public boolean shouldRetry(AmazonWebServiceRequest amazonWebServiceRequest, AmazonClientException amazonClientException, int r3) {
                return false;
            }
        };

        boolean shouldRetry(AmazonWebServiceRequest amazonWebServiceRequest, AmazonClientException amazonClientException, int r3);
    }

    public RetryPolicy(RetryCondition retryCondition, BackoffStrategy backoffStrategy, int r3, boolean z) {
        retryCondition = retryCondition == null ? PredefinedRetryPolicies.DEFAULT_RETRY_CONDITION : retryCondition;
        backoffStrategy = backoffStrategy == null ? PredefinedRetryPolicies.DEFAULT_BACKOFF_STRATEGY : backoffStrategy;
        if (r3 >= 0) {
            this.retryCondition = retryCondition;
            this.backoffStrategy = backoffStrategy;
            this.maxErrorRetry = r3;
            this.honorMaxErrorRetryInClientConfig = z;
            return;
        }
        throw new IllegalArgumentException("Please provide a non-negative value for maxErrorRetry.");
    }

    public BackoffStrategy getBackoffStrategy() {
        return this.backoffStrategy;
    }

    public int getMaxErrorRetry() {
        return this.maxErrorRetry;
    }

    public RetryCondition getRetryCondition() {
        return this.retryCondition;
    }

    public boolean isMaxErrorRetryInClientConfigHonored() {
        return this.honorMaxErrorRetryInClientConfig;
    }
}
