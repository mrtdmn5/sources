package com.amazonaws.services.lambda.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.lambda.model.ServiceException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: classes.dex */
public class ServiceExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public ServiceExceptionUnmarshaller() {
        super(ServiceException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("ServiceException");
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        ServiceException serviceException = (ServiceException) super.unmarshall(jsonErrorResponse);
        serviceException.setErrorCode("ServiceException");
        serviceException.setType(String.valueOf(jsonErrorResponse.get("Type")));
        return serviceException;
    }
}
