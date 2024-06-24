package com.amazonaws.services.cognitoidentity.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentity.model.DeleteIdentitiesRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import java.util.List;

/* loaded from: classes.dex */
public class DeleteIdentitiesRequestMarshaller implements Marshaller<Request<DeleteIdentitiesRequest>, DeleteIdentitiesRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<DeleteIdentitiesRequest> marshall(DeleteIdentitiesRequest deleteIdentitiesRequest) {
        if (deleteIdentitiesRequest != null) {
            DefaultRequest defaultRequest = new DefaultRequest(deleteIdentitiesRequest, "AmazonCognitoIdentity");
            defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityService.DeleteIdentities");
            defaultRequest.setHttpMethod(HttpMethodName.POST);
            defaultRequest.setResourcePath("/");
            try {
                StringWriter stringWriter = new StringWriter();
                AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
                jsonWriter.beginObject();
                if (deleteIdentitiesRequest.getIdentityIdsToDelete() != null) {
                    List<String> identityIdsToDelete = deleteIdentitiesRequest.getIdentityIdsToDelete();
                    jsonWriter.name("IdentityIdsToDelete");
                    jsonWriter.beginArray();
                    for (String str : identityIdsToDelete) {
                        if (str != null) {
                            jsonWriter.value(str);
                        }
                    }
                    jsonWriter.endArray();
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
        throw new AmazonClientException("Invalid argument passed to marshall(DeleteIdentitiesRequest)");
    }
}
