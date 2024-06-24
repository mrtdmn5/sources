package com.amazonaws.services.securitytoken.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.auth.policy.internal.JsonDocumentFields;
import com.amazonaws.services.securitytoken.model.GetSessionTokenRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

/* loaded from: classes.dex */
public class GetSessionTokenRequestMarshaller implements Marshaller<Request<GetSessionTokenRequest>, GetSessionTokenRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<GetSessionTokenRequest> marshall(GetSessionTokenRequest getSessionTokenRequest) {
        if (getSessionTokenRequest != null) {
            DefaultRequest defaultRequest = new DefaultRequest(getSessionTokenRequest, "AWSSecurityTokenService");
            defaultRequest.addParameter(JsonDocumentFields.ACTION, "GetSessionToken");
            defaultRequest.addParameter(JsonDocumentFields.VERSION, "2011-06-15");
            if (getSessionTokenRequest.getDurationSeconds() != null) {
                defaultRequest.addParameter("DurationSeconds", StringUtils.fromInteger(getSessionTokenRequest.getDurationSeconds()));
            }
            if (getSessionTokenRequest.getSerialNumber() != null) {
                defaultRequest.addParameter("SerialNumber", StringUtils.fromString(getSessionTokenRequest.getSerialNumber()));
            }
            if (getSessionTokenRequest.getTokenCode() != null) {
                defaultRequest.addParameter("TokenCode", StringUtils.fromString(getSessionTokenRequest.getTokenCode()));
            }
            return defaultRequest;
        }
        throw new AmazonClientException("Invalid argument passed to marshall(GetSessionTokenRequest)");
    }
}
