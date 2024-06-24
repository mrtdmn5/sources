package com.amazonaws.services.lambda.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.lambda.model.EC2AccessDeniedException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: classes.dex */
public class EC2AccessDeniedExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public EC2AccessDeniedExceptionUnmarshaller() {
        super(EC2AccessDeniedException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("EC2AccessDeniedException");
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        EC2AccessDeniedException eC2AccessDeniedException = (EC2AccessDeniedException) super.unmarshall(jsonErrorResponse);
        eC2AccessDeniedException.setErrorCode("EC2AccessDeniedException");
        eC2AccessDeniedException.setType(String.valueOf(jsonErrorResponse.get("Type")));
        return eC2AccessDeniedException;
    }
}
