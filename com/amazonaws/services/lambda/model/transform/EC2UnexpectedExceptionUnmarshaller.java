package com.amazonaws.services.lambda.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.lambda.model.EC2UnexpectedException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: classes.dex */
public class EC2UnexpectedExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public EC2UnexpectedExceptionUnmarshaller() {
        super(EC2UnexpectedException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("EC2UnexpectedException");
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        EC2UnexpectedException eC2UnexpectedException = (EC2UnexpectedException) super.unmarshall(jsonErrorResponse);
        eC2UnexpectedException.setErrorCode("EC2UnexpectedException");
        eC2UnexpectedException.setType(String.valueOf(jsonErrorResponse.get("Type")));
        eC2UnexpectedException.setEC2ErrorCode(String.valueOf(jsonErrorResponse.get("EC2ErrorCode")));
        return eC2UnexpectedException;
    }
}
