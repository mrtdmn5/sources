package com.amazonaws.services.lambda.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.lambda.model.TooManyRequestsException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: classes.dex */
public class TooManyRequestsExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public TooManyRequestsExceptionUnmarshaller() {
        super(TooManyRequestsException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("TooManyRequestsException");
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        TooManyRequestsException tooManyRequestsException = (TooManyRequestsException) super.unmarshall(jsonErrorResponse);
        tooManyRequestsException.setErrorCode("TooManyRequestsException");
        tooManyRequestsException.setRetryAfterSeconds(String.valueOf(jsonErrorResponse.get("retryAfterSeconds")));
        tooManyRequestsException.setType(String.valueOf(jsonErrorResponse.get("Type")));
        tooManyRequestsException.setReason(String.valueOf(jsonErrorResponse.get("Reason")));
        return tooManyRequestsException;
    }
}
