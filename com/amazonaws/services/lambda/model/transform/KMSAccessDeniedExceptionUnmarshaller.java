package com.amazonaws.services.lambda.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.lambda.model.KMSAccessDeniedException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: classes.dex */
public class KMSAccessDeniedExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public KMSAccessDeniedExceptionUnmarshaller() {
        super(KMSAccessDeniedException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("KMSAccessDeniedException");
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        KMSAccessDeniedException kMSAccessDeniedException = (KMSAccessDeniedException) super.unmarshall(jsonErrorResponse);
        kMSAccessDeniedException.setErrorCode("KMSAccessDeniedException");
        kMSAccessDeniedException.setType(String.valueOf(jsonErrorResponse.get("Type")));
        return kMSAccessDeniedException;
    }
}
