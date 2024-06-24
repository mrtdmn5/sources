package aws.sdk.kotlin.services.cognitoidentityprovider.transform;

import aws.sdk.kotlin.services.cognitoidentity.transform.ExternalServiceExceptionDeserializer$$ExternalSyntheticOutline1;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.AnalyticsMetadataType;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkObjectDescriptor;
import aws.smithy.kotlin.runtime.serde.SerialKind;
import aws.smithy.kotlin.runtime.serde.Serializer;
import aws.smithy.kotlin.runtime.serde.json.JsonSerialName;
import aws.smithy.kotlin.runtime.serde.json.JsonSerializer;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnalyticsMetadataTypeDocumentSerializer.kt */
/* loaded from: classes.dex */
public final class AnalyticsMetadataTypeDocumentSerializerKt {
    public static final void serializeAnalyticsMetadataTypeDocument(Serializer serializer, AnalyticsMetadataType input) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(input, "input");
        SdkFieldDescriptor sdkFieldDescriptor = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new JsonSerialName("AnalyticsEndpointId"));
        JsonSerializer beginStruct = serializer.beginStruct(new SdkObjectDescriptor(ExternalServiceExceptionDeserializer$$ExternalSyntheticOutline1.m(sdkFieldDescriptor)));
        String str = input.analyticsEndpointId;
        if (str != null) {
            beginStruct.field(sdkFieldDescriptor, str);
        }
        beginStruct.endStruct();
    }
}
