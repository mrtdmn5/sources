package com.amazonaws.services.lambda.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.lambda.model.EFSMountConnectivityException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: classes.dex */
public class EFSMountConnectivityExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public EFSMountConnectivityExceptionUnmarshaller() {
        super(EFSMountConnectivityException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("EFSMountConnectivityException");
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        EFSMountConnectivityException eFSMountConnectivityException = (EFSMountConnectivityException) super.unmarshall(jsonErrorResponse);
        eFSMountConnectivityException.setErrorCode("EFSMountConnectivityException");
        eFSMountConnectivityException.setType(String.valueOf(jsonErrorResponse.get("Type")));
        return eFSMountConnectivityException;
    }
}
