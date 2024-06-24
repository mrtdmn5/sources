package aws.sdk.kotlin.runtime.http.middleware;

import aws.sdk.kotlin.runtime.http.AwsUserAgentMetadata;
import aws.sdk.kotlin.runtime.http.FrameworkMetadata;
import aws.sdk.kotlin.runtime.http.SdkMetadata;
import aws.sdk.kotlin.runtime.http.operation.CustomUserAgentMetadata;
import aws.smithy.kotlin.runtime.http.HeadersBuilder;
import aws.smithy.kotlin.runtime.http.operation.OperationRequest;
import aws.smithy.kotlin.runtime.http.operation.SdkHttpOperation;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.io.middleware.ModifyRequest;
import aws.smithy.kotlin.runtime.io.middleware.ModifyRequestMiddleware;
import aws.smithy.kotlin.runtime.io.middleware.ModifyRequestMiddleware$handle$1;
import aws.smithy.kotlin.runtime.io.middleware.Phase;
import com.amazonaws.http.HttpHeader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserAgent.kt */
/* loaded from: classes.dex */
public final class UserAgent implements ModifyRequest {
    public final AwsUserAgentMetadata staticMetadata;

    public UserAgent(AwsUserAgentMetadata staticMetadata) {
        Intrinsics.checkNotNullParameter(staticMetadata, "staticMetadata");
        this.staticMetadata = staticMetadata;
    }

    public final void install(SdkHttpOperation<?, ?> op) {
        Intrinsics.checkNotNullParameter(op, "op");
        Phase<OperationRequest<HttpRequestBuilder>, ?> phase = op.execution.mutate;
        Phase.Order order = Phase.Order.After;
        phase.getClass();
        Intrinsics.checkNotNullParameter(order, "order");
        phase.register(new ModifyRequestMiddleware(this), order);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // aws.smithy.kotlin.runtime.io.middleware.ModifyRequest
    public final Object modifyRequest(Object obj, ModifyRequestMiddleware$handle$1 modifyRequestMiddleware$handle$1) {
        String str;
        LinkedHashMap linkedHashMap;
        LinkedHashMap linkedHashMap2;
        OperationRequest operationRequest = (OperationRequest) obj;
        CustomUserAgentMetadata customUserAgentMetadata = (CustomUserAgentMetadata) operationRequest.context.getOrNull(CustomUserAgentMetadata.ContextKey);
        AwsUserAgentMetadata awsUserAgentMetadata = this.staticMetadata;
        if (customUserAgentMetadata != null) {
            CustomUserAgentMetadata customUserAgentMetadata2 = awsUserAgentMetadata.customMetadata;
            if (customUserAgentMetadata2 == null) {
                awsUserAgentMetadata = AwsUserAgentMetadata.copy$default(awsUserAgentMetadata, customUserAgentMetadata);
            } else {
                awsUserAgentMetadata = AwsUserAgentMetadata.copy$default(awsUserAgentMetadata, new CustomUserAgentMetadata(MapsKt__MapsKt.plus(customUserAgentMetadata2.extras, customUserAgentMetadata.extras), CollectionsKt___CollectionsKt.plus((Iterable) customUserAgentMetadata.typedExtras, (Collection) customUserAgentMetadata2.typedExtras)));
            }
        }
        HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) operationRequest.subject;
        HeadersBuilder headersBuilder = httpRequestBuilder.headers;
        awsUserAgentMetadata.getClass();
        ArrayList arrayList = new ArrayList();
        CustomUserAgentMetadata customUserAgentMetadata3 = awsUserAgentMetadata.customMetadata;
        if (customUserAgentMetadata3 != null && (linkedHashMap2 = customUserAgentMetadata3.extras) != null) {
            str = (String) linkedHashMap2.remove("internal");
        } else {
            str = null;
        }
        if (str != null) {
            arrayList.add("md/internal");
        }
        SdkMetadata sdkMetadata = awsUserAgentMetadata.sdkMetadata;
        arrayList.add(String.valueOf(sdkMetadata));
        arrayList.add(String.valueOf(awsUserAgentMetadata.osMetadata));
        arrayList.add(String.valueOf(awsUserAgentMetadata.languageMetadata));
        FrameworkMetadata frameworkMetadata = awsUserAgentMetadata.frameworkMetadata;
        if (frameworkMetadata != null) {
            arrayList.add(String.valueOf(frameworkMetadata));
        }
        if (customUserAgentMetadata3 != null && (linkedHashMap = customUserAgentMetadata3.extras) != null) {
            arrayList.add(CollectionsKt___CollectionsKt.joinToString$default(linkedHashMap.entrySet(), " ", null, null, new Function1<Map.Entry<? extends String, ? extends String>, CharSequence>() { // from class: aws.sdk.kotlin.runtime.http.AdditionalMetadata$toString$1
                @Override // kotlin.jvm.functions.Function1
                public final CharSequence invoke(Map.Entry<? extends String, ? extends String> entry) {
                    Map.Entry<? extends String, ? extends String> entry2 = entry;
                    Intrinsics.checkNotNullParameter(entry2, "entry");
                    String lowerCase = entry2.getValue().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                    if (Intrinsics.areEqual(lowerCase, "true")) {
                        return "md/" + entry2.getKey();
                    }
                    return "md/" + AwsUserAgentMetadataKt.access$encodeUaToken(entry2.getKey()) + '/' + AwsUserAgentMetadataKt.access$encodeUaToken(entry2.getValue());
                }
            }, 30));
        }
        headersBuilder.set(CollectionsKt___CollectionsKt.joinToString$default(arrayList, " ", null, null, null, 62), HttpHeader.USER_AGENT);
        httpRequestBuilder.headers.set(String.valueOf(sdkMetadata), "x-amz-user-agent");
        return operationRequest;
    }
}
