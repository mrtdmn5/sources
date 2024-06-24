package com.amazonaws.services.lambda.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.lambda.model.SnapStartNotReadyException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: classes.dex */
public class SnapStartNotReadyExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public SnapStartNotReadyExceptionUnmarshaller() {
        super(SnapStartNotReadyException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("SnapStartNotReadyException");
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        SnapStartNotReadyException snapStartNotReadyException = (SnapStartNotReadyException) super.unmarshall(jsonErrorResponse);
        snapStartNotReadyException.setErrorCode("SnapStartNotReadyException");
        snapStartNotReadyException.setType(String.valueOf(jsonErrorResponse.get("Type")));
        return snapStartNotReadyException;
    }
}
