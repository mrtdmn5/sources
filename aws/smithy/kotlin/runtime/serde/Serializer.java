package aws.smithy.kotlin.runtime.serde;

import aws.smithy.kotlin.runtime.serde.json.JsonSerializer;

/* compiled from: Serializer.kt */
/* loaded from: classes.dex */
public interface Serializer extends PrimitiveSerializer {
    JsonSerializer beginStruct(SdkObjectDescriptor sdkObjectDescriptor);
}
