package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentity.model.transform.CreateIdentityPoolRequestMarshaller$$ExternalSyntheticOutline0;
import com.amazonaws.services.kms.model.UpdateKeyDescriptionRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;

/* loaded from: classes.dex */
public class UpdateKeyDescriptionRequestMarshaller implements Marshaller<Request<UpdateKeyDescriptionRequest>, UpdateKeyDescriptionRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<UpdateKeyDescriptionRequest> marshall(UpdateKeyDescriptionRequest updateKeyDescriptionRequest) {
        if (updateKeyDescriptionRequest != null) {
            DefaultRequest defaultRequest = new DefaultRequest(updateKeyDescriptionRequest, "AWSKMS");
            defaultRequest.addHeader("X-Amz-Target", "TrentService.UpdateKeyDescription");
            defaultRequest.setHttpMethod(HttpMethodName.POST);
            defaultRequest.setResourcePath("/");
            try {
                StringWriter stringWriter = new StringWriter();
                AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
                jsonWriter.beginObject();
                if (updateKeyDescriptionRequest.getKeyId() != null) {
                    String keyId = updateKeyDescriptionRequest.getKeyId();
                    jsonWriter.name("KeyId");
                    jsonWriter.value(keyId);
                }
                if (updateKeyDescriptionRequest.getDescription() != null) {
                    String description = updateKeyDescriptionRequest.getDescription();
                    jsonWriter.name("Description");
                    jsonWriter.value(description);
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
        throw new AmazonClientException("Invalid argument passed to marshall(UpdateKeyDescriptionRequest)");
    }
}
