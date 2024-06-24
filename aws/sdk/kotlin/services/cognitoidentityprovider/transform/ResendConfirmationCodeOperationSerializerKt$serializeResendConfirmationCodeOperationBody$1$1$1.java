package aws.sdk.kotlin.services.cognitoidentityprovider.transform;

import aws.sdk.kotlin.services.cognitoidentityprovider.model.AnalyticsMetadataType;
import aws.smithy.kotlin.runtime.serde.Serializer;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResendConfirmationCodeOperationSerializer.kt */
/* loaded from: classes.dex */
public final /* synthetic */ class ResendConfirmationCodeOperationSerializerKt$serializeResendConfirmationCodeOperationBody$1$1$1 extends FunctionReferenceImpl implements Function2<Serializer, AnalyticsMetadataType, Unit> {
    public static final ResendConfirmationCodeOperationSerializerKt$serializeResendConfirmationCodeOperationBody$1$1$1 INSTANCE = new ResendConfirmationCodeOperationSerializerKt$serializeResendConfirmationCodeOperationBody$1$1$1();

    public ResendConfirmationCodeOperationSerializerKt$serializeResendConfirmationCodeOperationBody$1$1$1() {
        super(2, AnalyticsMetadataTypeDocumentSerializerKt.class, "serializeAnalyticsMetadataTypeDocument", "serializeAnalyticsMetadataTypeDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/cognitoidentityprovider/model/AnalyticsMetadataType;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Unit invoke(Serializer serializer, AnalyticsMetadataType analyticsMetadataType) {
        Serializer p0 = serializer;
        AnalyticsMetadataType p1 = analyticsMetadataType;
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        AnalyticsMetadataTypeDocumentSerializerKt.serializeAnalyticsMetadataTypeDocument(p0, p1);
        return Unit.INSTANCE;
    }
}
