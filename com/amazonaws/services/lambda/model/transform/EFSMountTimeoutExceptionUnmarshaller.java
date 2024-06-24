package com.amazonaws.services.lambda.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.lambda.model.EFSMountTimeoutException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: classes.dex */
public class EFSMountTimeoutExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public EFSMountTimeoutExceptionUnmarshaller() {
        super(EFSMountTimeoutException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("EFSMountTimeoutException");
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        EFSMountTimeoutException eFSMountTimeoutException = (EFSMountTimeoutException) super.unmarshall(jsonErrorResponse);
        eFSMountTimeoutException.setErrorCode("EFSMountTimeoutException");
        eFSMountTimeoutException.setType(String.valueOf(jsonErrorResponse.get("Type")));
        return eFSMountTimeoutException;
    }
}
