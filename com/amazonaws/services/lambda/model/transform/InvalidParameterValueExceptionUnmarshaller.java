package com.amazonaws.services.lambda.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.lambda.model.InvalidParameterValueException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: classes.dex */
public class InvalidParameterValueExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public InvalidParameterValueExceptionUnmarshaller() {
        super(InvalidParameterValueException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("InvalidParameterValueException");
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        InvalidParameterValueException invalidParameterValueException = (InvalidParameterValueException) super.unmarshall(jsonErrorResponse);
        invalidParameterValueException.setErrorCode("InvalidParameterValueException");
        invalidParameterValueException.setType(String.valueOf(jsonErrorResponse.get("Type")));
        return invalidParameterValueException;
    }
}
