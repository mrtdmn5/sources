package com.amazonaws.services.lambda.model.transform;

import com.amazonaws.services.lambda.model.InvokeResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.IOUtils;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class InvokeResultJsonUnmarshaller implements Unmarshaller<InvokeResult, JsonUnmarshallerContext> {
    private static InvokeResultJsonUnmarshaller instance;

    public static InvokeResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new InvokeResultJsonUnmarshaller();
        }
        return instance;
    }

    @Override // com.amazonaws.transform.Unmarshaller
    public InvokeResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        InvokeResult invokeResult = new InvokeResult();
        invokeResult.setStatusCode(Integer.valueOf(jsonUnmarshallerContext.getHttpResponse().getStatusCode()));
        if (jsonUnmarshallerContext.getHeader("X-Amz-Function-Error") != null) {
            invokeResult.setFunctionError(jsonUnmarshallerContext.getHeader("X-Amz-Function-Error"));
        }
        if (jsonUnmarshallerContext.getHeader("X-Amz-Log-Result") != null) {
            invokeResult.setLogResult(jsonUnmarshallerContext.getHeader("X-Amz-Log-Result"));
        }
        InputStream content = jsonUnmarshallerContext.getHttpResponse().getContent();
        if (content != null) {
            invokeResult.setPayload(ByteBuffer.wrap(IOUtils.toByteArray(content)));
        }
        if (jsonUnmarshallerContext.getHeader("X-Amz-Executed-Version") != null) {
            invokeResult.setExecutedVersion(jsonUnmarshallerContext.getHeader("X-Amz-Executed-Version"));
        }
        return invokeResult;
    }
}
