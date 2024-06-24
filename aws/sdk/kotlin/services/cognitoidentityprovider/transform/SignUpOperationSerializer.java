package aws.sdk.kotlin.services.cognitoidentityprovider.transform;

import aws.sdk.kotlin.services.cognitoidentityprovider.model.AnalyticsMetadataType;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.AttributeType;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.SignUpRequest;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.UserContextDataType;
import aws.smithy.kotlin.runtime.http.HttpBody;
import aws.smithy.kotlin.runtime.http.HttpMethod;
import aws.smithy.kotlin.runtime.http.content.ByteArrayContent;
import aws.smithy.kotlin.runtime.http.operation.HttpSerialize;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilderKt;
import aws.smithy.kotlin.runtime.net.UrlBuilder;
import aws.smithy.kotlin.runtime.serde.ListSerializer;
import aws.smithy.kotlin.runtime.serde.MapSerializer;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkObjectDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkSerializableLambda;
import aws.smithy.kotlin.runtime.serde.SerialKind;
import aws.smithy.kotlin.runtime.serde.Serializer;
import aws.smithy.kotlin.runtime.serde.json.JsonEncoder;
import aws.smithy.kotlin.runtime.serde.json.JsonSerialName;
import aws.smithy.kotlin.runtime.serde.json.JsonSerializer;
import aws.smithy.kotlin.runtime.serde.json.LexerState;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.TimeZoneKt;

/* compiled from: SignUpOperationSerializer.kt */
/* loaded from: classes.dex */
public final class SignUpOperationSerializer implements HttpSerialize<SignUpRequest> {
    @Override // aws.smithy.kotlin.runtime.http.operation.HttpSerialize
    public final HttpRequestBuilder serialize(Object obj) {
        final SignUpRequest signUpRequest = (SignUpRequest) obj;
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.POST);
        HttpRequestBuilderKt.url(httpRequestBuilder, new Function1<UrlBuilder, Unit>() { // from class: aws.sdk.kotlin.services.cognitoidentityprovider.transform.SignUpOperationSerializer$serialize$2
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(UrlBuilder urlBuilder) {
                UrlBuilder url = urlBuilder;
                Intrinsics.checkNotNullParameter(url, "$this$url");
                url.path = "/";
                return Unit.INSTANCE;
            }
        });
        JsonSerializer jsonSerializer = new JsonSerializer();
        SerialKind.Struct struct = SerialKind.Struct.INSTANCE;
        SdkFieldDescriptor sdkFieldDescriptor = new SdkFieldDescriptor(struct, new JsonSerialName("AnalyticsMetadata"));
        SerialKind.String string = SerialKind.String.INSTANCE;
        SdkFieldDescriptor sdkFieldDescriptor2 = new SdkFieldDescriptor(string, new JsonSerialName("ClientId"));
        SdkFieldDescriptor sdkFieldDescriptor3 = new SdkFieldDescriptor(SerialKind.Map.INSTANCE, new JsonSerialName("ClientMetadata"));
        SdkFieldDescriptor sdkFieldDescriptor4 = new SdkFieldDescriptor(string, new JsonSerialName("Password"));
        SdkFieldDescriptor sdkFieldDescriptor5 = new SdkFieldDescriptor(string, new JsonSerialName("SecretHash"));
        SerialKind.List list = SerialKind.List.INSTANCE;
        SdkFieldDescriptor sdkFieldDescriptor6 = new SdkFieldDescriptor(list, new JsonSerialName("UserAttributes"));
        SdkFieldDescriptor sdkFieldDescriptor7 = new SdkFieldDescriptor(struct, new JsonSerialName("UserContextData"));
        SdkFieldDescriptor sdkFieldDescriptor8 = new SdkFieldDescriptor(string, new JsonSerialName("Username"));
        SdkFieldDescriptor sdkFieldDescriptor9 = new SdkFieldDescriptor(list, new JsonSerialName("ValidationData"));
        SdkObjectDescriptor.Builder builder = new SdkObjectDescriptor.Builder();
        builder.field(sdkFieldDescriptor);
        builder.field(sdkFieldDescriptor2);
        builder.field(sdkFieldDescriptor3);
        builder.field(sdkFieldDescriptor4);
        builder.field(sdkFieldDescriptor5);
        builder.field(sdkFieldDescriptor6);
        builder.field(sdkFieldDescriptor7);
        builder.field(sdkFieldDescriptor8);
        builder.field(sdkFieldDescriptor9);
        SerialKind.Struct kind = SerialKind.Struct.INSTANCE;
        LinkedHashSet traits = builder.traits;
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(traits, "traits");
        JsonEncoder jsonEncoder = jsonSerializer.jsonWriter;
        jsonEncoder.getClass();
        LexerState lexerState = LexerState.ObjectFirstKeyOrEnd;
        jsonEncoder.encodeValue("{");
        if (jsonEncoder.pretty) {
            jsonEncoder.buffer.append('\n');
        }
        jsonEncoder.depth++;
        ArrayList arrayList = jsonEncoder.state;
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        arrayList.add(lexerState);
        AnalyticsMetadataType analyticsMetadataType = signUpRequest.analyticsMetadata;
        if (analyticsMetadataType != null) {
            TimeZoneKt.field(jsonSerializer, sdkFieldDescriptor, analyticsMetadataType, SignUpOperationSerializerKt$serializeSignUpOperationBody$1$1$1.INSTANCE);
        }
        String str = signUpRequest.clientId;
        if (str != null) {
            jsonSerializer.field(sdkFieldDescriptor2, str);
        }
        if (signUpRequest.clientMetadata != null) {
            jsonSerializer.mapField(sdkFieldDescriptor3, new Function1<MapSerializer, Unit>() { // from class: aws.sdk.kotlin.services.cognitoidentityprovider.transform.SignUpOperationSerializerKt$serializeSignUpOperationBody$1$3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(MapSerializer mapSerializer) {
                    MapSerializer mapField = mapSerializer;
                    Intrinsics.checkNotNullParameter(mapField, "$this$mapField");
                    for (Map.Entry<String, String> entry : SignUpRequest.this.clientMetadata.entrySet()) {
                        mapField.entry(entry.getKey(), entry.getValue());
                    }
                    return Unit.INSTANCE;
                }
            });
        }
        String str2 = signUpRequest.password;
        if (str2 != null) {
            jsonSerializer.field(sdkFieldDescriptor4, str2);
        }
        String str3 = signUpRequest.secretHash;
        if (str3 != null) {
            jsonSerializer.field(sdkFieldDescriptor5, str3);
        }
        if (signUpRequest.userAttributes != null) {
            jsonSerializer.listField(sdkFieldDescriptor6, new Function1<ListSerializer, Unit>() { // from class: aws.sdk.kotlin.services.cognitoidentityprovider.transform.SignUpOperationSerializerKt$serializeSignUpOperationBody$1$6

                /* compiled from: SignUpOperationSerializer.kt */
                /* renamed from: aws.sdk.kotlin.services.cognitoidentityprovider.transform.SignUpOperationSerializerKt$serializeSignUpOperationBody$1$6$1, reason: invalid class name */
                /* loaded from: classes.dex */
                public final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function2<Serializer, AttributeType, Unit> {
                    public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                    public AnonymousClass1() {
                        super(2, AttributeTypeDocumentSerializerKt.class, "serializeAttributeTypeDocument", "serializeAttributeTypeDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/cognitoidentityprovider/model/AttributeType;)V", 1);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(Serializer serializer, AttributeType attributeType) {
                        Serializer p0 = serializer;
                        AttributeType p1 = attributeType;
                        Intrinsics.checkNotNullParameter(p0, "p0");
                        Intrinsics.checkNotNullParameter(p1, "p1");
                        AttributeTypeDocumentSerializerKt.serializeAttributeTypeDocument(p0, p1);
                        return Unit.INSTANCE;
                    }
                }

                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(ListSerializer listSerializer) {
                    ListSerializer listField = listSerializer;
                    Intrinsics.checkNotNullParameter(listField, "$this$listField");
                    for (AttributeType attributeType : SignUpRequest.this.userAttributes) {
                        AnonymousClass1 serializeFn = AnonymousClass1.INSTANCE;
                        Intrinsics.checkNotNullParameter(serializeFn, "serializeFn");
                        listField.serializeSdkSerializable(new SdkSerializableLambda(attributeType, serializeFn));
                    }
                    return Unit.INSTANCE;
                }
            });
        }
        UserContextDataType userContextDataType = signUpRequest.userContextData;
        if (userContextDataType != null) {
            TimeZoneKt.field(jsonSerializer, sdkFieldDescriptor7, userContextDataType, SignUpOperationSerializerKt$serializeSignUpOperationBody$1$7$1.INSTANCE);
        }
        String str4 = signUpRequest.username;
        if (str4 != null) {
            jsonSerializer.field(sdkFieldDescriptor8, str4);
        }
        if (signUpRequest.validationData != null) {
            jsonSerializer.listField(sdkFieldDescriptor9, new Function1<ListSerializer, Unit>() { // from class: aws.sdk.kotlin.services.cognitoidentityprovider.transform.SignUpOperationSerializerKt$serializeSignUpOperationBody$1$9

                /* compiled from: SignUpOperationSerializer.kt */
                /* renamed from: aws.sdk.kotlin.services.cognitoidentityprovider.transform.SignUpOperationSerializerKt$serializeSignUpOperationBody$1$9$1, reason: invalid class name */
                /* loaded from: classes.dex */
                public final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function2<Serializer, AttributeType, Unit> {
                    public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                    public AnonymousClass1() {
                        super(2, AttributeTypeDocumentSerializerKt.class, "serializeAttributeTypeDocument", "serializeAttributeTypeDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/cognitoidentityprovider/model/AttributeType;)V", 1);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(Serializer serializer, AttributeType attributeType) {
                        Serializer p0 = serializer;
                        AttributeType p1 = attributeType;
                        Intrinsics.checkNotNullParameter(p0, "p0");
                        Intrinsics.checkNotNullParameter(p1, "p1");
                        AttributeTypeDocumentSerializerKt.serializeAttributeTypeDocument(p0, p1);
                        return Unit.INSTANCE;
                    }
                }

                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(ListSerializer listSerializer) {
                    ListSerializer listField = listSerializer;
                    Intrinsics.checkNotNullParameter(listField, "$this$listField");
                    for (AttributeType attributeType : SignUpRequest.this.validationData) {
                        AnonymousClass1 serializeFn = AnonymousClass1.INSTANCE;
                        Intrinsics.checkNotNullParameter(serializeFn, "serializeFn");
                        listField.serializeSdkSerializable(new SdkSerializableLambda(attributeType, serializeFn));
                    }
                    return Unit.INSTANCE;
                }
            });
        }
        jsonSerializer.endStruct();
        ByteArrayContent byteArrayContent = new ByteArrayContent(jsonSerializer.toByteArray());
        httpRequestBuilder.body = byteArrayContent;
        if (!(byteArrayContent instanceof HttpBody.Empty)) {
            httpRequestBuilder.headers.setMissing("application/x-amz-json-1.1");
        }
        return httpRequestBuilder;
    }
}
