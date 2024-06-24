package com.amazonaws.retry;

import com.amazonaws.AbortedException;
import com.amazonaws.AmazonServiceException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;

/* loaded from: classes.dex */
public class RetryUtils {
    public static boolean isClockSkewError(AmazonServiceException amazonServiceException) {
        if (amazonServiceException == null) {
            return false;
        }
        String errorCode = amazonServiceException.getErrorCode();
        if (!"RequestTimeTooSkewed".equals(errorCode) && !"RequestExpired".equals(errorCode) && !"InvalidSignatureException".equals(errorCode) && !"SignatureDoesNotMatch".equals(errorCode)) {
            return false;
        }
        return true;
    }

    public static boolean isInterrupted(Throwable th) {
        if (th instanceof AbortedException) {
            return true;
        }
        if (th.getCause() != null) {
            Throwable cause = th.getCause();
            if ((cause instanceof InterruptedException) || ((cause instanceof InterruptedIOException) && !(cause instanceof SocketTimeoutException))) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static boolean isRequestEntityTooLargeException(AmazonServiceException amazonServiceException) {
        if (amazonServiceException == null) {
            return false;
        }
        return "Request entity too large".equals(amazonServiceException.getErrorCode());
    }

    public static boolean isThrottlingException(AmazonServiceException amazonServiceException) {
        if (amazonServiceException == null) {
            return false;
        }
        String errorCode = amazonServiceException.getErrorCode();
        if (!"Throttling".equals(errorCode) && !"ThrottlingException".equals(errorCode) && !"ProvisionedThroughputExceededException".equals(errorCode)) {
            return false;
        }
        return true;
    }
}
