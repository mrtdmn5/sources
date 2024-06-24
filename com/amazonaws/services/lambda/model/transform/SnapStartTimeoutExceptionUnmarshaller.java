package com.amazonaws.services.lambda.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.lambda.model.SnapStartTimeoutException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: classes.dex */
public class SnapStartTimeoutExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public SnapStartTimeoutExceptionUnmarshaller() {
        super(SnapStartTimeoutException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("SnapStartTimeoutException");
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        SnapStartTimeoutException snapStartTimeoutException = (SnapStartTimeoutException) super.unmarshall(jsonErrorResponse);
        snapStartTimeoutException.setErrorCode("SnapStartTimeoutException");
        snapStartTimeoutException.setType(String.valueOf(jsonErrorResponse.get("Type")));
        return snapStartTimeoutException;
    }
}
