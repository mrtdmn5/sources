package com.amazonaws.services.lambda.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.lambda.model.InvalidRequestContentException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: classes.dex */
public class InvalidRequestContentExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public InvalidRequestContentExceptionUnmarshaller() {
        super(InvalidRequestContentException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("InvalidRequestContentException");
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        InvalidRequestContentException invalidRequestContentException = (InvalidRequestContentException) super.unmarshall(jsonErrorResponse);
        invalidRequestContentException.setErrorCode("InvalidRequestContentException");
        invalidRequestContentException.setType(String.valueOf(jsonErrorResponse.get("Type")));
        return invalidRequestContentException;
    }
}
