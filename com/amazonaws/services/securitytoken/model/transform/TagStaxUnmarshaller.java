package com.amazonaws.services.securitytoken.model.transform;

import com.amazonaws.services.securitytoken.model.Tag;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: classes.dex */
class TagStaxUnmarshaller implements Unmarshaller<Tag, StaxUnmarshallerContext> {
    private static TagStaxUnmarshaller instance;

    public static TagStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new TagStaxUnmarshaller();
        }
        return instance;
    }

    @Override // com.amazonaws.transform.Unmarshaller
    public Tag unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        Tag tag = new Tag();
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
                if (staxUnmarshallerContext.testExpression("Key", r2)) {
                    tag.setKey(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("Value", r2)) {
                    tag.setValue(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent == 3 && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                break;
            }
        }
        return tag;
    }
}
