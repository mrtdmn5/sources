package com.amazonaws.services.cognitoidentity.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentity.model.GetOpenIdTokenForDeveloperIdentityRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import java.util.Map;

/* loaded from: classes.dex */
public class GetOpenIdTokenForDeveloperIdentityRequestMarshaller implements Marshaller<Request<GetOpenIdTokenForDeveloperIdentityRequest>, GetOpenIdTokenForDeveloperIdentityRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<GetOpenIdTokenForDeveloperIdentityRequest> marshall(GetOpenIdTokenForDeveloperIdentityRequest getOpenIdTokenForDeveloperIdentityRequest) {
        if (getOpenIdTokenForDeveloperIdentityRequest != null) {
            DefaultRequest defaultRequest = new DefaultRequest(getOpenIdTokenForDeveloperIdentityRequest, "AmazonCognitoIdentity");
            defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityService.GetOpenIdTokenForDeveloperIdentity");
            defaultRequest.setHttpMethod(HttpMethodName.POST);
            defaultRequest.setResourcePath("/");
            try {
                StringWriter stringWriter = new StringWriter();
                AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
                jsonWriter.beginObject();
                if (getOpenIdTokenForDeveloperIdentityRequest.getIdentityPoolId() != null) {
                    String identityPoolId = getOpenIdTokenForDeveloperIdentityRequest.getIdentityPoolId();
                    jsonWriter.name("IdentityPoolId");
                    jsonWriter.value(identityPoolId);
                }
                if (getOpenIdTokenForDeveloperIdentityRequest.getIdentityId() != null) {
                    String identityId = getOpenIdTokenForDeveloperIdentityRequest.getIdentityId();
                    jsonWriter.name("IdentityId");
                    jsonWriter.value(identityId);
                }
                if (getOpenIdTokenForDeveloperIdentityRequest.getLogins() != null) {
                    Map<String, String> logins = getOpenIdTokenForDeveloperIdentityRequest.getLogins();
                    jsonWriter.name("Logins");
                    jsonWriter.beginObject();
                    for (Map.Entry<String, String> entry : logins.entrySet()) {
                        String value = entry.getValue();
                        if (value != null) {
                            jsonWriter.name(entry.getKey());
                            jsonWriter.value(value);
                        }
                    }
                    jsonWriter.endObject();
                }
                if (getOpenIdTokenForDeveloperIdentityRequest.getPrincipalTags() != null) {
                    Map<String, String> principalTags = getOpenIdTokenForDeveloperIdentityRequest.getPrincipalTags();
                    jsonWriter.name("PrincipalTags");
                    jsonWriter.beginObject();
                    for (Map.Entry<String, String> entry2 : principalTags.entrySet()) {
                        String value2 = entry2.getValue();
                        if (value2 != null) {
                            jsonWriter.name(entry2.getKey());
                            jsonWriter.value(value2);
                        }
                    }
                    jsonWriter.endObject();
                }
                if (getOpenIdTokenForDeveloperIdentityRequest.getTokenDuration() != null) {
                    Long tokenDuration = getOpenIdTokenForDeveloperIdentityRequest.getTokenDuration();
                    jsonWriter.name("TokenDuration");
                    jsonWriter.value(tokenDuration);
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
        throw new AmazonClientException("Invalid argument passed to marshall(GetOpenIdTokenForDeveloperIdentityRequest)");
    }
}
