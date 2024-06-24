package com.amazonaws.services.lambda.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.lambda.model.InvalidSubnetIDException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: classes.dex */
public class InvalidSubnetIDExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public InvalidSubnetIDExceptionUnmarshaller() {
        super(InvalidSubnetIDException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("InvalidSubnetIDException");
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        InvalidSubnetIDException invalidSubnetIDException = (InvalidSubnetIDException) super.unmarshall(jsonErrorResponse);
        invalidSubnetIDException.setErrorCode("InvalidSubnetIDException");
        invalidSubnetIDException.setType(String.valueOf(jsonErrorResponse.get("Type")));
        return invalidSubnetIDException;
    }
}
