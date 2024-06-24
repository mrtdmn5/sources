package aws.sdk.kotlin.services.cognitoidentityprovider.transform;

import aws.sdk.kotlin.services.cognitoidentityprovider.model.DeviceSecretVerifierConfigType;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkObjectDescriptor;
import aws.smithy.kotlin.runtime.serde.SerialKind;
import aws.smithy.kotlin.runtime.serde.Serializer;
import aws.smithy.kotlin.runtime.serde.json.JsonSerialName;
import aws.smithy.kotlin.runtime.serde.json.JsonSerializer;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConfirmDeviceOperationSerializer.kt */
/* loaded from: classes.dex */
public final /* synthetic */ class ConfirmDeviceOperationSerializerKt$serializeConfirmDeviceOperationBody$1$4$1 extends FunctionReferenceImpl implements Function2<Serializer, DeviceSecretVerifierConfigType, Unit> {
    public static final ConfirmDeviceOperationSerializerKt$serializeConfirmDeviceOperationBody$1$4$1 INSTANCE = new ConfirmDeviceOperationSerializerKt$serializeConfirmDeviceOperationBody$1$4$1();

    public ConfirmDeviceOperationSerializerKt$serializeConfirmDeviceOperationBody$1$4$1() {
        super(2, DeviceSecretVerifierConfigTypeDocumentSerializerKt.class, "serializeDeviceSecretVerifierConfigTypeDocument", "serializeDeviceSecretVerifierConfigTypeDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/cognitoidentityprovider/model/DeviceSecretVerifierConfigType;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Unit invoke(Serializer serializer, DeviceSecretVerifierConfigType deviceSecretVerifierConfigType) {
        Serializer p0 = serializer;
        DeviceSecretVerifierConfigType p1 = deviceSecretVerifierConfigType;
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        SerialKind.String string = SerialKind.String.INSTANCE;
        SdkFieldDescriptor sdkFieldDescriptor = new SdkFieldDescriptor(string, new JsonSerialName("PasswordVerifier"));
        SdkFieldDescriptor sdkFieldDescriptor2 = new SdkFieldDescriptor(string, new JsonSerialName("Salt"));
        SdkObjectDescriptor.Builder builder = new SdkObjectDescriptor.Builder();
        builder.field(sdkFieldDescriptor);
        builder.field(sdkFieldDescriptor2);
        JsonSerializer beginStruct = p0.beginStruct(new SdkObjectDescriptor(builder));
        String str = p1.passwordVerifier;
        if (str != null) {
            beginStruct.field(sdkFieldDescriptor, str);
        }
        String str2 = p1.salt;
        if (str2 != null) {
            beginStruct.field(sdkFieldDescriptor2, str2);
        }
        beginStruct.endStruct();
        return Unit.INSTANCE;
    }
}
