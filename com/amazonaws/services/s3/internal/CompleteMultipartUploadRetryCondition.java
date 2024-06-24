package com.amazonaws.services.s3.internal;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.retry.RetryPolicy;
import com.amazonaws.services.s3.model.AmazonS3Exception;

/* loaded from: classes.dex */
public class CompleteMultipartUploadRetryCondition implements RetryPolicy.RetryCondition {
    private static final String ERROR_CODE = "InternalError";
    private static final int MAX_RETRY_ATTEMPTS = 3;
    private static final String RETYABLE_ERROR_MESSAGE = "Please try again.";
    private final int maxCompleteMultipartUploadRetries;

    public CompleteMultipartUploadRetryCondition() {
        this(3);
    }

    @Override // com.amazonaws.retry.RetryPolicy.RetryCondition
    public boolean shouldRetry(AmazonWebServiceRequest amazonWebServiceRequest, AmazonClientException amazonClientException, int r4) {
        if (!(amazonClientException instanceof AmazonS3Exception) || !test((AmazonS3Exception) amazonClientException) || r4 >= this.maxCompleteMultipartUploadRetries) {
            return false;
        }
        return true;
    }

    public boolean test(AmazonS3Exception amazonS3Exception) {
        if (amazonS3Exception == null || amazonS3Exception.getErrorCode() == null || amazonS3Exception.getErrorMessage() == null || !amazonS3Exception.getErrorCode().contains(ERROR_CODE) || !amazonS3Exception.getErrorMessage().contains(RETYABLE_ERROR_MESSAGE)) {
            return false;
        }
        return true;
    }

    public CompleteMultipartUploadRetryCondition(int r1) {
        this.maxCompleteMultipartUploadRetries = r1;
    }
}
