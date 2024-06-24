package com.amazonaws.services.lambda.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.lambda.model.InvalidRuntimeException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: classes.dex */
public class InvalidRuntimeExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public InvalidRuntimeExceptionUnmarshaller() {
        super(InvalidRuntimeException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("InvalidRuntimeException");
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        InvalidRuntimeException invalidRuntimeException = (InvalidRuntimeException) super.unmarshall(jsonErrorResponse);
        invalidRuntimeException.setErrorCode("InvalidRuntimeException");
        invalidRuntimeException.setType(String.valueOf(jsonErrorResponse.get("Type")));
        return invalidRuntimeException;
    }
}
