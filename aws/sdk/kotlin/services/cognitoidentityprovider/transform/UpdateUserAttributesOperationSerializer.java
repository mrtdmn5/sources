package aws.sdk.kotlin.services.cognitoidentityprovider.transform;

import aws.sdk.kotlin.services.cognitoidentityprovider.model.AttributeType;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.UpdateUserAttributesRequest;
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

/* compiled from: UpdateUserAttributesOperationSerializer.kt */
/* loaded from: classes.dex */
public final class UpdateUserAttributesOperationSerializer implements HttpSerialize<UpdateUserAttributesRequest> {
    @Override // aws.smithy.kotlin.runtime.http.operation.HttpSerialize
    public final HttpRequestBuilder serialize(Object obj) {
        final UpdateUserAttributesRequest updateUserAttributesRequest = (UpdateUserAttributesRequest) obj;
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.POST);
        HttpRequestBuilderKt.url(httpRequestBuilder, new Function1<UrlBuilder, Unit>() { // from class: aws.sdk.kotlin.services.cognitoidentityprovider.transform.UpdateUserAttributesOperationSerializer$serialize$2
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(UrlBuilder urlBuilder) {
                UrlBuilder url = urlBuilder;
                Intrinsics.checkNotNullParameter(url, "$this$url");
                url.path = "/";
                return Unit.INSTANCE;
            }
        });
        JsonSerializer jsonSerializer = new JsonSerializer();
        SdkFieldDescriptor sdkFieldDescriptor = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new JsonSerialName("AccessToken"));
        SdkFieldDescriptor sdkFieldDescriptor2 = new SdkFieldDescriptor(SerialKind.Map.INSTANCE, new JsonSerialName("ClientMetadata"));
        SdkFieldDescriptor sdkFieldDescriptor3 = new SdkFieldDescriptor(SerialKind.List.INSTANCE, new JsonSerialName("UserAttributes"));
        ArrayList arrayList = new ArrayList();
        new LinkedHashSet();
        sdkFieldDescriptor.index = arrayList.size();
        arrayList.add(sdkFieldDescriptor);
        sdkFieldDescriptor2.index = arrayList.size();
        arrayList.add(sdkFieldDescriptor2);
        sdkFieldDescriptor3.index = arrayList.size();
        arrayList.add(sdkFieldDescriptor3);
        SerialKind.Struct kind = SerialKind.Struct.INSTANCE;
        Intrinsics.checkNotNullParameter(kind, "kind");
        JsonEncoder jsonEncoder = jsonSerializer.jsonWriter;
        jsonEncoder.getClass();
        LexerState lexerState = LexerState.ObjectFirstKeyOrEnd;
        jsonEncoder.encodeValue("{");
        if (jsonEncoder.pretty) {
            jsonEncoder.buffer.append('\n');
        }
        jsonEncoder.depth++;
        ArrayList arrayList2 = jsonEncoder.state;
        Intrinsics.checkNotNullParameter(arrayList2, "<this>");
        arrayList2.add(lexerState);
        String str = updateUserAttributesRequest.accessToken;
        if (str != null) {
            jsonSerializer.field(sdkFieldDescriptor, str);
        }
        if (updateUserAttributesRequest.clientMetadata != null) {
            jsonSerializer.mapField(sdkFieldDescriptor2, new Function1<MapSerializer, Unit>() { // from class: aws.sdk.kotlin.services.cognitoidentityprovider.transform.UpdateUserAttributesOperationSerializerKt$serializeUpdateUserAttributesOperationBody$1$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(MapSerializer mapSerializer) {
                    MapSerializer mapField = mapSerializer;
                    Intrinsics.checkNotNullParameter(mapField, "$this$mapField");
                    for (Map.Entry<String, String> entry : UpdateUserAttributesRequest.this.clientMetadata.entrySet()) {
                        mapField.entry(entry.getKey(), entry.getValue());
                    }
                    return Unit.INSTANCE;
                }
            });
        }
        if (updateUserAttributesRequest.userAttributes != null) {
            jsonSerializer.listField(sdkFieldDescriptor3, new Function1<ListSerializer, Unit>() { // from class: aws.sdk.kotlin.services.cognitoidentityprovider.transform.UpdateUserAttributesOperationSerializerKt$serializeUpdateUserAttributesOperationBody$1$3

                /* compiled from: UpdateUserAttributesOperationSerializer.kt */
                /* renamed from: aws.sdk.kotlin.services.cognitoidentityprovider.transform.UpdateUserAttributesOperationSerializerKt$serializeUpdateUserAttributesOperationBody$1$3$1, reason: invalid class name */
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
                    for (AttributeType attributeType : UpdateUserAttributesRequest.this.userAttributes) {
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
