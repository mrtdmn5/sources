package com.amazonaws.services.lambda.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.lambda.model.InvalidSecurityGroupIDException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: classes.dex */
public class InvalidSecurityGroupIDExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public InvalidSecurityGroupIDExceptionUnmarshaller() {
        super(InvalidSecurityGroupIDException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("InvalidSecurityGroupIDException");
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        InvalidSecurityGroupIDException invalidSecurityGroupIDException = (InvalidSecurityGroupIDException) super.unmarshall(jsonErrorResponse);
        invalidSecurityGroupIDException.setErrorCode("InvalidSecurityGroupIDException");
        invalidSecurityGroupIDException.setType(String.valueOf(jsonErrorResponse.get("Type")));
        return invalidSecurityGroupIDException;
    }
}
