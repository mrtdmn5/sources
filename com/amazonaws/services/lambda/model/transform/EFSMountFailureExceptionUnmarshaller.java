package com.amazonaws.services.lambda.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.lambda.model.EFSMountFailureException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: classes.dex */
public class EFSMountFailureExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public EFSMountFailureExceptionUnmarshaller() {
        super(EFSMountFailureException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("EFSMountFailureException");
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        EFSMountFailureException eFSMountFailureException = (EFSMountFailureException) super.unmarshall(jsonErrorResponse);
        eFSMountFailureException.setErrorCode("EFSMountFailureException");
        eFSMountFailureException.setType(String.valueOf(jsonErrorResponse.get("Type")));
        return eFSMountFailureException;
    }
}
