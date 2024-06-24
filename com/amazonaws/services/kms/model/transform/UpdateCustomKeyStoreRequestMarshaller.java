package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentity.model.transform.CreateIdentityPoolRequestMarshaller$$ExternalSyntheticOutline0;
import com.amazonaws.services.kms.model.UpdateCustomKeyStoreRequest;
import com.amazonaws.services.kms.model.XksProxyAuthenticationCredentialType;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;

/* loaded from: classes.dex */
public class UpdateCustomKeyStoreRequestMarshaller implements Marshaller<Request<UpdateCustomKeyStoreRequest>, UpdateCustomKeyStoreRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<UpdateCustomKeyStoreRequest> marshall(UpdateCustomKeyStoreRequest updateCustomKeyStoreRequest) {
        if (updateCustomKeyStoreRequest != null) {
            DefaultRequest defaultRequest = new DefaultRequest(updateCustomKeyStoreRequest, "AWSKMS");
            defaultRequest.addHeader("X-Amz-Target", "TrentService.UpdateCustomKeyStore");
            defaultRequest.setHttpMethod(HttpMethodName.POST);
            defaultRequest.setResourcePath("/");
            try {
                StringWriter stringWriter = new StringWriter();
                AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
                jsonWriter.beginObject();
                if (updateCustomKeyStoreRequest.getCustomKeyStoreId() != null) {
                    String customKeyStoreId = updateCustomKeyStoreRequest.getCustomKeyStoreId();
                    jsonWriter.name("CustomKeyStoreId");
                    jsonWriter.value(customKeyStoreId);
                }
                if (updateCustomKeyStoreRequest.getNewCustomKeyStoreName() != null) {
                    String newCustomKeyStoreName = updateCustomKeyStoreRequest.getNewCustomKeyStoreName();
                    jsonWriter.name("NewCustomKeyStoreName");
                    jsonWriter.value(newCustomKeyStoreName);
                }
                if (updateCustomKeyStoreRequest.getKeyStorePassword() != null) {
                    String keyStorePassword = updateCustomKeyStoreRequest.getKeyStorePassword();
                    jsonWriter.name("KeyStorePassword");
                    jsonWriter.value(keyStorePassword);
                }
                if (updateCustomKeyStoreRequest.getCloudHsmClusterId() != null) {
                    String cloudHsmClusterId = updateCustomKeyStoreRequest.getCloudHsmClusterId();
                    jsonWriter.name("CloudHsmClusterId");
                    jsonWriter.value(cloudHsmClusterId);
                }
                if (updateCustomKeyStoreRequest.getXksProxyUriEndpoint() != null) {
                    String xksProxyUriEndpoint = updateCustomKeyStoreRequest.getXksProxyUriEndpoint();
                    jsonWriter.name("XksProxyUriEndpoint");
                    jsonWriter.value(xksProxyUriEndpoint);
                }
                if (updateCustomKeyStoreRequest.getXksProxyUriPath() != null) {
                    String xksProxyUriPath = updateCustomKeyStoreRequest.getXksProxyUriPath();
                    jsonWriter.name("XksProxyUriPath");
                    jsonWriter.value(xksProxyUriPath);
                }
                if (updateCustomKeyStoreRequest.getXksProxyVpcEndpointServiceName() != null) {
                    String xksProxyVpcEndpointServiceName = updateCustomKeyStoreRequest.getXksProxyVpcEndpointServiceName();
                    jsonWriter.name("XksProxyVpcEndpointServiceName");
                    jsonWriter.value(xksProxyVpcEndpointServiceName);
                }
                if (updateCustomKeyStoreRequest.getXksProxyAuthenticationCredential() != null) {
                    XksProxyAuthenticationCredentialType xksProxyAuthenticationCredential = updateCustomKeyStoreRequest.getXksProxyAuthenticationCredential();
                    jsonWriter.name("XksProxyAuthenticationCredential");
                    XksProxyAuthenticationCredentialTypeJsonMarshaller.getInstance().marshall(xksProxyAuthenticationCredential, jsonWriter);
                }
                if (updateCustomKeyStoreRequest.getXksProxyConnectivity() != null) {
                    String xksProxyConnectivity = updateCustomKeyStoreRequest.getXksProxyConnectivity();
                    jsonWriter.name("XksProxyConnectivity");
                    jsonWriter.value(xksProxyConnectivity);
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
        throw new AmazonClientException("Invalid argument passed to marshall(UpdateCustomKeyStoreRequest)");
    }
}
