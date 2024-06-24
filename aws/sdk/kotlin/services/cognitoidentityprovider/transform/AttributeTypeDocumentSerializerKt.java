package aws.sdk.kotlin.services.cognitoidentityprovider.transform;

import aws.sdk.kotlin.services.cognitoidentityprovider.model.AttributeType;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkObjectDescriptor;
import aws.smithy.kotlin.runtime.serde.SerialKind;
import aws.smithy.kotlin.runtime.serde.Serializer;
import aws.smithy.kotlin.runtime.serde.json.JsonSerialName;
import aws.smithy.kotlin.runtime.serde.json.JsonSerializer;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AttributeTypeDocumentSerializer.kt */
/* loaded from: classes.dex */
public final class AttributeTypeDocumentSerializerKt {
    public static final void serializeAttributeTypeDocument(Serializer serializer, AttributeType input) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(input, "input");
        SerialKind.String string = SerialKind.String.INSTANCE;
        SdkFieldDescriptor sdkFieldDescriptor = new SdkFieldDescriptor(string, new JsonSerialName("Name"));
        SdkFieldDescriptor sdkFieldDescriptor2 = new SdkFieldDescriptor(string, new JsonSerialName("Value"));
        SdkObjectDescriptor.Builder builder = new SdkObjectDescriptor.Builder();
        builder.field(sdkFieldDescriptor);
        builder.field(sdkFieldDescriptor2);
        JsonSerializer beginStruct = serializer.beginStruct(new SdkObjectDescriptor(builder));
        String str = input.name;
        if (str != null) {
            beginStruct.field(sdkFieldDescriptor, str);
        }
        String str2 = input.value;
        if (str2 != null) {
            beginStruct.field(sdkFieldDescriptor2, str2);
        }
        beginStruct.endStruct();
    }
}
