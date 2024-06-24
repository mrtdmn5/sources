package com.amazonaws.services.securitytoken.model.transform;

import com.amazonaws.services.securitytoken.model.DecodeAuthorizationMessageResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: classes.dex */
public class DecodeAuthorizationMessageResultStaxUnmarshaller implements Unmarshaller<DecodeAuthorizationMessageResult, StaxUnmarshallerContext> {
    private static DecodeAuthorizationMessageResultStaxUnmarshaller instance;

    public static DecodeAuthorizationMessageResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DecodeAuthorizationMessageResultStaxUnmarshaller();
        }
        return instance;
    }

    @Override // com.amazonaws.transform.Unmarshaller
    public DecodeAuthorizationMessageResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DecodeAuthorizationMessageResult decodeAuthorizationMessageResult = new DecodeAuthorizationMessageResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int r2 = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            r2 += 2;
        }
        while (true) {
            int nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent == 1) {
                break;
            }
            if (nextEvent == 2) {
                if (staxUnmarshallerContext.testExpression("DecodedMessage", r2)) {
                    decodeAuthorizationMessageResult.setDecodedMessage(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent == 3 && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                break;
            }
        }
        return decodeAuthorizationMessageResult;
    }
}
