package com.amazonaws.services.lambda.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.lambda.model.ResourceNotReadyException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: classes.dex */
public class ResourceNotReadyExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public ResourceNotReadyExceptionUnmarshaller() {
        super(ResourceNotReadyException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("ResourceNotReadyException");
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        ResourceNotReadyException resourceNotReadyException = (ResourceNotReadyException) super.unmarshall(jsonErrorResponse);
        resourceNotReadyException.setErrorCode("ResourceNotReadyException");
        resourceNotReadyException.setType(String.valueOf(jsonErrorResponse.get("Type")));
        return resourceNotReadyException;
    }
}
