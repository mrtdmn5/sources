package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.kms.model.XksProxyUriUnreachableException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: classes.dex */
public class XksProxyUriUnreachableExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public XksProxyUriUnreachableExceptionUnmarshaller() {
        super(XksProxyUriUnreachableException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("XksProxyUriUnreachableException");
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        XksProxyUriUnreachableException xksProxyUriUnreachableException = (XksProxyUriUnreachableException) super.unmarshall(jsonErrorResponse);
        xksProxyUriUnreachableException.setErrorCode("XksProxyUriUnreachableException");
        return xksProxyUriUnreachableException;
    }
}
