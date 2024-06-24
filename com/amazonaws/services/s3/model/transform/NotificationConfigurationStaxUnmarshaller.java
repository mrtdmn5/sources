package com.amazonaws.services.s3.model.transform;

import com.amazonaws.auth.policy.internal.JsonDocumentFields;
import com.amazonaws.services.s3.model.NotificationConfiguration;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import java.util.AbstractMap;
import java.util.Map;

/* loaded from: classes.dex */
abstract class NotificationConfigurationStaxUnmarshaller<T extends NotificationConfiguration> implements Unmarshaller<Map.Entry<String, NotificationConfiguration>, StaxUnmarshallerContext> {
    public abstract T createConfiguration();

    public abstract boolean handleXmlEvent(T t, StaxUnmarshallerContext staxUnmarshallerContext, int r3) throws Exception;

    @Override // com.amazonaws.transform.Unmarshaller
    public Map.Entry<String, NotificationConfiguration> unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int r1 = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            r1++;
        }
        T createConfiguration = createConfiguration();
        String str = null;
        while (true) {
            int nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent == 1) {
                return null;
            }
            if (nextEvent == 2) {
                if (!handleXmlEvent(createConfiguration, staxUnmarshallerContext, r1)) {
                    if (staxUnmarshallerContext.testExpression(JsonDocumentFields.POLICY_ID, r1)) {
                        str = SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext);
                    } else if (staxUnmarshallerContext.testExpression("Event", r1)) {
                        createConfiguration.addEvent(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                    } else if (staxUnmarshallerContext.testExpression("Filter", r1)) {
                        createConfiguration.setFilter(FilterStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                    }
                }
            } else if (nextEvent == 3 && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return new AbstractMap.SimpleEntry(str, createConfiguration);
            }
        }
    }
}
