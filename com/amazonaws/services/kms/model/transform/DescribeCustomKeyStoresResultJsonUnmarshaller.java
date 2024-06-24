package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.DescribeCustomKeyStoresResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: classes.dex */
public class DescribeCustomKeyStoresResultJsonUnmarshaller implements Unmarshaller<DescribeCustomKeyStoresResult, JsonUnmarshallerContext> {
    private static DescribeCustomKeyStoresResultJsonUnmarshaller instance;

    public static DescribeCustomKeyStoresResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeCustomKeyStoresResultJsonUnmarshaller();
        }
        return instance;
    }

    @Override // com.amazonaws.transform.Unmarshaller
    public DescribeCustomKeyStoresResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        DescribeCustomKeyStoresResult describeCustomKeyStoresResult = new DescribeCustomKeyStoresResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("CustomKeyStores")) {
                describeCustomKeyStoresResult.setCustomKeyStores(new ListUnmarshaller(CustomKeyStoresListEntryJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("NextMarker")) {
                describeCustomKeyStoresResult.setNextMarker(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("Truncated")) {
                describeCustomKeyStoresResult.setTruncated(SimpleTypeJsonUnmarshallers.BooleanJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return describeCustomKeyStoresResult;
    }
}
