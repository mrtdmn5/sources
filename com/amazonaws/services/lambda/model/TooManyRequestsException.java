package com.amazonaws.services.lambda.model;

import com.amazonaws.AmazonServiceException;

/* loaded from: classes.dex */
public class TooManyRequestsException extends AmazonServiceException {
    private static final long serialVersionUID = 1;
    private String reason;
    private String retryAfterSeconds;
    private String type;

    public TooManyRequestsException(String str) {
        super(str);
    }

    public String getReason() {
        return this.reason;
    }

    public String getRetryAfterSeconds() {
        return this.retryAfterSeconds;
    }

    public String getType() {
        return this.type;
    }

    public void setReason(String str) {
        this.reason = str;
    }

    public void setRetryAfterSeconds(String str) {
        this.retryAfterSeconds = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
