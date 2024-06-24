package aws.smithy.kotlin.runtime.awsprotocol;

import aws.smithy.kotlin.runtime.http.HttpBody;
import aws.smithy.kotlin.runtime.http.content.ByteArrayContent;
import aws.smithy.kotlin.runtime.http.response.HttpResponse;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResponseUtils.kt */
/* loaded from: classes.dex */
public final class ResponseUtilsKt {
    public static final HttpResponse withPayload(HttpResponse httpResponse, byte[] bArr) {
        HttpBody httpBody;
        Intrinsics.checkNotNullParameter(httpResponse, "<this>");
        if (bArr != null) {
            httpBody = new ByteArrayContent(bArr);
        } else {
            httpBody = HttpBody.Empty.INSTANCE;
        }
        return new HttpResponse(httpResponse.status, httpResponse.headers, httpBody);
    }
}
