package com.amazonaws.services.lambda.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.StringUtils;

/* loaded from: classes.dex */
public class InvokeRequestMarshaller implements Marshaller<Request<InvokeRequest>, InvokeRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<InvokeRequest> marshall(InvokeRequest invokeRequest) {
        if (invokeRequest != null) {
            DefaultRequest defaultRequest = new DefaultRequest(invokeRequest, "AWSLambda");
            defaultRequest.setHttpMethod(HttpMethodName.POST);
            if (invokeRequest.getInvocationType() != null) {
                defaultRequest.addHeader("X-Amz-Invocation-Type", StringUtils.fromString(invokeRequest.getInvocationType()));
            }
            if (invokeRequest.getLogType() != null) {
                defaultRequest.addHeader("X-Amz-Log-Type", StringUtils.fromString(invokeRequest.getLogType()));
            }
            if (invokeRequest.getClientContext() != null) {
                defaultRequest.addHeader("X-Amz-Client-Context", StringUtils.fromString(invokeRequest.getClientContext()));
            }
            String replace = "/2015-03-31/functions/{FunctionName}/invocations".replace("{FunctionName}", invokeRequest.getFunctionName() == null ? "" : StringUtils.fromString(invokeRequest.getFunctionName()));
            if (invokeRequest.getQualifier() != null) {
                defaultRequest.addParameter("Qualifier", StringUtils.fromString(invokeRequest.getQualifier()));
            }
            defaultRequest.setResourcePath(replace);
            defaultRequest.addHeader("Content-Length", Integer.toString(invokeRequest.getPayload().remaining()));
            defaultRequest.setContent(BinaryUtils.toStream(invokeRequest.getPayload()));
            if (!defaultRequest.getHeaders().containsKey("Content-Type")) {
                defaultRequest.addHeader("Content-Type", "application/x-amz-json-1.0");
            }
            return defaultRequest;
        }
        throw new AmazonClientException("Invalid argument passed to marshall(InvokeRequest)");
    }
}
