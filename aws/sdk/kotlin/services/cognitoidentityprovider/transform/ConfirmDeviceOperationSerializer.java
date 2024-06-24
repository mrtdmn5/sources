package aws.sdk.kotlin.services.cognitoidentityprovider.transform;

import aws.sdk.kotlin.services.cognitoidentityprovider.model.ConfirmDeviceRequest;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.DeviceSecretVerifierConfigType;
import aws.smithy.kotlin.runtime.http.HttpBody;
import aws.smithy.kotlin.runtime.http.HttpMethod;
import aws.smithy.kotlin.runtime.http.content.ByteArrayContent;
import aws.smithy.kotlin.runtime.http.operation.HttpSerialize;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilderKt;
import aws.smithy.kotlin.runtime.net.UrlBuilder;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.SerialKind;
import aws.smithy.kotlin.runtime.serde.json.JsonEncoder;
import aws.smithy.kotlin.runtime.serde.json.JsonSerialName;
import aws.smithy.kotlin.runtime.serde.json.JsonSerializer;
import aws.smithy.kotlin.runtime.serde.json.LexerState;
import com.amplifyframework.auth.cognito.asf.BuildDataCollector;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.TimeZoneKt;

/* compiled from: ConfirmDeviceOperationSerializer.kt */
/* loaded from: classes.dex */
public final class ConfirmDeviceOperationSerializer implements HttpSerialize<ConfirmDeviceRequest> {
    @Override // aws.smithy.kotlin.runtime.http.operation.HttpSerialize
    public final HttpRequestBuilder serialize(Object obj) {
        ConfirmDeviceRequest confirmDeviceRequest = (ConfirmDeviceRequest) obj;
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.POST);
        HttpRequestBuilderKt.url(httpRequestBuilder, new Function1<UrlBuilder, Unit>() { // from class: aws.sdk.kotlin.services.cognitoidentityprovider.transform.ConfirmDeviceOperationSerializer$serialize$2
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(UrlBuilder urlBuilder) {
                UrlBuilder url = urlBuilder;
                Intrinsics.checkNotNullParameter(url, "$this$url");
                url.path = "/";
                return Unit.INSTANCE;
            }
        });
        JsonSerializer jsonSerializer = new JsonSerializer();
        SerialKind.String string = SerialKind.String.INSTANCE;
        SdkFieldDescriptor sdkFieldDescriptor = new SdkFieldDescriptor(string, new JsonSerialName("AccessToken"));
        SdkFieldDescriptor sdkFieldDescriptor2 = new SdkFieldDescriptor(string, new JsonSerialName("DeviceKey"));
        SdkFieldDescriptor sdkFieldDescriptor3 = new SdkFieldDescriptor(string, new JsonSerialName(BuildDataCollector.MODEL));
        SdkFieldDescriptor sdkFieldDescriptor4 = new SdkFieldDescriptor(SerialKind.Struct.INSTANCE, new JsonSerialName("DeviceSecretVerifierConfig"));
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
        String str = confirmDeviceRequest.accessToken;
        if (str != null) {
            jsonSerializer.field(sdkFieldDescriptor, str);
        }
        String str2 = confirmDeviceRequest.deviceKey;
        if (str2 != null) {
            jsonSerializer.field(sdkFieldDescriptor2, str2);
        }
        String str3 = confirmDeviceRequest.deviceName;
        if (str3 != null) {
            jsonSerializer.field(sdkFieldDescriptor3, str3);
        }
        DeviceSecretVerifierConfigType deviceSecretVerifierConfigType = confirmDeviceRequest.deviceSecretVerifierConfig;
        if (deviceSecretVerifierConfigType != null) {
            TimeZoneKt.field(jsonSerializer, sdkFieldDescriptor4, deviceSecretVerifierConfigType, ConfirmDeviceOperationSerializerKt$serializeConfirmDeviceOperationBody$1$4$1.INSTANCE);
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
