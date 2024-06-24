package com.amazonaws.services.lambda.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.lambda.model.RequestTooLargeException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: classes.dex */
public class RequestTooLargeExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public RequestTooLargeExceptionUnmarshaller() {
        super(RequestTooLargeException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("RequestTooLargeException");
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        RequestTooLargeException requestTooLargeException = (RequestTooLargeException) super.unmarshall(jsonErrorResponse);
        requestTooLargeException.setErrorCode("RequestTooLargeException");
        requestTooLargeException.setType(String.valueOf(jsonErrorResponse.get("Type")));
        return requestTooLargeException;
    }
}
