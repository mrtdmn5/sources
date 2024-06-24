package com.amazonaws.services.s3.model.transform;

import com.amazonaws.services.s3.model.QueueConfiguration;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers;
import com.amazonaws.transform.StaxUnmarshallerContext;

/* loaded from: classes.dex */
class QueueConfigurationStaxUnmarshaller extends NotificationConfigurationStaxUnmarshaller<QueueConfiguration> {
    private static QueueConfigurationStaxUnmarshaller instance = new QueueConfigurationStaxUnmarshaller();

    private QueueConfigurationStaxUnmarshaller() {
    }

    public static QueueConfigurationStaxUnmarshaller getInstance() {
        return instance;
    }

    @Override // com.amazonaws.services.s3.model.transform.NotificationConfigurationStaxUnmarshaller
    public QueueConfiguration createConfiguration() {
        return new QueueConfiguration();
    }

    @Override // com.amazonaws.services.s3.model.transform.NotificationConfigurationStaxUnmarshaller
    public boolean handleXmlEvent(QueueConfiguration queueConfiguration, StaxUnmarshallerContext staxUnmarshallerContext, int r4) throws Exception {
        if (!staxUnmarshallerContext.testExpression("Queue", r4)) {
            return false;
        }
        queueConfiguration.setQueueARN(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
        return true;
    }
}
