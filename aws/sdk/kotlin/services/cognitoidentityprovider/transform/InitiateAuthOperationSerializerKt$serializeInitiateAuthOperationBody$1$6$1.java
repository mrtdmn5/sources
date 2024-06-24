package aws.sdk.kotlin.services.cognitoidentityprovider.transform;

import aws.sdk.kotlin.services.cognitoidentityprovider.model.UserContextDataType;
import aws.smithy.kotlin.runtime.serde.Serializer;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InitiateAuthOperationSerializer.kt */
/* loaded from: classes.dex */
public final /* synthetic */ class InitiateAuthOperationSerializerKt$serializeInitiateAuthOperationBody$1$6$1 extends FunctionReferenceImpl implements Function2<Serializer, UserContextDataType, Unit> {
    public static final InitiateAuthOperationSerializerKt$serializeInitiateAuthOperationBody$1$6$1 INSTANCE = new InitiateAuthOperationSerializerKt$serializeInitiateAuthOperationBody$1$6$1();

    public InitiateAuthOperationSerializerKt$serializeInitiateAuthOperationBody$1$6$1() {
        super(2, UserContextDataTypeDocumentSerializerKt.class, "serializeUserContextDataTypeDocument", "serializeUserContextDataTypeDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/cognitoidentityprovider/model/UserContextDataType;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Unit invoke(Serializer serializer, UserContextDataType userContextDataType) {
        Serializer p0 = serializer;
        UserContextDataType p1 = userContextDataType;
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        UserContextDataTypeDocumentSerializerKt.serializeUserContextDataTypeDocument(p0, p1);
        return Unit.INSTANCE;
    }
}
