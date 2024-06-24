package com.amazonaws.services.securitytoken.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.auth.policy.internal.JsonDocumentFields;
import com.amazonaws.services.securitytoken.model.GetCallerIdentityRequest;
import com.amazonaws.transform.Marshaller;

/* loaded from: classes.dex */
public class GetCallerIdentityRequestMarshaller implements Marshaller<Request<GetCallerIdentityRequest>, GetCallerIdentityRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<GetCallerIdentityRequest> marshall(GetCallerIdentityRequest getCallerIdentityRequest) {
        if (getCallerIdentityRequest != null) {
            DefaultRequest defaultRequest = new DefaultRequest(getCallerIdentityRequest, "AWSSecurityTokenService");
            defaultRequest.addParameter(JsonDocumentFields.ACTION, "GetCallerIdentity");
            defaultRequest.addParameter(JsonDocumentFields.VERSION, "2011-06-15");
            return defaultRequest;
        }
        throw new AmazonClientException("Invalid argument passed to marshall(GetCallerIdentityRequest)");
    }
}
