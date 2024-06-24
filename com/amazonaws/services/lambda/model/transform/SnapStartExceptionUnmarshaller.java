package com.amazonaws.services.lambda.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.lambda.model.SnapStartException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: classes.dex */
public class SnapStartExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public SnapStartExceptionUnmarshaller() {
        super(SnapStartException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("SnapStartException");
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        SnapStartException snapStartException = (SnapStartException) super.unmarshall(jsonErrorResponse);
        snapStartException.setErrorCode("SnapStartException");
        snapStartException.setType(String.valueOf(jsonErrorResponse.get("Type")));
        return snapStartException;
    }
}
