package aws.sdk.kotlin.services.cognitoidentityprovider.transform;

import aws.sdk.kotlin.services.cognitoidentity.transform.ExternalServiceExceptionDeserializer$$ExternalSyntheticOutline0;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.AttributeType;
import aws.smithy.kotlin.runtime.serde.Deserializer$FieldIterator;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkObjectDescriptor;
import aws.smithy.kotlin.runtime.serde.SerialKind;
import aws.smithy.kotlin.runtime.serde.json.JsonDeserializer;
import aws.smithy.kotlin.runtime.serde.json.JsonSerialName;

/* compiled from: AttributeTypeDocumentDeserializer.kt */
/* loaded from: classes.dex */
public final class AttributeTypeDocumentDeserializerKt {
    public static final AttributeType deserializeAttributeTypeDocument(JsonDeserializer jsonDeserializer) {
        AttributeType.Builder builder = new AttributeType.Builder();
        SerialKind.String string = SerialKind.String.INSTANCE;
        SdkFieldDescriptor sdkFieldDescriptor = new SdkFieldDescriptor(string, new JsonSerialName("Name"));
        SdkFieldDescriptor sdkFieldDescriptor2 = new SdkFieldDescriptor(string, new JsonSerialName("Value"));
        SdkObjectDescriptor.Builder builder2 = new SdkObjectDescriptor.Builder();
        builder2.field(sdkFieldDescriptor);
        builder2.field(sdkFieldDescriptor2);
        Deserializer$FieldIterator m = ExternalServiceExceptionDeserializer$$ExternalSyntheticOutline0.m(builder2, jsonDeserializer);
        while (true) {
            Integer findNextFieldIndex = m.findNextFieldIndex();
            int r3 = sdkFieldDescriptor.index;
            if (findNextFieldIndex != null && findNextFieldIndex.intValue() == r3) {
                builder.name = m.deserializeString();
            } else {
                int r32 = sdkFieldDescriptor2.index;
                if (findNextFieldIndex != null && findNextFieldIndex.intValue() == r32) {
                    builder.value = m.deserializeString();
                } else if (findNextFieldIndex != null) {
                    m.skipValue();
                } else {
                    return new AttributeType(builder);
                }
            }
        }
    }
}
