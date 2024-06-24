package com.amazonaws.services.lambda.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.lambda.model.EC2ThrottledException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: classes.dex */
public class EC2ThrottledExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public EC2ThrottledExceptionUnmarshaller() {
        super(EC2ThrottledException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("EC2ThrottledException");
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        EC2ThrottledException eC2ThrottledException = (EC2ThrottledException) super.unmarshall(jsonErrorResponse);
        eC2ThrottledException.setErrorCode("EC2ThrottledException");
        eC2ThrottledException.setType(String.valueOf(jsonErrorResponse.get("Type")));
        return eC2ThrottledException;
    }
}
