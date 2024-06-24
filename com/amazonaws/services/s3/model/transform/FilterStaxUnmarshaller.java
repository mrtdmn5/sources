package com.amazonaws.services.s3.model.transform;

import com.amazonaws.services.s3.model.Filter;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: classes.dex */
class FilterStaxUnmarshaller implements Unmarshaller<Filter, StaxUnmarshallerContext> {
    private static FilterStaxUnmarshaller instance = new FilterStaxUnmarshaller();

    private FilterStaxUnmarshaller() {
    }

    public static FilterStaxUnmarshaller getInstance() {
        return instance;
    }

    @Override // com.amazonaws.transform.Unmarshaller
    public Filter unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int r1 = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            r1++;
        }
        Filter filter = new Filter();
        while (true) {
            int nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent == 1) {
                return filter;
            }
            if (nextEvent == 2) {
                if (staxUnmarshallerContext.testExpression("S3Key", r1)) {
                    filter.withS3KeyFilter(S3KeyFilterStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent == 3 && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return filter;
            }
        }
    }
}
