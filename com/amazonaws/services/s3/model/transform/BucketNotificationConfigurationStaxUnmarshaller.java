package com.amazonaws.services.s3.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.s3.model.BucketNotificationConfiguration;
import com.amazonaws.services.s3.model.NotificationConfiguration;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import java.io.InputStream;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes.dex */
public class BucketNotificationConfigurationStaxUnmarshaller implements Unmarshaller<BucketNotificationConfiguration, InputStream> {
    private static BucketNotificationConfigurationStaxUnmarshaller instance = new BucketNotificationConfigurationStaxUnmarshaller();
    private static final XmlPullParserFactory xmlPullParserFactory;

    static {
        try {
            xmlPullParserFactory = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e) {
            throw new AmazonClientException("Couldn't initialize XmlPullParserFactory", e);
        }
    }

    private BucketNotificationConfigurationStaxUnmarshaller() {
    }

    public static BucketNotificationConfigurationStaxUnmarshaller getInstance() {
        return instance;
    }

    @Override // com.amazonaws.transform.Unmarshaller
    public BucketNotificationConfiguration unmarshall(InputStream inputStream) throws Exception {
        XmlPullParser newPullParser = xmlPullParserFactory.newPullParser();
        newPullParser.setInput(inputStream, null);
        StaxUnmarshallerContext staxUnmarshallerContext = new StaxUnmarshallerContext(newPullParser, null);
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int r1 = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            r1++;
        }
        BucketNotificationConfiguration bucketNotificationConfiguration = new BucketNotificationConfiguration();
        while (true) {
            int nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent == 1) {
                return bucketNotificationConfiguration;
            }
            if (nextEvent == 2) {
                if (staxUnmarshallerContext.testExpression("TopicConfiguration", r1)) {
                    Map.Entry<String, NotificationConfiguration> unmarshall = TopicConfigurationStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext);
                    bucketNotificationConfiguration.addConfiguration(unmarshall.getKey(), unmarshall.getValue());
                } else if (staxUnmarshallerContext.testExpression("QueueConfiguration", r1)) {
                    Map.Entry<String, NotificationConfiguration> unmarshall2 = QueueConfigurationStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext);
                    bucketNotificationConfiguration.addConfiguration(unmarshall2.getKey(), unmarshall2.getValue());
                } else if (staxUnmarshallerContext.testExpression("CloudFunctionConfiguration", r1)) {
                    Map.Entry<String, NotificationConfiguration> unmarshall3 = LambdaConfigurationStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext);
                    bucketNotificationConfiguration.addConfiguration(unmarshall3.getKey(), unmarshall3.getValue());
                }
            } else if (nextEvent == 3 && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return bucketNotificationConfiguration;
            }
        }
    }
}
