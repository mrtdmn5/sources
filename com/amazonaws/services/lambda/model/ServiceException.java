package com.amazonaws.services.lambda.model;

import com.amazonaws.AmazonServiceException;

/* loaded from: classes.dex */
public class ServiceException extends AmazonServiceException {
    private static final long serialVersionUID = 1;
    private String type;

    public ServiceException(String str) {
        super(str);
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }
}
