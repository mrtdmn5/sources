package com.amazonaws.services.lambda.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.lambda.model.InvalidZipFileException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: classes.dex */
public class InvalidZipFileExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public InvalidZipFileExceptionUnmarshaller() {
        super(InvalidZipFileException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("InvalidZipFileException");
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        InvalidZipFileException invalidZipFileException = (InvalidZipFileException) super.unmarshall(jsonErrorResponse);
        invalidZipFileException.setErrorCode("InvalidZipFileException");
        invalidZipFileException.setType(String.valueOf(jsonErrorResponse.get("Type")));
        return invalidZipFileException;
    }
}
