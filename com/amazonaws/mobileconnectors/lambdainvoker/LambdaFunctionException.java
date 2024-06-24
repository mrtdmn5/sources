package com.amazonaws.mobileconnectors.lambdainvoker;

import com.amazonaws.AmazonClientException;

/* loaded from: classes.dex */
public class LambdaFunctionException extends AmazonClientException {
    private static final long serialVersionUID = 6674259958957646199L;
    private final String details;

    public LambdaFunctionException(String str, String str2) {
        super(str);
        this.details = str2;
    }

    public String getDetails() {
        return this.details;
    }
}
