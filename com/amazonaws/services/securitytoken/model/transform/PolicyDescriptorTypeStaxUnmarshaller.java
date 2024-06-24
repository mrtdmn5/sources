package com.amazonaws.services.securitytoken.model.transform;

import com.amazonaws.services.securitytoken.model.PolicyDescriptorType;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: classes.dex */
class PolicyDescriptorTypeStaxUnmarshaller implements Unmarshaller<PolicyDescriptorType, StaxUnmarshallerContext> {
    private static PolicyDescriptorTypeStaxUnmarshaller instance;

    public static PolicyDescriptorTypeStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new PolicyDescriptorTypeStaxUnmarshaller();
        }
        return instance;
    }

    @Override // com.amazonaws.transform.Unmarshaller
    public PolicyDescriptorType unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        PolicyDescriptorType policyDescriptorType = new PolicyDescriptorType();
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
                if (staxUnmarshallerContext.testExpression("arn", r2)) {
                    policyDescriptorType.setArn(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent == 3 && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                break;
            }
        }
        return policyDescriptorType;
    }
}
