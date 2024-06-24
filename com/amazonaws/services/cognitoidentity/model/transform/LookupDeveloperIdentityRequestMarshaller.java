package com.amazonaws.services.cognitoidentity.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentity.model.LookupDeveloperIdentityRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;

/* loaded from: classes.dex */
public class LookupDeveloperIdentityRequestMarshaller implements Marshaller<Request<LookupDeveloperIdentityRequest>, LookupDeveloperIdentityRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<LookupDeveloperIdentityRequest> marshall(LookupDeveloperIdentityRequest lookupDeveloperIdentityRequest) {
        if (lookupDeveloperIdentityRequest != null) {
            DefaultRequest defaultRequest = new DefaultRequest(lookupDeveloperIdentityRequest, "AmazonCognitoIdentity");
            defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityService.LookupDeveloperIdentity");
            defaultRequest.setHttpMethod(HttpMethodName.POST);
            defaultRequest.setResourcePath("/");
            try {
                StringWriter stringWriter = new StringWriter();
                AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
                jsonWriter.beginObject();
                if (lookupDeveloperIdentityRequest.getIdentityPoolId() != null) {
                    String identityPoolId = lookupDeveloperIdentityRequest.getIdentityPoolId();
                    jsonWriter.name("IdentityPoolId");
                    jsonWriter.value(identityPoolId);
                }
                if (lookupDeveloperIdentityRequest.getIdentityId() != null) {
                    String identityId = lookupDeveloperIdentityRequest.getIdentityId();
                    jsonWriter.name("IdentityId");
                    jsonWriter.value(identityId);
                }
                if (lookupDeveloperIdentityRequest.getDeveloperUserIdentifier() != null) {
                    String developerUserIdentifier = lookupDeveloperIdentityRequest.getDeveloperUserIdentifier();
                    jsonWriter.name("DeveloperUserIdentifier");
                    jsonWriter.value(developerUserIdentifier);
                }
                if (lookupDeveloperIdentityRequest.getMaxResults() != null) {
                    Integer maxResults = lookupDeveloperIdentityRequest.getMaxResults();
                    jsonWriter.name("MaxResults");
                    jsonWriter.value(maxResults);
                }
                if (lookupDeveloperIdentityRequest.getNextToken() != null) {
                    String nextToken = lookupDeveloperIdentityRequest.getNextToken();
                    jsonWriter.name("NextToken");
                    jsonWriter.value(nextToken);
                }
                jsonWriter.endObject();
                jsonWriter.close();
                String stringWriter2 = stringWriter.toString();
                byte[] bytes = stringWriter2.getBytes(StringUtils.UTF8);
                defaultRequest.setContent(new StringInputStream(stringWriter2));
                defaultRequest.addHeader("Content-Length", Integer.toString(bytes.length));
                if (!defaultRequest.getHeaders().containsKey("Content-Type")) {
                    defaultRequest.addHeader("Content-Type", "application/x-amz-json-1.1");
                }
                return defaultRequest;
            } catch (Throwable th) {
                throw new AmazonClientException(CreateIdentityPoolRequestMarshaller$$ExternalSyntheticOutline0.m(th, new StringBuilder("Unable to marshall request to JSON: ")), th);
            }
        }
        throw new AmazonClientException("Invalid argument passed to marshall(LookupDeveloperIdentityRequest)");
    }
}
