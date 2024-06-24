package com.amazonaws.services.lambda.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.lambda.model.EFSIOException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: classes.dex */
public class EFSIOExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public EFSIOExceptionUnmarshaller() {
        super(EFSIOException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("EFSIOException");
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        EFSIOException eFSIOException = (EFSIOException) super.unmarshall(jsonErrorResponse);
        eFSIOException.setErrorCode("EFSIOException");
        eFSIOException.setType(String.valueOf(jsonErrorResponse.get("Type")));
        return eFSIOException;
    }
}
