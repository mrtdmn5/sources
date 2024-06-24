package com.amazonaws.services.securitytoken.model.transform;

import com.amazonaws.services.securitytoken.model.GetCallerIdentityResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: classes.dex */
public class GetCallerIdentityResultStaxUnmarshaller implements Unmarshaller<GetCallerIdentityResult, StaxUnmarshallerContext> {
    private static GetCallerIdentityResultStaxUnmarshaller instance;

    public static GetCallerIdentityResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new GetCallerIdentityResultStaxUnmarshaller();
        }
        return instance;
    }

    @Override // com.amazonaws.transform.Unmarshaller
    public GetCallerIdentityResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        GetCallerIdentityResult getCallerIdentityResult = new GetCallerIdentityResult();
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
                if (staxUnmarshallerContext.testExpression("UserId", r2)) {
                    getCallerIdentityResult.setUserId(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("Account", r2)) {
                    getCallerIdentityResult.setAccount(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("Arn", r2)) {
                    getCallerIdentityResult.setArn(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent == 3 && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                break;
            }
        }
        return getCallerIdentityResult;
    }
}
