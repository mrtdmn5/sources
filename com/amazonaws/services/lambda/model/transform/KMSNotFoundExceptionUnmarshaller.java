package com.amazonaws.services.lambda.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.lambda.model.KMSNotFoundException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: classes.dex */
public class KMSNotFoundExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public KMSNotFoundExceptionUnmarshaller() {
        super(KMSNotFoundException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("KMSNotFoundException");
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        KMSNotFoundException kMSNotFoundException = (KMSNotFoundException) super.unmarshall(jsonErrorResponse);
        kMSNotFoundException.setErrorCode("KMSNotFoundException");
        kMSNotFoundException.setType(String.valueOf(jsonErrorResponse.get("Type")));
        return kMSNotFoundException;
    }
}
