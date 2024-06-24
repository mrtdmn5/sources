package aws.sdk.kotlin.services.cognitoidentityprovider.transform;

import aws.sdk.kotlin.services.cognitoidentityprovider.model.VerifyUserAttributeRequest;
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
import java.util.ArrayList;
import java.util.LinkedHashSet;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VerifyUserAttributeOperationSerializer.kt */
/* loaded from: classes.dex */
public final class VerifyUserAttributeOperationSerializer implements HttpSerialize<VerifyUserAttributeRequest> {
    @Override // aws.smithy.kotlin.runtime.http.operation.HttpSerialize
    public final HttpRequestBuilder serialize(Object obj) {
        VerifyUserAttributeRequest verifyUserAttributeRequest = (VerifyUserAttributeRequest) obj;
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.POST);
        HttpRequestBuilderKt.url(httpRequestBuilder, new Function1<UrlBuilder, Unit>() { // from class: aws.sdk.kotlin.services.cognitoidentityprovider.transform.VerifyUserAttributeOperationSerializer$serialize$2
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
        SdkFieldDescriptor sdkFieldDescriptor2 = new SdkFieldDescriptor(string, new JsonSerialName("AttributeName"));
        SdkFieldDescriptor sdkFieldDescriptor3 = new SdkFieldDescriptor(string, new JsonSerialName("Code"));
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
        String str = verifyUserAttributeRequest.accessToken;
        if (str != null) {
            jsonSerializer.field(sdkFieldDescriptor, str);
        }
        String str2 = verifyUserAttributeRequest.attributeName;
        if (str2 != null) {
            jsonSerializer.field(sdkFieldDescriptor2, str2);
        }
        String str3 = verifyUserAttributeRequest.code;
        if (str3 != null) {
            jsonSerializer.field(sdkFieldDescriptor3, str3);
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
