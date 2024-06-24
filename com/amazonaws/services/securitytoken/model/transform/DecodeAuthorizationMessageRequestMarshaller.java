package com.amazonaws.services.securitytoken.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.auth.policy.internal.JsonDocumentFields;
import com.amazonaws.services.securitytoken.model.DecodeAuthorizationMessageRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

/* loaded from: classes.dex */
public class DecodeAuthorizationMessageRequestMarshaller implements Marshaller<Request<DecodeAuthorizationMessageRequest>, DecodeAuthorizationMessageRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<DecodeAuthorizationMessageRequest> marshall(DecodeAuthorizationMessageRequest decodeAuthorizationMessageRequest) {
        if (decodeAuthorizationMessageRequest != null) {
            DefaultRequest defaultRequest = new DefaultRequest(decodeAuthorizationMessageRequest, "AWSSecurityTokenService");
            defaultRequest.addParameter(JsonDocumentFields.ACTION, "DecodeAuthorizationMessage");
            defaultRequest.addParameter(JsonDocumentFields.VERSION, "2011-06-15");
            if (decodeAuthorizationMessageRequest.getEncodedMessage() != null) {
                defaultRequest.addParameter("EncodedMessage", StringUtils.fromString(decodeAuthorizationMessageRequest.getEncodedMessage()));
            }
            return defaultRequest;
        }
        throw new AmazonClientException("Invalid argument passed to marshall(DecodeAuthorizationMessageRequest)");
    }
}
