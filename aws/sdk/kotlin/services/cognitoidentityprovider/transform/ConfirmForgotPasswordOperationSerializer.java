package aws.sdk.kotlin.services.cognitoidentityprovider.transform;

import aws.sdk.kotlin.services.cognitoidentityprovider.model.AnalyticsMetadataType;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.ConfirmForgotPasswordRequest;
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
import aws.smithy.kotlin.runtime.serde.SdkObjectDescriptor;
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

/* compiled from: ConfirmForgotPasswordOperationSerializer.kt */
/* loaded from: classes.dex */
public final class ConfirmForgotPasswordOperationSerializer implements HttpSerialize<ConfirmForgotPasswordRequest> {
    @Override // aws.smithy.kotlin.runtime.http.operation.HttpSerialize
    public final HttpRequestBuilder serialize(Object obj) {
        final ConfirmForgotPasswordRequest confirmForgotPasswordRequest = (ConfirmForgotPasswordRequest) obj;
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.POST);
        HttpRequestBuilderKt.url(httpRequestBuilder, new Function1<UrlBuilder, Unit>() { // from class: aws.sdk.kotlin.services.cognitoidentityprovider.transform.ConfirmForgotPasswordOperationSerializer$serialize$2
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
        SdkFieldDescriptor sdkFieldDescriptor4 = new SdkFieldDescriptor(string, new JsonSerialName("ConfirmationCode"));
        SdkFieldDescriptor sdkFieldDescriptor5 = new SdkFieldDescriptor(string, new JsonSerialName("Password"));
        SdkFieldDescriptor sdkFieldDescriptor6 = new SdkFieldDescriptor(string, new JsonSerialName("SecretHash"));
        SdkFieldDescriptor sdkFieldDescriptor7 = new SdkFieldDescriptor(struct, new JsonSerialName("UserContextData"));
        SdkFieldDescriptor sdkFieldDescriptor8 = new SdkFieldDescriptor(string, new JsonSerialName("Username"));
        SdkObjectDescriptor.Builder builder = new SdkObjectDescriptor.Builder();
        builder.field(sdkFieldDescriptor);
        builder.field(sdkFieldDescriptor2);
        builder.field(sdkFieldDescriptor3);
        builder.field(sdkFieldDescriptor4);
        builder.field(sdkFieldDescriptor5);
        builder.field(sdkFieldDescriptor6);
        builder.field(sdkFieldDescriptor7);
        builder.field(sdkFieldDescriptor8);
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
        AnalyticsMetadataType analyticsMetadataType = confirmForgotPasswordRequest.analyticsMetadata;
        if (analyticsMetadataType != null) {
            TimeZoneKt.field(jsonSerializer, sdkFieldDescriptor, analyticsMetadataType, ConfirmForgotPasswordOperationSerializerKt$serializeConfirmForgotPasswordOperationBody$1$1$1.INSTANCE);
        }
        String str = confirmForgotPasswordRequest.clientId;
        if (str != null) {
            jsonSerializer.field(sdkFieldDescriptor2, str);
        }
        if (confirmForgotPasswordRequest.clientMetadata != null) {
            jsonSerializer.mapField(sdkFieldDescriptor3, new Function1<MapSerializer, Unit>() { // from class: aws.sdk.kotlin.services.cognitoidentityprovider.transform.ConfirmForgotPasswordOperationSerializerKt$serializeConfirmForgotPasswordOperationBody$1$3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(MapSerializer mapSerializer) {
                    MapSerializer mapField = mapSerializer;
                    Intrinsics.checkNotNullParameter(mapField, "$this$mapField");
                    for (Map.Entry<String, String> entry : ConfirmForgotPasswordRequest.this.clientMetadata.entrySet()) {
                        mapField.entry(entry.getKey(), entry.getValue());
                    }
                    return Unit.INSTANCE;
                }
            });
        }
        String str2 = confirmForgotPasswordRequest.confirmationCode;
        if (str2 != null) {
            jsonSerializer.field(sdkFieldDescriptor4, str2);
        }
        String str3 = confirmForgotPasswordRequest.password;
        if (str3 != null) {
            jsonSerializer.field(sdkFieldDescriptor5, str3);
        }
        String str4 = confirmForgotPasswordRequest.secretHash;
        if (str4 != null) {
            jsonSerializer.field(sdkFieldDescriptor6, str4);
        }
        UserContextDataType userContextDataType = confirmForgotPasswordRequest.userContextData;
        if (userContextDataType != null) {
            TimeZoneKt.field(jsonSerializer, sdkFieldDescriptor7, userContextDataType, ConfirmForgotPasswordOperationSerializerKt$serializeConfirmForgotPasswordOperationBody$1$7$1.INSTANCE);
        }
        String str5 = confirmForgotPasswordRequest.username;
        if (str5 != null) {
            jsonSerializer.field(sdkFieldDescriptor8, str5);
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
