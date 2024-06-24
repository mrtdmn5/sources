package aws.sdk.kotlin.services.cognitoidentityprovider.transform;

import aws.sdk.kotlin.services.cognitoidentityprovider.model.UserContextDataType;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkObjectDescriptor;
import aws.smithy.kotlin.runtime.serde.SerialKind;
import aws.smithy.kotlin.runtime.serde.Serializer;
import aws.smithy.kotlin.runtime.serde.json.JsonSerialName;
import aws.smithy.kotlin.runtime.serde.json.JsonSerializer;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserContextDataTypeDocumentSerializer.kt */
/* loaded from: classes.dex */
public final class UserContextDataTypeDocumentSerializerKt {
    public static final void serializeUserContextDataTypeDocument(Serializer serializer, UserContextDataType input) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(input, "input");
        SerialKind.String string = SerialKind.String.INSTANCE;
        SdkFieldDescriptor sdkFieldDescriptor = new SdkFieldDescriptor(string, new JsonSerialName("EncodedData"));
        SdkFieldDescriptor sdkFieldDescriptor2 = new SdkFieldDescriptor(string, new JsonSerialName("IpAddress"));
        SdkObjectDescriptor.Builder builder = new SdkObjectDescriptor.Builder();
        builder.field(sdkFieldDescriptor);
        builder.field(sdkFieldDescriptor2);
        JsonSerializer beginStruct = serializer.beginStruct(new SdkObjectDescriptor(builder));
        String str = input.encodedData;
        if (str != null) {
            beginStruct.field(sdkFieldDescriptor, str);
        }
        beginStruct.endStruct();
    }
}
