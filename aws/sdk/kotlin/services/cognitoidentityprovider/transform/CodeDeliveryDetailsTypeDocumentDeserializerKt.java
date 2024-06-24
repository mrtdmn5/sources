package aws.sdk.kotlin.services.cognitoidentityprovider.transform;

import aws.sdk.kotlin.services.cognitoidentity.transform.ExternalServiceExceptionDeserializer$$ExternalSyntheticOutline0;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.CodeDeliveryDetailsType;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.DeliveryMediumType;
import aws.smithy.kotlin.runtime.serde.Deserializer$FieldIterator;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkObjectDescriptor;
import aws.smithy.kotlin.runtime.serde.SerialKind;
import aws.smithy.kotlin.runtime.serde.json.JsonDeserializer;
import aws.smithy.kotlin.runtime.serde.json.JsonSerialName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CodeDeliveryDetailsTypeDocumentDeserializer.kt */
/* loaded from: classes.dex */
public final class CodeDeliveryDetailsTypeDocumentDeserializerKt {
    public static final CodeDeliveryDetailsType deserializeCodeDeliveryDetailsTypeDocument(JsonDeserializer jsonDeserializer) {
        DeliveryMediumType sdkUnknown;
        CodeDeliveryDetailsType.Builder builder = new CodeDeliveryDetailsType.Builder();
        SerialKind.String string = SerialKind.String.INSTANCE;
        SdkFieldDescriptor sdkFieldDescriptor = new SdkFieldDescriptor(string, new JsonSerialName("AttributeName"));
        SdkFieldDescriptor sdkFieldDescriptor2 = new SdkFieldDescriptor(SerialKind.Enum.INSTANCE, new JsonSerialName("DeliveryMedium"));
        SdkFieldDescriptor sdkFieldDescriptor3 = new SdkFieldDescriptor(string, new JsonSerialName("Destination"));
        SdkObjectDescriptor.Builder builder2 = new SdkObjectDescriptor.Builder();
        builder2.field(sdkFieldDescriptor);
        builder2.field(sdkFieldDescriptor2);
        builder2.field(sdkFieldDescriptor3);
        Deserializer$FieldIterator m = ExternalServiceExceptionDeserializer$$ExternalSyntheticOutline0.m(builder2, jsonDeserializer);
        while (true) {
            Integer findNextFieldIndex = m.findNextFieldIndex();
            int r3 = sdkFieldDescriptor.index;
            if (findNextFieldIndex != null && findNextFieldIndex.intValue() == r3) {
                builder.attributeName = m.deserializeString();
            } else {
                int r32 = sdkFieldDescriptor2.index;
                if (findNextFieldIndex != null && findNextFieldIndex.intValue() == r32) {
                    String str = m.deserializeString();
                    Intrinsics.checkNotNullParameter(str, "str");
                    if (Intrinsics.areEqual(str, "EMAIL")) {
                        sdkUnknown = DeliveryMediumType.Email.INSTANCE;
                    } else if (Intrinsics.areEqual(str, "SMS")) {
                        sdkUnknown = DeliveryMediumType.Sms.INSTANCE;
                    } else {
                        sdkUnknown = new DeliveryMediumType.SdkUnknown(str);
                    }
                    builder.deliveryMedium = sdkUnknown;
                } else {
                    int r33 = sdkFieldDescriptor3.index;
                    if (findNextFieldIndex != null && findNextFieldIndex.intValue() == r33) {
                        builder.destination = m.deserializeString();
                    } else if (findNextFieldIndex != null) {
                        m.skipValue();
                    } else {
                        return new CodeDeliveryDetailsType(builder);
                    }
                }
            }
        }
    }
}
