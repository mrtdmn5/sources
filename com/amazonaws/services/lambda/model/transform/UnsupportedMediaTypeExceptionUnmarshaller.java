package com.amazonaws.services.lambda.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.lambda.model.UnsupportedMediaTypeException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: classes.dex */
public class UnsupportedMediaTypeExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public UnsupportedMediaTypeExceptionUnmarshaller() {
        super(UnsupportedMediaTypeException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("UnsupportedMediaTypeException");
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        UnsupportedMediaTypeException unsupportedMediaTypeException = (UnsupportedMediaTypeException) super.unmarshall(jsonErrorResponse);
        unsupportedMediaTypeException.setErrorCode("UnsupportedMediaTypeException");
        unsupportedMediaTypeException.setType(String.valueOf(jsonErrorResponse.get("Type")));
        return unsupportedMediaTypeException;
    }
}
