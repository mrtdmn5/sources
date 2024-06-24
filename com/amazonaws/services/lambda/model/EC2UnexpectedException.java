package com.amazonaws.services.lambda.model;

import com.amazonaws.AmazonServiceException;

/* loaded from: classes.dex */
public class EC2UnexpectedException extends AmazonServiceException {
    private static final long serialVersionUID = 1;
    private String eC2ErrorCode;
    private String type;

    public EC2UnexpectedException(String str) {
        super(str);
    }

    public String getEC2ErrorCode() {
        return this.eC2ErrorCode;
    }

    public String getType() {
        return this.type;
    }

    public void setEC2ErrorCode(String str) {
        this.eC2ErrorCode = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
