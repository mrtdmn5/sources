package aws.sdk.kotlin.services.cognitoidentityprovider.transform;

import aws.sdk.kotlin.services.cognitoidentityprovider.model.AnalyticsMetadataType;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.AuthFlowType;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.InitiateAuthRequest;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.UserContextDataType;
import aws.smithy.kotlin.runtime.http.HttpBody;
import aws.smithy.kotlin.runtime.http.HttpMethod;
import aws.smithy.kotlin.runtime.http.content.ByteArrayContent;
import aws.smithy.kotlin.runtime.http.operation.HttpSerialize;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilderKt;
import aws.smithy.kotlin.runtime.net.UrlBuilder;
import aws.smithy.kotlin.runtime.serde.MapSerializer;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.SerialKind;
import aws.smithy.kotlin.runtime.serde.json.JsonEncoder;
import aws.smithy.kotlin.runtime.serde.json.JsonSerialName;
import aws.smithy.kotlin.runtime.serde.json.JsonSerializer;
import aws.smithy.kotlin.runtime.serde.json.LexerState;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.TimeZoneKt;

/* compiled from: InitiateAuthOperationSerializer.kt */
/* loaded from: classes.dex */
public final class InitiateAuthOperationSerializer implements HttpSerialize<InitiateAuthRequest> {
    @Override // aws.smithy.kotlin.runtime.http.operation.HttpSerialize
    public final HttpRequestBuilder serialize(Object obj) {
        final InitiateAuthRequest initiateAuthRequest = (InitiateAuthRequest) obj;
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.POST);
        HttpRequestBuilderKt.url(httpRequestBuilder, new Function1<UrlBuilder, Unit>() { // from class: aws.sdk.kotlin.services.cognitoidentityprovider.transform.InitiateAuthOperationSerializer$serialize$2
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
        SdkFieldDescriptor sdkFieldDescriptor2 = new SdkFieldDescriptor(SerialKind.Enum.INSTANCE, new JsonSerialName("AuthFlow"));
        SerialKind.Map map = SerialKind.Map.INSTANCE;
        SdkFieldDescriptor sdkFieldDescriptor3 = new SdkFieldDescriptor(map, new JsonSerialName("AuthParameters"));
        SdkFieldDescriptor sdkFieldDescriptor4 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new JsonSerialName("ClientId"));
        SdkFieldDescriptor sdkFieldDescriptor5 = new SdkFieldDescriptor(map, new JsonSerialName("ClientMetadata"));
        SdkFieldDescriptor sdkFieldDescriptor6 = new SdkFieldDescriptor(struct, new JsonSerialName("UserContextData"));
        ArrayList arrayList = new ArrayList();
        new LinkedHashSet();
        sdkFieldDescriptor.index = arrayList.size();
        arrayList.add(sdkFieldDescriptor);
        sdkFieldDescriptor2.index = arrayList.size();
        arrayList.add(sdkFieldDescriptor2);
        sdkFieldDescriptor3.index = arrayList.size();
        arrayList.add(sdkFieldDescriptor3);
        sdkFieldDescriptor4.index = arrayList.size();
        arrayList.add(sdkFieldDescriptor4);
        sdkFieldDescriptor5.index = arrayList.size();
        arrayList.add(sdkFieldDescriptor5);
        sdkFieldDescriptor6.index = arrayList.size();
        arrayList.add(sdkFieldDescriptor6);
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
        AnalyticsMetadataType analyticsMetadataType = initiateAuthRequest.analyticsMetadata;
        if (analyticsMetadataType != null) {
            TimeZoneKt.field(jsonSerializer, sdkFieldDescriptor, analyticsMetadataType, InitiateAuthOperationSerializerKt$serializeInitiateAuthOperationBody$1$1$1.INSTANCE);
        }
        AuthFlowType authFlowType = initiateAuthRequest.authFlow;
        if (authFlowType != null) {
            jsonSerializer.field(sdkFieldDescriptor2, authFlowType.getValue());
        }
        if (initiateAuthRequest.authParameters != null) {
            jsonSerializer.mapField(sdkFieldDescriptor3, new Function1<MapSerializer, Unit>() { // from class: aws.sdk.kotlin.services.cognitoidentityprovider.transform.InitiateAuthOperationSerializerKt$serializeInitiateAuthOperationBody$1$3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(MapSerializer mapSerializer) {
                    MapSerializer mapField = mapSerializer;
                    Intrinsics.checkNotNullParameter(mapField, "$this$mapField");
                    for (Map.Entry<String, String> entry : InitiateAuthRequest.this.authParameters.entrySet()) {
                        mapField.entry(entry.getKey(), entry.getValue());
                    }
                    return Unit.INSTANCE;
                }
            });
        }
        String str = initiateAuthRequest.clientId;
        if (str != null) {
            jsonSerializer.field(sdkFieldDescriptor4, str);
        }
        if (initiateAuthRequest.clientMetadata != null) {
            jsonSerializer.mapField(sdkFieldDescriptor5, new Function1<MapSerializer, Unit>() { // from class: aws.sdk.kotlin.services.cognitoidentityprovider.transform.InitiateAuthOperationSerializerKt$serializeInitiateAuthOperationBody$1$5
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(MapSerializer mapSerializer) {
                    MapSerializer mapField = mapSerializer;
                    Intrinsics.checkNotNullParameter(mapField, "$this$mapField");
                    for (Map.Entry<String, String> entry : InitiateAuthRequest.this.clientMetadata.entrySet()) {
                        mapField.entry(entry.getKey(), entry.getValue());
                    }
                    return Unit.INSTANCE;
                }
            });
        }
        UserContextDataType userContextDataType = initiateAuthRequest.userContextData;
        if (userContextDataType != null) {
            TimeZoneKt.field(jsonSerializer, sdkFieldDescriptor6, userContextDataType, InitiateAuthOperationSerializerKt$serializeInitiateAuthOperationBody$1$6$1.INSTANCE);
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
