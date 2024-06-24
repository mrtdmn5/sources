package com.amazonaws.services.lambda.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.lambda.model.ENILimitReachedException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: classes.dex */
public class ENILimitReachedExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public ENILimitReachedExceptionUnmarshaller() {
        super(ENILimitReachedException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("ENILimitReachedException");
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        ENILimitReachedException eNILimitReachedException = (ENILimitReachedException) super.unmarshall(jsonErrorResponse);
        eNILimitReachedException.setErrorCode("ENILimitReachedException");
        eNILimitReachedException.setType(String.valueOf(jsonErrorResponse.get("Type")));
        return eNILimitReachedException;
    }
}
