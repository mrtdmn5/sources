package aws.smithy.kotlin.runtime.serde;

/* compiled from: Serializer.kt */
/* loaded from: classes.dex */
public interface StructSerializer extends PrimitiveSerializer {
    void field(SdkFieldDescriptor sdkFieldDescriptor, SdkSerializableLambda sdkSerializableLambda);
}
